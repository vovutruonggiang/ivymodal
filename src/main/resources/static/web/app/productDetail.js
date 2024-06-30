$(document).ready(function() {
    const urlParams = new URLSearchParams(window.location.search);
    const productId = urlParams.get('id');

    // Lấy các phần tử DOM cần thao tác
    const thumbnailImage = document.getElementById('thumbnail');
    const colorsContainer = $('.color-buttons-container');
    const sizesContainer = $('.sizes-container');
    const previewContainer = $('.preview-container');
    const variantIdInput = $('#idProductVariant');
    const quantityInput = $('#quantity');
    const soluongInput = $('#soluong');
    const stockCountSpan = $('#stockCount');

    // Hàm để lấy và hiển thị thông tin chi tiết sản phẩm
    function fetchProductDetail(productId) {
        $.ajax({
            url: 'api-website-product/detail/' + productId,
            type: 'GET',
            success: function(response) {
                console.log(response);

                const product = response.result;

                // Đổ thông tin sản phẩm vào các phần tử HTML
                $('#sp_ten').text(product.name);
                $('#sp_gia').text(formatCurrency(product.productVariants[0].size[0].price));
                $('.product-title').text(product.name);
                $('.product-description').text(product.description);
                $('.price span').text(formatCurrency(product.productVariants[0].size[0].price));

                // Load hình ảnh thumbnail chung của sản phẩm
                thumbnailImage.src = '/images/' + product.thumbnail;

                // Hiển thị hình ảnh mặc định của từng biến thể
                product.productVariants.forEach((variant, index) => {
                    const previewImage = $('<img>').addClass('preview-image').attr('src', '/images/' + variant.image_url);
                    previewContainer.append(previewImage);

                    // Đổ các màu sắc sản phẩm vào các nút radio và label
                    const color = variant.color;
                    colorsContainer.append(`
                        <input type="radio" class="color-button" id="color${index}" name="color" value="${color}">
                        <label for="color${index}" style="background-color: ${color};"></label>
                    `);
                });

                // Xử lý sự kiện khi người dùng chọn màu sắc
                $('.color-button').change(function() {
                    const selectedColor = $(this).val();
                    console.log('Mã màu:', selectedColor);

                    // Đánh dấu màu được chọn bằng cách thêm/loại bỏ lớp active
                    $('.color-button + label').removeClass('active');
                    $(`label[for="${$(this).attr('id')}"]`).addClass('active');

                    // Tìm và cập nhật hình ảnh thumbnail từ biến thể sản phẩm đã chọn
                    const selectedVariant = product.productVariants.find(variant => variant.color === selectedColor);
                    if (selectedVariant) {
                        thumbnailImage.src = '/images/' + selectedVariant.image_url;

                        // Cập nhật kích thước tương ứng
                        sizesContainer.empty(); // Làm trống phần tử chứa kích thước trước khi thêm mới
                        selectedVariant.size.forEach((size, sizeIndex) => {
                            sizesContainer.append(`
                                <input type="radio" class="size-button" id="size${sizeIndex}" name="size" value="${size.size}" data-variant-id="${size.variantId}" data-price="${size.price}" data-status="${size.status}" data-stock="${size.stock}">
                                <label for="size${sizeIndex}">${size.size}</label>
                            `);
                        });

                        // Cập nhật giá, trạng thái và số lượng tồn kho khi chọn kích thước
                        $('.size-button').change(function() {
                            const selectedSize = $(this).val();
                            const sizeInfo = selectedVariant.size.find(s => s.size === selectedSize);
                            if (sizeInfo) {
                                $('#sp_gia').text(formatCurrency(sizeInfo.price));
                                variantIdInput.val(sizeInfo.variantId); // Đặt mã biến thể vào input
                                updateStockCount(sizeInfo.stock); // Cập nhật số lượng tồn kho
                            }
                        });

                        // Kích hoạt kích thước đầu tiên và hiển thị giá tương ứng
                        if (selectedVariant.size.length > 0) {
                            $(`#size0`).prop('checked', true).change();
                        }
                    }
                });

                // Xử lý sự kiện khi người dùng nhấn vào hình nhỏ để thay đổi thumbnail
                previewContainer.on('click', '.preview-image', function() {
                    const newSrc = $(this).attr('src');
                    thumbnailImage.src = newSrc;
                });

                // Cập nhật số lượng tồn kho ban đầu
                updateStockCount(product.productVariants[0].size[0].stock);

                // Kích hoạt màu sắc đầu tiên và hiển thị kích cỡ tương ứng
                if (product.productVariants.length > 0) {
                    $(`#color0`).prop('checked', true).change();
                }
            },
            error: function(error) {
                console.error('Error fetching product detail:', error);
            }
        });
    }

    // Hàm format số tiền sang định dạng tiền tệ
    function formatCurrency(amount) {
        return new Intl.NumberFormat('vi-VN', { style: 'currency', currency: 'VND' }).format(amount);
    }

    // Hàm cập nhật số lượng tồn kho
    function updateStockCount(stock) {
        stockCountSpan.text(stock);
        soluongInput.prop('max', stock); // Cập nhật số lượng mua tối đa là số lượng tồn kho

        if (stock === 0) {
            soluongInput.prop('disabled', true); // Khóa ô chọn số lượng khi số lượng tồn kho là 0
        } else {
            soluongInput.prop('disabled', false);
        }

        // Mặc định chọn số lượng là 1 nếu số lượng tồn kho > 0
        const defaultQuantity = stock > 0 ? 1 : 0;
        soluongInput.val(defaultQuantity);
        quantityInput.val(defaultQuantity);
    }

    // Gọi hàm fetchProductDetail khi trang được tải
    fetchProductDetail(productId);

    // Xử lý sự kiện khi người dùng thay đổi số lượng mua
    soluongInput.on('input', function() {
        let quantity = $(this).val();
        quantity = Math.min(quantity, stockCountSpan.data('stock')); // Chỉ cho phép nhập tối đa là số lượng tồn kho
        quantity = Math.max(quantity, 1); // Mặc định chọn số lượng là 1 và không giảm dưới mức này
        quantityInput.val(quantity);
    });
});


// Lấy query parameters từ URL hiện tại
const urlParams = new URLSearchParams(window.location.search);

// Lấy giá trị của tham số 'id' từ query parameters
const idProduct = urlParams.get('id');

function createCart() {
    var idProductVariant = $('#idProductVariant').val();
    var idUser = $('#id_user').val();
    var quantity = $('#soluong').val();

    // Kiểm tra nếu số lượng mua là 0 thì hiển thị thông báo và không thực hiện AJAX request
    if (quantity === '0') {
        alert("Sản phẩm đã hết hàng");
        return;
    }

    $.ajax({
        url: 'api-web-cart',
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify({
            idProduct: idProduct,
            idUser: idUser,
            idProductVariant: idProductVariant,
            quantity: quantity
        }),
        dataType: 'json',
        success: function (result) {
            alert("Thêm giỏ hàng thành công");
        },
        error: function (error) {
            alert("Thêm giỏ hàng thất bại");
        }
    });
}
