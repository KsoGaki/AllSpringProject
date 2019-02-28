package fr.formation.afpa.main;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Component
public class PseudoJFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JList<Product> jList;

	@Autowired
	private AddDialog addDialog;
	
	@Autowired
	private UpdateDialog updateDialog;
	
	@Autowired
	private PseudoModel pseudoModel;
	
	@Autowired
	private PseudoService pseudoService;
	
	public JList<Product> getjList() {
		return jList;
	}

	public PseudoJFrame() {}

	public void start() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 564, 616);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(51, 51, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(51, 51, 51));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		jList = new JList<Product>();
		jList.setBorder(new EmptyBorder(5, 5, 5, 5));
		jList.setBounds(21, 27, 384, 466);
		jList.setBackground(new Color(255, 255, 255));
		contentPane.add(jList);

		jList.setModel(pseudoModel);

		JButton deleteButton = new JButton("delete");
		deleteButton.setBackground(new Color(255, 0, 0));
		deleteButton.setForeground(new Color(255, 255, 255));
		deleteButton.setFont(new Font("Titillium Web", Font.PLAIN, 18));
		deleteButton.setBounds(426, 520, 100, 30);
		contentPane.add(deleteButton);
		
		deleteButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int jListIdSelected = jList.getSelectedIndex();
				pseudoService.deleteById(jListIdSelected);
				jList.updateUI();
			}
		});
		
		JButton addButton = new JButton("add");
		addButton.setBackground(new Color(255, 0, 0));
		addButton.setForeground(new Color(255, 255, 255));
		addButton.setFont(new Font("Titillium Web", Font.PLAIN, 18));
		addButton.setBounds(426, 550, 100, 30);
		contentPane.add(addButton);
		
		addButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				addDialog.setModal(true);
				addDialog.start();
				jList.updateUI();
			}
		});
		
		JButton updateButton = new JButton("update");
		updateButton.setBackground(new Color(255, 0, 0));
		updateButton.setForeground(new Color(255, 255, 255));
		updateButton.setFont(new Font("Titillium Web", Font.PLAIN, 18));
		updateButton.setBounds(426, 490, 100, 30);
		contentPane.add(updateButton);
		
		updateButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				updateDialog.setModal(true);
				updateDialog.start();
				jList.updateUI();
			}
		});
	}
}
