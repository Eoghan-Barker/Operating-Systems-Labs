In this lab we look at another implementation of synchronized to read and write in a shared object.
We also look at how we can implement an order to the threads when they are accessing a shared object.
Finally we look at how another solution to the producer-consumer problem but this time using a bounded buffer

BankExample is another example of thread synchrization on a shared object to prevent data inconsistency. The sysout messages show that all 100 threads call the synchronized addApenny method straight away but then only one thread can be in that method at a time so there is never 2 "in add a penny" or "finished add a penny" messages in a row.

In the ConsoleUnordered example the shared object is the sccreen. The goal with these threads is to display "My name is Martin" in the correct order however this isnt achieved with the synchronized keyword. When you run this example the output is not in the correct order because one thread puts a lock on the method and then prints out all of its words before the next thread can run(kind of)

In ConsoleOrdered the shared object has a "state" property and each thread has a "Desiredstate" property, if a thread calls shared.display() and these 2 properties are not equal the thread will call wait(). Once a thread's desiredstate is equal to the state of the shared object then it can display its message, move the object into the next state and signalAll() for the other threads to wake up and test their desiredState with the state again.