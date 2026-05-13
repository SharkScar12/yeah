import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class GUIit extends JFrame implements ActionListener {
	JPanel rightPanel = new JPanel();
	JPanel topPanel = new JPanel();
	JPanel leftPanel = new JPanel();
	JPanel rightBottomPanel = new JPanel();
	JPanel leftTop = new JPanel();
	JPanel left1 = new JPanel();
	JPanel left2 = new JPanel();
	JPanel left3 = new JPanel();
	JPanel left4 = new JPanel();
	JPanel left5 = new JPanel();
	JTextPane test = new JTextPane();
	JTextPane description = new JTextPane();
	JTextArea notes = new JTextArea();
	JScrollPane scrollPane = new JScrollPane(notes);
	JLabel titreTicket = new JLabel();
	JButton confirmeResolution = new JButton();
	JLabel[] infos = new JLabel[6];

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
		rightBottomPanel.setBackground(Color.blue);
		rightPanel.add(rightBottomPanel, gbc);
		left3.setBackground(Color.RED);
		leftTop.setBackground(Color.green);
		leftPanel.setLayout(new GridLayout(6,0));
		leftPanel.add(leftTop);
		leftPanel.add(left1);
		leftPanel.add(left2);
		leftPanel.add(left3);
		leftPanel.add(left4);
		leftPanel.add(left5);

		
		rightPanel.setLayout(new GridLayout(8,1));
		for(int i = 0; i<6; i++) {
			infos[i] = new JLabel();
		}
		infos[0].setText("Les problèmes");
		infos[1].setText("Des");
		infos[2].setText("Élèves");
		infos[3].setText("Serons");
		infos[4].setText("Affichés");
		infos[5].setText("Ici!");
		for(int i = 0; i<6; i++) {
			rightPanel.add(infos[i]);
		}
		
		
		description.setEditable(false);
		rightPanel.add(description);
		notes.setLineWrap(true);
		/*rightBottomPanel.add(scrollPane);*/
		rightBottomPanel.add(confirmeResolution);
		confirmeResolution.setText("Soummetre la résolution de problème.");
		rightPanel.add(rightBottomPanel);
		leftPanel.setBackground(Color.green);
		rightPanel.setBackground(Color.cyan);
		

		setVisible(true);
	}
	
	public void actionPerformed (ActionEvent actionEvent ) {
		
	}
	
	
	
	

}