# Note on week 1's lessons

## Seven steps for solving programming problem

1. Work example by __Hand__
2. __Write down__ what you did
3. __Find patterns__
4. Check by __Hand__
5. __Translate__ to Code
6. Run __Test Cases__
7. __Debug__ Failed Test Cases

### 1. Work example by __Hand__

- Solve small instance by hand
    - with small pieces of data
- Unclear problem?
- Need domain knowledge?

### 2. __Write down__ what you did

- Write down exact steps
- Only write the step-by-step approach for the on _particular_
    instance you solved, not the more general problem.

- Trikcy: Do it without thinking

### 3. __Find patterns__

In step three, you want to move from the particular instance that you solved
in the step one to __an algorithm__ that works for any instance of the problem.
That is, you want to devise an algorithm which can solve the problem for any
input that you give it. You'll do this by finding patterns in what you did and 
replacing specific behavior with more than general behavior based on that pattern.

Difficulties? Try step 1 + 2 again OR using different inputs

- Algorithm for any instance
- Find patterns
- Repetition, conditions, values

### 4. Check by __Hand__

In step four, you want to check your algorithm before you proceed to turn it into
code. If you found the patterns incorrectly or otherwise made a mistake in step three,
you'll find it out now.

The way you check your algorithm is to pick at least one different input (again, it 
should be small one).

If your algorithm give you the write answer, you're ready to move on.
If not, you should go back and fix it first.

- Incorrect pattern? Find now
- Check with different inputs

### 5. __Translate__ to Code

At this step, you're ready to translate that algorithm into code.
This step is where the syntax of a specific programming language comes into play.

You need to write down your steps in the syntax of that language.

- Translate algorithm to code
    - Programming language

### 6. Run __Test Cases__

Once you've written your code, you want to be sure that it works correctly,
so you run test cases on it.

Running a test case involves executing the code on a paticular input and
checking if it produced the right answer.

The more test cases your code passes, the more confident you could be that it is correct.
However, no amount of testing can guarantee that the code is right.

- Run test cases on code
    - Execute program
    - Check answer

### 7. __Debug__ Failed Test Cases

When your program fails a test case, you know something is wrong.

And when that happens, it's time to debug your program.

- Test failed? Debug
    - Use scientific method
    - Understand problem + fix
        - Algorithmic problem? return to __step 3__
        - Implementation problem? return to __step 5__