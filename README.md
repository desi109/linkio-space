<!--
*** Using markdown "reference style" links for readability.
*** https://www.markdownguide.org/basic-syntax/#reference-style-links
-->
[![Contributors][contributors-shield]][contributors-url]
[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]
[![MIT License][license-shield]][license-url]
[![LinkedIn][linkedin-shield]][linkedin-url]



<!-- PROJECT LOGO -->
<br />
<p align="center">
  <a href="https://github.com/desi109/linkio-space">
    <img style="" src="images/logo/logo-with-background.png" alt="Logo" width="100%" height="100%">
  </a>


  <h3 align="center">Linkio.Space</h3>

  <p align="center">
    Linkio.Space is a web application that allows you to keep all your connections with people and their business cards. <br>You can easily and quickly add new connections. All your business cards are stored and updated at any time.
    <br />
    <a href="https://github.com/desi109/linkio-space"><strong>Explore the docs »</strong></a>
    <br />
    <br />
    <a href="https://github.com/desi109/linkio-space">View Demo</a>
    ·
    <a href="https://github.com/desi109/linkio-space/issues">Report Bug</a>
    .
    <a href="https://github.com/desi109/linkio-space/issues">Request Feature</a>
  </p>
</p>



<!-- TABLE OF CONTENTS -->
<details open="open">
  <summary><h2 style="display: inline-block">Table of Contents</h2></summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#roadmap">Roadmap</a></li>
    <li><a href="#license">License</a></li>
    <li><a href="#contact">Contact</a></li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## About The Project
The idea of this app is to save the user's business cards. When the user signs up, the system automatically generates a 4-digit code that is unique. If a user wants to give his business card to somebody, he just has to provide this code. The platform has a search system that searches other users by using this user code.  After the user's business card which is searched, is found, it can be added with just one click. The application has a user`s connections board, from where the user can see all his contacts. Every user profile can be edited and the new information for a user will be updated also for the people who have been saved his business card. 

The app has a blue minimalistic design and it is easy to be used by everyone.

On http://localhost:8081/, there is the start page. It has welcome information with a logo, simple navigation bar, and footer with contacts.
![product-screenshot-start-page-1]
![product-screenshot-start-page-2]

On http://localhost:8081/home, there is the home page with buttons for ```Sign Up``` and ```Log In```. The user can also use the navigation bar to sign up and log in.
![product-screenshot-home-page]

 The user can also use the navigation bar to sign up and login.

 http://localhost:8081/register
![product-screenshot-sign-up-page]

http://localhost:8081/login
![product-screenshot-log-in-page]

The application has two views for the administrator and for the user. Credentials for login as administrator are:
```
Email: admin@linkiospace.com
Password: admin123
```
Admin profile page (http://localhost:8081/profile) has information about the admin. The information can only be edited from the button ```EDIT YOUR INFORMATION```.
![product-screenshot-admin-profil-page]

After editing the information, everything should be saved from the button ```SAVE``` .
![product-screenshot-admin-profile-edit-page]

The admin view has ```Admin Board``` (http://localhost:8081/admin/users) where all users and their information is visible. 
![product-screenshot-admin-board-page]

Admin can delete users from the database.
![product-screenshot-admin-board-delete-page]

Credentials for login as user are for exaple:
```
Email: todor.todorov@gmail.com
Password: 12345678

// The password is the same for all test users.
```
The user can also edit his profile as the administrator.
![product-screenshot-user-profile-page]

Every user has ```Connections``` (http://localhost:8081/user/connections) board where can remove business cards or see details about his connections.
![product-screenshot-user-connections-board-page]
![product-screenshot-user-connections-delete-board-page]

To search for a new business card, the user should go to ```Search``` (http://localhost:8081/user/search), enter a code, and press the button for search. If the business card is found, the user can easily add it to his connections from the button ```ADD USER TO YOUR CONNECTIONS```.
![product-screenshot-user-search-board-page]




### Built With

* [Spring Boot](https://spring.io/projects/spring-boot)
* [PostgreSQL](https://www.postgresql.org/)
* [Vue](https://vuejs.org/)
* [Vuetify](https://vuetifyjs.com/en/)



<!-- GETTING STARTED -->
## Getting Started

To get a local copy up and running follow these simple steps.

### Prerequisites
To run this project you first need to install and set up:
* [Java 11](https://docs.aws.amazon.com/corretto/latest/corretto-11-ug/downloads-list.html)
  ```sh
  java -version
  ```
* [ApacheMaven v3.6.3](https://maven.apache.org/download.cgi)
  ```sh
  mvn -v
  ```
* [PostgreSQL v12.4](https://www.enterprisedb.com/downloads/postgres-postgresql-downloads)
* [pgAdmin v4.20](https://www.pgadmin.org/download/)
* [Node.js v12.18](https://nodejs.org/en/download/)
  ```sh
  node -v
  ```
* NPM 6.14
  ```sh
  npm -v
  ```
* [Vue 2](https://vuejs.org/v2/guide/installation.html)
  ```sh
  npm install vue
  ```
* [Vue CLI v4.5](https://cli.vuejs.org/guide/installation.html)
  ```sh
  npm install -g @vue/cli
  vue -V 
  ```




### Installation

1. Clone the repo:
   ```sh
   git clone https://github.com/desi109/linkio-space.git
   ```

2. Set up the database for the project
  * ### For Windows
  In pgAdmin open *Servers* and then *PostgreSQL Server*.
  Go to:
  
  ```Login/Group Roles -> Create -> Login/Group Role...```

  Create new user:
  ```
  General: Name: linkio_space_user

  Privileges:  Can login?        Yes.
               Superuser?        No.
               Create role?      Yes.
               Create database?  Yes.
               Update catalog?   No.
               Inherit rights from the parent roles?  Yes.
               Can initate streaming replication and backups? No.
  ```


  In pgAdmin open *Servers* and then *PostgreSQL Server*.

  Go to:
  ```Databases -> Create -> Database...```

  Create new database:
  ```
  General: Database: linkio_space
              Owner: linkio_space_user   

  Definition:  Tablespace:  pg_default
  ```
   
  Create database tables and import data. Copy the two scripts (```create_tables.sql``` and ```insert_data.sql``` ) from [here](https://github.com/desi109/linkio-space/tree/master/linkiospace-backend/src/main/resources/db_postgresql). 
  Go to ```Servers -> PostgreSQL Server -> Databases -> linkio_space -> Query Tool...```.
  Paste scripts and click button ```Execute/Refresh``` or clicl ```F5```.
   
   


  * ### For Linux
  [How to set up PostgreSQL server on Linux?](https://github.com/desi109/linux-cheat-sheet/blob/master/postgresql_setup)

  Start pgAdmin and run:
   ```sh
   cd linkiospace
   psql -h localhost -p 5432 -U postgres -f create_user_and_database.sql

   cd linkiospace-backend/src/main/resources/db_postgresql
   psql -U linkio_space_user -d linkio_space -f create_tables.sql
   psql -U linkio_space_user -d linkio_space -f insert_data.sql   
   ```
   
   The first script set up new role and create database:
   ```
   Role: linkio_space_user
   Password: 1234

   Database: linkio_space
   ```
   The other two scripts create database tables and insert all data.

3. Start the back-end of the project:
   ```sh
   cd linkiospace/linkiospace-backend
   mvn spring-boot:run
   ```
   It is running on ```localhost:8080```.

   To restart, first kill the process:
   ```sh
   kill -9 $(lsof -t -i:8080)   
   ```
   And run the previous command to start it again.

4. Start the front-end of the project:
   ```sh
   cd linkiospace/linkiospace-ui
   npm run serve
   ```
   It is running on ```localhost:8081```.

   To restart, first kill the process:
   ```sh
   kill -9 $(lsof -t -i:8081)   
   ```
   And run the previous command to start it again.

5. Everything is ready. Go to ```localhost:8081```. Enjoy!  😉
 


<!-- ROADMAP -->
## Roadmap

See the [open issues](https://github.com/desi109/linkio-space/issues) for a list of proposed features (and known issues).



<!-- LICENSE -->
## License

Distributed under the MIT License. See `LICENSE` for more information.



<!-- CONTACT -->
## Contact
[![LinkedIn][linkedin-shield]][linkedin-url] 

Project Link: [https://github.com/desi109/linkio-space](https://github.com/desi109/linko-space)




<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[contributors-shield]: https://img.shields.io/github/contributors/desi109/linkio-space.svg?style=for-the-badge
[contributors-url]: https://github.com/desi109/linkio-space/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/desi109/linkio-space.svg?style=for-the-badge
[forks-url]: https://github.com/desi109/linkio-space/network/members
[stars-shield]: https://img.shields.io/github/stars/desi109/linkio-space.svg?style=for-the-badge
[stars-url]: https://github.com/desi109/linkio-space/stargazers
[issues-shield]: https://img.shields.io/github/issues/desi109/linkio-space.svg?style=for-the-badge
[issues-url]: https://github.com/desi109/linkio-space/issues
[license-shield]: https://img.shields.io/github/license/desi109/linkio-space.svg?style=for-the-badge
[license-url]: https://github.com/desi109/linkio-space/blob/master/LICENSE.md
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555
[linkedin-url]: https://www.linkedin.com/in/desislava-milusheva-200574151
[product-screenshot-start-page-1]: images/screenshoots/screenshoot-start-page-1.png
[product-screenshot-start-page-2]: images/screenshoots/screenshoot-start-page-2.png
[product-screenshot-home-page]: images/screenshoots/screenshoot-home-page.png
[product-screenshot-sign-up-page]: images/screenshoots/screenshoot-sign-up-page.png
[product-screenshot-log-in-page]: images/screenshoots/screenshoot-log-in-page.png
[product-screenshot-admin-profil-page]: images/screenshoots/screenshoot-admin-profile-page.png
[product-screenshot-admin-profile-edit-page]: images/screenshoots/screenshoot-admin-profile-edit-page.png
[product-screenshot-admin-board-page]: images/screenshoots/screenshoot-admin-board-page.png
[product-screenshot-admin-board-delete-page]: images/screenshoots/screenshoot-admin-board-delete-page.png
[product-screenshot-user-profile-page]: images/screenshoots/screenshoot-user-profile-page.png
[product-screenshot-user-connections-board-page]: images/screenshoots/screenshoot-user-connections-board-page.png
[product-screenshot-user-connections-delete-board-page]: images/screenshoots/screenshoot-user-connections-delete-board-page.png
[product-screenshot-user-search-board-page]: images/screenshoots/screenshoot-user-search-board-page.png

