create table if not exists Filter (
    id identity,
    description varchar(50) null
);

create table if not exists Field_Metadata (
    id identity,
    group_id bigint not null,
    name varchar(50) not null,
    type ENUM('text', 'selection', 'multi_value'),
    required boolean not null default false
);

create table if not exists Filter_Field (
    id identity,
    filter_id bigint not null,
    metadata_id bigint not null,
    property_condition_id bigint null,
    value_ varchar(50) null
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

alter table Filter_Field add foreign key (filter_id) references Filter(id);
alter table Filter_Field add foreign key (metadata_id) references Field_Metadata(id);
alter table Filter_Field add foreign key (property_condition_id) references Property_Condition(id);
alter table Property_Condition add foreign key (property_id) references Property(id);
alter table Property_Condition add foreign key (condition_id) references Condition(id);