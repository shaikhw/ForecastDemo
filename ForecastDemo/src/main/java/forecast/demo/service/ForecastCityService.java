package forecast.demo.service;

import java.sql.SQLException;
import java.util.List;

import org.joda.time.DateTime;

import forecast.demo.City;

public interface ForecastCityService {
	public List<City> persistAndGetCitiesWithHottestWeatherAtTime(List<City> cities, DateTime time) throws SQLException;
	public List<City> persistAndGetCitiesWithCoolestWeatherAtTime(List<City> cities, DateTime time) throws SQLException;

}

