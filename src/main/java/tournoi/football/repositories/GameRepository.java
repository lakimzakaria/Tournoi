package tournoi.football.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tournoi.football.entities.Equipe;
import tournoi.football.entities.Game;


@Repository

public interface GameRepository extends JpaRepository<Game, Long> {

	public List<Game> findByDateGame(LocalDate dateGame);
	
	
	
	
}
