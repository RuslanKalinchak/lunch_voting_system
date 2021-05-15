DROP TABLE IF EXISTS user_roles CASCADE;
DROP TABLE IF EXISTS roles CASCADE;
DROP TABLE IF EXISTS users CASCADE;
DROP TABLE IF EXISTS foods CASCADE;
DROP TABLE IF EXISTS menu CASCADE;
DROP TABLE IF EXISTS restaurants CASCADE;

CREATE TABLE IF NOT EXISTS users
(
    user_id   INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
    user_name VARCHAR(MAX) NOT NULL,
    password  VARCHAR(MAX) NOT NULL
);

CREATE TABLE IF NOT EXISTS roles
(
    role_id INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name    VARCHAR(MAX) NOT NULL
);

CREATE TABLE IF NOT EXISTS user_roles
(
    user_id INT NOT NULL,
    role_id INT NOT NULL,

    FOREIGN KEY (user_id) REFERENCES users (user_id),
    FOREIGN KEY (role_id) REFERENCES roles (role_id),
    UNIQUE (user_id, role_id)
);

CREATE TABLE IF NOT EXISTS restaurants
(
    restaurant_id   INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
    restaurant_name VARCHAR(MAX) NOT NULL
);

CREATE TABLE IF NOT EXISTS menu
(
    menu_id       INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
    menu_name     VARCHAR(MAX) NOT NULL,
    menu_date     DATETIME     NOT NULL,
    restaurant_id INT          NOT NULL,
    CONSTRAINT menu_ibfk_1 FOREIGN KEY (restaurant_id) REFERENCES restaurants (restaurant_id)
);

CREATE TABLE IF NOT EXISTS foods
(
    food_id   INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
    food_name VARCHAR(MAX) NOT NULL,
    price     INT          NOT NULL,
    menu_id   INT          NOT NULL,
    CONSTRAINT foods_ibfk_1 FOREIGN KEY (menu_id) REFERENCES menu (menu_id)
);

INSERT INTO users
VALUES (1, 'admin@gmail.com', 'password');
INSERT INTO roles
VALUES (1, 'ROLE_ADMIN');
INSERT INTO roles
VALUES (2, 'ROLE_USER');
INSERT INTO user_roles
VALUES (1, 1);