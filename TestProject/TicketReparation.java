import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.FileNotFoundException;

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
  private boolean affichage;
  File ficherNoTicket;
  
  //Constructeurs de CompteGUI
  TicketReparation() {
    super();
    try {
      ficherNoTicket = new File("ticketTotal.txt");
      Scanner lecteurTotal = new Scanner(ficherNoTicket);
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
    this.affichage = true;
  }
  //blyat
  TicketReparation(String ticketE, int compteE, String emailE, String descriptionE, boolean[] categoriesE, boolean afficheE) {
    super(compteE, emailE);
    try {
      ficherNoTicket = new File("ticketTotal.txt");
      Scanner lecteurTotal = new Scanner(ficherNoTicket);
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
      PrintWriter writerTemp = new PrintWriter(new BufferedWriter(new FileWriter(ficherNoTicket)));
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
  public boolean getAffichage() {
    return this.affichage;
  }
  
  public void setAffichage(boolean affichageE) {
    this.affichage = affichageE;
  }

  public void systemeAffiche () {
    System.out.println("Information du ticket : " + ticketID);
    System.out.println("ID du compte : " + super.getCompteID() + "\nEmail du compte : " + super.getEmail() +  "\nDescription : " + description + "\nCategories : " + categories);
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
        monWriter.println("i" + totalTicket + ";" + super.getCompteID() + ";" + super.getEmail() +  ";" + description + ";" + categStr + true);
        monWriter.close();
        System.out.println("Ecrit dans ticket.txt : i" + totalTicket + ";" + super.getCompteID() + ";" + super.getEmail() +  ";" + description + ";" + categories + true);
          
    	} catch (IOException e) {
		    System.out.println("Il y a eu une erreur.");
		    e.printStackTrace();
		  }
  }

}