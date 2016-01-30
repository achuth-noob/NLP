-- phpMyAdmin SQL Dump
-- version 4.0.10deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jan 20, 2016 at 12:43 PM
-- Server version: 5.5.46-0ubuntu0.14.04.2
-- PHP Version: 5.5.9-1ubuntu4.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `NewsKeywordsDB`
--

-- --------------------------------------------------------

--
-- Table structure for table `KeywordDetails`
--

CREATE TABLE IF NOT EXISTS `KeywordDetails` (
  `id` int(11) NOT NULL,
  `headline` varchar(500) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `url` varchar(1000) DEFAULT NULL,
  `keyword_count` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `KeywordDetails`
--

INSERT INTO `KeywordDetails` (`url`) VALUES
('http://zeenews.india.com/news/bihar/bihar-polls-ljp-promises-quota-in-private-sector_1808218.html'),
('http://indianexpress.com/article/india/india-news-india/pm-narendra-modis-rally-at-bhabhua-tomorrow-gets-ec-clearance/'),
('http://indianexpress.com/article/india/india-news-india/pm-narendra-modis-rally-at-bhabhua-tomorrow-gets-ec-clearance/'),
('http://www.ibnlive.com/news/politics/bihar-all-set-for-change-phenomenal-enthusiasm-for-nda-tweets-modi-1156040.html'),
('http://www.ibnlive.com/news/politics/bihar-all-set-for-change-phenomenal-enthusiasm-for-nda-tweets-modi-1156040.html'),
('http://www.ndtv.com/'),
('http://timesofindia.indiatimes.com/elections/bihar-elections-2015/news/Bihar-exit-poll-Backwards-stay-united-with-Mahagatbandhan/articleshow/49677321.cms'),
('http://timesofindia.indiatimes.com/elections/bihar-elections-2015/news/Bihar-exit-poll-Backwards-stay-united-with-Mahagatbandhan/articleshow/49677321.cms'),
('http://timesofindia.indiatimes.com/elections/bihar-elections-2015/news/CVoter-exit-poll-BJP-to-emerge-single-largest-party-in-Bihar/articleshow/49675383.cms'),
('http://timesofindia.indiatimes.com/elections/bihar-elections-2015/news/Bihar-exit-poll-46-of-mahadalits-vote-for-NDA-Jitan-Ram-Manjhi-emerges-as-prominent-leader/articleshow/49675878.cms'),
('http://timesofindia.indiatimes.com/elections/bihar-elections-2015/news/CVoter-exit-poll-BJP-to-emerge-single-largest-party-in-Bihar/articleshow/49675383.cms'),
('http://timesofindia.indiatimes.com/elections/bihar-elections-2015/news/Bihar-exit-poll-46-of-mahadalits-vote-for-NDA-Jitan-Ram-Manjhi-emerges-as-prominent-leader/articleshow/49675878.cms'),
('http://timesofindia.indiatimes.com/elections/bihar-elections-2015/Exit-polls-divided-on-Bihar-4-give-Nitish-Lalu-majority-1-an-NDA-sweep/articleshow/49680298.cms'),
('http://timesofindia.indiatimes.com/elections/bihar-elections-2015/Bihar-sees-highest-turnout-in-15-years/articleshow/49680562.cms'),
('http://timesofindia.indiatimes.com/elections/bihar-elections-2015/Exit-polls-divided-on-Bihar-4-give-Nitish-Lalu-majority-1-an-NDA-sweep/articleshow/49680298.cms'),
('http://timesofindia.indiatimes.com/elections/bihar-elections-2015/Exit-polls-divided-on-Bihar-4-give-Nitish-Lalu-majority-1-an-NDA-sweep/articleshow/49680298.cms'),
('http://indianexpress.com/article/opinion/columns/india-india-politics-nitish-kumar-tantrics/'),
('http://timesofindia.indiatimes.com/elections/bihar-elections-2015/news/India-holds-breath-as-Bihar-finally-shows-its-hand-today/articleshow/49706527.cms'),
('http://timesofindia.indiatimes.com/city/delhi/Subdued-Nitish-sprightly-Lalu-a-study-in-contrasts/articleshow/49706686.cms'),
('http://timesofindia.indiatimes.com/elections/bihar-elections-2015/news/Whichever-way-it-swings-EC-the-real-winner-in-Bihar/articleshow/49706640.cms'),
('http://timesofindia.indiatimes.com/elections/bihar-elections-2015/news/Election-Commission/articleshow/49707044.cms'),
('http://timesofindia.indiatimes.com/elections/bihar-elections-2015/news/India-holds-breath-as-Bihar-finally-shows-its-hand-today/articleshow/49706527.cms'),
('http://timesofindia.indiatimes.com/elections/bihar-elections-2015/news/India-holds-breath-as-Bihar-finally-shows-its-hand-today/articleshow/49706527.cms'),
('http://timesofindia.indiatimes.com/city/delhi/Subdued-Nitish-sprightly-Lalu-a-study-in-contrasts/articleshow/49706686.cms'),
('http://timesofindia.indiatimes.com/elections/bihar-elections-2015/news/Whichever-way-it-swings-EC-the-real-winner-in-Bihar/articleshow/49706640.cms'),
(''),
(''),
('http://timesofindia.indiatimes.com/city/delhi/Subdued-Nitish-sprightly-Lalu-a-study-in-contrasts/articleshow/49706686.cms'),
(''),
(''),
('http://timesofindia.indiatimes.com/elections/bihar-elections-2015/news/India-holds-breath-as-Bihar-finally-shows-its-hand-today/articleshow/49706527.cms'),
('http://timesofindia.indiatimes.com/city/delhi/Subdued-Nitish-sprightly-Lalu-a-study-in-contrasts/articleshow/49706686.cms'),
(''),
(''),
(''),
(''),
(''),
('https://www.youtube.com/watch?v=luhFQGksmJI'),
('http://www.ndtv.com/photos/news/bihar-verdict-maha-win-for-mahagatbandhan-20904'),
('http://www.ndtv.com/photos/news/bihar-verdict-maha-win-for-mahagatbandhan-20904'),
('http://www.hindustantimes.com/videos/india/watch-amit-shah-must-take-bihar-as-wake-up-call/video-0au75VPgHhJEodUAOGkGLP.html'),
('http://www.hindustantimes.com/videos/india/watch-amit-shah-must-take-bihar-as-wake-up-call/video-0au75VPgHhJEodUAOGkGLP.html'),
('http://www.hindustantimes.com/videos/india/watch-amit-shah-must-take-bihar-as-wake-up-call/video-0au75VPgHhJEodUAOGkGLP.html'),
('http://www.hindustantimes.com/videos/india/watch-amit-shah-must-take-bihar-as-wake-up-call/video-0au75VPgHhJEodUAOGkGLP.html'),
('http://www.ndtv.com/photos/news/and-the-winners-the-bihari-brothers-20904'),
('http://www.ndtv.com/photos/news/and-the-winners-the-bihari-brothers-20904'),
('http://www.ndtv.com/photos/news/game-set-and-match-to-the-bihari-brothers-20904'),
('http://www.ndtv.com/photos/news/game-set-and-match-to-the-bihari-brothers-20904'),
('http://www.ndtv.com/photos/news/bihar-election-results-2015-tracking-the-heavyweights-20906'),
('http://timesofindia.indiatimes.com/elections/bihar-elections-2015/news/Whichever-way-it-swings-EC-the-real-winner-in-Bihar/articleshow/49706640.cms'),
('http://www.ndtv.com/photos/news/bihar-election-results-2015-prominent-winners-and-losers-20906'),
('http://indianexpress.com/article/opinion/editorials/after-the-counting-comes-the-reading/'),
('http://timesofindia.indiatimes.com/elections/bihar-elections-2015/news/Lalu-and-I-understand-each-other-well-Nitish-Kumar/articleshow/49717086.cms'),
('http://timesofindia.indiatimes.com/elections/bihar-elections-2015/news/What-does-the-Bihar-verdict-mean/articleshow/49717291.cms'),
('http://timesofindia.indiatimes.com/elections/bihar-elections-2015/news/Let-Nitish-take-a-call-on-deputy-CM-Lalu-Prasad/articleshow/49717214.cms'),
('http://timesofindia.indiatimes.com/elections/bihar-elections-2015/news/Bettiah-sends-cracker-of-a-reply-to-Amit-Shah/articleshow/49717788.cms'),
('http://www.ibnlive.com/news/politics/shiv-sena-hits-out-at-its-ally-over-defeat-in-bihar-says-bjp-needs-to-learn-a-lesson-in-humility-1162380.html'),
('http://www.ibnlive.com/news/politics/shiv-sena-hits-out-at-its-ally-over-defeat-in-bihar-says-bjp-needs-to-learn-a-lesson-in-humility-1162380.html'),
('http://timesofindia.indiatimes.com/elections/bihar-elections-2015/news/Bihar-Elections-Bihar-Election-2015-Bihar-Election-Results-Bihar-Election-Results-2015-BJP-NDA/articleshow/49717382.cms'),
('http://timesofindia.indiatimes.com/elections/bihar-elections-2015/news/Bihar-electionresults-Murmurs-in-BJP-that-Amit-Shah-will-be-proxy-target/articleshow/49717474.cms'),
('http://timesofindia.indiatimes.com/elections/bihar-elections-2015/news/Bihar-electionresults-Murmurs-in-BJP-that-Amit-Shah-will-be-proxy-target/articleshow/49717474.cms'),
('http://timesofindia.indiatimes.com/elections/bihar-elections-2015/news/Bihar-election-results-2015-Caste-tension-in-Ara-as-1-dies-in-post-poll-violence/articleshow/49730316.cms'),
('http://timesofindia.indiatimes.com/elections/bihar-elections-2015/news/Bihar-election-results-2015-Junk-divisive-politics-Urdu-media-tells-BJP/articleshow/49730952.cms'),
('http://timesofindia.indiatimes.com/elections/bihar-elections-2015/news/Bihar-election-results-2015-Criticism-of-Narendra-Modi-Amit-Shah-doesnt-find-traction-with-RSS/articleshow/49730833.cms'),
('http://timesofindia.indiatimes.com/elections/bihar-elections-2015/news/Bihar-election-results-2015-Caste-tension-in-Ara-as-1-dies-in-post-poll-violence/articleshow/49730316.cms'),
('http://timesofindia.indiatimes.com/elections/bihar-elections-2015/news/Bihar-election-results-2015-Criticism-of-Narendra-Modi-Amit-Shah-doesnt-find-traction-with-RSS/articleshow/49730833.cms'),
('http://timesofindia.indiatimes.com/elections/bihar-elections-2015/news/Bihar-election-results-2015-Criticism-of-Narendra-Modi-Amit-Shah-doesnt-find-traction-with-RSS/articleshow/49730833.cms'),
('http://timesofindia.indiatimes.com/elections/bihar-elections-2015/news/Bihar-election-result-Modi-to-blame-for-NDA-debacle-Congress-says/articleshow/49742385.cms'),
('http://timesofindia.indiatimes.com/elections/bihar-elections-2015/news/Bihar-election-Officials-inspect-Gandhi-Maidan-gear-up-for-oath-ceremony/articleshow/49742261.cms'),
('http://timesofindia.indiatimes.com/elections/bihar-elections-2015/news/Bihar-election-result-JDU-RJD-discuss-ministers-portfolios/articleshow/49742407.cms'),
('http://timesofindia.indiatimes.com/elections/bihar-elections-2015/news/Every-action-has-equal-opposite-reaction-Nitish-on-BJP-rumblings/articleshow/49747264.cms'),
('http://timesofindia.indiatimes.com/elections/bihar-elections-2015/news/Every-action-has-equal-opposite-reaction-Nitish-on-BJP-rumblings/articleshow/49747264.cms'),
('http://timesofindia.indiatimes.com/elections/bihar-elections-2015/news/Every-action-has-equal-opposite-reaction-Nitish-on-BJP-rumblings/articleshow/49747264.cms'),
('http://www.ibnlive.com/news/politics/saddened-by-humiliating-defeat-in-bihar-but-shouldnt-run-away-from-fixing-responsibility-shatrughan-sinha-1163405.html'),
('http://www.hindustantimes.com/india/nitish-to-take-oath-on-november-20-at-gandhi-maidan/story-r7FapKpI03Ql5VT58WrdOI.html'),
('http://www.businessworld.in/article/Five-Reasons-Why-Parliament-Will-Stall-Again/17-12-2015-88695'),
('http://www.businessworld.in/article/Five-Reasons-Why-Parliament-Will-Stall-Again/17-12-2015-88695'),
('http://www.businessworld.in/article/Five-Reasons-Why-Parliament-Will-Stall-Again/17-12-2015-88695'),
('http://www.businessworld.in/article/Five-Reasons-Why-Parliament-Will-Stall-Again/17-12-2015-88695'),
('http://zeenews.india.com/news/india/elections-that-changed-dynamics-of-indian-politics-in-2015_1835202.html');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
