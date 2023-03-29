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
	public void UpdateLanguageName(Language language) {
		languages.stream().filter(l-> l.getId()==language.getId()).forEach(l->l.setName(language.getName()));	
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


	@Override
	public boolean IsNameAdded(String name) {
	boolean result 	= languages.stream().filter(l-> l.getName().equals(name)).count()>0;
		return result;
	}


	@Override
	public boolean IsIdAdded(int id) {
		boolean result 	= languages.stream().filter(l-> l.getId()==id).count()>0;
		return result;
	}

	
}
