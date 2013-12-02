-- phpMyAdmin SQL Dump
-- version 4.0.4.1
-- http://www.phpmyadmin.net
--
-- Хост: 127.0.0.1
-- Время создания: Дек 02 2013 г., 09:58
-- Версия сервера: 5.6.11
-- Версия PHP: 5.5.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- База данных: `deanery`
--
CREATE DATABASE IF NOT EXISTS `deanery` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `deanery`;

-- --------------------------------------------------------

--
-- Структура таблицы `departments`
--

CREATE TABLE IF NOT EXISTS `departments` (
  `departmentId` int(11) NOT NULL AUTO_INCREMENT,
  `departmentName` varchar(100) NOT NULL,
  PRIMARY KEY (`departmentId`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- Дамп данных таблицы `departments`
--

INSERT INTO `departments` (`departmentId`, `departmentName`) VALUES
(1, 'CSN'),
(2, 'PI');

-- --------------------------------------------------------

--
-- Структура таблицы `groups`
--

CREATE TABLE IF NOT EXISTS `groups` (
  `groupNumber` int(11) NOT NULL,
  `departmentId` int(11) NOT NULL,
  `curator` varchar(100) NOT NULL,
  PRIMARY KEY (`groupNumber`),
  KEY `specId` (`departmentId`),
  KEY `specId_2` (`departmentId`),
  KEY `curatorId` (`curator`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `groups`
--

INSERT INTO `groups` (`groupNumber`, `departmentId`, `curator`) VALUES
(111, 3, '5'),
(121, 1, '2'),
(122, 1, '3'),
(141, 2, '4'),
(221, 1, '7'),
(241, 2, '8'),
(321, 1, '9'),
(342, 2, '10'),
(421, 1, '16'),
(521, 1, '1'),
(541, 2, '15');

-- --------------------------------------------------------

--
-- Структура таблицы `projects`
--

CREATE TABLE IF NOT EXISTS `projects` (
  `projectId` int(11) NOT NULL AUTO_INCREMENT,
  `projectName` varchar(255) NOT NULL,
  PRIMARY KEY (`projectId`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=5 ;

--
-- Дамп данных таблицы `projects`
--

INSERT INTO `projects` (`projectId`, `projectName`) VALUES
(1, 'Hibernate Query Language'),
(2, 'Criteria Queries'),
(3, 'Hibernate Native SQL'),
(4, 'Hibernate Caching');

-- --------------------------------------------------------

--
-- Структура таблицы `students`
--

CREATE TABLE IF NOT EXISTS `students` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `lastName` varchar(50) NOT NULL,
  `firstName` varchar(20) NOT NULL,
  `averageMark` float NOT NULL,
  `groupNumber` int(6) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `groupNumber` (`groupNumber`),
  KEY `groupNumber_2` (`groupNumber`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=12 ;

--
-- Дамп данных таблицы `students`
--

INSERT INTO `students` (`id`, `lastName`, `firstName`, `averageMark`, `groupNumber`) VALUES
(3, 'Student', 'First', 5, 521),
(4, 'Rooney', 'Wayne', 5, 521),
(5, 'Ramsey', 'Aaron', 4, 241),
(6, 'Cole', 'Jow', 4, 121),
(7, 'Messi', 'Lionel', 5, 541),
(8, 'Ronaldo', 'Cristiano', 4.5, 531),
(9, 'Iniesta', 'Andres', 4.5, 541),
(10, 'Ribery', 'Frank', 4, 421),
(11, 'Hart', 'Joe', 3.5, 311);

-- --------------------------------------------------------

--
-- Структура таблицы `studentsprojects`
--

CREATE TABLE IF NOT EXISTS `studentsprojects` (
  `id` int(11) NOT NULL,
  `projectId` int(11) NOT NULL,
  KEY `studentId` (`id`,`projectId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
