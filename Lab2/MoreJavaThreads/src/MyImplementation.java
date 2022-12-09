public class MyImplementation {
    public static void main(String[] args) {
        CubbyHole cubby = new CubbyHole();
        // Thread p = new Thread(new Producer(cubby));
        // Thread c = new Thread(new Consumer(cubby));
        Producer p = new Producer(cubby, 1);
        Consumer c = new Consumer(cubby, 1);

        p.start();
        c.start();
    }    
}

class CubbyHole{
    // boolean available = false;
    // int sharedNum = 0;

    // public void set(int n){
    //     sharedNum = 0;
    // }

    // public int get(){
    //     return sharedNum;
    // }

    private int contents;
    private boolean available = false;

    public synchronized int get() {
        while (available == false) {
            try {
                wait();
            } catch (InterruptedException e) { }
        }
        available = false;
        notifyAll();
        return contents;
    }

    public synchronized void set(int value) {
        while (available == true) {
            try {
                wait();
            } catch (InterruptedException e) { }
        }
        contents = value;
        available = true;
        notifyAll();
    }
}

class Consumer extends Thread{
    private CubbyHole hole;
    private int number;

    public Consumer(CubbyHole c, int number){
        hole = c;
        this.number = number;
    }

    public void run(){
        int value = 0;
        for(int i = 0; i < 10; i++){
            value = hole.get();
            System.out.println("Consumer"+ number +" took:"+ value);
        }
    }
}

class Producer extends Thread{
    private CubbyHole hole;
    private int number;

    public Producer(CubbyHole c, int number) {
        hole = c;
        this.number = number;
    }

    public void run(){
        for(int i = 0; i < 10; i++){
            hole.set(i);
            System.out.println("Producer"+number+" put: " + i );

            try {
                sleep((int)(Math.random() * 100));
            } catch (InterruptedException e) { }
        }
    }
}


