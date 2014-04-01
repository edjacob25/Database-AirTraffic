import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class FlightIUG extends JFrame implements ActionListener
{
	// private String[] dates = {"---","1","2","3"};
	// private JComboBox comboDates;
	private String[] statusShow = {"---","A Tiempo","Retrasado","Arrivo","Cancelado","Volando"};
	private String[] statusReal = {"---","ON TIME","DELAYED","ARRIVED","CANCELED", "FLYING"};
	
	private JComboBox comboStatus;

	JSpinner datePicker;

	private JButton bSearchAll, bSearchSpecific, bLimpiar, bSalir;

	private JTextArea taData;
	private JPanel panel1, panel2;

	private FlightAD flight = new FlightAD();

	public FlightIUG()
	{
		datePicker = new JSpinner(new SpinnerDateModel());
		datePicker.setEditor(new JSpinner.DateEditor(datePicker,"dd/MM/yyyy"));
		// comboDates = new JComboBox(dates);
		comboStatus = new JComboBox(statusShow);

		bSearchAll = new JButton("Buscar todos");
		bSearchSpecific = new JButton("Buscar especifico");
		bLimpiar = new JButton("Limpiar");
		bSalir = new JButton("Salir");

		taData = new JTextArea(20,40);

		panel1 = new JPanel();
		panel2 = new JPanel();

		panel1.setLayout(new GridLayout(4,2));
		panel2.setLayout(new FlowLayout());

		panel1.add(new JLabel("Fecha"));
		// panel1.add(comboDates);
		panel1.add(datePicker);

		panel1.add(new JLabel("Estado"));
		panel1.add(comboStatus);

		panel1.add(bSearchAll);
		bSearchAll.addActionListener(this);

		panel1.add(bSearchSpecific);
		bSearchSpecific.addActionListener(this);

		panel1.add(bLimpiar);
		bLimpiar.addActionListener(this);

		panel1.add(bSalir);
		bSalir.addActionListener(this);

		panel2.add(panel1);
		panel2.add(new JScrollPane(taData));

		add(panel2);
		setSize(400,400);

		//setVisible(true);
	}

	public JPanel getPanel2()
	{
		return panel2;
	}

	private void cleanData()
	{
		datePicker.setValue(new Date());
		comboStatus.setSelectedIndex(0);
		taData.setText("");
		//comboDates.setSelectedIndex(0);
	}


	public void actionPerformed(ActionEvent event)
	{
		if(event.getSource() == bSearchAll)
		{
			// String datos = getData();
			// JOptionPane.showMessageDialog(null, datos);
			taData.setText(flight.checkAllFlights());
		}

		if (event.getSource() == bSearchSpecific) {
			String status = statusReal[comboStatus.getSelectedIndex()];
			if (status.equals("---")) 
				JOptionPane.showMessageDialog(null, "Escoja un estado valido");
			else
			{
				Date date = (Date)datePicker.getValue();
				taData.setText(flight.search(status, new java.sql.Date(date.getTime())));

			}
		}

		if(event.getSource() == bLimpiar)
		{
			cleanData();
		}

		if(event.getSource() == bSalir)
		{
			System.exit(0);
		}
	}


	public static void main(String args[])
	{
		FlightIUG flightIUG = new FlightIUG();
	}
}