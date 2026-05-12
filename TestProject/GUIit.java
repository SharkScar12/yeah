import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class GUIit extends JFrame {
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
	JTextPane description = new JTextPane();
	JTextArea notes = new JTextArea();
	JScrollPane scrollPane = new JScrollPane(notes);
	JLabel titreTicket = new JLabel();
	JButton confirmeResolution = new JButton();
	JTextPane[] infos = new JTextPane[6];

	GridLayout baseGrid = new GridLayout(7,1);
	FlowLayout flowthing = new FlowLayout();
	
	public GUIit () {
		super ("GUIit");
		setSize(500,500);
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
		GridBagConstraints gbc = new GridBagConstraints();
		this.add(leftPanel);
		this.add(rightPanel);
		gbc.fill = GridBagConstraints.BOTH;
	    gbc.weightx = 0.5;
	    gbc.weighty = 0.5;
	    gbc.gridx = 0;
	    gbc.gridy = 0;
		/*rightPanel.setLayout(new GridBagLayout());
		rightPanel.add(rightRightTopPanel, gbc);
		gbc.gridy = 1;
		gbc.weighty = 0.15;*/
		rightBottomPanel.setBackground(Color.blue);
		rightBottomPanel.setLayout(new GridLayout(1,2));
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
		
	    /*RightTopPanel.setBackground(Color.yellow);
		rightTopPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
		for(int i = 0; i<6; i++) {
			infos[i] = new JTextPane();
		}
		infos[0].setText("1");
		infos[1].setText("2");
		infos[2].setText("3");
		infos[3].setText("4");
		infos[4].setText("5");
		infos[5].setText("6");
		for(int i = 0; i<6; i++) {
			rightTopPanel.add(infos[i]);
		}

		
		description.setEditable(false);
		rightTopPanel.add(description);
		notes.setLineWrap(true);
		rightBottomPanel.add(scrollPane);
		rightBottomPanel.add(confirmeResolution);*/
		leftPanel.setBackground(Color.green);
		rightPanel.setBackground(Color.cyan);
		setVisible(true);
	}
	
	//Lit fichier pour initialiser un objet TicketReparation
	  public void lireTicketFicher(String noTicket) {
	    int noTick = Integer.parseInt(noTicket.substring(1));
	    String[] tickLn = trouveTicketID(noTicket, "").split(";");
	    boolean[] categ = new boolean[boxCateg.length];
	    for (int i = 0; i < boxCateg.length; i++) {
	      categ[i] = Boolean.parseBoolean(tickLn[4+i]);
	    }
	    //Créer nouveau objet avec info
	    TicketReparation temp = new TicketReparation(tickLn[0], Integer.parseInt(tickLn[1]), tickLn[2], tickLn[3], categ, Byte.parseByte(tickLn[tickLn.length - 1]));
	    temp.systemeAffiche();
	  }
	
	//Méthode de recherche pour un ticket en particulier, retourne les information de la ligne spécifique auquel le ticket est stocké
	  //Variable output contient sois "offset" ou quelque chose d'autre pour déterminer la valeur retournée (offset retourne la valeur du dernier byte de la ligne sous forme String, sinon il retourne la ligne du ticket)
	public String trouveTicketID (String tickID, String output) {
	    try {
	      File monFichier = new File("Temp/ticket2.txt");
	      Scanner lecteurTicket = new Scanner(monFichier);
	      boolean trouver = false;
	      
	      while ((lecteurTicket.hasNextLine()) && (trouver == false)) { 
	        String info = lecteurTicket.nextLine(); 
	        //Detection de l'ID du ticket dans la ligne complete
	        if (info.contains(tickID)) { 
	          System.out.println("Found match: " + info); 
	          String[] ticketLn = info.split(";");
	          //Assure que l'ID trouver etait dans la section de ticketID
	          if (ticketLn[0].equals(tickID)) {
	            trouver = true;
	            if (output.equals("offset")) {
	              long offset = lecteurTicket.getFilePointer();
	              offset += info.length();
	              return (String) offset; 
	            } else {
	              lecteurTicket.close();
	              return info;
	            }
	          }
	        }
	      }
	    } catch (FileNotFoundException f) {
	      f.printStackTrace();
	      System.out.println("Fichier non-retrouver (Trouve ticketID)");
	    }
	    return "Non-retrouver";
	  }
	
	
}