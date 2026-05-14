import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class GUIcreation extends JFrame implements ActionListener{
	JPanel rightPanel = new JPanel();
	JPanel rightTopPanel = new JPanel();
	JPanel leftPanel = new JPanel();
	JPanel topPanel = new JPanel();
	JPanel leftTopPanel = new JPanel();
	JPanel leftMiddlePanel = new JPanel();
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
	JTextArea description = new JTextArea();
	JScrollPane scrollPane = new JScrollPane(description);
	JTextPane descriptionInst = new JTextPane();
	JButton butEnv = new JButton("Envoyer");
	JButton butIT = new JButton("Mode IT");
	TicketReparation thisTicket = new TicketReparation();
	JTextPane idInst = new JTextPane();
	JTextArea id = new JTextArea();
	JTextPane emailInst = new JTextPane();
	JTextArea email = new JTextArea();
	JScrollPane idScroll = new JScrollPane(id);
	JScrollPane emailScroll = new JScrollPane(email);
	boolean[] categTemp = new boolean[boxCateg.length];
	public GUIcreation () {
		super ("GUIcreation");
		setSize(700,500);
		butEnv.addActionListener(this);
		butIT.addActionListener(this);
		getContentPane().setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
	    gbc.fill = GridBagConstraints.BOTH;
	    gbc.weightx = 0.5;
	    gbc.weighty = 0.05;
	    gbc.gridx = 0;
	    gbc.gridy = 0;
	    leftPanel.setLayout(new GridBagLayout());
	    this.add(topPanel, gbc);
	    
	    idInst.setText("Entrez votre id:");
	    idInst.setEditable(false);
	    emailInst.setText("Entrez votre adresse courriel:");
	    emailInst.setEditable(false);
	    topPanel.setLayout(new GridBagLayout());
	    GridBagConstraints forTopPanel = new GridBagConstraints();
	    forTopPanel.weightx = 0.5;
	    forTopPanel.gridx = 0;
	    forTopPanel.gridy = 0;
	    forTopPanel.weighty = 0.5;
	    forTopPanel.fill = GridBagConstraints.BOTH;
	    
	    idInst.setMaximumSize(new Dimension(200,50));
	    topPanel.add(idInst, forTopPanel);
	    forTopPanel.gridx = 1;
	    idScroll.setMinimumSize(new Dimension(150,50));
	    topPanel.add(idScroll, forTopPanel);
	    forTopPanel.gridx = 2;
	    emailInst.setMaximumSize(new Dimension(200,50));
	    topPanel.add(emailInst, forTopPanel);
	    forTopPanel.gridx = 3;
	    emailScroll.setMinimumSize(new Dimension(150, 25));
	    topPanel.add(emailScroll, forTopPanel);
	    
	    
	    gbc.gridy = 1;
	    gbc.weighty = 0.95;
	    this.add(leftPanel, gbc);
	    gbc.weighty = 0.5;
		leftTopPanel.setLayout(new GridBagLayout());
		categories.setText("Cochez le(s) boîte(s) applicable(s) à votre problème:");
		categories.setEditable(false);
	    leftTopPanel.add(categories, gbc);
		for(int i=0; i<6; i++) {
			gbc.gridy = i+1;
			leftTopPanel.add(boxCateg[i], gbc);
		}
		gbc.gridy = 2;
		leftPanel.add(leftTopPanel, gbc);
		
		gbc.gridy = 3;
		gbc.weighty = 0.02;
		descriptionInst.setText("Entrez une description:");
		descriptionInst.setEditable(false);
		leftPanel.add(descriptionInst, gbc);
		
		gbc.gridy = 4;
		gbc.weighty = 0.2;
		description.setLineWrap(true);
		leftPanel.add(scrollPane, gbc);
		gbc.gridy = 5;
		gbc.weighty = 0.1;
		leftPanel.add(butEnv, gbc);
		
		gbc.gridy = 0;
		gbc.weighty = 0.001;
		leftPanel.add(butIT, gbc);
		/*rightPanel.setLayout(new GridBagLayout());
		this.add(rightPanel, gbc);
		gbc.gridx = 0;
	    rightTopPanel.setBackground(Color.black);
		rightPanel.add(rightTopPanel, gbc);
		gbc.gridy = 1;
		gbc.weighty = 0.18;
		rightBottomPanel.setBackground(Color.blue);
		rightBottomPanel.add(butEnv);
		rightPanel.add(rightBottomPanel, gbc);*/
		setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
	    if (e.getSource() == butEnv) {
	        // Ajoutez ici le code à exécuter lors du clic sur le bouton Envoyer
	    	System.out.println("butEnv");
	    	thisTicket.setDescription(description.getText());
	    	try {
	    	thisTicket.setCompteID(Integer.parseInt(id.getText()));
	    	} catch(NumberFormatException f) {
	    		System.out.println("e");
	    	}
	    	thisTicket.setEmail(email.getText());
	    	thisTicket.setCategories(categTemp);
	    	thisTicket.systemeAffiche();
	    } else if (e.getSource() == butIT) {
	    	System.out.println("butIT");
	    }
	}
	 public void prendCategories () {
		    for (int i = 0; i > boxCateg.length; i++) {
		      if (boxCateg[i].isSelected()) {
		        categTemp[i] = true;
		      } else {
		        categTemp[i] = false;
		      }
		    }
		  }
}

