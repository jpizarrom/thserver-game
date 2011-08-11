-- phpMyAdmin SQL Dump
-- version 3.3.9.2deb1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 03-07-2011 a las 21:06:28
-- Versión del servidor: 5.1.49
-- Versión de PHP: 5.3.3-7

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `memoria2-game`
--

--
-- Volcar la base de datos para la tabla `Game`
--

INSERT INTO `Game` (`gameId`, `city`, `description`, `finishDate`, `finished`, `latitude`, `longitude`, `maxTeams`, `maxUserPerTeam`, `name`, `startDate`) VALUES
(1, 'Talca', NULL, '2011-04-07 02:14:28', b'0', -35422333, -71662931, 4, 3, NULL, '2011-04-07 02:14:28'),
(2, 'Talca', NULL, '2011-05-29 17:35:51', b'0', -35422054, -71653833, 3, 2, NULL, '2011-05-29 17:35:51'),
(3, 'Talca', NULL, '2011-05-29 17:52:53', b'0', -35411421, -71644906, 2, 2, NULL, '2011-05-29 17:52:53'),
(4, 'Talca', NULL, '2011-05-29 17:58:37', b'0', -35405825, -71652116, 3, 3, NULL, '2011-05-29 17:58:37'),
(5, 'Talca', NULL, '2011-05-29 18:15:08', b'0', -35416738, -71622934, 5, 5, NULL, '2011-05-29 18:15:08'),
(6, 'Talca', NULL, '2011-05-30 03:10:04', b'0', -35414499, -71620530, 2, 2, NULL, '2011-05-30 03:10:04'),
(7, 'Talca', NULL, '2011-05-30 03:43:06', b'0', -35406664, -71692285, 4, 4, NULL, '2011-05-30 03:43:06'),
(8, 'Talca', NULL, '2011-06-12 13:08:38', b'0', -35426250, -71656579, 3, 2, NULL, '2011-06-12 13:08:38'),
(9, 'Talca', NULL, '2011-06-12 13:44:33', b'0', -35421774, -71662759, 2, 2, NULL, '2011-06-12 13:44:33'),
(10, 'Talca', NULL, '2011-06-12 13:49:31', b'0', -35415898, -71668596, 2, 2, NULL, '2011-06-12 13:49:31'),
(11, 'Talca', NULL, '2011-06-13 07:22:20', b'0', -35421494, -71654176, 3, 2, 'Casa', '2011-06-13 07:22:20'),
(12, 'Talca', NULL, '2011-06-17 09:02:53', b'0', -35431303, -71658736, 2, 3, 'Oficina', '2011-06-17 09:02:53'),
(13, 'Talca', NULL, '2011-06-17 13:20:30', b'0', -35403042, -71634355, 3, 2, 'Utal', '2011-06-17 13:20:30'),
(14, 'Talca', NULL, '2011-06-17 15:59:18', b'0', -35422543, -71653704, 3, 2, '8 or 3 n', '2011-06-17 15:59:18'),
(15, 'Santa Cruz', NULL, '2011-06-25 12:40:30', b'0', -34635486, -71360463, 3, 5, NULL, '2011-06-25 12:40:30');

--
-- Volcar la base de datos para la tabla `Goal`
--

INSERT INTO `Goal` (`placeId`) VALUES
(12),
(15),
(16),
(17),
(18),
(21),
(28),
(33),
(34),
(40),
(42),
(44),
(49),
(51);

--
-- Volcar la base de datos para la tabla `Hint`
--

INSERT INTO `Hint` (`placeId`) VALUES
(1),
(2),
(3),
(4),
(5),
(6),
(7),
(8),
(9),
(10),
(11),
(13),
(14),
(19),
(20),
(22),
(23),
(24),
(25),
(26),
(27),
(29),
(30),
(31),
(32),
(35),
(36),
(37),
(38),
(39),
(41),
(43),
(45),
(46),
(47),
(48),
(50),
(52);

--
-- Volcar la base de datos para la tabla `Place`
--

INSERT INTO `Place` (`placeId`, `placeRefId`, `type`, `gameId`) VALUES
(1, 0, '', 1),
(2, 0, '', 1),
(3, 0, '', 1),
(4, 0, '', 2),
(5, 0, '', 2),
(6, 0, '', 3),
(7, 0, '', 3),
(8, 0, '', 3),
(9, 0, '', 3),
(10, 0, '', 4),
(11, 0, '', 4),
(12, 0, '', 5),
(13, 0, 'HIN', 5),
(14, 0, 'HIN', 6),
(15, 0, '', 6),
(16, 0, 'GOA', 7),
(17, 0, 'GOA', 7),
(18, 0, 'GOA', 7),
(19, 0, 'HIN', 7),
(20, 0, 'HIN', 8),
(21, 0, 'GOA', 8),
(22, 0, 'HIN', 9),
(23, 0, 'HIN', 10),
(24, 0, 'HIN', 11),
(25, 0, 'HIN', 11),
(26, 0, 'HIN', 11),
(27, 0, 'HIN', 11),
(28, 0, 'GOA', 11),
(29, 0, 'HIN', 11),
(30, 0, 'HIN', 12),
(31, 0, 'HIN', 12),
(32, 0, 'HIN', 12),
(33, 0, 'GOA', 12),
(34, 0, 'GOA', 12),
(35, 0, 'HIN', 12),
(36, 0, 'HIN', 13),
(37, 0, 'HIN', 13),
(38, 0, 'HIN', 13),
(39, 0, 'HIN', 13),
(40, 0, 'GOA', 13),
(41, 0, 'HIN', 13),
(42, 0, 'HIN', 14),
(43, 0, 'HIN', 14),
(44, 0, 'GOA', 14),
(45, 0, 'HIN', 14),
(46, 0, 'HIN', 14),
(47, 0, 'HIN', 15),
(48, 0, 'HIN', 15),
(49, 0, 'GOA', 15),
(50, 0, 'HIN', 15),
(51, 0, 'GOA', 15),
(52, 0, 'HIN', 15);

--
-- Volcar la base de datos para la tabla `Team`
--

INSERT INTO `Team` (`teamId`, `teamRefId`, `gameId`) VALUES
(20, 0, 7),
(21, 0, 7),
(22, 0, 7),
(23, 0, 7),
(24, 0, 8),
(25, 0, 8),
(26, 0, 8),
(27, 0, 9),
(28, 0, 9),
(29, 0, 10),
(30, 0, 10),
(31, 0, 11),
(32, 0, 11),
(33, 0, 11),
(34, 0, 12),
(35, 0, 12),
(36, 0, 13),
(37, 0, 13),
(38, 0, 13),
(39, 0, 14),
(40, 0, 14),
(41, 0, 14),
(42, 0, 15),
(43, 0, 15),
(44, 0, 15);

--
-- Volcar la base de datos para la tabla `TeamHasPlace`
--


--
-- Volcar la base de datos para la tabla `TeamSeePlace`
--


--
-- Volcar la base de datos para la tabla `User`
--

INSERT INTO `User` (`userId`) VALUES
(1),
(2);

--
-- Volcar la base de datos para la tabla `UserSeePlace`
--

