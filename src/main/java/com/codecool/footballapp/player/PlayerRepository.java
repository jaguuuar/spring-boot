package com.codecool.footballapp.player;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PlayerRepository extends CrudRepository<Player, Integer> {

    Iterable<Player> findByIsArchived(boolean isArchive);
}
