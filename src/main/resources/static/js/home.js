$.ajax({
    url: 'api-admin-product',
    type: 'GET',
    success: function(response) {
        // if (response && response.result) {
        //     var products = response.result;
        //     var productsHtml = '';
        //
        //     products.forEach(function(product) {
        //         var productName = product.productVariants[0].color.name;
        //         var productPrice = product.productVariants[0].price; // Giả sử giá cố định cho biến thể đầu tiên
        //         var thumbnailUrl = '/images/' + product.thumbnail; // Sử dụng đường dẫn tương đối từ thư mục tài nguyên tĩnh của ứng dụng Spring Boot
        //
        //         // Tạo mã HTML cho mỗi sản phẩm
        //         var productHtml = '<div class="col">' +
        //             '<div class="card shadow-sm">' +
        //             '<img src="' + thumbnailUrl + '" class="bd-placeholder-img card-img-top" width="100%" height="300">' +
        //             '<div class="card-body">' +
        //             '<p class="card-text">' + productName + '</p>' +
        //             '<p class="card-text">' + productPrice + '</p>' +
        //             '<div class="d-flex justify-content-between align-items-center">' +
        //             '<div class="btn-group">' +
        //             '<button type="button" class="btn btn-sm btn-outline-secondary">Thích</button>' +
        //             '<button type="button" class="btn btn-sm btn-outline-secondary">Giỏ hàng</button>' +
        //             '</div>' +
        //             '<small class="text-muted">9 mins</small>' +
        //             '</div>' +
        //             '</div>' +
        //             '</div>' +
        //             '</div>';
        //
        //         productsHtml += productHtml;
        //     });
        //
        //     // Thêm các sản phẩm vào phần tử có id là 'product-container' (hoặc thay thế id tương ứng trong giao diện của bạn)
        //     $('#product-container').html(productsHtml);
        // }
        if (response && response.result) {
            var products = response.result;
            var productsHtml = '';

            products.forEach(function(product) {
                var productNameHtml = '';
                var productPriceHtml = '';
                var thumbnailUrl = '/images/' + product.thumbnail; // Sử dụng đường dẫn tương đối từ thư mục tài nguyên tĩnh của ứng dụng Spring Boot

                // Tạo Set để lưu trữ các kích thước duy nhất
                var uniqueSizes = new Set();

                // Lặp qua tất cả các biến thể của sản phẩm
                product.productVariants.forEach(function(variant) {
                    var variantName = variant.color.name;
                    var variantPrice = variant.price;
                    var variantSize = variant.size.name;

                    // Thêm tên màu vào productNameHtml
                    productNameHtml += '<p class="card-text">Color: ' + variantName + ', Price: ' + variantPrice + '</p>';

                    // Thêm kích thước vào Set
                    uniqueSizes.add(variantSize);
                });

                // Tạo HTML cho các kích thước duy nhất
                uniqueSizes.forEach(function(size) {
                    productPriceHtml += '<p class="card-text">Size: ' + size + '</p>';
                });

                // Tạo mã HTML cho mỗi sản phẩm
                var productHtml = '<div class="col">' +
                    '<div class="card shadow-sm">' +
                    '<img src="' + thumbnailUrl + '" class="bd-placeholder-img card-img-top" width="100%" height="300">' +
                    '<div class="card-body">' +
                    productNameHtml + // Thêm tất cả các tên biến thể và giá
                    productPriceHtml + // Thêm tất cả các kích thước duy nhất
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
            $('#product-container').html(productsHtml);
        }


    }
});