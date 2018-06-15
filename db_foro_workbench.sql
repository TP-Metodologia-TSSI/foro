CREATE DATABASE IF NOT EXISTS `foro`;
USE `foro`;

DROP TABLE IF EXISTS `respuesta`;
CREATE TABLE `respuesta` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `contenido` varchar(1000) NOT NULL,
  `fecha` date NOT NULL,
  `id_tema` int(11) NOT NULL,
  `id_usuario` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `respuesta_ibfk_1` FOREIGN KEY (`id_tema`) REFERENCES `tema` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `respuesta_ibfk_2` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `subforo`;
CREATE TABLE `subforo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(50) NOT NULL,
  `fecha` date NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `titulo` (`titulo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `tema`;
CREATE TABLE `tema` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(50) NOT NULL,
  `descripcion` varchar(1000) DEFAULT NULL,
  `fecha` date NOT NULL,
  `id_subforo` int(11) NOT NULL,
  `id_usuario` int(11) NOT NULL,
  CONSTRAINT `pk_Tema` PRIMARY KEY (`id`),
  CONSTRAINT `unq_tema` UNIQUE(`titulo`),
  CONSTRAINT `tema_ibfk_1` FOREIGN KEY (`id_subforo`) REFERENCES `subforo` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `tema_idfk_2` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `usuario`;
CREATE TABLE `usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `fecha_suscripcion` date NOT NULL,
  `url_imagen` varchar(50) DEFAULT NULL,
  `pass` varchar(50) NOT NULL,
  `tipo_usuario` int NOT NULL,
  CONSTRAINT `pk_usuario` PRIMARY KEY (`id`),
  CONSTRAINT `unq_usuario` UNIQUE(`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `subforo_moderador`;
CREATE TABLE `subforo_moderador` (
  `id_usuario` int(11) NOT NULL,
  `id_subforo` int(11) NOT NULL,
  PRIMARY KEY (`id_usuario`, `id_subforo`),
  CONSTRAINT FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`) ON UPDATE CASCADE ON DELETE CASCADE,
  CONSTRAINT FOREIGN KEY (`id_subforo`) REFERENCES `subforo` (`id`) ON UPDATE CASCADE ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;