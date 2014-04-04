import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class ProyectoIUG extends JFrame implements ActionListener
{
	private JMenuBar menuBar;
	private JMenu menuConsultas, menuTransacciones;
	private JMenuItem miAvion, miVuelo, miAerolinea, miAeropuerto, miSalir, miNuevoAvion, 
					  miNuevoAeropuerto, miNuevoVuelo, miNuevoAerolinea;
	private JPanel panel1, panel2;

	private AirplaneIUG objetoAvion = new AirplaneIUG();
	private FlightIUG objetoVuelos = new FlightIUG();
	private AirportIUG objetoAeropuerto = new AirportIUG();
	private AirlineIUG objetoAirline = new AirlineIUG();
	private NewAirplaneIUG objetoNewAirplane = new NewAirplaneIUG();
	private NewAirlineIUG objetoNewAirline = new NewAirlineIUG();
	private NewFlightIUG objetoNewFlight = new NewFlightIUG();

	public ProyectoIUG()
	{
		super("AirTraffic");
		menuBar = new JMenuBar();
		menuConsultas = new JMenu("Consultas");
		menuTransacciones = new JMenu("Transacciones");

		miAvion = new JMenuItem("Aviones");
		miVuelo = new JMenuItem("Vuelos");
		miAerolinea = new JMenuItem("Aerolineas");
		miAeropuerto = new JMenuItem("Aeropuertos");
		miSalir = new JMenuItem("Salir");

		miNuevoAvion = new JMenuItem("Nuevo Avion");
		miNuevoAeropuerto = new JMenuItem("Nuevo Aeropuerto");
		miNuevoAerolinea = new JMenuItem("Nueva Aerolinea");
		miNuevoVuelo = new JMenuItem("Nuevo Vuelo");

		miAvion.addActionListener(this);
		miVuelo.addActionListener(this);
		miAerolinea.addActionListener(this);
		miSalir.addActionListener(this);
		miAeropuerto.addActionListener(this);

		miNuevoVuelo.addActionListener(this);
		miNuevoAvion.addActionListener(this);
		miNuevoAerolinea.addActionListener(this);
		miNuevoAeropuerto.addActionListener(this);

		menuConsultas.add(miVuelo);
		menuConsultas.add(miAeropuerto);
		menuConsultas.add(miAerolinea);
		menuConsultas.add(miAvion);
		menuConsultas.add(miSalir);

		menuTransacciones.add(miNuevoAvion);
		menuTransacciones.add(miNuevoAeropuerto);
		menuTransacciones.add(miNuevoAerolinea);
		menuTransacciones.add(miNuevoVuelo);

		menuBar.add(menuConsultas);
		menuBar.add(menuTransacciones);

		setJMenuBar(menuBar);

		setSize(500,500);
		setVisible(true);
	}
 
	private void ocultarPaneles()
	{
		objetoAvion.getPanel2().setVisible(false);
		objetoVuelos.getPanel2().setVisible(false);
		objetoAeropuerto.getPanel2().setVisible(false);
		objetoAirline.getPanel2().setVisible(false);
		objetoNewAirplane.getPanel2().setVisible(false);
		objetoNewAirline.getPanel2().setVisible(false);
		objetoNewFlight.getPanel2().setVisible(false);
	}

	public void actionPerformed(ActionEvent event)
	{
		if(event.getSource() == miVuelo)
		{
			ocultarPaneles();

			objetoVuelos.getPanel2().setVisible(true);
			add(objetoVuelos.getPanel2());
			setVisible(true);
		}

		if(event.getSource() == miAeropuerto)
		{
			ocultarPaneles();

			objetoAeropuerto.getPanel2().setVisible(true);
			add(objetoAeropuerto.getPanel2());
			setVisible(true);
		}

		if(event.getSource() == miAerolinea)
		{
			ocultarPaneles();	
			objetoAirline.getPanel2().setVisible(true);
			add(objetoAirline.getPanel2());
			setVisible(true);
		}

		if(event.getSource() == miAvion)
		{
			ocultarPaneles();

			objetoAvion.getPanel2().setVisible(true);
			add(objetoAvion.getPanel2());
			setVisible(true);
		}

		if(event.getSource() == miNuevoAvion)
		{
			ocultarPaneles();

			objetoNewAirplane.getPanel2().setVisible(true);
			add(objetoNewAirplane.getPanel2());
			setVisible(true);
		}

		if(event.getSource() == miNuevoAerolinea)
		{
			ocultarPaneles();

			objetoNewAirline.getPanel2().setVisible(true);
			add(objetoNewAirline.getPanel2());
			setVisible(true);
		}

		if(event.getSource() == miNuevoVuelo)
		{
			ocultarPaneles();

			objetoNewFlight.getPanel2().setVisible(true);
			add(objetoNewFlight.getPanel2());
			setVisible(true);
		}

		if(event.getSource() == miSalir)
		{
			System.exit(0);
		}
	}

	public static void main(String args[])
	{
		ProyectoIUG proyectoIUG = new ProyectoIUG();
	}
}