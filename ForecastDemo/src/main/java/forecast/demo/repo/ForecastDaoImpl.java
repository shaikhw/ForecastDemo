package forecast.demo.repo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.List;

import org.joda.time.DateTime;

import forecast.demo.City;

public class ForecastDaoImpl implements ForecastDao {

	private static final String DB_DRIVER = "org.h2.Driver";
	private static final String DB_CONNECTION = "jdbc:h2:~/test";
	private static final String DB_USER = "";
	private static final String DB_PASSWORD = "";

	private static final String CREATE_QUERY = "CREATE TABLE FORECAST(TIME TIMESTAMP primary key, CITY varchar(255))";
	private static final String ISNERT_QUERY = "INSERT INTO FORECAST" + "(TIME, CITY) values" + "(?,?)";
	private static final String SELECT_QUERY = "select * from FORECAST";
	private Connection connection;

	public ForecastDaoImpl() throws SQLException {
		connection = getDBConnection();
		Statement stmt = null;
		try {
			connection.setAutoCommit(false);
			stmt = connection.createStatement();
			stmt.execute(CREATE_QUERY);
		} catch (SQLException e) {
			System.out.println("Exception Message " + e.getLocalizedMessage());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
	}

	@Override
	public void persist(DateTime time, List<City> citiesWithHottestWeather) throws SQLException {
		connection = getDBConnection();
		try {
			connection.setAutoCommit(false);
			PreparedStatement insertPreparedStatement = null;
			PreparedStatement selectPreparedStatement = null;

			connection.setAutoCommit(false);
			insertPreparedStatement = connection.prepareStatement(ISNERT_QUERY);
			for (City city : citiesWithHottestWeather) {
				insertPreparedStatement.setTimestamp(1, new Timestamp(time.getMillis()));
				insertPreparedStatement.setString(2, city.getName());
				insertPreparedStatement.executeUpdate();
				insertPreparedStatement.close();
			}

			selectPreparedStatement = connection.prepareStatement(SELECT_QUERY);
			ResultSet rs = selectPreparedStatement.executeQuery();
			System.out.println("H2 Database inserted through PreparedStatement");
			while (rs.next()) {
				System.out.println("TIME " + rs.getTimestamp("TIME") + " CITY " + rs.getString("CITY"));
			}
			selectPreparedStatement.close();

			connection.commit();
		} catch (SQLException e) {
			System.out.println("Exception Message " + e.getLocalizedMessage());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
	}

	private static Connection getDBConnection() {
		Connection dbConnection = null;
		try {
			Class.forName(DB_DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		try {
			dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
			return dbConnection;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return dbConnection;
	}

}

