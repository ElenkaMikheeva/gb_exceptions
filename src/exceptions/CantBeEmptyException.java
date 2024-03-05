package exceptions;

public class CantBeEmptyException extends RuntimeException{
    public CantBeEmptyException(String s){
        super(s);
    }
}
