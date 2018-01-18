package com.codecool.footballapp.club;

import com.codecool.footballapp.exception_handle.custom_exception.NoSuchIdException;
import org.springframework.stereotype.Service;

@Service
public interface ClubService {

    Iterable<Club> findAllClubs(boolean isArchived);

    Club fidOneClub(Integer id) throws NoSuchIdException;

    void createClub(Club club);

    void deleteClub(Integer id);

    void update(Club club);


}
