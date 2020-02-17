create table TESIS_CUSTOMER_CAR_SERVICE_CENTER_LINK (
    CUSTOMER_ID varchar(36) not null,
    CAR_SERVICE_CENTER_ID varchar(36) not null,
    primary key (CUSTOMER_ID, CAR_SERVICE_CENTER_ID)
);
