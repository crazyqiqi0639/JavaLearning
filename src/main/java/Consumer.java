import java.util.Random;

public class Consumer implements Runnable{
    private Container2 container;
    public Consumer(Container2 container) {
        this.container = container;
    }

    @Override
    public void run() {
        while(true) {
            Integer val = container.take();
        }
    }
}
