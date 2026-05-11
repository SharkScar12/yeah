import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class GUIcreation extends JFrame {
	JPanel rightPanel = new JPanel();
	JPanel rightTopPanel = new JPanel();
	JPanel leftPanel = new JPanel();
	JPanel leftTopPanel = new JPanel();
	JPanel leftBottomPanel = new JPanel();
	JPanel rightBottomPanel = new JPanel();
	JCheckBox box1 = new JCheckBox("Plug");
	JCheckBox box2 = new JCheckBox("Cable");
	JCheckBox box3 = new JCheckBox("Ecran");
	JCheckBox box4 = new JCheckBox("Batterie");
	JCheckBox box5 = new JCheckBox("Allume/Eteint");
	JCheckBox box6 = new JCheckBox("Logiciel");
	JCheckBox[] boxCateg = {box1, box2, box3, box4, box5, box6};
	JTextPane categories = new JTextPane();
	JTextPane description = new JTextPane();
	JTextPane descriptionInst = new JTextPane();

	public GUIcreation () {
		super ("GUIcreation");
		setSize(500,500);
		getContentPane().setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
	    gbc.fill = GridBagConstraints.BOTH;
	    gbc.weightx = 0.5;
	    gbc.weighty = 0.5;
	    gbc.gridx = 0;
	    gbc.gridy = 0;
	    leftPanel.setLayout(new GridBagLayout());
	    this.add(leftPanel, gbc);
	   
		leftTopPanel.setLayout(new GridBagLayout());
		categories.setText("Cochez le(s) boîte(s) applicable(s) à votre problème:");
		categories.setEditable(false);
	    leftTopPanel.add(categories, gbc);
		for(int i=0; i<6; i++) {
			leftTopPanel.add(boxCateg[i], gbc);
			gbc.gridy = i+1;
		}
		gbc.gridy = 0;
		leftPanel.add(leftTopPanel, gbc);
		
		gbc.gridy = 1;
		gbc.weighty = 0.02;
		descriptionInst.setText("Entrez une description:");
		descriptionInst.setEditable(false);
		leftPanel.add(descriptionInst, gbc);
		
		gbc.gridy = 2;
		gbc.weighty = 0.2;
		leftPanel.add(description, gbc);
		gbc.gridy = 0;
		gbc.weighty = 0.5;
		gbc.gridx = 1;
		
		rightPanel.setLayout(new GridBagLayout());
		this.add(rightPanel, gbc);
	    gbc.gridx = 0;
	    rightTopPanel.setBackground(Color.black);
		rightPanel.add(rightTopPanel, gbc);
		gbc.gridy = 1;
		gbc.weighty = 0.15;
		rightBottomPanel.setBackground(Color.blue);
		rightPanel.add(rightBottomPanel, gbc);
		
		setVisible(true);
	}
}
