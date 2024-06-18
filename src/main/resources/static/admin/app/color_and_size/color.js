load_DataColor();

var allowEditColor = false; // Biến để kiểm soát cho phép sửa

function load_DataColor(){
    $.ajax({
        url: 'api-admin-color',
        type: 'GET',
        success: function(rs) {
            var str = "";
            $.each(rs.result, function(i, item) {
                str += "<tr>";
                str += "<td>" + (i + 1) + "</td>";
                str += "<td contenteditable='" + allowEditColor + "' class='editable' data-field='name'>" + item.name + "</td>";
                str += "<td contenteditable='" + allowEditColor + "' class='editable' data-field='color_coding'>" + item.color_coding + "</td>";
                str += "<td style='text-align: center'>";
                if (allowEditColor) {
                    str += "<button onclick='updateColor(this)' class='btn btn-info' style='margin-right: 10px;' data-id='" + item.id + "'>sửa</button>";
                }
                str += "<button onclick='deleteColor(this)' data-id='" + item.id + "' class='btn btn-danger'>xóa</button>";
                str += "</td>";
                str += "</tr>";
            });
            $('#load_data_color').html(str);
        }
    });
}

// Xử lý sự kiện khi nhấn nút bật/tắt sửa
$('#toggleEditColor').click(function() {
    allowEditColor = !allowEditColor; // Đảo ngược giá trị của biến allowEditColor
    load_DataColor(); // Load lại dữ liệu để áp dụng trạng thái mới
});


function createColor(){
    var name = $('#nameColor').val();
    var color_coding = $('#colorCoding').val();

    $.ajax({
        url: 'api-admin-color',
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify({name: name, color_coding : color_coding}),
        dataType: 'json',
        success: function (result) {
            load_DataColor();
        },
        error: function (error) {
            console.log(error)
        }
    });
}

function updateColor(button) {
    var id = $(button).data('id');
    var row = $(button).closest('tr'); // Tìm dòng (row) chứa nút sửa
    var name = row.find('[data-field="name"]').text(); // Lấy giá trị của ô có data-field="name"
    var color = row.find('[data-field="color_coding"]').text(); // Lấy giá trị của ô có data-field="color_coding"

    $.ajax({
        url: 'api-admin-color/'+id,
        type: 'PUT',
        contentType: 'application/json',
        data: JSON.stringify({id: id,name: name, color_coding : color}),
        dataType: 'json',
        success: function (result) {
            load_DataColor();
        },
        error: function (error) {
            console.log(error)
        }
    });
}

function deleteColor(button){
    var id = $(button).data('id');
    $.ajax({
        url: 'api-admin-color',
        type: 'DELETE',
        contentType: 'application/json',
        data: JSON.stringify({ ids: [id] }), // Gửi một mảng ids chứa một phần tử id
        dataType: 'json',
        success: function (result) {
            load_DataColor();
        },
        error: function (error) {
            console.log(error)
        }
    });
}


