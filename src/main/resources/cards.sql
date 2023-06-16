-- phpMyAdmin SQL Dump
-- version 5.0.4deb2+deb11u1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jun 16, 2023 at 12:30 PM
-- Server version: 8.0.27
-- PHP Version: 7.3.33-1+0~20211119.91+debian10~1.gbp618351

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cards`
--

-- --------------------------------------------------------

--
-- Table structure for table `cards`
--

CREATE TABLE `cards` (
  `id` bigint NOT NULL,
  `color` varchar(255) DEFAULT NULL,
  `created_at` datetime(6) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `status` varchar(255) DEFAULT NULL,
  `user_id` bigint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `cards`
--

INSERT INTO `cards` (`id`, `color`, `created_at`, `description`, `name`, `status`, `user_id`) VALUES
(1, '#2f5a01', '2023-06-14 14:08:45.895265', 'Bacon Facilitator red Branding', 'bandwidth', 'TO_DO', 2),
(2, '#2d1a79', '2023-06-14 14:08:50.033989', 'methodical solid SSL THX payment', 'bus', 'TO_DO', 2),
(3, '#7a4c4e', '2023-06-14 14:08:50.994151', 'Corporate indexing', 'feed', 'TO_DO', 2),
(4, '#62662c', '2023-06-14 14:08:52.082186', 'Small Marshall', 'circuit', 'TO_DO', 2),
(5, '#174115', '2023-06-14 14:08:53.444965', 'firmware Borders repurpose Handcrafted Shirt', 'bandwidth', 'TO_DO', 2),
(6, '#43761d', '2023-06-14 14:08:54.347493', 'Multi-channelled indexing Health', 'microchip', 'TO_DO', 2),
(7, '#420958', '2023-06-14 14:08:55.331476', 'hierarchy Home approach', 'program', 'TO_DO', 2),
(8, '#285f79', '2023-06-14 14:08:56.358231', 'Rubber Fully-configurable paradigm Solutions', 'array', 'TO_DO', 2),
(9, '#784c0c', '2023-06-14 14:08:57.205021', 'Manor magenta collaborative models', 'array', 'TO_DO', 2),
(10, '#57693e', '2023-06-14 14:08:57.865278', 'Burkina Frozen Underpass Chicken', 'monitor', 'TO_DO', 2),
(11, '#59234b', '2023-06-14 14:08:58.585991', 'Compatible lavender', 'port', 'TO_DO', 2),
(12, '#337a75', '2023-06-14 14:08:59.289803', 'paradigms next-generation Gold', 'circuit', 'TO_DO', 2),
(13, '#6c7058', '2023-06-14 14:09:00.374636', 'knowledge Chair challenge SSL Buckinghamshire', 'panel', 'TO_DO', 2),
(14, '#560151', '2023-06-14 14:09:00.910627', 'deposit Thailand', 'program', 'TO_DO', 2),
(15, '#407460', '2023-06-14 14:09:01.630706', 'Cotton Savings Division Games payment', 'driver', 'TO_DO', 2),
(16, '#273f04', '2023-06-14 14:09:02.355651', 'reinvent bluetooth Honduras', 'matrix', 'TO_DO', 2),
(17, '#68630d', '2023-06-14 14:09:03.035089', 'AI synthesizing', 'application', 'TO_DO', 2),
(18, '#225230', '2023-06-14 14:09:03.653541', 'robust panel quantify FTP incentivize', 'card', 'TO_DO', 2),
(19, '#32231f', '2023-06-14 14:09:04.359789', 'Card invoice', 'alarm', 'TO_DO', 2),
(20, '#5a5c41', '2023-06-14 14:15:02.707260', 'Toys turquoise Account invoice quantifying', 'circuit', 'TO_DO', 4),
(21, '#660d1f', '2023-06-14 14:15:04.206370', 'reboot well-modulated', 'pixel', 'TO_DO', 4),
(22, '#554a42', '2023-06-14 14:15:05.190787', 'AGP Agent incubate Profit-focused dot-com', 'program', 'TO_DO', 4),
(25, '#577234', '2023-06-14 14:15:55.663658', 'Metal FTP Market matrix', 'application', 'IN_PROGRESS', 6),
(26, '#520462', '2023-06-14 14:15:56.552256', 'pink web-readiness Michigan Cotton', 'application', 'TO_DO', 6),
(27, '#0b113a', '2023-06-14 14:16:26.859077', 'Zambia end-to-end cross-platform Cotton', 'monitor', 'TO_DO', 7),
(28, '#234880', '2023-06-14 14:16:27.796431', 'firewall Borders Loan', 'alarm', 'TO_DO', 7),
(29, '#2c7655', '2023-06-14 14:16:28.740208', 'Directives markets copying (Bouvetoya)', 'circuit', 'TO_DO', 7),
(30, '#11063f', '2023-06-14 14:16:54.759160', 'bifurcated initiative', 'interface', 'TO_DO', 1),
(31, '#320828', '2023-06-14 14:16:55.643184', 'Netherlands Implementation engage', 'firewall', 'TO_DO', 1),
(32, '#0e0f63', '2023-06-14 14:16:57.100450', 'Ghana clicks-and-mortar plug-and-play Garden Plastic', 'bandwidth', 'TO_DO', 1),
(33, '#1c200b', '2023-06-14 14:17:29.268070', 'Polynesia COM', 'system', 'TO_DO', 8),
(34, '#646954', '2023-06-14 14:17:30.458581', 'Orchestrator virtual override Branding', 'system', 'TO_DO', 8),
(35, '#58624b', '2023-06-14 14:17:31.345977', 'methodologies logistical system Account redundant', 'microchip', 'TO_DO', 8),
(36, '#0b7349', '2023-06-14 14:18:38.561315', 'Plastic withdrawal User-friendly Loaf scalable', 'transmitter', 'TO_DO', 8),
(37, '#1b7a47', '2023-06-14 14:19:05.530601', 'bluetooth blue ADP Nakfa Northern', 'capacitor', 'TO_DO', 8),
(38, '#157217', '2023-06-14 14:19:57.158880', 'bandwidth-monitored compress Fiji HTTP Versatile', 'application', 'TO_DO', 8),
(39, '#225d7f', '2023-06-14 14:34:18.322600', 'deposit Lesotho Steel', 'transmitter', 'TO_DO', 8),
(40, '#587668', '2023-06-14 14:34:34.756337', 'Industrial Internal', 'sensor', 'TO_DO', 8);

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `Id` bigint NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`Id`, `name`) VALUES
(1, 'Admin'),
(2, 'Member');

-- --------------------------------------------------------

--
-- Table structure for table `role_user`
--

CREATE TABLE `role_user` (
  `user_id` bigint NOT NULL,
  `role_id` bigint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `role_user`
--

INSERT INTO `role_user` (`user_id`, `role_id`) VALUES
(1, 1),
(2, 2),
(4, 2),
(5, 2),
(6, 2),
(7, 2),
(8, 1);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` bigint NOT NULL,
  `email` varchar(255) NOT NULL,
  `firstName` varchar(255) DEFAULT NULL,
  `lastName` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `email`, `firstName`, `lastName`, `password`) VALUES
(1, 'brnnyandieka@gmail.com', 'brian', 'matonda', '$2a$10$K0i5uq097FgsERlAZtbd6uz9RV0lyTjrd.DVk3R9z7V2zo8j7qDbK'),
(2, 'felix.tembo@gmail.com', 'Felix', 'Tembo', '$2a$10$pLVeyiwbx.t5VNXSWBX.4uO8vxkgvdbX3EN3Al3BK7eeBbjGzKfcC'),
(4, 'Zane.Wolff@yahoo.com', 'Ardith', 'Smitham', '$2a$10$tJuLN1jY/kBYDOaZso5oPOMdovH9W7FitVqck/WcefHf0udgvcfGe'),
(5, 'Arnoldo32@gmail.com', 'Scottie', 'Wolf', '$2a$10$INmdqhCz5xEdYy3ZTCNTvO6bdm5XComeqCoTiQsURlRn/0PYALh6.'),
(6, 'Davin_Schimmel85@gmail.com', 'Leonora', 'Vandervort', '$2a$10$o4ghW9.qPW5e8fJIUb1s5eETGve5NRGYx6cQ.3oajUG5i.cwHWWhm'),
(7, 'Haylie.Welch@gmail.com', 'Robbie', 'Walter', '$2a$10$CgIPtisnvMBNT7NtePB5DuuMeptcmxdkGjyNC9y8XtwtODIkx9TQ6'),
(8, 'Mohammed61@hotmail.com', 'Stephanie', 'Lubowitz', '$2a$10$EcXwhoHDHHYvHlqMAQMV4.hda4T7pTxSx6lg72m1MG3a6E10ZhACu');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cards`
--
ALTER TABLE `cards`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKcmanafgwbibfijy2o5isfk3d5` (`user_id`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `role_user`
--
ALTER TABLE `role_user`
  ADD KEY `FKiqpmjd2qb4rdkej916ymonic6` (`role_id`),
  ADD KEY `FKhvai2k29vlwpt9wod4sw4ghmn` (`user_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_6dotkott2kjsp8vw4d0m25fb7` (`email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cards`
--
ALTER TABLE `cards`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;

--
-- AUTO_INCREMENT for table `role`
--
ALTER TABLE `role`
  MODIFY `Id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `cards`
--
ALTER TABLE `cards`
  ADD CONSTRAINT `FKcmanafgwbibfijy2o5isfk3d5` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

--
-- Constraints for table `role_user`
--
ALTER TABLE `role_user`
  ADD CONSTRAINT `FKhvai2k29vlwpt9wod4sw4ghmn` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `FKiqpmjd2qb4rdkej916ymonic6` FOREIGN KEY (`role_id`) REFERENCES `role` (`Id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
