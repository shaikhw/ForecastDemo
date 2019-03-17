package forecast.demo;

import java.util.HashMap;
import java.util.Map;

import org.joda.time.DateTime;

public class City {

	private String name;
	private Map<DateTime, Weather> weatherMap = new HashMap<>();
	private DateTime time;

	public City(String name) {
		this.name = name;
	}

	public City(String name, DateTime time, Weather weather) {
		this.name = name;
		this.time = time;
		weatherMap.put(time, weather);
	}

	public void setWeatherAtTime(Weather weather, DateTime time) {
		weatherMap.put(time, weather);
	}

	public Weather getWeatherAtTime(DateTime time) {
		this.time = time;
		return weatherMap.get(time);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Weather getWeather(DateTime time) {
		this.time = time;
		return getWeatherAtTime(time);
	}

	@Override
	public String toString() {
		return "City [name=" + name + ", weather=" + getWeather(time) + "]";
	}

}
