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

DROP TABLE BOOK;

SELECT * FROM BOOK;

CREATE TABLE MFT.BOOK (
    BOOK_ID INT PRIMARY KEY AUTO_INCREMENT,
    TITLE NVARCHAR(50) NOT NULL,
    EDITION NVARCHAR(50),
    AUTHOR NVARCHAR(50) NOT NULL ,
    GENRE NVARCHAR(50),
    PUBLISHER NVARCHAR(50),
    PUBLSHED_YEAR NVARCHAR(4),
    AVAILABLE_COPIES INT,
    BDESCRIPTION NVARCHAR(500)
);
insert into(TITLE , EDITION , AUTHOR , GENRE , PUBLISHER , PUBLSHED_YEAR , AVAILABLE_COPIES, BDESCRIPTION)

DROP TABLE member;
create table member (
                        memberID INT PRIMARY KEY AUTO_INCREMENT,
                        FIRSTNAME NVARCHAR(50),
                        LastName NVARCHAR(50),
                        PhoneNumber NVARCHAR(50),
                        Email NVARCHAR(50),
                        addressLine1 nvarchar(100),
                        addressLine2 nvarchar(100),
                        city nvarchar(50),
                        state nvarchar(50),
                        country nvarchar(50),
                        postalcode nvarchar(50),
                        Photo NVARCHAR(50)
);
INSERT INTO member(FirstName , LastName , PhoneNumber , Email , addressLine1 , addressLine2 , city , state , country , postalcode , Photo )
VALUES (?,?,?,?,?,?,?,?,?,?,?)

