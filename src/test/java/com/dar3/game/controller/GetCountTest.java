package com.dar3.game.controller;

import com.dar3.game.controller.utils.TestsHelper;
import com.dar3.game.entity.Profession;
import com.dar3.game.entity.Race;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import static org.junit.Assert.assertSame;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class GetCountTest extends AbstractTest {

    private final TestsHelper testsHelper = new TestsHelper();

    //test1
    @Test
    public void getCountWithoutFiltersReturnAllPlayers() throws Exception {
        ResultActions resultActions = this.mockMvc.perform(get("/rest/players/count")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();
        int actual = Integer.parseInt(contentAsString);
        int expected = testsHelper.getAllPlayers().size();

        assertSame("Wrong result during request GET /rest/players/count.", expected, actual);
    }

    //test2
    @Test
    public void getCountWithFiltersMinLevelMinExperience() throws Exception {
        ResultActions resultActions = this.mockMvc.perform(get("/rest/players/count?minLevel=42&minExperience=94000")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();
        int actual = Integer.parseInt(contentAsString);
        int expected = testsHelper.getPlayerInfosByMinLevel(42,
                testsHelper.getPlayerInfosByMinExperience(94000,
                        testsHelper.getAllPlayers())).size();

        assertSame("Wrong result during request GET /rest/players/count with parameters minLevel and minExperience.", expected, actual);
    }

    //test3
    @Test
    public void getCountWithFiltersNameAfterMaxLevel() throws Exception {
        //after 00:00 01.01.2005
        ResultActions resultActions = this.mockMvc.perform(get("/rest/players/count?name=me1&after=1104530400000&maxLevel=40")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();
        int actual = Integer.parseInt(contentAsString);
        int expected = testsHelper.getPlayerInfosByMaxLevel(40,
                testsHelper.getPlayerInfosByAfter(1104530400000L,
                        testsHelper.getPlayerInfosByName("me1",
                                testsHelper.getAllPlayers()))).size();

        assertSame("Wrong result during request GET /rest/players/count with parameters name, after and maxLevel.", expected, actual);
    }

    //test4
    @Test
    public void getCountWithFiltersRaceProfessionBanned() throws Exception {
        ResultActions resultActions = this.mockMvc.perform(get("/rest/players/count?race=HOBBIT&profession=EXPLORER&banned=true")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();
        int actual = Integer.parseInt(contentAsString);
        int expected = testsHelper.getPlayerInfosByBaned(true,
                testsHelper.getPlayerInfosByRace(Race.HOBBIT,
                        testsHelper.getPlayerInfosByProfession(Profession.EXPLORER,
                                testsHelper.getAllPlayers()))).size();

        assertSame("Wrong result during request GET rest/players/count with parameters race, profession and banned.", expected, actual);
    }

    //test5
    @Test
    public void getCountWithFiltersRaceProfessionMaxExperience() throws Exception {
        ResultActions resultActions = this.mockMvc.perform(get("/rest/players/count?race=ANIMAL&profession=WARRIOR&maxExperience=120000")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();
        int actual = Integer.parseInt(contentAsString);
        int expected = testsHelper.getPlayerInfosByMaxExperience(120000,
                testsHelper.getPlayerInfosByRace(Race.ANIMAL,
                        testsHelper.getPlayerInfosByProfession(Profession.WARRIOR,
                                testsHelper.getAllPlayers()))).size();

        assertSame("Wrong result during request GET /rest/players/count with parameters race, profession and maxExperience.", expected, actual);
    }

    //test6
    @Test
    public void getCountWithFiltersTitle() throws Exception {
        ResultActions resultActions = this.mockMvc.perform(get("/rest/players/count?title=le2")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();
        int actual = Integer.parseInt(contentAsString);
        int expected = testsHelper.getPlayerInfosByTitle("le2", testsHelper.getAllPlayers()).size();

        assertSame("Wrong result during request GET /rest/players/count с параметром title.", expected, actual);
    }

    //test7
    @Test
    public void getCountWithFiltersRaceProfessionBefore() throws Exception {
        //before 00:00 01.01.2008
        ResultActions resultActions = this.mockMvc.perform(get("/rest/players/count?race=HUMAN&profession=WARRIOR&before=1199138400000")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();
        int actual = Integer.parseInt(contentAsString);
        int expected = testsHelper.getPlayerInfosByBefore(1199138400000L,
                testsHelper.getPlayerInfosByRace(Race.HUMAN,
                        testsHelper.getPlayerInfosByProfession(Profession.WARRIOR,
                                testsHelper.getAllPlayers()))).size();

        assertSame("Wrong result during request GET /rest/players/count with parameters race, profession and before.", expected, actual);
    }

    //test8
    @Test
    public void getCountWithFiltersBanned() throws Exception {
        ResultActions resultActions = this.mockMvc.perform(get("/rest/players/count?banned=false")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();
        int actual = Integer.parseInt(contentAsString);
        int expected = testsHelper.getPlayerInfosByBaned(false, testsHelper.getAllPlayers()).size();

        assertSame("Wrong result during request GET /rest/players/count with parameters banned.", expected, actual);
    }
}
