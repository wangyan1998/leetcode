package classify.test;

/**
 * @author wy
 * @date 2021/4/5 11:09
 */
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Testtheard {
    public static void main(String args[]) throws InterruptedException{
        Runtime r = Runtime.getRuntime();//获得当前系统的CPU数量，根据这个数值创建对应数量的线程
        System.out.println(r.availableProcessors());
        ExecutorService pool = Executors.newFixedThreadPool(r.availableProcessors());
        for (int i = 0;i < r.availableProcessors();i++){
            pool.execute(new Loop());
        }
        pool.shutdown();
    }
}
class Loop implements Runnable{
    @Override
    public void run() {
        int busyTime = 50;//可调节参数，单位为ms。50ms后线程休眠50毫秒，然后再经系统调度。该数值越小，则线程被调度得越频繁，则CPU使用率也就越高（平均）
        int idleTime = busyTime;
        while(true){
            long startTime = System.currentTimeMillis();
            //busy loop:
            while((System.currentTimeMillis()-startTime)<=busyTime)
                ;
            try {
                Thread.sleep(idleTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
