package com.codecool.footballapp.player;

import com.codecool.footballapp.club.Club;
import com.codecool.footballapp.club.ClubServiceImpl;
import com.codecool.footballapp.exception_handle.custom_exception.NoSuchIdException;
import com.codecool.footballapp.logger_service.LoggerService;
import org.springframework.stereotype.Service;

@Service
public class PlayerServiceImpl implements PlayerService {

    private PlayerRepository playerRepository;
    private LoggerService loggerService;

    public PlayerServiceImpl(PlayerRepository playerRepository, LoggerService loggerService) {
        this.playerRepository = playerRepository;
        this.loggerService = loggerService;
    }

    @Override
    public Iterable<Player> findAllPlayers(boolean isArchived) {
        return this.playerRepository.findByIsArchived(isArchived);
    }

    @Override
    public Player fidOnePlayer(Integer id) {
        if (this.playerRepository.findOne(id).isArchived()) {
            this.loggerService.logError("Wrong id");
            return null;
        }
        this.loggerService.logInfo("Object found");
        return this.playerRepository.findOne(id);
        }

    @Override
    public void createPlayer(Player player) {
        this.playerRepository.save(player);
        this.loggerService.logInfo("Player created");
    }

    @Override
    public void deletePlayer(Integer id) {
        Player player = this.playerRepository.findOne(id);
        player.setArchived(true);
        this.playerRepository.save(player);

    }


    @Override
    public void update(Player player) {
        this.playerRepository.save(player);
    }
}
