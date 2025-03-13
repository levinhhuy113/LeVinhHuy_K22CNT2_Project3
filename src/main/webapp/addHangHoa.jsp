<%@ page import="dao.HangHoaDAO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Thêm Hàng Hóa</title>
    <link rel="stylesheet" href="assets/css/style.css"> <!-- Tạo tệp CSS nếu cần -->
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .form-container {
            background-color: #fff;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
            width: 100%;
            max-width: 500px;
            text-align: center;
        }

        h2 {
            text-align: center;
            color: #333;
        }

        label {
            font-size: 14px;
            color: #333;
            margin-bottom: 5px;
            display: block;
        }

        input[type="text"], input[type="number"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ddd;
            border-radius: 5px;
            font-size: 16px;
        }

        button[type="submit"] {
            width: 100%;
            padding: 12px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 5px;
            font-size: 16px;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        button[type="submit"]:hover {
            background-color: #45a049;
        }

        .btn-back {
            display: block;
            width: 100%;
            padding: 12px;
            margin-top: 10px;
            background-color: #f44336;
            color: white;
            text-align: center;
            text-decoration: none;
            border-radius: 5px;
            font-size: 16px;
            transition: background-color 0.3s;
        }

        .btn-back:hover {
            background-color: #c62828;
        }

        .form-group {
            margin-bottom: 15px;
            text-align: left;
        }
    </style>
</head>
<body>
    <div class="form-container">
        <h2>Thêm Hàng Hóa</h2>
       <form action="addHangHoa" method="post" enctype="multipart/form-data">
    <div class="form-group">
        <label for="tenHang">Tên hàng:</label>
        <input type="text" name="tenHang" required>
    </div>
    <div class="form-group">
        <label for="loaiHang">Loại hàng:</label>
        <input type="text" name="loaiHang" required>
    </div>
    <div class="form-group">
        <label for="donViTinh">Đơn vị tính:</label>
        <input type="text" name="donViTinh" required>
    </div>
    <div class="form-group">
        <label for="soLuongTon">Số lượng tồn:</label>
        <input type="number" name="soLuongTon" required>
    </div>
    <div class="form-group">
        <label for="maNCC">Mã nhà cung cấp:</label>
        <input type="number" name="maNCC" required>
    </div>
    <div class="form-group">
        <label for="hinhAnh">Hình ảnh:</label>
        <input type="file" name="hinhAnh" accept="image/*" required>
    </div>
    <button type="submit">Thêm hàng hóa</button>
</form>


        <a href="hanghoa" class="btn-back">Quay về</a>
    </div>
</body>
</html>
