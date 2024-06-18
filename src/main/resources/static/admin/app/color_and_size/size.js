load_DataSize();

var allowEditSize = false; // Biến để kiểm soát cho phép sửa

function load_DataSize(){
    $.ajax({
        url: 'api-admin-size',
        type: 'GET',
        success: function(rs2) {
            var str2 = "";
            $.each(rs2.result, function(i, itemSize) {
                str2 += "<tr>";
                str2 += "<td>" + (i + 1) + "</td>";
                str2 += "<td contenteditable='" + allowEditSize + "' class='editable' data-field='namesize'>" + itemSize.name + "</td>";
                str2 += "<td style='text-align: center'>";
                if (allowEditSize) {
                    str2 += "<button onclick='updateSize(this)' class='btn btn-info' style='margin-right: 10px;' data-id='" + itemSize.id + "'>sửa</button>";
                }
                str2 += "<button onclick='deleteSize(this)' data-id='" + itemSize.id + "' class='btn btn-danger'>xóa</button>";
                str2 += "</td>";
                str2 += "</tr>";
            });
            $('#load_data_size').html(str2);
        }
    });
}
// Xử lý sự kiện khi nhấn nút bật/tắt sửa
$('#toggleEditSize').click(function() {
    allowEditSize = !allowEditSize; // Đảo ngược giá trị của biến allowEditSize
    load_DataSize(); // Load lại dữ liệu để áp dụng trạng thái mới
});

function createSize(){
    var name = $('#nameSize').val();

    $.ajax({
        url: 'api-admin-size',
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify({name: name}),
        dataType: 'json',
        success: function (result) {
            load_DataSize();
        },
        error: function (error) {
            console.log(error)
        }
    });
}

function updateSize(button) {
    var id = $(button).data('id');
    var row = $(button).closest('tr'); // Tìm dòng (row) chứa nút sửa
    var name = row.find('[data-field="namesize"]').text(); // Lấy giá trị của ô có data-field="name"
    $.ajax({
        url: 'api-admin-size/'+id,
        type: 'PUT',
        contentType: 'application/json',
        data: JSON.stringify({id: id,name: name}),
        dataType: 'json',
        success: function (result) {
            load_DataSize();
        },
        error: function (error) {
            console.log(error)
        }
    });
}

function deleteSize(button){
    var id = $(button).data('id');
    $.ajax({
        url: 'api-admin-size',
        type: 'DELETE',
        contentType: 'application/json',
        data: JSON.stringify({ ids: [id] }), // Gửi một mảng ids chứa một phần tử id
        dataType: 'json',
        success: function (result) {
            load_DataSize();
        },
        error: function (error) {
            console.log(error)
        }
    });
}


