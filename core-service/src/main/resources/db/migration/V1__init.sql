create table categories (
                            id          bigserial primary key,
                            title       varchar(255),
                            created_at  timestamp default current_timestamp,
                            updated_at  timestamp default current_timestamp
);

create table product (
                         id          bigserial primary key,
                         title       varchar(255),
                         price       numeric(8, 2),
                         category_id bigint references categories (id),
                         created_at  timestamp default current_timestamp,
                         updated_at  timestamp default current_timestamp
);

create table users (
                       id         bigserial primary key,
                       username   varchar(36) not null,
                       password   varchar(80) not null,
                       email      varchar(50) unique,
                       created_at timestamp default current_timestamp,
                       updated_at timestamp default current_timestamp
);

create table roles (
                       id         bigserial primary key,
                       name       varchar(50) not null,
                       created_at timestamp default current_timestamp,
                       updated_at timestamp default current_timestamp
);

create table users_roles (
                             user_id bigint not null references users (id),
                             role_id bigint not null references roles (id),
                             primary key (user_id, role_id)
);

create table  orders(
                            id          bigserial primary key,
                            user_id     bigint not null references users (id),
                            total_price numeric(8, 2) not null,
--                             address     varchar(255),
--                             phone       varchar(255),
                            created_at  timestamp default current_timestamp,
                            updated_at  timestamp default current_timestamp
);

create table  order_items(
                        id                bigserial primary key,
                        product_id        bigint not null references product (id),
                        order_id          bigint not null references orders (id),
                        quantity          int not null,
                        price_per_product numeric(8, 2) not null,
                        price             numeric(8, 2) not null,
                        created_at        timestamp default current_timestamp,
                        updated_at        timestamp default current_timestamp
);



