package tournoi.football.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tournoi.football.entities.Arbitre;

@Repository
public interface ArbitreRepository  extends JpaRepository<Arbitre, Long>{

}
