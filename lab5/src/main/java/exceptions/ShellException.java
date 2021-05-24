package exceptions;

public class ShellException extends Exception{
    public ShellException(String msg){
        super("Catalog exception: " + msg);
    }
}
