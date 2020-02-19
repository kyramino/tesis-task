-- begin TESIS_EMPLOYEE
create table TESIS_EMPLOYEE (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    FIRST_NAME varchar(255),
    SECOND_NAME varchar(255),
    BIRTH_DATE date,
    EMAIL varchar(255),
    SALARY decimal(19, 2),
    CENTER_ID varchar(36) not null,
    --
    primary key (ID)
)^
-- end TESIS_EMPLOYEE
-- begin TESIS_CITY
create table TESIS_CITY (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255) not null,
    CODE bigint,
    --
    primary key (ID)
)^
-- end TESIS_CITY
-- begin TESIS_CAR_SERVICE_CENTER
create table TESIS_CAR_SERVICE_CENTER (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255) not null,
    CREATOR_ID varchar(36) not null,
    PHONE varchar(255),
    CITY_ID varchar(36),
    ADDRESS varchar(255),
    --
    primary key (ID)
)^
-- end TESIS_CAR_SERVICE_CENTER
-- begin TESIS_REPAIR
create table TESIS_REPAIR (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    DESCRIPTION varchar(255) not null,
    CENTER_ID varchar(36),
    EMPLOYEE_ID varchar(36),
    --
    primary key (ID)
)^
-- end TESIS_REPAIR
-- begin TESIS_CUSTOMER
create table TESIS_CUSTOMER (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    DTYPE varchar(31),
    --
    NAME varchar(255) not null,
    PHONE varchar(255),
    EMAIL varchar(255),
    --
    primary key (ID)
)^
-- end TESIS_CUSTOMER
-- begin TESIS_CAR_SERVICE_CENTER_CUSTOMER_LINK
create table TESIS_CAR_SERVICE_CENTER_CUSTOMER_LINK (
    CAR_SERVICE_CENTER_ID varchar(36) not null,
    CUSTOMER_ID varchar(36) not null,
    primary key (CAR_SERVICE_CENTER_ID, CUSTOMER_ID)
)^
-- end TESIS_CAR_SERVICE_CENTER_CUSTOMER_LINK
-- begin TESIS_CUSTOMER_INDIVIDUAL
create table TESIS_CUSTOMER_INDIVIDUAL (
    customer_id varchar(36) not null,
    --
    PASSPORT_NO varchar(255) not null,
    --
    primary key (customer_id)
)^
-- end TESIS_CUSTOMER_INDIVIDUAL
-- begin TESIS_CUSTOMER_COMPANY
create table TESIS_CUSTOMER_COMPANY (
    customer_id varchar(36) not null,
    --
    INN varchar(255),
    --
    primary key (customer_id)
)^
-- end TESIS_CUSTOMER_COMPANY
