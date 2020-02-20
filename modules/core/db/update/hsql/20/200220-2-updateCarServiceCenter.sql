update TESIS_CAR_SERVICE_CENTER set CREATOR_ID = '60885987-1b61-4247-94c7-dff348347f93' where CREATOR_ID is null ;
alter table TESIS_CAR_SERVICE_CENTER alter column CREATOR_ID set not null ;
