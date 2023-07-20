package com.dar3.game.controller;

import com.dar3.game.controller.utils.PlayerInfoTest;
import com.dar3.game.controller.utils.TestsHelper;
import com.dar3.game.entity.Profession;
import com.dar3.game.entity.Race;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.util.AssertionErrors.assertEquals;
import static org.springframework.test.util.AssertionErrors.assertNotEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class UpdatePlayerTest extends AbstractTest {

    private final TestsHelper testsHelper = new TestsHelper();
    private final ObjectMapper mapper = new ObjectMapper();

    //test1 updatePlayerIdZero
    @Test
    public void updatePlayerIdZeroTest() throws Exception {
        mockMvc.perform(post("/rest/players/0")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(TestsHelper.NORMAL_JSON))
                .andExpect(status().isBadRequest());
    }

    //test2 updatePlayerNotExist
    @Test
    public void updatePlayerNotExistTest() throws Exception {
        mockMvc.perform(post("/rest/players/415")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(TestsHelper.NORMAL_JSON))
                .andExpect(status().isNotFound());
    }

    //test3 EMPTY_NAME
    @Test
    public void updatePlayerInvalidNameTest() throws Exception {
        PlayerInfoTest playerInfoTest = testsHelper.getPlayerInfosById(1);

        mockMvc.perform(MockMvcRequestBuilders.post("/rest/players/" + playerInfoTest.id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(TestsHelper.EMPTY_NAME_JSON))
                .andExpect(status().isBadRequest());
    }

    //test4 NEGATIVE_BIRTHDAY
    @Test
    public void updatePlayerInvalidBirthdayTest() throws Exception {
        PlayerInfoTest playerInfoTest = testsHelper.getPlayerInfosById(1);

        mockMvc.perform(MockMvcRequestBuilders.post("/rest/players/" + playerInfoTest.id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(TestsHelper.NEGATIVE_BIRTHDAY_JSON))
                .andExpect(status().isBadRequest());
    }

    //test5 TOO_BIG_EXPERIENCE
    @Test
    public void updatePlayerInvalidExperienceTest() throws Exception {
        PlayerInfoTest playerInfoTest = testsHelper.getPlayerInfosById(1);

        mockMvc.perform(MockMvcRequestBuilders.post("/rest/players/" + playerInfoTest.id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(TestsHelper.TOO_BIG_EXPERIENCE_JSON))
                .andExpect(status().isBadRequest());
    }

    //test6 NEGATIVE_EXPERIENCE
    @Test
    public void updatePlayerInvalidExperienceTest2() throws Exception {
        PlayerInfoTest playerInfoTest = testsHelper.getPlayerInfosById(1);

        mockMvc.perform(MockMvcRequestBuilders.post("/rest/players/" + playerInfoTest.id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(TestsHelper.NEGATIVE_EXPERIENCE_JSON))
                .andExpect(status().isBadRequest());
    }

    //test7 updatePlayerWithId
    @Test
    public void updatePlayerWithIdTest() throws Exception {
        PlayerInfoTest expected = mapper.readValue(String.format(TestsHelper.NORMAL_JSON_WITH_ID, 5), PlayerInfoTest.class);
        expected.level = 35;
        expected.untilNextLevel = 2614;

        ResultActions resultActions = mockMvc.perform(post("/rest/players/5")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(String.format(TestsHelper.NORMAL_JSON_WITH_ID, 8L)))
                .andExpect(status().isOk());

        String contentAsString = resultActions.andReturn().getResponse().getContentAsString();
        PlayerInfoTest actual = mapper.readValue(contentAsString, PlayerInfoTest.class);

        assertNotEquals("During request POST /rest/players/{id} field id shouldn't be updated.", 8, actual.id);
        assertEquals("During request POST /rest/players/{id} with id in the request's body, " +
                        "fields have to be updated excluding id", expected, actual);
    }

    //test8 updatePlayerEmptyBody
    @Test
    public void updatePlayerEmptyBodyTest() throws Exception {
        PlayerInfoTest expected = testsHelper.getPlayerInfosById(17);

        ResultActions resultActions = mockMvc.perform(post("/rest/players/17")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{}"))
                .andExpect(status().isOk());

        String contentAsString = resultActions.andReturn().getResponse().getContentAsString();
        PlayerInfoTest actual = mapper.readValue(contentAsString, PlayerInfoTest.class);

        assertEquals("During request POST /rest/players/{id} with empty request's body, " +
                "player shouldn't be updated", expected, actual);
    }

    //test9 updatePlayerLevel
    @Test
    public void updatePlayerLevelTest() throws Exception {
        PlayerInfoTest expected = mapper.readValue(String.format(TestsHelper.NORMAL_JSON_WITH_ID, 23), PlayerInfoTest.class);
        expected.level = 35;
        expected.untilNextLevel = 2614;

        ResultActions resultActions = mockMvc.perform(post("/rest/players/23")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(String.format(TestsHelper.NORMAL_JSON_WITH_LEVEL, "9")))
                .andExpect(status().isOk());

        String contentAsString = resultActions.andReturn().getResponse().getContentAsString();
        PlayerInfoTest actual = mapper.readValue(contentAsString, PlayerInfoTest.class);

        assertEquals("During request POST /rest/players/{id} with level in request's body," +
                        "fields have to be updated excluding field level", expected, actual);
    }

    //test10
    //check if level and UntilNextLevel are calculated each time
    @Test
    public void updatePlayerWithDataTest1() throws Exception {
        PlayerInfoTest playerInfoTest = testsHelper.getPlayerInfosById(14);
        System.out.println("Was: " + playerInfoTest);
        String newName = "TestName";
        boolean newBanned = false;
        int newExperience = 2500;

        PlayerInfoTest expected = new PlayerInfoTest(playerInfoTest.id, newName, playerInfoTest.title, playerInfoTest.race, playerInfoTest.profession,
                playerInfoTest.birthday, newBanned, newExperience, 6, 300);

        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.post("/rest/players/" + playerInfoTest.id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(String.format(TestsHelper.JSON_SKELETON, newName, newBanned, newExperience)))
                .andExpect(status().isOk());

        String contentAsString = resultActions.andReturn().getResponse().getContentAsString();
        PlayerInfoTest actual = mapper.readValue(contentAsString, PlayerInfoTest.class);
        System.out.println("Expected: " + expected);
        System.out.println("Actual: " + actual);
//        testsHelper.setPlayer(actual);

        System.out.println(testsHelper.getPlayerInfosById(14));

        assertEquals("During request POST /rest/players/{id} player has to be updated" +
                        "and level and UntilNextlevel have to be recalculated", expected, actual);
    }

    //test11
    @Test
    public void updatePlayerWithDataTest2() throws Exception {
        PlayerInfoTest playerInfoTest = testsHelper.getPlayerInfosById(32);
        System.out.println("Tested player: " + playerInfoTest);

        String newTitle = "TestName";
        Race newRace = Race.ALIEN;
        Profession newProfession = Profession.SHOOTER;
        long newBirthday = 1178571600000L;

        PlayerInfoTest expected = new PlayerInfoTest(playerInfoTest.id, playerInfoTest.name, newTitle, newRace, newProfession, newBirthday,
                playerInfoTest.banned, playerInfoTest.experience, playerInfoTest.level, playerInfoTest.untilNextLevel);

        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.post("/rest/players/" + playerInfoTest.id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(String.format(TestsHelper.JSON_SKELETON_2, newTitle, newRace, newProfession, newBirthday)))
                .andExpect(status().isOk());

        String contentAsString = resultActions.andReturn().getResponse().getContentAsString();
        PlayerInfoTest actual = mapper.readValue(contentAsString, PlayerInfoTest.class);

        System.out.println("Expected: " + expected);
        System.out.println("Actual: " + actual);
        testsHelper.setPlayer(actual);

        System.out.println(testsHelper.getPlayerInfosById(14));

        assertEquals("In request POST /rest/players/{id} player has to be updated, Level & UntilNextLevel have to be re-calculated", expected, actual);
    }
}

