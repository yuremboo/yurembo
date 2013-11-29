-- phpMyAdmin SQL Dump
-- version 4.0.4.1
-- http://www.phpmyadmin.net
--
-- Хост: 127.0.0.1
-- Время создания: Ноя 29 2013 г., 12:28
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
-- Структура таблицы `cathedra`
--

CREATE TABLE IF NOT EXISTS `cathedra` (
  `cathedraId` int(11) NOT NULL AUTO_INCREMENT,
  `cathedraName` varchar(100) NOT NULL,
  PRIMARY KEY (`cathedraId`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

--
-- Дамп данных таблицы `cathedra`
--

INSERT INTO `cathedra` (`cathedraId`, `cathedraName`) VALUES
(1, 'CSN');

-- --------------------------------------------------------

--
-- Структура таблицы `groups`
--

CREATE TABLE IF NOT EXISTS `groups` (
  `groupNumber` int(11) NOT NULL,
  `groupName` varchar(100) NOT NULL,
  `specId` int(11) NOT NULL,
  `curatorId` int(11) NOT NULL,
  PRIMARY KEY (`groupNumber`),
  KEY `specId` (`specId`),
  KEY `specId_2` (`specId`),
  KEY `curatorId` (`curatorId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `groups`
--

INSERT INTO `groups` (`groupNumber`, `groupName`, `specId`, `curatorId`) VALUES
(521, 'CSN 5 course', 1, 1);

-- --------------------------------------------------------

--
-- Структура таблицы `marks`
--

CREATE TABLE IF NOT EXISTS `marks` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `studentId` int(11) NOT NULL,
  `subject` varchar(100) NOT NULL,
  `mark` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `studentId` (`studentId`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

--
-- Дамп данных таблицы `marks`
--

INSERT INTO `marks` (`id`, `studentId`, `subject`, `mark`) VALUES
(1, 3, 'Java', 5);

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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

--
-- Дамп данных таблицы `students`
--

INSERT INTO `students` (`id`, `lastName`, `firstName`, `averageMark`, `groupNumber`) VALUES
(3, 'Student', 'First', 5, 521);

-- --------------------------------------------------------

--
-- Структура таблицы `teachers`
--

CREATE TABLE IF NOT EXISTS `teachers` (
  `teacherId` int(11) NOT NULL AUTO_INCREMENT,
  `tFirstName` varchar(50) NOT NULL,
  `tSecondName` varchar(50) NOT NULL,
  PRIMARY KEY (`teacherId`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

--
-- Дамп данных таблицы `teachers`
--

INSERT INTO `teachers` (`teacherId`, `tFirstName`, `tSecondName`) VALUES
(1, 'First', 'Teacher');

--
-- Ограничения внешнего ключа сохраненных таблиц
--

--
-- Ограничения внешнего ключа таблицы `groups`
--
ALTER TABLE `groups`
  ADD CONSTRAINT `groups_ibfk_2` FOREIGN KEY (`curatorId`) REFERENCES `teachers` (`teacherId`),
  ADD CONSTRAINT `groups_ibfk_1` FOREIGN KEY (`specId`) REFERENCES `cathedra` (`cathedraId`);

--
-- Ограничения внешнего ключа таблицы `marks`
--
ALTER TABLE `marks`
  ADD CONSTRAINT `marks_ibfk_1` FOREIGN KEY (`studentId`) REFERENCES `students` (`id`);

--
-- Ограничения внешнего ключа таблицы `students`
--
ALTER TABLE `students`
  ADD CONSTRAINT `students_ibfk_1` FOREIGN KEY (`groupNumber`) REFERENCES `groups` (`groupNumber`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
