import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.*;
import java.util.Calendar;

public class FlightAD
{
	private Connection conexion;
	private Statement statement;

	public FlightAD(){
		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/AirTraffic","myself","myself");
			System.out.println("Conexion exitosa a la BD en MySQL, JDBC Tipo 4");
		}
		catch(ClassNotFoundException cnfe)
		{
			System.out.println("Error: " + cnfe);
		}
		catch(java.sql.SQLException sqle)
		{
			System.out.println("Error: " + sqle);	
		}
		catch(InstantiationException ie)
		{
			System.out.println("Error: " + ie);	
		}
		catch(IllegalAccessException iae)
		{			
			System.out.println("Error: " + iae);	
		}
	}

	public String checkAllFlights(){
		
		String data="";
		String query = "";
		boolean pass = false;

		FlightDP flight = new FlightDP();
		ResultSet tr = null;
			try
			{
				statement = conexion.createStatement();
				query = "SELECT * FROM Flight";
				tr = statement.executeQuery(query);
	
				while(tr.next())
				{
					pass = true;
					flight.setFlightNumber(tr.getInt("flight_number"));
					flight.setStatus(tr.getString("status"));
					flight.setPlane(tr.getString("plane"));
					flight.setOrigin(tr.getString("origin"));
					flight.setDestination(tr.getString("destination"));
					flight.setDeparture(tr.getDate("departure")+" "+tr.getTime("departure"));
					flight.setArrival(tr.getDate("arrival")+" "+tr.getTime("arrival"));
					data = data + flight.toString() +"\n";
				}
			}
			catch(SQLException sqle)
			{
				System.out.println("Error: " + sqle);
				data = "Error "+ sqle;
			}
			if (!pass) {
				data="No hay vuelos";
			}
		return data;
	}

	public String search(String status, Date date){
		
		String data="";
		String query = "";
		
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DATE,1);
		Date tomorrow = new Date(c.getTimeInMillis());

		boolean pass = false;

		FlightDP flight = new FlightDP();
		ResultSet tr = null;
			try
			{
				statement = conexion.createStatement();
				query = "SELECT * FROM Flight WHERE status = '"+status+"' AND departure > '"+date+"' AND departure < '"+tomorrow+"'";
				tr = statement.executeQuery(query);
	
				while(tr.next())
				{
					pass=true;
					flight.setFlightNumber(tr.getInt("flight_number"));
					flight.setStatus(tr.getString("status"));
					flight.setPlane(tr.getString("plane"));
					flight.setOrigin(tr.getString("origin"));
					flight.setDestination(tr.getString("destination"));
					flight.setDeparture(tr.getDate("departure")+" "+tr.getTime("departure"));
					flight.setArrival(tr.getDate("arrival")+" "+tr.getTime("arrival"));
					data = data + flight.toString() +"\n";
				}
			}
			catch(SQLException sqle)
			{
				System.out.println("Error: " + sqle);
				data = "Error "+ sqle;
			}
			if (!pass) {
				data="No hay vuelos";
			}
		return data;
	}
}