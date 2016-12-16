# Sprint Boot example of RxJava

This is a simple Java / Maven / Spring Boot application to demonstrate how RxJava can be perfectly used
in microservice, particularly in composing downstream services in an
asynchronous fashion.

## Quick Start
1. `mvn clean install`
2. `java -jar ./target/spring-boot-rx-movies-0.0.1-SNAPSHOT.jar`
3. `curl http://localhost:8080/movies/u1`

The output would be:
```
{
  "movies": [
    {
      "id": "m1",
      "title": "The Shawshank Redemption",
      "year": "1994",
      "rating": {
        "id": "rt1",
        "average": 9.3,
        "numRaters": 1738986
      },
      "reviews": [
        {
          "id": "rv1",
          "author": "Tim Cox",
          "summary": "One of the finest films made in recent years."
        },
        {
          "id": "rv2",
          "author": "Dan Grant",
          "summary": "Misery and Stand By Me were the best adaptations up until this one, now you can add Shawshank to that list."
        }
      ]
    },
    {
      "id": "m2",
      "title": "The Lord of the Rings: The Return of the King",
      "year": "2003",
      "rating": {
        "id": "rt2",
        "average": 8.9,
        "numRaters": 1248775
      },
      "reviews": [
        {
          "id": "rv4",
          "author": "Stacey Bullen",
          "summary": "How superb 'The Return of the King' is. It is the ultimate fantasy film and a sure bet for all the film awards this year."
        },
        {
          "id": "rv3",
          "author": "Theo Robertson",
          "summary": "It takes a miracle for me to go the cinema since smoking is banned in cinema chains but Peter Jackson is a miracle worker."
        }
      ]
    }
  ]
}
```