package com.dar3.game.service;

import com.dar3.game.controller.PlayerOrder;
import com.dar3.game.entity.Player;
import com.dar3.game.entity.Profession;
import com.dar3.game.entity.Race;

import java.util.List;

// Business logic (for POJO)
public interface PlayerService {
    //  Get whole sorted list of Players according to received filters
    List<Player> getSortAllPlayers(String name, String title, Race race, Profession profession, Long after,
                                   Long before, Boolean banned, Integer minExperience, Integer maxExperience,
                                   Integer minLevel, Integer maxLevel);

    // Get list with Pagination.
    List<Player> getPlayersForPage(List<Player> sortAllShips, PlayerOrder order,
                                   Integer pageNumber, Integer pageSize);

    //  Create new Player
    Player createNewPlayer(Player newPlayer);

    //  Edit Player's fields
    Player editPlayer(Player newCharacteristics, Long id);

    //  Edit Player by ID;
    void deletePlayerById(Long id);

    //  Get Player by ID;
    Player getPlayerById(Long id);
}
