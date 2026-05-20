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
			setSize(600,500);
			getContentPane().setLayout(new GridLayout(1,2));
			this.add(leftPanel);
			this.add(rightPanel);
			
			
			//rightPanel.setBackground(new Color(177, 204, 230));
			//description.setBackground(new Color(177, 204, 230));
			
			
			rightBottomPanel.setLayout(new GridLayout(1,2));		
			
			
			leftPanel.setLayout(new GridLayout(6,1));
			leftPanel.add(leftTop);
			//leftTop.setLayout(new FlowLayout());
			leftTop.setLayout(new GridLayout(1,2));
			
			leftTop.add(pageprecedente);
			pageprecedente.setText("<--");
			pageprecedente.addActionListener(this);
			pageprecedente.setFont(new Font("HelveticaNeue", Font.BOLD, 25));
			pageprecedente.setBackground(new Color(24, 55, 84));
		    pageprecedente.setForeground(Color.WHITE);
			
			leftTop.add(prochainepage);
			prochainepage.setText("-->");
			prochainepage.addActionListener(this);
			prochainepage.setFont(new Font("HelveticaNeue", Font.BOLD, 25));
			prochainepage.setBackground(new Color(24, 55, 84));
		    prochainepage.setForeground(Color.WHITE);

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
	        
	        rightBottomPanel.setLayout(new GridLayout(1,2));
	        rightBottomPanel.add(scrollPane);
	        rightBottomPanel.add(confirmeResolution);
	        
	        confirmeResolution.addActionListener(this);
	        confirmeResolution.setText("Résolu");
	        confirmeResolution.setBackground(new Color(24, 55, 84));
		    confirmeResolution.setForeground(Color.WHITE);
	        
	        rightPanel.add(rightBottomPanel);
			
			//Charger les 5 premiers billets de la page actuelle
			totalTickets = getTotalTicket();
			System.out.println("DEBUG totalTickets = " + totalTickets + ", numTicket = " + numTicket);
			
			//charger au plus 5 tickets, mais seulement jusqu’au dernier ticket existant
			int toLoad = Math.min(5, totalTickets - numTicket + 1); //Calcule le nombre de billets disponibles sur cette page (entre 1 et 5), essay pas de charger un billet qui n'existe pas
			
			for (int i = 0; i < 5; i++) { // on garde toujours 5 tickets dans le tableau
				if (i < toLoad) { //seulement les tickets existants
		            tabTicekt[i].lireTicketFicher("i" + (numTicket + i));
		        } else { //tickets invalides / inexistants → on met un ticket vide par défaut
		            tabTicekt[i].setEmail("");
		            tabTicekt[i].setDescription("");
		            tabTicekt[i].setAffichage((byte) 0);
		        }
	        }
			
			//texte des boutons à partir des billets chargés
			left1.setText("<html>" + tabTicekt[0].getEmail() + "<br> | " + tabTicekt[0].getDescription() + "</html>");
			left2.setText("<html>" + tabTicekt[1].getEmail() + "<br> | " + tabTicekt[1].getDescription() + "</html>" );
			left3.setText("<html>" + tabTicekt[2].getEmail() + "<br> | " + tabTicekt[2].getDescription() + "</html>");
			left4.setText("<html>" + tabTicekt[3].getEmail() + "<br> | " + tabTicekt[3].getDescription() + "</html>");
			left5.setText("<html>" + tabTicekt[4].getEmail() + "<br> | " + tabTicekt[4].getDescription() + "</html>");
			
			updatePageButtons();
			
			setVisible(true);
			
			//initialize the tickets themselves in the buttons
	}
	//les Action Listeners pour sélectionner les tickets de l'affichage rapide
	public void actionPerformed (ActionEvent actionEvent ) {
		int i = 0;
		
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
				ticketresolu = 0;
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
				ticketresolu = 0;
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
				ticketresolu = 0;
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
				ticketresolu = 0;
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
				ticketresolu = 0;
				ticketresolu = numTicket + 4;
				System.out.println(ticketresolu);
			} else {
				description.setText("Ticket Résolu");
			}
		}
		if (actionEvent.getSource() == prochainepage) {
			numTicket = numTicket + 5;
			
			//refacturer le chargement de la page pour gérer les moins de 5 tickets
			totalTickets = getTotalTicket();
			int toLoad = Math.min(5, totalTickets - numTicket + 1);
			for (int j = 0; j < 5; j++) {
				if (j < toLoad) {
					tabTicekt[j].lireTicketFicher("i" + (numTicket + j));
				} else { 
					tabTicekt[j].setEmail("");
					tabTicekt[j].setDescription("Aucun ticket");
					//problème que les ticket non-résolus son affichés comme résolus après avoir changé de page
					//tabTicekt[j].setAffichage((byte) 0);
				}
			}
			
			left1.setText("<html>" + tabTicekt[0].getEmail() + "<br> | " + tabTicekt[0].getDescription() + "</html>");
			left2.setText("<html>" + tabTicekt[1].getEmail() + "<br> | " + tabTicekt[1].getDescription() + "</html>" );
			left3.setText("<html>" + tabTicekt[2].getEmail() + "<br> | " + tabTicekt[2].getDescription() + "</html>");
			left4.setText("<html>" + tabTicekt[3].getEmail() + "<br> | " + tabTicekt[3].getDescription() + "</html>");
			left5.setText("<html>" + tabTicekt[4].getEmail() + "<br> | " + tabTicekt[4].getDescription() + "</html>");
            updatePageButtons();
		}
		if (actionEvent.getSource() == pageprecedente) {

		    numTicket = numTicket - 5;

		    //même logique pour la page précédente
		    totalTickets = getTotalTicket();
			int toLoad = Math.min(5, totalTickets - numTicket + 1);
			for (int j = 0; j < 5; j++) {
				if (j < toLoad) {
					tabTicekt[j].lireTicketFicher("i" + (numTicket + j));
				} else { 
					tabTicekt[j].setEmail("");
					tabTicekt[j].setDescription("Aucun ticket");
					//problème que les ticket non-résolus son affichés comme résolus après avoir changé de page
					//tabTicekt[j].setAffichage((byte) 0);

				} 
			}

			left1.setText("<html>" + tabTicekt[0].getEmail() + "<br> | " + tabTicekt[0].getDescription() + "</html>");
			left2.setText("<html>" + tabTicekt[1].getEmail() + "<br> | " + tabTicekt[1].getDescription() + "</html>" );
			left3.setText("<html>" + tabTicekt[2].getEmail() + "<br> | " + tabTicekt[2].getDescription() + "</html>");
			left4.setText("<html>" + tabTicekt[3].getEmail() + "<br> | " + tabTicekt[3].getDescription() + "</html>");
			left5.setText("<html>" + tabTicekt[4].getEmail() + "<br> | " + tabTicekt[4].getDescription() + "</html>");

		    updatePageButtons();
		}
		if (actionEvent.getSource() == (confirmeResolution)) {
			
			
			if (ticketresolu >= 1 && ticketresolu <= totalTickets) {
				tabTicekt[ticketresolu - numTicket].setAffichage((byte)0);
				description.setText("Ticket Résolu");
			}
		}
	}
	public void afficheProbleme(int nombreTicket) {
		
		
		
		
	}
	
	private void updatePageButtons() {
		pageprecedente.setEnabled(numTicket > 1); // Activer seulement si ce n'est pas la première page
		prochainepage.setEnabled(numTicket + 5 - 1 < totalTickets);
		//on veut qu’on puisse aller à la page suivante si *au moins un ticket existe* après ces 5
	}

}
	
