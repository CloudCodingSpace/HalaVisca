package org.hv.core.renderer;

import org.hv.core.Utils;

import static org.lwjgl.opengl.GL46.*;

public class Shader {
    private int ID, vertID, fragID;

    public Shader(String vertPath, String fragPath) {
        String vSrc = Utils.ListStrToStr(Utils.ReadFile(vertPath));
        String fSrc = Utils.ListStrToStr(Utils.ReadFile(fragPath));

        vertID = glCreateShader(GL_VERTEX_SHADER);
        glShaderSource(vertID, vSrc);
        glCompileShader(vertID);

        if (glGetShaderi(vertID, GL_COMPILE_STATUS) == 0) {
            throw new RuntimeException(glGetShaderInfoLog(vertID));
        }

        fragID = glCreateShader(GL_FRAGMENT_SHADER);
        glShaderSource(fragID, fSrc);
        glCompileShader(fragID);

        if (glGetShaderi(fragID, GL_COMPILE_STATUS) == 0) {
            throw new RuntimeException(glGetShaderInfoLog(fragID));
        }

        ID = glCreateProgram();
        glAttachShader(ID, vertID);
        glAttachShader(ID, fragID);
        glLinkProgram(ID);
    }

    public void Bind() {
        glUseProgram(ID);
    }

    public void Unbind() {
        glUseProgram(0);
    }

    public void Cleanup() {
        glDeleteShader(vertID);
        glDeleteShader(fragID);
        glDeleteProgram(ID);
    }

    public void PutTex(String name, int slot) {
        Bind();
        glUniform1i(glGetUniformLocation(ID, name), slot);
    }

    public void PutInt(String name, int val) {
        Bind();
        glUniform1i(glGetUniformLocation(ID, name), val);
    }

}
