# Sprint Boot example of RxJava

This is a simple Java / Maven / Spring Boot application to demonstrate how RxJava can be perfectly used
in microservice, particularly in composing downstream services in an
asynchronous fashion.

## Entities and Sample Data
There are four entities in this example: User, Movie, Rating and Review. Sample data is listed below to demonstrate all attributes and their relationship.

|User Id|Movie Ids|
|----|----|
|u1|[m1, m2]|
|u2|[m3, m4]|

|Movie Id|Title|Year|Rating Id|Review Ids|
|----|----|----|----|----|
|m1|The Shawshank Redemption|1994|rt1|[rv1, rv2]|
|m2|The Lord of the Rings: The Return of the King|2003|rt2|[rv3, rv3]|
|m3|The Dark Knight|2008|rt3|[rv5, rv6]|
|m4|Avatar|2009|rt4|[rv7, rv8]|

|Rating Id|Average|Num of Raters|
|----|----|----|
|rt1|9.3|1738986|
|rt2|8.9|1248775|
|rt3|9.0|1723350|
|rt4|7.9|905836|

|Review Id|Author|Summary|
|----|----|----|
|rv1|Tim Cox|One of the finest films made in recent years.|
|rv2|Dan Grant|Misery and Stand By Me were the best adaptations up until this one, now you can add Shawshank to that list.|
|rv3|Theo Robertson|It takes a miracle for me to go the cinema since smoking is banned in cinema chains but Peter Jackson is a miracle worker.|
|rv4|Stacey Bullen|How superb 'The Return of the King' is. It is the ultimate fantasy film and a sure bet for all the film awards this year.|
|rv5|Can Bolat|This is one of the best I've watched the movie trilogy.|
|rv6|Matt Greenwood|A perfectly made movie, with Heath Ledger at his best.|
|rv7|Dan Franzen|James Cameron's long-awaited Titanic follow-up is very pretty to look at but suffers from a flimsy plot and astoundingly stupid plot development.|
|rv8|Marco Di Giovanni|Unfortunately, I had to watch it in 2D, but even with that, this movie was just brilliant.|

## Get Started
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