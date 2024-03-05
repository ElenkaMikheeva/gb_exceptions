package exceptions;

public class WrongGender extends RuntimeException{
    public WrongGender(String s){
        super(s);
    }
}
