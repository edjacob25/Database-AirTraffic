import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class NewAirportIUG extends JFrame implements ActionListener
{
	private JTextField tfCode, tfName, tfAddress;
	private JButton bRegister, bClean;
	private JTextArea taData;
	private JPanel panel1, panel2;
	private NewAirportAD airport = new NewAirportAD();

	public NewAirportIUG()
	{
		panel1 = new JPanel();
		panel2 = new JPanel();

		tfCode = new JTextField(3);
		tfName = new JTextField();
		tfAddress = new JTextField();

		bRegister = new JButton("Registrar");
		bClean = new JButton("Limpiar");

		taData = new JTextArea(8,40);

		panel1.setLayout(new GridLayout(5,2));
		panel2.setLayout(new FlowLayout());	

		panel1.add(new JLabel("Codigo"));
		panel1.add(tfCode);

		panel1.add(new JLabel("Nombre"));
		panel1.add(tfName);

		panel1.add(new JLabel("Direccion"));
		panel1.add(tfAddress);


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

	public JPanel getPanel2()
	{
		return panel2;
	}

	private void cleanData()
	{
		tfCode.setText("");
		tfName.setText("");
		tfAddress.setText("");
		taData.setText("");
		
	}

	public void actionPerformed(ActionEvent event)
	{
		if(event.getSource() == bClean)
		{
			cleanData();
		}
		if (event.getSource()== bRegister) {
			String code = tfCode.getText();
			String name = tfName.getText();
			String address = tfAddress.getText();
			taData.setText(airport.setNewAirport(code, name, address));

		}
	}
}