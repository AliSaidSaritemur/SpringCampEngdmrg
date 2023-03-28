package kodlama.io.LanguageLib.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import kodlama.io.LanguageLib.dataAccess.abstracts.LanguageRepository;
import kodlama.io.LanguageLib.entities.concretes.Language;

@Repository
public class InMemoryLanguageRepository implements LanguageRepository {

	List<Language> languages;
	
	
	public InMemoryLanguageRepository(){
		this.languages = new ArrayList<Language>();
		this.languages.add(new Language(1, "C#"));
		this.languages.add(new Language(4, "Java"));
		this.languages.add(new Language(3, "C++"));
		this.languages.add(new Language(2, "C"));
	}
		
	
	@Override
	public List<Language> GetAllLanguage() {		
		return languages;
	}

	@Override
	public void UpdateLanguageName(Language language,Language updatedLanguage) {
		languages.stream().filter(l-> l.equals(language)).forEach(l->l=updatedLanguage);	
	}

	@Override
	public void DeleteLanguage(int id) {
		languages.removeIf(l-> l.getId()==id);
	}

	@Override
	public void AddLanguage(Language language) {
		languages.add(language);
		
	}

	@Override
	public Language GetById(int id) {
	
		Language resultLAnguage =languages.stream().filter(l-> l.getId()==id).findFirst().orElse(null);
		return 	resultLAnguage;
	}

	
}
