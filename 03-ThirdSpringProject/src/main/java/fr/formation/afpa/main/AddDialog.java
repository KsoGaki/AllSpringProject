package fr.formation.afpa.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddDialog extends JDialog {

	@Autowired
	PseudoService pseudoService;

	private static final long serialVersionUID = 1L;

	public AddDialog() {

	}

	public void start() {
		setVisible(true);
		setTitle("Add Bagnole");
		getContentPane().setBackground(new Color(51, 51, 51));
		getContentPane().setLayout(null);

		JTextField addFieldString = new JTextField();
		addFieldString.setFont(new Font("Rockwell", Font.PLAIN, 14));
		addFieldString.setBounds(33, 35, 100, 30);
		getContentPane().add(addFieldString);
		addFieldString.setColumns(10);

		JTextField addFieldValue = new JTextField();
		addFieldValue.setFont(new Font("Rockwell", Font.PLAIN, 14));
		addFieldValue.setColumns(10);
		addFieldValue.setBounds(299, 35, 100, 30);
		getContentPane().add(addFieldValue);
		setBounds(100, 100, 450, 160);

		JButton addButton = new JButton("Add");
		getContentPane().add(addButton);

		JLabel addLabelString = new JLabel("String");
		addLabelString.setFont(new Font("Rockwell", Font.PLAIN, 18));
		addLabelString.setForeground(new Color(255, 255, 255));
		addLabelString.setBounds(33, 11, 100, 20);
		getContentPane().add(addLabelString);

		JLabel addLabelValue = new JLabel("Valeur");
		addLabelValue.setForeground(Color.WHITE);
		addLabelValue.setFont(new Font("Rockwell", Font.PLAIN, 18));
		addLabelValue.setBounds(299, 11, 100, 20);
		getContentPane().add(addLabelValue);

		JButton addCancelButton = new JButton("cancel");
		addCancelButton.setForeground(new Color(255, 255, 255));
		addCancelButton.setFont(new Font("Titillium Web", Font.PLAIN, 16));
		addCancelButton.setBackground(new Color(204, 0, 51));
		addCancelButton.setBounds(236, 87, 89, 23);
		getContentPane().add(addCancelButton);
		addCancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		JButton addAddButton = new JButton("add");
		addAddButton.setForeground(new Color(255, 255, 255));
		addAddButton.setBackground(new Color(51, 102, 0));
		addAddButton.setBounds(335, 87, 89, 23);
		getContentPane().add(addAddButton);
		addAddButton.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				String string = addFieldString.getText();
				Integer value = null;
				if(string == null || string.equals("")) {
					JOptionPane.showConfirmDialog(null, "Entrez une chaine", "Erreur Chaine", JOptionPane.CLOSED_OPTION);
					return;
				}
				try {
					value = Integer.parseInt(addFieldValue.getText());
				} catch (Exception exception) {
					exception.printStackTrace();
					JOptionPane.showConfirmDialog(null, "Entrez une valeur correct", "Erreur Valeur", JOptionPane.CLOSED_OPTION);
					return;
				}
				pseudoService.add(string, value);
				dispose();
			}
		});
	}
}


