import java.util.StringTokenizer;

public class AirplaneDP
{
	String plate;
	String owner;
	String model;
	int hours_on_flight;

	public AirplaneDP(){
		this.plate = "";
		this.owner = "";
		this.model = "";
		this.hours_on_flight = 0;		
	}

	public AirplaneDP(String data){
		StringTokenizer st = new StringTokenizer(data,"_");
		this.plate = st.nextToken();
		this.owner = st.nextToken();
		this.model = st.nextToken();
		this.hours_on_flight = Integer.parseInt(st.nextToken());
	}

	//Setters
	public void setPlate(String data){
		this.plate = data;
	}

	public void setOwner(String data){
		this.owner = data;
	}

	public void setModel(String data){
		this.model = data;
	}

	public void setHours(int data){
		this.hours_on_flight = data;
	}

	//Getters
	public String getPlate(){
		return this.plate;
	}

	public String getOwner(){
		return this.owner;
	}

	public String getModel(){
		return this.model;
	}

	public int getHours(){
		return this.hours_on_flight;
	}

	public String toString()
	{
		return this.plate+"_"+this.owner+"_"+this.model+"_"+this.hours_on_flight+"\n";
	}
}	