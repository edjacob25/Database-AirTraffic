import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


public class NewFlightIUG extends JFrame implements ActionListener
{
	private JTextField tfNumber, tfStatus, tfPlane;
	private String[] airports;
	private String[] filteredAirports = {"---"};
	private String[] statusShow = {"---","A Tiempo","Retrasado","Arrivo","Cancelado","Volando"};
	private String[] statusReal = {"---","ON TIME","DELAYED","ARRIVED","CANCELED", "FLYING"};
	private String[] planes;

	private JComboBox comboOrigin, comboDestination, comboStatus, comboPlanes;

	JSpinner datePickerDeparture, datePickerArrival;

	private JButton bRegister, bClean;
	private JTextArea taData;
	private JPanel panel1, panel2;

	NewFlightAD newFlightAD = new NewFlightAD();

	public NewFlightIUG()
	{
		airports = newFlightAD.getAirports("");
		planes = newFlightAD.getAirplanes("");

		datePickerDeparture = new JSpinner(new SpinnerDateModel());
		datePickerDeparture.setEditor(new JSpinner.DateEditor(datePickerDeparture,"dd/MM/yyyy HH:mm"));

		datePickerArrival = new JSpinner(new SpinnerDateModel());
		datePickerArrival.setEditor(new JSpinner.DateEditor(datePickerArrival,"dd/MM/yyyy HH:mm"));

		comboOrigin = new JComboBox(airports);
		comboOrigin.addActionListener(this);
		comboDestination= new JComboBox(filteredAirports);

		comboStatus = new JComboBox(statusShow);
		comboPlanes = new JComboBox(planes);

		panel1 = new JPanel();
		panel2 = new JPanel();

		panel1.setLayout(new GridLayout(8,2));
		panel2.setLayout(new FlowLayout());	

		tfNumber = new JTextField();

		bRegister = new JButton("Registrar");
		bClean = new JButton("Limpiar");

		taData = new JTextArea(9,40);

		panel1.add(new JLabel("Numero"));
		panel1.add(tfNumber);

		panel1.add(new JLabel("Estado"));
		panel1.add(comboStatus);

		panel1.add(new JLabel("Avion"));
		panel1.add(comboPlanes);

		panel1.add(new JLabel("Origen"));
		panel1.add(comboOrigin);

		panel1.add(new JLabel("Destino"));
		panel1.add(comboDestination);

		panel1.add(new JLabel("Salida"));
		panel1.add(datePickerDeparture);

		panel1.add(new JLabel("Llegada"));
		panel1.add(datePickerArrival);

		panel1.add(bRegister);
		bRegister.addActionListener(this);
		panel1.add(bClean);
		bClean.addActionListener(this);

		panel2.add(panel1);
		panel2.add(new JScrollPane(taData));

		add(panel2);
		setSize(400,400);
		//setVisible(true);
		
	}

	private String obtainData()
	{
		String data = "";
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		java.util.Date timeDeparture = (java.util.Date)datePickerDeparture.getValue();
		java.util.Date timeArrival = (java.util.Date)datePickerArrival.getValue();
		
		String origin = newFlightAD.getShortName((String)comboOrigin.getSelectedItem());
		String destination = newFlightAD.getShortName((String)comboDestination.getSelectedItem());

		int index = comboStatus.getSelectedIndex();

		data = Integer.parseInt(tfNumber.getText())+",'"+statusReal[index]+"','"+comboPlanes.getSelectedItem();
		data = data+"','"+origin+"','"+destination;
		data = data+"','"+format.format(timeDeparture)+"','"+format.format(timeArrival)+"'";

		JOptionPane.showMessageDialog(null, "Data: "+data);

		return data;
	}

	public JPanel getPanel2()
	{
		return panel2;
	}

	private void cleanData()
	{
		tfNumber.setText("");
		taData.setText("");

		comboPlanes.setSelectedIndex(0);
		comboStatus.setSelectedIndex(0);
		comboOrigin.setSelectedIndex(0);
		comboDestination.setSelectedIndex(0);
	}

	public void actionPerformed(ActionEvent event)
	{
		if(event.getSource() == comboOrigin)
		{
			String origin = (String)comboOrigin.getSelectedItem();
			String[] data = newFlightAD.getAirports(origin);
			DefaultComboBoxModel model = new DefaultComboBoxModel(data);
			comboDestination.setModel( model );
		}	

		if(event.getSource() == bRegister)
		{
			String data = obtainData();
			String response = newFlightAD.newRegister(data);
			taData.setText(response);
		}

		if(event.getSource() == bClean)
		{
			cleanData();
		}
	}
}