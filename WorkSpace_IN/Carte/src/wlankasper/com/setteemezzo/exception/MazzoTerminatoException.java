package wlankasper.com.setteemezzo.exception;

public class MazzoTerminatoException extends Exception {

    public MazzoTerminatoException() {
        super("Mazzo Terminato!!!");
    }

    public MazzoTerminatoException(String msg) {
        super(msg);
    }
}