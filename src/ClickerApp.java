import de.ur.mi.oop.app.GraphicsApp;
import de.ur.mi.oop.events.MousePressedEvent;
import de.ur.mi.oop.graphics.Circle;
import de.ur.mi.oop.launcher.GraphicsAppLauncher;

import java.util.ArrayList;

public class ClickerApp extends GraphicsApp implements AppConfig {

    private ArrayList<Circle> marks;

    @Override
    public void initialize() {
        setFrameRate(FRAME_RATE);
        setCanvasSize(CANVAS_WIDTH, CANVAS_HEIGHT);
        marks = new ArrayList<Circle>();
    }

    @Override
    public void draw() {
        drawBackground(BACKGROUND_COLOR);
        for(Circle mark: marks) {
            mark.draw();
        }
    }

    private void addNewMark(int x, int y) {
        Circle mark = new Circle(x, y, MARK_SIZE, MARK_COLOR);
        marks.add(mark);
    }

    @Override
    public void onMousePressed(MousePressedEvent event) {
        addNewMark(event.getXPos(), event.getYPos());
    }

    public static void main(String[] args) {
        GraphicsAppLauncher.launch();
    }

}
