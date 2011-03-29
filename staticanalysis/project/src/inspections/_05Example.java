package inspections;


import java.awt.*;

public class _05Example {

    Frame makeFrame(int height, int width) {
        Frame frame = new Frame();
        frame.setSize(height, width);
        return frame;
    }

    Rectangle makeRectangle() {
        int x = 0;
        int y = 0;
        return new Rectangle(y, x, 20, 20);
    }
}
