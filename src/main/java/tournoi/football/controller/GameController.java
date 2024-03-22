package tournoi.football.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
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

import tournoi.football.entities.Arbitre;
import tournoi.football.entities.Equipe;
import tournoi.football.entities.Game;
import tournoi.football.entities.Joueur;
import tournoi.football.entities.Stade;
import tournoi.football.repositories.ArbitreRepository;
import tournoi.football.repositories.EquipeRepository;
import tournoi.football.repositories.GameRepository;
import tournoi.football.repositories.StadeRepository;



@RestController
@RequestMapping("tournoi")
public class GameController {

	@Autowired GameRepository gameRepository;
	@Autowired  StadeRepository  stadeRepository;
	@Autowired  EquipeRepository  equipeRepository;
	@Autowired  ArbitreRepository  arbitreRepository;

	@PostMapping("game/{idequipe1}/{idequipe2}/{idarbitre}/{idstade}")
	public Game addGame(@PathVariable ("idstade") Long idstade,@PathVariable ("idarbitre") Long idarbitre,@PathVariable ("idequipe1") Long idequipe1,@PathVariable ("idequipe2") Long idequipe2,@RequestBody Game game) {
	     Optional<Arbitre> arbitre=arbitreRepository.findById(idarbitre);
	     Optional<Stade> stade=stadeRepository.findById(idstade);
	    Optional<Equipe>  equipe1 = equipeRepository.findById(idequipe1);
	    Optional<Equipe> equipe2 = equipeRepository.findById(idequipe2);
	    game.setEquipe1(equipe1.get());
	    game.setEquipe2(equipe2.get());
	    game.setArbitre(arbitre.get());
	    game.setStade(stade.get());

	 
	    return gameRepository.save(game);
	}
	   @GetMapping("games")
	   private List<Game> getAllGames (@RequestBody Game game){
	   
		 return gameRepository.findAll();

	   }
	    @GetMapping("games/date/{date}")
	    public List<Game> getMatchesByDate(@PathVariable String date) {
	        LocalDate localDate = LocalDate.parse(date);
	        return gameRepository.findByDateGame(localDate);
	    }
	   
	    
	   @GetMapping("game/{idgame}")	
	   public Game deleteGame(@PathVariable Long idgame) {
	    	Game game=gameRepository.findById(idgame).get();
     	   gameRepository.deleteById(idgame); 
	   	   return game;
	   	   
	   }
	    @GetMapping("game/{id}/equipes")
	    public List<Equipe> getEquipesByMatchId(@PathVariable Long id) {
	        Optional<Game> Game = gameRepository.findById(id);
	        if (Game.isPresent()) {
	            Game game = Game.get();
	            return Arrays.asList(game.getEquipe1(), game.getEquipe2());
	        }
	        return null;
	    }
		   @DeleteMapping("game/{idgame}")	
		   public void deleteStade(@PathVariable Long idgame) {
		   	   gameRepository.deleteById(idgame); 
		   }	
	    @DeleteMapping("games/passed")
	    public void deletePassedMatches() {
	        LocalDate today = LocalDate.now();
	        List<Game> games = gameRepository.findAll();
	        for (Game game : games) {
	            if (game.getDateGame().isBefore(today)) {
	                gameRepository.delete(game);
	            }
	        }
	    } 
}
