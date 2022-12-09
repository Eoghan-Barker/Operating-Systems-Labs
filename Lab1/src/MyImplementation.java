public class MyImplementation {
    private Bank bank = new Bank();
    private Thread[] threads = new Thread[100];
    public static void main(String[] args) {
        MyImplementation runner = new MyImplementation();
        System.out.println(runner.bank.getBalance());
    }

    public MyImplementation(){
        ThreadGroup group1 = new ThreadGroup("group");
        boolean finished = false;

        for(int i = 0; i < 100; i++){
            threads[i] = new Thread(group1, new AddAPennyThread(), "t"+i);
            threads[i].start();
        }

        //wait for threads to finish before returning to main execution
        while(!finished){
            if(group1.activeCount()==0) finished = true;
        }
    }

    public synchronized void addAPenny(Bank bank){
        int newBalance = bank.getBalance() + 1;

        bank.setBalance(newBalance);
    }

    class Bank{
        private int balance;

        public int getBalance(){
            return balance;
        }

        public void setBalance(int n){
            balance = n;
        }
    }

    class AddAPennyThread extends Thread{
        public void run(){
            addAPenny(bank);
        }
    }
}
