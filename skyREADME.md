Parental Control Service
===

Scenario
---
Sky is developing a next generation Video on Demand platform. You are part of a software engineering team, developing 
services for the platform and working on the following story:

**Prevent access to movies based on parental control level**
*As a customer I don’t want my account to be able to access movies that have a higher parental control level than my 
current preference setting.*

**Parental Control Levels:**
U, PG, 12, 15, 18 (where U is the least restrictive and 18 is the most restrictive)


Your team has partnered with the Movie Meta Data team that provides a service that can return parental control 
information for a given movie.

Instructions
---
You are required to provide an implementation of a *ParentalControlService* 
(com.bskyb.internettv.parental_control_service.ParentalControlService) using the provided project shell. You may 
use Java version 6 or above and whatever libraries you find reasonable (just make sure you update the project's pom file 
accordingly). 

The service should accept as input the customer’s *parental control level 
preference* and a *movie id*. If the customer is able to watch the movie the *ParentalControlService* should indicate 
this to the calling client.

The recommended time to complete this exercise should be between forty-five minutes and one-hour.


Movie Service
---
The Movie Meta Data team is currently developing the MovieService getParentalControlLevel call that accepts the *movie 
id* as an input and returns the parental control level for that movie as a string. 

This is a simple diagram of the interaction between the services:

```
Client                      ParentalControlService                      MovieService
------                      ----------------------                      ------------
  |                                   |                                       |
  | customer parental control level,  |                                       |
  |          movie id                 |                                       |
  |---------------------------------->|                                       |
  |                                   |      getParentalControlLevel(...)     |
  |                                   |-------------------------------------->|
  |                                   |                                       |
  |                                   |      movie parental control level     |
  |                                   |<--------------------------------------|
  |            boolean                |                                       |
  |<----------------------------------|                                       |
  |                                   |                                       |
```

MovieService Interface
---
```java
package com.thirdparty.movie;

public interface MovieService {
    String getParentalControlLevel(String movieId) throws TitleNotFoundException, TechnicalFailureException;
}
```

This is a third party interface so you should not change it. This service throws checked exceptions.

Acceptance Criteria
---

The following table describes the expected ParentalControlService result based on a given MovieService 
*getParentalControlLevel* response.

| MovieService getParentalControlLevel response| Description                                     | ParentalControlService result  
|----------------------------------------------|------------                                     |------------------------------
| Parental Control level                       |A string e.g. "PG"                               |If the parental control level of the movie is equal to or less than the customer’s preference indicate to the caller that the customer can watch the movie
| TitleNotFoundException                       |The movie service could not find the given movie |Indicate the error to the calling client.
| TechnicalFailureException                    |System error                                     |Indicate that the customer cannot watch this movie

We need to ensure that we always failsafe.

To deliver your solution
---
* In the pom.xml file update the 'candidateName' property with your first and last names (e.g. <candidateName>John.Doe</candidateName>) 
* 'Package' your project (e.g. run 'mvn package' from the command line)
* Send us the zip file that was generated inside the project's 'target' directory (e.g. ${project.basedir}/target/John.Doe.zip) 
* Please do not publish your solution in the public domain e.g. GitHub, a blog or Dropbox.

Note: We are interested in code readability and structure and your use of best practices.
