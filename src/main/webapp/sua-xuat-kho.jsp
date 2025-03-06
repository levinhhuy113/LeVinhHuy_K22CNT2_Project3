<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.XuatKho" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sửa Phiếu Xuất Kho</title>
    <style>
        /* General Reset */
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        /* Body */
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f9;
            padding: 20px;
        }

        .container {
            max-width: 600px;
            margin: 0 auto;
            background-color: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
        }

        /* Heading */
        h2 {
            text-align: center;
            margin-bottom: 20px;
            color: #333;
        }

        /* Form styles */
        .form-edit {
            display: flex;
            flex-direction: column;
        }

        /* Form group */
        .form-group {
            margin-bottom: 15px;
        }

        .form-group label {
            font-size: 14px;
            color: #333;
            margin-bottom: 5px;
        }

        .form-group input {
            width: 100%;
            padding: 10px;
            font-size: 14px;
            border: 1px solid #ccc;
            border-radius: 4px;
            outline: none;
        }

        .form-group input:focus {
            border-color: #2196F3;
        }

        /* Submit Button */
        .btn-submit {
            background-color: #2196F3;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            font-size: 16px;
            cursor: pointer;
            transition: background-color 0.3s ease;
            text-align: center;
        }

        .btn-submit:hover {
            background-color: #0b7dda;
        }

        .btn-submit:focus {
            outline: none;
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
    <div class="container">
        <h2>Sửa Phiếu Xuất Kho</h2>
        <form action="SuaXuatKho" method="post" class="form-edit">
            <input type="hidden" name="maPhieuXuat" value="<%= request.getAttribute("xuatKho") != null ? ((XuatKho) request.getAttribute("xuatKho")).getMaPhieuXuat() : "" %>" />
            <div class="form-group">
                <label for="ngayXuat">Ngày xuất:</label>
                <input type="date" id="ngayXuat" name="ngayXuat" value="<%= request.getAttribute("xuatKho") != null ? ((XuatKho) request.getAttribute("xuatKho")).getNgayXuat() : "" %>" />
            </div>
            <div class="form-group">
                <label for="maHang">Mã hàng:</label>
                <input type="number" id="maHang" name="maHang" value="<%= request.getAttribute("xuatKho") != null ? ((XuatKho) request.getAttribute("xuatKho")).getMaHang() : "" %>" />
            </div>
            <div class="form-group">
                <label for="soLuongXuat">Số lượng xuất:</label>
                <input type="number" id="soLuongXuat" name="soLuongXuat" value="<%= request.getAttribute("xuatKho") != null ? ((XuatKho) request.getAttribute("xuatKho")).getSoLuongXuat() : "" %>" />
            </div>
            <div class="form-group">
                <label for="giaXuat">Giá xuất:</label>
                <input type="number" step="0.01" id="giaXuat" name="giaXuat" value="<%= request.getAttribute("xuatKho") != null ? ((XuatKho) request.getAttribute("xuatKho")).getGiaXuat() : "" %>" />
            </div>
            <div class="form-group">
                <label for="tenKhachHang">Tên khách hàng:</label>
                <input type="text" id="tenKhachHang" name="tenKhachHang" value="<%= request.getAttribute("xuatKho") != null ? ((XuatKho) request.getAttribute("xuatKho")).getTenKhachHang() : "" %>" />
            </div>
            <div class="form-group">
                <button type="submit" class="btn-submit">Cập nhật</button>
            </div>
        </form>
        <a href="danh-sach-xuat-kho" class="btn-back">Quay về</a>
    </div>
</body>
</html>
