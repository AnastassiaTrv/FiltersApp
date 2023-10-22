create table if not exists Filter (
    id identity,
    name varchar(50) not null,
    some_optional_value varchar(50) null
);

create table if not exists Filter_Field (
    id identity,
    filter_id bigint null,
    property_id bigint not null,
    condition_id bigint not null,
    value_ varchar(50) not null
);

create table if not exists Property (
    id identity,
    name varchar(50),
    data_type ENUM('text', 'number', 'date')
);

create table if not exists Condition (
    id identity,
    rule varchar(50)
);

create table if not exists Property_Condition (
    id identity,
    property_id bigint not null,
    condition_id bigint not null
);

create sequence if not exists filter_seq start with 3;
create sequence if not exists field_seq start with 7;

alter table Filter_Field add foreign key (filter_id) references Filter(id);
alter table Filter_Field add foreign key (property_id) references Property(id);
alter table Filter_Field add foreign key (condition_id) references Condition(id);
alter table Property_Condition add foreign key (property_id) references Property(id);
alter table Property_Condition add foreign key (condition_id) references Condition(id);