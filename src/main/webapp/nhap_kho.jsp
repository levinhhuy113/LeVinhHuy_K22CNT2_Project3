<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="dao.HangHoaDAO, dao.NhaCungCapDAO, model.HangHoa, model.NhaCungCap, java.util.List" %>
<%
    HangHoaDAO hangHoaDAO = new HangHoaDAO();
    NhaCungCapDAO nccDAO = new NhaCungCapDAO();
    List<HangHoa> danhSachHang = hangHoaDAO.getAllHangHoa();
    List<NhaCungCap> danhSachNCC = nccDAO.getAllNhaCungCap();
%>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Nhập Kho</title>
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

        .form-group select, .form-group input {
            width: 100%;
            padding: 10px;
            font-size: 14px;
            border: 1px solid #ccc;
            border-radius: 4px;
            outline: none;
        }

        .form-group select:focus, .form-group input:focus {
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

        /* Button Container */
        .form-group button {
            align-self: center;
            margin-top: 20px;
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
        <h2>Nhập Kho</h2>
        <form action="NhapKhoServlet" method="post" class="form-edit">
            <div class="form-group">
                <label for="maHang">Chọn hàng hóa:</label>
                <select name="maHang" required>
                    <% for (HangHoa hh : danhSachHang) { %>
                        <option value="<%= hh.getMaHang() %>"><%= hh.getTenHang() %></option>
                    <% } %>
                </select>
            </div>

            <div class="form-group">
                <label for="maNCC">Chọn nhà cung cấp:</label>
                <select name="maNCC" required>
                    <% for (NhaCungCap ncc : danhSachNCC) { %>
                        <option value="<%= ncc.getMaNCC() %>"><%= ncc.getTenNCC() %></option>
                    <% } %>
                </select>
            </div>

            <div class="form-group">
                <label for="soLuong">Số lượng nhập:</label>
                <input type="number" name="soLuong" min="1" required />
            </div>

            <div class="form-group">
                <label for="giaNhap">Giá nhập:</label>
                <input type="number" name="giaNhap" step="0.01" required />
            </div>

            <div class="form-group">
                <label for="ngayNhap">Ngày nhập:</label>
                <input type="date" name="ngayNhap" required />
            </div>

            <div class="form-group">
                <button type="submit" class="btn-submit">Nhập kho</button>
            </div>
        </form>
        <a href="DanhSachNhapKho" class="btn-back">Quay về</a>
    </div>
</body>
</html>
