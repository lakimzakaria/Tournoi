package tournoi.football.controller;

import java.lang.StackWalker.Option;
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
import tournoi.football.repositories.EquipeRepository;
import tournoi.football.repositories.JoueurRepository;
@RestController
@RequestMapping("tournoi")
public class JoueurController {
	@Autowired  JoueurRepository joueurRepository;
	@Autowired  EquipeRepository  equipeRepository;
   @PostMapping ("equipe/{idequipe}/joueurs")
	public Joueur addJoueurByIdEquipe(@PathVariable("idequipe") Long idequipe, @RequestBody Joueur joueur) {
	    Optional<Equipe> equipe = equipeRepository.findById(idequipe);
	    if (equipe.isPresent()) {
	        joueur.setEquipe(equipe.get());
	        return joueurRepository.save(joueur);
	    }
	    return null;
	}
   @GetMapping("joueurs")
   private List<Joueur> getJoueurs (@RequestBody Joueur joueur){
   
	 return joueurRepository.findAll();

   }

   @GetMapping("joueurs/equipe/{nomEquipe}")
  	public List<Joueur> getJoueursByEquipe(@PathVariable("nomEquipe") String nomEquipe) {
	  List<Joueur> joueur= joueurRepository.findByEquipeNomEquipe(nomEquipe);

  	    return joueur;
  	}
   @GetMapping("equipe/{nomEquipe}/joueur/{poste}")
  	public List<Joueur> getJoueursByPost(@PathVariable("nomEquipe") String nomEquipe,@PathVariable("poste") String poste) {
	   List<Joueur> joueurs= joueurRepository.findByEquipeNomEquipeAndPoste(nomEquipe,poste);
 
         return joueurs;
  	}
   @DeleteMapping("joueur/{idjoueur}")	
   public void deleteJoueur(@PathVariable Long idjoueur) {
   	   joueurRepository.deleteById(idjoueur); 
   }
   
	

}
