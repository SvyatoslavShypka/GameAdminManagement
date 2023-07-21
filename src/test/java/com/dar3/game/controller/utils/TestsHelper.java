package com.dar3.game.controller.utils;

import com.dar3.game.entity.Profession;
import com.dar3.game.entity.Race;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class TestsHelper {
    public final static String NORMAL_JSON =
            "{" +
                    "\"name\": \"Testname\"," +
                    "\"title\":\"Testtitle\"," +
                    "\"race\": \"HUMAN\"," +
                    "\"profession\": \"SHOOTER\"," +
                    "\"birthday\" : 988059600000," +
                    "\"banned\":false," +
                    "\"experience\": 63986" +
                    "}";

    public final static String NORMAL_JSON_WITH_ID =
            "{" +
                    "\"id\": %s," +
                    "\"name\": \"Testname\"," +
                    "\"title\":\"Testtitle\"," +
                    "\"race\": \"HUMAN\"," +
                    "\"profession\": \"SHOOTER\"," +
                    "\"birthday\" : 988059600000," +
                    "\"banned\":false," +
                    "\"experience\": 63986" +
                    "}";

    public final static String NORMAL_JSON_WITH_LEVEL =
            "{" +
                    "\"name\": \"Testname\"," +
                    "\"title\":\"Testtitle\"," +
                    "\"race\": \"HUMAN\"," +
                    "\"profession\": \"SHOOTER\"," +
                    "\"birthday\" : 988059600000," +
                    "\"banned\":false," +
                    "\"experience\": 63986," +
                    "\"level\": %s" +
                    "}";

    public static final String EMPTY_NAME_JSON =
            "{" +
                    "\"name\": \"\"," +
                    "\"title\":\"Testtitle\"," +
                    "\"race\": \"HUMAN\"," +
                    "\"profession\": \"SHOOTER\"," +
                    "\"birthday\" : 988059600000," +
                    "\"banned\":false," +
                    "\"experience\": 63986" +
                    "}";

    public static final String NEGATIVE_BIRTHDAY_JSON =
            "{" +
                    "\"name\": \"Testname\"," +
                    "\"title\":\"Testtitle\"," +
                    "\"race\": \"HUMAN\"," +
                    "\"birthday\" : -988059600000," +
                    "\"banned\":false," +
                    "\"experience\": 63986" +
                    "}";

    public static final String TOO_BIG_EXPERIENCE_JSON =
            "{" +
                    "\"name\": \"Testname\"," +
                    "\"title\":\"Testtitle\"," +
                    "\"race\": \"HUMAN\"," +
                    "\"profession\": \"SHOOTER\"," +
                    "\"birthday\" : 988059600000," +
                    "\"banned\":false," +
                    "\"experience\": 10000001" +
                    "}";

    public static final String NEGATIVE_EXPERIENCE_JSON =
            "{" +
                    "\"name\": \"Testname\"," +
                    "\"title\":\"Testtitle\"," +
                    "\"race\": \"HUMAN\"," +
                    "\"profession\": \"SHOOTER\"," +
                    "\"birthday\" : 988059600000," +
                    "\"Banned\":false," +
                    "\"experience\": -2" +
                    "}";

    public static final String TOO_BIG_TITLE_LENGTH_JSON =
            "{" +
                    "\"name\": \"Testname\"," +
                    "\"title\":\"TesttitleTesttitleTesttitleTesttitleTesttitle\"," +
                    "\"race\": \"HUMAN\"," +
                    "\"profession\": \"SHOOTER\"," +
                    "\"birthday\" : 988059600000," +
                    "\"banned\":false," +
                    "\"experience\": 63986" +
                    "}";

    public static final String BANNED_TRUE_JSON =
            "{" +
                    "\"name\": \"Testname\"," +
                    "\"title\":\"Testtitle\"," +
                    "\"race\": \"HUMAN\"," +
                    "\"profession\": \"SHOOTER\"," +
                    "\"birthday\" : 988059600000," +
                    "\"banned\":true," +
                    "\"experience\": 63986" +
                    "}";

    public static final String JSON_SKELETON =
            "{" +
                    "\"name\": \"%s\"," +
                    "\"banned\":%s," +
                    "\"experience\": %s" +
                    "}";

    public static final String JSON_SKELETON_2 =
            "{" +
                    "\"title\": \"%s\"," +
                    "\"race\": \"%s\"," +
                    "\"profession\": \"%s\"," +
                    "\"birthday\": %s" +
                    "}";

    private final List<PlayerInfoTest> allPlayers = new ArrayList<>();

    public TestsHelper() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        try {
            allPlayers.add(new PlayerInfoTest(1L, "PlayerName1", "Title1", Race.HUMAN, Profession.WARRIOR, sdf.parse("2010-10-12").getTime(), false, 58347, 33, 1153));
            allPlayers.add(new PlayerInfoTest(2L, "PlayerName2", "Title2", Race.HUMAN, Profession.WARRIOR, sdf.parse("2010-02-14").getTime(), false, 174403,
                    58, 2597));
            allPlayers.add(new PlayerInfoTest(3L, "PlayerName3", "Title3", Race.HOBBIT, Profession.WARRIOR, sdf.parse("2006-02-28").getTime(), true, 804, 3,
                    196));
            allPlayers.add(new PlayerInfoTest(4L, "PlayerName4", "Title4", Race.HUMAN, Profession.WARRIOR, sdf.parse("2008-02-25").getTime(), true, 44553, 29
                    , 1947));
            allPlayers.add(new PlayerInfoTest(5L, "PlayerName5", "Title5", Race.HUMAN, Profession.MAGICIAN, sdf.parse("2006-01-07").getTime(), true, 63986,
                    35, 2614));
            allPlayers.add(new PlayerInfoTest(6L, "PlayerName6", "Title6", Race.HUMAN, Profession.WARRIOR, sdf.parse("2004-06-21").getTime(), false, 163743,
                    56, 1557));
            allPlayers.add(new PlayerInfoTest(7L, "PlayerName7", "Title7", Race.HOBBIT, Profession.WARRIOR, sdf.parse("2005-05-15").getTime(), false, 68950, 36, 1350));
            allPlayers.add(new PlayerInfoTest(8L, "PlayerName8", "Title8", Race.HUMAN, Profession.WARRIOR, sdf.parse("2006-08-10").getTime(), false, 61023, 34, 1977));
            allPlayers.add(new PlayerInfoTest(9L, "PlayerName9", "Title9", Race.HUMAN, Profession.WARRIOR, sdf.parse("2010-06-22").getTime(), false, 156630, 55, 2970));
            allPlayers.add(new PlayerInfoTest(10L,"PlayerName11", "Title11", Race.HUMAN, Profession.WARRIOR, sdf.parse("2005-01-12").getTime(), false, 76010, 38, 1990));
            allPlayers.add(new PlayerInfoTest(11L,"PlayerName12", "Title12", Race.ANIMAL, Profession.WARRIOR, sdf.parse("2001-04-24").getTime(), false, 103734, 45, 4366));
            allPlayers.add(new PlayerInfoTest(12L,"PlayerName13", "Title13", Race.HOBBIT, Profession.MAGICIAN, sdf.parse("2010-09-06").getTime(), false, 7903, 12, 1197));
            allPlayers.add(new PlayerInfoTest(13L,"PlayerName14", "Title14", Race.ANIMAL, Profession.SHOOTER, sdf.parse("2009-09-08").getTime(), false, 114088, 47, 3512));
            allPlayers.add(new PlayerInfoTest(14L,"PlayerName15", "Title15", Race.ANIMAL, Profession.MAGICIAN, sdf.parse("2009-07-14").getTime(), false, 29573, 23, 427));
            allPlayers.add(new PlayerInfoTest(15L,"PlayerName16", "Title16", Race.ANIMAL, Profession.SHOOTER, sdf.parse("2005-04-28").getTime(), false, 174414, 58, 2586));
            allPlayers.add(new PlayerInfoTest(16L,"PlayerName17", "Title17", Race.ANIMAL, Profession.MAGICIAN, sdf.parse("2010-03-15").getTime(), false, 49872, 31, 2928));
            allPlayers.add(new PlayerInfoTest(17L,"PlayerName18", "Title18", Race.ANIMAL, Profession.WARRIOR , sdf.parse("2001-09-03").getTime(), false, 162477, 56, 2823));
            allPlayers.add(new PlayerInfoTest(18L,"PlayerName19", "Title19", Race.ANIMAL, Profession.WARRIOR , sdf.parse("2001-04-08").getTime(), true, 136860, 51, 940));
            allPlayers.add(new PlayerInfoTest(19L,"PlayerName21", "Title21", Race.HUMAN, Profession.WARRIOR, sdf.parse("2005-05-23").getTime(), false, 151039, 54, 2961));
            allPlayers.add(new PlayerInfoTest(20L,"PlayerName22", "Title22", Race.HUMAN, Profession.WARRIOR, sdf.parse("2008-02-09").getTime(), true, 64945, 35, 1655));
            allPlayers.add(new PlayerInfoTest(21L,"PlayerName23", "Title23", Race.HOBBIT, Profession.MAGICIAN, sdf.parse("2003-07-08").getTime(), false, 120006, 48, 2494));
            allPlayers.add(new PlayerInfoTest(22L,"PlayerName24", "Title24", Race.HUMAN, Profession.WARRIOR, sdf.parse("2001-11-07").getTime(), false, 152996, 54, 1004));
            allPlayers.add(new PlayerInfoTest(23L,"PlayerName25", "Title25", Race.HUMAN, Profession.EXPLORER, sdf.parse("2008-01-04").getTime(), true, 86585, 41, 3715));
            allPlayers.add(new PlayerInfoTest(24L,"PlayerName26", "Title26", Race.ALIEN, Profession.MAGICIAN, sdf.parse("2010-01-25").getTime(), false, 106181, 45, 1919));
            allPlayers.add(new PlayerInfoTest(25L,"PlayerName27", "Title27", Race.ALIEN, Profession.EXPLORER, sdf.parse("2010-10-03").getTime(), false, 33889, 25, 1211));
            allPlayers.add(new PlayerInfoTest(26L,"PlayerName28", "Title28", Race.ALIEN, Profession.WARRIOR, sdf.parse("2004-05-17").getTime(), false, 91676, 42, 2924));
            allPlayers.add(new PlayerInfoTest(27L,"PlayerName29", "Title29", Race.HOBBIT, Profession.WARRIOR, sdf.parse("2010-10-04").getTime(), false, 93079, 42, 1521));
            allPlayers.add(new PlayerInfoTest(28L,"PlayerName31", "Title31", Race.ALIEN, Profession.WARRIOR, sdf.parse("2005-08-05").getTime(), true, 79884, 39, 2116));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public List<PlayerInfoTest> getAllPlayers() {
        return allPlayers;
    }


    public List<PlayerInfoTest> getPlayerInfosByName(String name, List<PlayerInfoTest> players) {
        List<PlayerInfoTest> result = new ArrayList<>();
        for (PlayerInfoTest player : players) {
            if (player.name.contains(name)) {
                result.add(player);
            }
        }
        return result;
    }

    public List<PlayerInfoTest> getPlayerInfosByTitle(String title, List<PlayerInfoTest> players) {
        List<PlayerInfoTest> result = new ArrayList<>();
        for (PlayerInfoTest player : players) {
            if (player.title.contains(title)) {
                result.add(player);
            }
        }
        return result;
    }

    public List<PlayerInfoTest> getPlayerInfosByRace(Race race, List<PlayerInfoTest> players) {
        List<PlayerInfoTest> result = new ArrayList<>();
        for (PlayerInfoTest player : players) {
            if (player.race == race) {
                result.add(player);
            }
        }
        return result;
    }

    public List<PlayerInfoTest> getPlayerInfosByProfession(Profession profession, List<PlayerInfoTest> players) {
        List<PlayerInfoTest> result = new ArrayList<>();
        for (PlayerInfoTest player : players) {
            if (player.profession == profession) {
                result.add(player);
            }
        }
        return result;
    }

    public List<PlayerInfoTest> getPlayerInfosByAfter(Long after, List<PlayerInfoTest> players) {
        List<PlayerInfoTest> result = new ArrayList<>();
        for (PlayerInfoTest player : players) {
            if (player.birthday >= after) {
                result.add(player);
            }
        }
        return result;
    }

    public List<PlayerInfoTest> getPlayerInfosByBefore(Long before, List<PlayerInfoTest> players) {
        List<PlayerInfoTest> result = new ArrayList<>();
        for (PlayerInfoTest player : players) {
            if (player.birthday <= before) {
                result.add(player);
            }
        }
        return result;
    }

    public List<PlayerInfoTest> getPlayerInfosByBaned(Boolean Banned, List<PlayerInfoTest> players) {
        List<PlayerInfoTest> result = new ArrayList<>();
        for (PlayerInfoTest player : players) {
            if (player.banned == Banned) {
                result.add(player);
            }
        }
        return result;
    }

    public List<PlayerInfoTest> getPlayerInfosByMinExperience(Integer minExperience, List<PlayerInfoTest> players) {
        List<PlayerInfoTest> result = new ArrayList<>();
        for (PlayerInfoTest player : players) {
            if (player.experience >= minExperience) {
                result.add(player);
            }
        }
        return result;
    }

    public List<PlayerInfoTest> getPlayerInfosByMaxExperience(Integer maxExperience, List<PlayerInfoTest> players) {
        List<PlayerInfoTest> result = new ArrayList<>();
        for (PlayerInfoTest player : players) {
            if (player.experience <= maxExperience) {
                result.add(player);
            }
        }
        return result;
    }

    public List<PlayerInfoTest> getPlayerInfosByMinLevel(Integer minLevel, List<PlayerInfoTest> players) {
        List<PlayerInfoTest> result = new ArrayList<>();
        for (PlayerInfoTest player : players) {
            if (player.level >= minLevel) {
                result.add(player);
            }
        }
        return result;
    }

    public List<PlayerInfoTest> getPlayerInfosByMaxLevel(Integer maxLevel, List<PlayerInfoTest> players) {
        List<PlayerInfoTest> result = new ArrayList<>();
        for (PlayerInfoTest player : players) {
            if (player.level <= maxLevel) {
                result.add(player);
            }
        }
        return result;
    }

    public List<PlayerInfoTest> getPlayerInfosByPage(Integer pageNumber, Integer pageSize, List<PlayerInfoTest> players) {
        int skip = pageNumber * pageSize;
        List<PlayerInfoTest> result = new ArrayList<>();
        for (int i = skip; i < Math.min(skip + pageSize, players.size()); i++) {
            result.add(players.get(i));
        }
        return result;
    }

    public PlayerInfoTest getPlayerInfosById(long id) {
        return allPlayers.stream().filter(s -> s.id == id).findFirst().orElse(null);
    }

    public void setPlayer(PlayerInfoTest player) {
        this.allPlayers.add(player.getId().intValue()-1, player);
//        return allPlayers;
    }
}

