package forecast.demo.service;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import org.joda.time.DateTime;

import forecast.demo.City;
import forecast.demo.Forecast;
import forecast.demo.repo.ForecastDao;

public class ForecastCityServiceImpl implements ForecastCityService {
	private ForecastDao dao;

	public ForecastCityServiceImpl(ForecastDao dao) {
		this.dao = dao;
	}

	@Override
	public List<City> persistAndGetCitiesWithHottestWeatherAtTime(List<City> cities, DateTime time)
			throws SQLException {
		if (cities == null || cities.size() == 0) {
			return Collections.EMPTY_LIST;
		}
		final Forecast forecast = new Forecast(cities);
		final List<City> citiesWithHottestWeather = forecast.getCitiesWithHottestWeatherAtTime(time);
		dao.persist(time, citiesWithHottestWeather);
		return citiesWithHottestWeather;
	}

	@Override
	public List<City> persistAndGetCitiesWithCoolestWeatherAtTime(List<City> cities, DateTime time)
			throws SQLException {
		if (cities == null || cities.size() == 0) {
			return Collections.EMPTY_LIST;
		}
		final Forecast forecast = new Forecast(cities);
		final List<City> citiesWithHottestWeather = forecast.getCitiesWithCoolestWeatherTimeAtTime(time);
		dao.persist(time, citiesWithHottestWeather);
		return citiesWithHottestWeather;
	}
}

