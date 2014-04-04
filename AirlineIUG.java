import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class AirlineIUG extends JFrame implements ActionListener
{
	private AirlineAD objetoAirlineAD = new AirlineAD();

	private String[] airlines;
	private JComboBox comboAirlines;
	
	private JTextArea taAirplanes, taData;

	private JPanel panel1, panel2;

	public AirlineIUG()
	{
		airlines = objetoAirlineAD.obtainAirlines();

		comboAirlines = new JComboBox(airlines);
		comboAirlines.addActionListener(this);
		
		taAirplanes = new JTextArea(8,40);
		taData = new JTextArea(15,40);

		panel1 = new JPanel();
		panel2 = new JPanel();

		panel1.setLayout(new GridLayout(2,1));
		panel2.setLayout(new FlowLayout());

		panel1.add(comboAirlines);
		panel1.add(new JLabel("Aviones"));
	
		panel2.add(panel1);
		panel2.add(new JScrollPane(taAirplanes));
		panel2.add(new JLabel("Vuelos"));
		panel2.add(new JScrollPane(taData));

		add(panel2);
		setSize(400,400);
		//setVisible(true);
	}

	public JPanel getPanel2()
	{
		return panel2;
	}

	public void actionPerformed(ActionEvent event)
	{
		if(event.getSource() == comboAirlines)
		{
			taAirplanes.setText(objetoAirlineAD.obtainAirplanes((String)comboAirlines.getSelectedItem()));
			taData.setText(objetoAirlineAD.obtainFlights((String)comboAirlines.getSelectedItem()));
		}
	}
}