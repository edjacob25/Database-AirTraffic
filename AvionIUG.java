import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class AvionIUG extends JFrame implements  ActionListener
{
	private JPanel panel1, panel2;
	private JTextField tfConsulta;
	private JButton bTodos, bEnVuelo, bLimpiar;
	private JTextArea taDatos; 	

	private String[] aerolineas = {"Aerolinea","A1","A2","A3"};
	private JComboBox comboAerolineas;
	private String[] modelos = {"Modelo","Boing","Pequeno","f411","Mediano"};
	private JComboBox comboModelos;

	public AvionIUG()
	{
		tfConsulta = new JTextField();

		bTodos = new JButton("Todos");
		bTodos.addActionListener(this);

		bEnVuelo = new JButton("En Vuelo");
		bEnVuelo.addActionListener(this);

		bLimpiar = new JButton("Limpiar");
		bLimpiar.addActionListener(this);

		comboAerolineas = new JComboBox(aerolineas);
		comboModelos = new JComboBox(modelos);

		taDatos = new JTextArea(8,40);

		panel1 = new JPanel();
		panel2 = new JPanel();

		//2 Añadiendo Objetos

		panel1.setLayout(new GridLayout(5,2));
		panel2.setLayout(new FlowLayout());

		panel1.add(new JLabel("Consulta: "));
		panel1.add(tfConsulta);
		tfConsulta.setEnabled(false);

		panel1.add(bTodos);
		panel1.add(bEnVuelo);
		panel1.add(comboAerolineas);
		panel1.add(comboModelos);
		panel1.add(bLimpiar);


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
		comboAerolineas.setSelectedIndex(0);
		comboModelos.setSelectedIndex(0);
	}

	public void actionPerformed(ActionEvent event)
	{
		if(event.getSource() == bLimpiar)
		{
			cleanData();
		}
	}

	public static void main(String args[])
	{
		AvionIUG avionIUG = new AvionIUG();
	}
}