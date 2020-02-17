alter table TESIS_CUSTOMER_INDIVIDUAL add constraint FK_TESIS_CUSTOMER_INDIVIDUAL_ON_CUSTOMER foreign key (customer_id) references TESIS_CUSTOMER(ID) on delete CASCADE;
