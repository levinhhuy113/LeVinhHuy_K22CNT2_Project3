<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    String username = (String) session.getAttribute("username");
    if (username == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<style>
.huy-le-container {
  text-align: center; /* Căn giữa chữ trong div */
  background-color: #fff; /* Màu nền của div */
  padding: 20px; /* Khoảng cách từ các cạnh của div đến nội dung */
  border-radius: 8px; /* Bo góc cho div */
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); /* Thêm bóng đổ nhẹ cho div */
}

.huy-le-container h1 {
  color: Blue	; /* Màu chữ */
  font-size: 36px; /* Kích thước chữ */
  font-family: 'Arial', sans-serif; /* Chọn font chữ */
  font-weight: bold; /* Chữ in đậm */
  margin: 0; /* Loại bỏ margin mặc định */
}
i.fa-solid.fa-cloud-arrow-up {
    margin-left: auto;
}
i.fa-solid.fa-cloud-arrow-down {
    margin-left: auto;
}
.huy-le-image {
    width: 100%; /* Chiều rộng tối đa */
    max-width: 600px; /* Giới hạn kích thước ảnh */
    height: auto; /* Đảm bảo ảnh không bị méo */
    display: block; /* Căn giữa ảnh */
    margin: 20px auto; /* Cách lề trên/dưới 20px, căn giữa */
    border-radius: 10px; /* Bo góc nhẹ để ảnh trông đẹp hơn */
    box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.2); /* Đổ bóng nhẹ */
}

</style>
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
                  <i class="mdi mdi-home"></i>
                </span> Dashboard
              </h3>
              
            </div>
            
           <div class="huy-le-container">
    <h1>2210900106 - Lê Vinh Huy - K22CNT2</h1>
    <h2>Quản lý kho Hàng</h2>
    
    <!-- Ảnh lớn, đẹp, căn giữa -->
    <img src="images/quanlykhohang.png" alt="Logo Quản lý kho hàng" class="huy-le-image">
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