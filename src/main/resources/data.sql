insert into roles(name)
select 'ROLE_USER' as name 
where NOT EXISTS(select 1 from roles where name='ROLE_USER');
--insert adm rol
insert into roles(name)
select 'ROLE_ADMIN' as name 
where NOT EXISTS(select 1 from roles where name='ROLE_ADMIN');
--insert gm rol
insert into roles(name)
select 'ROLE_GM' as name 
where NOT EXISTS(select 1 from roles where name='ROLE_GM');
--register user
insert into users(email, password, username)
select
'example@gmail.com' as email,
--this password is: eee123
'$2a$10$26pJhpM9opbsoTyJt2EdK.GNvG0S2B4jHoa3W1vkJiwY.KHGnQAO6' as password,
'admin' as username
where not exists(select 1 from users where id=1 AND username='admin');
--register user with role
insert into user_roles(user_id, role_id)
select
1 as user_id,
(select id from roles where name = 'ROLE_ADMIN') as role_id
where not exists(select 1 from user_roles ur where ur.user_id = 1);
