create table activity_logs (
                               id bigserial primary key,
                               book_name varchar(255) not null,
                               event_type varchar(50) not null,
                               event_time timestamp not null default now()
);