import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

public class TicketReparation extends CompteGUI {
/*
afficheInfo(boolean)
fermeTicket()
envoyerEmail() : String
*/

  private static int totalTicket;
  private String ticketID;
  private String description;
  private boolean[] categories;
  //0 est false et 1 est true
  private byte affichage;
  File fichierNoTicket;
  File fichierTickets;
  
  //Constructeurs de CompteGUI
  TicketReparation() {
    super();
    try {
    	fichierNoTicket = new File("ticketTotal.txt");
  		fichierTickets = new File("tickets.txt");
  		Scanner lecteurTotal = new Scanner(fichierNoTicket);
  		totalTicket = Integer.parseInt(lecteurTotal.next());
  		lecteurTotal.close();
    } catch (FileNotFoundException f) {
    	f.printStackTrace();
    	System.out.println("Fichier non-retrouver");
    }
    this.ticketID = "i0";
    this.description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.";
    this.categories = new boolean[] 
      {false, false, false, false, false, false, false, false};
    this.affichage = 0;
  }
  
  //Constructeur structuré de TicketReparation
  TicketReparation(String ticketE, int compteE, String emailE, String descriptionE, boolean[] categoriesE, byte afficheE) {
    super(compteE, emailE);
    try {
    	//Ouvre les fichiers nécéssairse et prend le nombre de tickets total
    	fichierNoTicket = new File("ticketTotal.txt");
    	fichierTickets = new File("tickets.txt");
    	Scanner lecteurTotal = new Scanner(fichierNoTicket);
    	totalTicket = Integer.parseInt(lecteurTotal.next());
    	lecteurTotal.close();
    } catch (FileNotFoundException f) {
    	f.printStackTrace();
    	System.out.println("Fichier non-retrouver");
    }
    
    this.ticketID = ticketE;
    this.description = descriptionE;
    this.categories = categoriesE;
    this.affichage = afficheE;
  }
  
  //Méthodes accesseurs et mutateurs
  //totalTicket
  public int getTotalTicket() {
    return totalTicket;
  }
  
  public void setTotalTicket(int ticketE) {
    totalTicket = ticketE;
  }
  
  public void upTotalTicket() {
    totalTicket++;
    try {
      PrintWriter writerTemp = new PrintWriter(new BufferedWriter(new FileWriter(fichierNoTicket)));
      writerTemp.println(totalTicket);
      writerTemp.close();
    } catch (IOException e) {
      System.out.println("Il y a eu une erreur.");
		    e.printStackTrace();
    }
    
  }
  
  //ticketID
  public String getTicketID() {
    return this.ticketID;
  }
  
  public void setTicketID(String ticketE) {
    this.ticketID = ticketE;
  }
  
  //description
  public String getDescription() {
    return this.description;
  }
  
  public void setDescription(String descriptionE) {
    this.description = descriptionE;
  }
  
  //categories
  public boolean[] getCategories() {
    return this.categories;
  }
  
  public void setCategories(boolean[] categoriesE) {
    this.categories = categoriesE;
  }
  //Méthode pour remplacer un index spécifique du tableau categories
  public void setCategories(boolean categorieE, int index) {
    this.categories[index] = categorieE;
  }
  
  //affichage
  public byte getAffichage() {
    return this.affichage;
  }
  
  public void setAffichage(byte affichageE) {
    this.affichage = affichageE;
    modifieAffichageFichier();
  }
  
  //Modification du byte d'affichage dans le fichier tickets.txt avec RandomAccessFile
  //Reference pour la classe RandomAccessFile : https://docs.oracle.com/javase/8/docs/api/java/io/RandomAccessFile.html
  public void modifieAffichageFichier() {
    try {
      RandomAccessFile raf = new RandomAccessFile(fichierTickets, "rw");
      String line;
      long lastPosition = 0;
      
      //Passe à travers tout les lignes du fichier jusqu'à ce qu'il trouve le bon ID de ticket
      while ((line = raf.readLine()) != null) {
        System.out.println(line);
        if (line.contains(ticketID)) {
        	String[] ticketLn = line.split(";");
            //Assure que l'ID trouver etait dans la section de ticketID
            if (ticketLn[0].equals(ticketID)) {
            	//Obtient le byte exacte du byte d'affichage
            	long offset = raf.getFilePointer() - 3;
            	//Met le pointeur au offset
            	raf.seek(offset);
            	char charRead = (char) raf.read();
            	System.out.println("Byte courant a offset " + offset + " : " + charRead);
            	raf.seek(offset);
            	//Si le byte lu était un 1 ou un 0 le byte change à l'autre, sinon il demeure inchanger (en cas d'erreurs)
            	if (charRead == '1') {
            		raf.write(48);
            	} else if (charRead == '0') {
            		raf.write(49);
            	} else {
            		System.out.println("Erreur, pointeur ne trouve pas le byte d'affichage");
            	}
            	//Retrouve le byte changer et sa ligne pour confirmer le changement
            	raf.seek(offset);
            	charRead = (char) raf.read();
            	System.out.println("Byte changer " + charRead);
            	line = raf.readLine();
            	System.out.println(line);
            	break; 
            }
        }
        lastPosition = raf.getFilePointer();
      }
      raf.close();
    
    } catch (FileNotFoundException f) {
      f.printStackTrace();
      System.out.println("Fichier non-trouvé");
    } catch (IOException e) {
      e.printStackTrace();
      System.out.println("IOException");
    }
    
  }

  //Méthode de recherche pour un ticket en particulier, retourne les information de la ligne spécifique auquel le ticket est stocké
  public String trouveTicketID (String tickID) {
    try {
      Scanner lecteurTicket = new Scanner(fichierTickets);
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
            lecteurTicket.close();
            return info;
          }
        }
      }
      lecteurTicket.close();
    } catch (FileNotFoundException f) {
    	f.printStackTrace();
      System.out.println("Fichier non-retrouver (Trouve ticketID)");
    }
    return "Ticket non-retrouver";
  }
  
  
  //Lit fichier pour initialiser un objet TicketReparation
  public void lireTicketFicher(String noTicket) {
    int noTick = Integer.parseInt(noTicket.substring(1));
    String[] tickLn = trouveTicketID(noTicket).split(";");
    boolean[] categ = new boolean[6];
    for (int i = 0; i < 6; i++) {
      categ[i] = Boolean.parseBoolean(tickLn[4+i]);
    }
    
    //Set les informations de l'objet courante aux informations lues
    super.setCompteID(Integer.parseInt(tickLn[1]));
    super.setEmail(tickLn[2]);
    this.ticketID = tickLn[0];
    this.description = tickLn[3];
    this.categories = categ;
    this.affichage = Byte.parseByte(tickLn[tickLn.length - 1]);
    //Affiche les nouvelles informations
    systemeAffiche();
  }
  
  public void creerTicket() {
    try {
      	//Écrit les informations dans tickets.txt
        upTotalTicket();
        File ficherTicket = new File("tickets.txt");
        PrintWriter monWriter = new PrintWriter(new BufferedWriter(new FileWriter(ficherTicket, true)));
        //Separe les valeurs du tableau de categories en un string du format "valeaur";"valeur";.... pour la documentation dans le fichier
        String categStr = "";
        for (int i = 0; i < categories.length; i++) {
          categStr += categories[i] + ";";
        }
        monWriter.println("i" + totalTicket + ";" + super.getCompteID() + ";" + super.getEmail() +  ";" + description + ";" + categStr + affichage);
        monWriter.close();
        System.out.println("Ecrit dans ticket.txt : i" + totalTicket + ";" + super.getCompteID() + ";" + super.getEmail() +  ";" + description + ";" + categStr + affichage);
          
    	} catch (IOException e) {
		    System.out.println("Il y a eu une erreur.");
		    e.printStackTrace();
		  }
  }
  
  public void systemeAffiche () {
	  System.out.println("Information du ticket : " + ticketID);
	  System.out.println("ID du compte : " + super.getCompteID() + "\nEmail du compte : " + super.getEmail() +  "\nDescription : " + description + "\nCategories : " + categories + "\nAffichage : " + affichage);
  }

}