-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 04, 2025 at 10:22 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `khedma_link`
--

-- --------------------------------------------------------

--
-- Table structure for table `project`
--

CREATE TABLE `project` (
  `creation_date` date DEFAULT NULL,
  `id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `price_per_hour` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `skills` varbinary(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `project`
--

INSERT INTO `project` (`creation_date`, `id`, `user_id`, `description`, `price_per_hour`, `status`, `title`, `skills`) VALUES
('2025-06-29', 1, 6, 'Design and implement responsive web interfaces using modern JavaScript frameworks. Focus on performance and user experience.', '25', 'active', 'Front-End Web Developer', 0xaced0005737200136a6176612e7574696c2e41727261794c6973747881d21d99c7619d03000149000473697a6578700000000577040000000574000448544d4c74000343535374000a4a617661536372697074740005526561637474000347697478),
('2025-06-29', 2, 6, 'Translate business and technical documents from English to Spanish, ensuring cultural relevance and accuracy.', '18', 'open', 'English to Spanish Translator', 0xaced0005737200136a6176612e7574696c2e41727261794c6973747881d21d99c7619d03000149000473697a6578700000000477040000000474000e466c75656e7420456e676c69736874000e466c75656e74205370616e69736874000b5472616e736c6174696f6e74000c50726f6f6672656164696e6778),
('2025-06-29', 3, 6, 'Create user-friendly mobile application designs for iOS and Android using Figma. Work closely with developers to hand off designs.', '30', 'active', 'Mobile App UI/UX Designer', 0xaced0005737200136a6176612e7574696c2e41727261794c6973747881d21d99c7619d03000149000473697a657870000000057704000000057400054669676d61740006536b6574636874000555492f555874000d4d6f62696c652044657369676e74000b50726f746f747970696e6778),
('2025-06-29', 4, 10, 'Manage customer inquiries, process orders, and update product listings. Familiarity with Shopify or WooCommerce is a plus.', '12', 'pending', 'Virtual Assistant for E-commerce Store', 0xaced0005737200136a6176612e7574696c2e41727261794c6973747881d21d99c7619d03000149000473697a65787000000004770400000004740010437573746f6d657220537570706f727474000753686f7069667974000a4461746120456e747279740010456d61696c204d616e6167656d656e7478),
('2025-06-29', 5, 7, 'Analyze sales and marketing data, create reports in Excel, and visualize trends using Power BI or Tableau.', '20', 'accepted', 'Junior Data Analyst', 0xaced0005737200136a6176612e7574696c2e41727261794c6973747881d21d99c7619d03000149000473697a65787000000005770400000005740005457863656c740008506f77657220424974000d4461746120416e616c7973697374000353514c740012446174612056697375616c697a6174696f6e78),
('2025-06-29', 6, 10, 'Create an E-Commerce website, for cooking materials, make sure to make it user-friendly.', '30', 'pending', 'Flutter Developer', 0xaced0005737200136a6176612e7574696c2e41727261794c6973747881d21d99c7619d03000149000473697a65787000000003770400000003740007466c757474657274000a526573706f6e736976657400044461727478),
('2025-06-29', 7, 10, 'Legal consultation regarding a copyright infringement protection, for my company.', '15', 'accepted', 'Legal Consultation', 0xaced0005737200136a6176612e7574696c2e41727261794c6973747881d21d99c7619d03000149000473697a657870000000047704000000047400064c61777965727400034c6177740014436f6d6d756e69636174696f6e20536b696c6c73740009436f7079726967687478),
('2025-06-29', 8, 10, 'System Designer needed to prepare the development on a massive project, with %100 certainty of no error', '70', 'pending', 'System Designer', 0xaced0005737200136a6176612e7574696c2e41727261794c6973747881d21d99c7619d03000149000473697a6578700000000477040000000474000453444c4374000d53797374656d2044657369676e74000c417263686974656374757265740011536f66747761726520456e67696e65657278);

-- --------------------------------------------------------

--
-- Table structure for table `rating`
--

CREATE TABLE `rating` (
  `counter` int(11) DEFAULT NULL,
  `id` int(11) NOT NULL,
  `rating` double DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `rating`
--

INSERT INTO `rating` (`counter`, `id`, `rating`, `user_id`) VALUES
(0, 1, 0, 1),
(0, 2, 0, 2),
(0, 3, 0, 3),
(2, 4, 4.85, 4),
(1, 5, 4.7, 5),
(0, 6, 0, 6),
(1, 7, 3.6, 7),
(1, 8, 4.6, 8),
(0, 9, 0, 9),
(0, 10, 0, 10),
(0, 11, 0, 11),
(0, 13, 0, 13),
(0, 14, 0, 14),
(0, 15, 0, 15),
(0, 16, 0, 16);

-- --------------------------------------------------------

--
-- Table structure for table `request`
--

CREATE TABLE `request` (
  `id` int(11) NOT NULL,
  `project_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `creation_date` date DEFAULT NULL,
  `id` int(11) NOT NULL,
  `email` varchar(255) NOT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `link` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`creation_date`, `id`, `email`, `first_name`, `last_name`, `link`, `password`, `phone`, `role`) VALUES
('2025-06-28', 1, 'laith_abusamra@khedmalink.com', 'laith', 'abusamra', 'https://yourprofile.link', 'laith123', '+962795216933', 'admin'),
('2025-06-28', 2, 'razan_haitham@khedmalink.com', 'razan', 'haitham', 'https://yourprofile.link', 'razan123', '+962787756741', 'admin'),
('2025-06-28', 3, 'abdulkareem_alsaou@khedmalink.com', 'abdulkareem', 'alsaou', 'https://yourprofile.link', 'abdulkareem123', '+962790662354', 'admin'),
('2025-06-28', 4, 'yamen_ghozlan@gmail.com', 'yamen', 'malik', 'https://yourprofile.link', 'yamen123', '+962775012569', 'freelancer'),
('2025-06-28', 5, 'ibraheem12@gmail.com', 'ibraim', 'tayem', 'https://yourprofile.link', 'ibrahim123', '+962799999685', 'freelancer'),
('2025-06-28', 6, 'mohammad_tayee@philadelphia.edu.jo', 'Mohammad', 'Tayee', 'https://yourprofile.link', 'motayee123', '+9627648215379', 'recruiter'),
('2025-06-28', 7, 'ahmad_jalal@gmail.com', 'ahmad', 'jalal', 'https://www.mydomain.com', 'ahmad123', '+962790654587', 'freelancer'),
('2025-06-28', 8, 'Sarah_Bakhori@outlook.com', 'Sarah', 'Bakhori', 'https:/www.sarah.com', 'sarah123', '+966156789245', 'freelancer'),
('2025-06-28', 9, 'baraa_adnan@khedmalink.com', 'baraa', 'adnan', 'https://www.baraa.com', 'baraa123', '+962795063245', 'admin'),
('2025-06-28', 10, 'mahmoud_saou@gmail.com', 'mahmoud', 'Saou', 'https://www.mahmoudsaou.com', 'mahmoud123', '+9627985467521', 'recruiter'),
('2025-06-28', 11, 'rami_almarami@gmai.com', 'Rami', 'Marami', '', 'rami123', '', 'recruiter'),
('2025-06-28', 13, 'sami_noname@gmail.com', 'sami', 'bdonasami', '', 'sami123', '+96279458416', 'recruiter'),
('2025-06-29', 14, 'ahmad_abuzanona@khedmalink', 'ahmad', 'abuzanona', 'https://www.myportfolio.com', 'ahmad123', '+962799897376', 'validator'),
('2025-06-30', 15, 'test@email.com', 'hasan', 'hasona', 'https://www.yourprofile.com', '123', '+962790662354', 'recruiter'),
('2025-07-03', 16, 'test@mail.com', 'Fadi', 'Suhiemat', 'https://www.fadisuh.com', '123', '+962790662354', 'freelancer');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `project`
--
ALTER TABLE `project`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKo06v2e9kuapcugnyhttqa1vpt` (`user_id`);

--
-- Indexes for table `rating`
--
ALTER TABLE `rating`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK8dfu35xwik8uwlrdloci4ok2i` (`user_id`);

--
-- Indexes for table `request`
--
ALTER TABLE `request`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKkvq26sm6o0fejk6syyfhygl1q` (`project_id`),
  ADD KEY `FKqws2fdeknk90txm7qnm9bxd07` (`user_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UKob8kqyqqgmefl0aco34akdtpe` (`email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `project`
--
ALTER TABLE `project`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT for table `rating`
--
ALTER TABLE `rating`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `request`
--
ALTER TABLE `request`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `project`
--
ALTER TABLE `project`
  ADD CONSTRAINT `FKo06v2e9kuapcugnyhttqa1vpt` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `rating`
--
ALTER TABLE `rating`
  ADD CONSTRAINT `FKpn05vbx6usw0c65tcyuce4dw5` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `request`
--
ALTER TABLE `request`
  ADD CONSTRAINT `FKkvq26sm6o0fejk6syyfhygl1q` FOREIGN KEY (`project_id`) REFERENCES `project` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FKqws2fdeknk90txm7qnm9bxd07` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
