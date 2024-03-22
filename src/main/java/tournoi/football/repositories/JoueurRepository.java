package tournoi.football.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tournoi.football.entities.Equipe;
import tournoi.football.entities.Joueur;

@Repository
public interface JoueurRepository extends JpaRepository<Joueur, Long> {
    
	public List<Joueur> findByEquipeNomEquipe( String nomEquipe);
	public List<Joueur> findByEquipeNomEquipeAndPoste(String nomEquipe,String poste);
}
