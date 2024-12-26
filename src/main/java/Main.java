import org.hv.Engine;

public class Main {
    public static void main(String[] args) {
        Engine engine = new Engine();
        engine.Run();
        engine.Cleanup();
    }
}