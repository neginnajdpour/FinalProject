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

DROP TABLE mft.BOOK;

SELECT * FROM BOOK;

CREATE TABLE MFT.BOOK (
    BOOK_ID INT PRIMARY KEY AUTO_INCREMENT,
    ISBN VARCHAR(50),
    RESOURCE_TYPE VARCHAR(50),
    TITLE VARCHAR(50),
    EDITION VARCHAR(50),
    AUTHOR VARCHAR(50),
    CATEGORY VARCHAR(50),
    PUBLISHER VARCHAR(50),
    LANGUAGE VARCHAR(50),
    QUANTITY INT,
    DESCRIPTION VARCHAR(50)
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

