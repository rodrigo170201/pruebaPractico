import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Consola {
    private static final Logger logg = LogManager.getLogger(Consola.class);
    public static void main(String[] args) {
        logg.debug("Hi world");
        /*logg.debug("Hi world");
        logg.info("Hi world");*/
        Ventana v = new Ventana();
    }
}
