package exercice2.Exceptions;

public class NullCuveException extends NullPointerException {
    //CONSTRUCTEURS*****************************************************************************************************
    public NullCuveException(){
            }
    public NullCuveException(String msg){
        super("NullCuveException :"+msg);
    }

    //METHODES**********************************************************************************************************
    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
