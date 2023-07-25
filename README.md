# Movie Review API Backend

This is a sample Movie Review API project built using Java, Maven, and Spring Boot. The API allows users to manage movies and their associated reviews. It utilizes MongoDB as the database to store movie and review data.

##  Prerequisites

Before running the project, make sure you have the following prerequisites:

- Java 8 or higher installed on your system.
- Maven installed on your system.
- MongoDB instance accessible, along with the necessary credentials and database name.

## Getting Started

1. Clone the repository to your local machine:
```agsl
git clone <repository_url>
```

2. Navigate to the project root directory:
```agsl
cd movie-review-api
```

3. Open the application.properties file in the src/main/resources directory and update the MongoDB configuration or
create a .env file that look like the .env.example file:
```agsl
MONGO_DATABASE=
MONGO_USER=
MONGO_PASSWORD=
MONGO_CLUSTER=
```

In the MongoDB the document should look like this:
```agsl
{
  "_id": ObjectId("<id_of_the_document>"),
  "imdbId": "tt1630029",
  "title": "Avatar: The Way of Water",
  "releaseDate": "2022-12-16",
  "trailerLink": "https://www.youtube.com/watch?v=d9MyW72ELq0",
  "genres": ["Science Fiction", "Action", "Adventure"],
  "poster": "https://image.tmdb.org/t/p/w500/t6HIqrRAclMCA60NsSmeqe9RmNV.jpg",
  "backdrops": [
    "https://image.tmdb.org/t/p/original/s16H6tpK2utvwDtzZ8Qy4qm5Emw.jpg",
    "https://image.tmdb.org/t/p/original/evaFLqtswezLosllRZtJNMiO1UR.jpg",
    "https://image.tmdb.org/t/p/original/198vrF8k7mfQ4FjDJsBmdQcaiyq.jpg",
    "https://image.tmdb.org/t/p/original/zaapQ1zjKe2BGhhowh5pM251Gpl.jpg",
    "https://image.tmdb.org/t/p/original/tQ91wWQJ2WRNDXwxuO7GCXX5VPC.jpg",
    "https://image.tmdb.org/t/p/original/5gPQKfFJnl8d1edbkOzKONo4mnr.jpg",
    "https://image.tmdb.org/t/p/original/2fS9cpar9rzxixwnRptg4bGmIym.jpg",
    "https://image.tmdb.org/t/p/original/fkGR1ltNbvERk3topo4dP3gWsvR.jpg",
    "https://image.tmdb.org/t/p/original/rb9IHprKNoSKqatP2vr25unUDSu.jpg",
    "https://image.tmdb.org/t/p/original/37ZswIuRQcRBN7kHij5MBjzRMRt.jpg"
  ],
  "reviewIds": []
}
```

The reviews are being to be populated after in the `/api/v1/reviews` endpoint.

4. Build the project using Maven:
```asgl
mvn clean package
```

5. Run the application:
```agsl
mvn spring-boot:run
```

The API should now be running at http://localhost:8080.

## API Endpoints

### Movie Endpoints

- `GET /api/v1/movies`: Get a list of all movies.
- `GET /api/v1/movies/{id}`: Get details of a specific movie by its `{imdbId}`.

### Review Endpoints

- `POST /api/v1/reviews`: Create a new review. (Requires a valid JSON payload with reviewBody and imdbId fields)

JSON payload example:
```json
{
	"reviewBody": "your_review",
	"imdbId": "<imdbId>"
}
```

More endpoints are being to be implemented soon

## Error Handling

The API includes a global exception handler to handle different types of exceptions. The API returns meaningful error responses with appropriate status codes and error messages for common scenarios like invalid requests, not found resources, etc.

## Data Models

The API uses the following data models:

- `MovieDocument`: Represents a movie entity in MongoDB.
- `ReviewDocument`: Represents a review entity in MongoDB.
- `MovieDTO`: Represents a Data Transfer Object for movie entities.
- `ReviewDTO`: Represents a Data Transfer Object for review entities.

## MongoDB Repositories

The API uses two MongoDB repositories to interact with the database:

- `MovieRepository`: Used to perform CRUD operations on the MovieDocument collection.
- `ReviewRepository`: Used to perform CRUD operations on the ReviewDocument collection.

## Service Layer

The service layer contains two main services:

- `MovieService`: Handles movie-related business logic and interactions with the MovieRepository.
- `ReviewService`: Handles review-related business logic and interactions with the ReviewRepository and MovieRepository.

## Controller Layer

The controller layer contains three main controllers:

- `MovieController`: Handles HTTP requests related to movies and interacts with the MovieService.
- `ReviewController`: Handles HTTP requests related to reviews and interacts with the ReviewService.
- `GlobalExceptionHandler`: Handles global exception handling for the API.


## DTO Mappers

The DTO mappers (`MovieDTOMapper` and `ReviewDTOMapper`) are responsible for mapping between the data models and DTOs.

## Conclusion

This Movie Review API project provides a basic implementation to manage movies and their reviews. You can extend the functionality and add more features to suit your specific use case. Happy coding!