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
public class Arbitre {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long idArbitre;
	String nom;
	String Nationalite;
	@OneToMany (mappedBy = "arbitre")
	@JsonIgnore
	List<Game> game;
	
	

	
	

}
