package ring;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by linhnm on September, 2021
 */

public class RingBuffer<T> {
    private T[] buffer;
    //    private volatile T[] buffer;
    private int readIndex;
    private int writeIndex;
    private final int capacity;
    private AtomicInteger size;

    public RingBuffer(int k) {
        this.buffer = (T[]) new Object[k];
        this.capacity = k;
        this.readIndex = 0;
        this.writeIndex = 0;
        this.size = new AtomicInteger(0);
    }

    public boolean offer(T value) {
        if (isFull()) return false;
        buffer[writeIndex] = value;
        writeIndex++;
        if (writeIndex == capacity) writeIndex -= capacity;
        size.getAndIncrement();
        return true;
    }

    public T poll() {
        if (isEmpty()) return null;
        int index = readIndex;
        T x = buffer[index];
        readIndex++;
        if (readIndex == capacity) readIndex -= capacity;
        size.getAndDecrement();
        return x;
    }

    public boolean isEmpty() {
        return size.get() == 0;
    }

    public boolean isFull() {
        return size.get() == capacity;
    }

    public static void test1() throws ExecutionException, InterruptedException {
        RingBuffer<String> buffer = new RingBuffer<>(10);
        AtomicBoolean writeDone1 = new AtomicBoolean(false);
        ExecutorService service = Executors.newFixedThreadPool(2);

        Callable<List<String>> cw1 = () -> {
            List<String> x = new ArrayList<>();
            int count = 0;
            for (int i = 0; i < 100; i++) {
                if (buffer.offer( i+"")) {
                    try {
                        Thread.sleep(10);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    count++;
                    x.add(i+"");
                }
            }
            writeDone1.set(true);
            System.out.println("num write " + count);
            return x;
        };

        Callable<List<String>> cr = () -> {
            List<String> x = new ArrayList<>();
            int count = 0;
            while (!writeDone1.get()) {
                String  data = buffer.poll();
                if (data != null) {
                    x.add(data);
                    try {
                        Thread.sleep(15);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    count++;
                }
            }

            while (true) {
                String data = buffer.poll();
                if (data != null) {
                    x.add(data);
                    try {
                        Thread.sleep(15);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    count++;
                } else {
                    break;
                }
            }
            System.out.println("num read " + count);
            return x;
        };
        Future<List<String >> fw = service.submit(cw1);
        Future<List<String>> fr = service.submit(cr);

        List<String> sw = fw.get();
        List<String> sr = fr.get();

        for (String s : sw) {
            System.out.println("write list: " + s);
        }

        for (String s : sr) {
            System.out.println("read list: " + s);
        }

        System.out.println(sw.size());
        System.out.println(sr.size());

//        sw.removeAll(sr);
//        System.out.println(sw.size());

        service.shutdown();
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        test1();
    }
}
