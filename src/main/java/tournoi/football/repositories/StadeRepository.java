package tournoi.football.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tournoi.football.entities.Game;
import tournoi.football.entities.Stade;

@Repository

public interface StadeRepository extends JpaRepository<Stade, Long> {
  
	public Stade findByGame(Game game);
}
