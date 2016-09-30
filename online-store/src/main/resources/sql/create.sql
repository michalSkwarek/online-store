-- ----------------------------------------------
-- add few operating systems
INSERT INTO os (id, name, version) VALUES
  (1, 'iOS', '10'),
  (2, 'iOS', '9'),
  (3, 'Android', '6.0 Marshmallow'),
  (4, 'Android', '5.0 Lollipop'),
  (5, 'Android', '5.1 Lollipop'),
  (6, 'Android', '4.4 KitKat'),
  (7, 'Android', '6.0 Marshmallow'),
  (8, 'Windows', '10 Mobile'),
  (9, 'Windows Phone', '8.1');

-- add few operating batteries
INSERT INTO battery_type (id, type) VALUES
  (1, 'Li-ion'),
  (2, 'Li-poly');

-- add few operating displays
INSERT INTO display (id, diagonal, width_in_pixels, height_in_pixels) VALUES
  (1, 5.5, 1920, 1080),
  (2, 4.7, 1334, 750),
  (3, 4, 1136, 640),
  (4, 5.5, 2560, 1440),
  (5, 5.1, 2560, 1440),
  (6, 5.7, 2560, 1440),
  (7, 5.3, 2560, 1440),
  (8, 5.2, 1920, 1080),
  (9, 5, 1920, 1080),
  (10, 5, 1280, 720),
  (11, 4.7, 1280, 720),
  (12, 5.2, 2560, 1440),
  (13, 5.5, 1280, 720);

-- add few gpu
INSERT INTO gpu (id, model) VALUES
  (1, 'PowerVR GT7600'),
  (2, 'Mali-T880 MP12'),
  (3, 'Mali-T760'),
  (4, 'Adreno 418'),
  (5, 'Adreno 405'),
  (6, 'Adreno 530'),
  (7, 'Adreno 330'),
  (8, 'Adreno 510'),
  (9, 'Adreno 430'),
  (10, 'Adreno 304'),
  (11, 'Adreno 305'),
  (12, 'Intel HD Graphics'),
  (13, 'Intel GFX 6 Series'),
  (14, 'Adreno 306'),
  (15, 'Mali-T880 MP4'),
  (16, 'Mali-T628 MP4');

-- add few cpu
INSERT INTO cpu (id, model, number_of_cores, low_clock_speed, high_clock_speed) VALUES
  (1, 'Apple A10', 4, 2.4, NULL),
  (2, 'Apple A9', 2, 1.85, NULL),
  (3, 'Samsung Exynos 8890', 8, 1.6, 2.3),
  (4, 'Samsung Exynos 7420', 8, 1.5, 2.1),
  (5, 'Qualcomm Snapdragon 808', 6, 1.44, 1.82),
  (6, 'Qualcomm Snapdragon 615', 8, 1.0, 1.7),
  (7, 'Qualcomm Snapdragon 820', 4, 2.2, NULL),
  (8, 'Qualcomm Snapdragon 801', 4, 2.5, NULL),
  (9, 'Qualcomm Snapdragon 650', 6, 1.4, 1.8),
  (10, 'Qualcomm Snapdragon 810', 8, 1.5, 2.0),
  (11, 'Qualcomm Snapdragon 212', 4, 1.3, NULL),
  (12, 'Qualcomm Snapdragon 400', 4, 1.2, NULL),
  (13, 'Qualcomm Snapdragon 210', 4, 1.1, NULL),
  (14, 'Qualcomm Snapdragon 652', 8, 1.2, 1.8),
  (15, 'Qualcomm Snapdragon 617', 8, 1.2, 1.5),
  (16, 'Intel Atom Z3580', 4, 2.33, NULL),
  (17, 'Qualcomm Snapdragon 410', 4, 1.2, NULL),
  (18, 'HiSilicon Kirin 955', 8, 1.8, 2.5),
  (19, 'HiSilicon Kirin 650', 8, 1.7, 2.0),
  (20, 'HiSilicon Kirin 930', 8, 1.5, 2.0);

-- add few specifications
INSERT INTO specifications (id, cpu_id, gpu_id, ram, disk, display_id, capacity, type_id, os_id, resolution_main_camera, resolution_front_camera, thickness, width, height, weight) VALUES
  (1, 1, NULL, 3, 128, 1, 2910, 1, 1, 12.0, 7.0, 7.3, 77.9, 158.2, 189),
  (2, 1, NULL, 2, 128, 1, 1900, 1, 1, 12.0, 7.0, 7.1, 67.1, 138.3, 138),
  (3, 2, 1, 2, 128, 1, 2750, 1, 2, 12.0, 5.0, 7.3, 77.9, 158.2, 192),
  (4, 2, 1, 2, 128, 1, 1715, 1, 2, 12.0, 5.0, 7.1, 67.1, 138.3, 143),
  (5, 2, 1, 2, 64, 1, 1624, 1, 2, 12.0, 1.2, 7.6, 58.6, 123.8, 113),

  (6, 3, 2, 4, 32, 1, 3600, 1, 3, 12.0, 5.0, 7.7, 72.6, 151, 158),
  (7, 3, 2, 4, 32, 1, 3000, 1, 3, 12.0, 5.0, 6.9, 70.8, 143.5, 152),
  (8, 3, 2, 4, 32, 1, 2600, 1, 4, 16.0, 7.0, 7.0, 70.1, 142.1, 132),
  (9, 4, 3, 3, 32, 1, 2600, 1, 4, 16.0, 7.0, 6.9, 70.5, 143.5, 138),
  (10, 4, 3, 3, 32, 1, 3000, 1, 5, 21.0, 5.0, 8.9, 76.2, 154, 180),

  (11, 5, 4, 3, 32, 1, 1, 5, 20.7, 5.0, 8.9, 75, 148, 168),
  (12, 6, 5, 2, 16, 1, 1, 3, 16.0, 8.0, 7.7, 73.9, 149.6, 158),
  (13, 7, 6, 4, 32, 1, 1, 4, 16.0, 8.0, 9.8, 76.2, 150, 155),
  (14, 6, 4, 3, 32, 1, 1, 6, 13.0, 2.1, 9.3, 74.6, 146.3, 149),
  (15, 8, 7, 2, 16, 1, 1, 3, 23.0, 13.0, 8.1, 72, 146, 161),

  (16, 7, 6, 3, 32, 1, 1, 3, 23.0, 13.0, 7.7, 69, 143, 152),
  (17, 9, 8, 3, 32, 1, 1, 8, 20.0, 5.0, 8.1, 78.4, 151.9, 165),
  (18, 10, 9, 3, 32, 1, 1, 8, 8.0, 5.0, 6.9, 70.8, 142.1, 122),
  (19, 11, 10, 1, 16, 1, 1, 9, 8.0, 0.9, 8.8, 72, 141, 145),
  (20, 12, 11, 1, 8, 1, 1, 8, 5.0, 2.0, 9.9, 67.8, 136.1, 142),

  (21, 13, 10, 1, 8, 1, 1, 3, 13.0, 5.0, 9.1, 71.9, 146, 161),
  (22, 14, 8, 3, 32, 1, 1, 3, 14.0, 3.0, 7.3, 70.8, 145.5, 143),
  (23, 15, 5, 2, 16, 1, 1, 4, 12.0, 5.0, 9.6, 70.6, 146.4, 160),
  (24, 6, 12, 2, 16, 1, 1, 4, 13.0, 5.0, 11.9, 79.2, 160, 185),
  (25, 16, 13, 4, 64, 1, 1, 4, 13.0, 5.0, 10.9, 77.3, 152.5, 170),

  (26, 17, 14, 4, 32, 1, 1, 4, 13.0, 5.0, 10.6, 77.3, 156, 202),
  (27, 18, 15, 2, 16, 1, 1, 3, 12.0, 8.0, 7, 75.3, 152.3, 162),
  (28, 18, 15, 4, 64, 1, 1, 3, 12.0, 8.0, 7, 70.9, 145, 144),
  (29, 19, 15, 3, 32, 1, 1, 3, 13.0, 8.0, 7.5, 72.6, 146.8, 148),
  (30, 20, 16, 2, 16, 1, 1, 4, 13.0, 8.0, 6.4, 72.1, 144.9, 144),

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
# INSERT INTO product (id, model, unit_price, category_id, manufacturer_id, specifications_id) VALUES (2, "Galaxy S7 edge", 3398, 1, 2, 2);
# INSERT INTO product (id, model, unit_price, category_id, manufacturer_id, specifications_id) VALUES (3, "280 G1 MT", 1199, 2, 3, 3);
# INSERT INTO product (id, model, unit_price, category_id, manufacturer_id, specifications_id) VALUES (4, "Vostro 3900", 1799, 2, 3, 4);
# INSERT INTO product (id, model, unit_price, category_id, manufacturer_id, specifications_id) VALUES (5, "PlayStation 4", 1279, 3, 4, 5);
INSERT INTO product (id, model, unit_price, category_id, manufacturer_id) VALUES (6, "abc", 1000, 1, 2);
INSERT INTO product (id, model, unit_price, category_id, manufacturer_id) VALUES (7, "klm", 2000, 1, 3);
INSERT INTO product (id, model, unit_price, category_id, manufacturer_id) VALUES (8, "xyz", 3000, 1, 4);