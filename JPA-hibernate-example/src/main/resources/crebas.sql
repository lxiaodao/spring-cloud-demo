/*==============================================================*/
/* DBMS name:      PostgreSQL 9.x                               */
/* Created on:     7/30/2019 4:40:24 PM                         */
/*==============================================================*/


drop table PRODUCT;

drop table PRODUCT_TYPE;


drop table USER_ROLE;

drop table ROLE;

drop table SAAS_USER;



/*==============================================================*/
/* Table: PRODUCT                                               */
/*==============================================================*/
create table PRODUCT (
   ID                   SERIAL               not null,
   PRODUCT_TYPE         INT4                 null,
   NAME                 varchar(50)          null,
   RETAIL_PRICE         DECIMAL(8,2)         null,
   COST_PRICE           DECIMAL(8,2)         null,
   CREATE_TIME          TIMESTAMP            null,
   constraint PK_PRODUCT primary key (ID)
);

/*==============================================================*/
/* Table: PRODUCT_TYPE                                          */
/*==============================================================*/
create table PRODUCT_TYPE (
   ID                   SERIAL               not null,
   NAME                 varchar(50)          null,
   constraint PK_PRODUCT_TYPE primary key (ID)
);

/*==============================================================*/
/* Table: ROLE                                                  */
/*==============================================================*/
create table ROLE (
   ID                   SERIAL               not null,
   NAME                 VARCHAR(20)          null,
   TYPE                 INT2                 null,
   URL                  varchar(200)         null,
   constraint PK_ROLE primary key (ID)
);

/*==============================================================*/
/* Table: SAAS_USER                                             */
/*==============================================================*/
create table SAAS_USER (
   ID                   SERIAL               not null,
   USERNAME             VARCHAR(50)          null,
   PASSWORD             VARCHAR(200)         null,
   EMAIL                VARCHAR(20)          null,
   NUMBER               INT2                 null,
   constraint PK_SAAS_USER primary key (ID)
);

/*==============================================================*/
/* Table: USER_ROLE                                             */
/*==============================================================*/
create table USER_ROLE (
   USER_ID              INT4                 not null,
   ROLE_ID              INT4                 not null,
   constraint PK_USER_ROLE primary key (USER_ID, ROLE_ID)
);

alter table PRODUCT
   add constraint FK_PRODUCT_REFERENCE_PRODUCT_ foreign key (PRODUCT_TYPE)
      references PRODUCT_TYPE (ID)
      on delete restrict on update restrict;

alter table USER_ROLE
   add constraint FK_USER_ROL_REFERENCE_SAAS_USE foreign key (USER_ID)
      references SAAS_USER (ID)
      on delete restrict on update restrict;

alter table USER_ROLE
   add constraint FK_USER_ROL_REFERENCE_ROLE foreign key (ROLE_ID)
      references ROLE (ID)
      on delete restrict on update restrict;

