package org.hv.core.renderer;

public class Renderer {
    private Shader mainShader = null;

    public Renderer() {
        mainShader = new Shader("assets/shaders/default.vert", "assets/shaders/default.frag");
    }

    public void Render() {
        mainShader.Bind();
    }

    public void Update() {

    }

    public void Cleanup() {
        mainShader.Cleanup();
    }

}
