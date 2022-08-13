--
CREATE DATABASE IF NOT EXISTS `db_concours` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `db_concours`;
-- --------------------------------------------------------

--
-- Structure de la table `candidats`
--

CREATE TABLE IF NOT EXISTS `candidats` (
  `id` int NOT NULL AUTO_INCREMENT,
  `numero` int NOT NULL,
  `nom` varchar(20) NOT NULL,
  `score` double NOT NULL,
  `region` smallint NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE(numero)  
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=113 ;

--
-- Contenu de la table `candidats`
--

INSERT INTO `candidats` (`id`, `numero`, `nom`, `score`, `region`) VALUES
(2, 859491, 'September Richmond', '81.70', 2),
(3, 380692, 'Armand Juarez', '76.30', 5),
(4, 189193, 'Dustin Alexander', '75.80', 4),
(5, 782994, 'Chadwick Washington', '84.10', 2),
(6, 514195, 'Meredith Camacho', '79.60', 4),
(7, 943296, 'Nehru Macdonald', '75.30', 2),
(8, 446491, 'Ahmed Savage', '84.40', 1),
(9, 870792, 'Merritt Peterson', '77.20', 2),
(10, 607392, 'Joy Cole', '88.20', 4),
(11, 367899, 'Ursula Bolton', '76.00', 4),
(23, 202096, 'Forrest Thompson', '84.40', 3),
(24, 296099, 'Buffy Gilliam', '75.80', 3),
(25, 853397, 'Ignatius Morse', '83.60', 4),
(26, 470999, 'Chancellor Ewing', '72.80', 5),
(27, 165996, 'Constance Hatfield', '88.00', 5),
(28, 439699, 'Kane Serrano', '86.10', 1),
(29, 431299, 'Echo Holmes', '86.70', 1),
(30, 438499, 'Caryn Wilcox', '74.40', 3),
(31, 808299, 'Iliana May', '88.60', 3),
(32, 776099, 'Eaton Nieves', '87.00', 2),
(33, 897499, 'Isabella Knowles', '83.00', 3),
(34, 444999, 'Emerson Byrd', '71.80', 5),
(35, 287399, 'Gloria Suarez', '76.40', 4),
(36, 490799, 'Chelsea Mckay', '81.70', 1),
(37, 250299, 'Christen Lawrence', '70.70', 1),
(38, 245699, 'Omar Harper', '81.50', 5),
(39, 206599, 'Erica Hobbs', '80.00', 4),
(40, 505199, 'Dakota Rhodes', '84.60', 2),
(41, 139199, 'Ezekiel Ryan', '74.60', 5),
(42, 147199, 'Yoshio Rogers', '73.70', 4),
(43, 925997, 'Sonia Delgado', '87.10', 1),
(44, 292899, 'Rowan Hancock', '78.00', 5),
(45, 800699, 'Sebastian Keller', '74.30', 4),
(46, 826099, 'Debra Avery', '76.60', 1),
(47, 530299, 'Reed Murphy', '75.50', 3),
(48, 862999, 'Cadman Moody', '70.40', 1),
(49, 466499, 'Xyla Navarro', '87.60', 1),
(50, 909399, 'Buckminster Mcguire', '82.40', 5),
(51, 476099, 'Cora Mcbride', '81.40', 5),
(52, 203799, 'Odessa Wyatt', '72.80', 1),
(53, 360599, 'Melodie Watkins', '79.70', 3),
(54, 361699, 'Murphy Lynch', '76.10', 1),
(55, 443799, 'Allegra Griffin', '78.00', 1),
(56, 449299, 'Venus Webb', '84.10', 2),
(57, 642099, 'Micah York', '75.00', 3),
(58, 923899, 'Joseph Roth', '87.90', 4),
(59, 495599, 'Lucas Wyatt', '77.10', 3),
(60, 538599, 'Dahlia Whitaker', '70.20', 3),
(61, 899499, 'Joel Bonner', '77.90', 2),
(62, 474099, 'Bree Fisher', '79.80', 1),
(63, 120094, 'Oren Cotton', '81.90', 2),
(64, 236399, 'Madison Griffin', '82.00', 3),
(65, 767499, 'Althea Bullock', '83.20', 5),
(66, 144599, 'Colin Cunningham', '68.80', 5),
(67, 581099, 'Vernon Stanley', '78.60', 1),
(68, 600799, 'Summer Irwin', '72.40', 4),
(69, 736599, 'Nadine Robles', '75.80', 5),
(70, 756699, 'Beatrice Ewing', '90.90', 2),
(71, 780699, 'Gil Wiggins', '80.40', 1),
(72, 488999, 'Callum Vincent', '78.80', 4),
(73, 387099, 'Julian Martin', '85.00', 5),
(74, 770699, 'Blythe Cruz', '81.40', 2),
(75, 301599, 'Lamar Nash', '85.40', 1),
(76, 615499, 'Eaton Hamilton', '76.60', 3),
(77, 485599, 'Bruno Mullen', '77.40', 5),
(78, 089599, 'Clarke Burks', '75.60', 2),
(79, 514199, 'Drew Weaver', '86.40', 4),
(80, 333599, 'Noble Dejesus', '87.20', 1);