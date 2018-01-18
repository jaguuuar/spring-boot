package com.codecool.footballapp.player;

import com.codecool.footballapp.club.Club;
import com.codecool.footballapp.exception_handle.custom_exception.NoSuchIdException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(path = "/players")
public class PlayerController {

    private PlayerServiceImpl playerService;

    @Autowired
    public PlayerController(PlayerServiceImpl playerService) {
        this.playerService = playerService;
    }

    @GetMapping(path = "")
    public Iterable<Player> index(boolean isArchived) {
        return this.playerService.findAllPlayers(isArchived);
    }

    @GetMapping(path = "/{id}")
    public Player show(@PathVariable Integer id) throws NoSuchIdException {
        return this.playerService.fidOnePlayer(id);
    }

    @PostMapping(path = "")
    public Player create(@RequestBody Player player) {
        this.playerService.createPlayer(player);
        return player;
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Integer id) {
        this.playerService.deletePlayer(id);
    }

    @PutMapping(path = "")
    public Player update(@RequestBody Player player) {
        this.playerService.update(player);
        return player;
    }

}
