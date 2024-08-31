create table PROFILE_TBL AS (
    id  NUMBER PRIMARY KEY,
    name NVARCHAR2(20) not null,
    family NVARCHAR2(20) not null,
    username NVARCHAR2(20) not null,
    password NVARCHAR2(20) not null
);
