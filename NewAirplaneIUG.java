import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class NewAirplaneIUG extends JFrame implements ActionListener
{
	private JTextField tfPlate, tfHours;
	private JButton bRegistrar, bLimpiar;
	private JTextArea taDatos;
	private JPanel panel1, panel2;
	private String[] owners;
	private JComboBox comboOwner;
	private String[] model = {"Boeing 747","Cessna 206","Airbus 380"};
	private JComboBox comboModel;
	private NewAirplaneAD airplane = new NewAirplaneAD();

	public NewAirplaneIUG()
	{
		owners = airplane.getAirlines();
		panel1 = new JPanel();
		panel2 = new JPanel();

		tfPlate = new JTextField();
		tfHours = new JTextField();
		comboModel = new JComboBox(model);
		comboOwner = new JComboBox(owners);

		bRegistrar = new JButton("Registrar");
		bLimpiar = new JButton("Limpiar");

		taDatos = new JTextArea(8,40);

		panel1.setLayout(new GridLayout(5,2));
		panel2.setLayout(new FlowLayout());	

		panel1.add(new JLabel("Placas"));
		panel1.add(tfPlate);

		panel1.add(new JLabel("Duenio"));
		panel1.add(comboOwner);

		panel1.add(new JLabel("Modelo"));
		panel1.add(comboModel);

		panel1.add(new JLabel("Horas"));
		panel1.add(tfHours);

		panel1.add(bRegistrar);
		bRegistrar.addActionListener(this);

		panel1.add(bLimpiar);
		bLimpiar.addActionListener(this);

		panel2.add(panel1);
		panel2.add(new JScrollPane(taDatos));

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
		tfPlate.setText("");
		comboOwner.setSelectedIndex(0);
		comboModel.setSelectedIndex(0);
		tfHours.setText("");
	}

	public void actionPerformed(ActionEvent event)
	{
		if(event.getSource() == bLimpiar)
		{
			cleanData();
		}
		if(event.getSource() == bRegistrar)
		{
			try
			{
				String plate = tfPlate.getText();
				String owner = (String)comboOwner.getSelectedItem();
				String model = (String)comboModel.getSelectedItem();
				int hours = Integer.parseInt(tfHours.getText());
				
				taDatos.setText(airplane.setNewAirplane(plate,owner,model,hours));
			}
			catch(NumberFormatException nfe)
			{
				JOptionPane.showMessageDialog(null, "Horas debe de ser un numero");
			}
		}
	}
}