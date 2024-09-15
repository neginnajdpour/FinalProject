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


CREATE TABLE MFT.RESOURCE (
    ISBN INT PRIMARY KEY,
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

create table member (
                        NationalID INT PRIMARY KEY,
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


