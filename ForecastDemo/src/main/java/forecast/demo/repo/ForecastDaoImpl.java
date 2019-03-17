package forecast.demo.repo;

import java.util.List;

import org.joda.time.DateTime;

import forecast.demo.City;

public class ForecastDaoImpl implements ForecastDao {

	
	@Override
	public void persist(DateTime time, List<City> citiesWithHottestWeather) {
		//TODO persist in DB 
	}

}
