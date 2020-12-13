package exercice2.Exceptions;

public class NullLiquideException extends NullPointerException{
    //CONSTRUCTEURS*****************************************************************************************************
    public NullLiquideException(){

    }
    public NullLiquideException(String msg){
        super("NullLiquideException :"+msg);
    }

    //METHODES**********************************************************************************************************
    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
