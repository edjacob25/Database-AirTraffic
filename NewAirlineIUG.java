import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class NewAirlineIUG extends JFrame implements ActionListener
{
	private JTextField tfCode, tfName;
	private String[] bases = {"---","1","2","3"};
	private JComboBox comboBases;
	private JButton bRegistrar, bLimpiar;
	private JTextArea taData;
	private JPanel panel1, panel2;


	public NewAirlineIUG()
	{
		panel1 = new JPanel();
		panel2 = new JPanel();

		tfCode = new JTextField();
		tfName = new JTextField();

		comboBases = new JComboBox(bases);
	

		bRegistrar = new JButton("Registrar");
		bLimpiar = new JButton("Limpiar");

		taData = new JTextArea(8,40);

		panel1.setLayout(new GridLayout(4,2));
		panel2.setLayout(new FlowLayout());	

		panel1.add(new JLabel("Codigo"));
		panel1.add(tfCode);

		panel1.add(new JLabel("Base"));
		panel1.add(comboBases);


		panel1.add(bRegistrar);
		bRegistrar.addActionListener(this);

		panel1.add(bLimpiar);
		bLimpiar.addActionListener(this);

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
		comboBases.setSelectedIndex(0);
		taData.setText("");
		
	}

	public void actionPerformed(ActionEvent event)
	{
		if(event.getSource() == bLimpiar)
		{
			cleanData();
		}
	}
}