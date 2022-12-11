insert into categories (title) values
                                   ('Food'),
                                   ('Electronic');

insert into product (title, price, category_id) values
                                       ('Bread', 32.00, 1),
                                       ('Milk', 120.00, 1),
                                       ('Butter', 320.00, 1),
                                       ('Cheese', 500.00, 1);

insert into roles (name)
values ('ROLE_USER'),
       ('ROLE_ADMIN');

insert into users (username, password, email)
values ('bob', '$2a$04$Fx/SX9.BAvtPlMyIIqqFx.hLY2Xp8nnhpzvEEVINvVpwIPbA3v/.i', 'bob_johnson@gmail.com'),
       ('john', '$2a$04$Fx/SX9.BAvtPlMyIIqqFx.hLY2Xp8nnhpzvEEVINvVpwIPbA3v/.i', 'john_johnson@gmail.com');

insert into users_roles (user_id, role_id)
values (1, 1),
       (2, 2);