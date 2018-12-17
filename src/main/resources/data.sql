INSERT INTO
USERS
(USERNAME, PASSWORD, ROLES)
VALUES
('vokhanhhuy', '$2a$10$FebcGKzwfzOVubMxbUsar.KjnjB/9qk0bRNL/a5uBERwBcXGDVD0.', 'ROLE_ADMIN'), -- password before BCrypt = admin123
('micheal', '$2a$10$ctO0n2wN28BXSA73U3DzruSWoSIL01Ww4oKz9fhpbAPaMN5bsOYfK', 'ROLE_USER'), -- password before BCrypt = 123456
('analyzer', '$2a$10$pu.8LcXf2rMXqsY7TWZ5j.ByG2rIOyqn.RDlvB.9xmZwJ6ZNOaESW', 'ROLE_ACTUATOR'); -- password before BCrypt = 999999
