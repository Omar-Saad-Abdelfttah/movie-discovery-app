## 🖼️ Project Screenshot  

<p align="center">
  <img src="https://github.com/user-attachments/assets/9c20e682-8e29-471c-a4bc-34a68542ef62" 
       alt="Movie Discovery App Screenshot" 
       width="500" 
       style="border-radius: 13px; box-shadow: 0 4px 8px rgba(0,0,0,0.2);" />
</p>

---

# 🎬 Movie Discovery App  

A modern Android application built with **Kotlin** and **Jetpack Compose** to browse and discover movies.  
This project is part of the **Digital Egypt Pioneers Initiative**.  

---

## 🚀 Features  
- Browse popular movies from **TMDB API**  
- View detailed information about a selected movie *(title, poster, rating, release date, overview)*  
- Search for movies by title  
- Modern UI with **Material Design 3** principles  
- Unit testing for business logic  

---

## 🛠️ Tech Stack  
- **Kotlin**  
- **Jetpack Compose**  
- **Retrofit** (API integration)  
- **Navigation Component**  
- **Material Design Components**  
- **Git & GitHub**  
- **JUnit** (Unit Testing)  

---

## 📅 Project Plan  

### 1️⃣ Project Setup and UI Design  
- Initialize GitHub repository & project structure  
- Set up Jetpack Compose  
- Build basic UI components (movie cards, lists, etc.)  

### 2️⃣ API Integration and Dynamic Display  
- Connect to **TMDB API**  
- Fetch & parse JSON responses  
- Display movies dynamically in the UI  

### 3️⃣ Navigation and Detail Screen  
- Implement navigation between screens  
- Create a detailed movie page *(poster, title, overview, rating, etc.)*  

### 4️⃣ Search, Security, and Final Polish  
- Add search functionality  
- Handle errors & secure API key  
- Apply final UI/UX polish and testing  

---

## 👨‍💻 Team Members  

- Omar Saad Abdel-Fattah  
- Youssef Gerges Awad  
- Omar Hamdy Fathy  
- Ahmed Magdy Mohamed  
- Bassem Ragy Yehia  

---

## 📌 Roles & Responsibilities  

### 👑 Omar Saad Abdel-Fattah (Team Leader)  
- Built the base project structure using Jetpack Compose.
- Implemented MainActivity and configured NavigationGraph to connect all screens.
- Developed the Home Screen (MovieGridScreen) for displaying popular movies.
- Created and connected the Search Screen with real-time TMDB data fetching.
- Added and structured the Movie Details navigation for individual movie pages.
- Integrated TMDB API inside Repository and ViewModel for dynamic movie data.
- Improved MovieGridScreen UI with dark theme, padding, and responsive grid layout.
- Added a Compose-based Splash Screen with loading animation at app start.
- Refactored MainActivity navigation logic for cleaner and more stable transitions.
- Enhanced UX by handling loading states, empty results, and smooth animations.

---

### 👨‍🎨 Youssef Gerges Awad  

---Role 5 – Review & Polish

Performs code review for all newly submitted changes.

Handles UI/UX polishing, including colors, themes, and styles.

Adds light documentation inside the code (comments explaining the Compose functions).

Ensures that the Static Home Screen works correctly without any issues.

### 🔗 Omar Hamdy Fathy 
- Integrate Retrofit with TMDB API.  
- Create data models for JSON responses.  
- Connect API with UI (Lazy grid of movies).  
- Handle network errors & loading states.  

---

### 📱 Ahmed Magdy Mohamed
- Built *(Detail Screen)* (Poster, Title, Overview, Rating, Release Date).
- Configured *(Retrofit)* for API communication.
- Created *(API Service interfaces)* with all required endpoints.
- Verified successful connection between (the app and the API).
- Implemented *(Jetpack Navigation Component)* for seamless screen transitions.
- Designed and integrated the *(app logo)*.
- Developed a custom *(Splash Screen)* with background styling.
- Implemented *(security configuration)* by storing the TMDB API key securely as required.

---

### 🔍 Bassem Ragy Yehia
- Implemented the NavigationGraph connecting (Splash, Home, Search, and Details) screens using Jetpack Compose Navigation.
- Developed the Movie Details Screen displaying (poster, title, rating, release date, and overview) with smooth slide and fade animations.
- Built the Home Screen using a responsive grid layout and integrated search navigation.
- Connected screens through safe movieId passing to ensure data consistency between routes.
- Created the MovieItem composable to show each movie card with its poster and title.
- Built the Repository layer to fetch movies, movie details, and search results directly from the TMDB API.
- Mapped API responses into clean Movie objects using toMovie() for UI presentation.
- Applied a modular structure separating data, UI, and navigation logic for easier scalability.
- Focused on improving the UI flow, ensuring smooth transitions and organized code readability.
---
