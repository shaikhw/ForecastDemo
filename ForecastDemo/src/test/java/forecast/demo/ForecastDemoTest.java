package forecast.demo;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import forecast.demo.repo.ForecastDao;
import forecast.demo.repo.ForecastDaoImpl;
import forecast.demo.service.ForecastCityService;
import forecast.demo.service.ForecastCityServiceImpl;

public class ForecastDemoTest {

	private ForecastDao dao;
	private ForecastCityService service;

	@Before
	public void init() {
		dao = new ForecastDaoImpl();
		service = new ForecastCityServiceImpl(dao);
	}

	@Test
	public void testWeather() {
		DateTime tomorrowTenAm = new DateTime(2019, 03, 17, 10, 00, 00);
		DateTime tomorrowThreePm = new DateTime(2019, 03, 17, 15, 00, 00);
		DateTime tomorrowEightPm = new DateTime(2019, 03, 17, 20, 00, 00);

		List<City> cities = new ArrayList<>();

		City mumbai = new City("Mumbai");
		Weather mumWeatherAtTenAm = new Weather(25);
		mumbai.setWeatherAtTime(mumWeatherAtTenAm, tomorrowTenAm);

		Weather mumWeatherAtThreePm = new Weather(30);
		mumbai.setWeatherAtTime(mumWeatherAtThreePm, tomorrowThreePm);

		Weather mumWeatherAtEightPm = new Weather(27);
		mumbai.setWeatherAtTime(mumWeatherAtEightPm, tomorrowEightPm);

		City pune = new City("Pune");
		Weather puneWeatherAtTenAm = new Weather(15);
		pune.setWeatherAtTime(puneWeatherAtTenAm, tomorrowTenAm);

		Weather puneWeatherAtThreePm = new Weather(20);
		pune.setWeatherAtTime(puneWeatherAtThreePm, tomorrowThreePm);

		Weather puneWeatherAtEightPm = new Weather(18);
		pune.setWeatherAtTime(puneWeatherAtEightPm, tomorrowEightPm);

		City delhi = new City("Delhi");
		Weather delhiWeatherAtTenAm = new Weather(05);
		delhi.setWeatherAtTime(delhiWeatherAtTenAm, tomorrowTenAm);

		Weather delhiWeatherAtThreePm = new Weather(00);
		delhi.setWeatherAtTime(delhiWeatherAtThreePm, tomorrowThreePm);

		Weather delhiWeatherAtEightPm = new Weather(02);
		delhi.setWeatherAtTime(delhiWeatherAtEightPm, tomorrowEightPm);

		City bangalore = new City("Bangalore");
		Weather bangaloreWeatherAtTenAm = new Weather(23);
		bangalore.setWeatherAtTime(bangaloreWeatherAtTenAm, tomorrowTenAm);

		Weather bangaloreWeatherAtThreePm = new Weather(23);
		bangalore.setWeatherAtTime(bangaloreWeatherAtThreePm, tomorrowThreePm);

		Weather bangaloreWeatherAtEightPm = new Weather(23);
		bangalore.setWeatherAtTime(bangaloreWeatherAtEightPm, tomorrowEightPm);

		City kolkata = new City("Kolkata");
		Weather kolkataWeatherAtTenAm = new Weather(20);
		kolkata.setWeatherAtTime(kolkataWeatherAtTenAm, tomorrowTenAm);

		Weather kolkataWeatherAtThreePm = new Weather(20);
		kolkata.setWeatherAtTime(kolkataWeatherAtThreePm, tomorrowThreePm);

		Weather kolkataWeatherAtEightPm = new Weather(20);
		kolkata.setWeatherAtTime(kolkataWeatherAtEightPm, tomorrowEightPm);

		cities.add(delhi);
		cities.add(mumbai);
		cities.add(pune);
		cities.add(bangalore);
		cities.add(kolkata);
		
		List<City> citiesWithHottestWeatherAtTenAm = service.persistAndGetCitiesWithHottestWeatherAtTime(cities, tomorrowTenAm);
		citiesWithHottestWeatherAtTenAm.stream().forEach(System.out::println);

		List<City> citiesWithCoolestWeatherAtTenAm = service.persistAndGetCitiesWithCoolestWeatherAtTime(cities, tomorrowTenAm);
		citiesWithCoolestWeatherAtTenAm.stream().forEach(System.out::println);

		List<City> citiesWithHottestWeatherAtThreePm = service.persistAndGetCitiesWithHottestWeatherAtTime(cities, tomorrowThreePm);
		citiesWithHottestWeatherAtThreePm.stream().forEach(System.out::println);

		List<City> citiesWithCoolestWeatherAtThreePm = service.persistAndGetCitiesWithCoolestWeatherAtTime(cities, tomorrowThreePm);
		citiesWithCoolestWeatherAtThreePm.stream().forEach(System.out::println);

		List<City> citiesWithHottestWeatherAtEightPm = service.persistAndGetCitiesWithHottestWeatherAtTime(cities, tomorrowEightPm);
		citiesWithHottestWeatherAtEightPm.stream().forEach(System.out::println);

		List<City> citiesWithCoolestWeatherAtEightPm = service.persistAndGetCitiesWithCoolestWeatherAtTime(cities, tomorrowEightPm);
		citiesWithCoolestWeatherAtEightPm.stream().forEach(System.out::println);

	}
}
