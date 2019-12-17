delete
from application;
delete
from user;
delete
from event;

insert into application (id,name,created_date)
values (1,'Windows',now());


insert into user (id,
                   name,
                   password,
                   email,
                  created_date
                  )
values (1,
        'Guilherme',
        'senha',
        'email@email.com',
        now());


insert into event (id,
                   description,
                   source,
                   details,
                   status,
                   environment,
                   level,
                   category,
                   user_id,
                   application_id,
                   created_date
                   )
values (1,
        'Texto description',
        'Texto source',
        'Texto details',
        1,
        1,
        1,
        1,
        1,
        1,
        now());


