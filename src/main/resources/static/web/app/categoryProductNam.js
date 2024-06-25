$.ajax({
    url: 'api-website-product',
    type: 'GET',
    success: function(response) {
        if (response && response.result) {
            var products = response.result;
            var productsHtml = '';

            products.forEach(function(product) {
                var productName = product.name;
                var productPrice = product.productVariants[0].price; // Giả sử giá cố định cho biến thể đầu tiên
                var thumbnailUrl = '/images/' + product.thumbnail; // Sử dụng đường dẫn tương đối từ thư mục tài nguyên tĩnh của ứng dụng Spring Boot
                var variantsHtml = '';

                // Container cho các nút màu
                var colorButtonsContainer = '<div class="color-buttons-container">';

                product.productVariants.forEach(function(variant) {
                    // Tạo nút button cho màu sắc
                    var colorButtonHtml = '<button type="button" style="background-color:' + variant.color + '; width: 20px; height: 20px; border: none; border-radius: 50%; margin-right: 5px;"></button>';

                    colorButtonsContainer += colorButtonHtml;
                });

                colorButtonsContainer += '</div>'; // Đóng container

                // Tạo mã HTML cho mỗi sản phẩm
                var productHtml = '<div class="col">' +
                    '<div class="card shadow-sm">' +
                    '<img src="' + thumbnailUrl + '" class="bd-placeholder-img card-img-top" width="100%" height="300">' +
                    '<div class="card-body">' +
                    '<h5 class="card-title">' + productName + '</h5>' +
                    '<h5 class="card-title">' + productPrice + '</h5>' +
                    colorButtonsContainer + // Thêm container chứa các nút màu
                    '<div class="d-flex justify-content-between align-items-center">' +
                    '<div class="btn-group">' +
                    '<button type="button" class="btn btn-sm btn-outline-secondary">Thích</button>' +
                    '<button type="button" class="btn btn-sm btn-outline-secondary">Giỏ hàng</button>' +
                    '</div>' +
                    '<small class="text-muted">9 mins</small>' +
                    '</div>' +
                    '</div>' +
                    '</div>' +
                    '</div>';

                productsHtml += productHtml;
            });

            // Thêm các sản phẩm vào phần tử có id là 'product-container' (hoặc thay thế id tương ứng trong giao diện của bạn)
            $('#productNam-container').html(productsHtml);
        }
    }
});
