1 Introduction
This lab session is designed to
• Build on last week’s Java Threads Lab. 

Questions
1. Build and Run Deadlock.java - Can you explain the sequence of how deadlock occurs in this example? 
    Thread 1 locks resource 1 and will not release it until it gets to lock resource 2 and finish its execution,
    thread 2 is doing the same but it locks resource 2 straight away and needs resource 1 to finish. Both threads are holding
    a resource that is needed by the other and waiting for the resource the other has to finish.
2. Build and Run ThreadCooperation.java:    
-Explain what DepositTask and WithdrawTask are implementing.
    They are both threads that continuously run, calling withdrawing and depositing into the shared balance object. The
    Deposit thread also sleeps for 1 second after each deposit.
-Explain how is the co-operation of the tasks being controlled. 
    When the deposit thread starts executing it calls lock() which acts as a semiphore(i.e if semiphore was = 1, it is now
    = 0 and the deposit thread can contiue executing and if another thread calls lock() it will have to wait until the semiphore is = 1 again.) When it finishes it calls unlock() which allows other threads calling lock() to enter execution.
    The withdraw method also calls await if the balance is empty, this causes the thread to give up the lock and wait for a signal, the deposit thread can then take the lock and add to the balance and call signalAll to let the withdraw thread contiue execution.
5. Build and Run ProducerConsumerTest.java
-Explain the classical Producer Consumer Problem.
    If one resource is shared between more than one process at the same time then it can lead to data inconsistency
-What is the function of the three classes in the solution.
    CubbyHole is on object with an integer that can only be accessed by one thread at a time. The producer class generates a number and tries to place it in the CubbyHole while the consumer class tries to take the number from the cubbyHole. They run simultaneously but only one thread is allowed access the the cubbyHole number. If available = false then the consumer thread will wait() which allows the producer thread to access the cubbyHole, it updates the number, sets available = true and calls notifyAll() which wakes up the consumer thread which can then take the number from the cubbyHole.