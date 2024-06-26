$(document).ready(function () {
    $.ajax({
        url: 'api-web-category',
        type: 'GET',
        success: function (response) {
            var menuContainer = $('#menuContainer');

            function buildMenu(categories) {
                var html = '';
                categories.forEach(function (category) {
                    if (category.subCategories && category.subCategories.length > 0) {
                        html += '<li class="dropdown-submenu">' +
                            '<a class="dropdown-item dropdown-toggle" href="#">' +
                            category.name +
                            '</a>' +
                            '<ul class="dropdown-menu">';
                        html += buildMenu(category.subCategories);
                        html += '</ul></li>';
                    } else {
                        html += '<li>' +
                            '<a class="dropdown-item dropdown-leaf" href="#" data-id="' + category.id + '" data-name="' + category.name + '">' +
                            category.name +
                            '</a>' +
                            '</li>';
                    }
                });
                return html;
            }

            response.result.forEach(function (category) {
                var categoryHtml =
                    '<li class="nav-item dropdown">' +
                    '<a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">' +
                    category.name +
                    '</a>' +
                    '<ul class="dropdown-menu">';
                categoryHtml += buildMenu(category.subCategories);
                categoryHtml += '</ul></li>';
                menuContainer.append(categoryHtml);
            });

            $('.dropdown-submenu .dropdown-toggle').on("click", function (e) {
                e.stopPropagation();
                e.preventDefault();
                $(this).parents('.dropdown-menu').find('.dropdown-menu').not($(this).next('.dropdown-menu')).hide();
                $(this).next('.dropdown-menu').toggle();
            });

            $('.dropdown-leaf').on("click", function (e) {
                e.preventDefault();
                var categoryId = $(this).data('id');
                console.log('with ID:', categoryId);

                // Chuyển hướng tới trang /product-by-category với categoryName là tham số
                window.location.href = '/product-by-category?category=' + encodeURIComponent(categoryId);
            });

        }
    });
});
