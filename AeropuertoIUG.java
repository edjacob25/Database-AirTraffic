import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class AeropuertoIUG extends JFrame implements ActionListener
{
	private String[] aeropuertos = {"B. Juarez", "Texas", "Toluca"}; 
	private JComboBox comboAeropuertos;
	private JTextField tfDireccion;
	private JTextArea taDatos;

	private JPanel panel1, panel2;


	public AeropuertoIUG()
	{
		comboAeropuertos = new JComboBox(aeropuertos);
		tfDireccion = new JTextField();
		taDatos = new JTextArea(8,40);

		panel1 = new JPanel();
		panel2 = new JPanel();

		panel1.setLayout(new GridLayout(2,2));
		panel2.setLayout(new FlowLayout());

		panel1.add(comboAeropuertos);
		panel1.add(new JLabel(""));

		panel1.add(new JLabel("Direccion: "));
		panel1.add(tfDireccion);
		tfDireccion.setColumns(15);
		tfDireccion.setEnabled(false);

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

	public void actionPerformed(ActionEvent event)
	{

	}
}