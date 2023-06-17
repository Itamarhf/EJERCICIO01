package pe.edu.idat.itamar12soapJ19;

import io.spring.guides.gs_producing_web_service.GetDayReq;
import io.spring.guides.gs_producing_web_service.GetDayRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class CountryEndpoint {
	private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

	private CountryRepository countryRepository;

	@Autowired
	public CountryEndpoint(CountryRepository countryRepository) {
		this.countryRepository = countryRepository;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getDayReq")
	@ResponsePayload
	public GetDayRes getCountry(@RequestPayload GetDayReq request) {
		var response = new GetDayRes();
		response.setTranslation(countryRepository.findCountry(request.getName()));
		//System.out.println(response.getTranslation());
		return response;
	}
}
