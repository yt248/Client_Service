insert into clients (name, surname)
VALUES ('Bob', 'Tomas'),
       ('Tom', 'Petrov'),
       ('Maria', 'Ivanova');

insert into orders (description, sum, client_id)
VALUES ('by phone', 1200, 2),
       ('laptop samsung', 2500.50, 2),
       ('laptop dell', 3000, 1),
       ('lamp', 950, 1),
       ('table', 400, 3),
       ('chair', 200, 3);