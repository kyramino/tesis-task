alter table TESIS_CUSTOMER alter column INN rename to INN__U71711 ^
alter table TESIS_CUSTOMER alter column PASSPORT_NO rename to PASSPORT_NO__U63971 ^
alter table TESIS_CUSTOMER alter column PASSPORT_NO__U63971 set null ;
alter table TESIS_CUSTOMER alter column DTYPE set data type varchar(31) ;
