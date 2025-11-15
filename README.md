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
  ✨ New Updates 
🔸 Shimmer Loading System
- Added a complete shimmer loading flow for the Movie Details Screen.
- Created a fully reusable ShimmerEffect.kt based on valentinilk shimmer library.
- Implemented ShimmerMovieDetails.kt as a full skeleton placeholder while data loads.
🔸 Movie Details Improvements
- Updated MovieDetailsScreenById to dynamically switch between shimmer state and real content using AnimatedContent.
- Improved the cast section with shimmer placeholders and cleaner layout.
- Enhanced transition animations and reduced layout jank for a smoother user experience.
---

### 👨‍🎨 Youssef Gerges Awad  

---Role 5 – Review & Polish

Performs code review for all newly submitted changes.

Handles UI/UX polishing, including colors, themes, and styles.

Adds light documentation inside the code (comments explaining the Compose functions).

Ensures that the Static Home Screen works correctly without any issues.

### 🔗 Omar Hamdy Fathy
- Added **MovieCard.kt** to display movies on the main screen.
- Fixed and improved **MovieDetailsScreen** to fetch real movie details from the API.
- Enhanced **MovieDetailsScreen** UI with dark theme and better layout.
- Added **search feature** in SearchScreen with real-time API integration.
- Created **CastMember** and **CastResponse** models for movie cast data.
- Updated **ApiService** and **MovieRepository** to handle cast requests.
- Extended **MovieDetailsViewModel** to manage movie and cast information.
- Updated **MovieDetailsScreen** to show movie cast (actors list with images).
- Improved overall UI performance, scrolling, and error handling.


---

### 📱 Ahmed Magdy Mohamed
- 🎨 *App Design*
  - Designed and integrated the *(App Logo)* to establish a clean and modern icon identity.
  - Developed a *(Splash Screen)* with styled image background and smooth transition animations.
- 🎬 *App UI*
  - Built the *(Detail Screen)* displaying (Poster, Title, Overview, Rating, and Release Date).
- 🔗 *App Navigation*
  - Implemented the *(Jetpack Navigation Component)* in NavigationGraph for details for dynamic screen transitions.
- 🌐 *Networking & API Integration*
  - Configured *(Retrofit)* for reliable communication with the *TMDB API*.
  - Created and structured *(API Service Interfaces)* defining all required endpoints.
  - Verified full connection and data flow between *the App and TMDB API*.
- 🔒 *security*
  - Applied *(security configuration)* to store the TMDB API key safely using secrets.properties.
- 🧪 *Unit Testing & Code Validation*
  - Implemented a complete *(Unit Testing Suite)* to ensure app reliability and data correctness.
  - Built (MapperTest) to validate :
    - correct mapping from ApiMovie API model to the app’s Movie domain model.
  - Built (MovieDetailsViewModelTest) to confirm :
    - the initial ViewModel state {null movie details & empty cast list} before loading data.
  - Built (SearchViewModelTest) to verify :
    - search logic, blank-query handling, and correct StateFlow updates during search operations.
  - Built (MovieViewModelTest) to check :
    - movie-loading behavior and ensure consistent StateFlow initialization within the ViewModel.
  - Built (MovieRepositoryTest) to test :
    - API data fetching using mocked responses - ensure accurate model mapping - verify search functionality logic.
  - Achieved *100% test success rate*, ensuring clean and maintainable code.

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
















