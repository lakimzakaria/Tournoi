package tournoi.football.entities;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Data @Entity
public class Game {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     Long idGame;   
     LocalDate dateGame;
     LocalTime heureGame;
	 @ManyToOne
	 Stade stade;
	 @ManyToOne
	 Arbitre arbitre;
	 @ManyToOne
	 Equipe equipe1;
	 @ManyToOne
	  Equipe equipe2;
}
