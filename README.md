

<!-- PROJECT SHIELDS -->
<!--
*** I'm using markdown "reference style" links for readability.
*** Reference links are enclosed in brackets [ ] instead of parentheses ( ).
*** See the bottom of this document for the declaration of the reference variables
*** for contributors-url, forks-url, etc. This is an optional, concise syntax you may use.
*** https://www.markdownguide.org/basic-syntax/#reference-style-links
-->
[![Contributors][contributors-shield]][contributors-url]
[![LinkedIn][linkedin-shield]][linkedin-url]

[![Product Name Screen Shot][product-screenshot]]()

<!-- PROJECT LOGO -->

<p align="center">Telia Summer Internship

  <h3 align="center">HINT SPRINT</h3>

  <p align="center">An awesome location-hunt application
    

<!-- TABLE OF CONTENTS -->
## Table of Contents

* [About the Project](#about-the-project)
  * [Built With](#built-with)
* [Implementation Guide](#implementation-guide)
  * [How To Run](#how-to-run)
  * [Structure](#structure)
* [Contact](#contact)



<!-- ABOUT THE PROJECT -->
## About The Project


HintSprint has been our main project throughout the summer. In short, we have created a treasure-hunt application where the objective
is to locate the different secret locations within a given Game. A "Game" exists as a list of secret locations, and the Users are to discover all these
secret locations based on a given "hint" for each location. Once a player arrives at his/her given next location, the user will receive
some points dependent on how little time they used from their previous location. The user will also receive a number of coupons
from local stores/restaurants which allows the implementation of Location Based Addvertisement. 

The main objective for the players is to gather points and compete with their friends and all other players in the form of a leaderboard,
while at the same time receive coupons/vouchers for nearby stores once they arrive at a new secret location. 

The main business aspect for Telia would be to allow shop-owners to apply for the location based addvertisement. 
The goal is also that Telia would own the plattform, and would allow shop-owners or others to create their own custom games.
By creating their own game, we mean that the shop-owners would get to define the different secret locations, define each their own hint,
and define some additional special rules for the given game. 

An example of a custom-made game by a shop-owner would be as follows:

- Mc Donalds create their own game, where they define each mc.d store in Oslo as a secret location. They can then define
to give coupons/promotions dependent on stuff like: 
  - How often they visit a mc.d store
  - How many different stores they have visited
  - Special challenges like visit a number of stores within a given time period.
  - And a lot more. 
  
 
 A user could be a member of a number of different HintSprint games at the same time. Both custom-made games created by the Community of players,
 or custom games created by shop-owners as the example above, and even some pre-determined main-games defined/created by Telia.
 
 The game encourages the players to go outside and be active, aswell as it has a huge player-base potential, including everyone from
 tourists to shop-owners´customers, and even competetive players who want to compete in becoming the best location-hunter. 
 


### Built With
The project is implemented in Java, using a gradle project structure. In addition to the basic libraries included in the java SDK,
we have used some additional libraries. Most importantly we´ve used the JAX-WS protocol of connecting with the SOAP APIs, and implemented
a cron job of the type Quartz which is sat to run every n seconds. 

* [Gradle](https://gradle.org)
* [JAX-WS](https://javaee.github.io/metro-jax-ws/doc/user-guide/index.html)
* [Quartz Job Scheduler](http://www.quartz-scheduler.org)



<!-- Implementation Guide -->
## Implementation Guide

During the summer we have managed to create an early prototype of the SprintHint Platform. 
Currently we have implemented the basic rules of a Game, and created one instance of a test-game.
The current test-game is created within the method "createTestGame" inside the Quiz class. See this method for explanation on how 
to create different locations for a given game. 

The test game consists of a number of different locations including dummy-promotions and hints. The test game is a real and testable
game which we have been playing with in real life.


<!-- How To Run -->

## How To Run
THIS SECTION IS HOW TO RUN TODO

### Structure

The structure of our project is as following:


```
Polygon
    - List of (x,y) coordinates 
    - function to determen whether a given point (x,y) is within this polygon.
```


```
User
    - msisdn(Nr.) 
    - score
    - current level
    - time since last levelUp
    - Misc. Variables
```

```
QuizLocation
    - Polygon actual area
    - Polygon margin area
    - hint of where location is
    - URL of promotions/coupons of current location
```


```
Leaderboard
    - Descending sorted list of Users, sorting criteria is User.score 
```


```
UpdatePosition
    - Scheduler which starts a new job every n seconds.
```

```
UpdatePositionJob
    - Job which executes every n seconds.
    - The job goes through the given memberList and checks whether each User is within their
      current hidden location. If true, update the Users´ level and score, and send out a congrats. SMS. 
```

```
Quiz - (The GameMaster)
    - User-List
    - Leaderboard
    - QuizLocation-List
    - UpdatePositioner
    - The Quiz-class represents the entire game. An instance of a Quiz represents an entire game.
``` 
    
    
In addition to these classes we have some logic for implementing the communication with the SOAP APIs. 
We used JAX-WS to genereate client-stub classes which are used to interact with the SOAP APIs. The important classes we have created
in regards to the API communication is the two Client classes: 
- CoverageAreaInvoker 
- SmsInvoker

These classes are used as an interface with the generated client-stub classes. In order to run the project it is neccesary
to create text files containing the basic authentication credentials for the APIs. The text files should be called loginSms and loginCoverage,
containing two lines. The first line should be the username, and the second line should be the corresponding password. Some additional information about the clients:

```
CoverageAreaInvoker
    - Update the position of a given msisdn (only make calls to the API if more than 10sec from last call of given number)
    - Misc. methods of returning information received from the CoverageArea2 API. Such as getLocation().
```

```
SmsInvoker
    - Send a custom String to the given msisdn.    
```
   

<!-- CONTACT -->
## Contact

Marcus Tierney - [LinkedIn](https://linkedin.com/in/marcustierney97) - Marcus-Tierney@hotmail.com
<br>
Shobi Premkumar - [LinkedIn](https://linkedin.com/in/shobiha-premkumar-17a60110a) - Shobiha.Premkumar@gmail.com
<br>
Project Link: [https://github.com/mvrcus97/LocationService](https://github.com/Mvrcus97/LocationService)







<!-- MARKDOWN LINKS & IMAGES -->
[contributors-shield]: https://img.shields.io/github/contributors/othneildrew/Best-README-Template.svg?style=flat-square
[contributors-url]: https://github.com/Mvrcus97/LocationService/graphs/contributors
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=flat-square&logo=linkedin&colorB=555
[linkedin-url]: https://linkedin.com/in/marcustierney97
[product-screenshot]: wnh05jyix9lijxfafljp.jpg
