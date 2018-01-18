package com.codecool.footballapp.club;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClubRepository extends CrudRepository <Club, Integer> {

    Iterable<Club> findByIsArchived(boolean isArchive);



    
}
