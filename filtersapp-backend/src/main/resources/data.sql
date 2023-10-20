delete from Filter;
delete from Field_Metadata;
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
(4, 2, 3),
(5, 2, 4),
(6, 2, 5),
(7, 2, 6),
(8, 3, 3),
(9, 3, 7),
(10, 3, 8);

insert into Filter (id, description) values
(1, 'Any description ..'),
(2, 'Any other description ..');

insert into Field_Metadata (id, group_id, name, type) values
(1, 1, 'Name', 'text'),
(2, 1, 'Criteria', 'multi_value'),
(3, 1, 'Selection', 'selection'),
(4, 2, 'List', 'multi_value'),
(5, 2, 'Title', 'text');

insert into Filter_Field (id, filter_id, metadata_id, property_condition_id, value_) values
(1, 1, 1, null, 'Test filter one'),
(2, 1, 2, 1, '15'),
(3, 1, 2, 3, '15'),
(4, 1, 2, 6, 'Meww'),
(5, 1, 2, 10, '23.03.2023'),
(6, 1, 3, null, 'A'),
(7, 2, 4, 6, 'Meww'),
(8, 2, 5, null, 'Test filter two');
