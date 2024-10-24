CREATE DATABASE TestDB;
CREATE USER 'USER_OPOS'@'localhost' IDENTIFIED BY 'westerlon';

SHOW GRANTS FOR 'OPO_DB'@'localhost';
UPDATE mysql.user SET Host='%' WHERE Host='localhost';
FLUSH PRIVILEGES;


CREATE TABLE Person (
  id int AUTO_INCREMENT PRIMARY KEY,
  name varchar(20),
  country varchar(20)
);


CREATE TABLE cuenta
(
    id int AUTO_INCREMENT PRIMARY KEY,
    numerocuenta text,
    id_person int,
FOREIGN KEY (id_person) REFERENCES Person(id)
);

GRANT SELECT,INSERT,UPDATE,DELETE ON Person TO 'USER_OPOS'@'localhost';
