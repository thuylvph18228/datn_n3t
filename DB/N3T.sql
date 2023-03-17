/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

CREATE DATABASE IF NOT EXISTS `webbangiay` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `webbangiay`;

CREATE TABLE IF NOT EXISTS `accounts` (
                                          `acc_id` int NOT NULL AUTO_INCREMENT,
                                          `username` varchar(50) NOT NULL,
    `password` varchar(20) NOT NULL,
    `fullname` varchar(100) DEFAULT NULL,
    `email` varchar(100) NOT NULL,
    `phone` int DEFAULT NULL,
    `gender` int NOT NULL,
    `birthdate` datetime DEFAULT NULL,
    `updated_at` datetime NOT NULL,
    `created_at` datetime NOT NULL,
    `role_id` int DEFAULT NULL,
    PRIMARY KEY (`acc_id`),
    UNIQUE KEY `unque_acc` (`email`,`username`),
    KEY `role_acc` (`role_id`),
    CONSTRAINT `role_acc` FOREIGN KEY (`role_id`) REFERENCES `roles` (`role_id`) ON DELETE CASCADE
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `accounts` (`acc_id`, `username`, `password`, `fullname`, `email`, `phone`, `gender`, `birthdate`, `updated_at`, `created_at`, `role_id`) VALUES
                                                                                                                                                          (1, 'nghiatm', '123456', 'Trần Minh Nghĩa', 'nghiatmph18153@fpt.edu.vn', 98438263, 1, '2002-10-19 00:00:00', '2023-03-15 08:55:43', '2023-03-15 08:55:44', 1),
                                                                                                                                                          (2, 'nva', '123456', 'Nguyễn Văn A', 'nva@gmail.com', 98438263, 2, '2002-10-19 00:00:00', '2023-03-15 08:55:43', '2023-03-15 08:55:43', 2),
                                                                                                                                                          (3, 'nvb', '123456', 'Nguyễn Văn B', 'nvb@gmail.com', 98438263, 1, '2002-10-19 00:00:00', '2023-03-15 08:55:43', '2023-03-15 08:55:43', 3),
                                                                                                                                                          (4, 'nvc', '123456', 'Nguyễn Văn C', 'nvc@gmail.com', 98438263, 2, '2002-10-19 00:00:00', '2023-03-15 08:55:43', '2023-03-15 08:55:43', 2),
                                                                                                                                                          (5, 'nvd', '123456', 'Nguyễn Văn D', 'nvd@gmail.com', 98438263, 1, '2002-10-19 00:00:00', '2023-03-15 08:55:43', '2023-03-15 08:55:43', 3);

CREATE TABLE IF NOT EXISTS `address` (
                                         `add_id` int NOT NULL AUTO_INCREMENT,
                                         `address` varchar(100) NOT NULL,
    `district` varchar(50) NOT NULL,
    `provice` varchar(50) NOT NULL,
    `city` varchar(50) NOT NULL,
    `ward` varchar(50) NOT NULL,
    `name` varchar(50) NOT NULL,
    `phone` int NOT NULL,
    `default` bit(1) NOT NULL,
    `acc_id` int NOT NULL,
    PRIMARY KEY (`add_id`),
    KEY `add_acc` (`acc_id`),
    CONSTRAINT `add_acc` FOREIGN KEY (`acc_id`) REFERENCES `accounts` (`acc_id`) ON DELETE CASCADE
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `address` (`add_id`, `address`, `district`, `provice`, `city`, `ward`, `name`, `phone`, `default`, `acc_id`) VALUES
                                                                                                                             (1, '11 Mễ trì thượng', 'Nam Từ Liêm', 'Hà Nội', 'Hà Nội', 'Mễ Trì', 'Nghĩa', 943892374, b'1', 1),
                                                                                                                             (2, '12 Mễ trì hạ', 'Nam Từ Liêm', 'Hà Nội', 'Hà Nội', 'Mễ Trì', 'A', 943892374, b'1', 2),
                                                                                                                             (3, '11 Láng', 'Đống Đa', 'Hà Nội', 'Hà Nội', 'Đống ĐA', 'B', 943892374, b'1', 3),
                                                                                                                             (4, '11 Cầu giấy', 'Cầu Giấy', 'Hà Nội', 'Hà Nội', 'Dịch Vọng', 'C', 943892374, b'1', 4),
                                                                                                                             (5, '11 Xuân Thủy', 'Cầu Giấy', 'Hà Nội', 'Hà Nội', 'Dịch Vọng', 'D', 943892374, b'1', 5);

CREATE TABLE IF NOT EXISTS `bill` (
                                      `bill_id` int NOT NULL AUTO_INCREMENT,
                                      `create_date` datetime NOT NULL,
                                      `total_price` double NOT NULL DEFAULT '0',
                                      `price_after_voucher` double NOT NULL DEFAULT '0',
                                      `address` varchar(50) NOT NULL DEFAULT '',
    `ship_price` double NOT NULL DEFAULT '0',
    `update_date` datetime NOT NULL,
    `receiver_name` varchar(50) NOT NULL DEFAULT '',
    `email` varchar(100) NOT NULL DEFAULT '',
    `district` varchar(50) NOT NULL DEFAULT '',
    `provice` varchar(50) NOT NULL DEFAULT '',
    `city` varchar(50) NOT NULL DEFAULT '',
    `name` varchar(50) NOT NULL DEFAULT '',
    `ward` varchar(50) NOT NULL DEFAULT '',
    `phone` int NOT NULL,
    `note` varchar(150) NOT NULL DEFAULT '',
    `acc_id` int NOT NULL,
    `vc_id` int NOT NULL,
    `pay_id` int NOT NULL,
    PRIMARY KEY (`bill_id`),
    KEY `bill_acc` (`acc_id`),
    KEY `bill_vc` (`vc_id`),
    KEY `bill_pay` (`pay_id`),
    CONSTRAINT `bill_acc` FOREIGN KEY (`acc_id`) REFERENCES `accounts` (`acc_id`),
    CONSTRAINT `bill_pay` FOREIGN KEY (`pay_id`) REFERENCES `pay` (`pay_id`),
    CONSTRAINT `bill_vc` FOREIGN KEY (`vc_id`) REFERENCES `vouchers` (`vc_id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE IF NOT EXISTS `bill_product` (
                                              `bill_prod_id` int NOT NULL AUTO_INCREMENT,
                                              `amount` double NOT NULL DEFAULT '0',
                                              `price` double NOT NULL DEFAULT '0',
                                              `quantity` int NOT NULL,
                                              `bill_id` int NOT NULL,
                                              `prod_id` int NOT NULL,
                                              PRIMARY KEY (`bill_prod_id`),
    KEY `bill` (`bill_id`),
    KEY `prod_bill` (`prod_id`),
    CONSTRAINT `bill` FOREIGN KEY (`bill_id`) REFERENCES `bill` (`bill_id`) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT `prod_bill` FOREIGN KEY (`prod_id`) REFERENCES `products` (`prod_id`) ON DELETE CASCADE ON UPDATE CASCADE
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE IF NOT EXISTS `brand` (
                                       `brd_id` int NOT NULL AUTO_INCREMENT,
                                       `name_brd` varchar(50) DEFAULT NULL,
    `updated_at` datetime DEFAULT NULL,
    `created_at` datetime DEFAULT NULL,
    PRIMARY KEY (`brd_id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `brand` (`brd_id`, `name_brd`, `updated_at`, `created_at`) VALUES
                                                                           (1, 'Nike', '2023-03-15 09:51:21', '2023-03-15 09:51:21'),
                                                                           (2, 'Adidas', '2023-03-15 09:51:21', '2023-03-15 09:51:21'),
                                                                           (3, 'Bitis', '2023-03-15 09:51:21', '2023-03-15 09:51:21'),
                                                                           (4, 'Ananas', '2023-03-15 09:51:21', '2023-03-15 09:51:21'),
                                                                           (5, 'Vans', '2023-03-15 09:51:21', '2023-03-15 09:51:21'),
                                                                           (6, 'Converse', '2023-03-15 09:51:21', '2023-03-15 09:51:21'),
                                                                           (7, 'MLB', '2023-03-15 09:51:21', '2023-03-15 09:51:21'),
                                                                           (8, 'New Balance', '2023-03-15 09:51:21', '2023-03-15 09:51:21');

CREATE TABLE IF NOT EXISTS `category` (
                                          `cate_id` int NOT NULL AUTO_INCREMENT,
                                          `name_cate` varchar(50) DEFAULT NULL,
    `updated_at` datetime DEFAULT NULL,
    `created_at` datetime DEFAULT NULL,
    PRIMARY KEY (`cate_id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `category` (`cate_id`, `name_cate`, `updated_at`, `created_at`) VALUES
                                                                                (1, 'Giày thể thao', '2023-03-15 10:02:32', '2023-03-15 10:02:32'),
                                                                                (2, 'Giày tây', '2023-03-15 10:02:32', '2023-03-15 10:02:32'),
                                                                                (3, 'Giày đá bóng', '2023-03-15 10:02:32', '2023-03-15 10:02:32'),
                                                                                (4, 'Sneaker', '2023-03-15 10:02:32', '2023-03-15 10:02:32'),
                                                                                (5, 'Giày lười', '2023-03-15 10:02:32', '2023-03-15 10:02:32');

CREATE TABLE IF NOT EXISTS `colors` (
                                        `color_id` int NOT NULL AUTO_INCREMENT,
                                        `name_color` varchar(50) NOT NULL,
    `created_at` datetime NOT NULL,
    `updated_at` datetime NOT NULL,
    `prod_id` int NOT NULL,
    PRIMARY KEY (`color_id`),
    KEY `color_prod` (`prod_id`),
    CONSTRAINT `color_prod` FOREIGN KEY (`prod_id`) REFERENCES `products` (`prod_id`) ON DELETE CASCADE ON UPDATE CASCADE
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `colors` (`color_id`, `name_color`, `created_at`, `updated_at`, `prod_id`) VALUES
                                                                                           (1, 'Đen', '2023-03-15 10:14:22', '2023-03-15 10:14:22', 1),
                                                                                           (2, 'Trắng', '2023-03-15 10:14:22', '2023-03-15 10:14:22', 1),
                                                                                           (3, 'Đen', '2023-03-15 10:14:22', '2023-03-15 10:14:22', 2),
                                                                                           (4, 'Vàng', '2023-03-15 10:14:22', '2023-03-15 10:14:22', 2),
                                                                                           (5, 'Đen', '2023-03-15 10:14:22', '2023-03-15 10:14:22', 3),
                                                                                           (6, 'Xanh', '2023-03-15 10:14:22', '2023-03-15 10:14:22', 3),
                                                                                           (7, 'Đen', '2023-03-15 10:14:22', '2023-03-15 10:14:22', 4),
                                                                                           (8, 'Trắng', '2023-03-15 10:14:22', '2023-03-15 10:14:22', 4),
                                                                                           (9, 'Đen', '2023-03-15 10:14:22', '2023-03-15 10:14:22', 5),
                                                                                           (10, 'Trắng', '2023-03-15 10:14:22', '2023-03-15 10:14:22', 5),
                                                                                           (11, 'Đen', '2023-03-15 10:14:22', '2023-03-15 10:14:22', 6),
                                                                                           (12, 'Trắng', '2023-03-15 10:14:22', '2023-03-15 10:14:22', 6);

CREATE TABLE IF NOT EXISTS `feedback` (
                                          `fb_id` int NOT NULL AUTO_INCREMENT,
                                          `rating_type` int DEFAULT NULL,
                                          `describe` varchar(50) DEFAULT NULL,
    PRIMARY KEY (`fb_id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE IF NOT EXISTS `image` (
                                       `img_id` int NOT NULL AUTO_INCREMENT,
                                       `alt_text` varchar(50) NOT NULL,
    `image_path` varchar(50) NOT NULL,
    `updated_at` datetime NOT NULL,
    `created_at` datetime NOT NULL,
    `prod_id` int DEFAULT NULL,
    PRIMARY KEY (`img_id`),
    KEY `img_prod` (`prod_id`),
    CONSTRAINT `img_prod` FOREIGN KEY (`prod_id`) REFERENCES `products` (`prod_id`) ON DELETE CASCADE ON UPDATE CASCADE
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE IF NOT EXISTS `origin` (
                                        `org_id` int NOT NULL AUTO_INCREMENT,
                                        `country` varchar(50) DEFAULT NULL,
    `updated_at` datetime DEFAULT NULL,
    `created_at` datetime DEFAULT NULL,
    PRIMARY KEY (`org_id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `origin` (`org_id`, `country`, `updated_at`, `created_at`) VALUES
                                                                           (1, 'Việt Nam', '2023-03-15 09:04:43', '2023-03-15 09:04:43'),
                                                                           (2, 'Trung Quốc', '2023-03-15 09:04:43', '2023-03-15 09:04:43'),
                                                                           (3, 'Mỹ', '2023-03-15 09:04:43', '2023-03-15 09:04:43'),
                                                                           (4, 'Thái Lan', '2023-03-15 09:04:43', '2023-03-15 09:04:43'),
                                                                           (5, 'Nhật Bản', '2023-03-15 09:04:43', '2023-03-15 09:04:43'),
                                                                           (6, 'Đài Loan', '2023-03-15 09:04:43', '2023-03-15 09:04:43'),
                                                                           (7, 'Singapore', '2023-03-15 09:04:43', '2023-03-15 09:04:43'),
                                                                           (8, 'Lào', '2023-03-15 09:04:43', '2023-03-15 09:04:43'),
                                                                           (9, 'Pháp', '2023-03-15 09:04:43', '2023-03-15 09:04:43'),
                                                                           (10, 'Anh', '2023-03-15 09:04:43', '2023-03-15 09:04:43');

CREATE TABLE IF NOT EXISTS `pay` (
                                     `pay_id` int NOT NULL AUTO_INCREMENT,
                                     `name_pay` varchar(50) NOT NULL,
    PRIMARY KEY (`pay_id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE IF NOT EXISTS `products` (
                                          `prod_id` int NOT NULL AUTO_INCREMENT,
                                          `name_prod` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
    `status` int DEFAULT NULL,
    `gender` int DEFAULT NULL,
    `total_amount` double DEFAULT NULL,
    `available` bit(1) DEFAULT NULL,
    `created_at` datetime DEFAULT NULL,
    `updated_at` datetime DEFAULT NULL,
    `org_id` int DEFAULT NULL,
    `cate_id` int DEFAULT NULL,
    `brd_id` int DEFAULT NULL,
    PRIMARY KEY (`prod_id`),
    KEY `org_prod` (`org_id`),
    KEY `cate_prod` (`cate_id`),
    KEY `brd_id` (`brd_id`),
    CONSTRAINT `brd_id` FOREIGN KEY (`brd_id`) REFERENCES `brand` (`brd_id`) ON DELETE SET NULL ON UPDATE CASCADE,
    CONSTRAINT `cate_prod` FOREIGN KEY (`cate_id`) REFERENCES `category` (`cate_id`) ON DELETE SET NULL ON UPDATE CASCADE,
    CONSTRAINT `org_prod` FOREIGN KEY (`org_id`) REFERENCES `origin` (`org_id`) ON DELETE SET NULL ON UPDATE CASCADE
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `products` (`prod_id`, `name_prod`, `status`, `gender`, `total_amount`, `available`, `created_at`, `updated_at`, `org_id`, `cate_id`, `brd_id`) VALUES
                                                                                                                                                                (1, 'GIÀY NIKE AIR MAX SC NAM', 1, 1, NULL, b'1', '2023-03-15 10:04:05', '2023-03-15 10:04:05', 1, 1, 1),
                                                                                                                                                                (2, 'Giày Chạy Bộ Nam Adidas Duramo 10', 1, 1, NULL, b'1', '2023-03-15 10:04:05', '2023-03-15 10:04:05', 2, 1, 2),
                                                                                                                                                                (3, 'Giày Tây Nam Bitis', 1, 1, NULL, b'1', '2023-03-15 10:04:05', '2023-03-15 10:04:05', 3, 2, 3),
                                                                                                                                                                (4, 'BASAS BUMPER GUM NE - LOW TOP - OFFWHITE/GUM', 1, 2, NULL, b'1', '2023-03-15 10:04:05', '2023-03-15 10:04:05', 4, 1, 4),
                                                                                                                                                                (5, 'RUNNER COMFORT', 1, 2, NULL, b'1', '2023-03-15 10:04:05', '2023-03-15 10:04:05', 5, 4, 2),
                                                                                                                                                                (6, 'New Balance 574 Classic Lifestyle', 1, 2, NULL, b'1', '2023-03-15 10:04:05', '2023-03-15 10:04:05', 1, 1, 6);

CREATE TABLE IF NOT EXISTS `product_detail` (
                                                `prod_dtl_id` int NOT NULL AUTO_INCREMENT,
                                                `quantity` int NOT NULL,
                                                `price` double NOT NULL,
                                                `listed_price` double NOT NULL,
                                                `created_at` datetime NOT NULL,
                                                `updated_at` datetime NOT NULL,
                                                `prod_id` int NOT NULL,
                                                PRIMARY KEY (`prod_dtl_id`),
    KEY `prod` (`prod_id`),
    CONSTRAINT `prod` FOREIGN KEY (`prod_id`) REFERENCES `products` (`prod_id`) ON DELETE CASCADE ON UPDATE CASCADE
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `product_detail` (`prod_dtl_id`, `quantity`, `price`, `listed_price`, `created_at`, `updated_at`, `prod_id`) VALUES
                                                                                                                             (1, 10, 100000, 200000, '2023-03-15 10:13:46', '2023-03-15 10:13:46', 1),
                                                                                                                             (2, 10, 200000, 300000, '2023-03-15 10:13:46', '2023-03-15 10:13:46', 2),
                                                                                                                             (3, 10, 300000, 400000, '2023-03-15 10:13:46', '2023-03-15 10:13:46', 3),
                                                                                                                             (4, 10, 400000, 500000, '2023-03-15 10:13:46', '2023-03-15 10:13:46', 4),
                                                                                                                             (5, 10, 500000, 600000, '2023-03-15 10:13:46', '2023-03-15 10:13:46', 5),
                                                                                                                             (6, 10, 600000, 700000, '2023-03-15 10:13:46', '2023-03-15 10:13:46', 6);

CREATE TABLE IF NOT EXISTS `promotion_category` (
                                                    `pro_cate_id` int NOT NULL AUTO_INCREMENT,
                                                    `name` varchar(50) DEFAULT NULL,
    `percentage` double DEFAULT NULL,
    `description` varchar(100) DEFAULT NULL,
    `created_at` datetime DEFAULT NULL,
    `updated_at` datetime DEFAULT NULL,
    `status` int DEFAULT NULL,
    `cate_id` int DEFAULT NULL,
    PRIMARY KEY (`pro_cate_id`),
    KEY `pro_cate` (`cate_id`),
    CONSTRAINT `pro_cate` FOREIGN KEY (`cate_id`) REFERENCES `category` (`cate_id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE IF NOT EXISTS `promotion_product` (
                                                   `pro_prod_id` int NOT NULL AUTO_INCREMENT,
                                                   `name` varchar(50) DEFAULT NULL,
    `percentage` double DEFAULT NULL,
    `description` varchar(100) DEFAULT NULL,
    `created_at` datetime DEFAULT NULL,
    `updated_at` datetime DEFAULT NULL,
    `status` int DEFAULT NULL,
    `prod_id` int NOT NULL,
    PRIMARY KEY (`pro_prod_id`),
    KEY `pro_prod` (`prod_id`),
    CONSTRAINT `pro_prod` FOREIGN KEY (`prod_id`) REFERENCES `products` (`prod_id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE IF NOT EXISTS `roles` (
                                       `role_id` int NOT NULL AUTO_INCREMENT,
                                       `name_role` varchar(50) NOT NULL,
    PRIMARY KEY (`role_id`)
    ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `roles` (`role_id`, `name_role`) VALUES
                                                 (1, 'Admin'),
                                                 (2, 'Staff'),
                                                 (3, 'User');

CREATE TABLE IF NOT EXISTS `sizes` (
                                       `sz_id` int NOT NULL AUTO_INCREMENT,
                                       `name_sz` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
    `updated_at` datetime DEFAULT NULL,
    `created_at` datetime DEFAULT NULL,
    `prod_id` int NOT NULL,
    PRIMARY KEY (`sz_id`),
    KEY `prod_sz` (`prod_id`),
    CONSTRAINT `prod_sz` FOREIGN KEY (`prod_id`) REFERENCES `products` (`prod_id`) ON DELETE CASCADE ON UPDATE CASCADE
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `sizes` (`sz_id`, `name_sz`, `updated_at`, `created_at`, `prod_id`) VALUES
                                                                                    (1, '41', '2023-03-15 10:16:22', '2023-03-15 10:16:22', 1),
                                                                                    (2, '42', '2023-03-15 10:16:22', '2023-03-15 10:16:22', 1),
                                                                                    (3, '41', '2023-03-15 10:16:22', '2023-03-15 10:16:22', 2),
                                                                                    (4, '42', '2023-03-15 10:16:22', '2023-03-15 10:16:22', 2),
                                                                                    (5, '41', '2023-03-15 10:16:22', '2023-03-15 10:16:22', 3),
                                                                                    (6, '42', '2023-03-15 10:16:22', '2023-03-15 10:16:22', 3),
                                                                                    (7, '41', '2023-03-15 10:16:22', '2023-03-15 10:16:22', 4),
                                                                                    (8, '42', '2023-03-15 10:16:22', '2023-03-15 10:16:22', 4),
                                                                                    (9, '41', '2023-03-15 10:16:22', '2023-03-15 10:16:22', 5),
                                                                                    (10, '42', '2023-03-15 10:16:22', '2023-03-15 10:16:22', 5),
                                                                                    (11, '41', '2023-03-15 10:16:22', '2023-03-15 10:16:22', 6),
                                                                                    (12, '42', '2023-03-15 10:16:22', '2023-03-15 10:16:22', 6);

CREATE TABLE IF NOT EXISTS `vouchers` (
                                          `vc_id` int NOT NULL AUTO_INCREMENT,
                                          `note` varchar(150) NOT NULL,
    `status` int NOT NULL,
    `discount` double NOT NULL,
    `voucher_name` varchar(50) NOT NULL,
    `voucher_code` varchar(10) NOT NULL,
    `create_at` datetime NOT NULL,
    `type` varchar(50) NOT NULL,
    `point_to_receiver` varchar(50) NOT NULL,
    `payment_type` varchar(50) NOT NULL,
    `amount` double NOT NULL,
    `from_time` datetime NOT NULL,
    `to_time` datetime NOT NULL,
    PRIMARY KEY (`vc_id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE IF NOT EXISTS `voucher_account` (
                                                 `vcacc_id` int NOT NULL AUTO_INCREMENT,
                                                 `status` int NOT NULL,
                                                 `acc_id` int NOT NULL,
                                                 `vc_id` int NOT NULL,
                                                 PRIMARY KEY (`vcacc_id`),
    KEY `acc` (`acc_id`),
    KEY `vc` (`vc_id`),
    CONSTRAINT `acc` FOREIGN KEY (`acc_id`) REFERENCES `accounts` (`acc_id`) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT `vc` FOREIGN KEY (`vc_id`) REFERENCES `vouchers` (`vc_id`) ON DELETE CASCADE ON UPDATE CASCADE
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
