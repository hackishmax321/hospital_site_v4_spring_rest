-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 24, 2020 at 06:20 AM
-- Server version: 10.4.13-MariaDB
-- PHP Version: 7.4.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hospitaldb`
--

-- --------------------------------------------------------

--
-- Table structure for table `patient`
--

CREATE TABLE `patient` (
  `id` int(11) NOT NULL,
  `age` int(11) NOT NULL,
  `auth_code` varchar(255) DEFAULT NULL,
  `contact` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `info` varchar(255) DEFAULT NULL,
  `initial_name` varchar(255) NOT NULL,
  `issues` tinyblob DEFAULT NULL,
  `q1` bit(1) NOT NULL,
  `q2` bit(1) NOT NULL,
  `q3` bit(1) NOT NULL,
  `q4` bit(1) NOT NULL,
  `surname` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `patient`
--

INSERT INTO `patient` (`id`, `age`, `auth_code`, `contact`, `email`, `info`, `initial_name`, `issues`, `q1`, `q2`, `q3`, `q4`, `surname`) VALUES
(3, 22, 'SHPAT814875', '0784566733', 'jayamanna_45.com', 'Liver Problem', 'Laksiri Sandeep', NULL, b'0', b'0', b'0', b'0', 'Jayamanna'),
(4, 52, 'SHPAT246316', '0783442362', 'ediranna52.com', 'Liver Problem', 'Jayasiri Pradeep', NULL, b'0', b'0', b'0', b'0', 'Edirimanna'),
(62, 26, 'SHPAT654236', '0725237814', 'hackishmax321@gmail.com', 'ggfgdfggd', 'Bakka', NULL, b'0', b'0', b'0', b'0', 'Soma');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `patient`
--
ALTER TABLE `patient`
  ADD PRIMARY KEY (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
