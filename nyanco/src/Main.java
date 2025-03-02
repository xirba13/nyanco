/*
 * Main.java
 *
 * DATE : 2025/01/11 13:17
 */
import com.nttdocomo.ui.IApplication;
import com.nttdocomo.ui.Display;
import com.nttdocomo.ui.Panel;
import com.nttdocomo.ui.Frame;


/**
 * Main
 *
 * @author NAME
 */
public class Main extends IApplication
{
    public void start() {
        final MyCanvas myCanvas = new MyCanvas();
        Display.setCurrent((Frame)myCanvas);
        new Thread(myCanvas).start();
    }
}

