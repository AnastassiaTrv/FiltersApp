delete from Property;
delete from Condition;
delete from Property_Condition;
delete from Filter;
delete from Fields_Group;
delete from Field;

insert into Property (id, name, data_type) values 
(1, 'Amount', 'number'),
(2, 'Title', 'text'),
(3, 'Date', 'date');

insert into Condition (id, rule) values 
(1, 'More'), 
(2, 'Less'),
(3, 'Equal'),
(4, 'Starts with'),
(5, 'Ends with'),
(6, 'Contains'),
(7, 'From'),
(8, 'Before');

insert into Property_Condition (id, property_id, contidion_id) values 
(1, 1, 1),
(2, 1, 2),
(3, 1, 3),
(4, 2, 3),
(5, 2, 4),
(6, 2, 5),
(7, 2, 6),
(8, 3, 3),
(9, 3, 7),
(10, 3, 8);

insert into Filter (id, name, static_field) values
(1, 'Test filter one', 'A'),
(2, 'Test filter two', 'B');

insert into Fields_Group (id, filter_id, name) values
(1, 1, 'Amount criteria'),
(2, 1, 'Arrival date criteria'),
(3, 2, 'Mixed criteria');

insert into Field (fields_group_id, property_condition_id, value_) values
(1, 1, '15'),
(1, 3, '15'),
(2, 9, '23.03.2023'),
(3, 3, '7'),
(3, 7, 'Meww'),
(3, 10, '20.10.2023');