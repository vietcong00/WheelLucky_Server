package project3.backend.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import project3.backend.model.Player;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player,Integer> {
    Player findByIdPlayer(int idPlayer);
    Player findByToken(String token);
    Player findByUsernamePlayer(String usernamePlayer);
    List<Player> findAll();
}
