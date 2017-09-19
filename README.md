# ForkJoinFramework
The fork/join framework provides a very straightforward and intuitive structure to implement recursive and **divide and conquer** problems that can be solved concurrently. You start with the big problem and break it down in smaller work units until each work unit can be solved directly.   
***The algorithm takes this form:**
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
As the ForkJoin Framework is standard in Java 8 and Java 7, you can view the official documentation [here](https://docs.oracle.com/javase/tutorial/essential/concurrency/forkjoin.html) and the javadoc for all subclasses in the ForkJoin framework [here](http://docs.oracle.com/javase/7/docs/api/java/util/concurrent/ForkJoinTask.html)
