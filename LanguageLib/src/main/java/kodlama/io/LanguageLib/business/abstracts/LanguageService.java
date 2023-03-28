package kodlama.io.LanguageLib.business.abstracts;

import java.util.List;

import kodlama.io.LanguageLib.entities.concretes.Language;

public interface LanguageService {

	 List<Language> GetAllLanguage();
	 void UpdateLanguageName(Language language,Language updatedLanguage);
	 void DeleteLanguage(int id);
	 void AddLanguage(Language language);
	 Language GetById(int id);
	
}
