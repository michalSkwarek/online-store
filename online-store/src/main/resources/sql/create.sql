-- ----------------------------------------------
-- add few categories
INSERT INTO category (id, name) VALUES (1, 'Smartphone');
INSERT INTO category (id, name) VALUES (2, 'Tablet');
INSERT INTO category (id, name) VALUES (3, 'Notebook');
INSERT INTO category (id, name) VALUES (4, 'PC');
INSERT INTO category (id, name) VALUES (5, 'Console');
INSERT INTO category (id, name) VALUES (6, 'Smartwatch');



-- add few manufacturers
INSERT INTO manufacturer (id, brand, website) VALUES (1, 'Apple', 'http://www.apple.com');
INSERT INTO manufacturer (id, brand, website) VALUES (2, 'Samsung', 'http://www.samsung.com');
INSERT INTO manufacturer (id, brand, website) VALUES (3, 'Lenovo', 'http://www.lenovo.com');
INSERT INTO manufacturer (id, brand, website) VALUES (4, 'LG', 'http://www.lg.com');
INSERT INTO manufacturer (id, brand, website) VALUES (5, 'Sony', 'http://www.sony.com');
INSERT INTO manufacturer (id, brand, website) VALUES (6, 'Microsoft', 'http://www.microsoft.com');
INSERT INTO manufacturer (id, brand, website) VALUES (7, 'HTC', 'http://www.htc.com');
INSERT INTO manufacturer (id, brand, website) VALUES (8, 'ASUS', 'http://www.asus.com');
INSERT INTO manufacturer (id, brand, website) VALUES (9, 'Huawei', 'http://www.huawei.com');
INSERT INTO manufacturer (id, brand, website) VALUES (10, 'HP', 'http://www.hp.com');
INSERT INTO manufacturer (id, brand, website) VALUES (11, 'Toshiba', 'http://www.toshiba.com');
INSERT INTO manufacturer (id, brand, website) VALUES (12, 'Dell', 'http://www.dell.com');
INSERT INTO manufacturer (id, brand, website) VALUES (13, 'MSI', 'http://www.msi.com');



-- ----------------------------------------------
-- SMARTPHONE
-- ----------------------------------------------
-- add few operating systems
INSERT INTO os (id, name, version) VALUES (1, 'iOS', '10');
INSERT INTO os (id, name, version) VALUES (2, 'iOS', '9');
INSERT INTO os (id, name, version) VALUES (3, 'Android', '6.0 Marshmallow');
INSERT INTO os (id, name, version) VALUES (4, 'Android', '5.0 Lollipop');
INSERT INTO os (id, name, version) VALUES (5, 'Android', '5.1 Lollipop');
INSERT INTO os (id, name, version) VALUES (6, 'Android', '4.4 KitKat');
INSERT INTO os (id, name, version) VALUES (7, 'Windows', '10 Mobile');
INSERT INTO os (id, name, version) VALUES (8, 'Windows Phone', '8.1');

-- add few battery types
INSERT INTO battery_type (id, type) VALUES (1, 'Li-ion');
INSERT INTO battery_type (id, type) VALUES (2, 'Li-poly');

-- add few display resolutions
INSERT INTO display_resolution (id, width_in_pixels, height_in_pixels) VALUES (1, 1920, 1080);
INSERT INTO display_resolution (id, width_in_pixels, height_in_pixels) VALUES (2, 1334, 750);
INSERT INTO display_resolution (id, width_in_pixels, height_in_pixels) VALUES (3, 1136, 640);
INSERT INTO display_resolution (id, width_in_pixels, height_in_pixels) VALUES (4, 2560, 1440);
INSERT INTO display_resolution (id, width_in_pixels, height_in_pixels) VALUES (5, 1280, 720);

-- add few displays
INSERT INTO display (id, diagonal, display_resolution_id) VALUES (1, 5.5, 1);
INSERT INTO display (id, diagonal, display_resolution_id) VALUES (2, 4.7, 2);
INSERT INTO display (id, diagonal, display_resolution_id) VALUES (3, 4, 3);
INSERT INTO display (id, diagonal, display_resolution_id) VALUES (4, 5.5, 4);
INSERT INTO display (id, diagonal, display_resolution_id) VALUES (5, 5.1, 4);
INSERT INTO display (id, diagonal, display_resolution_id) VALUES (6, 5.7, 4);
INSERT INTO display (id, diagonal, display_resolution_id) VALUES (7, 5.3, 4);
INSERT INTO display (id, diagonal, display_resolution_id) VALUES (8, 5.2, 1);
INSERT INTO display (id, diagonal, display_resolution_id) VALUES (9, 5, 1);
INSERT INTO display (id, diagonal, display_resolution_id) VALUES (10, 5, 5);
INSERT INTO display (id, diagonal, display_resolution_id) VALUES (11, 4.7, 5);
INSERT INTO display (id, diagonal, display_resolution_id) VALUES (12, 5.2, 4);
INSERT INTO display (id, diagonal, display_resolution_id) VALUES (13, 5.5, 5);

-- add few gpu
INSERT INTO gpu (id, model) VALUES (1, 'PowerVR GT7600');
INSERT INTO gpu (id, model) VALUES (2, 'Mali-T880 MP12');
INSERT INTO gpu (id, model) VALUES (3, 'Mali-T760');
INSERT INTO gpu (id, model) VALUES (4, 'Adreno 418');
INSERT INTO gpu (id, model) VALUES (5, 'Adreno 405');
INSERT INTO gpu (id, model) VALUES (6, 'Adreno 530');
INSERT INTO gpu (id, model) VALUES (7, 'Adreno 330');
INSERT INTO gpu (id, model) VALUES (8, 'Adreno 510');
INSERT INTO gpu (id, model) VALUES (9, 'Adreno 430');
INSERT INTO gpu (id, model) VALUES (10, 'Adreno 304');
INSERT INTO gpu (id, model) VALUES (11, 'Adreno 305');
INSERT INTO gpu (id, model) VALUES (12, 'Intel HD Graphics');
INSERT INTO gpu (id, model) VALUES (13, 'Intel GFX 6 Series');
INSERT INTO gpu (id, model) VALUES (14, 'Adreno 306');
INSERT INTO gpu (id, model) VALUES (15, 'Mali-T880 MP4');
INSERT INTO gpu (id, model) VALUES (16, 'Mali-T628 MP4');

-- add few cpu
INSERT INTO cpu (id, model, number_of_cores, low_clock_speed, high_clock_speed) VALUES (1, 'Apple A10', 4, 2.4, NULL);
INSERT INTO cpu (id, model, number_of_cores, low_clock_speed, high_clock_speed) VALUES (2, 'Apple A9', 2, 1.85, NULL);
INSERT INTO cpu (id, model, number_of_cores, low_clock_speed, high_clock_speed) VALUES (3, 'Samsung Exynos 8890', 8, 1.6, 2.3);
INSERT INTO cpu (id, model, number_of_cores, low_clock_speed, high_clock_speed) VALUES (4, 'Samsung Exynos 7420', 8, 1.5, 2.1);
INSERT INTO cpu (id, model, number_of_cores, low_clock_speed, high_clock_speed) VALUES (5, 'Qualcomm Snapdragon 808', 6, 1.44, 1.82);
INSERT INTO cpu (id, model, number_of_cores, low_clock_speed, high_clock_speed) VALUES (6, 'Qualcomm Snapdragon 615', 8, 1.0, 1.7);
INSERT INTO cpu (id, model, number_of_cores, low_clock_speed, high_clock_speed) VALUES (7, 'Qualcomm Snapdragon 820', 4, 2.2, NULL);
INSERT INTO cpu (id, model, number_of_cores, low_clock_speed, high_clock_speed) VALUES (8, 'Qualcomm Snapdragon 801', 4, 2.5, NULL);
INSERT INTO cpu (id, model, number_of_cores, low_clock_speed, high_clock_speed) VALUES (9, 'Qualcomm Snapdragon 650', 6, 1.4, 1.8);
INSERT INTO cpu (id, model, number_of_cores, low_clock_speed, high_clock_speed) VALUES (10, 'Qualcomm Snapdragon 810', 8, 1.5, 2.0);
INSERT INTO cpu (id, model, number_of_cores, low_clock_speed, high_clock_speed) VALUES (11, 'Qualcomm Snapdragon 212', 4, 1.3, NULL);
INSERT INTO cpu (id, model, number_of_cores, low_clock_speed, high_clock_speed) VALUES (12, 'Qualcomm Snapdragon 400', 4, 1.2, NULL);
INSERT INTO cpu (id, model, number_of_cores, low_clock_speed, high_clock_speed) VALUES (13, 'Qualcomm Snapdragon 210', 4, 1.1, NULL);
INSERT INTO cpu (id, model, number_of_cores, low_clock_speed, high_clock_speed) VALUES (14, 'Qualcomm Snapdragon 652', 8, 1.2, 1.8);
INSERT INTO cpu (id, model, number_of_cores, low_clock_speed, high_clock_speed) VALUES (15, 'Qualcomm Snapdragon 617', 8, 1.2, 1.5);
INSERT INTO cpu (id, model, number_of_cores, low_clock_speed, high_clock_speed) VALUES (16, 'Intel Atom Z3580', 4, 2.33, NULL);
INSERT INTO cpu (id, model, number_of_cores, low_clock_speed, high_clock_speed) VALUES (17, 'Qualcomm Snapdragon 410', 4, 1.2, NULL);
INSERT INTO cpu (id, model, number_of_cores, low_clock_speed, high_clock_speed) VALUES (18, 'HiSilicon Kirin 955', 8, 1.8, 2.5);
INSERT INTO cpu (id, model, number_of_cores, low_clock_speed, high_clock_speed) VALUES (19, 'HiSilicon Kirin 650', 8, 1.7, 2.0);
INSERT INTO cpu (id, model, number_of_cores, low_clock_speed, high_clock_speed) VALUES (20, 'HiSilicon Kirin 930', 8, 1.5, 2.0);

-- add few specifications
INSERT INTO specifications (id, cpu_id, gpu_id, ram, disk_memory, display_id, battery_capacity, battery_type_id, os_id, resolution_main_camera, resolution_front_camera, thickness, width, height, weight) VALUES (1, 1, NULL, 3, 128, 1, 2910, 1, 1, 12.0, 7.0, 7.3, 77.9, 158.2, 189);
INSERT INTO specifications (id, cpu_id, gpu_id, ram, disk_memory, display_id, battery_capacity, battery_type_id, os_id, resolution_main_camera, resolution_front_camera, thickness, width, height, weight) VALUES (2, 1, NULL, 2, 128, 2, 1900, 1, 1, 12.0, 7.0, 7.1, 67.1, 138.3, 138);
INSERT INTO specifications (id, cpu_id, gpu_id, ram, disk_memory, display_id, battery_capacity, battery_type_id, os_id, resolution_main_camera, resolution_front_camera, thickness, width, height, weight) VALUES (3, 2, 1, 2, 128, 1, 2750, 1, 2, 12.0, 5.0, 7.3, 77.9, 158.2, 192);
INSERT INTO specifications (id, cpu_id, gpu_id, ram, disk_memory, display_id, battery_capacity, battery_type_id, os_id, resolution_main_camera, resolution_front_camera, thickness, width, height, weight) VALUES (4, 2, 1, 2, 128, 2, 1715, 1, 2, 12.0, 5.0, 7.1, 67.1, 138.3, 143);
INSERT INTO specifications (id, cpu_id, gpu_id, ram, disk_memory, display_id, battery_capacity, battery_type_id, os_id, resolution_main_camera, resolution_front_camera, thickness, width, height, weight) VALUES (5, 2, 1, 2, 64, 3, 1624, 1, 2, 12.0, 1.2, 7.6, 58.6, 123.8, 113);

INSERT INTO specifications (id, cpu_id, gpu_id, ram, disk_memory, display_id, battery_capacity, battery_type_id, os_id, resolution_main_camera, resolution_front_camera, thickness, width, height, weight) VALUES (6, 3, 2, 4, 32, 4, 3600, 1, 3, 12.0, 5.0, 7.7, 72.6, 151, 158);
INSERT INTO specifications (id, cpu_id, gpu_id, ram, disk_memory, display_id, battery_capacity, battery_type_id, os_id, resolution_main_camera, resolution_front_camera, thickness, width, height, weight) VALUES (7, 3, 2, 4, 32, 5, 3000, 1, 3, 12.0, 5.0, 6.9, 70.8, 143.5, 152);
INSERT INTO specifications (id, cpu_id, gpu_id, ram, disk_memory, display_id, battery_capacity, battery_type_id, os_id, resolution_main_camera, resolution_front_camera, thickness, width, height, weight) VALUES (8, 4, 3, 3, 32, 5, 2600, 1, 4, 16.0, 5.0, 7.0, 70.1, 142.1, 132);
INSERT INTO specifications (id, cpu_id, gpu_id, ram, disk_memory, display_id, battery_capacity, battery_type_id, os_id, resolution_main_camera, resolution_front_camera, thickness, width, height, weight) VALUES (9, 4, 3, 3, 32, 5, 2600, 1, 4, 16.0, 5.0, 6.9, 70.5, 143.5, 138);
INSERT INTO specifications (id, cpu_id, gpu_id, ram, disk_memory, display_id, battery_capacity, battery_type_id, os_id, resolution_main_camera, resolution_front_camera, thickness, width, height, weight) VALUES (10, 5, 4, 3, 32, 6, 3000, 1, 5, 21.0, 5.0, 8.9, 76.2, 154, 180);

INSERT INTO specifications (id, cpu_id, gpu_id, ram, disk_memory, display_id, battery_capacity, battery_type_id, os_id, resolution_main_camera, resolution_front_camera, thickness, width, height, weight) VALUES (11, 6, 5, 2, 16, 1, 3600, 2, 5, 20.7, 5.0, 8.9, 75, 148, 168);
INSERT INTO specifications (id, cpu_id, gpu_id, ram, disk_memory, display_id, battery_capacity, battery_type_id, os_id, resolution_main_camera, resolution_front_camera, thickness, width, height, weight) VALUES (12, 7, 6, 4, 32, 7, 2800, 1, 3, 16.0, 8.0, 7.7, 73.9, 149.6, 158);
INSERT INTO specifications (id, cpu_id, gpu_id, ram, disk_memory, display_id, battery_capacity, battery_type_id, os_id, resolution_main_camera, resolution_front_camera, thickness, width, height, weight) VALUES (13, 5, 4, 3, 32, 4, 3000, 1, 4, 16.0, 8.0, 9.8, 76.2, 150, 155);
INSERT INTO specifications (id, cpu_id, gpu_id, ram, disk_memory, display_id, battery_capacity, battery_type_id, os_id, resolution_main_camera, resolution_front_camera, thickness, width, height, weight) VALUES (14, 8, 7, 2, 16, 4, 3000, 1, 6, 13.0, 2.1, 9.3, 74.6, 146.3, 149);
INSERT INTO specifications (id, cpu_id, gpu_id, ram, disk_memory, display_id, battery_capacity, battery_type_id, os_id, resolution_main_camera, resolution_front_camera, thickness, width, height, weight) VALUES (15, 7, 6, 3, 32, 8, 2900, 1, 3, 23.0, 13.0, 8.1, 72, 146, 161);

INSERT INTO specifications (id, cpu_id, gpu_id, ram, disk_memory, display_id, battery_capacity, battery_type_id, os_id, resolution_main_camera, resolution_front_camera, thickness, width, height, weight) VALUES (16, 9, 8, 3, 32, 9, 2620, 1, 3, 23.0, 13.0, 7.7, 69, 143, 152);
INSERT INTO specifications (id, cpu_id, gpu_id, ram, disk_memory, display_id, battery_capacity, battery_type_id, os_id, resolution_main_camera, resolution_front_camera, thickness, width, height, weight) VALUES (17, 10, 9, 3, 32, 6, 3340, 1, 7, 20.0, 5.0, 8.1, 78.4, 151.9, 165);
INSERT INTO specifications (id, cpu_id, gpu_id, ram, disk_memory, display_id, battery_capacity, battery_type_id, os_id, resolution_main_camera, resolution_front_camera, thickness, width, height, weight) VALUES (18, 11, 10, 1, 16, 10, 2000, 1, 7, 8.0, 5.0, 6.9, 70.8, 142.1, 122);
INSERT INTO specifications (id, cpu_id, gpu_id, ram, disk_memory, display_id, battery_capacity, battery_type_id, os_id, resolution_main_camera, resolution_front_camera, thickness, width, height, weight) VALUES (19, 12, 11, 1, 8, 10, 2500, 1, 8, 8.0, 0.9, 8.8, 72, 141, 145);
INSERT INTO specifications (id, cpu_id, gpu_id, ram, disk_memory, display_id, battery_capacity, battery_type_id, os_id, resolution_main_camera, resolution_front_camera, thickness, width, height, weight) VALUES (20, 13, 10, 1, 8, 11, 2100, 1, 7, 5.0, 2.0, 9.9, 67.8, 136.1, 142);

INSERT INTO specifications (id, cpu_id, gpu_id, ram, disk_memory, display_id, battery_capacity, battery_type_id, os_id, resolution_main_camera, resolution_front_camera, thickness, width, height, weight) VALUES (21, 14, 8, 3, 32, 12, 3000, 1, 3, 13.0, 5.0, 9.1, 71.9, 146, 161);
INSERT INTO specifications (id, cpu_id, gpu_id, ram, disk_memory, display_id, battery_capacity, battery_type_id, os_id, resolution_main_camera, resolution_front_camera, thickness, width, height, weight) VALUES (22, 15, 5, 2, 16, 9, 2150, 1, 3, 14.0, 3.0, 7.3, 70.8, 145.5, 143);
INSERT INTO specifications (id, cpu_id, gpu_id, ram, disk_memory, display_id, battery_capacity, battery_type_id, os_id, resolution_main_camera, resolution_front_camera, thickness, width, height, weight) VALUES (23, 6, 5, 2, 16, 9, 2840, 2, 4, 12.0, 5.0, 9.6, 70.6, 146.4, 160);
INSERT INTO specifications (id, cpu_id, gpu_id, ram, disk_memory, display_id, battery_capacity, battery_type_id, os_id, resolution_main_camera, resolution_front_camera, thickness, width, height, weight) VALUES (24, 16, 12, 4, 64, 1, 3000, 1, 4, 13.0, 5.0, 11.9, 79.2, 160, 185);
INSERT INTO specifications (id, cpu_id, gpu_id, ram, disk_memory, display_id, battery_capacity, battery_type_id, os_id, resolution_main_camera, resolution_front_camera, thickness, width, height, weight) VALUES (25, 16, 13, 4, 32, 1, 3000, 1, 4, 13.0, 5.0, 10.9, 77.3, 152.5, 170);

INSERT INTO specifications (id, cpu_id, gpu_id, ram, disk_memory, display_id, battery_capacity, battery_type_id, os_id, resolution_main_camera, resolution_front_camera, thickness, width, height, weight) VALUES (26, 17, 14, 2, 16, 13, 5000, 1, 4, 13.0, 5.0, 10.6, 77.3, 156, 202);
INSERT INTO specifications (id, cpu_id, gpu_id, ram, disk_memory, display_id, battery_capacity, battery_type_id, os_id, resolution_main_camera, resolution_front_camera, thickness, width, height, weight) VALUES (27, 18, 15, 4, 64, 9, 3400, 2, 3, 12.0, 8.0, 7, 75.3, 152.3, 162);
INSERT INTO specifications (id, cpu_id, gpu_id, ram, disk_memory, display_id, battery_capacity, battery_type_id, os_id, resolution_main_camera, resolution_front_camera, thickness, width, height, weight) VALUES (28, 18, 15, 3, 32, 8, 3000, 2, 3, 12.0, 8.0, 7, 70.9, 145, 144);
INSERT INTO specifications (id, cpu_id, gpu_id, ram, disk_memory, display_id, battery_capacity, battery_type_id, os_id, resolution_main_camera, resolution_front_camera, thickness, width, height, weight) VALUES (29, 19, 15, 2, 16, 8, 3000, 1, 3, 13.0, 8.0, 7.5, 72.6, 146.8, 148);
INSERT INTO specifications (id, cpu_id, gpu_id, ram, disk_memory, display_id, battery_capacity, battery_type_id, os_id, resolution_main_camera, resolution_front_camera, thickness, width, height, weight) VALUES (30, 20, 16, 3, 16, 8, 2680, 2, 4, 13.0, 8.0, 6.4, 72.1, 144.9, 144);

-- add few products
INSERT INTO product (id, model, unit_price, category_id, manufacturer_id, specifications_id) VALUES (1, 'iPhone 7 Plus', 4479, 1, 1, 1);
INSERT INTO product (id, model, unit_price, category_id, manufacturer_id, specifications_id) VALUES (2, 'iPhone 7', 3879, 1, 1, 2);
INSERT INTO product (id, model, unit_price, category_id, manufacturer_id, specifications_id) VALUES (3, 'iPhone 6s Plus', 3879, 1, 1, 3);
INSERT INTO product (id, model, unit_price, category_id, manufacturer_id, specifications_id) VALUES (4, 'iPhone 6s', 3349, 1, 1, 4);
INSERT INTO product (id, model, unit_price, category_id, manufacturer_id, specifications_id) VALUES (5, 'iPhone SE', 2399, 1, 1, 5);

INSERT INTO product (id, model, unit_price, category_id, manufacturer_id, specifications_id) VALUES (6, 'Galaxy S7 edge', 3398, 1, 2, 6);
INSERT INTO product (id, model, unit_price, category_id, manufacturer_id, specifications_id) VALUES (7, 'Galaxy S7', 2998, 1, 2, 7);
INSERT INTO product (id, model, unit_price, category_id, manufacturer_id, specifications_id) VALUES (8, 'Galaxy S6 edge', 2149, 1, 2, 8);
INSERT INTO product (id, model, unit_price, category_id, manufacturer_id, specifications_id) VALUES (9, 'Galaxy S6', 1999, 1, 2, 9);
INSERT INTO product (id, model, unit_price, category_id, manufacturer_id, specifications_id) VALUES (10, 'Moto X Style', 1599, 1, 3, 10);

INSERT INTO product (id, model, unit_price, category_id, manufacturer_id, specifications_id) VALUES (11, 'Moto X Play', 1089, 1, 3, 11);
INSERT INTO product (id, model, unit_price, category_id, manufacturer_id, specifications_id) VALUES (12, 'G5', 2199, 1, 4, 12);
INSERT INTO product (id, model, unit_price, category_id, manufacturer_id, specifications_id) VALUES (13, 'G4', 1599, 1, 4, 13);
INSERT INTO product (id, model, unit_price, category_id, manufacturer_id, specifications_id) VALUES (14, 'G3', 1059, 1, 4, 14);
INSERT INTO product (id, model, unit_price, category_id, manufacturer_id, specifications_id) VALUES (15, 'Xperia XZ', 2999, 1, 5, 15);

INSERT INTO product (id, model, unit_price, category_id, manufacturer_id, specifications_id) VALUES (16, 'Xperia X', 2389, 1, 5, 16);
INSERT INTO product (id, model, unit_price, category_id, manufacturer_id, specifications_id) VALUES (17, 'Lumia 950 XL', 1899, 1, 6, 17);
INSERT INTO product (id, model, unit_price, category_id, manufacturer_id, specifications_id) VALUES (18, 'Lumia 650', 589, 1, 6, 18);
INSERT INTO product (id, model, unit_price, category_id, manufacturer_id, specifications_id) VALUES (19, 'Lumia 640', 469, 1, 6, 19);
INSERT INTO product (id, model, unit_price, category_id, manufacturer_id, specifications_id) VALUES (20, 'Lumia 550', 389, 1, 6, 20);

INSERT INTO product (id, model, unit_price, category_id, manufacturer_id, specifications_id) VALUES (21, '10 Lifestyle', 2999, 1, 7, 21);
INSERT INTO product (id, model, unit_price, category_id, manufacturer_id, specifications_id) VALUES (22, 'One A9 Aero', 1699, 1, 7, 22);
INSERT INTO product (id, model, unit_price, category_id, manufacturer_id, specifications_id) VALUES (23, 'One M8S', 1569, 1, 7, 23);
INSERT INTO product (id, model, unit_price, category_id, manufacturer_id, specifications_id) VALUES (24, 'Zenfone Zoom', 3028, 1, 8, 24);
INSERT INTO product (id, model, unit_price, category_id, manufacturer_id, specifications_id) VALUES (25, 'Zenfone 2', 2078, 1, 8, 25);

INSERT INTO product (id, model, unit_price, category_id, manufacturer_id, specifications_id) VALUES (26, 'Zenfone Max', 1778, 1, 8, 26);
INSERT INTO product (id, model, unit_price, category_id, manufacturer_id, specifications_id) VALUES (27, 'P9 Plus', 3199, 1, 9, 27);
INSERT INTO product (id, model, unit_price, category_id, manufacturer_id, specifications_id) VALUES (28, 'P9', 2449, 1, 9, 28);
INSERT INTO product (id, model, unit_price, category_id, manufacturer_id, specifications_id) VALUES (29, 'P9 Lite', 1399, 1, 9, 29);
INSERT INTO product (id, model, unit_price, category_id, manufacturer_id, specifications_id) VALUES (30, 'P8', 1499, 1, 9, 30);







INSERT INTO product (id, model, unit_price, category_id, manufacturer_id) VALUES (36, "abc", 1000, 1, 2);
INSERT INTO product (id, model, unit_price, category_id, manufacturer_id) VALUES (37, "klm", 2000, 1, 3);
INSERT INTO product (id, model, unit_price, category_id, manufacturer_id) VALUES (38, "xyz", 3000, 1, 4);

-- ----------------------------------------------
-- Tablet
-- ----------------------------------------------









# INSERT INTO specifications (id, display_id, battery_id, os_id, weight) VALUES (1, 1, 1, 1, 189);
# INSERT INTO specifications (id, display_id, battery_id, os_id, weight) VALUES (2, 2, 2, 1, 138);
# INSERT INTO specifications (id, power_supply, os_id, weight) VALUES (3, 180, 3, 7000);
# INSERT INTO specifications (id, power_supply, os_id, weight) VALUES (4, 300, 3, 10000);
# INSERT INTO specifications (id, weight) VALUES (5, 2900);

# INSERT INTO product (id, model, unit_price, category_id, manufacturer_id, specifications_id) VALUES (3, "280 G1 MT", 1199, 2, 3, 3);
# INSERT INTO product (id, model, unit_price, category_id, manufacturer_id, specifications_id) VALUES (4, "Vostro 3900", 1799, 2, 3, 4);
# INSERT INTO product (id, model, unit_price, category_id, manufacturer_id, specifications_id) VALUES (5, "PlayStation 4", 1279, 3, 4, 5);