-- phpMyAdmin SQL Dump
-- version 3.3.9.2deb1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 03-07-2011 a las 20:37:42
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

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Game`
--

CREATE TABLE IF NOT EXISTS `Game` (
  `gameId` bigint(20) NOT NULL AUTO_INCREMENT,
  `city` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `finishDate` datetime DEFAULT NULL,
  `finished` bit(1) NOT NULL,
  `latitude` int(11) NOT NULL,
  `longitude` int(11) NOT NULL,
  `maxTeams` int(11) NOT NULL,
  `maxUserPerTeam` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `startDate` datetime DEFAULT NULL,
  PRIMARY KEY (`gameId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=16 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Goal`
--

CREATE TABLE IF NOT EXISTS `Goal` (
  `placeId` bigint(20) NOT NULL,
  PRIMARY KEY (`placeId`),
  KEY `FK21F333FE0A9D32` (`placeId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Hint`
--

CREATE TABLE IF NOT EXISTS `Hint` (
  `placeId` bigint(20) NOT NULL,
  PRIMARY KEY (`placeId`),
  KEY `FK2252A7FE0A9D32` (`placeId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Place`
--

CREATE TABLE IF NOT EXISTS `Place` (
  `placeId` bigint(20) NOT NULL AUTO_INCREMENT,
  `placeRefId` bigint(20) NOT NULL,
  `type` varchar(255) DEFAULT NULL,
  `gameId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`placeId`),
  KEY `FK499E8E7DF764F96` (`gameId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=53 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Team`
--

CREATE TABLE IF NOT EXISTS `Team` (
  `teamId` bigint(20) NOT NULL AUTO_INCREMENT,
  `teamRefId` bigint(20) NOT NULL,
  `gameId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`teamId`),
  KEY `FK27B67DDF764F96` (`gameId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=45 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `TeamHasPlace`
--

CREATE TABLE IF NOT EXISTS `TeamHasPlace` (
  `teamId` bigint(20) NOT NULL,
  `placeId` bigint(20) NOT NULL,
  PRIMARY KEY (`teamId`,`placeId`),
  KEY `FKE4342AF5DE4DAC` (`teamId`),
  KEY `FKE4342AFE0A9D32` (`placeId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `TeamSeePlace`
--

CREATE TABLE IF NOT EXISTS `TeamSeePlace` (
  `teamId` bigint(20) NOT NULL,
  `placeId` bigint(20) NOT NULL,
  PRIMARY KEY (`teamId`,`placeId`),
  KEY `FK33463611F5DE4DAC` (`teamId`),
  KEY `FK33463611FE0A9D32` (`placeId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `User`
--

CREATE TABLE IF NOT EXISTS `User` (
  `userId` bigint(20) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `UserSeePlace`
--

CREATE TABLE IF NOT EXISTS `UserSeePlace` (
  `userId` bigint(20) NOT NULL,
  `placeId` bigint(20) NOT NULL,
  PRIMARY KEY (`userId`,`placeId`),
  KEY `FK15F5917FFE0A9D32` (`placeId`),
  KEY `FK15F5917FF85AFD08` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Filtros para las tablas descargadas (dump)
--

--
-- Filtros para la tabla `Goal`
--
ALTER TABLE `Goal`
  ADD CONSTRAINT `FK21F333FE0A9D32` FOREIGN KEY (`placeId`) REFERENCES `Place` (`placeId`);

--
-- Filtros para la tabla `Hint`
--
ALTER TABLE `Hint`
  ADD CONSTRAINT `FK2252A7FE0A9D32` FOREIGN KEY (`placeId`) REFERENCES `Place` (`placeId`);

--
-- Filtros para la tabla `Place`
--
ALTER TABLE `Place`
  ADD CONSTRAINT `FK499E8E7DF764F96` FOREIGN KEY (`gameId`) REFERENCES `Game` (`gameId`);

--
-- Filtros para la tabla `Team`
--
ALTER TABLE `Team`
  ADD CONSTRAINT `FK27B67DDF764F96` FOREIGN KEY (`gameId`) REFERENCES `Game` (`gameId`);

--
-- Filtros para la tabla `TeamHasPlace`
--
ALTER TABLE `TeamHasPlace`
  ADD CONSTRAINT `FKE4342AF5DE4DAC` FOREIGN KEY (`teamId`) REFERENCES `Team` (`teamId`),
  ADD CONSTRAINT `FKE4342AFE0A9D32` FOREIGN KEY (`placeId`) REFERENCES `Place` (`placeId`);

--
-- Filtros para la tabla `TeamSeePlace`
--
ALTER TABLE `TeamSeePlace`
  ADD CONSTRAINT `FK33463611F5DE4DAC` FOREIGN KEY (`teamId`) REFERENCES `Team` (`teamId`),
  ADD CONSTRAINT `FK33463611FE0A9D32` FOREIGN KEY (`placeId`) REFERENCES `Place` (`placeId`);

--
-- Filtros para la tabla `UserSeePlace`
--
ALTER TABLE `UserSeePlace`
  ADD CONSTRAINT `FK15F5917FF85AFD08` FOREIGN KEY (`userId`) REFERENCES `User` (`userId`),
  ADD CONSTRAINT `FK15F5917FFE0A9D32` FOREIGN KEY (`placeId`) REFERENCES `Place` (`placeId`);
