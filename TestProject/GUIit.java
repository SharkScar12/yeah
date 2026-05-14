import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class GUIit extends JFrame implements ActionListener{
	JPanel rightPanel = new JPanel();
	JPanel topPanel = new JPanel();
	JPanel leftPanel = new JPanel();
	JPanel rightBottomPanel = new JPanel();
	JButton leftTop = new JButton();
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

	GridLayout baseGrid = new GridLayout(7,1);
	FlowLayout flowthing = new FlowLayout();
	
	TicketReparation thingy = new TicketReparation();
	TicketReparation ticket1 = new TicketReparation();
	TicketReparation ticket2 = new TicketReparation();
	TicketReparation ticket3 = new TicketReparation();
	TicketReparation ticket4 = new TicketReparation();
	TicketReparation ticket5 = new TicketReparation();
	TicketReparation[] tabTicekt = {ticket1, ticket2, ticket3, ticket4, ticket5};
//tabTicekt[0].lireTicketFichier("i6");
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
			leftPanel.add(left1);
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
			infos[0].setText("Problème d'alimentation : ");
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
			setVisible(true);
			
			//initialize the tickets themselves in the buttons
	}

	public void actionPerformed (ActionEvent actionEvent ) {
		int i = 0;
		String[] affichage = {"Problème d'alimentation : ", "Câble brisé : ","Écran brisé : ", "Batterie défectueuse : ", "Ne s'allume pas : ", "Problème logiciel : "};
		if (actionEvent.getSource() == left1) {
			ticket1.lireTicketFicher ("i1");
			boolean[] affiche = ticket1.getCategories();
			System.out.println(affiche[1]);
			for ( i = 0; i <6; i++) {
				infos[i].setText(String.valueOf(affichage[i] + affiche[i]));
			}
			description.setText(ticket1.getDescription());
		}
		if (actionEvent.getSource() == left2) {
			ticket2.lireTicketFicher ("i2");
			boolean[] affiche = ticket2.getCategories();
			System.out.println(affiche[1]);
			for ( i = 0; i <6; i++) {
				infos[i].setText(String.valueOf(affichage[i] + affiche[i]));
			}
			description.setText(ticket2.getDescription());
		}
		if (actionEvent.getSource() == left3) {
			ticket3.lireTicketFicher ("i3");
			boolean[] affiche = ticket3.getCategories();
			System.out.println(affiche[1]);
			for ( i = 0; i <6; i++) {
				infos[i].setText(String.valueOf(affichage[i] + affiche[i]));
			}
			description.setText(ticket3.getDescription());
		}
		if (actionEvent.getSource() == left4) {
			ticket4.lireTicketFicher ("i4");
			boolean[] affiche = ticket4.getCategories();
			System.out.println(affiche[1]);
			for ( i = 0; i <6; i++) {
				infos[i].setText(String.valueOf(affichage[i] + affiche[i]));
			}
			description.setText(ticket4.getDescription());
		}
		if (actionEvent.getSource() == left5) {
			ticket5.lireTicketFicher ("i5");
			boolean[] affiche = ticket5.getCategories();
			System.out.println(affiche[1]);
			for ( i = 0; i <6; i++) {
				infos[i].setText(String.valueOf(affichage[i] + affiche[i]));
			}
			description.setText(ticket4.getDescription());
		}
	}

}
	
