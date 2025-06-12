# COMP 271 SU25 WEEK 03

This assignment has two parts: a coding part based on current material we discuss in class and a reflection part to evaluate work you have already submitted.


# Standing requirements

* **Programmers Pact:** Your work must be compliant with the [Programmers Pact](./ProgrammerPact.pdf). 
* **Comments:** Your code must be sufficiently documented with comments.
* **No imports:** You may not use the import statement in your code, with one exception: `import Arrays;` is allowed only for using `Arrays.toString()`. No other methods of class `Arrays` may be used.
* **Only `System.out` calls:** you may use `System.out` to print to the console. No other methods from `System` are allowed. Only `System.out.println`, `System.out.printf`, and `System.out.print`. 

# Finals week policy

There is no final exam for the course. There will be a final assignemnt that will be published the week before finals and will be due the week of finals. Additionally, 8 students in the course will be invited randomly to a brief meeting with the instructor during the course's final exam slot. The final exam slot for this course is on Tuesday, August 5, 2025 from 9 to 11 AM. If you are selected for a brief meeting, we'll spend about 15 minutes during the final exam slot to review your work. This interview will cover coding practices based on your past assignments. It is meant as a checkpoint to ensure that you have internalized the work you submitted.

# Code

For this coding part, class `TrainLine_Implementation` has 8 basic tests that you must pass. The class cannot be compiled before you write the specified methods below. Your code must pass all tests in the implementation class.

## Faster addition of new station

Study the code in classes [`Station`](./Station.java), [`TrainLine`](./TrainLine.java), and [`TrainLine_Implementation`](./TrainLine_Implementation.java). Notice that method `TrainLine.add` has to iterate over the entire line to find the last station, before adding a new station at the end of the line. Investigate if there is a way to avoid the traversal, recalling our discussion about counting the number of stations in the line. Document your strategy as comments for method `TrainLine.add` then implement the changes you proposed. Your code should work with class `TrainLine_Implementation` just like before, i.e., the stations should be added in the same order and shown in the same order when the object is printed.

## Search for the position of a train station

Write a method with header
```java
public int indexOf(String stationName)
```
that returns the position of the named station: 0 if it's the first station, 1 if it's the second, etc. If the station we search for is not present in the train line, the method should return -1.

## Predicate-based search

Write a method with header
```java
public boolean contains(String stationName)
```
that returns `true` if the named station is present in the train line and `false` otherwise.


# Study

* <a href="https://docs.oracle.com/javase/tutorial/java/javaOO/accesscontrol.html" target = "_blank">Tutorial about classes and objects</a>

# Reflect

Compare your code from the previous assignment with [Leo's posted solutions](./MinHeap.java#L191). 

Then write a brief reflection (100-300 words) discussing what you got right, what you got close but not quite, and where you may have missed the mark. Also discuss what you learned by comparing your code to the posted solutions. The reflection must be substantive. For example, you may find that you missed something in the assignment because you did not put enough time in it or because you did not start work early. It's fine to acknowledge these issues. It is also important to propose a plan to avoid them in the future. And, in later reflections, evaluate how that plan worked.

In the assignment for WEEK 02 you were given class `MinHeap`. The class had a dozen of methods in 300 lines of code. One of the methods (`heapifyUp`) was incomplete. You had to complete it. The solution presented here is very compact, practically implemented with 5 lines of code (shown as pseudocode here):

```java
int index = last used position in underlying array;
while (min-heap property is violated) {
    swap(parent(index), index);
    index = parent(index); }
```

* Was your code sufficiently documented with comments?.

* Did you test your code to verify that it compiles and returns correct results?

Your reflection should be submitted together with the current homework assignment due 6/11. Write your reflection as a *markdown* file called `reflection.md` in the current assignment's repository. **MarkDown** is a fairly simple markup (I know!) language that's worth learning. You can use a [simple cheat sheet](https://www.markdownguide.org/basic-syntax/) for MarkDown (.md) files or you can look at the course code of any `.md` file I share with you such as this one here. You can open any `.md` file on your CodeSpaces editor to see how it's written. 

If MarkDown is not your cup of tea that's ok too. Write your reflection in an email and send it to me with the header "reflection" in the subject line. But if you see yourself as a programmer/computer scientist down the road, it's worth the time to learn to write in MarkDown.
