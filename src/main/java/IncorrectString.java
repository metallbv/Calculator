/**
 * Created by v.babiak on 18.05.2016.
 */
public class IncorrectString extends Exception{

    public IncorrectString(String message) {
        super("Incorrect expression: " + message);
    }

}
