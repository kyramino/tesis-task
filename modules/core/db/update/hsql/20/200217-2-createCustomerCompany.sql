alter table TESIS_CUSTOMER_COMPANY add constraint FK_TESIS_CUSTOMER_COMPANY_ON_CUSTOMER foreign key (customer_id) references TESIS_CUSTOMER(ID) on delete CASCADE;
