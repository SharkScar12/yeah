import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GUIit extends JFrame implements ActionListener{
	JPanel rightPanel = new JPanel();
	JPanel topPanel = new JPanel();
	JPanel leftPanel = new JPanel();
	JPanel rightBottomPanel = new JPanel();
	JPanel leftTop = new JPanel();
	JButton left1 = new JButton();
	JButton left2 = new JButton();
	JButton left3 = new JButton();
	JButton left4 = new JButton();
	JButton left5 = new JButton();
	JTextPane test = new JTextPane();
	JTextPane description = new JTextPane();
	JTextArea notes = new JTextArea();
	JScrollPane scrollPane = new JScrollPane(notes);
	JLabel titreTicket = new JLabel();
	JButton confirmeResolution = new JButton();
	JLabel[] infos = new JLabel[6];
	JButton prochainepage = new JButton();
	JButton pageprecedente = new JButton();

	GridLayout baseGrid = new GridLayout(7,1);
	FlowLayout flowthing = new FlowLayout();
	
	TicketReparation thingy = new TicketReparation();
	TicketReparation ticket1 = new TicketReparation();
	TicketReparation ticket2 = new TicketReparation();
	TicketReparation ticket3 = new TicketReparation();
	TicketReparation ticket4 = new TicketReparation();
	TicketReparation ticket5 = new TicketReparation();
	TicketReparation[] tabTicekt = {ticket1, ticket2, ticket3, ticket4, ticket5};
	
	public int getTotalTicket() {
		int count = 0;

		try {
			BufferedReader reader = new BufferedReader(new FileReader("tickets.txt"));

			while (reader.readLine() != null) {
				count++;
			}

			reader.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		return count;
	}
	
//tabTicekt[0].lireTicketFichier("i6");
	int numTicket = 1;
	int ticketresolu = 0;
	int totalTickets;
	
	public GUIit () {
			super ("GUIit");
			setSize(500,500);
			getContentPane().setLayout(new GridLayout(1,2));
			this.add(leftPanel);
			this.add(rightPanel);
			rightPanel.setBackground(Color.yellow);
			rightBottomPanel.setBackground(Color.blue);
			rightBottomPanel.setLayout(new GridLayout(1,2));
			left3.setBackground(Color.RED);
			leftTop.setBackground(Color.green);
			leftPanel.setLayout(new GridLayout(6,1));
			leftPanel.add(leftTop);
			leftTop.setLayout(new GridLayout(1,2));
			leftTop.add(pageprecedente);
			pageprecedente.setText("Page précédente");
			leftTop.add(prochainepage);
			prochainepage.setText("Prochaine page");
			prochainepage.addActionListener(this);
			pageprecedente.addActionListener(this);
			leftPanel.add(left1);
			left1.setText("");
			left1.addActionListener(this);
			leftPanel.add(left2);
			left2.addActionListener(this);
			leftPanel.add(left3);
			left3.addActionListener(this);
			leftPanel.add(left4);
			left4.addActionListener(this);
			leftPanel.add(left5);
			left5.addActionListener(this);

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
			rightBottomPanel.add(scrollPane);
			rightBottomPanel.add(confirmeResolution);
			confirmeResolution.addActionListener(this);
			confirmeResolution.setText("Soummetre la résolution");
			rightPanel.add(rightBottomPanel);
			leftPanel.setBackground(Color.green);
			rightPanel.setBackground(Color.cyan);
			
			//Charger les 5 premiers billets de la page actuelle
			for (int i = 0; i < 5; i++) {
	            tabTicekt[i].lireTicketFicher("i" + (numTicket + i));
	        }
			totalTickets = getTotalTicket();
			System.out.println("DEBUG totalTickets = " + totalTickets + ", numTicket = " + numTicket);
			//texte des boutons à partir des billets chargés
			left1.setText(tabTicekt[0].getEmail() + " | " + tabTicekt[0].getDescription());
			left2.setText(tabTicekt[1].getEmail() + " | " + tabTicekt[1].getDescription());
			left3.setText(tabTicekt[2].getEmail() + " | " + tabTicekt[2].getDescription());
			left4.setText(tabTicekt[3].getEmail() + " | " + tabTicekt[3].getDescription());
			left5.setText(tabTicekt[4].getEmail() + " | " + tabTicekt[4].getDescription());
			
			updatePageButtons();
			
			setVisible(true);
			
			//initialize the tickets themselves in the buttons
	}
	//les Action Listeners pour sélectionner les tickets de l'affichage rapide
	public void actionPerformed (ActionEvent actionEvent ) {
		int i = 0;
		ticketresolu = 0;
		System.out.println(ticketresolu);
		String[] affichage = {"Problème d'alimentation : ", "Câble brisé : ","Écran brisé : ", "Batterie défectueuse : ", "Ne s'allume pas : ", "Problème logiciel : "};
		
		if (actionEvent.getSource() == left1) {
			//cheker si le ticket est résolu ou non
			if (tabTicekt[0].getAffichage() == 1) {
				boolean[] affiche = tabTicekt[0].getCategories();
				System.out.println(affiche[1]);
				for ( i = 0; i <6; i++) {
					infos[i].setText(String.valueOf(affichage[i] + affiche[i]));
				}
				description.setText(tabTicekt[0].getDescription());
				ticketresolu = numTicket;
				System.out.println(ticketresolu);
			} else {
				description.setText("Ticket Résolu");
			}
		}
		if (actionEvent.getSource() == left2) {
			if (tabTicekt[1].getAffichage() == 1) {
				boolean[] affiche = tabTicekt[1].getCategories();
				System.out.println(affiche[1]);
				for ( i = 0; i <6; i++) {
					infos[i].setText(String.valueOf(affichage[i] + affiche[i]));
				}
				description.setText(tabTicekt[1].getDescription());
				ticketresolu = numTicket + 1;
				System.out.println(ticketresolu);
			} else {
				description.setText("Ticket Résolu");
			}
		}
		if (actionEvent.getSource() == left3) {
			if (tabTicekt[2].getAffichage() == 1) {
				boolean[] affiche = tabTicekt[2].getCategories();
				System.out.println(affiche[1]);
				for ( i = 0; i <6; i++) {
					infos[i].setText(String.valueOf(affichage[i] + affiche[i]));
				}
				description.setText(tabTicekt[2].getDescription());
				ticketresolu = numTicket + 2;
				System.out.println(ticketresolu);
			} else {
				description.setText("Ticket Résolu");
			}
		}
		if (actionEvent.getSource() == left4) {
			if (tabTicekt[3].getAffichage() == 1) {
				boolean[] affiche = tabTicekt[3].getCategories();
				System.out.println(affiche[1]);
				for ( i = 0; i <6; i++) {
					infos[i].setText(String.valueOf(affichage[i] + affiche[i]));
				}
				description.setText(tabTicekt[3].getDescription());
				ticketresolu = numTicket + 3;
				System.out.println(ticketresolu);
			} else {
				description.setText("Ticket Résolu");
			}
		}
		if (actionEvent.getSource() == left5) {
			if (tabTicekt[4].getAffichage() == 1) {
				boolean[] affiche = tabTicekt[4].getCategories();
				System.out.println(affiche[1]);
				for ( i = 0; i <6; i++) {
					infos[i].setText(String.valueOf(affichage[i] + affiche[i]));
				}
				description.setText(tabTicekt[4].getDescription());
				ticketresolu = numTicket + 4;
				System.out.println(ticketresolu);
			} else {
				description.setText("Ticket Résolu");
			}
		}
		if (actionEvent.getSource() == prochainepage) {
			numTicket = numTicket + 5;
			
			for (int j = 0; j < 5; j++) {
                tabTicekt[j].lireTicketFicher("i" + (numTicket + j));
            }
			
			left1.setText(tabTicekt[0].getEmail() + " | " + tabTicekt[0].getDescription());
            left2.setText(tabTicekt[1].getEmail() + " | " + tabTicekt[1].getDescription());
            left3.setText(tabTicekt[2].getEmail() + " | " + tabTicekt[2].getDescription());
            left4.setText(tabTicekt[3].getEmail() + " | " + tabTicekt[3].getDescription());
            left5.setText(tabTicekt[4].getEmail() + " | " + tabTicekt[4].getDescription());
            updatePageButtons();
		}
		if (actionEvent.getSource() == pageprecedente) {

		    numTicket = numTicket - 5;

		    for (int j = 0; j < 5; j++) {
		        tabTicekt[j].lireTicketFicher("i" + (numTicket + j));
		    }

		    left1.setText(tabTicekt[0].getEmail() + " | " + tabTicekt[0].getDescription());
		    left2.setText(tabTicekt[1].getEmail() + " | " + tabTicekt[1].getDescription());
		    left3.setText(tabTicekt[2].getEmail() + " | " + tabTicekt[2].getDescription());
		    left4.setText(tabTicekt[3].getEmail() + " | " + tabTicekt[3].getDescription());
		    left5.setText(tabTicekt[4].getEmail() + " | " + tabTicekt[4].getDescription());

		    updatePageButtons();
		}
		if (actionEvent.getSource() == (confirmeResolution)) {
			tabTicekt[ticketresolu].setAffichage((byte) 0);
		}
	}
	public void afficheProbleme(int nombreTicket) {
		
		
		
		
	}
	
	private void updatePageButtons() {
		pageprecedente.setEnabled(numTicket > 1);                   // Activer seulement si ce n'est pas la première page
		prochainepage.setEnabled(numTicket + 5 <= totalTickets);     // Activer seulement si la page suivante existe
    }

}
	
