package kodlama.io.LanguageLib.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlama.io.LanguageLib.business.abstracts.LanguageService;
import kodlama.io.LanguageLib.dataAccess.abstracts.LanguageRepository;
import kodlama.io.LanguageLib.entities.concretes.Language;

@Service
public class LanguageManager implements LanguageService {

	
	private LanguageRepository languageRepository;
			
	public LanguageManager(LanguageRepository _languageRepository) {		
		this.languageRepository = _languageRepository;
	}

	@Override
	public List<Language> GetAllLanguage() {

		return languageRepository.GetAllLanguage();
	}

	@Override
	public void UpdateLanguageName(Language language) throws Exception {
		
		if(languageRepository.IsIdAdded(language.getId()))
			languageRepository.UpdateLanguageName( language);		
		
		else {
			throw new Exception("No Language has this id");
		}
			
	}

	@Override
	public void DeleteLanguage(int id) {
		languageRepository.DeleteLanguage(id);	
	}

	@Override
	public void AddLanguage(Language language) throws Exception {
		if(languageRepository.IsNameAdded(language.getName()))
			throw new Exception("Language : "+language.getName() +" is Already exist");
		else if(languageRepository.IsIdAdded(language.getId()))
			throw new Exception("Id : "+language.getId() +" is Already exist");	
		
		else {
			languageRepository.AddLanguage(language);
		}					

	}

	@Override
	public Language GetById(int id) {
		return languageRepository.GetById(id);
	}

}
