create database mft;

create table mft.PROFILE_TBL
(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name NVARCHAR(20) not null,
    family NVARCHAR(20) not null,
    username NVARCHAR(20) not null,
    password NVARCHAR(20) not null,
    active tinyint
);

CREATE TABLE BOOK (
    BOOK_ID INT PRIMARY KEY AUTO_INCREMENT,
    TITLE NVARCHAR(50) NOT NULL,
    EDITION NVARCHAR(50),
    AUTHOR NVARCHAR(50) NOT NULL ,
    GENRE NVARCHAR(50),
    PUBLISHER NVARCHAR(50),
    PUBLSHED_YEAR NVARCHAR(4),
    AVAILABLE_COPIES INT
);
