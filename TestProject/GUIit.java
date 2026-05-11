import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class GUIit extends JFrame {
	JPanel rightPanel = new JPanel();
	JPanel topPanel = new JPanel();
	JPanel leftPanel = new JPanel();
	JPanel bottomPanel = new JPanel();
	JPanel leftTop = new JPanel();
	JPanel left1 = new JPanel();
	JPanel left2 = new JPanel();
	JPanel left3 = new JPanel();
	JPanel left4 = new JPanel();
	JPanel left5 = new JPanel();
	public GUIit () {
		super ("GUIit");
		setSize(500,500);
		getContentPane().setLayout(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints();
	    gbc.fill = GridBagConstraints.BOTH;
	    gbc.weightx = 0.5;
	    gbc.weighty = 0.5;
	    gbc.gridx = 0;
	    gbc.gridy = 0;
		rightPanel.setLayout(new GridBagLayout());
		this.add(leftPanel, gbc);
		gbc.gridx = 1;
		this.add(rightPanel, gbc);
	    gbc.gridx = 0;
	    topPanel.setBackground(Color.black);
		rightPanel.add(topPanel, gbc);
		gbc.gridy = 1;
		gbc.weighty = 0.15;
		bottomPanel.setBackground(Color.blue);
		rightPanel.add(bottomPanel, gbc);
		left3.setBackground(Color.RED);
		leftTop.setBackground(Color.green);
		leftPanel.setLayout(new GridLayout(6,0));
		leftPanel.add(leftTop);
		leftPanel.add(left1);
		leftPanel.add(left2);
		leftPanel.add(left3);
		leftPanel.add(left4);
		leftPanel.add(left5);
		setVisible(true);
	}
}