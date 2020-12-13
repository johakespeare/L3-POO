package exercice2.Citernes;

import exercice2.Exceptions.IllegalLiquideException;
import exercice2.Exceptions.NullCuveException;

public class CiterneSecurisee extends Citerne implements Cloneable{

    //ATTRIBUTS*********************************************************************************************************
    private Citerne cuve;

    //CONSTRUCTEURS*****************************************************************************************************

    /**
     * Constructeur de la classe Citerne Sécurisée
     * @param capacite
     * @param liquide
     * @param cuve
     */
    public CiterneSecurisee(int capacite, Liquide liquide, Citerne cuve) {
        super(capacite, liquide);
        if(cuve==null){
            throw new NullCuveException("la cuve est nulle");
        }
        if(cuve.getLiquide() != liquide){
            this.cuve = new Citerne((int)(this.capacite / 10), this.liquide);
        }

       else{
        this.cuve=cuve;}


    }

    //SETTERS***********************************************************************************************************

    public void setCuve(Citerne cuve){
        if(cuve==null){
            throw new NullCuveException("la cuve est nulle");
        }
        if(cuve.getLiquide()!=this.liquide ){
            throw new IllegalLiquideException("la cuve doit contenir le même liquide ");
        }
        this.cuve=cuve;
    }

    //GETTERS***********************************************************************************************************
    public Citerne getCuve() {
        return (this.cuve);
    }

    //METHODES**********************************************************************************************************

    @Override
    public void ajouterLiquide(double pourcentage) {
        if (pourcentage < 0 || pourcentage > 1) {
            throw new IllegalArgumentException("Le pourcentage entré doit être compris entre 0 et 1");
        }
        double volumeVoulu = this.quantite + this.capacite * pourcentage;
        if ((volumeVoulu) > this.capacite) {
            this.quantite = this.capacite;
            this.cuve.ajouterLiquide((int) volumeVoulu - this.capacite);
            System.err.println("attention la citerne est pleine!");
            cuveMoitieRemplie();
        }
        else{
        this.quantite += (int)( capacite * pourcentage);}

    }

    @Override
    public void ajouterLiquide(int litres) {
        if (litres < 0) {
            throw new IllegalArgumentException("On ajoute un volume positif !");
        }
        double volumeVoulu = this.quantite + litres;

        if(volumeVoulu>capacite) {
            this.quantite=capacite;
            System.err.println("attention la citerne est pleine!");
            this.cuve.ajouterLiquide((int) volumeVoulu - this.capacite);
            cuveMoitieRemplie();
        }
        else{
        this.quantite+=litres;}

    }

    /**
     * methode qui affiche un message d'erreur dans la console si la vue est à moitiée remplie
     */

    private void cuveMoitieRemplie(){
        if (this.cuve.getQuantite() >= this.cuve.getCapacite() / 2) {
            System.err.println("La cuve de à moitié pleine ! Vidange conseillée");
        }
    }

    //METHODE CLONE*****************************************************************************************************

    public Object clone() throws CloneNotSupportedException{
        CiterneSecurisee clone=null;
        clone = (CiterneSecurisee) super.clone();
        clone.cuve = (Citerne) this.cuve.clone();

        return clone;
    }


    //METHODES TO STRING ET EQUALS**************************************************************************************
    public String toString() {
        return super.toString() + "cuve de remplissage : " + this.cuve.toString();
    }

    public boolean equals(Object o) {
           return (super.equals(o)) && o instanceof CiterneSecurisee && cuve.equals(((CiterneSecurisee) o).getCuve());

    }

}
