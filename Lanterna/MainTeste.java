import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;

public class MainTeste{

    public static void main(String[] args) throws Exception {

        DefaultTerminalFactory factory = new DefaultTerminalFactory();
        factory.setForceAWTOverSwing(true);

        Screen screen = factory.createScreen();
        screen.startScreen();
        TextGraphics tg = screen.newTextGraphics();

        tg.setForegroundColor(TextColor.ANSI.GREEN);

        tg.putString(5, 5, "Olá Lanterna!");
        screen.refresh();

        Thread.sleep(5000);
        screen.stopScreen();
    }
}