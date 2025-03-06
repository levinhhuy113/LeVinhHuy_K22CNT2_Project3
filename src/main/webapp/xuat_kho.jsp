<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="dao.HangHoaDAO, model.HangHoa, java.util.List" %>
<%
    HangHoaDAO hangHoaDAO = new HangHoaDAO();
    List<HangHoa> danhSachHang = hangHoaDAO.getAllHangHoa();
%>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Thêm Phiếu Xuất Kho</title>
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

        /* Error Message */
        .error-message {
            color: red;
            font-size: 14px;
            text-align: center;
            margin-top: 15px;
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
        <h2>Thêm Phiếu Xuất Kho</h2>
        <form action="<%= request.getContextPath() %>/xuatkho/them" method="post" class="form-edit">
            <div class="form-group">
                <label for="maHang">Chọn hàng hóa:</label>
                <select name="maHang" required>
                    <% for (HangHoa hh : danhSachHang) { %>
                        <option value="<%= hh.getMaHang() %>"><%= hh.getTenHang() %></option>
                    <% } %>
                </select>
            </div>

            <div class="form-group">
                <label for="soLuongXuat">Số lượng xuất:</label>
                <input type="number" name="soLuongXuat" min="1" required />
            </div>

            <div class="form-group">
                <label for="giaXuat">Giá xuất:</label>
                <input type="number" name="giaXuat" step="0.01" required />
            </div>

            <div class="form-group">
                <label for="ngayXuat">Ngày xuất:</label>
                <input type="date" name="ngayXuat" required />
            </div>

            <div class="form-group">
                <label for="tenKhachHang">Tên khách hàng:</label>
                <input type="text" name="tenKhachHang" required />
            </div>

            <div class="form-group">
                <button type="submit" class="btn-submit">Thêm Phiếu Xuất</button>
            </div>
        </form>
<a href="danh-sach-xuat-kho" class="btn-back">Quay về</a>
        <c:if test="${not empty error}">
            <div class="error-message">
                <p>${error}</p>
            </div>
        </c:if>
    </div>
</body>
</html>
