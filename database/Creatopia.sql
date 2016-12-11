-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Database: `creatopia`
--
-- ------------------------------------------------------
-- Server version	5.7.9-log

--
-- Create and use database
--
	CREATE DATABASE IF NOT EXISTS creatopia;
	USE creatopia;

--
-- Table structure for table `comments`
--

CREATE TABLE IF NOT EXISTS `comments` (
  `Comment_ID` int(10) NOT NULL,
  `Comment` text NOT NULL,
  `User_ID` int(10) NOT NULL,
  `Comment_Date` datetime NOT NULL,
  `Image_ID` int(10) NOT NULL,
  `Status` int(10) NOT NULL,
  PRIMARY KEY (`Comment_ID`),
  KEY `User_ID` (`User_ID`),
  KEY `Image_ID` (`Image_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


--
-- Table structure for table `images`
--

CREATE TABLE IF NOT EXISTS `images` (
  `Image_ID` int(10) NOT NULL AUTO_INCREMENT,
  `Image_name` varchar(255) NOT NULL,
  `Image_desc` text,
  `Upload_date` datetime NOT NULL,
  `Path` varchar(255) NOT NULL,
  `User_ID` int(10) NOT NULL,
  `Tags` var(255),
  `Num_View` int(10) NOT NULL,
  `Num_Like` int(10) NOT NULL,
  `Last_Edit` datetime NOT NULL,
  `Status` int(10) NOT NULL,
  PRIMARY KEY (`Image_ID`),
  KEY `Cate_ID` (`Cate_ID`),
  KEY `User_ID` (`User_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


--
-- Table structure for table `likes`
--

CREATE TABLE IF NOT EXISTS `likes` (
  `Like_ID` int(11) NOT NULL AUTO_INCREMENT,
  `User_ID` int(10) DEFAULT NULL,
  `Image_ID` int(10) DEFAULT NULL,
  PRIMARY KEY (`Like_ID`),
  KEY `User_ID` (`User_ID`),
  KEY `Image_ID` (`Image_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `users` (
  `User_ID` int(11) NOT NULL AUTO_INCREMENT UNIQUE,
  `Username` varchar(100) NOT NULL,
  `Fname` varchar(50) NOT NULL,
  `Lname` varchar(50) NOT NULL,
  `Gender` smallint(1) NOT NULL,
  `Email` varchar(100) NOT NULL,
  `Password` varchar(50) NOT NULL,
  `User_role` varchar(255) NOT NULL,
  `Bio` text,
  `Avatar` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`User_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Constraints for table `comments`
--

ALTER TABLE `comments`
  ADD CONSTRAINT `comments_ibfk_1` FOREIGN KEY (`Image_ID`) REFERENCES `images` (`Image_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `comments_ibfk_2` FOREIGN KEY (`User_ID`) REFERENCES `users` (`User_ID`) ON DELETE CASCADE ON UPDATE CASCADE;
	
--
-- Constraints for table `images`
--
	
ALTER TABLE `images`
  ADD CONSTRAINT `images_ibfk_1` FOREIGN KEY (`User_ID`) REFERENCES `users` (`User_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  
--
-- Constraints for table `likes`
--
  
ALTER TABLE `likes`
  ADD CONSTRAINT `likes_ibfk_1` FOREIGN KEY (`Image_ID`) REFERENCES `images` (`Image_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `likes_ibfk_2` FOREIGN KEY (`User_ID`) REFERENCES `users` (`User_ID`) ON DELETE CASCADE ON UPDATE CASCADE;
