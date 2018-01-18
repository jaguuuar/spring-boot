package com.codecool.footballapp.club;


import com.codecool.footballapp.exception_handle.custom_exception.NoSuchIdException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/clubs")
public class ClubController {

    private ClubService clubService;

    @Autowired
    public ClubController(ClubService clubService) {
        this.clubService = clubService;
    }

    @GetMapping(path = "")
    public Iterable<Club> index(boolean isArchived) {
        return this.clubService.findAllClubs(isArchived);
    }

    @GetMapping(path = "/{id}")
    public Club show(@PathVariable Integer id) throws NoSuchIdException {
        if (this.clubService.fidOneClub(id) == null) {
            throw  new NoSuchIdException();
        }
        if (this.clubService.fidOneClub(id).isArchived()) {
            return null;
        }
        return this.clubService.fidOneClub(id);
    }

    @PostMapping(path = "")
    public Club create(@RequestBody Club club) {
        this.clubService.createClub(club);
        return club;
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Integer id) {
        this.clubService.deleteClub(id);
    }

    @PutMapping(path = "")
    public Club update(@RequestBody Club club) {
        this.clubService.update(club);
        return club;
    }

}
