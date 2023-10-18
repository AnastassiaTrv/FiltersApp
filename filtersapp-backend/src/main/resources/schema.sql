create table if not exists Filter (
    id identity,
    name varchar(50) not null,
    static_field varchar(50) not null
);

create table if not exists Fields_Group (
    id identity,
    filter_id bigint not null,
    name varchar(50) not null
);

create table if not exists Field (
    id identity,
    fields_group_id bigint not null,
    property_condition_id bigint not null,
    value_ varchar(50)
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
    contidion_id bigint not null
);

alter table Fields_Group add foreign key (filter_id) references Filter(id);
alter table Field add foreign key (fields_group_id) references Fields_Group(id);
alter table Field add foreign key (property_condition_id) references Property_Condition(id);
alter table Property_Condition add foreign key (property_id) references Property(id);
alter table Property_Condition add foreign key (contidion_id) references Condition(id);