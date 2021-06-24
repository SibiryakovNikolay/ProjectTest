create table securities
(
    id            int primary key,
    secid         varchar not null unique,
    regnumber     varchar,
    name          varchar,
    emitent_title varchar
);

create table history
(
    secid      varchar,
    tradedate  varchar,
    numtrades  varchar,
    open       varchar,
    close      varchar,
    foreign key (secid) references securities(secid) ON DELETE CASCADE on UPDATE CASCADE
);
