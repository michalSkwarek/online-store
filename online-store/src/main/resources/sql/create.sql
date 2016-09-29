-- ----------------------------------------------
-- add few operating systems
INSERT INTO os (id, name, version) VALUES (1, "iOS", "10");
INSERT INTO os (id, name, version) VALUES (2, "Android", "6.0");
INSERT INTO os (id, name, version) VALUES (3, "Microsoft Windows", "7");

-- add few operating batteries
INSERT INTO battery (id, capacity, type) VALUES (1, 2910, "Li-Ion");
INSERT INTO battery (id, capacity, type) VALUES (2, 3600, "Li-Ion");

-- add few operating displays
INSERT INTO display (id, diagonal, width_in_pixels, height_in_pixels) VALUES (1, 5.5, 1920, 1080);
INSERT INTO display (id, diagonal, width_in_pixels, height_in_pixels) VALUES (2, 5.5, 2560, 1440);

-- add few gpu
INSERT INTO gpu (id, model) VALUES (1, "Mali-T880 MP12");

-- add few cpu
INSERT INTO cpu (id, model, number_of_cores, low_clock_speed) VALUES (1, "Apple A10", 4, 2.4);
INSERT INTO cpu (id, model, number_of_cores, low_clock_speed, high_clock_speed) VALUES (2, "Samsung Exynos 8890", 8, 1.6, 2.3);

-- add few specifications
INSERT INTO specifications (id, cpu_id, ram, disk, display_id, battery_id, os_id) VALUES (1, 1, 3, 128, 1, 1, 1);
INSERT INTO specifications (id, cpu_id, gpu_id, ram, disk, display_id, battery_id, os_id) VALUES (2, 2, 1, 4, 32, 2, 2, 2);
# INSERT INTO specifications (id, display_id, battery_id, os_id, weight) VALUES (1, 1, 1, 1, 189);
# INSERT INTO specifications (id, display_id, battery_id, os_id, weight) VALUES (2, 2, 2, 1, 138);
# INSERT INTO specifications (id, power_supply, os_id, weight) VALUES (3, 180, 3, 7000);
# INSERT INTO specifications (id, power_supply, os_id, weight) VALUES (4, 300, 3, 10000);
# INSERT INTO specifications (id, weight) VALUES (5, 2900);

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
INSERT INTO product (id, model, unit_price, category_id, manufacturer_id, specifications_id) VALUES (1, "iPhone 7 Plus", 4479, 1, 1, 1);
INSERT INTO product (id, model, unit_price, category_id, manufacturer_id, specifications_id) VALUES (2, "Galaxy S7 edge", 3398, 1, 2, 2);
# INSERT INTO product (id, model, unit_price, category_id, manufacturer_id, specifications_id) VALUES (3, "280 G1 MT", 1199, 2, 3, 3);
# INSERT INTO product (id, model, unit_price, category_id, manufacturer_id, specifications_id) VALUES (4, "Vostro 3900", 1799, 2, 3, 4);
# INSERT INTO product (id, model, unit_price, category_id, manufacturer_id, specifications_id) VALUES (5, "PlayStation 4", 1279, 3, 4, 5);
INSERT INTO product (id, model, unit_price, category_id, manufacturer_id) VALUES (6, "abc", 1000, 1, 2);
INSERT INTO product (id, model, unit_price, category_id, manufacturer_id) VALUES (7, "klm", 2000, 1, 3);
INSERT INTO product (id, model, unit_price, category_id, manufacturer_id) VALUES (8, "xyz", 3000, 1, 4);