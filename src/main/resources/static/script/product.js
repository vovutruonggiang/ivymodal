// Hàm để thêm một biến thể sản phẩm mới
function addVariant() {
    var variantCount = document.querySelectorAll(".variant").length + 1;

    var variantDiv = document.createElement("div");
    variantDiv.className = "variant col-md-12";
    variantDiv.setAttribute('data-variant-id', variantCount); // Add a unique identifier for each variant

    variantDiv.innerHTML = `
        <div style="margin-bottom: 30px">
            <div class="col-md-2" style="margin-top: 20px">
                <div class="form-group">
                    <label class="control-label" for="price${variantCount}">Giá:</label>
                    <input type="text" class="form-control" id="price${variantCount}" name="price[]">
                </div>
            </div>
            <div class="col-md-2" style="margin-top: 20px">
                <div class="form-group">
                    <label class="control-label" for="stock${variantCount}">Số lượng</label>
                    <input type="text" class="form-control" id="stock${variantCount}" name="stock[]">
                </div>
            </div>
            <div class="col-md-2" style="margin-top: 20px">
                <div class="form-group">
                    <label class="control-label" for="color${variantCount}">Màu sắc:</label>
                    <select id="color${variantCount}" class="form-control" name="color[]">
                        <!-- Đây là nơi để load danh sách màu sắc từ backend -->
                    </select>
                </div>
            </div>
            <div class="col-md-2" style="margin-top: 20px">
                <div class="form-group">
                    <label class="control-label" for="size${variantCount}">Kích thước:</label>
                    <select id="size${variantCount}" class="form-control" name="size[]">
                        <!-- Đổ danh sách các kích thước từ database -->
                    </select>
                </div>
            </div>
            <div class="col-md-2" id="image-section-${variantCount}">
                <!-- Image upload section will be added here dynamically -->
            </div>
            <div class="col-md-2" style="margin-top: 45px;">
                <button type="button" class="btn btn-danger" onclick="removeVariant(this)">Xóa biến thể</button>
            </div>
        </div>
    `;

    document.getElementById("variants").appendChild(variantDiv);

    loadColors(variantCount);
    loadSizes(variantCount);
}


function loadColors(variantCount) {
    $.ajax({
        url: 'api-admin-color',
        type: 'GET',
        dataType: 'json',
        success: function (data) {
            var colors = data.result;
            $(`#color${variantCount}`).empty();
            colors.forEach(function (color) {
                $(`#color${variantCount}`).append($('<option>', {
                    value: color.id,
                    text: color.name,
                }));
            });
            $(`#color${variantCount}`).val(colors[0].id);
        },
        error: function (xhr, status, error) {
            console.error('Error fetching colors:', error);
        }
    });
}

function loadSizes(variantCount) {
    $.ajax({
        url: 'api-admin-size',
        type: 'GET',
        dataType: 'json',
        success: function (data) {
            var sizes = data.result;
            $(`#size${variantCount}`).empty();
            sizes.forEach(function (size) {
                $(`#size${variantCount}`).append($('<option>', {
                    value: size.id,
                    text: size.name,
                }));
            });
            $(`#size${variantCount}`).val(sizes[0].id);
        },
        error: function (xhr, status, error) {
            console.error('Error fetching sizes:', error);
        }
    });
}

function removeVariant(button) {
    var variantDiv = button.closest('.variant');
    var variantId = variantDiv.getAttribute('data-variant-id');

    // Remove variant image section
    var imageSection = document.getElementById(`image-section-${variantId}`);
    imageSection.innerHTML = ''; // Clear image section content

    variantDiv.parentNode.removeChild(variantDiv);

    // After removing the variant, recreate images for remaining variants
    createImagesForVariants();
}

function createImagesForVariants() {
    var variantColors = {}; // Object to track unique color combinations
    var imagesContainer = document.getElementById("variant-images");
    imagesContainer.innerHTML = ''; // Clear previous content

    $('.variant').each(function (index, element) {
        var colorId = $(element).find('[id^=color]').val();
        var colorName = $(element).find('[id^=color] option:selected').text();
        var variantCount = index + 1;

        if (!variantColors[colorId]) {
            variantColors[colorId] = true;

            // Create file input element for this color combination
            var colDiv = document.createElement('div');
            colDiv.className = 'col-md-2';

            var fileInputGroup = document.createElement('div');
            fileInputGroup.className = 'form-group';

            var labelElement = document.createElement('label');
            labelElement.setAttribute('for', `input_file${variantCount}`);
            labelElement.id = 'drop-area';

            var imgViewDiv = document.createElement('div');
            imgViewDiv.className = 'img_view';
            imgViewDiv.id = `img_view_${variantCount}`;

            var plusP = document.createElement('p');
            plusP.className = 'img-placeholder'; // Add a class for styling
            plusP.style.cursor = 'pointer';
            plusP.innerHTML = `
                <span style="font-size: 50px; color: #bbb5ff;">+</span>
                <br>
                <span>${colorName}</span>
            `;

            imgViewDiv.appendChild(plusP);
            labelElement.appendChild(imgViewDiv);

            var inputFile = document.createElement('input');
            inputFile.type = 'file';
            inputFile.id = `input_file${variantCount}`;
            inputFile.className = 'form-control-file';
            inputFile.style.display = 'none';

            fileInputGroup.appendChild(labelElement);
            fileInputGroup.appendChild(inputFile);
            colDiv.appendChild(fileInputGroup);

            imagesContainer.appendChild(colDiv);

            // Attach event listener to show file input on click
            imgViewDiv.addEventListener('click', function (event) {
                event.preventDefault();
                inputFile.click();
            });

            // Attach event listener to handle file selection
            inputFile.addEventListener('change', function (event) {
                const file = event.target.files[0];
                const imgView = document.getElementById(`img_view_${variantCount}`);
                const imgUrlInput = document.getElementById(`imgUrl_${variantCount}`);
                const idColorInput = document.getElementById(`idColorImages_${variantCount}`);

                if (file) {
                    const img = document.createElement('img');
                    img.style.maxWidth = '100%';
                    img.style.maxHeight = '100%';
                    img.style.borderRadius = '5px';

                    imgView.innerHTML = '';
                    imgView.appendChild(img);

                    const reader = new FileReader();
                    reader.onload = function (e) {
                        img.src = e.target.result;
                        imgUrlInput.value = file.name; // Set filename to input value
                    };
                    reader.readAsDataURL(file);

                    // Log idColor and idUrl to console
                    console.log(`idColor: ${idColorInput.value}, idUrl: ${file.name}`);
                }
            });
        }
    });
}

// Global array to store image data
var variantImages = [];

function createImagesForVariants() {
    var variantColors = {}; // Object to track unique color combinations
    var imagesContainer = document.getElementById("variant-images");
    imagesContainer.innerHTML = ''; // Clear previous content

    $('.variant').each(function (index, element) {
        var colorId = $(element).find('[id^=color]').val();
        var colorName = $(element).find('[id^=color] option:selected').text();
        var variantCount = index + 1;

        if (!variantColors[colorId]) {
            variantColors[colorId] = true;

            // Create file input element for this color combination
            var colDiv = document.createElement('div');
            colDiv.className = 'col-md-2';

            var fileInputGroup = document.createElement('div');
            fileInputGroup.className = 'form-group';

            var labelElement = document.createElement('label');
            labelElement.setAttribute('for', `input_file${variantCount}`);
            labelElement.id = 'drop-area';

            var imgViewDiv = document.createElement('div');
            imgViewDiv.className = 'img_view';
            imgViewDiv.id = `img_view_${variantCount}`;

            var plusP = document.createElement('p');
            plusP.className = 'img-placeholder'; // Add a class for styling
            plusP.style.cursor = 'pointer';
            plusP.innerHTML = `
                <span style="font-size: 50px; color: #bbb5ff;">+</span>
                <br>
                <span>${colorName}</span>
            `;

            imgViewDiv.appendChild(plusP);
            labelElement.appendChild(imgViewDiv);

            var inputFile = document.createElement('input');
            inputFile.type = 'file';
            inputFile.id = `input_file${variantCount}`;
            inputFile.className = 'form-control-file';
            inputFile.style.display = 'none';

            fileInputGroup.appendChild(labelElement);
            fileInputGroup.appendChild(inputFile);
            colDiv.appendChild(fileInputGroup);

            imagesContainer.appendChild(colDiv);

            // Attach event listener to show file input on click
            imgViewDiv.addEventListener('click', function (event) {
                event.preventDefault();
                inputFile.click();
            });

            // Attach event listener to handle file selection
            inputFile.addEventListener('change', function (event) {
                const file = event.target.files[0];
                const imgView = document.getElementById(`img_view_${variantCount}`);

                if (file) {
                    const img = document.createElement('img');
                    img.style.maxWidth = '100%';
                    img.style.maxHeight = '100%';
                    img.style.borderRadius = '5px';

                    imgView.innerHTML = '';
                    imgView.appendChild(img);

                    const reader = new FileReader();
                    reader.onload = function (e) {
                        img.src = e.target.result;

                        // Store image data in global array
                        variantImages.push({
                            color: { id: colorId },
                            image_url: file.name
                        });

                        // Log idColor and idUrl to console
                        console.log(`idColor: ${colorId}, idUrl: ${file.name}`);
                    };
                    reader.readAsDataURL(file);
                }
            });
        }
    });
}
function createProduct() {
    var idCategory = $('#idCategory').val();
    var nameProduct = $('#name').val();
    var description = $('#description').val();
    var avatarProduct = $('#file-input').val();
    var avatarProduct1 = avatarProduct.split('\\').pop().split('/').pop(); // Lấy tên của avatar sản phẩm
    var variants = [];
    var images = [];

    $('.variant').each(function (index, element) {
        var price = $(element).find('[id^=price]').val();
        var stock = $(element).find('[id^=stock]').val();
        var color = $(element).find('[id^=color]').val();
        var size = $(element).find('[id^=size]').val();

        var variant = {
            price: parseFloat(price),
            stock: parseInt(stock, 10),
            color: { id: color },
            size: { id: size },
            status: true
        };

        variants.push(variant);
    });

    // Populate images array with variantImages data
    variantImages.forEach(function (imageData) {
        var image = {
            color: { id: imageData.color.id },
            image_url: imageData.image_url
        };
        images.push(image);
    });

    var requestData = {
        name: nameProduct,
        description: description,
        thumbnail: avatarProduct1,
        category: { id: idCategory },
        productVariants: variants,
        productImages: images
    };

    console.log(JSON.stringify(requestData));

    $.ajax({
        url: 'api-admin-product',
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(requestData),
        dataType: 'json',
        success: function (result) {
            console.log('Product created successfully:', result);
        },
        error: function (error) {
            console.error('Error creating product:', error);
        }
    });
}




