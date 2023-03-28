package kodlama.io.rentACar.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import kodlama.io.rentACar.dataAccess.abstracts.BrandRepository;
import kodlama.io.rentACar.entities.concretes.Brand;

@Repository
public class InMemoryBrandRepository implements BrandRepository {

	List<Brand> brands;
	@Override
	
	 
	
	public List<Brand> getAll() {
	 
		return brands;
	}
	public InMemoryBrandRepository() {
		this.brands = new ArrayList<Brand>();
		brands.add(new Brand(1,"BMW"));
		brands.add(new Brand(2,"Ford"));
		brands.add(new Brand(3,"Fiar"));
		brands.add(new Brand(4,"Kartal"));
		brands.add(new Brand(5,"Tofas"));
	}

}
