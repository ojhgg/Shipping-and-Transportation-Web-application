create table courier
(
    boxname     varchar(20) null,
    servicename varchar(20) null,
    name        varchar(20) null,
    shipfrom    varchar(20) null,
    shipto      varchar(20) null,
    slug        varchar(20) not null
        primary key
);

create table courierservicetype
(
    isdomestic      varchar(20) null,
    servicename     varchar(20) not null
        primary key,
    servicetype     varchar(20) null,
    shipfromcountry varchar(20) null
);

create table item
(
    description varchar(20) null,
    itemid      varchar(20) not null
        primary key,
    price       varchar(20) null,
    quantity    mediumtext  null,
    weight      varchar(20) null
);

create table parcel
(
    boxtype     varchar(20) null,
    description varchar(20) null,
    dimension   varchar(20) null,
    itemsid     varchar(20) null,
    weight      varchar(20) null
);

create table shipment
(
    returnto    varchar(20) null,
    shipfrom    varchar(20) null,
    shipto      varchar(20) null,
    servicetype varchar(20) null,
    parcels     varchar(20) null
);

create table shipperaccount
(
    contactname varchar(20)  null,
    createdat   varchar(240) null,
    id          varchar(20)  not null
        primary key,
    password    varchar(255) not null,
    address     varchar(255) null
);

create table billing
(
    accountnumber varchar(20) null,
    servicetype          varchar(20) null,
    paidby        varchar(20) null,
    constraint billing_shipperaccount_id_fk
        foreign key (paidby) references shipperaccount (id)
);

create table user
(
    username varchar(20) null,
    password varchar(20) null
);


