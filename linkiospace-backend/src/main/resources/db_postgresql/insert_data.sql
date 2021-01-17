INSERT INTO roles (id, role_name )
VALUES
(1, 'ROLE_ADMIN'),
(2, 'ROLE_USER');


-- admin
-- email: admin@linkiospace.com
-- password: admin123

-- user
-- password: 12345678

INSERT INTO users (id, user_code, first_name, last_name, email, password, phone_number,
                    job_title, company_name, bio, website_portfolio_link)
VALUES
(1, '0001', 'Ivana', 'Ivanova', 'admin@linkiospace.com', '$2a$10$8lSwinKDVqyReiS2WyUs4OMZRG8TWLtg3YB0B7zMjEXxcdt9n4R6y', '0876623964', 'Developer', 'Linkio.Space', 'My name is Ivana and I am a Java Developer at Linkio.Space.', 'linkio.space'),
(2, '0002', 'Todor', 'Todorov', 'todor.todorov@gmail.com', '$2a$10$4K8Vq5mw.nwxl.WRmuYCfevme82c73uGkEcnPbmm/3/YJ3UToie7m', '0898623954', 'Senior Software Engineer', 'Soft GB', 'I am Todor Todorov and I work as Senior Software Engineer at Soft GB.', 'softgb.com'),
(3, '0003', 'Marina', 'Marinova', 'marina.marinova@gmail.com', '$2a$10$4K8Vq5mw.nwxl.WRmuYCfevme82c73uGkEcnPbmm/3/YJ3UToie7m', '0886233964',  'CEO', 'Dp. E.', 'I am Marina and I work for Dp. E. as a CEO. Our mission is to help people.', ''),
(4, '0004', 'Cveta', 'Cveteva', 'cveta.cveteva@gmail.com', '$2a$10$4K8Vq5mw.nwxl.WRmuYCfevme82c73uGkEcnPbmm/3/YJ3UToie7m', '0886623964', 'App Developer', 'App Me', '', 'app-me.com'),
(5, '0005', 'Boris', 'Borisov', 'boris.borisov@gmail.com', '$2a$10$4K8Vq5mw.nwxl.WRmuYCfevme82c73uGkEcnPbmm/3/YJ3UToie7m', '0886623964', 'HR', 'Best Credits', '', 'bestcredits.com'),
(6, '0006', 'Hristo', 'Hristov', 'hristo.hristov@gmail.com', '$2a$10$4K8Vq5mw.nwxl.WRmuYCfevme82c73uGkEcnPbmm/3/YJ3UToie7m', '0896623964', 'Junior Software Engineer', 'Cosmo', 'I am Hristo and I work as Junior Software Engineer.', 'cosmo.com'),
(7, '0007', 'Krasimir', 'Krasimirov', 'krasimir.krasimirov@gmail.com', '$2a$10$4K8Vq5mw.nwxl.WRmuYCfevme82c73uGkEcnPbmm/3/YJ3UToie7m', '0898623954', 'Senior Software Engineer', 'Soft GB', 'My name is Krasimir and I am a Senior Software Engineer.', '');

INSERT INTO users_roles (user_id, role_id)
VALUES
(1, 1), (2, 2), (3, 2), (4, 2), (5, 2), (6, 2);

INSERT INTO connections (id, user_one_id, user_two_id, connection_date )
VALUES
(1, 1, 2, '15-01-2020'),
(2, 1, 5, '15-01-2020'),
(3, 2, 1, '15-01-2020'),
(4, 2, 3, '15-01-2020'),
(5, 2, 4, '15-01-2020'),
(6, 3, 5, '15-01-2020'),
(7, 3, 6, '15-01-2020'),
(8, 4, 3, '15-01-2020'),
(9, 4, 5, '15-01-2020'),
(10, 4, 6, '15-01-2020'),
(11, 5, 2, '15-01-2020'),
(12, 5, 3, '15-01-2020'),
(13, 5, 6, '15-01-2020'),
(14, 6, 3, '15-01-2020'),
(15, 6, 4, '15-01-2020');

INSERT INTO users_connections (user_id, connection_id)
VALUES
(1, 1), (1, 2), (2, 3), (2, 4), (2, 5), (3, 6), (3, 7), (4, 8), (4, 9), (4, 10), (5, 11),
(5, 12),(5, 13), (6, 14), (6, 15);

SELECT setval('users_id_seq', (SELECT MAX (id)+1 FROM users), false);
SELECT setval('roles_id_seq', (SELECT MAX (id)+1 FROM roles), false);
SELECT setval('connections_id_seq', (SELECT MAX (id)+1 FROM connections), false);