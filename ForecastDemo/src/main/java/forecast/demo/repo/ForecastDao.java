package forecast.demo.repo;

import java.util.List;

import org.joda.time.DateTime;

import forecast.demo.City;

public interface ForecastDao {

	public void persist(DateTime time, List<City> citiesWithHottestWeather);
}
