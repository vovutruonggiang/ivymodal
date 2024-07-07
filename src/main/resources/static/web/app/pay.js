$.ajax({
    url: 'api-web-pay/11357a38-2ae6-4011-b50f-eea72b48256b',
    type: 'GET',
    datatype: 'json',
    success: function(data) {
        if (data && data.result && data.result.length > 0) {
            data.result.forEach(function(product, index) {
                var productHTML = `
                    <div class="row product-item" style="margin-bottom: 20px;">
                        <div class="col-md-2">
                            <input type="checkbox">
                            <img style="width: 100px;height: 150px" src="/images/${product.product.thumbnail}" class="img-fluid" alt="Product Image">
                        </div>
                        <div class="col-md-3">
                            <h5 class="card-title">${product.product.name}</h5>
                            <p class="card-text">
                                Màu: <span class="color-circle" style="background-color: ${product.productVariant.color.color_coding};"></span> ${product.productVariant.color.name}
                            </p>
                            <p class="card-text">
                                Kích thước: ${product.productVariant.size.name}
                            </p>
                        </div>
                        <div class="col-md-2">
                            <div class="price-container">
                                <span>${product.productVariant.price}đ</span>
                            </div>
                        </div>
                        <div class="col-md-2">
                            <div class="input-group quantity-input">
                                <span class="input-group-text button-decrease">-</span>
                                <input type="text" class="form-control quantity" value="${product.quantity}" min="1" max="${product.productVariant.stock}">
                                <span class="input-group-text button-increase">+</span>
                            </div>
                        </div>
                        <div class="col-md-2">
                            <div class="price-container">
                                <span class="total-price">${product.productVariant.price * product.quantity}đ</span>
                            </div>
                        </div>
                        <div class="col-md-1">
                            <div class="btnDelete">
                                <button class="btn btn-danger">Xóa</button>
                            </div>
                        </div>
                    </div>`;

                // Thêm sản phẩm vào cuối .card-body của sản phẩm cuối cùng
                if (index === 0) {
                    $('.card-body:last').html(productHTML); // Thêm HTML đầu tiên
                } else {
                    $('.card-body:last').append(productHTML); // Thêm các HTML tiếp theo
                }
            });

            // Event listeners for dynamically added elements
            $(document).on('click', '.button-decrease', function () {
                var quantityInput = $(this).siblings('.quantity');
                var quantity = parseInt(quantityInput.val());
                if (quantity > 1) {
                    quantityInput.val(quantity - 1);
                }
                updateTotalPrice(quantityInput);
            });

            $(document).on('click', '.button-increase', function () {
                var quantityInput = $(this).siblings('.quantity');
                var quantity = parseInt(quantityInput.val());
                var maxStock = parseInt(quantityInput.attr('max')); // Lấy giá trị max từ thuộc tính max của input

                if (quantity < maxStock) { // Chỉ tăng số lượng nếu chưa đạt tối đa tồn kho
                    quantityInput.val(quantity + 1);
                    updateTotalPrice(quantityInput);
                } else {
                    alert(`Số lượng sản phẩm chỉ còn ${maxStock}`);
                }
            });

            function updateTotalPrice(quantityInput) {
                var price = parseFloat(quantityInput.closest('.row').find('.price-container span').first().text());
                var quantity = parseInt(quantityInput.val());
                var totalPrice = price * quantity;
                quantityInput.closest('.row').find('.total-price').text(totalPrice + 'đ');
            }
        }
    }
});
