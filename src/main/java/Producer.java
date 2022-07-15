import java.util.Random;

public class Producer implements Runnable{
    private Container2 container;
    public Producer(Container2 container) {
        this.container = container;
    }

    @Override
    public void run() {
        while (true) {
            container.put(new Random().nextInt(100));
        }
    }
}
