-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 21, 2018 at 10:21 PM
-- Server version: 10.1.36-MariaDB
-- PHP Version: 7.2.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `realestate`
--

-- --------------------------------------------------------

--
-- Table structure for table `buy`
--

CREATE TABLE `buy` (
  `Property_no` int(11) NOT NULL,
  `Property_Type` varchar(20) NOT NULL,
  `House_No` varchar(10) NOT NULL,
  `Building_Name` varchar(20) NOT NULL,
  `Street_Name` varchar(20) NOT NULL,
  `Area` varchar(20) NOT NULL,
  `City` varchar(20) NOT NULL DEFAULT 'Mumbai',
  `State` varchar(20) NOT NULL DEFAULT 'Maharashtra',
  `Pin_Code` varchar(6) NOT NULL,
  `BHKs` int(11) NOT NULL,
  `Floors` int(11) NOT NULL,
  `Furnished` varchar(3) NOT NULL DEFAULT 'NO',
  `Surface_Area` float NOT NULL,
  `Cost` double NOT NULL,
  `owners_id` int(11) NOT NULL,
  `status` varchar(2) DEFAULT 'A'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `buy`
--

INSERT INTO `buy` (`Property_no`, `Property_Type`, `House_No`, `Building_Name`, `Street_Name`, `Area`, `City`, `State`, `Pin_Code`, `BHKs`, `Floors`, `Furnished`, `Surface_Area`, `Cost`, `owners_id`, `status`) VALUES
(4, 'Flat', '54', 'Kalpataru Towers', 'Near ESIS Hospital', 'Kandivali East', 'Mumbai', 'Maharashtra', '40010', 3, 5, 'NO', 1235, 25000000, 2, 'A'),
(5, 'Flat', '12', 'UK Iridium', 'Near Nativity church', 'Kandivali East', 'Mumbai', 'Maharashtra', '400101', 1, 1, 'NO', 395, 7400000, 7, 'A'),
(6, 'Flat', '23', 'Fressia Ranibello', 'Near Omkar Altamonte', 'Malad East', 'Mumbai', 'Maharashtra', '400', 2, 1, 'NO', 1100, 14500000, 8, 'A'),
(7, 'Flat', '', 'Rustomjee Seasons', 'Seasons,BKC', 'Bandra', 'Mumbai', 'Maharashtra', '400023', 4, 1, 'NO', 2722, 95200000, 7, 'A');

-- --------------------------------------------------------

--
-- Table structure for table `buyers`
--

CREATE TABLE `buyers` (
  `cust_id` int(11) NOT NULL,
  `first_name` varchar(20) NOT NULL,
  `last_name` varchar(20) NOT NULL,
  `current_address` varchar(200) NOT NULL,
  `phone_no` varchar(10) NOT NULL,
  `email` varchar(30) NOT NULL,
  `aadhar_no` varchar(12) DEFAULT NULL,
  `Property_no` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `username` varchar(10) NOT NULL,
  `password` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`username`, `password`) VALUES
('admin', 'admin@123'),
('sarahc', 'sarah@123'),
('user', 'pass@123');

-- --------------------------------------------------------

--
-- Table structure for table `owners`
--

CREATE TABLE `owners` (
  `owners_id` int(11) NOT NULL,
  `first_name` varchar(20) DEFAULT NULL,
  `last_name` varchar(20) DEFAULT NULL,
  `bank_acc_no` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `owners`
--

INSERT INTO `owners` (`owners_id`, `first_name`, `last_name`, `bank_acc_no`) VALUES
(1, 'Joel', 'Vaz', '002-186452-006'),
(2, 'Sydney', 'Carvalho', '002-126489-006'),
(3, 'John ', 'Mayers', '002-645278-006'),
(7, 'John', 'Falcao', '002-348621-006'),
(8, 'Stephen', 'Mark', '002-672981-006'),
(9, 'Sarah', 'Carvalho', '002-123456-006');

-- --------------------------------------------------------

--
-- Table structure for table `property_type`
--

CREATE TABLE `property_type` (
  `type` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `property_type`
--

INSERT INTO `property_type` (`type`) VALUES
('Flat'),
('House'),
('Office Space'),
('Plot'),
('Shop/Showroom'),
('Warehouse');

-- --------------------------------------------------------

--
-- Table structure for table `rent`
--

CREATE TABLE `rent` (
  `Property_no` int(11) NOT NULL,
  `Property_Type` varchar(20) NOT NULL,
  `House_No` varchar(10) NOT NULL,
  `Building_Name` varchar(20) NOT NULL,
  `Street_Name` varchar(20) NOT NULL,
  `Area` varchar(20) NOT NULL,
  `City` varchar(20) NOT NULL,
  `State` varchar(20) NOT NULL,
  `Pin_Code` varchar(6) NOT NULL,
  `BHKs` int(11) NOT NULL,
  `Floors` int(11) NOT NULL,
  `Furnished` varchar(3) NOT NULL DEFAULT 'NO',
  `Surface_Area` float NOT NULL,
  `Cost` double NOT NULL,
  `owners_id` int(11) NOT NULL,
  `status` varchar(2) DEFAULT 'A'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `rent`
--

INSERT INTO `rent` (`Property_no`, `Property_Type`, `House_No`, `Building_Name`, `Street_Name`, `Area`, `City`, `State`, `Pin_Code`, `BHKs`, `Floors`, `Furnished`, `Surface_Area`, `Cost`, `owners_id`, `status`) VALUES
(1, 'Flat', '502', 'Hiranandani', 'Near Carter Road', 'Bandra West', 'Mumbai', 'Maharashtra', '400022', 3, 14, 'YES', 1650, 130000, 3, 'A'),
(2, 'Flat', '200', 'CBD', 'Vakola', 'Bandra KC', 'Mumbai', 'Maharashtra', '400034', 2, 1, 'NO', 795, 315000, 2, 'A'),
(3, 'Flat', '101', 'Alica', 'Nagar', 'Kandivali', 'Mumbai', 'Maharashtra', '400101', 3, 1, 'NO', 1200, 3500000, 9, 'A');

-- --------------------------------------------------------

--
-- Table structure for table `renters`
--

CREATE TABLE `renters` (
  `cust_id` int(11) NOT NULL,
  `first_name` varchar(20) NOT NULL,
  `last_name` varchar(20) NOT NULL,
  `current_address` varchar(200) NOT NULL,
  `phone_no` varchar(10) NOT NULL,
  `email` varchar(30) NOT NULL,
  `aadhar_no` varchar(12) DEFAULT NULL,
  `Property_no` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `buy`
--
ALTER TABLE `buy`
  ADD PRIMARY KEY (`Property_no`),
  ADD KEY `Property_Type` (`Property_Type`),
  ADD KEY `owners_id` (`owners_id`);

--
-- Indexes for table `buyers`
--
ALTER TABLE `buyers`
  ADD PRIMARY KEY (`cust_id`),
  ADD KEY `Property_no` (`Property_no`);

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `owners`
--
ALTER TABLE `owners`
  ADD PRIMARY KEY (`owners_id`);

--
-- Indexes for table `property_type`
--
ALTER TABLE `property_type`
  ADD PRIMARY KEY (`type`);

--
-- Indexes for table `rent`
--
ALTER TABLE `rent`
  ADD PRIMARY KEY (`Property_no`),
  ADD KEY `Property_Type` (`Property_Type`),
  ADD KEY `owners_id` (`owners_id`);

--
-- Indexes for table `renters`
--
ALTER TABLE `renters`
  ADD KEY `Property_no` (`Property_no`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `buy`
--
ALTER TABLE `buy`
  MODIFY `Property_no` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `buyers`
--
ALTER TABLE `buyers`
  MODIFY `cust_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `owners`
--
ALTER TABLE `owners`
  MODIFY `owners_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `rent`
--
ALTER TABLE `rent`
  MODIFY `Property_no` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `buy`
--
ALTER TABLE `buy`
  ADD CONSTRAINT `buy_ibfk_1` FOREIGN KEY (`Property_Type`) REFERENCES `property_type` (`type`),
  ADD CONSTRAINT `buy_ibfk_2` FOREIGN KEY (`owners_id`) REFERENCES `owners` (`owners_id`);

--
-- Constraints for table `buyers`
--
ALTER TABLE `buyers`
  ADD CONSTRAINT `buyers_ibfk_1` FOREIGN KEY (`Property_no`) REFERENCES `buy` (`Property_no`);

--
-- Constraints for table `rent`
--
ALTER TABLE `rent`
  ADD CONSTRAINT `rent_ibfk_1` FOREIGN KEY (`Property_Type`) REFERENCES `property_type` (`type`),
  ADD CONSTRAINT `rent_ibfk_2` FOREIGN KEY (`owners_id`) REFERENCES `owners` (`owners_id`);

--
-- Constraints for table `renters`
--
ALTER TABLE `renters`
  ADD CONSTRAINT `renters_ibfk_1` FOREIGN KEY (`Property_no`) REFERENCES `rent` (`Property_no`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
