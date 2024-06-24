package interpreter.exception;

public class InvalidID extends RuntimeException{
    public InvalidID(String msg){
        super(msg);
    }
}
