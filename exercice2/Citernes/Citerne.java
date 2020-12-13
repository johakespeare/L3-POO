package exercice2.Citernes;
import exercice1.EstComparable;
import exercice2.Exceptions.IllegalAjoutException;
import exercice2.Exceptions.IllegalCapaciteException;
import exercice2.Exceptions.IllegalEnleverException;
import exercice2.Exceptions.NullLiquideException;

import java.time.LocalDate;

public class Citerne implements EstComparable,Cloneable {

    //ATTRIBUTS*********************************************************************************************************
    protected static int compteur=0;
    protected int numero;
    protected int capacite;
    protected Liquide liquide;
    protected boolean clean=true;
    protected LocalDate date;
    protected int quantite;

    //CONSTRUCTEURS*****************************************************************************************************

    /**
     * constructeur de la classe Citerne
     * @param capacite
     * @param liquide
     */
    public Citerne(int capacite, Liquide liquide){
        if(liquide==null){
            throw new NullLiquideException("liquide est nul");
        }
        if(capacite <= 0 || capacite>20000) {
            throw new IllegalCapaciteException("Une capacité ne peut être négative ou supérieure à 20 000L");
        }
        this.capacite=capacite;
        this.date=LocalDate.now();
        this.quantite=0;
        setLiquide(liquide);
        compteur++;
        numero=compteur;
    }

    //SETTERS***********************************************************************************************************


    public void setLiquide(Liquide liquide) {
        if(liquide==null){
            throw new NullLiquideException("liquide est nul");
        }
        if (this.clean == false) {
            nettoyage();
        }
            this.liquide=liquide;
            this.clean = false;

    }


    //GETTERS***********************************************************************************************************


    public int getNumero() {
        return numero;
    }
    public int getCapacite() {
        return capacite;
    }
    public Liquide getLiquide() {
        return liquide;
    }
    public static int getCompteur() {
        return compteur;
    }
    public int getQuantite() {
        return quantite;
    }
    public LocalDate getDate(){
        return this.date;
    }

    //METHODES**********************************************************************************************************

    /**
     * methode qui nettoie la Cuve
     */
    public void nettoyage(){
        this.clean=true;
    }

    /**
     * methode qui retourne la plus ancienne citerne
     * @param citerneA
     * @param citerneB
     * @return Citerne
     */
    public static Citerne plusAncienne(Citerne citerneA, Citerne citerneB){
        Citerne retour=null;
        if (citerneA.date.isAfter(citerneB.date)){
            retour=citerneA;
        }else if (citerneB.date.isAfter(citerneA.date)){
            retour=citerneB;
        } return(retour);
    }

    //METHODES AJOUTER**************************************************************************************************

    /**
     * augmente la quantité de liquide selon un pourcentage compris entre 0 et 1
     * @param pourcentage
     */
    public void ajouterLiquide(double pourcentage){
       if((pourcentage<0 )|| (pourcentage>1)){
           throw new IllegalArgumentException("Le pourcentage entré doit être compris entre 0 et 1");
       }
       if ((this.quantite+capacite*pourcentage)>this.capacite){
           this.quantite=capacite;
           throw new IllegalAjoutException("Ca va déborder !");
       }
       this.quantite+=(int)(capacite*pourcentage);

    }

    /**
     * augmente la quantité de liquide selon le nombre de litres
     * @param litres
     */
    public void ajouterLiquide(int litres){
        if (litres < 0) {
            throw new IllegalArgumentException("On ajoute un volume positif !");
        }
        if(this.quantite+litres>capacite) {
            this.quantite=capacite;
            throw new IllegalAjoutException("Ca va déborder");
        }
        this.quantite+=litres;
    }

    //METHODES ENLEVER**************************************************************************************************

    /**
     * enleve la quantité de liquide selon un pourcentage compris entre 0 et 1
     * @param pourcentage
     */
    public void enleverLiquide(double pourcentage){
        int pourcentageBase=this.quantite/capacite;
        if(pourcentage<0 || pourcentage>1){
            throw new IllegalArgumentException("Le pourcentage entré doit être compris entre 0 et 1");
        }
       if ((this.quantite-capacite*pourcentage)<0){
            this.quantite=0;
            throw new IllegalEnleverException("Il n'y a pas assez de liquide,  il manque "+
                    (pourcentage-pourcentageBase)+" %");
        }
        this.quantite-=capacite*pourcentage;
    }

    /**
     * augmente la quantité de liquide selon les litres
     * @param litres
     */
    public void enleverLiquide(int litres){
        int quantiteBase=quantite;
        if (litres < 0) {
            throw new IllegalArgumentException("On ajoute un volume positif !");
        }
        if(this.quantite-litres<0) {
            this.quantite=0;
            throw new IllegalEnleverException("Il n'y a pas assez de liquide,  il manque "+ -(quantiteBase-litres) +" litres" );
        }
        this.quantite-=litres;
    }

    //METHODES INTERFACE ESTCOMPARABLE**********************************************************************************
    @Override
    public int compareA(Object o) {
        int retour = 0;
        if(o==null){
            throw new NullPointerException("l'objet est nul");
        }
        if (!(o instanceof Citerne)) {
            throw new IllegalArgumentException("On compare des citernes !");
        }
        Citerne c2 = (Citerne) o;
        if (this.quantite > c2.getQuantite()) {
            retour = 1;
        } else if (this.quantite < c2.getQuantite()) {
            retour = -1;
        } else {
            if (this.capacite > c2.getCapacite()) {
                retour = 1;
            } else if (this.capacite < c2.getCapacite()) {
                retour = -1;
            }

        }
        return (retour);
    }

    //METHODE CLONE*****************************************************************************************************
    public Object clone() throws CloneNotSupportedException  {
        Citerne c1=null;
        try {
            c1 = (Citerne) super.clone();
        }catch (CloneNotSupportedException e){
            throw new InternalError();
        }
        return c1;
    }

    //METHODES TOSTRING ET EQUALS***************************************************************************************
    @Override
    public boolean equals(Object obj){
        return(obj instanceof Citerne && ((Citerne) obj).capacite==this.capacite && ((Citerne) obj).date.equals(this.date) &&
                ((Citerne) obj).quantite==this.quantite && ((Citerne) obj).getLiquide()==this.getLiquide());
    }

    @Override
    public String toString(){
        return("Citerne n° "+ this.numero +", "+ this.liquide+ ", capacité : "+this.capacite+
                " m3 , mise en service : "+ this.date + ", volume occupé : "+ this.quantite );

    }






}
