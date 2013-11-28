-- phpMyAdmin SQL Dump
-- version 3.5.2.2
-- http://www.phpmyadmin.net
--
-- Хост: localhost
-- Время создания: Ноя 28 2013 г., 23:59
-- Версия сервера: 5.5.27
-- Версия PHP: 5.4.7

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- База данных: `deanery`
--

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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- Дамп данных таблицы `students`
--

INSERT INTO `students` (`id`, `lastName`, `firstName`, `averageMark`, `groupNumber`) VALUES
(1, 'Test', 'First', 3.5, 421),
(2, 'Hibernate', 'Secont', 4, 542);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
