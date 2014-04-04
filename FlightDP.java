import java.util.StringTokenizer;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class FlightDP
{
	private int flight_number;
	private String status;
	private String plane;
	private String origin;
	private String destination;
	private Date departure;
	private Date arrival;

	public FlightDP()
	{
		this.flight_number = 0;
		this.status = "";
		this.plane = "";
		this.origin = "";
		this.destination = "";
	}

	public FlightDP(String data)
	{
		StringTokenizer st = new StringTokenizer(data,"_" );
		this.flight_number = Integer.parseInt(st.nextToken());
		this.status = st.nextToken();
		this.plane = st.nextToken();
		this.origin = st.nextToken();
		this.destination = st.nextToken();

		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try
		{
			departure = format.parse(st.nextToken());
			arrival = format.parse(st.nextToken());
		}
		catch(ParseException pe)
		{
			System.out.println(pe);
		}
	}

	//Setters
	public void setFlightNumber(int flight_number){
		this.flight_number = flight_number;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public void setPlane(String plane){
		this.plane = plane;
	}

	public void setOrigin(String origin){
		this.origin = origin;
	}

	public void setDestination(String destination){
		this.destination = destination;
	}

	public void setDeparture(Date departure){
		this.departure = departure;
	}

	public void setDeparture(String departure){
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try
		{
			this.departure = format.parse(departure);
		}
		catch(ParseException pe)
		{
			System.out.println(pe);
		}
	}

	public void setArrival(Date arrival){
		this.arrival = arrival;
	}

	public void setArrival(String arrival){
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try
		{
			this.arrival = format.parse(arrival);
		}
		catch(ParseException pe)
		{
			System.out.println(pe);
		}
	}

	//Getters
	public int getFligthNumber(){
		return this.flight_number;
	}	

	public String getStatus(){
		return this.status;
	}

	public String getPlane(){
		return this.plane;
	}

	public String getOrigin(){
		return this.origin;
	}

	public String getDestination(){
		return this.destination;
	}

	public Date getDeparture(){
		return this.departure;
	}

	public Date getArrival(){
		return this.departure;
	}

	public String toString()
	{
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return flight_number+"_"+status+"_"+plane+"_"+origin+"_"+destination+"_"+format.format(departure)+"_"+format.format(arrival);
	}

	public String toStringNoCalendar()
	{
		return flight_number+"_"+status+"_"+plane+"_"+origin+"_"+destination+"\n";
	}
}