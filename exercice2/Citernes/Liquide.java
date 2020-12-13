package exercice2.Citernes;

public enum Liquide {
    //ATTRIBUTS*********************************************************************************************************
    EAU(10),
    VIN(15),
    HUILE(9);

    public final int temperature;

    //CONSTRUCTEURS*****************************************************************************************************
    /**
     * Constructeur de l'énumération Liquide
     * @param temperature
     */
    Liquide(int temperature) {
        this.temperature = temperature;
    }
}
