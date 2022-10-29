package kodlama.io.Kodlama.io.Devs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.Kodlama.io.Devs.business.abstracts.IProgrammingLanguageService;
import kodlama.io.Kodlama.io.Devs.dataAccess.abstracts.IProgrammingLanguageRepository;
import kodlama.io.Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

@Service
public class ProgrammingLanguageManager implements IProgrammingLanguageService {

	private IProgrammingLanguageRepository _programmingLanguageRepository;

	@Autowired
	public ProgrammingLanguageManager(IProgrammingLanguageRepository programmingLanguageRepository) {
		_programmingLanguageRepository = programmingLanguageRepository;
	}

	public List<ProgrammingLanguage> getAll() {
		var result = _programmingLanguageRepository.getAll();

		return result;
	}

	public ProgrammingLanguage getById(int id) {
		var result = _programmingLanguageRepository.getById(id);

		return result;
	}

	public void add(ProgrammingLanguage programmingLanguage) {

		if (programmingLanguage.getName() == null || programmingLanguage.getName().isBlank()) {
			System.out.println("Programlama dili ismi boş bırakılamaz.");
		} else {
			var programmingLanguages = _programmingLanguageRepository.getAll();

			for (ProgrammingLanguage language : programmingLanguages) {

				if (language.getName().equals(programmingLanguage.getName())) {
					System.out.println("Aynı isimde bir kayıt mevcut");
					return;
				}
			}
		}

		_programmingLanguageRepository.add(programmingLanguage);
	}

	public void update(ProgrammingLanguage programmingLanguage) {
		if (programmingLanguage.getName() == "" || programmingLanguage.getName() == null) {
			System.out.println("Programlama dili ismi boş bırakılamaz.");
			return;
		}

		_programmingLanguageRepository.update(programmingLanguage);
	}

	public void delete(ProgrammingLanguage programmingLanguage) {
		_programmingLanguageRepository.delete(programmingLanguage);
	}

}
