package exercice2;

import exercice2.Citernes.Citerne;
import exercice2.Citernes.CiterneSecurisee;
import exercice2.Citernes.Liquide;
import exercice2.Exceptions.*;

import java.time.LocalDate;

public  class TestCiterne {

    public static void main(String[] args) {

        //-----------------CITERNES--------------------//
        //CREATION DE DIFFERENTES CITERNES******************************************************************************

        Citerne c1 = new Citerne(100, Liquide.EAU);
        Citerne c2 = new Citerne(50, Liquide.HUILE);
        Citerne c3 = new Citerne(10, Liquide.VIN);

        Citerne bisC2 = new Citerne(50, Liquide.HUILE);

        assert(c1.getNumero()==1):"le numero n'est pas égale à 1";
        assert(c2.getNumero()==2):"le numero n'est pas égale à 2";
        assert(c3.getNumero()==3):"le numero n'est pas égale à 3";
        assert(Citerne.getCompteur()==4):"le compteur ne marche pas";

        try{
        Citerne tropGrande = new Citerne(20001, Liquide.EAU);}
        catch(IllegalCapaciteException e){
            System.out.println(e.getMessage()) ;
        }

        try{
            Citerne tropPetite = new Citerne(0, Liquide.EAU);}
        catch(IllegalCapaciteException e){
            System.out.println(e.getMessage()) ;
        }

        try{
            Citerne nulle = new Citerne(0, null);}
        catch(NullLiquideException e){
            System.out.println(e.getMessage()) ;
        }



        //TEST COMPAREA*************************************************************************************************
        assert(c1.compareA(c2)==1):" le résultat n'est pas égale à 1";
        assert(c3.compareA(c1)==-1):" le résulat n'est pas égale à -1";
        assert(bisC2.compareA(c2)==0):" les citernes ne sont pas égales";

        try{
            c1.compareA(null);
        }catch(NullPointerException e){
            System.out.println(e.getMessage()) ;
        }

        try{
            Object o = new Object();
            c1.compareA(o);
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage()) ;
        }


        //TEST EQUALS ET SET LIQUIDE************************************************************************************

        assert(bisC2.equals(c2)):" les citernes ne sont pas égales";
        bisC2.setLiquide(Liquide.VIN);
        assert(!bisC2.equals(c2)):" les citernes  sont  égales";

        /*
        // compare des jours.. sauf qu'elles se créent le même jour...
        //TEST METHODE PLUS ANCIENNE************************************************************************************
        assert( Citerne.plusAncienne(c1,c2)==c1 ):"la citerne c2 est plus ancienne";
        assert( Citerne.plusAncienne(c2,c3)==c3 ):"la citerne c3 est plus ancienne";
        */

        //TEST GET QUANTITE*********************************************************************************************
        //+TEST ajouterLiquide Litre************************************************************************************
        assert( c1.getQuantite()==0):"la quantité est non nulle";
        assert( c2.getQuantite()==0):"la quantité est non nulle";
        assert( c3.getQuantite()==0):"la quantité est non nulle";
        c1.ajouterLiquide(100);
        c2.ajouterLiquide(17);
        c3.ajouterLiquide(2);

        try{
            bisC2.ajouterLiquide(51);
        }catch(IllegalAjoutException e){
            System.out.println(e.getMessage()) ;
        }

        try{
            bisC2.ajouterLiquide(-1);
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage()) ;
        }

        assert( c1.getQuantite()==100):"la quantité n'est pas égale à 100";
        assert( c2.getQuantite()==17):"la quantité n'est pas égale à 17";
        assert( c3.getQuantite()==2):"la quantité n'est pas égale à 2";

        //+TEST EnleverLiquide Litre************************************************************************************
        c1.enleverLiquide(100);
        c2.enleverLiquide(17);
        c3.enleverLiquide(2);


        try{
            bisC2.enleverLiquide(51);
        }catch(IllegalEnleverException e){
            System.out.println(e.getMessage()) ;
        }

        try{
            bisC2.enleverLiquide(-1);
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage()) ;
        }

        //+TEST AjouterLiquide pourcentage******************************************************************************
        assert( c1.getQuantite()==0):"la quantité est non nulle";
        assert( c2.getQuantite()==0):"la quantité est non nulle";
        assert( c3.getQuantite()==0):"la quantité est non nulle";
        c1.ajouterLiquide((double)1);
        c2.ajouterLiquide(0.2);
        c3.ajouterLiquide(0.6);

        try{
            bisC2.ajouterLiquide(-0.5);
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage()) ;
        }

        try{
            bisC2.ajouterLiquide((double)5825);
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage()) ;
        }

        assert( c1.getQuantite()==100):"la quantité n'est pas égale à 100";
        assert( c2.getQuantite()==10):"la quantité n'est pas égale à 10";
        assert( c3.getQuantite()==6):"la quantité n'est pas égale à 6";
        //+TEST enleverLiquide pourcentage******************************************************************************
        c1.enleverLiquide((double)1);
        c2.enleverLiquide(0.2);
        c3.enleverLiquide(0.6);

        try{
            bisC2.enleverLiquide(-0.5);
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage()) ;
        }

        try{
            bisC2.enleverLiquide((double)5825);
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage()) ;
        }

        assert( c1.getQuantite() == 0):"la quantité est non nulle";
        assert( c2.getQuantite() == 0):"la quantité est non nulle";
        assert( c3.getQuantite() == 0):"la quantité est non nulle";

        //TEST GET LIQUIDE**********************************************************************************************
        assert( c1.getLiquide() == Liquide.EAU):"le liquide n'est pas de l'eau";
        assert( c2.getLiquide() == Liquide.HUILE):"le liquide n'est pas de l'huile";
        assert( c3.getLiquide() == Liquide.VIN):"le liquide n'est pas du vin";

        //TEST GET DATE*************************************************************************************************
        LocalDate DateDuJour = LocalDate.now();

        assert( c1.getDate().isEqual(DateDuJour)):"c1 n'a pas la bonne date";
        assert( c2.getDate().isEqual(DateDuJour)):"c2 n'a pas la bonne date";
        assert( c3.getDate().isEqual(DateDuJour)):"c3 n'a pas la bonne date";



        //TEST Tostring*************************************************************************************************
        c1.ajouterLiquide((double)1);
        c2.ajouterLiquide(0.2);
        c3.ajouterLiquide(0.6);
        System.out.println(c1.toString());
        System.out.println(c2.toString());
        System.out.println(c3.toString());

//**********************************************************************************************************************

        //-----------------CITERNES SECURISEES--------------------//

        Citerne cuve1 = new Citerne(100, Liquide.EAU);
        Citerne cuve2 = new Citerne(50, Liquide.HUILE);


        CiterneSecurisee cs1=new CiterneSecurisee(120,Liquide.EAU,cuve1);
        CiterneSecurisee cs2=new CiterneSecurisee(120, Liquide.HUILE,cuve2);
        CiterneSecurisee bisCs2=new CiterneSecurisee(120, Liquide.HUILE,cuve2);

        try{
            CiterneSecurisee cs3=new CiterneSecurisee(120,Liquide.EAU,null);
        }catch(NullCuveException e){
            System.out.println(e.getMessage());
        }

        assert(Citerne.getCompteur()==10):"le compteur ne marche pas (classe CiterneSecurisée)";

        //TEST EQUALS***************************************************************************************************
        assert(cs2.equals(bisCs2)):"les citernes ne sont pas égales";
        assert(!cs2.equals(cs1)):"les citernes sont égales";

        //TEST SET******************************************************************************************************

        Citerne cuve3 = new Citerne(200, Liquide.EAU);
        cs1.setCuve(cuve3);
        assert(cs1.getCuve()==cuve3):"le set n'a pas fonctionné";

        try{System.out.println(cuve2);
        cs1.setCuve(cuve2);}
        catch(IllegalLiquideException e){
            System.out.println(e.getMessage());
        }

        try{
            cs1.setCuve(null);}
        catch(NullCuveException e){
            System.out.println(e.getMessage());
        }

        //TEST AJOUTER LIQUIDE LITRE************************************************************************************
        cs1.ajouterLiquide(150);
        assert(cs1.getCuve().getQuantite()==30):"la cuve n'a pas la bonne quantité";
        assert(cs1.getQuantite()==120):"la citerne n'a pas la bonne quantité";

        cs1.enleverLiquide(120);
        cs1.getCuve().enleverLiquide(30);
        assert(cs1.getCuve().getQuantite()==0):"la cuve n'a pas la bonne quantité";
        assert(cs1.getQuantite()==0):"la citerne n'a pas la bonne quantité";


        //TEST AJOUTER LIQUIDE *****************************************************************************************
        cs1.ajouterLiquide((double)1);
        assert(cs1.getQuantite()==120):"la citerne n'a pas la bonne quantité";
        cs1.ajouterLiquide(0.5);
        assert(cs1.getCuve().getQuantite()==60):"la cuve n'a pas la bonne quantité";
        assert(cs1.getQuantite()==120):"la citerne n'a pas la bonne quantité";


        try{
            cs2.ajouterLiquide(-25);;
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

        try{
            cs2.ajouterLiquide(300);
        }catch(IllegalAjoutException e){
            System.out.println(e.getMessage());
        }

        //TEST CLONAGE**************************************************************************************************
         System.out.println("test ghinevra");
         Citerne cuveClone = new Citerne(40,Liquide.EAU);
         CiterneSecurisee citerneClone= new CiterneSecurisee(120, Liquide.EAU, cuveClone);

        CiterneSecurisee clone= null;
        try {
            clone = (CiterneSecurisee)citerneClone.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        assert(citerneClone.equals(clone)):"le clonage s'est mal passé";

        //TEST TOSTRING*************************************************************************************************

        System.out.println(cs1.toString());
        System.out.println(cs2.toString());
        System.out.println(citerneClone.toString());




}
}