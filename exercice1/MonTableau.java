public class MonTableau implements estComparable {
    private int[] tab;

    // CONSTRUCTEUR

    /**
     *
     * @param tab d'entiers
     */
    public MonTableau(int [] tab){
        this.tab= tab;
    }


    //METHODES

    /**
     * fonction qui compare la somme des MonT ableau
     * @param o un objet
     * @return int result
     */
    @Override
    public int compareA(Object o) {
        int result = 0;
        int sommeX= somme();

        if(o == null){
            throw new NullPointerException("L'objet est null");
        }
        if(o instanceof MonTableau == false){
            throw new IllegalArgumentException("l'objet n'est pas un Mont ableau");
        }
        else{
            MonTableau tab2 = (MonTableau)o;
            int sommeY = tab2.somme();

            if(sommeX>sommeY){
                result = 1;
            }
            else if(sommeX<sommeY){
                result = -1;
            }

        }

        return result;
    }

    /**
     *
     * @return somme du Mont ableau
     */
    private int somme(){
        int somme=0;
        int taille = tab.length;
        for(int i=0;i<taille;i++){
            somme+=tab[i];
        }
        return somme;
    }

public static void main(String[]args){
    // test sum(a)>sum(b)
    int[] a = new int[] {1,2,3,4};
    int[] b = new int[] {-1,2,-3,4,5};
    MonTableau m1=new MonTableau(a);
    MonTableau m2=new MonTableau(b);
    System.out.println(m1.compareA(m2));

   // test sum(c)=sum(d)
    int[] c = new int[] {-1,2,-3,5,4};
    int[] d = new int[] {-1,2,-3,4,5};
    MonTableau m3=new MonTableau(c);
    MonTableau m4=new MonTableau(d);
    System.out.println(m3.compareA(m4));

    // test sum(f)>sum(e)
    int[] e = new int[] {1,2,3,4,12,13,15};
    int[] f = new int[] {-1,2,-3,4,5};
    MonTableau m5=new MonTableau(e);
    MonTableau m6=new MonTableau(f);
    System.out.println(m6.compareA(m5));

    //test mauvais objet
    System.out.println(m6.compareA("mauvais objet"));
    //test null
    System.out.println(m6.compareA(null));


}
}
