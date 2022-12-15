To get multiple programs running simultaneously in vscode(i.e server and client) go to the run and debug menu and click create launch.json file. Set this up to launch from both the server and client main methods.

In MultiThreadedIssue the provider and requester will connect correctly and the threads will be called but the thread will finish executing and the program will end. To fix this in MultiThreadedChanges we add a while loop that will keep executing the thread until the user enters something.

