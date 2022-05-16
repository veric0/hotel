USE hotel_database;

CREATE TABLE IF NOT EXISTS users (
    user_id     BIGINT PRIMARY KEY AUTO_INCREMENT ,
    full_name   NVARCHAR(50)    NOT NULL ,
    email       NVARCHAR(80)    NOT NULL ,
    phone       NVARCHAR(20)    NOT NULL
);

CREATE TABLE IF NOT EXISTS manager (
    manager_id     BIGINT PRIMARY KEY AUTO_INCREMENT ,
    login       NVARCHAR(50)    NOT NULL ,
    passphrase  NVARCHAR(50)    NOT NULL
);

CREATE TABLE IF NOT EXISTS room_type (
    room_type_id    BIGINT PRIMARY KEY AUTO_INCREMENT ,
    type_name   NVARCHAR(50)    NOT NULL ,
    capacity    INT     NOT NULL DEFAULT 1,
    price       INT     NOT NULL
# img
# description
);

CREATE TABLE IF NOT EXISTS room (
    room_number BIGINT PRIMARY KEY AUTO_INCREMENT ,
    room_type_id BIGINT ,
    FOREIGN KEY (room_type_id) REFERENCES room_type(room_type_id)
);

CREATE TABLE IF NOT EXISTS booking_status (
    booking_status_id    BIGINT PRIMARY KEY AUTO_INCREMENT ,
    status_name   ENUM('EMPTY', 'RESERVED', 'PAID', 'CANCELED', 'EXPIRED') NOT NULL
);

CREATE TABLE IF NOT EXISTS booking (
    booking_id BIGINT PRIMARY KEY AUTO_INCREMENT ,
    room_number BIGINT ,
    FOREIGN KEY (room_number) REFERENCES room(room_number) ,
    user_id     BIGINT ,
    FOREIGN KEY (user_id) REFERENCES users(user_id) ,
    check_in    DATE NOT NULL DEFAULT (CURDATE()),
    check_out   DATE NOT NULL DEFAULT (DATE_ADD(CURDATE(),INTERVAL 1 DAY)) ,
    num_of_people INT NOT NULL DEFAULT 1,
    booking_status_id BIGINT ,
    FOREIGN KEY (booking_status_id) REFERENCES booking_status(booking_status_id)
);
