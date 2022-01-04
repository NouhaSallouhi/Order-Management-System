-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jun 03, 2021 at 06:45 PM
-- Server version: 5.7.31
-- PHP Version: 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ordermsdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
CREATE TABLE IF NOT EXISTS `customer` (
  `customerId` int(11) NOT NULL AUTO_INCREMENT,
  `customerCode` varchar(20) NOT NULL,
  `customerName` varchar(40) NOT NULL,
  `customerPhone` varchar(20) NOT NULL,
  `customerLocation` varchar(50) NOT NULL,
  PRIMARY KEY (`customerId`),
  UNIQUE KEY `customerCode` (`customerCode`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`customerId`, `customerCode`, `customerName`, `customerPhone`, `customerLocation`) VALUES
(10, 'nada', 'nada', 'nada', 'nadaaaaaaaaaaaaaaaaaaaaa'),
(22, 'nadaaaaaaaaaaaaaaaa', 'nadaaaaaaaaaaaaaa', 'nadaaaaa', 'nadaaaaaaaaaaaaaaaa'),
(28, 'someone', 'someoneesomeonesomeone', 'someoneee', 'someonesomeone'),
(33, 'bbbbbbbb', 'bbbbbbbbbb', 'bbbbbbbbbbb', 'bbbbbbbbbb'),
(34, 'dddddd', 'dddd', 'ddddddd', 'ddddddd'),
(36, 'd', 'd', 'd', 'd'),
(37, 'hgfh', 'ghgfh', 'gfhgfh', 'ghgfh'),
(40, '', '', '', ''),
(41, 'fffff', 'fffffff', 'ffffff', 'fffffffff');

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
CREATE TABLE IF NOT EXISTS `orders` (
  `orderId` int(11) NOT NULL AUTO_INCREMENT,
  `date` varchar(30) NOT NULL,
  `costumerId` int(11) NOT NULL,
  PRIMARY KEY (`orderId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
CREATE TABLE IF NOT EXISTS `product` (
  `productId` int(11) NOT NULL AUTO_INCREMENT,
  `productCode` int(20) NOT NULL,
  `productName` varchar(40) NOT NULL,
  `costPrice` double NOT NULL,
  `sellingPrice` double NOT NULL,
  `brand` varchar(40) NOT NULL,
  PRIMARY KEY (`productId`)
) ENGINE=InnoDB AUTO_INCREMENT=75555 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`productId`, `productCode`, `productName`, `costPrice`, `sellingPrice`, `brand`) VALUES
(444, 477, '74', 74, 47, '47'),
(75554, 4444, 'give it a try', 7, 4, 'try');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `FullName` int(11) NOT NULL,
  `userName` int(11) NOT NULL,
  `password` int(11) NOT NULL,
  `category` int(11) NOT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
