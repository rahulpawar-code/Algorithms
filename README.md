# Table of Contents
1. [System Design Questions](#system-design-questions)
2. [Java OOP Concepts](#java-oop-concepts)
3. [C++ Concepts](#c++-concpets)
4. [Operating System Concepts](#operating-system-concepts)
5. [Reading-References](#reading-references)
6. [Algorithms and Data Structures](#algorithms-and-data-structures)


# [System Design Questions](System-Design-Questions/)
Large scale system design and object oriented design questions and topics

## Index
1. Keywords To Remember
2. Infrastructure Design Questions
3. System Design Questions
4. Object Oriented Design Questions
5. External References


# [Java OOP Concepts](Java-Concepts/)
Short sample programs to demonstrate the inbuilt object oriented concepts in Java language.
* Generics
* Equality
* String Representation of Object
* Hash code of Object
* Dynamic array
* Iterable
* Comparable
* assert
* Comparator
* Immutability


# [C++ Concepts](C++-Concepts/)
Short sample program to demonstrate C++ language basics
* Smart pointers
* move semantics
* move constructor
* move assignment


# [Operating System Concepts](Operating-System-Concepts/)
* Concurrency
    * Simple producer consumer with busy wait [Link](Operating-System-Concepts/concurrency/SimpleProducerConsumer.cpp)
    * Simple producer consumer with **condition variable** [Link](Operating-System-Concepts/concurrency/SimpleProducerConsumerCond.cpp)
* File IO
    * Print all lines which contain a given pattern [Link](Operating-System-Concepts/fileio/SearchPatternInFile.cpp)
* Memory Management
    * Implement aligned **malloc()** and **free()** [Link](Operating-System-Concepts/memory-management/aligned_malloc_free/)
    * Implement **malloc()** and **free()** [Link](Operating-System-Concepts/memory-management/my_malloc_free/)


# Reading-References

* **Prefix Hash tree** - https://www.eecs.berkeley.edu/~sylvia/papers/pht.pdf - Prefix Hash Tree: An Indexing Data Structure over Distributed Hash Tables
* **Distributed Hash table** - https://en.wikipedia.org/wiki/Distributed_hash_table
* **Suffix tree** https://en.wikipedia.org/wiki/Suffix_tree Compressed Trie, used in pattern searching, hard algo


# Algorithms and Data Structures
1. [Google CodeJam](#google-codejam)
2. Algorithms
3. [LeetCode](#leetcode)


## [Google CodeJam](sites/googlecodejam/)
1. Google Code Jam 2018
2. Google Code Jam 2020

## Princeton Algorithms Course
Princeton Algorithms [Part 1](https://www.coursera.org/learn/algorithms-part1/) and [Part2](https://www.coursera.org/learn/algorithms-part2/)


## Linked List
* Rearrange odd even elements in a linked list. [C++](problems/linked-list/RearrangeEvenOdd.cpp)
* Linked List [Java](problems/linked-list/LinkedList.java)
* Alternating Split [Java](problems/linked-list/AlternatingSplit.java)

## Stack
* Dynamic Stack [Java generic](problems/stack/DynamicStack.java)
* StackOfStrings [Java generic](problems/stack/StackOfStrings.java)

## Queue
* CircularQueue [Java generic](problems/queue/CircularQueue.java)
* LinkedQueue [Java generic](problems/queue/LinkedQueue.java)
* Deque [Java generic](problems/queue/Deque.java)
* RandomizedQueue [Java generic](problems/queue/RandomizedQueue.java)

## Priority Queue and Heap
* Max Queue [Java generic](problems/priority-queue/MaxQueue.java)
* Min Queue [Java generic](problems/priority-queue/MinQueue.java)

## Symbol table and Search Trees
* Binary Search Tree [Java generic](problems/symbol-table/BST.java)
* Interval Search Tree [Java generic](problems/symbol-table/IntervalST.java)

## Union Find
* Quick Find [Java generic](problems/union-find/QuickFind.java)
* Quick Union [Java generic](problems/union-find/QuickUnion.java)
* Weighted Quick Union [Java generic](problems/union-find/WeightedQuickUnion.java)
* Weighted Quick Union with Path compression [Java generic](problems/union-find/QuickUnionPathCompression.java)
* Percolation Problem [Java](problems/union-find/percolation)

## Graph
* Find the celebrity in room. [C++](problems/graph/CelebrityProblem1.cpp)

## String
* Parse decimal, hexdecimal, octal from a file and output to another. [C++](problems/string/ParseDecHexOctal.cpp)
* Check if two strings are isomorphic. [C++](problems/string/IsomorphicStrings.cpp)
* Find first unique character in a string. [C++](problems/string/firstUniqueCharacter.cpp)
* String sorting [Java](problems/string/SortStringUsingTrie.java) Using trie data structure
* Auto Completion search [Java](problems/string/AutoComplete.java) Using trie
* English word meaning dictionary [Java](problems/string/WordMeaningDictionary.java) Using trie
* Longest Common Prefix [Java](problems/string/LongestCommonPrefix.java) Using trie
* Pattern Searching [Java](problems/string/PatternSearchingTrie.java) Using trie of all suffix
* Word Break problem [Java](problems/string/WordBreak.java) Using trie, recursive algorithm
* KMP Pattern searching [Java](problems/string/KMP.java) Search pattern in text

## Trie
* Spell checker. [C++](problems/trie/SpellChecker.cpp)
* Trie data structure. [Java](problems/trie/Trie.java)

## Arrays
* Continuous ones [Java](problems/array/ContinuousOnes.java)
* Infections over a distance [Java](problems/array/Contamination.java)

## Matrices
* 8 Puzzle [Java](problems/matrices/8-puzzle/)

## Sorting
* Insertion sort. (generic)  [Java](problems/sorting/Insertion.java)
* Selection sort (generic)  [Java](problems/sorting/Selection.java)
* Shell sort (generic)  [Java](problems/sorting/Shell.java)
* Merge (generic)  [Java](problems/sorting/Merge.java)
* Bottom Up Merge (generic)  [Java](problems/sorting/MergeBU.java)
* Quicksort (generic)  [Java](problems/sorting/Quick.java)
* 3-way Quicksort (generic)  [Java](problems/sorting/Quick3Way.java)

## Dynamic Programming
* Word Break problem [Java](problems/string/WordBreak.java) recursive algorithm, using trie
* Longest Common Subsequence [Java](problems/dynamic-programming/LongestCommonSubsequence.java) Naive, top-down, bottom up tabulation, LCS string, LCS of 3 strings
* Shortest Common Supersequence
    * Using DP [Java](problems/dynamic-programming/ShortestSupersequenceDP.java)
    * Using LCS [Java](problems/dynamic-programming/Shortestsuperseequence.java)
* Longest Common Substring [Java](problems/dynamic-programming/LongestCommonSubstring.java) Recursive, bottom-up, space optimized, print substring, without repeating characters
* Longest Common Substring in array [Java](problems/dynamic-programming/StemInStringArray.java) Stem in an array of strings
* Subsequence variants: Repeated Subsequence [Java](problems/dynamic-programming/RepeatedSubsequence.java) top-down, naive recursion, print sequence
* Levenshtein distance / Edit Distance [Java](problems/dynamic-programming/EditDistance.java)
* Largest sqaure submatrix of 1s [Java](problems/dynamic-programming/LargestSquareSubmatrix.java)
* Min cost path from top right to bottom down in matrix](other/dynamic-programming/MatrixMinCost.java)
* Maximum value of expression [Java](problems/dynamic-programming/MaxValueOfExpression.java)
* Subset sum partition [Java](problems/dynamic-programming/Partition.java)
* Three Partition [Java](problems/dynamic-programming/ThreePartition.java)
* Rod Cutting [Java](problems/dynamic-programming/RodCutting.java)
* Rod Cutting Product [Java](problems/dynamic-programming/RodCuttingProduct.java)
* Coin Change [Java](problems/dynamic-programming/CoinChange.java)
* Coin Change Ways [Java](problems/dynamic-programming/CoinChangeWays.java)
* Binary String with no consecutive 1s [Java](problems/dynamic-programming/BinaryStrings.java)
* Word Break [Java](problems/dynamic-programming/WordBreak.java)
* Word Break using trie [Java](problems/dynamic-programming/WordBreakUsingTrie.java)
* Array Adjustment cost [Java](problems/dynamic-programming/ArrayAdjustmentCost.java)
* No of ways for dice throws [Java](problems/dynamic-programming/DiceThrows.java)
* Wildcard Matching [Java](problems/dynamic-programming/WildcardMatching.java)
* Tripping Rain Water [Java](problems/array/TrappingRainWater.java)

## Greedy
* Activity Selection [Java](problems/greedy/ActivitySelection.java)
* Activity Sequencing
    * Naive algorithm [Java](problems/greedy/ActivitySequencing.java)
    * Using union-find [Java](problems/greedy/ActivitySequencing2.java)

## Maths, Stats, Ordered Stats
* kth element, Quick Select [Java](problems/sorting/QuickSelect.java)
* Shuffling [Java](problems/sorting/Shuffling.java)
    * [Fisher–Yates shuffle algorithm](https://en.wikipedia.org/wiki/Fisher%E2%80%93Yates_shuffle)
* GaussElimination [Java](problems/math/GaussElimination.java) Gauss elimination or Gauss Jordan method to solve system of linear equations
* Point2D [Java](problems/math/Point2D.java) Data structure to represent point in 2D space
* Point3D [Java](problems/math/Point3D.java) Data structure to represent point in 3D space

## Permutation
* Permutation of objects [Java](problems/queue/Permutation.java)

## Encoding decoding (char, int, digits etc)
* Print all possible decoding of given digit sequence. [C++](problems/encoding-decoding/CountDecodedDigitSequence.cpp)
* Print all possible decoding of given digit sequence. [C++](problems/encoding-decoding/PrintDecodedDigitSequence.cpp)

## Other
* Find the celebrity in room. [C++](problems/others/CelebrityProblem2.cpp)
* Maximum possible length by cutting N wood pieces into K pieces. [C++](problems/others/MaxLengthForCutting.cpp)
* Merge N trasactions preserve order. [C++](problems/others/MergeTransactions.cpp)
* Stock Buy Sell to Maximize Profit. [C++](problems/string/firstUniqueCharacter.cpp)

## Bit manipulation/ Bitwise hacks
* Basics [Java](problems/bitwise/bitwise1.cpp)
* Questions [Links 1](https://www.techiedelight.com/Tags/Bit-Hacks/)
* Bit Twiddling Hacks [collection](https://graphics.stanford.edu/~seander/bithacks.html)

## Computational Geometry
* Closest pair of points [Java](others/math/ClosestPairPoint.java) Divide and conquer algorithm
* Collinear points [Java](others/math/CollinearPoints.java)
* Group points which are at distance less than k [Java](others/math/GroupPoints) brute force algorithm
* Group points which are at distance less than k [Java](others/math/GroupPoint2.java) divide and conquer algorithm

## Random data generation
* Random String [Java](problems/dynamic-programming/RandomString.java) Random strings
* Random 2D Matrix [Java](problems/dynamic-programming/Random2DMatrix.java) Random 2D boolean, binary or integer matrix

## Other data structures
* Activity/Task [Java](problems/greedy/Activity.java) representation of an activity or a task

## Leetcode
| String | Link | Java  | C++|
|:--|:--|:--|:--|
| Reverse String | [link](https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/879/) | [ReverseString.java](sites/leetcode/ReverseString.java) | [ReverseString.cpp](sites/leetcode/ReverseString.cpp) |
| Reverse Integer |  [link](https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/880/) | ? | [ReverseInteger.cpp](sites/leetcode/ReverseInteger.cpp)  |
| First unique character in a string |  [link](https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/881/) | ? | [FirstUniqueCharacter.cpp](sites/leetcode/FirstUniqueCharacter.cpp) |
| Valid anagram | [link](https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/882) | ? | [ValidAnagram.cpp](sites/leetcode/ValidAnagram.cpp) |
| Valid palindrome |  [link](https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/8823) | ? | [ValidPalindrome.cpp](sites/leetcode/ValidPalindrome.cpp) |
| Longest Common Prefix |  [link](https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/887/) | ? | [Brute Force 1](sites/leetcode/LongestCommonPrefixMethod1.cpp) <br/> [Brute Force 2](sites/leetcode/LongestCommonPrefixMethod2.cpp) <br/> [Using Trie](sites/leetcode/LongestCommonPrefixMethod3.cpp) |

<br/>

| Singly Linked List| Link | Java  | C++|
|:--|:--|:--|:--|
| Delete Node (without previous) | [link](https://leetcode.com/explore/interview/card/top-interview-questions-easy/93/linked-list/553/) | ? | [Simple Delete](sites/leetcode/LinkedList.cpp) |
| Remove Nth from end | [link](https://leetcode.com/explore/interview/card/top-interview-questions-easy/93/linked-list/603/) | ? | [Simple Delete](sites/leetcode/LinkedList.cpp) |
| Reverse a linked list | [link](https://leetcode.com/explore/interview/card/top-interview-questions-easy/93/linked-list/560/) | ? | [Iterative](sites/leetcode/ReverseList.cpp) <br/> [Recursive](sites/leetcode/ReverseList.cpp)|
| Merge two sorted | [link](https://leetcode.com/explore/interview/card/top-interview-questions-easy/93/linked-list/771/) | ? | [Simple](sites/leetcode/MergeSortedList.cpp) |
| Palindrome List | [link](https://leetcode.com/explore/interview/card/top-interview-questions-easy/93/linked-list/772/) | ? | [Double Reverse](sites/leetcode/PalindromeList.cpp) |
| Cycle in Linked List | [link](https://leetcode.com/explore/interview/card/top-interview-questions-easy/93/linked-list/773/) | ? | [Slow and fast pointer](sites/leetcode/LinkedListCycle.cpp) |
| Sum two numbers | [link](https://leetcode.com/explore/interview/card/top-interview-questions-medium/107/linked-list/783/)  | ? | [Link](sites/leetcode/SumTwoNumbers.cpp)  |
| Odd Even Linked List | [link](https://leetcode.com/explore/interview/card/top-interview-questions-medium/107/linked-list/784/)  | ? | [Link](sites/leetcode/OddEvenList.cpp)  |
| Intersection of Two Linked Lists | [link](https://leetcode.com/explore/interview/card/top-interview-questions-medium/107/linked-list/785/)  | ? | [Difference of Lengths](sites/leetcode/ListIntersection.cpp) <br/> [Traversal Pointer reassignment](sites/leetcode/ListIntersection.cpp) |

<br/>

| Binary Tree | Link | Java  | C++|
|:--|:--|:--|:--|
| Max depth | [link](https://leetcode.com/explore/interview/card/top-interview-questions-easy/94/trees/555/) | ? | [Max Depth]((sites/leetcode/BinaryTree.cpp)) |
| Validate Binary search Tree | [link](https://leetcode.com/explore/interview/card/top-interview-questions-easy/94/trees/625/) | ? | [Validate BST](sites/leetcode/BinaryTree.cpp) |
| Symmeric Binary Tree | [link](https://leetcode.com/explore/interview/card/top-interview-questions-easy/94/trees/627/) | ? | [Iterative](sites/leetcode/SymmetricBinaryTree.cpp) <br/> [Recursive](sites/leetcode/SymmetricBinaryTree.cpp) |
| Level Order Of Tree | [link](https://leetcode.com/explore/interview/card/top-interview-questions-easy/94/trees/628/)  | ? | [Using queue](sites/leetcode/BinaryTreeTraversals.cpp)  |
| Sorted Array to Binary Search Tree | [link](https://leetcode.com/explore/interview/card/top-interview-questions-easy/94/trees/631/)  | ? | [Recursive](sites/leetcode/SortedArratToBST.cpp)  |
| Inorder traversal| [link](https://leetcode.com/explore/interview/card/top-interview-questions-medium/108/trees-and-graphs/786/) | ? | [Iterative using stack](sites/leetcode/BinaryTreeTraversals.cpp) <br\> [Recursive](sites/leetcode/BinaryTreeTraversals.cpp) |
| Zigzag/spiral level order traversal| [link](https://leetcode.com/explore/interview/card/top-interview-questions-medium/108/trees-and-graphs/787/) | ? | [Link](sites/leetcode/BinaryTreeTraversals.cpp) |
| Construct Binary Tree from Preorder and Inorder Traversal | [Link](https://leetcode.com/explore/interview/card/top-interview-questions-medium/108/trees-and-graphs/788/) | ? | [Link](sites/leetcode/ConstructBinaryTree.cpp) |
|Populating Next Right Pointers in Each Node| [Link](https://leetcode.com/explore/interview/card/top-interview-questions-medium/108/trees-and-graphs/789/) | ? | [Iterative level order](sites/leetcode/RightPointer.cpp) <br/> [Using queue](sites/leetcode/RightPointer.cpp) |
| Kth Smallest Element in a BST | [Link](https://leetcode.com/problems/kth-smallest-element-in-a-bst/solution/) | ? | [Iterative using stack](sites/leetcode/KthSmallestBinarySearchTree.cpp) <br/> [Recursive](sites/leetcode/KthSmallestBinarySearchTree.cpp) |
| Kth Largest Element in a BST | ?? | ? | [Iterative using stack](sites/leetcode/KthLargestBinarySearchTree.cpp) <br/> [Recursive](sites/leetcode/KthLargestBinarySearchTree.cpp) |
| Number of Islands | [Link](https://leetcode.com/explore/interview/card/top-interview-questions-medium/108/trees-and-graphs/792/) | ? | [Using DFS](sites/leetcode/NumberofIslands.cpp) <br/> [Using BFS](sites/leetcode/NumberofIslands.cpp) <br/> [Using disjoint set](sites/leetcode/NumberofIslandsDisjointSet.cpp) |

| Permutations | Link | Java  | C++|
|:--|:--|:--|:--|
| Letter Combinations of a Phone Number | [Link](https://leetcode.com/explore/interview/card/top-interview-questions-medium/109/backtracking/793/) | ? | [Iterative](sites/leetcode/LetterCombinationOfPhoneNumber.cpp) <br/> [Recursive](sites/leetcode/LetterCombinationOfPhoneNumber.cpp) |
| Generate Balanced Parentheses | [Link](https://leetcode.com/explore/interview/card/top-interview-questions-medium/109/backtracking/794/) | ? | [Recursive](sites/leetcode/GenerateParentheses.cpp) |

| Backtracking | Link | Java  | C++|
|:--|:--|:--|:--|
| Permutations | [Link](https://leetcode.com/explore/interview/card/top-interview-questions-medium/109/backtracking/795/) | ? | [Backtracking](sites/leetcode/Permutations.cpp) |
| Subset | [Link](https://leetcode.com/problems/subsets/) | ? | [Backtracking](sites/leetcode/Subsets.cpp) |
| Subset without duplicates | [Link](https://leetcode.com/problems/subsets-ii/) | ? | [Backtracking](sites/leetcode/Subsets.cpp) |
| Combination Sum | [Link](https://leetcode.com/problems/combination-sum/) | ? | [Backtracking](sites/leetcode/CombinationSum.cpp) |
| Combination Sum without duplicates | [Link](https://leetcode.com/problems/combination-sum-ii/) | ? | [Backtracking](sites/leetcode/CombinationSum.cpp) |
| Word Search | [Link](https://leetcode.com/explore/interview/card/top-interview-questions-medium/109/backtracking/797/) | ? | Not working [Recursive DFS](sites/leetcode/WordSearch.cpp) <br/>  |

| Maths | Link | Java  | C++|
|:--|:--|:--|:--|
| Top K frequent elements | [Link](https://leetcode.com/explore/interview/card/top-interview-questions-medium/110/sorting-and-searching/799/) | ? | [Using hashmap and sorting](sites/leetcode/FrequentElements.cpp) <br/> [Using hashmap and priority queue](sites/leetcode/FrequentElements.cpp) <br/> [Using Quick Select](sites/leetcode/FrequentElementsQuickSelect.cpp) |
|  | [Link]() | ? | []() |
<br/>



