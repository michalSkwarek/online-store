
-- add few categories
INSERT INTO category (id, name) VALUES (1, "smartphone");
INSERT INTO category (id, name) VALUES (2, "PC");
INSERT INTO category (id, name) VALUES (3, "console");

-- add few manufacturers
INSERT INTO manufacturer (id, brand, website) VALUES (1, "Apple", "http://www.apple.com");
INSERT INTO manufacturer (id, brand, website) VALUES (2, "Samsung", "http://www.samsung.com");
INSERT INTO manufacturer (id, brand, website) VALUES (3, "Dell", "http://www.dell.com");
INSERT INTO manufacturer (id, brand, website) VALUES (4, "Sony", "http://www.sony.com");

-- add few products
INSERT INTO product (id, model, unit_price, category_id, manufacturer_id) VALUES (1, "iPhone 7 Plus", 4479, 1, 1);
INSERT INTO product (id, model, unit_price, category_id, manufacturer_id) VALUES (2, "iPhone 7", 3879, 1, 1);
# INSERT INTO product (id, model, unit_price, manufacturer_id, category_id, specifications_id) VALUES (3, "280 G1 MT", 1199, 3, 2, 3);
# INSERT INTO product (id, model, unit_price, manufacturer_id, category_id, specifications_id) VALUES (4, "Vostro 3900", 1799, 3, 2, 4);
# INSERT INTO product (id, model, unit_price, manufacturer_id, category_id, specifications_id) VALUES (5, "PlayStation 4", 1279, 4, 3, 5);