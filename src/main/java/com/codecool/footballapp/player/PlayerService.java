package com.codecool.footballapp.player;

import com.codecool.footballapp.exception_handle.custom_exception.NoSuchIdException;

public interface PlayerService {

    Iterable<Player> findAllPlayers(boolean isArchived);

    Player fidOnePlayer(Integer id) throws NoSuchIdException;

    void createPlayer(Player player);

    void deletePlayer(Integer id);

    void update(Player player);

}
