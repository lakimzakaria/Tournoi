package tournoi.football.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tournoi.football.entities.Equipe;
import tournoi.football.entities.Game;
import tournoi.football.entities.Joueur;
import tournoi.football.entities.Stade;
import tournoi.football.repositories.GameRepository;
import tournoi.football.repositories.StadeRepository;

@RestController
@RequestMapping("tournoi")
public class StadeController {
	   @Autowired  StadeRepository  stadeRepository;
	   @Autowired GameRepository gameRepository;
	   @PostMapping("stade")
	   public Stade addStade(@RequestBody Stade stade) {
	       
	       
	       return stadeRepository.save(stade) ;
	   }
	   @GetMapping("stades")
	   private List<Stade> getAllStades (@RequestBody Stade stade){
	   
		 return stadeRepository.findAll();

	   }
	   @GetMapping("stade/game/{idgame}")
	  	public Stade getStadeByIdGame(@PathVariable("idgame") Long idgame) {
	  	    Optional<Game> game =gameRepository.findById(idgame);
	  	    if (game.isPresent()) {
	  	        return stadeRepository.findByGame(game.get());
	  	    }
	  	    return null;
	  	}
	   @DeleteMapping("stade/{idstade}")	
	   public void deleteStade(@PathVariable Long idstade) {
	   	   stadeRepository.deleteById(idstade); 
	   }	
}
