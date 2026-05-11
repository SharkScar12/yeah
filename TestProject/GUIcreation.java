import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class GUIcreation extends JFrame {
	JPanel rightPanel = new JPanel();
	JPanel topPanel = new JPanel();
	JPanel leftPanel = new JPanel();
	JPanel bottomPanel = new JPanel();
	JCheckBox box1 = new JCheckBox("Plug");
	JCheckBox box2 = new JCheckBox("Cable");
	JCheckBox box3 = new JCheckBox("Ecran");
	JCheckBox box4 = new JCheckBox("Batterie");
	JCheckBox box5 = new JCheckBox("Allume/Eteint");
	JCheckBox box6 = new JCheckBox("Logiciel");
	JCheckBox[] boxCateg = {box1, box2, box3, box4, box5, box6};

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
		for(int i=0; i<6; i++) {
			leftPanel.add(boxCateg[i], gbc);
			gbc.gridy = i+1;
		}
		gbc.gridy = 0;
		this.add(leftPanel, gbc);
		gbc.gridx = 1;
		rightPanel.setLayout(new GridBagLayout());
		this.add(rightPanel, gbc);
	    gbc.gridx = 0;
	    topPanel.setBackground(Color.black);
		rightPanel.add(topPanel, gbc);
		gbc.gridy = 1;
		gbc.weighty = 0.15;
		bottomPanel.setBackground(Color.blue);
		rightPanel.add(bottomPanel, gbc);

		setVisible(true);
	}
}
