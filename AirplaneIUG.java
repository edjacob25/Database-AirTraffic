import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class AirplaneIUG extends JFrame implements  ActionListener
{
	private JPanel panel1, panel2;
	private JTextField tfSearch;
	private JButton bAll, bFlying, bClean;
	private JTextArea taData; 	

	private String[] airlines;
	private JComboBox comboAirlines;
	private String[] model = {"Boeing 747","Cessna 206","Airbus 380"};
	private JComboBox comboModel;

	private AirplaneAD airplane = new AirplaneAD();

	public AirplaneIUG()
	{
		airlines = airplane.getAirlines();
		tfSearch = new JTextField();

		bAll = new JButton("Todos");
		bAll.addActionListener(this);

		bFlying = new JButton("En Vuelo");
		bFlying.addActionListener(this);

		bClean = new JButton("Limpiar");
		bClean.addActionListener(this);

		comboAirlines = new JComboBox(airlines);
		comboModel = new JComboBox(model);

		taData = new JTextArea(8,40);

		panel1 = new JPanel();
		panel2 = new JPanel();

		//2 Añadiendo Objetos

		panel1.setLayout(new GridLayout(5,2));
		panel2.setLayout(new FlowLayout());

		panel1.add(new JLabel("Consulta: "));
		panel1.add(tfSearch);
		tfSearch.setEnabled(false);

		panel1.add(bAll);
		panel1.add(bFlying);
		panel1.add(comboAirlines);
		panel1.add(comboModel);
		panel1.add(bClean);


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
		comboAirlines.setSelectedIndex(0);
		comboModel.setSelectedIndex(0);
	}

	public void actionPerformed(ActionEvent event)
	{
		if(event.getSource() == bClean)
		{
			cleanData();
		}
		if (event.getSource() == bAll) {
			String airline = (String)comboAirlines.getSelectedItem();
			String model = (String)comboModel.getSelectedItem();
			taData.setText(airplane.searchAll(airline,model));
		}
		if (event.getSource() == bFlying) {
			String airline = (String)comboAirlines.getSelectedItem();
			String model = (String)comboModel.getSelectedItem();
			taData.setText(airplane.searchFlying(airline,model));
		}
	}

	public static void main(String args[])
	{
		AirplaneIUG airplaneIUG = new AirplaneIUG();
	}
}