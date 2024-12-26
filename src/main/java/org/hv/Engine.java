package org.hv;

import org.hv.core.Window;

public class Engine {
    private static final int WIDTH = 800, HEIGHT = 600;
    private static final String TITLE = "HalaVisca";

    private Window window = null;

    public Engine() {
        window = new Window(WIDTH, HEIGHT, TITLE);
    }

    public void Run() {
        window.Show();
        while(window.IsOpen()) {
            window.Clear();



            window.Update();
        }
    }

    public void Cleanup() {
        window.Cleanup();
    }
}
