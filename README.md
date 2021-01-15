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
    Linkio.Space is a web application that allows you to keep all your connections with people and their business cards. <br>You can easily and quickly add new links. All your business cards are stored and updated at any time.
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
    <li><a href="#usage">Usage</a></li>
    <li><a href="#roadmap">Roadmap</a></li>
    <li><a href="#license">License</a></li>
    <li><a href="#contact">Contact</a></li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## About The Project
[![Product Name Screen Shot][product-screenshot]](https://linkio.space)

Here's a blank template to get started:
**To avoid retyping too much info. Do a search and replace with your text editor for the following:** 
`github_username`, `repo_name`, `twitter_handle`, `email`, `project_title`, `project_description`


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
* [ApacheMaven 3.6.3](https://maven.apache.org/download.cgi)
  ```sh
  mvn -v
  ```
* [PostgreSQL 12.4](https://www.enterprisedb.com/downloads/postgres-postgresql-downloads)
* [pgAdmin 4](https://www.pgadmin.org/download/)
* [Node.js v12.18](https://nodejs.org/en/download/)
  ```sh
  node -v
  ```
* NPM 6.14
  ```sh
  npm -v
  ```
* [Vue](https://vuejs.org/v2/guide/installation.html)
  ```sh
  npm install vue
  vue -V
  ```
* [Vue CLI](https://cli.vuejs.org/guide/installation.html)
  ```sh
  npm install -g @vue/cli
  ```




### Installation

1. Clone the repo:
   ```sh
   git clone https://github.com/desi109/linkio-space.git
   ```

2. Set up the database fot the project
  * ### For Windows
  * ### For Linux
  
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
4. Start the front-end of the project:
   ```sh
   cd linkiospace/linkiospace-ui
   npm run serve
   ```
   It is running on ```localhost:8081```.
   
5. Everything is ready. Go to ```localhost:8081```. Enjoy!  😉
 


<!-- USAGE EXAMPLES -->
## Usage

Use this space to show useful examples of how a project can be used. Additional screenshots, code examples and demos work well in this space. You may also link to more resources.

_For more examples, please refer to the [Documentation](https://example.com)_



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
[product-screenshot]: images/screenshoots/screenshoot-start-page-1.png

