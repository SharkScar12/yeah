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
	JTextPane description = new JTextPane();
	JTextPane notes = new JTextPane();
	JLabel titreTicket = new JLabel();
	JButton confirmeResolution = new JButton();
	JLabel info1 = new JLabel("", 10);
	JLabel info2 = new JLabel("", 10);
	JLabel info3 = new JLabel("", 10);
	JLabel info4 = new JLabel("", 10);
	JLabel info5 = new JLabel("", 10);
	JLabel info6 = new JLabel("", 10);
	GridLayout baseGrid = new GridLayout(7,1);
	FlowLayout flowthing = new FlowLayout();
	
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
		bottomPanel.setLayout(new GridLayout(1,2));
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
		
		topPanel.setLayout(baseGrid);
		topPanel.add(info1);
		topPanel.add(info2);
		topPanel.add(info3);
		topPanel.add(info4);
		topPanel.add(info5);
		topPanel.add(info6);
		description.setEditable(false);
		topPanel.add(description);
		bottomPanel.add(notes);
		bottomPanel.add(confirmeResolution);
		setVisible(true);
	}
	
	
	
}