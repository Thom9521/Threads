import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Threads_30_4 {
    public static void main(String[] args) {

        ExecutorService pool = Executors.newCachedThreadPool();
        AddOne add = new AddOne();

        for (int i = 0; i < 1000; i++) {
            pool.execute(new AddOne());
        }
        pool.shutdown();

        System.out.println("Sum: " + Sum.getNum());
    }


    private static class AddOne implements Runnable{

        private int sum = 0;
        @Override
        public  void run() {
            Sum.add(1);
           // sum = sum + 1;
        }

    }

    private static class Sum{
       static int num = 0;

        public static int getNum() {
            return num;
        }

        public synchronized static void add(int i){
            num = num + i;

        }
    }
}