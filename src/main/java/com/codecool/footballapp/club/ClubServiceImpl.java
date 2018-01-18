package com.codecool.footballapp.club;

import com.codecool.footballapp.exception_handle.custom_exception.NoSuchIdException;
import com.codecool.footballapp.logger_service.LoggerService;
import com.codecool.footballapp.player.Player;
import com.codecool.footballapp.player.PlayerServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class ClubServiceImpl implements  ClubService{

    private ClubRepository clubRepository;
    private PlayerServiceImpl playerService;
    private LoggerService loggerService;

    public ClubServiceImpl(ClubRepository clubRepository, PlayerServiceImpl playerService, LoggerService loggerService) {
        this.clubRepository = clubRepository;
        this.playerService = playerService;
        this.loggerService = loggerService;
    }

    @Override

    public Iterable<Club> findAllClubs(boolean isArchived) {
        return this.clubRepository.findByIsArchived(isArchived);
    }

    @Override
    public Club fidOneClub(Integer id) throws NoSuchIdException {
        if (this.clubRepository.findOne(id) == null) {
            this.loggerService.logError("Wrong id");
            throw  new NoSuchIdException();
        }
        if (this.clubRepository.findOne(id).isArchived()) {
            return null;
        }
        this.loggerService.logInfo("Object found");
        return this.clubRepository.findOne(id);
    }

    @Override
    public void createClub(Club club) {
        this.clubRepository.save(club);
    }

    @Override
    public void deleteClub(Integer id) {
        Club club = this.clubRepository.findOne(id);
        club.setIsArchived(true);
        Iterable<Player> players = this.playerService.findAllPlayers(false);
        for(Player player : players) {
            if(player.getClub().getId() == club.getId()) {
                this.playerService.deletePlayer(player.getId());
            }
        }
        this.clubRepository.save(club);

    }

    @Override
    public void update(Club club) {
        this.clubRepository.save(club);
    }

}
