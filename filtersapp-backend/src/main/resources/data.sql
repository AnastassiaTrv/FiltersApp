delete from Filter;
delete from Filter_Field;
delete from Property;
delete from Condition;
delete from Property_Condition;

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

insert into Property_Condition (id, property_id, condition_id) values 
(1, 1, 1),
(2, 1, 2),
(3, 1, 3),
(4, 2, 4),
(5, 2, 5),
(6, 2, 6),
(7, 2, 3),
(8, 3, 7),
(9, 3, 8),
(10, 3, 3);

insert into Filter (id, name, some_optional_value) values
(1, 'Test filter 1', 'A'),
(2, 'Test filter 2', null);

insert into Filter_Field (id, filter_id, property_id, condition_id, value_) values
(1, 1, 1, 1, '15'),
(2, 1, 1, 2, '15'),
(3, 1, 2, 5, 'Meww'),
(4, 1, 3, 8, '2023-03-29'),
(5, 2, 2, 3, 'A'),
(6, 2, 2, 6, 'Meww');
