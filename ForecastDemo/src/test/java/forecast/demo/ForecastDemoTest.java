package forecast.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
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
	public void init() throws SQLException {
		dao = new ForecastDaoImpl();
		service = new ForecastCityServiceImpl(dao);
	}

	@Test
	public void testWeatherForcastForTommorowAtTenAmForNoCity() throws SQLException {
		DateTime tomorrowTenAm = new DateTime(2019, 03, 17, 10, 00, 00);

		List<City> citiesWithHottestWeatherAtTenAm = service.persistAndGetCitiesWithHottestWeatherAtTime(null,
				tomorrowTenAm);
		assertEquals(citiesWithHottestWeatherAtTenAm, Collections.EMPTY_LIST);
	}

	@Test
	public void testWeatherForcastForTommorowAtTenAm() throws SQLException {
		DateTime tomorrowTenAm = new DateTime(2019, 03, 17, 10, 00, 00);

		List<City> cities = new ArrayList<>();

		City mumbai = new City("Mumbai");
		Weather mumWeatherAtTenAm = new Weather(25);
		mumbai.setWeatherAtTime(mumWeatherAtTenAm, tomorrowTenAm);

		City pune = new City("Pune");
		Weather puneWeatherAtTenAm = new Weather(15);
		pune.setWeatherAtTime(puneWeatherAtTenAm, tomorrowTenAm);

		City delhi = new City("Delhi");
		Weather delhiWeatherAtTenAm = new Weather(05);
		delhi.setWeatherAtTime(delhiWeatherAtTenAm, tomorrowTenAm);

		City bangalore = new City("Bangalore");
		Weather bangaloreWeatherAtTenAm = new Weather(23);
		bangalore.setWeatherAtTime(bangaloreWeatherAtTenAm, tomorrowTenAm);

		City kolkata = new City("Kolkata");
		Weather kolkataWeatherAtTenAm = new Weather(20);
		kolkata.setWeatherAtTime(kolkataWeatherAtTenAm, tomorrowTenAm);

		cities.add(delhi);
		cities.add(mumbai);
		cities.add(pune);
		cities.add(bangalore);
		cities.add(kolkata);
		List<City> citiesWithHottestWeatherAtTenAm = service.persistAndGetCitiesWithHottestWeatherAtTime(cities,
				tomorrowTenAm);
		assertNotNull(citiesWithHottestWeatherAtTenAm);
		assertEquals(citiesWithHottestWeatherAtTenAm.size(), 1);

		citiesWithHottestWeatherAtTenAm.stream().forEach(System.out::println);

		List<City> citiesWithCoolestWeatherAtTenAm = service.persistAndGetCitiesWithCoolestWeatherAtTime(cities,
				tomorrowTenAm);
		assertNotNull(citiesWithCoolestWeatherAtTenAm);
		assertEquals(citiesWithCoolestWeatherAtTenAm.size(), 1);

		citiesWithCoolestWeatherAtTenAm.stream().forEach(System.out::println);

	}

	@Test
	public void testWeatherForcastForTommorowAtThreePm() throws SQLException {
		DateTime tomorrowThreePm = new DateTime(2019, 03, 17, 15, 00, 00);

		List<City> cities = new ArrayList<>();

		City mumbai = new City("Mumbai");

		Weather mumWeatherAtThreePm = new Weather(30);
		mumbai.setWeatherAtTime(mumWeatherAtThreePm, tomorrowThreePm);

		City pune = new City("Pune");
		Weather puneWeatherAtThreePm = new Weather(20);
		pune.setWeatherAtTime(puneWeatherAtThreePm, tomorrowThreePm);

		City delhi = new City("Delhi");
		Weather delhiWeatherAtThreePm = new Weather(00);
		delhi.setWeatherAtTime(delhiWeatherAtThreePm, tomorrowThreePm);

		City bangalore = new City("Bangalore");
		Weather bangaloreWeatherAtThreePm = new Weather(23);
		bangalore.setWeatherAtTime(bangaloreWeatherAtThreePm, tomorrowThreePm);

		City kolkata = new City("Kolkata");
		Weather kolkataWeatherAtThreePm = new Weather(20);
		kolkata.setWeatherAtTime(kolkataWeatherAtThreePm, tomorrowThreePm);

		cities.add(delhi);
		cities.add(mumbai);
		cities.add(pune);
		cities.add(bangalore);
		cities.add(kolkata);

		List<City> citiesWithHottestWeatherAtThreePm = service.persistAndGetCitiesWithHottestWeatherAtTime(cities,
				tomorrowThreePm);
		assertNotNull(citiesWithHottestWeatherAtThreePm);
		assertEquals(citiesWithHottestWeatherAtThreePm.size(), 1);
		citiesWithHottestWeatherAtThreePm.stream().forEach(System.out::println);

		List<City> citiesWithCoolestWeatherAtThreePm = service.persistAndGetCitiesWithCoolestWeatherAtTime(cities,
				tomorrowThreePm);
		assertNotNull(citiesWithCoolestWeatherAtThreePm);
		assertEquals(citiesWithCoolestWeatherAtThreePm.size(), 1);
		citiesWithCoolestWeatherAtThreePm.stream().forEach(System.out::println);

	}

	@Test
	public void testWeatherForcastForTommorowAtEightPm() throws SQLException {
		DateTime tomorrowEightPm = new DateTime(2019, 03, 17, 20, 00, 00);

		List<City> cities = new ArrayList<>();

		City mumbai = new City("Mumbai");
		Weather mumWeatherAtEightPm = new Weather(27);
		mumbai.setWeatherAtTime(mumWeatherAtEightPm, tomorrowEightPm);

		City pune = new City("Pune");
		Weather puneWeatherAtEightPm = new Weather(18);
		pune.setWeatherAtTime(puneWeatherAtEightPm, tomorrowEightPm);

		City delhi = new City("Delhi");
		Weather delhiWeatherAtEightPm = new Weather(02);
		delhi.setWeatherAtTime(delhiWeatherAtEightPm, tomorrowEightPm);

		City bangalore = new City("Bangalore");
		Weather bangaloreWeatherAtEightPm = new Weather(23);
		bangalore.setWeatherAtTime(bangaloreWeatherAtEightPm, tomorrowEightPm);

		City kolkata = new City("Kolkata");
		Weather kolkataWeatherAtEightPm = new Weather(20);
		kolkata.setWeatherAtTime(kolkataWeatherAtEightPm, tomorrowEightPm);

		cities.add(delhi);
		cities.add(mumbai);
		cities.add(pune);
		cities.add(bangalore);
		cities.add(kolkata);

		List<City> citiesWithHottestWeatherAtEightPm = service.persistAndGetCitiesWithHottestWeatherAtTime(cities,
				tomorrowEightPm);
		assertNotNull(citiesWithHottestWeatherAtEightPm);
		assertEquals(citiesWithHottestWeatherAtEightPm.size(), 1);

		citiesWithHottestWeatherAtEightPm.stream().forEach(System.out::println);

		List<City> citiesWithCoolestWeatherAtEightPm = service.persistAndGetCitiesWithCoolestWeatherAtTime(cities,
				tomorrowEightPm);
		assertNotNull(citiesWithCoolestWeatherAtEightPm);
		assertEquals(citiesWithCoolestWeatherAtEightPm.size(), 1);
		citiesWithCoolestWeatherAtEightPm.stream().forEach(System.out::println);

	}

}


