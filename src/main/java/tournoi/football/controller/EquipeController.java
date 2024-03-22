package tournoi.football.controller;

import java.util.List;

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
import tournoi.football.repositories.EquipeRepository;
import tournoi.football.repositories.GameRepository;
@RestController
@RequestMapping("tournoi")
public class EquipeController {
	   @Autowired  EquipeRepository  equipeRepository;
	   
	   @PostMapping("equipe")
	   public Equipe addEquipe(@RequestBody Equipe equipe) {
	       
	       
	       return equipeRepository.save(equipe) ;
	   }
	   @GetMapping("equipes")
	   private List<Equipe> getAllEquipes (@RequestBody Equipe equipe){
	   
		 return equipeRepository.findAll();

	   }
	   @GetMapping("equipes/{pays}")
	   private List<Equipe> getByPays (@PathVariable String pays){
	   
		 return equipeRepository.findByPays(pays);
	   }
	   
	   
	   @DeleteMapping("equipe")	
	   public void deleteEquipe(@RequestBody Equipe equipe) {
	   	   equipeRepository.delete(equipe); 
	   }
		
}
