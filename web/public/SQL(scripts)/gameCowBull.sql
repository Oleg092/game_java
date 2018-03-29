-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2
-- http://www.phpmyadmin.net
--
-- Хост: localhost
-- Время создания: Июл 19 2017 г., 05:50
-- Версия сервера: 5.7.18-0ubuntu0.16.04.1
-- Версия PHP: 7.0.18-0ubuntu0.16.04.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `gameCowBull`
--

-- --------------------------------------------------------

--
-- Структура таблицы `att`
--

CREATE TABLE `att` (
  `id` int(10) NOT NULL,
  `user` int(8) NOT NULL,
  `b` int(1) NOT NULL,
  `num` int(4) NOT NULL,
  `k` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `att`
--

INSERT INTO `att` (`id`, `user`, `b`, `num`, `k`) VALUES
(57, 1, 1, 1234, 1),
(58, 1, 1, 2341, 1),
(59, 1, 2, 5678, 0),
(60, 1, 0, 1425, 3),
(61, 1, 0, 4567, 2),
(62, 1, 1, 9876, 0),
(63, 1, 0, 1325, 3),
(64, 1, 2, 5341, 0),
(65, 1, 2, 5341, 0),
(66, 1, 2, 5341, 0),
(67, 1, 0, 1234, 1),
(68, 1, 1, 2145, 1),
(69, 1, 0, 2315, 1),
(70, 1, 1, 2341, 0),
(71, 1, 0, 1234, 1),
(72, 1, 0, 4231, 1),
(73, 1, 0, 1234, 1),
(74, 1, 0, 4321, 1),
(75, 1, 1, 3421, 0),
(76, 1, 0, 1234, 0),
(77, 1, 0, 2145, 1),
(78, 1, 0, 1234, 2),
(79, 1, 1, 4235, 1),
(80, 1, 0, 1267, 3),
(81, 1, 0, 1278, 3),
(82, 1, 0, 1279, 3),
(83, 1, 1, 1275, 3),
(84, 1, 0, 2715, 0),
(85, 1, 0, 2715, 0),
(86, 2, 0, 1234, 1),
(87, 2, 2, 2675, 2),
(88, 2, 0, 2315, 1),
(89, 2, 0, 2345, 1),
(90, 2, 1, 5678, 1),
(91, 2, 0, 8629, 0),
(92, 2, 1, 1234, 0),
(93, 2, 0, 2345, 0),
(94, 2, 1, 1567, 1),
(95, 2, 1, 1896, 2),
(96, 2, 3, 1689, 0),
(97, 2, 2, 1680, 1),
(98, 2, 2, 1687, 0),
(99, 2, 2, 1589, 0),
(100, 2, 3, 1649, 0),
(101, 2, 3, 1629, 0),
(102, 2, 3, 1639, 0),
(103, 2, 0, 1609, 0),
(104, 2, 1, 1234, 0),
(105, 2, 0, 1234, 1),
(106, 2, 1, 2345, 0),
(107, 2, 2, 2346, 0),
(108, 2, 3, 2786, 0),
(109, 2, 0, 2796, 0),
(110, 2, 3, 2786, 0),
(111, 2, 3, 2786, 0),
(112, 2, 1, 2314, 0),
(113, 2, 1, 2345, 0),
(114, 2, 0, 1234, 1),
(115, 2, 3, 2786, 0),
(116, 2, 2, 2789, 1),
(117, 2, 2, 2708, 0),
(118, 2, 3, 2786, 0),
(119, 2, 2, 2086, 0),
(120, 2, 3, 2706, 0),
(121, 2, 3, 2716, 0),
(122, 2, 3, 2736, 0),
(123, 2, 3, 2746, 0),
(124, 2, 3, 2756, 0),
(125, 2, 0, 2796, 0),
(126, 1, 1, 1234, 1),
(127, 1, 0, 2314, 2),
(128, 1, 0, 2314, 2),
(129, 1, 0, 3214, 2),
(131, 1, 0, 2321, 0),
(132, 1, 0, 3214, 0),
(133, 1, 0, 1334, 1),
(134, 1, 1, 2124, 1),
(135, 1, 1, 1324, 1),
(136, 1, 0, 2345, 2),
(137, 1, 0, 2312, 1),
(138, 1, 0, 1023, 2),
(139, 1, 0, 2345, 2),
(140, 1, 0, 4456, 1),
(141, 1, 0, 2314, 1),
(142, 1, 0, 2345, 1),
(143, 1, 0, 1234, 1),
(144, 1, 2, 5678, 0),
(145, 1, 1, 9876, 2);

-- --------------------------------------------------------

--
-- Структура таблицы `Attempt`
--

CREATE TABLE `Attempt` (
  `id` int(10) NOT NULL,
  `user` int(8) NOT NULL,
  `date` date NOT NULL,
  `NA` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `Attempt`
--

INSERT INTO `Attempt` (`id`, `user`, `date`, `NA`) VALUES
(5, 1, '2017-07-18', 10),
(6, 1, '2017-07-18', 8),
(7, 1, '2017-07-19', 1),
(8, 1, '2017-07-19', 2),
(9, 1, '2017-07-19', 3),
(10, 1, '2017-07-19', 4),
(11, 1, '2017-07-19', 5),
(12, 1, '2017-07-19', 6),
(13, 1, '2017-07-19', 7),
(14, 1, '2017-07-19', 7),
(15, 2, '2017-07-19', 4),
(16, 2, '2017-07-19', 12),
(17, 2, '2017-07-19', 5),
(18, 2, '2017-07-19', 19);

-- --------------------------------------------------------

--
-- Структура таблицы `user`
--

CREATE TABLE `user` (
  `id` int(8) NOT NULL,
  `mail` varchar(50) NOT NULL,
  `login` varchar(20) NOT NULL,
  `password` varchar(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `user`
--

INSERT INTO `user` (`id`, `mail`, `login`, `password`) VALUES
(1, 'xxxx092@ya.ru', 'admin', 'admin'),
(2, 'sema_kot@kot.kot', 'sema2010', 'sema2010'),
(3, 'xxxx092@yandex.ru', '12345', '12345');

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `att`
--
ALTER TABLE `att`
  ADD PRIMARY KEY (`id`),
  ADD KEY `user` (`user`);

--
-- Индексы таблицы `Attempt`
--
ALTER TABLE `Attempt`
  ADD PRIMARY KEY (`id`),
  ADD KEY `user` (`user`);

--
-- Индексы таблицы `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `att`
--
ALTER TABLE `att`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=146;
--
-- AUTO_INCREMENT для таблицы `Attempt`
--
ALTER TABLE `Attempt`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;
--
-- AUTO_INCREMENT для таблицы `user`
--
ALTER TABLE `user`
  MODIFY `id` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- Ограничения внешнего ключа сохраненных таблиц
--

--
-- Ограничения внешнего ключа таблицы `att`
--
ALTER TABLE `att`
  ADD CONSTRAINT `att_ibfk_1` FOREIGN KEY (`user`) REFERENCES `user` (`id`);

--
-- Ограничения внешнего ключа таблицы `Attempt`
--
ALTER TABLE `Attempt`
  ADD CONSTRAINT `Attempt_ibfk_1` FOREIGN KEY (`user`) REFERENCES `user` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
