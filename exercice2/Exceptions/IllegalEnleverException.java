package exercice2.Exceptions;

public class IllegalEnleverException extends IllegalArgumentException {

    //CONSTRUCTEURS*****************************************************************************************************

    public IllegalEnleverException() {
    }

    public IllegalEnleverException(String msg){
        super("IllegalEnleverException :"+msg);
    }


    //METHODES**********************************************************************************************************
    @Override
    public String getMessage() {
        return  super.getMessage();
    }
}
