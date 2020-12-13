package exercice2.Exceptions;

public class IllegalAjoutException extends IllegalArgumentException{

    //CONSTRUCTEURS*****************************************************************************************************

    public IllegalAjoutException(){
    }

    public IllegalAjoutException(String msg){
        super("IllegalAjoutException :"+msg);
    }

    //METHODES**********************************************************************************************************
    @Override
    public String getMessage() {
        return super.getMessage();
    }


}
