package org.hv;

import org.hv.core.Window;
import org.hv.core.renderer.Renderer;

public class Engine {
    private static final int WIDTH = 800, HEIGHT = 600;
    private static final String TITLE = "HalaVisca";

    private Window window = null;
    private Renderer renderer = null;

    public Engine() {
        window = new Window(WIDTH, HEIGHT, TITLE);
        renderer = new Renderer();
    }

    public void Run() {
        window.Show();
        while(window.IsOpen()) {
            window.Clear();

            renderer.Render();

            renderer.Update();
            window.Update();
        }
    }

    public void Cleanup() {
        renderer.Cleanup();
        window.Cleanup();
    }
}
