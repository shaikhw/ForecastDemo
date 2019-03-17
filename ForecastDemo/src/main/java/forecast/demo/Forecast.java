package forecast.demo;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

import org.joda.time.DateTime;

public class Forecast {

	private List<City> cities;

	public Forecast(List<City> cities) {
		this.cities = cities;
	}

	public List<City> getCitiesWithHottestWeatherAtTime(DateTime time) {
		IntSummaryStatistics stats = getStatsForTime(time);
		return cities.stream().filter(c -> c.getWeather(time).getTempreture() == stats.getMax())
				.collect(Collectors.toList());
	}
	
	public List<City> getCitiesWithCoolestWeatherTimeAtTime(DateTime time) {
		IntSummaryStatistics stats = getStatsForTime(time);
		return cities.stream().filter(c -> c.getWeather(time).getTempreture() == stats.getMin())
				.collect(Collectors.toList());
	}

	private IntSummaryStatistics getStatsForTime(DateTime time) {
		return cities.stream().mapToInt(x -> x.getWeatherAtTime(time).getTempreture()).summaryStatistics();
	}
}
