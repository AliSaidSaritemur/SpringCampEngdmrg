package kodlama.io.LanguageLib.business.abstracts;

import java.util.List;

import kodlama.io.LanguageLib.entities.concretes.Language;

public interface LanguageService {

	 List<Language> GetAllLanguage();
	 void UpdateLanguageName(Language language) throws Exception;
	 void DeleteLanguage(int id);
	 void AddLanguage(Language language) throws Exception;
	 Language GetById(int id);
	
}
