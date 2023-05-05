insert into user_details(user_id, user_name, user_birthdate)
values (10001, 'Bobby', current_date());

insert into user_details(user_id, user_name, user_birthdate)
values (10002, 'Marty', current_date());

insert into user_details(user_id, user_name, user_birthdate)
values (10003, 'Jenny', current_date());

insert into post(id, description, user_user_id)
values (20001, 'I want learn AWS', 10001);

insert into post(id, description, user_user_id)
values (20002, 'I want learn Azure', 10002);

insert into post(id, description, user_user_id)
values (20003, 'I want learn Spring', 10003);

insert into post(id, description, user_user_id)
values (20004, 'I want to get the AWS cerificate', 10001);