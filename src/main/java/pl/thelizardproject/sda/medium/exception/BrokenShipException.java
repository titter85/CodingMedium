package pl.thelizardproject.sda.medium.exception;

/**
 * Created by Dominik on 06-07-2017.
 */
public class BrokenShipException extends Exception {
    public BrokenShipException(String name){
        super(name);
    }

    @Override
    public String getMessage() {
        return "The "+ super.getMessage() + " is broken";
    }
}
