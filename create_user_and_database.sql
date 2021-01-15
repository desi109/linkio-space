-- psql -h localhost -p 5432 -U postgres -f create_user_and_database.sql

-- Role: linkio_space_user
-- Password: 1234

DROP ROLE linkio_space_user;
CREATE ROLE linkio_space_user WITH
  LOGIN
  SUPERUSER
  INHERIT
  CREATEDB
  CREATEROLE
  NOREPLICATION
  ENCRYPTED PASSWORD 'SCRAM-SHA-256$4096:w67g5PKAxdPUKbN/LbokwA==$IKr9cYcEKHB4XuE+8cFdWNRpOrlhko8EpNCrkx7OdNo=:uvOhISVvWT5vK90bYAl6/OeZPFIRnQ12CGGh0GOowFs=';

GRANT postgres TO linkio_space_user WITH ADMIN OPTION;




-- Database: linkio_space

DROP DATABASE "linkio_space";
CREATE DATABASE "linkio_space"
    WITH 
    OWNER = linkio_space_user
    ENCODING = 'UTF8'
    CONNECTION LIMIT = -1;

