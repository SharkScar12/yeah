public class TicketReparation extends CompteGUI {
/*
afficheInfo(boolean)
fermeTicket()
envoyerEmail() : String
*/

  private static int totalTicket;
  private int ticketID;
  private String description;
  private boolean[] categories;
  private boolean affichage;
  
  //Constructeurs de CompteGUI
  TicketReparation() {
    super();
    this.totalTicket++;
    this.ticketID = totalTicket;
    this.description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.";
    this.categories = new boolean[] 
      {false, false, false, false, false, false, false, false};
    this.affichage = true;
  }
  
  TicketReparation(int compteE, String emailE, String descriptionE, boolean[] categoriesE) {
    super(compteE, emailE);
    this.totalTicket++;
    this.ticketID = totalTicket;
    this.description = descriptionE;
    this.categories = categoriesE;
    this.affichage = true;
  }
  
  //Méthodes accesseurs et mutateurs
  //totalTicket
  public int getTotalTicket() {
    return this.totalTicket;
  }
  
  public void setTotalTicket(int ticketE) {
    this.totalTicket = ticketE;
  }
  
  //ticketID
  public int getTicketID() {
    return this.ticketID;
  }
  
  public void setTicketID(int ticketE) {
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


}