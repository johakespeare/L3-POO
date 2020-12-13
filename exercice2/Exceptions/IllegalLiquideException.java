package exercice2.Exceptions;

public class IllegalLiquideException extends IllegalArgumentException {
    //CONSTRUCTEURS*****************************************************************************************************
    public IllegalLiquideException(){
         }
    public IllegalLiquideException(String msg){
        super("IllegalLiquideException :"+msg);
    }

    //METHODE***********************************************************************************************************
    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
