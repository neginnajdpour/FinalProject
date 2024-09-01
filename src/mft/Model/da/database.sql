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
