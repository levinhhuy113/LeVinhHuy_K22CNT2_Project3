<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.NhaCungCap, dao.NhaCungCapDAO" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Thêm Nhà Cung Cấp</title>
    <link rel="stylesheet" href="assets/css/style.css">
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
        fieldset {
            border: none;
            padding: 0;
        }
        legend {
            font-size: 18px;
            font-weight: bold;
            color: #333;
            margin-bottom: 10px;
        }
        label {
            font-size: 14px;
            color: #333;
            margin-bottom: 5px;
            display: block;
            text-align: left;
        }
        input[type="text"] {
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
    </style>
</head>
<body>
    <div class="form-container">
        <h2>Thêm Nhà Cung Cấp Mới</h2>
        <form action="NhaCungCapServlet" method="post">
            <input type="hidden" name="action" value="add">
            <fieldset>
                
                <label for="tenNCC">Tên Nhà Cung Cấp:</label>
                <input type="text" id="tenNCC" name="tenNCC" required>
                <label for="diaChi">Địa Chỉ:</label>
                <input type="text" id="diaChi" name="diaChi" required>
                <label for="soDienThoai">Số Điện Thoại:</label>
                <input type="text" id="soDienThoai" name="soDienThoai" required>
                <button type="submit">Thêm</button>
            </fieldset>
        </form>
        <a href="NhaCungCapServlet" class="btn-back">Quay về</a>
    </div>
    
</body>
</html>