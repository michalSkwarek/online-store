# -- ----------------------------------------------
# -- add few categories
# INSERT INTO category (id, name) VALUES (1, 'Smartphone');
# INSERT INTO category (id, name) VALUES (2, 'Tablet');
# INSERT INTO category (id, name) VALUES (3, 'Notebook');
# INSERT INTO category (id, name) VALUES (4, 'PC');
# INSERT INTO category (id, name) VALUES (5, 'Console');
# INSERT INTO category (id, name) VALUES (6, 'Smartwatch');
#
#
#
# -- add few manufacturers
# INSERT INTO manufacturer (id, brand, website) VALUES (1, 'Apple', 'http://www.apple.com');
# INSERT INTO manufacturer (id, brand, website) VALUES (2, 'Samsung', 'http://www.samsung.com');
# INSERT INTO manufacturer (id, brand, website) VALUES (3, 'Lenovo', 'http://www.lenovo.com');
# INSERT INTO manufacturer (id, brand, website) VALUES (4, 'LG', 'http://www.lg.com');
# INSERT INTO manufacturer (id, brand, website) VALUES (5, 'Sony', 'http://www.sony.com');
# INSERT INTO manufacturer (id, brand, website) VALUES (6, 'Microsoft', 'http://www.microsoft.com');
# INSERT INTO manufacturer (id, brand, website) VALUES (7, 'HTC', 'http://www.htc.com');
# INSERT INTO manufacturer (id, brand, website) VALUES (8, 'ASUS', 'http://www.asus.com');
# INSERT INTO manufacturer (id, brand, website) VALUES (9, 'Huawei', 'http://www.huawei.com');
# INSERT INTO manufacturer (id, brand, website) VALUES (10, 'HP', 'http://www.hp.com');
# INSERT INTO manufacturer (id, brand, website) VALUES (11, 'Toshiba', 'http://www.toshiba.com');
# INSERT INTO manufacturer (id, brand, website) VALUES (12, 'Dell', 'http://www.dell.com');
# INSERT INTO manufacturer (id, brand, website) VALUES (13, 'MSI', 'http://www.msi.com');
#
#
#
# -- ----------------------------------------------
# -- SMARTPHONE
# -- ----------------------------------------------
# -- add few operating systems
# INSERT INTO os (id, name, version) VALUES (1, 'iOS', '10');
# INSERT INTO os (id, name, version) VALUES (2, 'iOS', '9');
# INSERT INTO os (id, name, version) VALUES (3, 'Android', '6.0 Marshmallow');
# INSERT INTO os (id, name, version) VALUES (4, 'Android', '5.0 Lollipop');
# INSERT INTO os (id, name, version) VALUES (5, 'Android', '5.1 Lollipop');
# INSERT INTO os (id, name, version) VALUES (6, 'Android', '4.4 KitKat');
# INSERT INTO os (id, name, version) VALUES (7, 'Windows', '10 Mobile');
# INSERT INTO os (id, name, version) VALUES (8, 'Windows', '8.1');
#
# -- add few battery types
# INSERT INTO battery_type (id, type) VALUES (1, 'Li-ion');
# INSERT INTO battery_type (id, type) VALUES (2, 'Li-poly');
#
# -- add few display resolutions
# INSERT INTO display_resolution (id, width_in_pixels, height_in_pixels) VALUES (1, 1920, 1080);
# INSERT INTO display_resolution (id, width_in_pixels, height_in_pixels) VALUES (2, 1334, 750);
# INSERT INTO display_resolution (id, width_in_pixels, height_in_pixels) VALUES (3, 1136, 640);
# INSERT INTO display_resolution (id, width_in_pixels, height_in_pixels) VALUES (4, 2560, 1440);
# INSERT INTO display_resolution (id, width_in_pixels, height_in_pixels) VALUES (5, 1280, 720);
#
# -- add few displays
# INSERT INTO display (id, diagonal, display_resolution_id) VALUES (1, 5.5, 1);
# INSERT INTO display (id, diagonal, display_resolution_id) VALUES (2, 4.7, 2);
# INSERT INTO display (id, diagonal, display_resolution_id) VALUES (3, 4, 3);
# INSERT INTO display (id, diagonal, display_resolution_id) VALUES (4, 5.5, 4);
# INSERT INTO display (id, diagonal, display_resolution_id) VALUES (5, 5.1, 4);
# INSERT INTO display (id, diagonal, display_resolution_id) VALUES (6, 5.7, 4);
# INSERT INTO display (id, diagonal, display_resolution_id) VALUES (7, 5.3, 4);
# INSERT INTO display (id, diagonal, display_resolution_id) VALUES (8, 5.2, 1);
# INSERT INTO display (id, diagonal, display_resolution_id) VALUES (9, 5, 1);
# INSERT INTO display (id, diagonal, display_resolution_id) VALUES (10, 5, 5);
# INSERT INTO display (id, diagonal, display_resolution_id) VALUES (11, 4.7, 5);
# INSERT INTO display (id, diagonal, display_resolution_id) VALUES (12, 5.2, 4);
# INSERT INTO display (id, diagonal, display_resolution_id) VALUES (13, 5.5, 5);
#
# -- add few gpu
# INSERT INTO gpu (id, model) VALUES (1, 'PowerVR GT7600');
# INSERT INTO gpu (id, model) VALUES (2, 'Mali-T880 MP12');
# INSERT INTO gpu (id, model) VALUES (3, 'Mali-T760');
# INSERT INTO gpu (id, model) VALUES (4, 'Adreno 418');
# INSERT INTO gpu (id, model) VALUES (5, 'Adreno 405');
# INSERT INTO gpu (id, model) VALUES (6, 'Adreno 530');
# INSERT INTO gpu (id, model) VALUES (7, 'Adreno 330');
# INSERT INTO gpu (id, model) VALUES (8, 'Adreno 510');
# INSERT INTO gpu (id, model) VALUES (9, 'Adreno 430');
# INSERT INTO gpu (id, model) VALUES (10, 'Adreno 304');
# INSERT INTO gpu (id, model) VALUES (11, 'Adreno 305');
# INSERT INTO gpu (id, model) VALUES (12, 'Intel HD Graphics');
# INSERT INTO gpu (id, model) VALUES (13, 'Intel GFX 6 Series');
# INSERT INTO gpu (id, model) VALUES (14, 'Adreno 306');
# INSERT INTO gpu (id, model) VALUES (15, 'Mali-T880 MP4');
# INSERT INTO gpu (id, model) VALUES (16, 'Mali-T628 MP4');
#
# -- add few cpu
# INSERT INTO cpu (id, model, number_of_cores, low_clock_speed, high_clock_speed) VALUES (1, 'Apple A10', 4, 2.4, NULL);
# INSERT INTO cpu (id, model, number_of_cores, low_clock_speed, high_clock_speed) VALUES (2, 'Apple A9', 2, 1.85, NULL);
# INSERT INTO cpu (id, model, number_of_cores, low_clock_speed, high_clock_speed) VALUES (3, 'Samsung Exynos 8890', 8, 1.6, 2.3);
# INSERT INTO cpu (id, model, number_of_cores, low_clock_speed, high_clock_speed) VALUES (4, 'Samsung Exynos 7420', 8, 1.5, 2.1);
# INSERT INTO cpu (id, model, number_of_cores, low_clock_speed, high_clock_speed) VALUES (5, 'Qualcomm Snapdragon 808', 6, 1.44, 1.82);
# INSERT INTO cpu (id, model, number_of_cores, low_clock_speed, high_clock_speed) VALUES (6, 'Qualcomm Snapdragon 615', 8, 1.0, 1.7);
# INSERT INTO cpu (id, model, number_of_cores, low_clock_speed, high_clock_speed) VALUES (7, 'Qualcomm Snapdragon 820', 4, 2.2, NULL);
# INSERT INTO cpu (id, model, number_of_cores, low_clock_speed, high_clock_speed) VALUES (8, 'Qualcomm Snapdragon 801', 4, 2.5, NULL);
# INSERT INTO cpu (id, model, number_of_cores, low_clock_speed, high_clock_speed) VALUES (9, 'Qualcomm Snapdragon 650', 6, 1.4, 1.8);
# INSERT INTO cpu (id, model, number_of_cores, low_clock_speed, high_clock_speed) VALUES (10, 'Qualcomm Snapdragon 810', 8, 1.5, 2.0);
# INSERT INTO cpu (id, model, number_of_cores, low_clock_speed, high_clock_speed) VALUES (11, 'Qualcomm Snapdragon 212', 4, 1.3, NULL);
# INSERT INTO cpu (id, model, number_of_cores, low_clock_speed, high_clock_speed) VALUES (12, 'Qualcomm Snapdragon 400', 4, 1.2, NULL);
# INSERT INTO cpu (id, model, number_of_cores, low_clock_speed, high_clock_speed) VALUES (13, 'Qualcomm Snapdragon 210', 4, 1.1, NULL);
# INSERT INTO cpu (id, model, number_of_cores, low_clock_speed, high_clock_speed) VALUES (14, 'Qualcomm Snapdragon 652', 8, 1.2, 1.8);
# INSERT INTO cpu (id, model, number_of_cores, low_clock_speed, high_clock_speed) VALUES (15, 'Qualcomm Snapdragon 617', 8, 1.2, 1.5);
# INSERT INTO cpu (id, model, number_of_cores, low_clock_speed, high_clock_speed) VALUES (16, 'Intel Atom Z3580', 4, 2.33, NULL);
# INSERT INTO cpu (id, model, number_of_cores, low_clock_speed, high_clock_speed) VALUES (17, 'Qualcomm Snapdragon 410', 4, 1.2, NULL);
# INSERT INTO cpu (id, model, number_of_cores, low_clock_speed, high_clock_speed) VALUES (18, 'HiSilicon Kirin 955', 8, 1.8, 2.5);
# INSERT INTO cpu (id, model, number_of_cores, low_clock_speed, high_clock_speed) VALUES (19, 'HiSilicon Kirin 650', 8, 1.7, 2.0);
# INSERT INTO cpu (id, model, number_of_cores, low_clock_speed, high_clock_speed) VALUES (20, 'HiSilicon Kirin 930', 8, 1.5, 2.0);
#
# -- add few specifications
# INSERT INTO specifications (id, cpu_id, gpu_id, ram, disk_memory, display_id, battery_capacity, battery_type_id, os_id, resolution_main_camera, resolution_front_camera, thickness, width, height, weight) VALUES (1, 1, NULL, 3, 128, 1, 2910, 1, 1, 12.0, 7.0, 7.3, 77.9, 158.2, 189);
# INSERT INTO specifications (id, cpu_id, gpu_id, ram, disk_memory, display_id, battery_capacity, battery_type_id, os_id, resolution_main_camera, resolution_front_camera, thickness, width, height, weight) VALUES (2, 1, NULL, 2, 128, 2, 1900, 1, 1, 12.0, 7.0, 7.1, 67.1, 138.3, 138);
# INSERT INTO specifications (id, cpu_id, gpu_id, ram, disk_memory, display_id, battery_capacity, battery_type_id, os_id, resolution_main_camera, resolution_front_camera, thickness, width, height, weight) VALUES (3, 2, 1, 2, 128, 1, 2750, 1, 2, 12.0, 5.0, 7.3, 77.9, 158.2, 192);
# INSERT INTO specifications (id, cpu_id, gpu_id, ram, disk_memory, display_id, battery_capacity, battery_type_id, os_id, resolution_main_camera, resolution_front_camera, thickness, width, height, weight) VALUES (4, 2, 1, 2, 128, 2, 1715, 1, 2, 12.0, 5.0, 7.1, 67.1, 138.3, 143);
# INSERT INTO specifications (id, cpu_id, gpu_id, ram, disk_memory, display_id, battery_capacity, battery_type_id, os_id, resolution_main_camera, resolution_front_camera, thickness, width, height, weight) VALUES (5, 2, 1, 2, 64, 3, 1624, 1, 2, 12.0, 1.2, 7.6, 58.6, 123.8, 113);
#
# INSERT INTO specifications (id, cpu_id, gpu_id, ram, disk_memory, display_id, battery_capacity, battery_type_id, os_id, resolution_main_camera, resolution_front_camera, thickness, width, height, weight) VALUES (6, 3, 2, 4, 32, 4, 3600, 1, 3, 12.0, 5.0, 7.7, 72.6, 151, 158);
# INSERT INTO specifications (id, cpu_id, gpu_id, ram, disk_memory, display_id, battery_capacity, battery_type_id, os_id, resolution_main_camera, resolution_front_camera, thickness, width, height, weight) VALUES (7, 3, 2, 4, 32, 5, 3000, 1, 3, 12.0, 5.0, 6.9, 70.8, 143.5, 152);
# INSERT INTO specifications (id, cpu_id, gpu_id, ram, disk_memory, display_id, battery_capacity, battery_type_id, os_id, resolution_main_camera, resolution_front_camera, thickness, width, height, weight) VALUES (8, 4, 3, 3, 32, 5, 2600, 1, 4, 16.0, 5.0, 7.0, 70.1, 142.1, 132);
# INSERT INTO specifications (id, cpu_id, gpu_id, ram, disk_memory, display_id, battery_capacity, battery_type_id, os_id, resolution_main_camera, resolution_front_camera, thickness, width, height, weight) VALUES (9, 4, 3, 3, 32, 5, 2600, 1, 4, 16.0, 5.0, 6.9, 70.5, 143.5, 138);
# INSERT INTO specifications (id, cpu_id, gpu_id, ram, disk_memory, display_id, battery_capacity, battery_type_id, os_id, resolution_main_camera, resolution_front_camera, thickness, width, height, weight) VALUES (10, 5, 4, 3, 32, 6, 3000, 1, 5, 21.0, 5.0, 8.9, 76.2, 154, 180);
#
# INSERT INTO specifications (id, cpu_id, gpu_id, ram, disk_memory, display_id, battery_capacity, battery_type_id, os_id, resolution_main_camera, resolution_front_camera, thickness, width, height, weight) VALUES (11, 6, 5, 2, 16, 1, 3600, 2, 5, 20.7, 5.0, 8.9, 75, 148, 168);
# INSERT INTO specifications (id, cpu_id, gpu_id, ram, disk_memory, display_id, battery_capacity, battery_type_id, os_id, resolution_main_camera, resolution_front_camera, thickness, width, height, weight) VALUES (12, 7, 6, 4, 32, 7, 2800, 1, 3, 16.0, 8.0, 7.7, 73.9, 149.6, 158);
# INSERT INTO specifications (id, cpu_id, gpu_id, ram, disk_memory, display_id, battery_capacity, battery_type_id, os_id, resolution_main_camera, resolution_front_camera, thickness, width, height, weight) VALUES (13, 5, 4, 3, 32, 4, 3000, 1, 4, 16.0, 8.0, 9.8, 76.2, 150, 155);
# INSERT INTO specifications (id, cpu_id, gpu_id, ram, disk_memory, display_id, battery_capacity, battery_type_id, os_id, resolution_main_camera, resolution_front_camera, thickness, width, height, weight) VALUES (14, 8, 7, 2, 16, 4, 3000, 1, 6, 13.0, 2.1, 9.3, 74.6, 146.3, 149);
# INSERT INTO specifications (id, cpu_id, gpu_id, ram, disk_memory, display_id, battery_capacity, battery_type_id, os_id, resolution_main_camera, resolution_front_camera, thickness, width, height, weight) VALUES (15, 7, 6, 3, 32, 8, 2900, 1, 3, 23.0, 13.0, 8.1, 72, 146, 161);
#
# INSERT INTO specifications (id, cpu_id, gpu_id, ram, disk_memory, display_id, battery_capacity, battery_type_id, os_id, resolution_main_camera, resolution_front_camera, thickness, width, height, weight) VALUES (16, 9, 8, 3, 32, 9, 2620, 1, 3, 23.0, 13.0, 7.7, 69, 143, 152);
# INSERT INTO specifications (id, cpu_id, gpu_id, ram, disk_memory, display_id, battery_capacity, battery_type_id, os_id, resolution_main_camera, resolution_front_camera, thickness, width, height, weight) VALUES (17, 10, 9, 3, 32, 6, 3340, 1, 7, 20.0, 5.0, 8.1, 78.4, 151.9, 165);
# INSERT INTO specifications (id, cpu_id, gpu_id, ram, disk_memory, display_id, battery_capacity, battery_type_id, os_id, resolution_main_camera, resolution_front_camera, thickness, width, height, weight) VALUES (18, 11, 10, 1, 16, 10, 2000, 1, 7, 8.0, 5.0, 6.9, 70.8, 142.1, 122);
# INSERT INTO specifications (id, cpu_id, gpu_id, ram, disk_memory, display_id, battery_capacity, battery_type_id, os_id, resolution_main_camera, resolution_front_camera, thickness, width, height, weight) VALUES (19, 12, 11, 1, 8, 10, 2500, 1, 8, 8.0, 0.9, 8.8, 72, 141, 145);
# INSERT INTO specifications (id, cpu_id, gpu_id, ram, disk_memory, display_id, battery_capacity, battery_type_id, os_id, resolution_main_camera, resolution_front_camera, thickness, width, height, weight) VALUES (20, 13, 10, 1, 8, 11, 2100, 1, 7, 5.0, 2.0, 9.9, 67.8, 136.1, 142);
#
# INSERT INTO specifications (id, cpu_id, gpu_id, ram, disk_memory, display_id, battery_capacity, battery_type_id, os_id, resolution_main_camera, resolution_front_camera, thickness, width, height, weight) VALUES (21, 14, 8, 3, 32, 12, 3000, 1, 3, 13.0, 5.0, 9.1, 71.9, 146, 161);
# INSERT INTO specifications (id, cpu_id, gpu_id, ram, disk_memory, display_id, battery_capacity, battery_type_id, os_id, resolution_main_camera, resolution_front_camera, thickness, width, height, weight) VALUES (22, 15, 5, 2, 16, 9, 2150, 1, 3, 14.0, 3.0, 7.3, 70.8, 145.5, 143);
# INSERT INTO specifications (id, cpu_id, gpu_id, ram, disk_memory, display_id, battery_capacity, battery_type_id, os_id, resolution_main_camera, resolution_front_camera, thickness, width, height, weight) VALUES (23, 6, 5, 2, 16, 9, 2840, 2, 4, 12.0, 5.0, 9.6, 70.6, 146.4, 160);
# INSERT INTO specifications (id, cpu_id, gpu_id, ram, disk_memory, display_id, battery_capacity, battery_type_id, os_id, resolution_main_camera, resolution_front_camera, thickness, width, height, weight) VALUES (24, 16, 12, 4, 64, 1, 3000, 1, 4, 13.0, 5.0, 11.9, 79.2, 160, 185);
# INSERT INTO specifications (id, cpu_id, gpu_id, ram, disk_memory, display_id, battery_capacity, battery_type_id, os_id, resolution_main_camera, resolution_front_camera, thickness, width, height, weight) VALUES (25, 16, 13, 4, 32, 1, 3000, 1, 4, 13.0, 5.0, 10.9, 77.3, 152.5, 170);
#
# INSERT INTO specifications (id, cpu_id, gpu_id, ram, disk_memory, display_id, battery_capacity, battery_type_id, os_id, resolution_main_camera, resolution_front_camera, thickness, width, height, weight) VALUES (26, 17, 14, 2, 16, 13, 5000, 1, 4, 13.0, 5.0, 10.6, 77.3, 156, 202);
# INSERT INTO specifications (id, cpu_id, gpu_id, ram, disk_memory, display_id, battery_capacity, battery_type_id, os_id, resolution_main_camera, resolution_front_camera, thickness, width, height, weight) VALUES (27, 18, 15, 4, 64, 9, 3400, 2, 3, 12.0, 8.0, 7, 75.3, 152.3, 162);
# INSERT INTO specifications (id, cpu_id, gpu_id, ram, disk_memory, display_id, battery_capacity, battery_type_id, os_id, resolution_main_camera, resolution_front_camera, thickness, width, height, weight) VALUES (28, 18, 15, 3, 32, 8, 3000, 2, 3, 12.0, 8.0, 7, 70.9, 145, 144);
# INSERT INTO specifications (id, cpu_id, gpu_id, ram, disk_memory, display_id, battery_capacity, battery_type_id, os_id, resolution_main_camera, resolution_front_camera, thickness, width, height, weight) VALUES (29, 19, 15, 2, 16, 8, 3000, 1, 3, 13.0, 8.0, 7.5, 72.6, 146.8, 148);
# INSERT INTO specifications (id, cpu_id, gpu_id, ram, disk_memory, display_id, battery_capacity, battery_type_id, os_id, resolution_main_camera, resolution_front_camera, thickness, width, height, weight) VALUES (30, 20, 16, 3, 16, 8, 2680, 2, 4, 13.0, 8.0, 6.4, 72.1, 144.9, 144);
#
# -- add few graphics
# INSERT INTO files_upload (id, file_name) VALUES (1, 'file1.jpg');
# INSERT INTO files_upload (id, file_name) VALUES (2, 'file12.jpg');
# INSERT INTO files_upload (id, file_name) VALUES (3, 'file13.jpg');
# INSERT INTO files_upload (id, file_name) VALUES (4, 'file14.jpg');
# INSERT INTO files_upload (id, file_name) VALUES (5, 'file15.jpg');
#
# INSERT INTO files_upload (id, file_name) VALUES (6, 'file16.jpg');
# INSERT INTO files_upload (id, file_name) VALUES (7, 'file17.jpg');
# INSERT INTO files_upload (id, file_name) VALUES (8, 'file18.jpg');
# INSERT INTO files_upload (id, file_name) VALUES (9, 'file19.jpg');
# INSERT INTO files_upload (id, file_name) VALUES (10, 'file10.jpg');
#
# INSERT INTO files_upload (id, file_name) VALUES (11, 'file11.jpg');
# INSERT INTO files_upload (id, file_name) VALUES (12, 'file12.jpg');
# INSERT INTO files_upload (id, file_name) VALUES (13, 'file13.jpg');
# INSERT INTO files_upload (id, file_name) VALUES (14, 'file14.jpg');
# INSERT INTO files_upload (id, file_name) VALUES (15, 'file15.jpg');
#
# INSERT INTO files_upload (id, file_name) VALUES (16, 'file16.jpg');
# INSERT INTO files_upload (id, file_name) VALUES (17, 'file17.jpg');
# INSERT INTO files_upload (id, file_name) VALUES (18, 'file18.jpg');
# INSERT INTO files_upload (id, file_name) VALUES (19, 'file19.jpg');
# INSERT INTO files_upload (id, file_name) VALUES (20, 'file20.jpg');
#
# INSERT INTO files_upload (id, file_name) VALUES (21, 'file21.jpg');
# INSERT INTO files_upload (id, file_name) VALUES (22, 'file22.jpg');
# INSERT INTO files_upload (id, file_name) VALUES (23, 'file23.jpg');
# INSERT INTO files_upload (id, file_name) VALUES (24, 'file24.jpg');
# INSERT INTO files_upload (id, file_name) VALUES (25, 'file25.jpg');
#
# INSERT INTO files_upload (id, file_name) VALUES (26, 'file26.jpg');
# INSERT INTO files_upload (id, file_name) VALUES (27, 'file27.jpg');
# INSERT INTO files_upload (id, file_name) VALUES (28, 'file28.jpg');
# INSERT INTO files_upload (id, file_name) VALUES (29, 'file29.jpg');
# INSERT INTO files_upload (id, file_name) VALUES (30, 'file30.jpg');
#
# -- add few products
# INSERT INTO product (id, model, unit_price, category_id, manufacturer_id, product_image_id, specifications_id, units_in_magazine) VALUES (1, 'iPhone 7 Plus', 4479, 1, 1, 1, 1, 10);
# INSERT INTO product (id, model, unit_price, category_id, manufacturer_id, product_image_id, specifications_id, units_in_magazine) VALUES (2, 'iPhone 7', 3879, 1, 1, 2, 2, 7);
# INSERT INTO product (id, model, unit_price, category_id, manufacturer_id, product_image_id, specifications_id, units_in_magazine) VALUES (3, 'iPhone 6s Plus', 3879, 1, 1, 3, 3, 3);
# INSERT INTO product (id, model, unit_price, category_id, manufacturer_id, product_image_id, specifications_id, units_in_magazine) VALUES (4, 'iPhone 6s', 3349, 1, 1, 4, 4, 2);
# INSERT INTO product (id, model, unit_price, category_id, manufacturer_id, product_image_id, specifications_id, units_in_magazine) VALUES (5, 'iPhone SE', 2399, 1, 1, 5, 5, 1);
#
# INSERT INTO product (id, model, unit_price, category_id, manufacturer_id, product_image_id, specifications_id, units_in_magazine) VALUES (6, 'Galaxy S7 edge', 3398, 1, 2, 6, 6, 6);
# INSERT INTO product (id, model, unit_price, category_id, manufacturer_id, product_image_id, specifications_id, units_in_magazine) VALUES (7, 'Galaxy S7', 2998, 1, 2, 7, 7, 0);
# INSERT INTO product (id, model, unit_price, category_id, manufacturer_id, product_image_id, specifications_id, units_in_magazine) VALUES (8, 'Galaxy S6 edge', 2149, 1, 2, 8, 8, 7);
# INSERT INTO product (id, model, unit_price, category_id, manufacturer_id, product_image_id, specifications_id, units_in_magazine) VALUES (9, 'Galaxy S6', 1999, 1, 2, 9, 9, 9);
# INSERT INTO product (id, model, unit_price, category_id, manufacturer_id, product_image_id, specifications_id, units_in_magazine) VALUES (10, 'Moto X Style', 1599, 1, 3, 10, 10, 0);
#
# INSERT INTO product (id, model, unit_price, category_id, manufacturer_id, product_image_id, specifications_id, units_in_magazine) VALUES (11, 'Moto X Play', 1089, 1, 3, 11, 11, 0);
# INSERT INTO product (id, model, unit_price, category_id, manufacturer_id, product_image_id, specifications_id, units_in_magazine) VALUES (12, 'G5', 2199, 1, 4, 12, 12, 3);
# INSERT INTO product (id, model, unit_price, category_id, manufacturer_id, product_image_id, specifications_id, units_in_magazine) VALUES (13, 'G4', 1599, 1, 4, 13, 13, 1);
# INSERT INTO product (id, model, unit_price, category_id, manufacturer_id, product_image_id, specifications_id, units_in_magazine) VALUES (14, 'G3', 1059, 1, 4, 14, 14, 2);
# INSERT INTO product (id, model, unit_price, category_id, manufacturer_id, product_image_id, specifications_id, units_in_magazine) VALUES (15, 'Xperia XZ', 2999, 1, 5, 15, 15, 6);
#
# INSERT INTO product (id, model, unit_price, category_id, manufacturer_id, product_image_id, specifications_id, units_in_magazine) VALUES (16, 'Xperia X', 2389, 1, 5, 16, 16, 4);
# INSERT INTO product (id, model, unit_price, category_id, manufacturer_id, product_image_id, specifications_id, units_in_magazine) VALUES (17, 'Lumia 950 XL', 1899, 1, 6, 17, 17, 2);
# INSERT INTO product (id, model, unit_price, category_id, manufacturer_id, product_image_id, specifications_id, units_in_magazine) VALUES (18, 'Lumia 650', 589, 1, 6, 18, 18, 0);
# INSERT INTO product (id, model, unit_price, category_id, manufacturer_id, product_image_id, specifications_id, units_in_magazine) VALUES (19, 'Lumia 640', 469, 1, 6, 19, 19, 0);
# INSERT INTO product (id, model, unit_price, category_id, manufacturer_id, product_image_id, specifications_id, units_in_magazine) VALUES (20, 'Lumia 550', 389, 1, 6, 20, 20, 4);
#
# INSERT INTO product (id, model, unit_price, category_id, manufacturer_id, product_image_id, specifications_id, units_in_magazine) VALUES (21, '10 Lifestyle', 2999, 1, 7, 21, 21, 2);
# INSERT INTO product (id, model, unit_price, category_id, manufacturer_id, product_image_id, specifications_id, units_in_magazine) VALUES (22, 'One A9 Aero', 1699, 1, 7, 22, 22, 1);
# INSERT INTO product (id, model, unit_price, category_id, manufacturer_id, product_image_id, specifications_id, units_in_magazine) VALUES (23, 'One M8S', 1569, 1, 7, 23, 23, 7);
# INSERT INTO product (id, model, unit_price, category_id, manufacturer_id, product_image_id, specifications_id, units_in_magazine) VALUES (24, 'Zenfone Zoom', 3028, 1, 8, 24, 24, 4);
# INSERT INTO product (id, model, unit_price, category_id, manufacturer_id, product_image_id, specifications_id, units_in_magazine) VALUES (25, 'Zenfone 2', 2078, 1, 8, 25, 25, 8);
#
# INSERT INTO product (id, model, unit_price, category_id, manufacturer_id, product_image_id, specifications_id, units_in_magazine) VALUES (26, 'Zenfone Max', 1778, 1, 8, 26, 26, 5);
# INSERT INTO product (id, model, unit_price, category_id, manufacturer_id, product_image_id, specifications_id, units_in_magazine) VALUES (27, 'P9 Plus', 3199, 1, 9, 27, 27, 8);
# INSERT INTO product (id, model, unit_price, category_id, manufacturer_id, product_image_id, specifications_id, units_in_magazine) VALUES (28, 'P9', 2449, 1, 9, 28, 28, 3);
# INSERT INTO product (id, model, unit_price, category_id, manufacturer_id, product_image_id, specifications_id, units_in_magazine) VALUES (29, 'P9 Lite', 1399, 1, 9, 29, 29, 8);
# INSERT INTO product (id, model, unit_price, category_id, manufacturer_id, product_image_id, specifications_id, units_in_magazine) VALUES (30, 'P8', 1499, 1, 9, 30, 30, 5);
#
#
#
# -- ----------------------------------------------
# -- Tablet
# -- ----------------------------------------------
# -- add few operating systems
# INSERT INTO os (id, name, version) VALUES (9, 'Android', '4.2 Jelly Bean');
# INSERT INTO os (id, name, version) VALUES (10, 'Android', '4.3 Jelly Bean');
#
# -- add few display resolutions
# INSERT INTO display_resolution (id, width_in_pixels, height_in_pixels) VALUES (6, 2048, 1536);
# INSERT INTO display_resolution (id, width_in_pixels, height_in_pixels) VALUES (7, 1920, 1200);
# INSERT INTO display_resolution (id, width_in_pixels, height_in_pixels) VALUES (8, 2560, 1600);
# INSERT INTO display_resolution (id, width_in_pixels, height_in_pixels) VALUES (9, 1280, 800);
# INSERT INTO display_resolution (id, width_in_pixels, height_in_pixels) VALUES (10, 1600, 1200);
#
# -- add few displays
# INSERT INTO display (id, diagonal, display_resolution_id) VALUES (14, 9.7, 6);
# INSERT INTO display (id, diagonal, display_resolution_id) VALUES (15, 7.9, 6);
# INSERT INTO display (id, diagonal, display_resolution_id) VALUES (16, 10.1, 7);
# INSERT INTO display (id, diagonal, display_resolution_id) VALUES (17, 10.1, 8);
# INSERT INTO display (id, diagonal, display_resolution_id) VALUES (18, 10.1, 9);
# INSERT INTO display (id, diagonal, display_resolution_id) VALUES (19, 8, 9);
# INSERT INTO display (id, diagonal, display_resolution_id) VALUES (20, 12.3, 10);
#
# -- add few memory types
# INSERT INTO memory_type (id, type) VALUES (1, 'DDR3');
# INSERT INTO memory_type (id, type) VALUES (2, 'DDR4');
# INSERT INTO memory_type (id, type) VALUES (3, 'DDR5');
#
# -- add few gpu
# INSERT INTO gpu (id, model) VALUES (17, 'PowerVR Series 7XT');
# INSERT INTO gpu (id, model) VALUES (18, 'PowerVR Series 7XT');
# INSERT INTO gpu (id, model) VALUES (19, 'PowerVR GXA6850');
# INSERT INTO gpu (id, model) VALUES (20, 'Mali-T830');
# INSERT INTO gpu (id, model) VALUES (21, 'Mali-T400 MP2');
#
# -- add few cpu
# INSERT INTO cpu (id, model, number_of_cores, low_clock_speed, high_clock_speed) VALUES (21, 'Apple A9X', 2, 2.26, NULL);
# INSERT INTO cpu (id, model, number_of_cores, low_clock_speed, high_clock_speed) VALUES (22, 'Apple A8', 2, 1.5, NULL);
# INSERT INTO cpu (id, model, number_of_cores, low_clock_speed, high_clock_speed) VALUES (23, 'Apple A8X', 3, 1.5, NULL);
# INSERT INTO cpu (id, model, number_of_cores, low_clock_speed, high_clock_speed) VALUES (24, 'Samsung Exynos 7870', 8, 1.6, NULL);
# INSERT INTO cpu (id, model, number_of_cores, low_clock_speed, high_clock_speed) VALUES (25, 'Intel Atom x5-Z8500', 4, 1.44, 2.24);
# INSERT INTO cpu (id, model, number_of_cores, low_clock_speed, high_clock_speed) VALUES (26, 'MTK 8382', 4, 1.3, NULL);
# INSERT INTO cpu (id, model, number_of_cores, low_clock_speed, high_clock_speed) VALUES (27, 'Qualcomm MSM8212', 4, 1.2, NULL);
# INSERT INTO cpu (id, model, number_of_cores, low_clock_speed, high_clock_speed) VALUES (28, 'Qualcomm Snapdragon 800', 4, 2.3, NULL);
# INSERT INTO cpu (id, model, number_of_cores, low_clock_speed, high_clock_speed) VALUES (29, 'Intel Atom Z3736F', 4, 1.33, 2.16);
#
# -- add few specifications
# INSERT INTO specifications (id, cpu_id, gpu_id, ram, memory_type_id, disk_memory, display_id, battery_capacity, battery_type_id, os_id, resolution_main_camera, resolution_front_camera, thickness, width, height, weight) VALUES (31, 21, 17, 2, 1, 128, 14, 7306, 1, 2, 12.0, 5.0, 6.1, 169.5, 240, 450);
# INSERT INTO specifications (id, cpu_id, gpu_id, ram, memory_type_id, disk_memory, display_id, battery_capacity, battery_type_id, os_id, resolution_main_camera, resolution_front_camera, thickness, width, height, weight) VALUES (32, 22, 18, 2, 1, 128, 15, 5124, 1, 2, 8.0, 1.2, 6.1, 134.8, 203.2, 299);
# INSERT INTO specifications (id, cpu_id, gpu_id, ram, memory_type_id, disk_memory, display_id, battery_capacity, battery_type_id, os_id, resolution_main_camera, resolution_front_camera, thickness, width, height, weight) VALUES (33, 23, 19, 2, 1, 64, 14, 7340, 1, 2, 8.0, 1.2, 6.1, 169.5, 240, 437);
# INSERT INTO specifications (id, cpu_id, gpu_id, ram, memory_type_id, disk_memory, display_id, battery_capacity, battery_type_id, os_id, resolution_main_camera, resolution_front_camera, thickness, width, height, weight) VALUES (34, 14, 8, 3, 1, 32, 14, 5870, 1, 3, 8.0, 2.1, 6.1, 169.5, 236, 390);
# INSERT INTO specifications (id, cpu_id, gpu_id, ram, memory_type_id, disk_memory, display_id, battery_capacity, battery_type_id, os_id, resolution_main_camera, resolution_front_camera, thickness, width, height, weight) VALUES (35, 24, 20, 2, 1, 16, 16, 7300, 1, 3, 8.0, 2.0, 8.2, 155, 254, 522);
#
# INSERT INTO specifications (id, cpu_id, gpu_id, ram, memory_type_id, disk_memory, display_id, battery_capacity, battery_type_id, os_id, resolution_main_camera, resolution_front_camera, thickness, width, height, weight) VALUES (36, 25, 12, 2, 1, 32, 17, 10200, 1, 5, 13.0, 5.0, 6.4, 179, 247, 662);
# INSERT INTO specifications (id, cpu_id, gpu_id, ram, memory_type_id, disk_memory, display_id, battery_capacity, battery_type_id, os_id, resolution_main_camera, resolution_front_camera, thickness, width, height, weight) VALUES (37, 26, 21, 1, 1, 16, 18, 6340, 2, 9, 5.0, 2.0, 9, 176, 264, 560);
# INSERT INTO specifications (id, cpu_id, gpu_id, ram, memory_type_id, disk_memory, display_id, battery_capacity, battery_type_id, os_id, resolution_main_camera, resolution_front_camera, thickness, width, height, weight) VALUES (38, 27, 21, 1, 1, 8, 19, 4800, 2, 10, 5.0, 0.3, 7.9, 128, 211, 360);
# INSERT INTO specifications (id, cpu_id, gpu_id, ram, memory_type_id, disk_memory, display_id, battery_capacity, battery_type_id, os_id, resolution_main_camera, resolution_front_camera, thickness, width, height, weight) VALUES (39, 28, 7, 2, 1, 32, 20, 9750, 1, 6, 8.0, 2.0, 8, 222, 301, 850);
# INSERT INTO specifications (id, cpu_id, gpu_id, ram, memory_type_id, disk_memory, display_id, battery_capacity, battery_type_id, os_id, resolution_main_camera, resolution_front_camera, thickness, width, height, weight) VALUES (40, 29, 12, 2, 1, 32, 19, 4800, 2, 8, 8.0, 2.0, 9, 140, 215, 380);
#
# -- add few graphics
# INSERT INTO files_upload (id, file_name) VALUES (31, 'file31.jpg');
# INSERT INTO files_upload (id, file_name) VALUES (32, 'file32.jpg');
# INSERT INTO files_upload (id, file_name) VALUES (33, 'file33.jpg');
# INSERT INTO files_upload (id, file_name) VALUES (34, 'file34.jpg');
# INSERT INTO files_upload (id, file_name) VALUES (35, 'file35.jpg');
#
# INSERT INTO files_upload (id, file_name) VALUES (36, 'file36.jpg');
# INSERT INTO files_upload (id, file_name) VALUES (37, 'file37.jpg');
# INSERT INTO files_upload (id, file_name) VALUES (38, 'file38.jpg');
# INSERT INTO files_upload (id, file_name) VALUES (39, 'file39.jpg');
# INSERT INTO files_upload (id, file_name) VALUES (40, 'file40.jpg');
#
# -- add few products
# INSERT INTO product (id, model, unit_price, category_id, manufacturer_id, product_image_id, specifications_id, units_in_magazine) VALUES (31, 'iPad Pro 9.7', 4299, 2, 1, 31, 31, 4);
# INSERT INTO product (id, model, unit_price, category_id, manufacturer_id, product_image_id, specifications_id, units_in_magazine) VALUES (32, 'iPad mini 4', 2399, 2, 1, 32, 32, 2);
# INSERT INTO product (id, model, unit_price, category_id, manufacturer_id, product_image_id, specifications_id, units_in_magazine) VALUES (33, 'iPad Air 2', 2349, 2, 1, 33, 33, 0);
# INSERT INTO product (id, model, unit_price, category_id, manufacturer_id, product_image_id, specifications_id, units_in_magazine) VALUES (34, 'Galaxy Tab S2 9.7', 2149, 2, 2, 34, 34, 0);
# INSERT INTO product (id, model, unit_price, category_id, manufacturer_id, product_image_id, specifications_id, units_in_magazine) VALUES (35, 'Galaxy Tab A 10.1', 1399, 2, 2, 35, 35, 1);
#
# INSERT INTO product (id, model, unit_price, category_id, manufacturer_id, product_image_id, specifications_id, units_in_magazine) VALUES (36, 'Yoga Tablet 3 Pro', 2499, 2, 3, 36, 36, 2);
# INSERT INTO product (id, model, unit_price, category_id, manufacturer_id, product_image_id, specifications_id, units_in_magazine) VALUES (37, 'A10-70', 842, 2, 3, 37, 37, 7);
# INSERT INTO product (id, model, unit_price, category_id, manufacturer_id, product_image_id, specifications_id, units_in_magazine) VALUES (38, 'MediaPad T1 8.0', 629, 2, 9, 38, 38, 5);
# INSERT INTO product (id, model, unit_price, category_id, manufacturer_id, product_image_id, specifications_id, units_in_magazine) VALUES (39, 'Pro Slate 12', 3975, 2, 10, 39, 39, 0);
# INSERT INTO product (id, model, unit_price, category_id, manufacturer_id, product_image_id, specifications_id, units_in_magazine) VALUES (40, 'Pro 408 G1', 1767, 2, 10, 40, 40, 0);
#
#
#
# -- ----------------------------------------------
# -- Notebook
# -- ----------------------------------------------
# -- add few operating systems
# INSERT INTO os (id, name, version) VALUES (11, 'Mac OS', 'X Yosemite');
# INSERT INTO os (id, name, version) VALUES (12, 'Mac OS', 'X El Capitan');
# INSERT INTO os (id, name, version) VALUES (13, 'Windows', '7 Professional');
# INSERT INTO os (id, name, version) VALUES (14, 'Windows', '10 Pro');
# INSERT INTO os (id, name, version) VALUES (15, 'Windows', '10 Home');
#
# -- add few display resolutions
# INSERT INTO display_resolution (id, width_in_pixels, height_in_pixels) VALUES (11, 2880, 1800);
# INSERT INTO display_resolution (id, width_in_pixels, height_in_pixels) VALUES (12, 1440, 900);
# INSERT INTO display_resolution (id, width_in_pixels, height_in_pixels) VALUES (13, 3840, 2160);
#
# -- add few displays
# INSERT INTO display (id, diagonal, display_resolution_id) VALUES (21, 15.4, 11);
# INSERT INTO display (id, diagonal, display_resolution_id) VALUES (22, 13.3, 12);
# INSERT INTO display (id, diagonal, display_resolution_id) VALUES (23, 14, 1);
# INSERT INTO display (id, diagonal, display_resolution_id) VALUES (24, 15.6, 13);
# INSERT INTO display (id, diagonal, display_resolution_id) VALUES (25, 15.6, 1);
# INSERT INTO display (id, diagonal, display_resolution_id) VALUES (26, 17.3, 13);
# INSERT INTO display (id, diagonal, display_resolution_id) VALUES (27, 17.3, 1);
#
# -- add few memory types
# INSERT INTO memory_type (id, type) VALUES (4, 'GDDR5');
#
# -- add few gpu
# INSERT INTO gpu (id, model) VALUES (22, 'Intel Iris Pro Graphics');
# INSERT INTO gpu (id, model) VALUES (23, 'Intel HD Graphics 6000');
# INSERT INTO gpu (id, model) VALUES (24, 'Intel HD Graphics 520');
# INSERT INTO gpu (id, model, memory, memory_type_id) VALUES (25, 'Intel HD Graphics 530 + NVIDIA GeForce GTX 960M', 2, 4);
# INSERT INTO gpu (id, model, memory, memory_type_id) VALUES (26, 'NVIDIA Quadro M600M', 8, 4);
# INSERT INTO gpu (id, model, memory, memory_type_id) VALUES (27, 'NVIDIA GeForce GTX 1070 SLI', 8, 4);
# INSERT INTO gpu (id, model, memory, memory_type_id) VALUES (28, 'NVIDIA GeForce GTX 980M', 4, 4);
#
# -- add few cpu
# INSERT INTO cpu (id, model, number_of_cores, low_clock_speed, high_clock_speed, cache) VALUES (30, 'Intel Core i7-4770HQ', 4, 2.2, 3.4, 6);
# INSERT INTO cpu (id, model, number_of_cores, low_clock_speed, high_clock_speed, cache) VALUES (31, 'Intel Core i5-5250U', 2, 1.6, 2.7, 3);
# INSERT INTO cpu (id, model, number_of_cores, low_clock_speed, high_clock_speed, cache) VALUES (32, 'Intel Core i5-6200U', 2, 2.3, 2.8, 3);
# INSERT INTO cpu (id, model, number_of_cores, low_clock_speed, high_clock_speed, cache) VALUES (33, 'Intel Core i7-6700HQ', 4, 2.6, 3.5, 6);
# INSERT INTO cpu (id, model, number_of_cores, low_clock_speed, high_clock_speed, cache) VALUES (34, 'Intel Xeon E3-1505M v5', 4, 2.8, 3.7, 8);
# INSERT INTO cpu (id, model, number_of_cores, low_clock_speed, high_clock_speed, cache) VALUES (35, 'Intel Core i7-6820HK', 4, 2.7, 3.6, 8);
#
# -- add few specifications
# INSERT INTO specifications (id, cpu_id, gpu_id, ram, memory_type_id, disk_memory, display_id, battery_capacity, battery_type_id, os_id, resolution_webcam, thickness, width, height, weight) VALUES (41, 30, 22, 16, 1, 256, 21, 6960, 1, 11, 1.0, 247, 359, 18, 2.05);
# INSERT INTO specifications (id, cpu_id, gpu_id, ram, memory_type_id, disk_memory, display_id, battery_capacity, battery_type_id, os_id, resolution_webcam, thickness, width, height, weight) VALUES (42, 31, 23, 8, 1, 256, 22, 6960, 1, 12, 1.0, 227, 325, 17, 1.35);
# INSERT INTO specifications (id, cpu_id, gpu_id, ram, memory_type_id, disk_memory, display_id, battery_capacity, battery_type_id, os_id, resolution_webcam, thickness, width, height, weight) VALUES (43, 32, 24, 8, 1, 512, 23, 5000, 2, 13, 2.0, 244, 340, 23.9, 1.95);
# INSERT INTO specifications (id, cpu_id, gpu_id, ram, memory_type_id, disk_memory, display_id, battery_capacity, battery_type_id, os_id, resolution_webcam, thickness, width, height, weight) VALUES (44, 33, 25, 16, 2, 512, 24, 7260, 2, 14, 1.0, 235, 357, 17, 1.78);
# INSERT INTO specifications (id, cpu_id, gpu_id, ram, memory_type_id, disk_memory, display_id, battery_capacity, battery_type_id, os_id, resolution_webcam, thickness, width, height, weight) VALUES (45, 33, 25, 16, 2, 512, 25, 6400, 1, 14, 1.0, 265, 383, 25.3, 2.6);
#
# INSERT INTO specifications (id, cpu_id, gpu_id, ram, memory_type_id, disk_memory, display_id, battery_capacity, battery_type_id, os_id, resolution_webcam, thickness, width, height, weight) VALUES (46, 34, 26, 16, 2, 512, 26, 6400, 1, 13, 1.0, 276, 416, 34.2, 3.3);
# INSERT INTO specifications (id, cpu_id, gpu_id, ram, memory_type_id, disk_memory, display_id, battery_capacity, battery_type_id, os_id, resolution_webcam, thickness, width, height, weight) VALUES (47, 33, 27, 32, 2, 1024, 27, 6000, 1, 15, 1.0, 322, 416, 39, 4);
# INSERT INTO specifications (id, cpu_id, gpu_id, ram, memory_type_id, disk_memory, display_id, battery_capacity, battery_type_id, os_id, resolution_webcam, thickness, width, height, weight) VALUES (48, 35, 27, 32, 2, 512, 27, 6000, 1, 15, 2.0, 287, 428, 49, 3.9);
# INSERT INTO specifications (id, cpu_id, gpu_id, ram, memory_type_id, disk_memory, display_id, battery_capacity, battery_type_id, os_id, resolution_webcam, thickness, width, height, weight) VALUES (49, 33, 28, 16, 2, 1024, 27, 7500, 1, 15, 2.0, 294, 428, 48, 3.8);
# INSERT INTO specifications (id, cpu_id, gpu_id, ram, memory_type_id, disk_memory, display_id, battery_capacity, battery_type_id, os_id, resolution_webcam, thickness, width, height, weight) VALUES (50, 33, 25, 32, 2, 512, 27, 5000, 2, 15, 1.0, 287, 418, 21.8, 2.65);
#
# -- add few graphics
# INSERT INTO files_upload (id, file_name) VALUES (41, 'file41.jpg');
# INSERT INTO files_upload (id, file_name) VALUES (42, 'file42.jpg');
# INSERT INTO files_upload (id, file_name) VALUES (43, 'file43.jpg');
# INSERT INTO files_upload (id, file_name) VALUES (44, 'file44.jpg');
# INSERT INTO files_upload (id, file_name) VALUES (45, 'file45.jpg');
#
# INSERT INTO files_upload (id, file_name) VALUES (46, 'file46.jpg');
# INSERT INTO files_upload (id, file_name) VALUES (47, 'file47.jpg');
# INSERT INTO files_upload (id, file_name) VALUES (48, 'file48.jpg');
# INSERT INTO files_upload (id, file_name) VALUES (49, 'file49.jpg');
# INSERT INTO files_upload (id, file_name) VALUES (50, 'file50.jpg');
#
# -- add few products
# INSERT INTO product (id, model, unit_price, category_id, manufacturer_id, product_image_id, specifications_id, units_in_magazine) VALUES (41, 'MacBook Pro', 8649, 3, 1, 41, 41, 4);
# INSERT INTO product (id, model, unit_price, category_id, manufacturer_id, product_image_id, specifications_id, units_in_magazine) VALUES (42, 'MacBook Air', 5799, 3, 1, 42, 42, 0);
# INSERT INTO product (id, model, unit_price, category_id, manufacturer_id, product_image_id, specifications_id, units_in_magazine) VALUES (43, 'Satellite Pro A40-C-152', 3270, 3, 11, 43, 43, 2);
# INSERT INTO product (id, model, unit_price, category_id, manufacturer_id, product_image_id, specifications_id, units_in_magazine) VALUES (44, 'XPS 15', 9499, 3, 12, 44, 44, 6);
# INSERT INTO product (id, model, unit_price, category_id, manufacturer_id, product_image_id, specifications_id, units_in_magazine) VALUES (45, 'Inspiron 7559', 5399, 3, 12, 45, 45, 2);
#
# INSERT INTO product (id, model, unit_price, category_id, manufacturer_id, product_image_id, specifications_id, units_in_magazine) VALUES (46, 'ThinkPad P70', 18999, 3, 3, 46, 46, 5);
# INSERT INTO product (id, model, unit_price, category_id, manufacturer_id, product_image_id, specifications_id, units_in_magazine) VALUES (47, 'G752VS-GC063T-32', 8899, 3, 8, 47, 47, 8);
# INSERT INTO product (id, model, unit_price, category_id, manufacturer_id, product_image_id, specifications_id, units_in_magazine) VALUES (48, 'GT73VR 6RE', 16299, 3, 13, 48, 48, 2);
# INSERT INTO product (id, model, unit_price, category_id, manufacturer_id, product_image_id, specifications_id, units_in_magazine) VALUES (49, 'GT72 Dominator Pro', 7529, 3, 13, 49, 49, 0);
# INSERT INTO product (id, model, unit_price, category_id, manufacturer_id, product_image_id, specifications_id, units_in_magazine) VALUES (50, 'GS70 Stealth', 6829, 3, 13, 50, 50, 0);
#
#
#
# -- ----------------------------------------------
# -- PC
# -- ----------------------------------------------
# -- add few gpu
# INSERT INTO gpu (id, model) VALUES (29, 'Intel HD Graphics 4400');
# INSERT INTO gpu (id, model, memory, memory_type_id) VALUES (30, 'AMD Radeon R9 370', 2, 4);
# INSERT INTO gpu (id, model) VALUES (31, 'Intel HD Graphics 530');
#
# -- add few cpu
# INSERT INTO cpu (id, model, number_of_cores, low_clock_speed, high_clock_speed, cache) VALUES (36, 'Intel Pentium G3250', 2, 3.2, NULL, 3);
# INSERT INTO cpu (id, model, number_of_cores, low_clock_speed, high_clock_speed, cache) VALUES (37, 'Intel Core i3-4170', 2, 3.7, NULL, 3);
# INSERT INTO cpu (id, model, number_of_cores, low_clock_speed, high_clock_speed, cache) VALUES (38, 'Intel Core i7-6700', 4, 3.4, 4.0, 8);
# INSERT INTO cpu (id, model, number_of_cores, low_clock_speed, high_clock_speed, cache) VALUES (39, 'Intel Core i5-6400', 4, 2.7, 3.3, 6);
# INSERT INTO cpu (id, model, number_of_cores, low_clock_speed, high_clock_speed, cache) VALUES (40, 'Intel Core i3-6100', 2, 3.7, NULL, 3);
#
# -- add few specifications
# INSERT INTO specifications (id, cpu_id, gpu_id, ram, memory_type_id, disk_memory, power_supply, os_id, thickness, width, height, weight) VALUES (51, 36, 12, 4, 1, 512, 180, 13, 355, 165, 359, 7);
# INSERT INTO specifications (id, cpu_id, gpu_id, ram, memory_type_id, disk_memory, power_supply, os_id, thickness, width, height, weight) VALUES (52, 37, 29, 4, 1, 512, 300, 13, 441, 175, 360, 10);
# INSERT INTO specifications (id, cpu_id, gpu_id, ram, memory_type_id, disk_memory, power_supply, os_id, thickness, width, height, weight) VALUES (53, 38, 30, 16, 2, 256, 460, 14, 445, 185, 405, 13.8);
# INSERT INTO specifications (id, cpu_id, gpu_id, ram, memory_type_id, disk_memory, power_supply, os_id, thickness, width, height, weight) VALUES (54, 39, 31, 16, 2, 256, 400, 15, 560, 270, 588, 7);
# INSERT INTO specifications (id, cpu_id, gpu_id, ram, memory_type_id, disk_memory, power_supply, os_id, thickness, width, height, weight) VALUES (55, 40, 31, 8, 2, 256, 300, 15, 400, 106, 308, 5.9);
#
# -- add few graphics
# INSERT INTO files_upload (id, file_name) VALUES (51, 'file51.jpg');
# INSERT INTO files_upload (id, file_name) VALUES (52, 'file52.jpg');
# INSERT INTO files_upload (id, file_name) VALUES (53, 'file53.jpg');
# INSERT INTO files_upload (id, file_name) VALUES (54, 'file54.jpg');
# INSERT INTO files_upload (id, file_name) VALUES (55, 'file55.jpg');
#
# -- add few products
# INSERT INTO product (id, model, unit_price, category_id, manufacturer_id, product_image_id, specifications_id, units_in_magazine) VALUES (51, '280 G1 MT', 1199, 4, 10, 51, 51, 0);
# INSERT INTO product (id, model, unit_price, category_id, manufacturer_id, product_image_id, specifications_id, units_in_magazine) VALUES (52, 'Vostro 3900', 1799, 4, 12, 52, 52, 2);
# INSERT INTO product (id, model, unit_price, category_id, manufacturer_id, product_image_id, specifications_id, units_in_magazine) VALUES (53, 'XPS 8900', 5299, 4, 12, 53, 53, 1);
# INSERT INTO product (id, model, unit_price, category_id, manufacturer_id, product_image_id, specifications_id, units_in_magazine) VALUES (54, 'IdeaCentre 300-20', 2359, 4, 3, 54, 54, 8);
# INSERT INTO product (id, model, unit_price, category_id, manufacturer_id, product_image_id, specifications_id, units_in_magazine) VALUES (55, 'IdeaCentre 700-25', 1549, 4, 3, 55, 55, 0);
#
#
#
# -- ----------------------------------------------
# -- Console
# -- ----------------------------------------------
# -- add few gpu
# INSERT INTO gpu (id, model) VALUES (32, 'AMD Radeon Graphics Core Next ');
# INSERT INTO gpu (id, model) VALUES (33, 'ATI R500');
#
# -- add few cpu
# INSERT INTO cpu (id, model, number_of_cores, low_clock_speed, high_clock_speed) VALUES (41, 'AMD Jaguar x64', 8, 1.75, NULL);
# INSERT INTO cpu (id, model, number_of_cores, low_clock_speed, high_clock_speed) VALUES (42, 'IBM PowerPC Xenon', 3, 3.2, NULL);
#
# -- add few specifications
# INSERT INTO specifications (id, cpu_id, gpu_id, ram, memory_type_id, disk_memory, thickness, width, height, weight) VALUES (56, 41, 32, 8, 3, 512, 305, 53, 275, 2.8);
# INSERT INTO specifications (id, cpu_id, gpu_id, ram, memory_type_id, disk_memory, thickness, width, height, weight) VALUES (57, 42, 33, 1, 1, 512, 264, 75, 270, 2.9);
# INSERT INTO specifications (id, cpu_id, gpu_id, ram, memory_type_id, disk_memory, thickness, width, height, weight) VALUES (58, 41, 32, 8, 1, 512, 274, 79, 333, 3.86);
# INSERT INTO specifications (id, cpu_id, gpu_id, ram, memory_type_id, disk_memory, thickness, width, height, weight) VALUES (59, 41, 32, 8, 1, 1024, 274, 67, 333, 2.9);
#
# -- add few graphics
# INSERT INTO files_upload (id, file_name) VALUES (56, 'file56.jpg');
# INSERT INTO files_upload (id, file_name) VALUES (57, 'file57.jpg');
# INSERT INTO files_upload (id, file_name) VALUES (58, 'file58.jpg');
# INSERT INTO files_upload (id, file_name) VALUES (59, 'file59.jpg');
#
# -- add few products
# INSERT INTO product (id, model, unit_price, category_id, manufacturer_id, product_image_id, specifications_id, units_in_magazine) VALUES (56, 'PlayStation 4', 1279, 5, 5, 56, 56, 2);
# INSERT INTO product (id, model, unit_price, category_id, manufacturer_id, product_image_id, specifications_id, units_in_magazine) VALUES (57, 'Xbox 360', 799, 5, 6, 57, 57, 1);
# INSERT INTO product (id, model, unit_price, category_id, manufacturer_id, product_image_id, specifications_id, units_in_magazine) VALUES (58, 'Xbox ONE', 1299, 5, 6, 58, 58, 0);
# INSERT INTO product (id, model, unit_price, category_id, manufacturer_id, product_image_id, specifications_id, units_in_magazine) VALUES (59, 'Xbox ONE S', 1599, 5, 6, 59, 59, 3);
#
#
#
# -- ----------------------------------------------
# -- Smartwatch
# -- ----------------------------------------------
# -- add few operating systems
# INSERT INTO os (id, name, version) VALUES (16, 'Apple', 'watchOS');
# INSERT INTO os (id, name, version) VALUES (17, 'Linux', 'Tizen');
# INSERT INTO os (id, name, version) VALUES (18, 'Android', 'Wear');
#
# -- add few display resolutions
# INSERT INTO display_resolution (id, width_in_pixels, height_in_pixels) VALUES (14, 272, 340);
# INSERT INTO display_resolution (id, width_in_pixels, height_in_pixels) VALUES (15, 312, 390);
# INSERT INTO display_resolution (id, width_in_pixels, height_in_pixels) VALUES (16, 320, 320);
#
# -- add few displays
# INSERT INTO display (id, diagonal, display_resolution_id) VALUES (28, 1.3, 14);
# INSERT INTO display (id, diagonal, display_resolution_id) VALUES (29, 1.5, 15);
# INSERT INTO display (id, diagonal, display_resolution_id) VALUES (30, 1.2, 16);
# INSERT INTO display (id, diagonal, display_resolution_id) VALUES (31, 1.8, 16);
#
# -- add few cpu
# INSERT INTO cpu (id, model, number_of_cores, low_clock_speed, high_clock_speed) VALUES (43, 'Apple S1', 1, 0.52, NULL);
# INSERT INTO cpu (id, model, number_of_cores, low_clock_speed, high_clock_speed) VALUES (44, 'Apple S2', 2, 0.52, NULL);
# INSERT INTO cpu (id, model, number_of_cores, low_clock_speed, high_clock_speed) VALUES (45, 'Samsung Exynos 3250', 2, 1.0, NULL);
#
# -- add few specifications
# INSERT INTO specifications (id, cpu_id, ram, disk_memory, display_id, battery_capacity, battery_type_id, os_id, thickness, width, height, weight) VALUES (60, 43, 512, 8, 28, 205, 1, 16, 10.5, 33.3, 38.6, 40);
# INSERT INTO specifications (id, cpu_id, ram, disk_memory, display_id, battery_capacity, battery_type_id, os_id, thickness, width, height, weight) VALUES (61, 44, 512, 8, 28, 205, 1, 16, 11.4, 33.3, 38.6, 28);
# INSERT INTO specifications (id, cpu_id, ram, disk_memory, display_id, battery_capacity, battery_type_id, os_id, thickness, width, height, weight) VALUES (62, 43, 512, 8, 29, 246, 1, 16, 10.5, 35.9, 42, 30);
# INSERT INTO specifications (id, cpu_id, ram, disk_memory, display_id, battery_capacity, battery_type_id, os_id, thickness, width, height, weight) VALUES (63, 45, 512, 4, 30, 250, 1, 17, 11.4, 42.3, 49.8, 51);
# INSERT INTO specifications (id, cpu_id, ram, disk_memory, display_id, battery_capacity, battery_type_id, os_id, thickness, width, height, weight) VALUES (64, 45, 512, 4, 31, 420, 2, 18, 10, 36, 51, 45);
#
# -- add few graphics
# INSERT INTO files_upload (id, file_name) VALUES (60, 'file60.jpg');
# INSERT INTO files_upload (id, file_name) VALUES (61, 'file61.jpg');
# INSERT INTO files_upload (id, file_name) VALUES (62, 'file62.jpg');
# INSERT INTO files_upload (id, file_name) VALUES (63, 'file63.jpg');
# INSERT INTO files_upload (id, file_name) VALUES (64, 'file64.jpg');
#
# -- add few products
# INSERT INTO product (id, model, unit_price, category_id, manufacturer_id, product_image_id, specifications_id, units_in_magazine) VALUES (60, 'Watch', 3749, 6, 1, 60, 60, 5);
# INSERT INTO product (id, model, unit_price, category_id, manufacturer_id, product_image_id, specifications_id, units_in_magazine) VALUES (61, 'Watch 2', 3749, 6, 1, 61, 61, 1);
# INSERT INTO product (id, model, unit_price, category_id, manufacturer_id, product_image_id, specifications_id, units_in_magazine) VALUES (62, 'Watch Sport', 1699, 6, 1, 62, 62, 0);
# INSERT INTO product (id, model, unit_price, category_id, manufacturer_id, product_image_id, specifications_id, units_in_magazine) VALUES (63, 'Gear S2', 999, 6, 2, 63, 63, 0);
# INSERT INTO product (id, model, unit_price, category_id, manufacturer_id, product_image_id, specifications_id, units_in_magazine) VALUES (64, 'SmartWatch 3', 649, 6, 5, 64, 64, 3);
#
#
#
#
#
#
#
#
#
#
#
# INSERT INTO product (id, model, unit_price, category_id, manufacturer_id) VALUES (101, 'abc', 1000, 1, 2);
# INSERT INTO product (id, model, unit_price, category_id, manufacturer_id) VALUES (102, 'klm', 2000, 1, 3);
# INSERT INTO product (id, model, unit_price, category_id, manufacturer_id) VALUES (103, 'xyz', 3000, 1, 4);
#
#
# INSERT INTO product (id, model, unit_price, category_id, manufacturer_id) VALUES (104, 'abc', 1000, 2, 2);
# INSERT INTO product (id, model, unit_price, category_id, manufacturer_id) VALUES (105, 'klm', 2000, 2, 3);
# INSERT INTO product (id, model, unit_price, category_id, manufacturer_id) VALUES (106, 'xyz', 3000, 2, 4);
#
#
# INSERT INTO product (id, model, unit_price, category_id, manufacturer_id) VALUES (107, 'abc', 1000, 3, 2);
# INSERT INTO product (id, model, unit_price, category_id, manufacturer_id) VALUES (108, 'klm', 2000, 3, 3);
# INSERT INTO product (id, model, unit_price, category_id, manufacturer_id) VALUES (109, 'xyz', 3000, 3, 4);
#
#
# INSERT INTO product (id, model, unit_price, category_id, manufacturer_id) VALUES (110, 'abc', 1000, 4, 2);
# INSERT INTO product (id, model, unit_price, category_id, manufacturer_id) VALUES (111, 'klm', 2000, 4, 3);
# INSERT INTO product (id, model, unit_price, category_id, manufacturer_id) VALUES (112, 'xyz', 3000, 4, 4);
#
# INSERT INTO product (id, model, unit_price, category_id, manufacturer_id) VALUES (113, 'abc', 1000, 5, 2);
# INSERT INTO product (id, model, unit_price, category_id, manufacturer_id) VALUES (114, 'klm', 2000, 5, 3);
# INSERT INTO product (id, model, unit_price, category_id, manufacturer_id) VALUES (115, 'xyz', 3000, 5, 4);
#
# INSERT INTO product (id, model, unit_price, category_id, manufacturer_id) VALUES (116, 'abc', 1000, 6, 2);
# INSERT INTO product (id, model, unit_price, category_id, manufacturer_id) VALUES (117, 'klm', 2000, 6, 3);
# INSERT INTO product (id, model, unit_price, category_id, manufacturer_id) VALUES (118, 'xyz', 3000, 6, 4);
#
#
#
# -- ----------------------------------------------
# -- add few countries
# INSERT INTO country (id, name) VALUES (1, 'Polska');
# INSERT INTO country (id, name) VALUES (2, 'Niemcy');
# INSERT INTO country (id, name) VALUES (3, 'Czechy');
# INSERT INTO country (id, name) VALUES (4, 'Slowacja');
# INSERT INTO country (id, name) VALUES (5, 'Litwa');
#
# -- add few cities
# INSERT INTO city (id, name, country_id) VALUES (1, 'Warszawa', 1);
# INSERT INTO city (id, name, country_id) VALUES (2, 'Krakow', 1);
# INSERT INTO city (id, name, country_id) VALUES (3, 'Gdansk', 1);
#
# -- add few addresses
# INSERT INTO address (id, street, street_number, door_number, zip_code, city_id) VALUES (1, 'Koszycka', '6A', '25', '01-446', 1);
# INSERT INTO address (id, street, street_number, door_number, zip_code, city_id) VALUES (2, 'Tyszkiewicza', '28', '3', '01-182', 1);
# INSERT INTO address (id, street, street_number, zip_code, city_id) VALUES (3, 'Syta', '50', '01-446', 1);
# INSERT INTO address (id, street, street_number, door_number, zip_code, city_id) VALUES (4, 'Krowoderska', '61', '12', '31-141', 2);
# INSERT INTO address (id, street, street_number, zip_code, city_id) VALUES (5, 'Osiedlowa', '10B', '31-964', 2);
#
#
#
# -- ----------------------------------------------
# -- add few customers
# INSERT INTO customer (id, first_name, last_name, birth_date, phone_number, number_of_orders) VALUES (1, 'Michal', 'Aaa', STR_TO_DATE('21-03-1994', '%d-%m-%Y'), '111222333', 1);
# INSERT INTO customer (id, first_name, last_name, birth_date, phone_number, number_of_orders) VALUES (2, 'Weronika', 'Bbb', STR_TO_DATE('21-03-1997', '%d-%m-%Y'), '222333444', 2);
# INSERT INTO customer (id, first_name, last_name, birth_date, phone_number, number_of_orders) VALUES (3, 'Radek', 'Ccc', STR_TO_DATE('21-03-1999', '%d-%m-%Y'), '333444555', 0);
#
# -- add few accounts
# INSERT INTO account (id, username, password, enabled, email, date_created, role, customer_id) VALUES (1, 'aaa', '111', true, 'a1@gmail.com', STR_TO_DATE('21-03-2007 05:31:55', '%d-%m-%Y %H:%i:%s'), 'ROLE_USER', 1);
# INSERT INTO account (id, username, password, enabled, email, date_created, role, customer_id) VALUES (2, 'bbb', '222', true, 'b2@gmail.com', STR_TO_DATE('14-11-2008 20:22:31', '%d-%m-%Y %H:%i:%s'), 'ROLE_USER', 2);
# INSERT INTO account (id, username, password, enabled, email, date_created, role, customer_id) VALUES (3, 'ccc', '333', true, 'c3@gmail.com', STR_TO_DATE('05-06-2009 11:44:07', '%d-%m-%Y %H:%i:%s'), 'ROLE_USER', 3);
# INSERT INTO account (id, username, password, enabled, email, date_created, role) VALUES (4, 'yyy', '888', true, 'y8@gmail.com', STR_TO_DATE('22-12-2015 16:24:00', '%d-%m-%Y %H:%i:%s'), 'ROLE_ADMIN');
# INSERT INTO account (id, username, password, enabled, email, date_created, role) VALUES (5, 'zzz', '999', true, 'z9@gmail.com', STR_TO_DATE('01-01-2016 23:01:50', '%d-%m-%Y %H:%i:%s'), 'ROLE_ADMIN');
#
#
#
#
#
#
#
#
#
#
#
#
#

-- add few shipping details
INSERT INTO shipping_detail (id, date_delivery, shipping_address_id) VALUES (1, STR_TO_DATE('21-03-2016', '%d-%m-%Y'), 1);
INSERT INTO shipping_detail (id, date_delivery, shipping_address_id) VALUES (2, STR_TO_DATE('02-04-2016', '%d-%m-%Y'), 2);
INSERT INTO shipping_detail (id, date_delivery, shipping_address_id) VALUES (3, STR_TO_DATE('13-05-2016', '%d-%m-%Y'), 3);
INSERT INTO shipping_detail (id, date_delivery, shipping_address_id) VALUES (4, STR_TO_DATE('24-06-2016', '%d-%m-%Y'), 4);

-- add few items
INSERT INTO item (id, product_id, shipping_address_id, quantity, item_total_price) VALUES (1, 1, 1, 1, 4479);
INSERT INTO item (id, product_id, shipping_address_id, quantity, item_total_price) VALUES (2, 1, 2, 2, 8958);
INSERT INTO item (id, product_id, shipping_address_id, quantity, item_total_price) VALUES (3, 2, 3, 1, 3879);
INSERT INTO item (id, product_id, shipping_address_id, quantity, item_total_price) VALUES (4, 3, 4, 2, 7758);

-- add few carts
INSERT INTO cart (id, cart, cart_total_price) VALUES (1, 1, 4479);
INSERT INTO cart (id, cart, cart_total_price) VALUES (2, 2, 8958);
INSERT INTO cart (id, cart, cart_total_price) VALUES (3, 2, 3879);
INSERT INTO cart (id, cart, cart_total_price) VALUES (4, 3, 7758);

-- add few orders
INSERT INTO cart (id, cart_id, customer_id, shipping_detail_id, date_created, status) VALUES (1, 1, 1, 1, STR_TO_DATE('19-03-2016'), 'no');
INSERT INTO cart (id, cart_id, customer_id, shipping_detail_id, date_created, status) VALUES (2, 2, 1, 1, STR_TO_DATE('19-03-2016'), 'no');
INSERT INTO cart (id, cart_id, customer_id, shipping_detail_id, date_created, status) VALUES (3, 3, 2, 2, STR_TO_DATE('19-03-2016'), 'yes');
INSERT INTO cart (id, cart_id, customer_id, shipping_detail_id, date_created, status) VALUES (4, 4, 3, 3, STR_TO_DATE('19-03-2016'), 'yes');