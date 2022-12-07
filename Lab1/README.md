Intro to Java threads

Introduction
This lab session is designed to
• Introduce the Java Thread API.
• Introduce java multithreaded application programming.

Notes
• When we extend Thread we cannot extend to any other class = missing out on inheritence
• If we implement the runnable interface we can implement other interface and take advantage of inheritence
• In extend Thread each thread is its own unique object, with Runnable, the same object is shared between threads

Questions
1. Build and Run TestThread.java – Can you explain the output?
    The order that the threads finish in is random, they are not syncrhonised but they are running in parallel
2. Build and Run TestRunnable.java – Can you explain what happened during the execution?
    The threads are running concurrently
3. Build and Run ThPool.java – Can you explain what happened during the execution?
    The threadExecutor allows the threads to continue running after main has finished.
    Each thread goes to sleep using Thread.sleep() and then prints its name when the sleep time ends.
4. Build and Run PiggyBankWithoutSync.java – Can you explain what happened during the execution?
    100 Threads are launched in parallel all reading from and writing to a shared variable "bank.balance".
    This creates race conditions, since each thread waits 5sec before writing the new balance the other threads 
    will be using out of date balance.
5. Build and Run PiggyBankWithSync.java - – Can you explain what happened during the execution?
    addApenny is now a synchronized method, this puts a lock on the method while a thread is running this method which
    blocks other threads from entering this critical section. Once the thread has finished the method a new thread
    can enter. This lets each thread read and write to the balance before a new thread does meaning that the total will
    always be 100/
