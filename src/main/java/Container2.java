import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class Container2 {
    Semaphore fullCount = new Semaphore(0);
    Semaphore emptyCount = new Semaphore(10);
    Semaphore isUse = new Semaphore(1);

    List list = new LinkedList<Integer>();

    public void  put(Integer val){

        try {
            emptyCount.acquire();
            isUse.acquire();

            list.add(val);
            System.out.println("producer--"+ Thread.currentThread().getName()+"--put:" + val+"===size:"+list.size());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            isUse.release();
            fullCount.release();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public Integer take(){
        Integer val1 = 0;
        try {
            fullCount.acquire();
            isUse.acquire();
            val1 = (Integer) list.remove(0);
            System.out.println("consumer--"+ Thread.currentThread().getName()+"--take:" + val1+"===size:"+list.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            isUse.release();
            emptyCount.release();
        }
        return val1;
    }
}
