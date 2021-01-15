--  psql -U linkio_space_user -d linkio_space -f create_tables.sql
--  psql -U linkio_space_user -d linkio_space -f insert_data.sql


DROP TABLE IF EXISTS users_connections;
DROP TABLE IF EXISTS users_roles;
DROP TABLE IF EXISTS connections;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS roles;

CREATE TABLE IF NOT EXISTS roles (
    id SERIAL PRIMARY KEY,
    role_name VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS users (
    id SERIAL NOT NULL PRIMARY KEY ,
    user_code VARCHAR(4) NOT NULL,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
    password VARCHAR(250) NOT NULL,
    phone_number VARCHAR(15) NOT NULL,
    job_title VARCHAR(100) NOT NULL,
    company_name VARCHAR(100) NOT NULL,
    bio VARCHAR(1000),
    website_portfolio_link VARCHAR(256)
);

CREATE TABLE IF NOT EXISTS users_roles (
    user_id BIGINT NOT NULL,
    role_id   BIGINT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (role_id) REFERENCES roles(id)
    );


CREATE TABLE IF NOT EXISTS connections (
    id SERIAL NOT NULL PRIMARY KEY ,
    user_one_id BIGINT NOT NULL,
    user_two_id BIGINT NOT NULL,
    connection_date DATE NOT NULL,
    FOREIGN KEY (user_one_id) REFERENCES users(id)
    );

CREATE TABLE IF NOT EXISTS users_connections (
    user_id BIGINT NOT NULL,
    connection_id BIGINT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (connection_id) REFERENCES connections(id)
);


