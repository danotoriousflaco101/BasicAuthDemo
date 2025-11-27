<div align="center">
<h1><strong>Basic Auth</strong></h1>

![unnamed](https://github.com/user-attachments/assets/75670775-7f33-42fd-8699-e0346d4dcbf7)


</div>

<div align="center">
</br>
Spring Boot app demo for HTTP Basic Authentication backed by H2 Database. 
</br>
</br>
</div>
</br>


Tech Stack 🛠️
-----
</br>
<strong>Java 21</strong>
</br>
</br>
<strong>Spring Boot 3.4.X</strong>
</br>
</br>
<strong>Spring Security:</strong> Custom configuration using SecurityFilterChain
</br>
</br>
<strong>Spring Data JPA + Hibernate:</strong> AppUser entity and AppUserRepository
</br>
</br>
<strong>H2 Database</strong>
</br>
</br>
<strong>Lombok</strong> to reduce boilerplate code
</br>
</br>
<strong>Database Auth:</strong> Users loaded from H2 DB (not hardcoded in-memo)
</br>
</br>
<strong>BCrypt:</strong> Passwords hashed before storage
</br>
</br>
<strong>RBAC:</strong> Role-Based Access Control configuration
</br>
</br>


Tools & Technologies 💻
------------
</br>
<p align="center">
<a href="#"><img src="https://img.shields.io/badge/Apache%20Maven-C71A36?logo=apachemaven&logoColor=white" alt="Maven"></a>
<a href="#"><img src="https://img.shields.io/badge/Spring%20Boot-6DB33F?logo=springboot&logoColor=fff&style=flat" alt="SpringBoot"></a>
<a href="#"><img src="https://img.shields.io/badge/macOS-000000?logo=apple&logoColor=F0F0F0" alt="macOS"></a>
<a href="#"><img src="https://img.shields.io/badge/Spotify-1ED760?logo=spotify&logoColor=white" alt="Spotify"></a> 
<a href="#"><img src="https://custom-icon-badges.demolab.com/badge/Visual%20Studio%20Code-0078d7.svg?logo=vsc&logoColor=white" alt="VSC"></a>
<a href="#"><img src="https://img.shields.io/badge/GitHub-181717?logo=github&logoColor=white" alt="GitHub"></a> 
</p>

Set up ✅
-----------

Run the App
</br>
</br>
<strong>CMD:</strong></br>
./mvnw spring-boot:run
</br>
</br>
DB automatically populated at start (DataLoader.java).
</br>
</br>

Endpoints 
-----------
</br>
</br>
http://localhost:8080/ (Public - No login required)
</br>
http://localhost:8080/user (Requires USER or ADMIN role)
</br>
http://localhost:8080/admin (Requires ADMIN role)
</br>
http://localhost:8080/h2-console (Database Console)
</br>
</br>

