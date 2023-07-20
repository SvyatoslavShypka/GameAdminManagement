CREATE DATABASE IF NOT EXISTS rpg
    COLLATE utf8mb4_unicode_ci;
CREATE DATABASE IF NOT EXISTS test
    COLLATE utf8mb4_unicode_ci;

USE rpg;

DROP TABLE IF EXISTS player;

CREATE TABLE player
(
    id             BIGINT(20)  NOT NULL AUTO_INCREMENT,
    name           VARCHAR(12) NULL,
    title          VARCHAR(30) NULL,
    race           VARCHAR(20) NULL,
    profession     VARCHAR(20) NULL,
    birthday       DATE        NULL,
    banned         BIT(1)      NULL,
    experience     INT(10)     NULL,
    level          INT(3)      NULL,
    untilNextLevel INT(10)     NULL,
    PRIMARY KEY (id)
)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8;

INSERT INTO player(name, title, race, profession, birthday, banned, experience, level, untilNextLevel)
VALUES ('PlayerName1', 'Title1', 'HUMAN', 'WARRIOR', '2010-10-12', false, 58347, 33, 1153)
     , ('PlayerName2', 'Title2', 'HUMAN', 'WARRIOR', '2010-02-14', false, 174403, 58, 2597)
     , ('PlayerName3', 'Title3', 'HOBBIT ', 'WARRIOR', '2006-02-28', true, 804, 3, 196)
     , ('PlayerName4', 'Title4', 'HUMAN', 'WARRIOR', '2008-02-25', true, 44553, 29, 1947)
     , ('PlayerName5', 'Title5', 'HUMAN', 'MAGICIAN', '2006-01-07', true, 63986, 35, 2614)
     , ('PlayerName6', 'Title6', 'HUMAN', 'WARRIOR', '2004-06-21', false, 163743, 56, 1557)
     , ('PlayerName7', 'Title7', 'HOBBIT', 'WARRIOR', '2005-05-15', false, 68950, 36, 1350)
     , ('PlayerName8', 'Title8', 'HUMAN', 'WARRIOR', '2006-08-10', false, 61023, 34, 1977)
     , ('PlayerName9', 'Title9', 'HUMAN', 'WARRIOR', '2010-06-22', false, 156630, 55, 2970)
     , ('PlayerName11', 'Title11', 'HUMAN', 'WARRIOR', '2005-01-12', false, 76010, 38, 1990)
     , ('PlayerName12', 'Title12', 'ANIMAL', 'WARRIOR', '2001-04-24', false, 103734, 45, 4366)
     , ('PlayerName13', 'Title13', 'HOBBIT', 'MAGICIAN', '2010-09-06', false, 7903, 12, 1197)
     , ('PlayerName14', 'Title14', 'ANIMAL', 'SHOOTER', '2009-09-08', false, 114088, 47, 3512)
     , ('PlayerName15', 'Title15', 'ANIMAL', 'MAGICIAN', '2009-07-14', false, 29573, 23, 427)
     , ('PlayerName16', 'Title16', 'ANIMAL', 'SHOOTER', '2005-04-28', false, 174414, 58, 2586)
     , ('PlayerName17', 'Title17', 'ANIMAL', 'MAGICIAN', '2010-03-15', false, 49872, 31, 2928)
     , ('PlayerName18', 'Title18', 'ANIMAL', 'WARRIOR', '2001-09-03', false, 162477, 56, 2823)
     , ('PlayerName19', 'Title19', 'ANIMAL', 'WARRIOR', '2001-04-08', true, 136860, 51, 940)
     , ('PlayerName21', 'Title21', 'HUMAN', 'WARRIOR', '2005-05-23', false, 151039, 54, 2961)
     , ('PlayerName22', 'Title22', 'HUMAN', 'WARRIOR', '2008-02-09', true, 64945, 35, 1655)
     , ('PlayerName23', 'Title23', 'HOBBIT', 'MAGICIAN', '2003-07-08', false, 120006, 48, 2494)
     , ('PlayerName24', 'Title24', 'HUMAN', 'WARRIOR', '2001-11-07', false, 152996, 54, 1004)
     , ('PlayerName25', 'Title25', 'HUMAN', 'EXPLORER', '2008-01-04', true, 86585, 41, 3715)
     , ('PlayerName26', 'Title26', 'ALIEN', 'MAGICIAN', '2010-01-25', false, 106181, 45, 1919)
     , ('PlayerName27', 'Title27', 'ALIEN', 'EXPLORER', '2010-10-03', false, 33889, 25, 1211)
     , ('PlayerName28', 'Title28', 'ALIEN', 'WARRIOR', '2004-05-17', false, 91676, 42, 2924)
     , ('PlayerName29', 'Title29', 'HOBBIT', 'WARRIOR', '2010-10-04', false, 93079, 42, 1521)
     , ('PlayerName31', 'Title31', 'ALIEN', 'WARRIOR', '2005-08-05', true, 79884, 39, 2116)
     , ('PlayerName32', 'Title32', 'ALIEN', 'WARRIOR', '2003-07-10', false, 111868, 46, 932)
     , ('PlayerName33', 'Title33', 'ALIEN', 'EXPLORER', '2003-05-24', false, 29654, 23, 346)
     , ('PlayerName34', 'Title34', 'ALIEN', 'MAGICIAN', '2005-02-23', false, 18869, 18, 131)
     , ('PlayerName35', 'Title35', 'HUMAN', 'EXPLORER', '2006-12-23', false, 144878, 53, 3622)
     , ('PlayerName36', 'Title36', 'HUMAN', 'WARRIOR', '2010-04-08', false, 59281, 33, 219)
     , ('PlayerName37', 'Title37', 'HOBBIT', 'MAGICIAN', '2001-05-12', false, 173807, 58, 3193)
     , ('PlayerName38', 'Title38', 'HOBBIT', 'WARRIOR', '2008-01-04', false, 848, 3, 152)
     , ('PlayerName39', 'Title39', 'HOBBIT', 'EXPLORER', '2008-08-03', false, 48496, 30, 1104)
     , ('PlayerName41', 'Title41', 'HOBBIT', 'WARRIOR', '2004-06-12', false, 138306, 52, 4794)
     , ('PlayerName42', 'Title42', 'HUMAN', 'WARRIOR', '2007-06-03', false, 115546, 47, 2054)
     , ('PlayerName43', 'Title43', 'HUMAN', 'EXPLORER', '2009-09-16', false, 24984, 21, 316)
     , ('PlayerName44', 'Title44', 'HUMAN', 'WARRIOR', '2010-04-15', true, 60520, 34, 2480)
;
