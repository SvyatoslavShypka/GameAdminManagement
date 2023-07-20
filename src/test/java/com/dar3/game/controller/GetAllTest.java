package com.dar3.game.controller;

import com.dar3.game.controller.utils.PlayerInfoTest;
import com.dar3.game.controller.utils.TestsHelper;
import com.dar3.game.entity.Profession;
import com.dar3.game.entity.Race;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import java.util.List;

import static org.springframework.test.util.AssertionErrors.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class GetAllTest extends AbstractTest {

    private final TestsHelper testsHelper = new TestsHelper();
    private final ObjectMapper mapper = new ObjectMapper();
    private final TypeReference<List<PlayerInfoTest>> typeReference = new TypeReference<List<PlayerInfoTest>>() {
    };

    //test1
    @Test
    public void getAllWithoutFiltersReturnAllPlayers() throws Exception {
        ResultActions resultActions = mockMvc.perform(get("/rest/players"))
                .andExpect(status().isOk());

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();

        List<PlayerInfoTest> actual = mapper.readValue(contentAsString, typeReference);
        List<PlayerInfoTest> expected = testsHelper.getPlayerInfosByPage(0, 3,
                testsHelper.getAllPlayers());
        assertEquals("Wrong result during request GET /rest/players.", expected, actual);
    }

    //test2
    @Test
    public void getAllWithFiltersNamePageNumber() throws Exception {
        ResultActions resultActions = mockMvc.perform(get("/rest/players?name=ра&pageNumber=1"))
                .andExpect(status().isOk());

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();
        List<PlayerInfoTest> actual = mapper.readValue(contentAsString, typeReference);
        List<PlayerInfoTest> expected = testsHelper.getPlayerInfosByPage(1, 3,
                testsHelper.getPlayerInfosByName("ра",
                        testsHelper.getAllPlayers()));

        assertEquals("Wrong result during request GET /rest/players with parameters name and pageNumber.", expected, actual);
    }

    //test3
    @Test
    public void getAllWithFiltersTitlePageSize() throws Exception {
        ResultActions resultActions = mockMvc.perform(get("/rest/players?title=ой&pageSize=4"))
                .andExpect(status().isOk());

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();

        List<PlayerInfoTest> actual = mapper.readValue(contentAsString, typeReference);
        List<PlayerInfoTest> expected = testsHelper.getPlayerInfosByPage(0, 4,
                testsHelper.getPlayerInfosByTitle("ой", testsHelper.getAllPlayers()));

        assertEquals("Wrong result during request GET /rest/players with parameters title and pageSize.", expected, actual);
    }

    //test4
    @Test
    public void getAllWithFiltersRaceProfessionAfterBefore() throws Exception {
        //after 00:00 01.01.2003
        //before 00:00 01.01.2006
        ResultActions resultActions = mockMvc.perform(get("/rest/players?race=HUMAN&profession=WARRIOR&after=1041372000000&before=1136066400000"))
                .andExpect(status().isOk());

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();

        List<PlayerInfoTest> actual = mapper.readValue(contentAsString, typeReference);

        List<PlayerInfoTest> expected = testsHelper.getPlayerInfosByPage(0, 3,
                testsHelper.getPlayerInfosByRace(Race.HUMAN,
                        testsHelper.getPlayerInfosByProfession(Profession.WARRIOR,
                                testsHelper.getPlayerInfosByAfter(1041372000000L,
                                        testsHelper.getPlayerInfosByBefore(1136066400000L,
                                                testsHelper.getAllPlayers())))));

        assertEquals("Wrong result during request GET /rest/players with parameters race, profession, after and before.", expected, actual);
    }

    //test5
    @Test
    public void getAllWithFiltersRaceProfessionMinExperienceMaxExperience() throws Exception {
        ResultActions resultActions = mockMvc.perform(get("/rest/players?race=ALIEN&profession=WARRIOR&minExperience=50000&maxExperience=150000"))
                .andExpect(status().isOk());

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();

        List<PlayerInfoTest> actual = mapper.readValue(contentAsString, typeReference);
        List<PlayerInfoTest> expected = testsHelper.getPlayerInfosByPage(0, 3,
                testsHelper.getPlayerInfosByRace(Race.ALIEN,
                        testsHelper.getPlayerInfosByProfession(Profession.WARRIOR,
                                testsHelper.getPlayerInfosByMinExperience(50000,
                                        testsHelper.getPlayerInfosByMaxExperience(150000,
                                                testsHelper.getAllPlayers())))));

        assertEquals("Wrong result during request GET /rest/players with parameters race, minExperience and maxExperience.", expected, actual);
    }

    //test6
    @Test
    public void getAllWithFiltersBannedMinLevelMaxLevel() throws Exception {
        ResultActions resultActions = mockMvc.perform(get("/rest/players?banned=false&minLevel=10&maxLevel=30"))
                .andExpect(status().isOk());

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();

        List<PlayerInfoTest> actual = mapper.readValue(contentAsString, typeReference);
        List<PlayerInfoTest> expected = testsHelper.getPlayerInfosByPage(0, 3,
                testsHelper.getPlayerInfosByBaned(false,
                        testsHelper.getPlayerInfosByMinLevel(10,
                                testsHelper.getPlayerInfosByMaxLevel(30,
                                        testsHelper.getAllPlayers()))));

        assertEquals("Wrong result during request GET /rest/players with parameters banned, minLevel and maxLevel.", expected, actual);
    }

    //test7
    @Test
    public void getAllWithFiltersBannedMaxLevel() throws Exception {
        ResultActions resultActions = mockMvc.perform(get("/rest/players?banned=false&maxLevel=20"))
                .andExpect(status().isOk());

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();

        List<PlayerInfoTest> actual = mapper.readValue(contentAsString, typeReference);
        List<PlayerInfoTest> expected = testsHelper.getPlayerInfosByPage(0, 3,
                testsHelper.getPlayerInfosByBaned(false,
                        testsHelper.getPlayerInfosByMaxLevel(20,
                                testsHelper.getAllPlayers())));

        assertEquals("Wrong result during request GET /rest/players with parameters banned and maxLevel.", expected, actual);
    }

    //test8
    @Test
    public void getAllWithFiltersAfterBeforeMinExperienceMaxExperience() throws Exception {
        //after 00:00 01.01.2005
        //before 00:00 01.01.2009
        ResultActions resultActions = mockMvc.perform(get("/rest/players?after=1104530400000&before=1230760800000&minExperience=30000&maxExperience=100000&pageNumber=1"))
                .andExpect(status().isOk());

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();

        List<PlayerInfoTest> actual = mapper.readValue(contentAsString, typeReference);
        List<PlayerInfoTest> expected = testsHelper.getPlayerInfosByPage(1, 3,
                testsHelper.getPlayerInfosByAfter(1104530400000L,
                        testsHelper.getPlayerInfosByBefore(1230760800000L,
                                testsHelper.getPlayerInfosByMinExperience(30000,
                                        testsHelper.getPlayerInfosByMaxExperience(100000,
                                                testsHelper.getAllPlayers())))));

        assertEquals("Wrong result during request GET /rest/players with parameters after, before, minExperience and maxExperience.", expected, actual);
    }
}
