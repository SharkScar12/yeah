import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class GUIcreation extends JFrame {
	JPanel rightPanel = new JPanel();
	JPanel topPanel = new JPanel();
	JPanel leftPanel = new JPanel();
	JPanel bottomPanel = new JPanel();
	
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
		rightPanel.setLayout(new GridBagLayout());
		//leftPanel.setPreferredSize(new Dimension(250, 500));
		this.add(leftPanel, gbc);
		//rightPanel.setPreferredSize(new Dimension(250, 500));
		gbc.gridx = 1;
		this.add(rightPanel, gbc);
	    //gbc.weightx = 0.5;
	    //gbc.weighty = 0.5;
	    gbc.gridx = 0;
	    //gbc.gridy = 0;
	    topPanel.setBackground(Color.black);
	    topPanel.setPreferredSize(new Dimension(250, 350));
		rightPanel.add(topPanel, gbc);
		gbc.gridy = 1;
		gbc.weighty = 0.15;
		bottomPanel.setBackground(Color.blue);
		bottomPanel.setPreferredSize(new Dimension(250, 150));
		rightPanel.add(bottomPanel, gbc);
		setVisible(true);
	}
}
