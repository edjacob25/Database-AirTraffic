import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class ProyectoIUG extends JFrame implements ActionListener
{
	private JMenuBar menuBar;
	private JMenu menuConsultas, menuTransacciones;
	private JMenuItem miAvion, miVuelo, miAerolinea, miAeropuerto, miSalir;
	private JPanel panel1, panel2;

	private AvionIUG objetoAvion = new AvionIUG();
	private FlightIUG objetoVuelos = new FlightIUG();
	private AeropuertoIUG objetoAeropuerto = new AeropuertoIUG();

	public ProyectoIUG()
	{
		menuBar = new JMenuBar();
		menuConsultas = new JMenu("Consultas");

		miAvion = new JMenuItem("Aviones");
		miVuelo = new JMenuItem("Vuelos");
		miAerolinea = new JMenuItem("Aerolineas");
		miAeropuerto = new JMenuItem("Aeropuertos");
		miSalir = new JMenuItem("Salir");

		miAvion.addActionListener(this);
		miVuelo.addActionListener(this);
		miAerolinea.addActionListener(this);
		miSalir.addActionListener(this);
		miAeropuerto.addActionListener(this);

		menuConsultas.add(miVuelo);
		menuConsultas.add(miAeropuerto);
		menuConsultas.add(miAerolinea);
		menuConsultas.add(miAvion);
		menuConsultas.add(miSalir);

		menuBar.add(menuConsultas);

		setJMenuBar(menuBar);

		setSize(500,500);
		setVisible(true);
	}
 
	private void ocultarPaneles()
	{
		objetoAvion.getPanel2().setVisible(false);
		objetoVuelos.getPanel2().setVisible(false);
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
		}

		if(event.getSource() == miAvion)
		{
			ocultarPaneles();

			objetoAvion.getPanel2().setVisible(true);
			add(objetoAvion.getPanel2());
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