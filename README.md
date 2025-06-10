# COMP 271 SU25 WEEK 02

This assignment has two parts: a coding part based on current material we discuss in class and a reflection part to evaluate work you have already submitted.


# Standing requirements

* **Programmers Pact:** Your work must be compliant with the [Programmers Pact](./ProgrammerPact.pdf). 
* **Comments:** Your code must be sufficiently documented with comments.
* **No imports:** You may not use the import statement in your code, with one exception: `import Arrays;` is allowed only for using `Arrays.toString()`. No other methods of class `Arrays` may be used.
* **Only `System.out` calls:** you may use `System.out` to print to the console. No other methods from `System` are allowed. Only `System.out.println`, `System.out.printf`, and `System.out.print`. 
 

# Code

Study the code in class [MinHeap.java](./MinHeap.java) and implement its `heapifyUp()` method. Use class [MinHeap_Implement](./MinHeap_Implement.java) to test your code. 

There are six tests in `MinHeap_Implement`. You can run the program and you'll see all tests reporting a `fail`. Once you complete your `heapifyUp()` correctly, all six tests will report success.


# Reflect

Compare your code from the previous **two** assignment with [Leo's posted solutions](./Realistic.java). Solutions for both WEEK 00 and WEEK 01 are included in `Realistic` here. For WEEK01, I preserved the original method 
```java
int getSmallest()
```
and added methods `getSmallest2` and `getSmallest3` to demonstrate the solution.

The write a brief reflection (100-300 words) discussing what you got right, what you got close but not quite, and where you may have missed the mark. Also discuss what you learned by comparing your code to the posted solutions. The reflection must be substantive. For example, you may find that you missed something in the assignment because you did not put enough time in it or because you did not start work early. It's fine to acknowledge these issues. It is also important to propose a plan to avoid them in the future. And, in later reflections, evaluate how that plan worked.

* Was your code sufficiently documented with comments? (Commenting is a skill introduced in COMP 170 or similar course).

* Did you test your code to verify that it compiles and returns correct results? (Compiling code is also a skill introduced in COMP 170 or similar).

Your reflection should be submitted together with the current homework assignment due 6/11. Write your reflection as a *markdown* file called `reflection.md` in the current assignment's repository. **MarkDown** is a fairly simple markup (I know!) language that's worth learning. You can use a [simple cheat sheet](https://www.markdownguide.org/basic-syntax/) for MarkDown (.md) files or you can look at the course code of any `.md` file I share with you such as this one here. You can open any `.md` file on your CodeSpaces editor to see how it's written. 

If MarkDown is not your cup of tea that's ok too. Write your reflection in an email and send it to me with the header "reflection" in the subject line. But if you see yourself as a programmer/computer scientist down the road, it's worth the time to learn to write in MarkDown.