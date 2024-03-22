package tournoi.football.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Data @Entity
public class Equipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	Long idEquipe;
	String nomEquipe;
	String pays;
	@OneToMany (mappedBy = "equipe")
	@JsonIgnore
	List<Joueur> joueur;
    @OneToMany(mappedBy = "equipe1")
    @JsonIgnore
     List<Game> gamesAsEquipe1;
    @OneToMany(mappedBy = "equipe2")
    @JsonIgnore
     List<Game> gamesAsEquipe2;
     
	
	

}
