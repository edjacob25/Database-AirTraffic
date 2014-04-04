import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class AirportIUG extends JFrame implements ActionListener
{
	private String[] airports; 
	private JComboBox comboAirports;
	private JTextField tfAdress;
	private JTextArea taData;

	private JPanel panel1, panel2;

	AirportAD airport = new AirportAD();

	public AirportIUG()
	{
		airports = airport.returnAirports();
		comboAirports = new JComboBox(airports);
		comboAirports.addActionListener(this);
		tfAdress = new JTextField();
		taData = new JTextArea(8,40);

		panel1 = new JPanel();
		panel2 = new JPanel();

		panel1.setLayout(new GridLayout(2,2));
		panel2.setLayout(new FlowLayout());

		panel1.add(comboAirports);
		panel1.add(new JLabel(""));

		panel1.add(new JLabel("Direccion: "));
		panel1.add(tfAdress);
		tfAdress.setColumns(15);
		tfAdress.setEnabled(false);

		panel2.add(panel1);
		panel2.add(new JScrollPane(taData));

		add(panel2);
		setSize(400,400);
		tfAdress.setText(airport.getAddress((String)comboAirports.getSelectedItem()));
		//setVisible(true);
	}

	public JPanel getPanel2()
	{
		return panel2;
	}

	public void actionPerformed(ActionEvent event)
	{
		if (event.getSource()==comboAirports) {
			tfAdress.setText(airport.getAddress((String)comboAirports.getSelectedItem()));
			taData.setText(airport.getFlights((String)comboAirports.getSelectedItem()));
		}
	}
}