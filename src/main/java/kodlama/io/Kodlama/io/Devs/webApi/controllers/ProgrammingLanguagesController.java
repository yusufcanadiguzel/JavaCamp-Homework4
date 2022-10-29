package kodlama.io.Kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.Kodlama.io.Devs.business.abstracts.IProgrammingLanguageService;
import kodlama.io.Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

@RestController
@RequestMapping("/api/programminglanguages")
public class ProgrammingLanguagesController {
	private IProgrammingLanguageService _programmingLanguageService;
	
	@Autowired
	public ProgrammingLanguagesController(IProgrammingLanguageService programmingLanguageService) {
		_programmingLanguageService = programmingLanguageService;
	}
	
	@GetMapping("/getall")
	public List<ProgrammingLanguage> getAll(){
		var result = _programmingLanguageService.getAll();
		
		return result;
	}
	
	@GetMapping("/getbyid")
	public ProgrammingLanguage getById(int id) {
		var result = _programmingLanguageService.getById(id);
		
		return result;
	}
	
	@GetMapping("/add")
	public void add(ProgrammingLanguage programmingLanguage) {
		_programmingLanguageService.add(programmingLanguage);
	}
	
	@GetMapping("/update")
	public void update(ProgrammingLanguage programmingLanguage) {
		_programmingLanguageService.update(programmingLanguage);
	}
	
	@GetMapping("/delete")
	public void delete(ProgrammingLanguage programmingLanguage) {
		_programmingLanguageService.delete(programmingLanguage);
	}
}
