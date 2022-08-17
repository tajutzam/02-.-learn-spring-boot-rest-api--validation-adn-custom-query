-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 17, 2022 at 07:11 PM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 7.4.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_product_api`
--

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `id` bigint(20) NOT NULL,
  `nama_kategori` varchar(255) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`id`, `nama_kategori`) VALUES
(1, 'Keyboard Mechanical');

-- --------------------------------------------------------

--
-- Table structure for table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(2);

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `id` bigint(20) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name_product` varchar(64) DEFAULT NULL,
  `prize` double NOT NULL,
  `category_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`id`, `description`, `name_product`, `prize`, `category_id`) VALUES
(3, 'ini adalah description product satu', 'Product Satu', 19, 1),
(2, 'ini adalah description product satu', 'Product Satu', 19, 1),
(4, 'ini adalah description product satu z', 'Product Satu', 19, 1);

-- --------------------------------------------------------

--
-- Table structure for table `supplier`
--

CREATE TABLE `supplier` (
  `id` bigint(20) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `email` varchar(64) DEFAULT NULL,
  `nama_supplier` varchar(64) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `supplier`
--

INSERT INTO `supplier` (`id`, `address`, `email`, `nama_supplier`) VALUES
(1, 'Jalan Ahmad Yani , rt 01 / rt 02', 'Mohammadtajutzamamija@gmail.com', 'Toshiba'),
(2, 'Jalan Ahmad Yani , rt 01 / rt 02', 'Mohammad@tajutgmail.com', 'Toshiba'),
(3, 'Jalan Ahmad Yani , rt 01 / rt 02', 'Mohammad@gmail.com', 'Poco x phone'),
(4, 'Jalan Ahmad Yani , rt 01 / rt 02', 'Mohammadtajutzamzami@gmail.com', 'Toshiba'),
(5, 'Jalan Ahmad Yani , rt 01 / rt 02', 'Mohammadtajutzamzamia@gmail.com', 'Toshiba');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_product_supplier`
--

CREATE TABLE `tbl_product_supplier` (
  `product_id` bigint(20) NOT NULL,
  `supplier_id` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbl_product_supplier`
--

INSERT INTO `tbl_product_supplier` (`product_id`, `supplier_id`) VALUES
(3, 1),
(4, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_9if6058qli1c9qap9s41vd5oh` (`nama_kategori`) USING HASH;

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK1mtsbur82frn64de7balymq9s` (`category_id`);

--
-- Indexes for table `supplier`
--
ALTER TABLE `supplier`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_g7qiwwu4vpciysmeeyme9gg1d` (`email`);

--
-- Indexes for table `tbl_product_supplier`
--
ALTER TABLE `tbl_product_supplier`
  ADD PRIMARY KEY (`product_id`,`supplier_id`),
  ADD KEY `FKc4yqyxottu2xpkbsxplamav09` (`supplier_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- AUTO_INCREMENT for table `supplier`
--
ALTER TABLE `supplier`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
