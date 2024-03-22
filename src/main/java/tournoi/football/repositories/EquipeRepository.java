package tournoi.football.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import tournoi.football.entities.Equipe;
@Repository
public interface EquipeRepository extends  JpaRepository<Equipe, Long>{
	
	public List<Equipe> findByPays(String pays);
	public Optional<Equipe> findByNomEquipe(String nomEquipe);

}
