public class CompteGUI {
  private int compteID;
  private String email;
  
  //Constructeurs de CompteGUI
  CompteGUI() {
    this.compteID = 00000;
    this.email = "bonjour@gmail.com";
  }
  
  CompteGUI(int compteE, String emailE) {
    this.compteID = compteE;
    this.email = emailE;
  }
  
  //Méthodes accesseurs et mutateurs
  //compteID
  public int getCompteID() {
    return this.compteID;
  }
  
  public void setCompteID(int compteE) {
    this.compteID = compteE;
  }
  
  //email
  public String getEmail() {
    return this.email;
  }
  
  public void setEmail(String emailE) {
    this.email = emailE;
  }

}