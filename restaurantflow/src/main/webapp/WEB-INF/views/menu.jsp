<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>RestaurantFlow — ${pageTitle}</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" 
          rel="stylesheet">
    <style>
        body { background-color: #f8f4f0; }
        .navbar { background-color: #b5451b; }
        .menu-card { 
            border: none; 
            border-radius: 12px; 
            box-shadow: 0 2px 8px rgba(0,0,0,0.1);
            transition: transform 0.2s;
        }
        .menu-card:hover { transform: translateY(-4px); }
        .badge-available { background-color: #2e7d32; }
        .badge-unavailable { background-color: #c62828; }
        .price-tag { 
            font-size: 1.2rem; 
            font-weight: bold; 
            color: #b5451b; 
        }
    </style>
</head>
<body>

    <!-- Navbar -->
    <nav class="navbar navbar-dark px-4 py-3">
        <span class="navbar-brand fs-4">🍽️ RestaurantFlow</span>
        <div>
            <a href="/menu" class="btn btn-outline-light btn-sm me-2">Menu</a>
            <a href="/login" class="btn btn-light btn-sm">Login</a>
        </div>
    </nav>

    <!-- Hero -->
    <div class="text-center py-5" 
         style="background: linear-gradient(135deg, #b5451b, #e07b39); color: white;">
        <h1 class="display-5 fw-bold">🍛 Today's Menu</h1>
        <p class="lead">Fresh ingredients. Real flavours. Every order made with care.</p>
    </div>

    <!-- Menu Items -->
    <div class="container py-5">

        <c:choose>
            <c:when test="${empty menuItems}">
                <div class="text-center py-5">
                    <h4 class="text-muted">
                        😔 No items available right now. Check back soon!
                    </h4>
                </div>
            </c:when>
            <c:otherwise>
                <div class="row g-4">
                    <c:forEach var="item" items="${menuItems}">
                        <div class="col-md-4">
                            <div class="card menu-card h-100 p-3">
                                <div class="card-body">

                                    <div class="d-flex justify-content-between 
                                                align-items-start mb-2">
                                        <h5 class="card-title mb-0">${item.name}</h5>
                                        <span class="badge 
                                            ${item.available ? 
                                              'badge-available' : 
                                              'badge-unavailable'} text-white">
                                            ${item.available ? 'Available' : 'Sold Out'}
                                        </span>
                                    </div>

                                    <p class="text-muted small mb-2">
                                        📂 ${item.category}
                                    </p>

                                    <p class="card-text text-secondary">
                                        ${item.description}
                                    </p>

                                    <div class="d-flex justify-content-between 
                                                align-items-center mt-3">
                                        <span class="price-tag">₹${item.price}</span>
                                        <span class="text-muted small">
                                            ⏱️ ${item.prepTimeMinutes} mins
                                        </span>
                                    </div>

                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </c:otherwise>
        </c:choose>

    </div>

    <!-- Footer -->
    <footer class="text-center py-4 text-muted">
        <small>RestaurantFlow © 2026 — Built with Spring Boot + JSP</small>
    </footer>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js">
    </script>
</body>
</html>