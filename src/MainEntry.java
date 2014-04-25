import java.security.InvalidAlgorithmParameterException;

/**
 * Created by AshwinMohan on 18/04/14.
 */
public class MainEntry {

    public static void main(String arg []){
        try {
            DutchFlagAlgorithm.call();
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        }
    }
}
