package exceptions;

public class WrongPartNumberException extends RuntimeException{
    public WrongPartNumberException(Integer m, Integer n) {
        super(String.format("Ожидалось %d частей, получили %d частей", m, n));
    }
}
