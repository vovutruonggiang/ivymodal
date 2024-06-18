// Define an empty categories object to store fetched data
var categories = {};

// Function to fetch data from API and update categories
function fetchDataAndUpdateCategories() {
    $.ajax({
        url: 'api-admin-category/structured', // Replace with your actual API endpoint
        type: 'GET',
        dataType: 'json',
        success: function(data) {
            // Update categories object with fetched data
            categories = data;
            console.log('Dữ liệu đã được cập nhật:', categories);
            populateCategory1(); // Call the function to populate category1 dropdown
        },
        error: function(xhr, status, error) {
            console.error('Lỗi khi gọi API:', error);
        }
    });
}

// Function to populate category1 dropdown
function populateCategory1() {
    var category1Dropdown = document.getElementById("category1");
    category1Dropdown.innerHTML = '<option value="">Chọn danh mục cấp 1</option>';

    // Loop through categories object and populate options for category1 dropdown
    for (var key in categories) {
        if (categories.hasOwnProperty(key)) {
            var option = document.createElement("option");
            option.value = key;
            option.textContent = key.charAt(0).toUpperCase() + key.slice(1);
            category1Dropdown.appendChild(option);
        }
    }
}

// Function to populate category2 dropdown based on category1 selection
function loadCategory2() {
    var category1 = document.getElementById("category1").value;
    var category2Dropdown = document.getElementById("category2");
    var category2Group = document.getElementById("category2-group");

    category2Dropdown.innerHTML = '<option value="">Chọn danh mục cấp 2</option>';

    if (category1 !== "") {
        var category2Options = categories[category1];
        for (var key in category2Options) {
            var option = document.createElement("option");
            option.value = key;
            option.textContent = key.charAt(0).toUpperCase() + key.slice(1);
            category2Dropdown.appendChild(option);
        }
        category2Group.style.display = "block";
    } else {
        category2Group.style.display = "none";
    }

    document.getElementById("category3-group").style.display = "none";
}

// Function to populate category3 dropdown based on category2 selection
function loadCategory3() {
    var category1 = document.getElementById("category1").value;
    var category2 = document.getElementById("category2").value;
    var category3Dropdown = document.getElementById("category3");
    var category3Group = document.getElementById("category3-group");

    category3Dropdown.innerHTML = '<option value="">Chọn danh mục cấp 3</option>';

    if (category1 !== "" && category2 !== "") {
        var category3Options = categories[category1][category2];
        category3Options.forEach(function (option) {
            var optionElem = document.createElement("option");
            optionElem.value = option.id; // Use id of the item
            optionElem.textContent = option.name; // Use name of the item
            category3Dropdown.appendChild(optionElem);
        });
        category3Group.style.display = "block";
    } else {
        category3Group.style.display = "none";
    }
}

// Function to set value of #idCategory input when #category3 changes
document.getElementById("category3").addEventListener("change", function() {
    var selectedId = this.value;
    document.getElementById("idCategory").value = selectedId;
});
// Call the function to fetch data and populate categories on page load
fetchDataAndUpdateCategories();



