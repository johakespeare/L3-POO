package exercice2.Exceptions;

public class IllegalCapaciteException extends IllegalArgumentException {
    //CONSTRUCTEURS*****************************************************************************************************
    public IllegalCapaciteException(){

    }
    public IllegalCapaciteException(String msg){
        super("IllegalCapaciteException :"+msg);
    }

    //METHODES**********************************************************************************************************
    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
