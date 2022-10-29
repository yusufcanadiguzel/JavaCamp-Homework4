package kodlama.io.Kodlama.io.Devs.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import kodlama.io.Kodlama.io.Devs.dataAccess.abstracts.IProgrammingLanguageRepository;
import kodlama.io.Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

@Repository
public class InMemoryProgrammingLanguageRepository implements IProgrammingLanguageRepository {
	private List<ProgrammingLanguage> _programmingLanguages;

	public InMemoryProgrammingLanguageRepository() {
		_programmingLanguages = new ArrayList<ProgrammingLanguage>();
		_programmingLanguages.add(new ProgrammingLanguage(1, "C#", "Çok amaçlı programlama dili."));
		_programmingLanguages.add(new ProgrammingLanguage(2, "Java", "Çok amaçlı programlama dili."));
		_programmingLanguages.add(new ProgrammingLanguage(3, "Kotlin", "Android odaklı programlama dili."));
		_programmingLanguages.add(new ProgrammingLanguage(4, "Swift", "IOS ve MACOS odaklı programlama dili."));
	}

	public List<ProgrammingLanguage> getAll() {
		var result = _programmingLanguages;

		return result;
	}

	public ProgrammingLanguage getById(int id) {
		for (ProgrammingLanguage programmingLanguage : _programmingLanguages) {
			if (programmingLanguage.getId() == id) {
				return programmingLanguage;
			}
		}

		System.out.println("İstenilen id numaralı programlama dili bulunamadı.");
		return null;
	}

	public void add(ProgrammingLanguage programmingLanguage) {
		_programmingLanguages.add(programmingLanguage);
	}

	public void update(ProgrammingLanguage programmingLanguage) {
		var language = getById(programmingLanguage.getId());
		
		language.setName(programmingLanguage.getName());
		language.setDescription(programmingLanguage.getDescription());
		
		System.out.println("Progralama dili başarıyla güncellendi.");
	}

	public void delete(ProgrammingLanguage programmingLanguage) {
		var language = getById(programmingLanguage.getId());
		
		_programmingLanguages.remove(language);
		
		System.out.println("Programlama dili başarıyla silindi.");
	}
}
