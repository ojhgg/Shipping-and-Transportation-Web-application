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
    description   varchar(255) null,
    descriptioncn varchar(255) null,
    hscode        varchar(255) null,
    itemid        varchar(255) not null
        primary key,
    originCountry varchar(255) null,
    price         varchar(255) null,
    quantity      varchar(255) null,
    sku           varchar(255) null,
    weight        varchar(255) null
);

create table parcel
(
    boxtype     varchar(255) null,
    description varchar(255) null,
    dimension   varchar(255) null,
    parcelsid   varchar(255) null,
    weight      varchar(255) null,
    quantity    varchar(255) null
);

create table role
(
    id   bigint                                             null,
    name enum ('ROLE_USER', 'ROLE_MODERATOR', 'ROLE_ADMIN') null
);

create table shipment
(
    returnto    varchar(255) null,
    shipfrom    varchar(255) null,
    shipto      varchar(255) null,
    servicetype varchar(255) null,
    parcels     varchar(255) not null
        primary key,
    updateat    varchar(255) null
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
    type          varchar(20) null,
    paidby        varchar(20) null,
    constraint billing_shipperaccount_id_fk
        foreign key (paidby) references shipperaccount (id)
);

create table user
(
    username varchar(20)  null,
    password varchar(120) null,
    id       int          not null
        primary key,
    email    varchar(50)  null,
    constraint UKob8kqyqqgmefl0aco34akdtpe
        unique (email),
    constraint UKsb8bbouer5wak8vyiiy4pf2bx
        unique (username)
);

create table user_roles
(
    user_id bigint not null,
    role_id int    not null,
    primary key (user_id, role_id)
);


