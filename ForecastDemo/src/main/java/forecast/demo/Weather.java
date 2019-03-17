package forecast.demo;

public class Weather implements Comparable<Weather> {
	private int tempreture;

	public Weather(int tempreture) {
		this.tempreture = tempreture;
	}

	public int getTempreture() {
		return tempreture;
	}

	public int compareTo(Weather o) {
		return this.tempreture - o.getTempreture();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + tempreture;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Weather other = (Weather) obj;
		if (tempreture != other.tempreture)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Weather [tempreture=" + tempreture + "]";
	}

}
