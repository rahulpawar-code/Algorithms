# Google Code Jam 2018

## SavingTheUniverseAgain
problem: https://codejam.withgoogle.com/2018/challenges/00000000000000cb/dashboard

Approach
The hint for greedy apporach can be drawn from the wording of the problem. The smallest possible number of hacks has to be calculated so that total damage is no more than D.

Sample Cases
Almost all the special and corner cases can be easily built using given sample test cases. Different cases are:
Case 1: If the total number of "S" is more than total damage then it is impossible to save knowledge becuase each beam attack will atleast cause 1 unit of damage
Case 2: If the total number of "S" is euqal to total damage then knowledge is safe and no swap is required. (This case is identical to Case 4)
Case 3: It all characters in string is "C" then there no damage to shield. Hence no swap is required.
Case 4: If total impact done by string is less than or equal to damage then no swap is required.

Logic 
A swap of "C" & "S" means promoting C to higher index in string or in other words demoting S to lower index in string. This will decrese the power of current "S" by a factor of 2. So if this C has a power of 4 units then its swap with adjacent S will cause S's power to be halved i.e. 2 units.

Eg. "CS". S has power of 2 units. A swap will modify string to "SC". S will now have power of 1 unit. 

Eg. "CCS". S has power of 4 units. A swap of last C will modify string to "CSC". S will now have power of 2 unit. Again one more swap of C & S will modify string to "SCC" and S will have a power of 1 unit.

To have a minimum number  of swaps we need to pick C will most power i.e. C with highest index in given string. Since the soultion could require  promoting more than one C, it would be to create a hash map of C indices. 


## TroubleSort
Problem: https://codejam.withgoogle.com/2018/challenges/00000000000000cb/dashboard/00000000000079cb

Approach
1. The hint for this problem came out from working out 5-6 examples. 
2. For a failed sorting case we have to find the index of first sorting error. It means we have to sort the numbers anyway obviously not using the trouble sort. 

Sample Cases
Use 9,8,7,6,5,4 as a working example.

Original
9,8,7,6,5,4
Iteration 1
Iteration 2
Final list after sorting

Logic 
This algorithm sort 2 sublist. First list comprises of number at even index and second list is formed by numbers at odd index.
Sort the two sublist 
Merge the solution into a new array
Scan the array and return the index of first sorting error


# Google Code Jam 2020
Explanation &amp; solutions to Google Code Jam 2020 programming competition

## Qualification Round

### [Vestigium](https://codingcompetitions.withgoogle.com/codejam/round/000000000019fd27/000000000020993c)

#### Solution
A straightforward brute force solution will work:
1. Scan diagonal elements and find out the trace of matrix
2. Perform row order scan of matrix. For a row, keep a freqency array. Scan all elements of a row. If frequency of any element exceeds 1 then this row contains repeated element. Increment count variable and break inner loop to move ot next row.
3. Same as step 2 but the role of rows and coulmn are exchanged.

#### compile, execute & verify result
    # javac Vestigium.java
    # java Vestigium < data/Vestigium.input
    # cat data/Vestigium.output

### [Nesting Depth](https://codingcompetitions.withgoogle.com/codejam/round/000000000019fd27/0000000000209a9f)

#### Solution
A lot of paranthesis questions are solved using stack data structure. We can use stack in this queston to come up with a simple solution.

A digit should be inside as many braces as its value. These partial examples demonstrate all possible scenarios, 00, 0((2, 2))0. From these examples we can derive the soltuion steps:
1. Initialize the reference or previous digit to 0.
2. Scan string from left to right char by char. Compare current digit from previous. There will be 3 cases:
    1. If current is smaller than previous then push closing braces in stack equal to diff between current and previous.
    2. If current is larger than previous then push opening braces in stack equal to diff between current and previous.
    3. If current is equal to previous then do nothing.
3. Push current digit onto stack. Update previous and assign it to current. Repeat step 2 until end of string.
4. If last digit is non-zero, keep pushing closing braces till it becomes zero.
5. Empty the stack content to a string and reverse it.

#### Compile, execute & verify result
    # javac NestingDepth.java
    # java NestingDepth < data/NestingDepth.input
    # cat data/NestingDepth.output

### [Parenting Partnering Returns](https://codingcompetitions.withgoogle.com/codejam/round/000000000019fd27/000000000020bdf9)

#### Compile, execute & verify result
    # javac ParentingPartneringReturns.java
    # java ParentingPartneringReturns < data/ParentingPartneringReturns.input
    # cat data/ParentingPartneringReturns.output

### [Indicium](https://codingcompetitions.withgoogle.com/codejam/round/000000000019fd27/0000000000209aa0)

#### Compile, execute & verify result
    # javac Indicium.java
    # java Indicium < data/Indicium.input
    # cat data/Indicium.output

 ## Round 1A
