package tournoi.football.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import tournoi.football.entities.Arbitre;
import tournoi.football.repositories.ArbitreRepository;

@RestController
@RequestMapping("tournoi")
public class ArbitreController {
	   @Autowired  ArbitreRepository  arbitreRepository;
	   @PostMapping("arbitre")
	   public Arbitre addArbitre(@RequestBody Arbitre arbitre) {
	       
	       
	       return arbitreRepository.save(arbitre) ;
	   }
	   @GetMapping("arbitres")
	   private List<Arbitre> getAllArbitres (@RequestBody Arbitre arbitre){
	   
		 return arbitreRepository.findAll();

	   }
	   @DeleteMapping("arbitre")	
	   public void deleteArbitre(@RequestBody Arbitre arbitre) {
	   	   arbitreRepository.delete(arbitre); 
	   }	
}
