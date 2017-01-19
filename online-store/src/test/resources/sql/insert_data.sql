-- ----------------------------------------------
-- add few addresses
INSERT INTO address (id, street, street_number, door_number, zip_code, city) VALUES (1, 'Koszycka', '6A', '25', '01-446', 'Warsaw');

-- add few customers
INSERT INTO customer (id, first_name, last_name, birth_date, billing_address_id, phone_number, number_of_orders) VALUES (1, 'Michal', 'Abacki', '1990-01-20', 1, '111222333', 1);

-- add few accounts
INSERT INTO account (id, username, password, enabled, email, date_created, role, customer_id) VALUES (1, 'aaa', '111', 1, 'a1@gmail.com', TIMESTAMP '2015-01-10 10:20:30', 'ROLE_USER', 1);