import java.awt.*;
import javax.swing.*;
import javax.swing.text.*;
import java.awt.event.*;
public class GUIcreation extends JFrame implements ActionListener{
	JPanel centerPanel = new JPanel();
	JPanel topPanel = new JPanel();
	JPanel centerTopPanel = new JPanel();
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
	boolean[] categTemp = new boolean[boxCateg.length]; //Boolean pour envoyer les valeurs des checkbox à l'objet
	public GUIcreation () {
		super ("GUIcreation");
		setSize(700,500);
		
		//Ajout du ActionListener
		butEnv.addActionListener(this); 
		butIT.addActionListener(this);
		
		//Création des GridBagLayout.
		getContentPane().setLayout(new GridBagLayout());
		centerPanel.setLayout(new GridBagLayout());
	    topPanel.setLayout(new GridBagLayout());
		centerTopPanel.setLayout(new GridBagLayout());

		//Création des deux objets contraintes d GridBagLayout.
		GridBagConstraints gbc = new GridBagConstraints();
	    gbc.fill = GridBagConstraints.BOTH;
	    gbc.weightx = 0.5;
	    gbc.weighty = 0.05;
	    gbc.gridx = 0;
	    gbc.gridy = 0;
	    
	    GridBagConstraints forTopPanel = new GridBagConstraints();
	    forTopPanel.weightx = 0.5;
	    forTopPanel.gridx = 0;
	    forTopPanel.gridy = 0;
	    forTopPanel.weighty = 0.5;
	    forTopPanel.fill = GridBagConstraints.BOTH;
	    
	    //Ajout des éléments au JFrame
	    this.add(topPanel, gbc);
	    gbc.gridy = 1;
	    gbc.weighty = 0.95;
	    this.add(centerPanel, gbc);
	    
	    //Ajout du texte aux éléments textuels
	    idInst.setText("Entrez votre id:");
	    emailInst.setText("Entrez votre adresse courriel:");
		categories.setText("Cochez le(s) boîte(s) applicable(s) à votre problème:");
		descriptionInst.setText("Entrez une description:");

	    //Ajout des restrictions liées à la modification des éléments textuels
	    idInst.setEditable(false);
	    emailInst.setEditable(false);
		descriptionInst.setEditable(false);
		categories.setEditable(false);

	    //Ajout des restrictions de dimension aux éléments textuels
	    idInst.setMaximumSize(new Dimension(200,50));
	    idScroll.setMinimumSize(new Dimension(150,50));
	    emailInst.setMaximumSize(new Dimension(200,50));
	    emailScroll.setMinimumSize(new Dimension(150, 25));
		description.setLineWrap(true);


	    //Ajout des éléments au topPanel
	    topPanel.add(idInst, forTopPanel);
	    forTopPanel.gridx = 1;
	    topPanel.add(idScroll, forTopPanel);
	    forTopPanel.gridx = 2;
	    topPanel.add(emailInst, forTopPanel);
	    forTopPanel.gridx = 3;
	    topPanel.add(emailScroll, forTopPanel);
	    
	    
	    //Ajout des checkbox au panneau haut-centrale (à l'interieur du panneau centrale)
	    gbc.weighty = 0.5;
	    gbc.gridy = 0;
	    centerTopPanel.add(categories, gbc);
		for(int i=0; i<6; i++) {
			gbc.gridy = i+1;
			centerTopPanel.add(boxCateg[i], gbc);
		}
		
		//Ajout des éléments au panneau haut
		gbc.gridy = 2;
		centerPanel.add(centerTopPanel, gbc);
		
		gbc.gridy = 3;
		gbc.weighty = 0.02;
		centerPanel.add(descriptionInst, gbc);
		
		gbc.gridy = 4;
		gbc.weighty = 0.2;
		centerPanel.add(scrollPane, gbc);
		
		gbc.gridy = 5;
		gbc.weighty = 0.1;
		centerPanel.add(butEnv, gbc);
		
		gbc.gridy = 0;
		gbc.weighty = 0.001;
		centerPanel.add(butIT, gbc);
		setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
	    if (e.getSource() == butEnv) {
	        // Ajoutez ici le code à exécuter lors du clic sur le bouton Envoyer
	    	System.out.println("butEnv");
	    	try {
	    		if(email.getText().contains("@") == true && email.getText().contains(".") == true && email.getText().contains(" ") == false ) {
	    			thisTicket.setCompteID(Integer.parseInt(id.getText()));
	    	    	thisTicket.setEmail(email.getText());
	    	    	thisTicket.setCategories(categTemp);
	    	    	thisTicket.setDescription(description.getText());
	    	    	thisTicket.systemeAffiche();
	    	    	//thisTicket.creerTicket();
	    	    	this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
	    		} else {
	    			invalidEntryStyle(descriptionInst);
	    			descriptionInst.setText("Insérez un adress courriel valide!");
	    			email.setBackground(Color.yellow);
	    		}
	    	
	    	} catch(NumberFormatException f) {
	    		descriptionInst.setText("Assurez-vous de remplir votre ID d'étudiant!");
	    		id.setBackground(Color.yellow);
	    		System.out.println("e");
	    	}
	    	
	    } else if (e.getSource() == butIT) {
	    	System.out.println("butIT");
			GUIit testing2 = new GUIit();
	    	this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
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
	 public void invalidEntryStyle (JTextPane text) {
			SimpleAttributeSet invalidEntry = new SimpleAttributeSet();
			StyleConstants.setBold(invalidEntry, true);
			StyleConstants.setFontSize(invalidEntry, 18);
			text.setCharacterAttributes(invalidEntry, true);
		}
/*
	 import org.apache.commons.validator.routines.EmailValidator;

	 public class Main {
	     public static void main(String[] args) {
	         EmailValidator validator = EmailValidator.getInstance();
	         boolean isValid = validator.isValid("example@domain.com");
	         System.out.println("Is valid: " + isValid);
	     }
	 }
*/
}