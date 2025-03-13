<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.List, model.XuatKho" %>



    <%
    String username = (String) session.getAttribute("username");
    if (username == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Lê Vinh Huy-K22CNT2-Quản lý kho hàng</title>
    <!-- plugins:css -->
    <link rel="stylesheet" href="assets/vendors/mdi/css/materialdesignicons.min.css">
    <link rel="stylesheet" href="assets/vendors/ti-icons/css/themify-icons.css">
    <link rel="stylesheet" href="assets/vendors/css/vendor.bundle.base.css">
    <link rel="stylesheet" href="assets/vendors/font-awesome/css/font-awesome.min.css">
    <!-- endinject -->
    <!-- Plugin css for this page -->
    <link rel="stylesheet" href="assets/vendors/font-awesome/css/font-awesome.min.css" />
    <link rel="stylesheet" href="assets/vendors/bootstrap-datepicker/bootstrap-datepicker.min.css">
    <!-- End plugin css for this page -->
    <!-- inject:css -->
    <!-- endinject -->
    <!-- Layout styles -->
    <link rel="stylesheet" href="assets/css/style.css">
    <!-- End layout styles -->
    <link rel="shortcut icon" href="assets/images/favicon.png" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
    
    <style>
        .table-container {
            margin: 20px;
            padding: 20px;
            border: 1px solid #ddd;
            border-radius: 10px;
            background-color: #f9f9f9;
        }

        .table-container h2 {
            text-align: center;
            margin-bottom: 20px;
            color: #333;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin: 0 auto;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        th, td {
            padding: 10px;
            text-align: center;
            border: 1px solid #ddd;
        }

        th {
            background-color: #4CAF50;
            color: white;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        img {
            border-radius: 5px;
            max-width: 50px;
            max-height: 50px;
        }

        td {
            font-size: 14px;
            color: #333;
        }

        /* Tạo hiệu ứng hover cho các dòng */
        tr:hover {
            background-color: #f1f1f1;
            cursor: pointer;
        }

        /* Cải thiện giao diện cho button */
        .btn {
            background-color: #4CAF50;
            color: white;
            padding: 10px 15px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        .btn:hover {
            background-color: #45a049;
        }
        tr:hover {
    background-color: #ddd;
    transition: 0.3s;
}

table {
    border-radius: 8px;
    overflow: hidden;
}
        /* CSS cho nút hành động */
.action-buttons {
    display: flex;
    justify-content: center;
    gap: 10px;
}

.action-buttons a, .action-buttons button {
    text-decoration: none;
    color: white;
    padding: 8px 12px;
    border: none;
    border-radius: 5px;
    font-size: 14px;
    cursor: pointer;
    transition: 0.3s;
}

/* Nút Sửa */
.btn-edit {
    background-color: #2196F3;
}

.btn-edit:hover {
    background-color: #0b7dda;
}

/* Nút Xóa */
.btn-delete {
    background-color: #f44336;
}

.btn-delete:hover {
    background-color: #c62828;
}
i.fa-solid.fa-cloud-arrow-up {
    margin-left: auto;
}
i.fa-solid.fa-cloud-arrow-down {
    margin-left: auto;
}
        
    </style>
  </head>
  <body>
      <!-- partial:partials/_navbar.html -->
      <nav class="navbar default-layout-navbar col-lg-12 col-12 p-0 fixed-top d-flex flex-row">
        <div class="text-center navbar-brand-wrapper d-flex align-items-center justify-content-start">
          <a class="navbar-brand brand-logo" href="index.jsp">
            <h3>QLKH</h3>
          </a>
        </div>
        <div class="navbar-menu-wrapper d-flex align-items-stretch">
          <button class="navbar-toggler navbar-toggler align-self-center" type="button" data-toggle="minimize">
            <span class="mdi mdi-menu"></span>
          </button>
          <div class="search-field d-none d-md-block">
            <form class="d-flex align-items-center h-100" action="#">
              <div class="input-group">
                <div class="input-group-prepend bg-transparent">
                  <i class="input-group-text border-0 mdi mdi-magnify"></i>
                </div>
                <input type="text" class="form-control bg-transparent border-0" placeholder="Search projects">
              </div>
            </form>
          </div>
          <ul class="navbar-nav navbar-nav-right">
            <li class="nav-item nav-profile dropdown">
            
                
                <div class="nav-profile-text">
                  <p>Xin chào, <%= username %> | <a href="logout">Đăng xuất</a></p>
                </div>
              </a>
              
            </li>
            
            
          </button>
        </div>
      </nav>
      <!-- partial -->
      <div class="container-fluid page-body-wrapper">
        <!-- partial:partials/_sidebar.html -->
        <nav class="sidebar sidebar-offcanvas" id="sidebar">
          <ul class="nav">
            <li class="nav-item nav-profile">
              <a href="#" class="nav-link">
      
                <div class="nav-profile-text d-flex flex-column">
                  <span class="font-weight-bold mb-2">Lê Vinh Huy</span>
                  <span class="text-secondary text-small">Admin</span>
                </div>
                <i class="fa-solid fa-user-tie" style="margin-left: 70px; color: #63E6BE;"></i>
              </a>
            </li>
           <li class="nav-item">
              <a class="nav-link" href="index.jsp">
                <span class="menu-title">Dashboard</span>
                <i class="mdi mdi-home menu-icon"></i>
              </a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="DanhSachNhapKho">
                <span class="menu-title">Nhập</span>
                <i class="fa-solid fa-cloud-arrow-down" style="color: #bba8bf;"></i>
                
              </a>
            </li>
            <li class="nav-item">
               <a class="nav-link" href="danh-sach-xuat-kho">
                <span class="menu-title">Xuất</span>
               
               <i class="fa-solid fa-cloud-arrow-up" style="color: #bba8bf;"></i>
              </a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="NhaCungCapServlet">
                <span class="menu-title">Nhà cung cấp</span>
                <i class="mdi mdi-contacts menu-icon"></i>
              </a>
            </li>
            <li class="nav-item">
		  <a class="nav-link" href="hanghoa">
		    <span class="menu-title">Kho hàng</span>
		    <i class="mdi mdi-format-list-bulleted menu-icon"></i>
		  </a>
		</li>

            
            
          </ul>
        </nav>
        <!-- partial -->
        <div class="main-panel">
          <div class="content-wrapper">
            <div class="page-header">
              <h3 class="page-title">
                <span class="page-title-icon bg-gradient-primary text-white me-2">
                  <i class="fa-solid fa-cloud-arrow-up" style="color: #fff;"></i>
                </span> Phiếu xuất
              </h3>
              
            </div>
            
            <div class="table-container">
    <h2>Danh Sách Phiếu Xuất Kho</h2>
    <div>
        <div style="text-align: left; margin-bottom: 10px;">
            <a href="xuat_kho.jsp" class="btn"><i class="fa-solid fa-circle-plus"></i> Tạo phiếu xuất</a>
        </div>
    </div>
    <table>
        <tr>
            <th>Mã Phiếu Xuất</th>
            <th>Ngày Xuất</th>
            <th>Mã Hàng</th>
            <th>Số Lượng Xuất</th>
            <th>Giá Xuất</th>
            <th>Tên Khách Hàng</th>
            <th>Thao tác</th>
        </tr>
        <%
            List<XuatKho> danhSachXuatKho = (List<XuatKho>) request.getAttribute("danhSachXuatKho");
            if (danhSachXuatKho != null) {
                for (XuatKho xk : danhSachXuatKho) {
        %>
        <tr>
            <td><%= xk.getMaPhieuXuat() %></td>
            <td><%= xk.getNgayXuat() %></td>
            <td><%= xk.getMaHang() %></td>
            <td><%= xk.getSoLuongXuat() %></td>
            <td><%= xk.getGiaXuat() %></td>
            <td><%= xk.getTenKhachHang() %></td>
            <td class="action-buttons">
			    <a href="SuaXuatKho?maPhieuXuat=<%= xk.getMaPhieuXuat() %>" class="btn-edit"><i class="fa-solid fa-pen-to-square"></i></a>    
			    <a href="javascript:void(0);" onclick="confirmDelete('<%= xk.getMaPhieuXuat() %>')" class="btn-delete"><i class="fa-solid fa-trash-can"></i></a>
			</td>
		
				<script type="text/javascript">
				    function confirmDelete(maPhieuXuat) {
				        var confirmation = confirm("Bạn có chắc chắn muốn xóa phiếu xuất kho này?");
				        if (confirmation) {
				            // Nếu người dùng xác nhận, thực hiện hành động xóa
				            window.location.href = "XoaXuatKho?maPhieuXuat=" + maPhieuXuat;
				        }
				    }
				</script>

            
        </tr>
        <%
                }
            }
        %>
    </table>
</div>

            
            </div>
            
          </div>
        </div>
        <!-- main-panel ends -->
      </div>
      <!-- page-body-wrapper ends -->
    </div>
    <!-- container-scroller -->
    <!-- plugins:js -->
    <script src="assets/vendors/js/vendor.bundle.base.js"></script>
    <!-- endinject -->
    <!-- Plugin js for this page -->
    <script src="assets/vendors/chart.js/chart.umd.js"></script>
    <script src="assets/vendors/bootstrap-datepicker/bootstrap-datepicker.min.js"></script>
    <!-- End plugin js for this page -->
    <!-- inject:js -->
    <script src="assets/js/off-canvas.js"></script>
    <script src="assets/js/misc.js"></script>
    <script src="assets/js/settings.js"></script>
    <script src="assets/js/todolist.js"></script>
    <script src="assets/js/jquery.cookie.js"></script>
    <!-- endinject -->
    <!-- Custom js for this page -->
    <script src="assets/js/dashboard.js"></script>
    <!-- End custom js for this page -->
  </body>
</html>