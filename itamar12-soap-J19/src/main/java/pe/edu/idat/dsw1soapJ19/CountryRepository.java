package pe.edu.idat.itamar12soapJ19;

import io.spring.guides.gs_producing_web_service.Day;
import jakarta.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class CountryRepository {
    
    private static final Map<String, Day> countries = new HashMap<>();

	@PostConstruct
	public void initData() {
		var lunes = new Day();
		lunes.setName("Monday");
		countries.put("lunes", lunes);
		var martes = new Day();
		martes.setName("Tuesday");
		countries.put("martes", martes);
		var miercoles = new Day();
		miercoles.setName("Wednesday");
		countries.put("miercoles", miercoles);

		var jueves = new Day();
		jueves.setName("Thursday");
		countries.put("jueves", jueves);

		var viernes = new Day();
		viernes.setName("Friday");
		countries.put("viernes", viernes);

		var sabado = new Day();
		sabado.setName("Saturday");
		countries.put("sabado", sabado);

		var domingo = new Day();
		domingo.setName("Sunday");
		countries.put("domingo", domingo);
	}


	public Day findCountry(String name) {
		Assert.notNull(name, "The country's name must not be null");
		//System.out.println(countries.get("Monday").getName());
		return countries.get(name);
	}
}
