# ForkJoinFramework
The fork/join framework provides a very straightforward and intuitive structure to implement recursive and **divide and conquer** problems that can be solved concurrently. You start with the big problem and break it down in smaller work units until each work unit can be solved directly. 
**The algorithm takes this form:**
```
Result solve(Problem problem) {
  if (problem is small)
    directly solve problem
  else {
    split problem into independent parts
    fork new subtasks to solve each part
    join all subtasks
    compose result from subresults
  }
}
```
As the ForkJoin Framework is standard in Java 8 and Java 7, you can view the official documentation [here](https://docs.oracle.com/javase/tutorial/essential/concurrency/forkjoin.html) and the javadoc for all subclasses in the ForkJoin framework [here](http://docs.oracle.com/javase/7/docs/api/java/util/concurrent/ForkJoinTask.html).

## (1) Task parallelism
Task parallelism focuses on distributing tasks—concurrently performed by processes or threads—across different processors. You can consider the fork/join framework if you want to perform some ***task parallelism*** on your project. Thus dividing each your program into asynchronous tasks operating in parallel. 
 ### There are only 2-4 classes you need to know about to perform parallel tasks:
- **ForkJoinPool:** An instance of this class is used to run all your fork-join tasks in the whole program.
- **RecursiveTask(V):** You run a subclass of this in a pool and have it return a result.
- **RecursiveAction:** just like RecursiveTask except it does not return a result
- **ForkJoinTask(V):** superclass of RecursiveTask<V> and RecursiveAction. fork and join are methods defined in this class.   
### In this Repo:
- **SumArray:** performing the sum of an array in sequentail & in parallel (using ForkJoin framework) and calculating the overall speedup.
- **MergeSort:** parallel merge sort, with calculating the total speedup between regular merge sort & parallel merge sort.

## (2) Functional parallelism 
