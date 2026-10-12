# CSE 12 PA3: Doubly Linked List

**Due date: Thursday, October 22, 2026, 11:59 PM PT**

There is an FAQ post on Piazza. Please read that post first if you have any questions.


## Learning goals:


* Implement a data structure similar to Java’s LinkedList with generic types
* Write JUnit tests to verify proper implementation

In this assignment, you will implement a data structure similar to Java's LinkedList and write JUnit tests to ensure that your implementation functions correctly. Additionally, you will apply your newly-implemented data structure to a coding problem.

**Make sure to read the entire write-up before you start coding.**

Begin by downloading the starter code and put it in a directory in your working environment.

Inside, you will find the following files:
```
+-- PA3
|   +-- MyLinkedList.java                Edit this file
|   +-- MyAlgorithm.java                 Edit this file
|   +-- MyLinkedListCustomTester.java    Edit this file
|   +-- MyLinkedListPublicTester.java
```

**Assignment Breakdown [100 points]**

* **Task 1** [100 points] You will earn points based on the autograder tests that your code passes. If the autograder tests are not able to run (e.g., your code does not compile or it does not match the specifications in this writeup), you may not earn credit.
    * **Testing** [20 points]
        * The autograder will test your implementation of the JUnit tests. Your unit tests are expected to fail or pass based on the Test table in Part 1.
    * **MyLinkedList** [65 points]
        * The autograder will test your implementation of MyLinkedList on public tests similar to `MyLinkedListPublicTester.java`, hidden test cases described in the Test table, and hidden test cases not described in this PA writeup.
    * **MyAlgorithm** [10 points]
        * The autograder will test your implementation of MyAlgorithm on public tests similar to `MyLinkedListPublicTester.java`, hidden test cases described in the Test table, and hidden test cases not described in this PA writeup.
    * **Coding Style** [5 points]
        * `MyLinkedList.java` and `MyAlgorithm.java` will be graded accordingly to the style guide. `MyLinkedListCustomTester.java` will be graded on file/class/method headers.

## Submission Instructions

#### Turning in your code

Submit all of the following files to Gradescope by the deadline:
* `MyLinkedList.java`
* `MyAlgorithm.java`
* `MyLinkedListCustomTester.java`

**Important:** Even if your code does not pass all the tests, you will still be able to submit your homework to receive partial points for the tests that you passed. Make sure your code compiles in order to receive partial credit.

## Task 1: Testing and Implementation of Doubly Linked List and MyAlgorithm [100 points]

### **Part 1: JUnit Testing (20 points)**

We provide two test files:

* `MyLinkedListPublicTester.java`
    * Contains complete test cases meant to help guide you throughout your 
    implementation. **These test cases are similar to but not exactly the same as those visible on Gradescope**.
* `MyLinkedListCustomTester.java`
    * Contains the headers and descriptions to the test cases required for the JUnit testing section. You will edit this file.
    * These headers and descriptions reveal **some** of the hidden test cases we will use to grade your MyLinkedList and MyAlgorithm implementations. The remaining set of hidden test cases will remain hidden until the PA is graded. ⚠️**Again, there are hidden tests on Gradescope not described in this write-up. Make sure to write additional tests to verify your implementation's correctness!** ⚠️

**Your task:** Implement the missing unit tests in `MyLinkedListCustomTester.java` based on the description in the Tests table below. That is to say, create JUnit tests that check for 
correct behavior under the context described in the "**Description**" column.
* Your tests will be graded by checking if they pass on a good implementation and fail on a bad implementation. If a test fails on a good implementation, then the test is written incorrectly. If a test passes on a bad implementation, it may be written incorrectly or it may not be rigorous enough (try adding more asserts).
* Some of your tests will be run on several bad implementations. You will receive 2 pts for every bad implementation your test fails (if your test also passes on the good implementation).
* **DO NOT CHANGE THE TEST HEADERS!**

**Tests Table: List of test cases to write and their description**
| Test Cases                                          | Description                                                     | Point Value |
|-----------------------------------------------------|-----------------------------------------------------------------|-------------|
| `testCustomAdd`                                     | Add a non-null element to the list.                             | 2           |
| `testCustomAddIdxToStart`                           | Add a non-null element to the start of the list.                | 2           |
| `testCustomAddIdxToMiddle`                          | Add a non-null element to the middle of the list.               | 4           |
| `testCustomRemoveFromEmpty`                         | Remove from an empty list.                                      | 2           |
| `testCustomRemoveFromMiddle`                        | Remove an element from the middle of a list at a valid index.   | 4           |
| `testCustomSetIndexOutOfBounds`                     | Set an out-of-bounds index using a non-null data argument.      | 2           |
| `testCustomMergeUnequalSize`   (MyAlgorithm.java)   | Merge two lists when one list is longer than the other.         | 2           |
| `testCustomMergeDuplicates`    (MyAlgorithm.java)   | Merge two lists when the lists share a value.                   | 2           |

**Note:** In writing JUnit tests for functions that can throw more than one exception (e.g., add(int index, E data)), if you perform a function call that would satisfy more than one exception condition, then your JUnit test must assert that all possible exceptions are thrown (even though only one will ever get thrown). This is because a correct implementation could handle the exceptions in any order. 

#### **How to compile and run the testers**

Running the tester on UNIX based systems (including Mac): 
- Compile: `javac -cp ../lib/junit-4.13.2.jar:../lib/hamcrest-core-1.3.jar:. MyLinkedListPublicTester.java`
- Execute: `java -cp ../lib/junit-4.13.2.jar:../lib/hamcrest-core-1.3.jar:. org.junit.runner.JUnitCore MyLinkedListPublicTester`

Running the tester on Windows systems:
- Compile: `javac -cp ".;..\lib\junit-4.13.2.jar;..\lib\hamcrest-core-1.3.jar" MyLinkedListPublicTester.java`
- Execute: `java -cp ".;..\lib\junit-4.13.2.jar;..\lib\hamcrest-core-1.3.jar" org.junit.runner.JUnitCore MyLinkedListPublicTester`

To run the custom tester, replace references to `MyLinkedListPublicTester` with `MyLinkedListCustomTester` in the above commands. If you would like to compile all files at once, replace `MyLinkedListPublicTester.java` with `*.java`.

**NOTE:** These commands assume the following workspace setup:

```
# Once your file system looks like this, you should open a terminal inside the 'starter' folder
# You can do this by right-clicking 'starter' in VSCode's `Explorer` tab and clicking 'Open in Integrated Terminal'
+-- lib
|   +-- hamcrest-core-1.3.jar
|   +-- junit-4.13.2.jar
+-- starter
|   ... your code files
```

⚠️**Your code must first compile in order to receive credit for the different test cases. You will receive a zero if your code doesn’t compile.** ⚠️




### **Part 2: Implementation of Doubly LinkedList (65 points)**

**What you will do:**

* Read through the method descriptions on the following table for the MyLinkedList class. Understand well the behavior of each method.
* Implement these methods (marked as TODOs in the starter code).

<!-- 
Specification Note for Autograder Compatibility:
Class headers must include the tag 'CSE12-LinkedList-Implementation' for style verification.
-->



**Requirements:**

* You **must use sentinel head and tail nodes** as discussed in lecture and on zyBooks in this assignment.
* Do not modify any class header or method signature.
* DO NOT import and use Java built-in LinkedList.⚠️**If we see that you _import java.util.LinkedList;_ you will not receive any credit! ⚠️**
* You should **NOT** allow **null** objects to be inserted into the list. A NullPointerException should be thrown in this case. This differs from java builtin LinkedList.
* For full style points, you should use the getters and setters defined in the Node class to access and modify Node objects.  Do not modify or access the Node’s member variables directly.
* Do not make any instance variables private, they should have the default access modifier.
* You may add private static final variables to be used as constants, but do not add any other instance variables and do not add static variables.

### Node class


In the starter code you can see that it uses a nested class (that is, a class inside a class) to represent a node in your linked list. To accomplish this, you can’t declare a `Node` class as public, but you can include it in the same file (and even in the same class) as `MyLinkedList`. If it is contained within `MyLinkedList<E>`, then it can just use the generic label E because it is within the class. 

Example of using the Node class from the MyLinkedList class:

<code>// data1 and data2 are objects of type E
Node node1 = new Node(data1);
Node node2 = new Node(data2);
node1.setNext(node2);
node1.setPrev(null);
Node node3 = node1.getNext();</code>

### MyLinkedList class

**Tip 1**: Make sure to implement all the helper methods (like `getNth(int index)`) first!

**Tip 2**: Make sure you refer to the table below to understand the correct behavior of the method. The behavior of your method must exactly match its specifications.

**Tip 3**: When a node is added or removed from LinkedList, remember to update relevant instance variables.

<table>
  <tr>
   <td><strong>Instance variable</strong>
   </td>
   <td><strong>Description</strong>
   </td>
  </tr>
  <tr>
   <td><code>Node head</code>
   </td>
   <td>Reference to the sentinel head of linked list
   </td>
  </tr>
  <tr>
   <td><code>Node tail</code>
   </td>
   <td>Reference to the sentinel tail of linked list
   </td>
  </tr>
  <tr>
   <td><code>int size</code>
   </td>
   <td>Keep track of the number of nodes in the linked list. This count
   does not include sentinel nodes.
   </td>
  </tr>
</table>

**Note:** Sentinel nodes do NOT have index numbers. Index 0 refers to the first non-sentinel node.

<table>
  <tr>
   <td><strong>Method Name</strong>
   </td>
   <td><strong>Description</strong>
   </td>
   <td><strong>Exceptions to Throw</strong>
   </td>
  </tr>
  <tr>
   <td><code>public MyLinkedList()</code>
   </td>
   <td>Constructor that creates an empty list and initializes all the necessary variables.
   </td>
   <td>None
   </td>
  </tr>
  <tr>
   <td><code>public boolean add(E data)</code>
   </td>
   <td>Add a node at the end into this list.
<p>
<strong>Note</strong>: the boolean add method will presumably always return true; it is a boolean function due to the method definition in AbstractList.
   </td>
   <td>Throw a <code>NullPointerException</code> if data is null.
   </td>
  </tr>
  <tr>
   <td><code>public void add(int index, E data)</code>
   </td>
   <td>Add a node into this list by index. The input index can be any integer in between zero and the number of elements (inclusive on both ends).
<p>
E.g. You have a doubly linked list with a node <em>a</em>, and you want to add a new node into the linked list by calling <code>add</code> with an index as its parameter.
<p>
<em>Example:</em>
<p>
head &lt;-> a &lt;-> tail
<p>
<code>add(0, new Character(b))</code>
<p>
head &lt;-> b &lt;-> a &lt;-> tail
<p>
<code>add(2, new Character(c))</code>
<p>
head &lt;-> b &lt;-> a &lt;-> c &lt;-> tail
   </td>
   <td>Throw a <code>NullPointerException</code> if data is null.
<p>
Throw <code>IndexOutOfBoundsException</code> when index &lt; 0 or index > number of elements in the list.
   </td>
  </tr>
  <tr>
   <td><code>public E get(int index)</code>
   </td>
   <td>Get data of type E within the node at position index.
   </td>
   <td>Throw <code>IndexOutOfBoundsException</code> when index &lt; 0 or index &ge; number of elements in the list.
   </td>
  </tr>
  <tr>
   <td><code>protected Node getNth(int index)</code>
   </td>
   <td>A helper method that returns the Node at a specified index, not the Node data.
   </td>
   <td>Throw <code>IndexOutOfBoundsException</code> when index &lt; 0 or index &ge; number of elements in the list.
   </td>
  </tr>
  <tr>
   <td><code>public E set(int index, E data)</code>
   </td>
   <td>Set the element for the node at the specified index to data and return the element that was previously stored in this node.
   </td>
   <td>Throw <code>NullPointerException</code> if data is null.
<p>
Throw <code>IndexOutOfBoundsException</code> when index &lt; 0 or index &ge; number of elements in the list.
   </td>
  </tr>
  <tr>
   <td><code>public E remove(int index)</code>
   </td>
   <td>Remove the node from the specified index in this list and return the data from the removed node.
   </td>
   <td>Throw <code>IndexOutOfBoundsException</code> when index &lt; 0 or index &ge; number of elements in the list.
   </td>
  </tr>
  <tr>
   <td><code>public void clear()</code>
   </td>
   <td>Remove all (non-sentinel) nodes from the list.
   </td>
   <td>None.
   </td>
  </tr>
  <tr>
   <td><code>public boolean isEmpty()</code>
   </td>
   <td>Determine if the list is empty.
   </td>
   <td>None.
   </td>
  </tr>
  <tr>
   <td><code>public int size()</code>
   </td>
   <td>Return the number of (non-sentinel) nodes stored in the list.
   </td>
   <td>None.
   </td>
  </tr>
</table>

### **Part 3: MyAlgorithm (10 points)**

In this part of the assignment, you will use `MyLinkedList` to solve a "challenge" programming problem. The goal of this section is to give you basic familiarity with the advantages/behavior of the data structure(s) you have just implemented.

|Method Name|Description|Exceptions to Throw|
|-----------|-----------|-------------------|
|`public static <E extends Comparable<E>> MyLinkedList<E> mergeLists(MyLinkedList<E> left, MyLinkedList<E> right)`|You are given two lists sorted in ascending order, `left` and `right`. Return a new sorted `MyLinkedList` which contains all the elements of both lists. There may be duplicates, and the list sizes may not be equal. For this problem, **do NOT** reference `head`, `tail`, or `size`; **otherwise, you will receive 0 points for this part**. However, feel free to use any of the `MyLinkedList` methods. |Throw a `NullPointerException` when `left` or `right` is null.| 

**Note:** if you would like to write additional tests for this part (asides from the ones we've asked for), write them in a different file so `MyAlgorithm` isn't accidentally flagged wrong by the autograder.

#### Examples
<pre>
// Example 1
left     ->   <1>  <-> <2> <-> <3>
right    ->   <4>  <-> <5> <-> <6>
                                          // 
MyAlgorithm.mergeLists(left, right)    ->   <1> <-> <2> <-> <3> <-> <4> <-> <5> <-> <6>

// Example 2
left     ->   <1> <-> <2> <-> <2>
right    ->   <2> <-> <3> <-> <4>
                                          // 
MyAlgorithm.mergeLists(left, right)    ->   <1> <-> <2> <-> <2> <-> <2> <-> <3> <-> <4>
</pre>

### **Part 4: Coding Style (5 points)**

Coding style is an important part of ensuring readability and maintainability of your code. We will grade your code style in all submitted code files according to the style guidelines. Namely, there are a few things you must have in each file/class/method:

* File header
* Class header
* Method header(s)
* Inline comments
* Proper indentation
* Descriptive variable names
* No magic numbers (Exception: Magic numbers can be used for testing.)
* Reasonably short methods (if you have implemented each method according to the specification in this write-up, you’re fine). This is not enforced as strictly.
* Lines shorter than 80 characters
* Javadoc conventions (`@param`, `@return` tags, `/** comments */`, etc.)


A full style guide can be found [here](https://github.com/CaoAssignments/guides/blob/main/style.md) and a sample styled file can be found [here](https://github.com/CaoAssignments/guides/blob/main/resources/SampleFile.java). If you need any clarifications, feel free to ask on Piazza.
