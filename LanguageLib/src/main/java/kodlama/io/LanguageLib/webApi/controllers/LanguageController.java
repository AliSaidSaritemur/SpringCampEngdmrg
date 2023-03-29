package kodlama.io.LanguageLib.webApi.controllers;

import java.util.List;

import org.springframework.aot.generate.InMemoryGeneratedFiles;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.session.InMemoryWebSessionStore;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import kodlama.io.LanguageLib.business.concretes.LanguageManager;
import kodlama.io.LanguageLib.dataAccess.abstracts.LanguageRepository;
import kodlama.io.LanguageLib.dataAccess.concretes.InMemoryLanguageRepository;
import kodlama.io.LanguageLib.entities.concretes.Language;

@RestController
@RequestMapping("api/languages")
public class LanguageController {

	private LanguageManager languageManager;

	public LanguageController(LanguageManager languageManager) {
		this.languageManager = new LanguageManager(new InMemoryLanguageRepository());
	}

	@GetMapping("/getall")
	 List<Language> GetAllLanguage(){
		 return languageManager.GetAllLanguage();
	 }
	@PutMapping("/update")
	 void UpdateLanguageName(@RequestBody Language language) throws Exception {
		 languageManager.UpdateLanguageName(language);
	 
	 };
	 @DeleteMapping("/{id}")
	 void DeleteLanguage(@PathVariable int id) {
		  languageManager.DeleteLanguage(id);
	 };
	 @PostMapping("/add")
	 void AddLanguage(Language language) throws Exception {
	 
		 languageManager.AddLanguage(language);
	 };
	 @GetMapping("/{id}")
	 Language GetById(@PathVariable int id) {
		 
		 return languageManager.GetById(id);
	 };
	
	
	
	
}
