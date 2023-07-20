package com.dar3.game.repository;

import com.dar3.game.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

//We extend JpaRepository from Spring Data for working with Databases
public interface PlayerRepository extends JpaRepository<Player, Long> {
// We use only standard methods
}
