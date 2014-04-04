import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class NewAirplaneIUG extends JFrame implements ActionListener
{
	private JTextField tfPlate, tfOwner, tfModel, tfHours;
	private JButton bRegistrar, bLimpiar;
	private JTextArea taDatos;
	private JPanel panel1, panel2;


	public NewAirplaneIUG()
	{
		panel1 = new JPanel();
		panel2 = new JPanel();

		tfPlate = new JTextField();
		tfOwner = new JTextField();
		tfModel = new JTextField();
		tfHours = new JTextField();

		bRegistrar = new JButton("Registrar");
		bLimpiar = new JButton("Limpiar");

		taDatos = new JTextArea(8,40);

		panel1.setLayout(new GridLayout(5,2));
		panel2.setLayout(new FlowLayout());	

		panel1.add(new JLabel("Placas"));
		panel1.add(tfPlate);

		panel1.add(new JLabel("Duenio"));
		panel1.add(tfOwner);

		panel1.add(new JLabel("Modelo"));
		panel1.add(tfModel);

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
		tfOwner.setText("");
		tfModel.setText("");
		tfHours.setText("");
	}

	public void actionPerformed(ActionEvent event)
	{
		if(event.getSource() == bLimpiar)
		{
			cleanData();
		}
	}
}