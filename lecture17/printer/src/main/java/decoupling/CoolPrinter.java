package decoupling;

public class CoolPrinter {
    public static void main(String[] args) {
        MessageRenderer renderer = new StandardOutMessageRenderer();
        MessageProvider provider = new HelloWorldMessageProvider();

        renderer.setMessageProvider(provider);
        renderer.render();
    }
}
