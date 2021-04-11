# Table of Contents
1. [System Design Questions](#system-design-questions)
2. [Java OOP Concepts](#java-oop-concepts)
3. [C++ Concepts](#c++-concpets)
4. [Operating System Concepts](#operating-system-concepts)
5. [Reading-References](#reading-references)
6. [Algorithms and Data Structures](#algorithms-and-data-structures)


# [System Design Questions](System-Design-Questions/)
Large scale system design and object oriented design questions and topics
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
* Synchronization
    * Simple producer consumer with busy wait, mutex in C++ [Link](Operating-System-Concepts/synchronization/SimpleProducerConsumer.cpp)
    * Simple producer consumer with **condition variable**, condition variable in C++ [Link](Operating-System-Concepts/synchronization/SimpleProducerConsumerCond.cpp)
* File IO
    * Print all lines which contain a given pattern [Link](Operating-System-Concepts/fileio/SearchPatternInFile.cpp)
* Memory Management
    * Implement aligned **malloc()** and **free()** [Link](Operating-System-Concepts/memory-management/aligned_malloc_free/)
    * Implement **malloc()** and **free()** [Link](Operating-System-Concepts/memory-management/my_malloc_free/)
* Hash table implementation
    * Implement elementary hash table in C++ [Link](Operating-System-Concepts/hash-table/HashTableElementary.cpp)
    * Hash table implementation in C++ using STL [Inspiration](https://aozturk.medium.com/simple-hash-map-hash-table-implementation-in-c-931965904250) &nbsp; [Link](Operating-System-Concepts/hash-table/hash-table-using-stl)

# Reading-References
* **Prefix Hash tree**
    * Prefix Hash Tree: An Indexing Data Structure over Distributed Hash Tables https://www.eecs.berkeley.edu/~sylvia/papers/pht.pdf -
* **Distributed Hash table**
    * - https://en.wikipedia.org/wiki/Distributed_hash_table
* **Suffix tree**
    * Compressed Trie, used in pattern searching, hard algo https://en.wikipedia.org/wiki/Suffix_tree
* **Hash Functions**
    * [djb2](http://www.cse.yorku.ca/~oz/hash.html)


# Algorithms and Data Structures
1. [Google CodeJam](#google-codejam)
2. Algorithms
3. [LeetCode](#leetcode)


## [Google CodeJam](sites/googlecodejam/)
1. Google Code Jam 2018
2. Google Code Jam 2020

## Princeton Algorithms Course
Princeton Algorithms [Part 1](https://www.coursera.org/learn/algorithms-part1/) and [Part2](https://www.coursera.org/learn/algorithms-part2/)


## Comprehensive guides/wiki/articles/solutions/summary
* A general approach to backtracking questions (Subsets, Permutations, Combination Sum) [Link](https://leetcode.com/explore/interview/card/top-interview-questions-medium/109/backtracking/795/discuss/18239/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partioning))
* A summary: how to use bit manipulation to solve problems easily and efficiently [Link](https://leetcode.com/explore/interview/card/top-interview-questions-medium/114/others/822/discuss/84278/A-summary:-how-to-use-bit-manipulation-to-solve-problems-easily-and-efficiently)


## Linked List
* Rearrange odd even elements in a linked list. [C++](problems/linked-list/RearrangeEvenOdd.cpp)
* Linked List [Java](problems/linked-list/LinkedList.java)
* Alternating Split [Java](problems/linked-list/AlternatingSplit.java)
* Sort linked list
    * Simple method [C++](problems/linked-list/SortLinkedListMethod1.cpp)
    * Using merge sort [C++](problems/linked-list/SortLinkedListMethod2.cpp)
* Clone list with random pointers [C++](problems/linked-list/CloneListWithRandomPointer.cpp)
* Linked List implementation
    * Push, append, delete, pop, clone list [C](problems/linked-list/LinkedList.c)

## Stack
* Dynamic Stack [Java](problems/stack/DynamicStack.java)
* StackOfStrings [Java](problems/stack/StackOfStrings.java)

## Queue
* CircularQueue [Java](problems/queue/CircularQueue.java)
* LinkedQueue [Java](problems/queue/LinkedQueue.java)
* Deque [Java](problems/queue/Deque.java)
* RandomizedQueue [Java](problems/queue/RandomizedQueue.java)

## Priority Queue and Heap
* Max Queue [Java](problems/priority-queue/MaxQueue.java)
* Min Queue [Java](problems/priority-queue/MinQueue.java)

## Binary Tree
* Binary tree
    * Recursive Preorder, inorder, postorder, height, diameter [C++](problems/binary-tree/BasicTree.cpp)

## Symbol table and Search Trees
* Binary Search Tree [Java](problems/symbol-table/BST.java)
* Interval Search Tree [Java](problems/symbol-table/IntervalST.java)

## Union Find
* Quick Find [Java](problems/union-find/QuickFind.java)
* Quick Union [Java](problems/union-find/QuickUnion.java)
* Weighted Quick Union [Java](problems/union-find/WeightedQuickUnion.java)
* Weighted Quick Union with Path compression [Java](problems/union-find/QuickUnionPathCompression.java)
* Percolation Problem [Java](problems/union-find/percolation)

## Graph
* Find the celebrity in room. [C++](problems/graph/CelebrityProblem1.cpp)

## String
* Parse decimal, hexdecimal, octal from a file and output to another. [C++](problems/string/ParseDecHexOctal.cpp)
* Check if two strings are isomorphic. [C++](problems/string/IsomorphicStrings.cpp)
* Find first unique character in a string. [C++](problems/string/firstUniqueCharacter.cpp)
* String sorting
    * Using trie data structure [Java](problems/string/SortStringUsingTrie.java)
* Auto Completion search
    * Using trie [Java](problems/string/AutoComplete.java)
* English word meaning dictionary
    * Using trie [Java](problems/string/WordMeaningDictionary.java)
* Longest Common Prefix
    * Using trie [Java](problems/string/LongestCommonPrefix.java)
* Pattern Searching
    * Using trie of all suffix [Java](problems/string/PatternSearchingTrie.java)
* Word Break problem
    * Using trie, recursive algorithm [Java](problems/string/WordBreak.java)
* KMP Pattern searching
    * Search pattern in text [Java](problems/string/KMP.java)

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
* Dutch national flag problem [C++](problems/sorting/DutchFlag.cpp)
* Merge intervals [C++](problems/sorting/MergeIntervals.cpp)
* Meeting rooms [C++](problems/sorting/MeetingRooms2.cpp)

## Searching
* Find peak element [C++](problems/searching/PeakElement.cpp)
* Search in rotated array [C++](problems/searching/SearchRotatedArray.cpp)
* Search in a 2D matrix [C++](problems/searching/SearchInMatrix.cpp)
* Find start and end of a range in a sorted array [C++](problems/searching/SearchRange.cpp)
* Find kth largest element
    * Using min heap [C++](problems/sorting/KthLargest.cpp)
    * Using max heap [C++](problems/sorting/KthLargest.cpp)
    * Using STL iterator and algorithm [C++](problems/sorting/KthLargest.cpp)
    * Using quick select algorithm [C++](problems/sorting/QuickSelect.cpp)

## Dynamic Programming
* Word Break problem
    * Recursive algorithm, using trie [Java](problems/string/WordBreak.java)
* Longest Common Subsequence
    * Naive, top-down, bottom up tabulation, LCS string, LCS of 3 strings [Java](problems/dynamic-programming/LongestCommonSubsequence.java)
* Shortest Common Supersequence
    * Using DP [Java](problems/dynamic-programming/ShortestSupersequenceDP.java)
    * Using LCS [Java](problems/dynamic-programming/Shortestsuperseequence.java)
* Longest Common Substring
    * Recursive, bottom-up, space optimized, print substring, without repeating characters [Java](problems/dynamic-programming/LongestCommonSubstring.java)
* Longest Common Substring in array
    * Stem in an array of strings [Java](problems/dynamic-programming/StemInStringArray.java)
* Subsequence variants: Repeated Subsequence
    * top-down, naive recursion, print sequence  [Java](problems/dynamic-programming/RepeatedSubsequence.java)
* Levenshtein distance / Edit Distance [Java](problems/dynamic-programming/EditDistance.java)
* Largest sqaure submatrix of 1s [Java](problems/dynamic-programming/LargestSquareSubmatrix.java)
* Min cost path from top right to bottom down in matrix [Java](problems/dynamic-programming/MatrixMinCost.java)
* Maximum value of expression [Java](problems/dynamic-programming/MaxValueOfExpression.java)
* Subset sum partition [Java](problems/dynamic-programming/Partition.java)
* Three Partition [Java](problems/dynamic-programming/ThreePartition.java)
* Rod Cutting [Java](problems/dynamic-programming/RodCutting.java)
* Rod Cutting Product [Java](problems/dynamic-programming/RodCuttingProduct.java)
* Coin Change - Minimum number of coins
    * [Java](problems/dynamic-programming/CoinChange.java)
    * [C++](problems/dynamic-programming/CoinChange.cpp)
* Coin Change Ways [Java](problems/dynamic-programming/CoinChangeWays.java)
* Binary String with no consecutive 1s [Java](problems/dynamic-programming/BinaryStrings.java)
* Word Break [Java](problems/dynamic-programming/WordBreak.java)
* Word Break using trie [Java](problems/dynamic-programming/WordBreakUsingTrie.java)
* Array Adjustment cost [Java](problems/dynamic-programming/ArrayAdjustmentCost.java)
* No of ways for dice throws [Java](problems/dynamic-programming/DiceThrows.java)
* Wildcard Matching [Java](problems/dynamic-programming/WildcardMatching.java)
* Tripping Rain Water [Java](problems/array/TrappingRainWater.java)
* Jump Game [C++](problems/dynamic-programming/JumpGame.cpp)
* Length of Longest Increasing Subsequence [C++](problems/dynamic-programming/LongestIncreasingSubsequence.cpp)

## Greedy
* Activity Selection [Java](problems/greedy/ActivitySelection.java)
* Activity Sequencing
    * Naive algorithm [Java](problems/greedy/ActivitySequencing.java)
    * Using union-find [Java](problems/greedy/ActivitySequencing2.java)

## Maths, Stats, Ordered Stats
* kth element, Quick Select [Java](problems/sorting/QuickSelect.java)
* Shuffling : using [Fisher–Yates shuffle algorithm](https://en.wikipedia.org/wiki/Fisher%E2%80%93Yates_shuffle) &nbsp; &nbsp; [Java](problems/sorting/Shuffling.java)
* GaussElimination : Gauss elimination or Gauss Jordan method to solve system of linear equations [Java](problems/math/GaussElimination.java)
* Point2D : Data structure to represent point in 2D space [Java](problems/math/Point2D.java)
* Point3D : Data structure to represent point in 3D space [Java](problems/math/Point3D.java)
* Generate Nth row of Pascal triangle
    * Recursive [C++](problems/math/PascalTriangle.cpp)
    * Iterative [C++](problems/math/PascalTriangle.cpp)
* Happy number [Wiki](https://en.wikipedia.org/wiki/Happy_number) [C++](problems/math/HappyNumber.cpp)
* Excel Sheet Column Number [C++](problems/math/SheetColumnNumber.cpp)
* Number of zeros in facorial [C++](problems/math/FactorialTrailingZeros.cpp)
* Implement power function [C++](problems/math/PowerFunction.cpp)
* Implement square root function [C++](problems/math/SquareRoot.cpp)

## Permutation
* Permutation of objects [Java](problems/queue/Permutation.java)
* Unique paths [C++](problems/math/UniquePaths.cpp)

## Encoding decoding (char, int, digits etc)
* Print all possible decoding of given digit sequence. [C++](problems/encoding-decoding/CountDecodedDigitSequence.cpp)
* Print all possible decoding of given digit sequence. [C++](problems/encoding-decoding/PrintDecodedDigitSequence.cpp)

## Other
* Find the celebrity in room. [C++](problems/others/CelebrityProblem2.cpp)
* Maximum possible length by cutting N wood pieces into K pieces. [C++](problems/others/MaxLengthForCutting.cpp)
* Merge N trasactions preserve order. [C++](problems/others/MergeTransactions.cpp)
* Stock Buy Sell to Maximize Profit. [C++](problems/string/firstUniqueCharacter.cpp)
* Find majority element. [Problem](https://www.techiedelight.com/find-majority-element-in-an-array-boyer-moore-majority-vote-algorithm/)
    * Brute Force [C++](problems/others/MajorityElement.cpp)
    * using hashmap [C++](problems/others/MajorityElement.cpp)
    * Boyer-Moore voting algorithm [wiki article](https://en.wikipedia.org/wiki/Boyer%E2%80%93Moore_majority_vote_algorithm) [C++](problems/others/MajorityElement.cpp)
* CPU task scheduling [C++](https://en.wikipedia.org/wiki/Boyer%E2%80%93Moore_majority_vote_algorithm)

## Bit manipulation/ Bitwise hacks
* Basics [Java](problems/bitwise/bitwise1.cpp)
* Questions [Links 1](https://www.techiedelight.com/Tags/Bit-Hacks/)
* Bit Twiddling Hacks [collection](https://graphics.stanford.edu/~seander/bithacks.html)

## Computational Geometry
* Closest pair of points : Divide and conquer algorithm [Java](others/math/ClosestPairPoint.java)
* Collinear points [Java](others/math/CollinearPoints.java)
* Group points which are at distance less than k : brute force algorithm [Java](others/math/GroupPoints)
* Group points which are at distance less than k : divide and conquer algorithm [Java](others/math/GroupPoint2.java)

## Random data generation
* Random String : generate random string [Java](problems/dynamic-programming/RandomString.java)
* Random 2D Matrix : generate random 2D boolean, binary or integer matrix [Java](problems/dynamic-programming/Random2DMatrix.java)

## Other data structures/ Implement some data structure
* Activity/Task : representation of an activity or a task [Java](problems/greedy/Activity.java)
* Randomized set [Problem](https://leetcode.com/explore/interview/card/top-interview-questions-medium/112/design/813/) [C++](problems/others/RandomizedSet.cpp)

## Leetcode
### Maths
* Top K frequent elements &nbsp; &nbsp; [Problem](https://leetcode.com/explore/interview/card/top-interview-questions-medium/110/sorting-and-searching/799/)
    * Using hashmap and sorting [C++](sites/leetcode/FrequentElements.cpp)
    * Using hashmap and priority queue [C++](sites/leetcode/FrequentElements.cpp)
    * Using Quick Select [C++](sites/leetcode/FrequentElementsQuickSelect.cpp)

### String
* Reverse String &nbsp; &nbsp; [Problem](https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/879/)
    * [Java](sites/leetcode/ReverseString.java)
    * [C++](sites/leetcode/ReverseString.cpp)
* Reverse Integer &nbsp; &nbsp; [Problem](https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/880/)
    * [C++](sites/leetcode/ReverseInteger.cpp)
* First unique character in a string &nbsp; &nbsp; [Problem](https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/881/)
    * [C++](sites/leetcode/FirstUniqueCharacter.cpp)
* Valid anagram &nbsp; &nbsp; [Problem](https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/882)
    * [C++](sites/leetcode/ValidAnagram.cpp)
* Valid palindrome &nbsp; &nbsp; [Problem](https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/8823)
    * [C++](sites/leetcode/ValidPalindrome.cpp)
* Longest Common Prefix &nbsp; &nbsp; [Problem](https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/887/)
    * Brute Force 1 [C++](sites/leetcode/LongestCommonPrefixMethod1.cpp)
    * Brute Force 2 [C++](sites/leetcode/LongestCommonPrefixMethod2.cpp)
    * Using Trie [C++](sites/leetcode/LongestCommonPrefixMethod3.cpp)

### Singly Linked List
* Delete Node (without previous) &nbsp; &nbsp; [Problem](https://leetcode.com/explore/interview/card/top-interview-questions-easy/93/linked-list/553/)
    * Simple Delete [C++](sites/leetcode/LinkedList.cpp)
* Remove Nth from end &nbsp; &nbsp; [Problem](https://leetcode.com/explore/interview/card/top-interview-questions-easy/93/linked-list/603/)
    * Simple Delete [C++](sites/leetcode/LinkedList.cpp)
* Reverse a linked list &nbsp; &nbsp; [Problem](https://leetcode.com/explore/interview/card/top-interview-questions-easy/93/linked-list/560/)
    * Iterative [C++](sites/leetcode/ReverseList.cpp)
    * Recursive [C++](sites/leetcode/ReverseList.cpp)
* Merge two sorted &nbsp; &nbsp; [Problem](https://leetcode.com/explore/interview/card/top-interview-questions-easy/93/linked-list/771/)
    * Simple [C++](sites/leetcode/MergeSortedList.cpp)
* Palindrome List &nbsp; &nbsp; [Problem](https://leetcode.com/explore/interview/card/top-interview-questions-easy/93/linked-list/772/)
    * Double Reverse [C++](sites/leetcode/PalindromeList.cpp)
* Cycle in Linked List &nbsp; &nbsp; [Problem](https://leetcode.com/explore/interview/card/top-interview-questions-easy/93/linked-list/773/)
    * Slow and fast pointer [C++](sites/leetcode/LinkedListCycle.cpp)
* Sum two numbers &nbsp; &nbsp; [Problem](https://leetcode.com/explore/interview/card/top-interview-questions-medium/107/linked-list/783/)
    * [C++](sites/leetcode/SumTwoNumbers.cpp)
* Odd Even Linked List &nbsp; &nbsp; [Problem](https://leetcode.com/explore/interview/card/top-interview-questions-medium/107/linked-list/784/)
    * [C++](sites/leetcode/OddEvenList.cpp)
* Intersection of Two Linked Lists &nbsp; &nbsp; [Problem](https://leetcode.com/explore/interview/card/top-interview-questions-medium/107/linked-list/785/)
    * Difference of Lengths [C++](sites/leetcode/ListIntersection.cpp)
    * Traversal Pointer reassignment [C++](sites/leetcode/ListIntersection.cpp)

### Binary Tree
* Max depth &nbsp; &nbsp; [Problem](https://leetcode.com/explore/interview/card/top-interview-questions-easy/94/trees/555/)
    * Max Depth [C++](sites/leetcode/BinaryTree.cpp)
* Validate Binary search Tree &nbsp; &nbsp; [Problem](https://leetcode.com/explore/interview/card/top-interview-questions-easy/94/trees/625/)
    * Validate BST [C++](sites/leetcode/BinaryTree.cpp)
* Symmeric Binary Tree &nbsp; &nbsp; [Problem](https://leetcode.com/explore/interview/card/top-interview-questions-easy/94/trees/627/)
    * Iterative [C++](sites/leetcode/SymmetricBinaryTree.cpp)
    * Recursive [C++](sites/leetcode/SymmetricBinaryTree.cpp)
* Level Order Of Tree &nbsp; &nbsp; [Problem](https://leetcode.com/explore/interview/card/top-interview-questions-easy/94/trees/628/)
    * Using queue [C++](sites/leetcode/BinaryTreeTraversals.cpp)
* Sorted Array to Binary Search Tree &nbsp; &nbsp; [Problem](https://leetcode.com/explore/interview/card/top-interview-questions-easy/94/trees/631/)
    * Recursive [C++](sites/leetcode/SortedArratToBST.cpp)
* Inorder traversal &nbsp; &nbsp; [Problem](https://leetcode.com/explore/interview/card/top-interview-questions-medium/108/trees-and-graphs/786/)
    * Iterative using stack [C++](sites/leetcode/BinaryTreeTraversals.cpp)
    * Recursive [C++](sites/leetcode/BinaryTreeTraversals.cpp)
* Zigzag/spiral level order traversal &nbsp; &nbsp; [Problem](https://leetcode.com/explore/interview/card/top-interview-questions-medium/108/trees-and-graphs/787/)
    * [C++](sites/leetcode/BinaryTreeTraversals.cpp)
* Construct Binary Tree from Preorder and Inorder Traversal &nbsp; &nbsp; [Problem](https://leetcode.com/explore/interview/card/top-interview-questions-medium/108/trees-and-graphs/788/)
    * [C++](sites/leetcode/ConstructBinaryTree.cpp)
* Populating Next Right Pointers in Each Node [Problem](https://leetcode.com/explore/interview/card/top-interview-questions-medium/108/trees-and-graphs/789/)
    * Iterative level order [C++](sites/leetcode/RightPointer.cpp)
    * Using queue [C++](sites/leetcode/RightPointer.cpp)
* Kth Smallest Element in a BST &nbsp; &nbsp; [Problem](https://leetcode.com/problems/kth-smallest-element-in-a-bst/solution/)
    * Iterative using stack [C++](sites/leetcode/KthSmallestBinarySearchTree.cpp)
    * Recursive [C++](sites/leetcode/KthSmallestBinarySearchTree.cpp)
* Kth Largest Element in a BST | ?? | ? |
    * Iterative using stack [C++](sites/leetcode/KthLargestBinarySearchTree.cpp)
    * Recursive [C++](sites/leetcode/KthLargestBinarySearchTree.cpp)
* Number of Islands &nbsp; &nbsp; [Problem](https://leetcode.com/explore/interview/card/top-interview-questions-medium/108/trees-and-graphs/792/)
    * Using DFS [C++](sites/leetcode/NumberofIslands.cpp)
    * Using BFS [C++](sites/leetcode/NumberofIslands.cpp)
    * Using disjoint set [C++](sites/leetcode/NumberofIslandsDisjointSet.cpp)

### Permutations
* Letter Combinations of a Phone Number &nbsp; &nbsp; [Problem](https://leetcode.com/explore/interview/card/top-interview-questions-medium/109/backtracking/793/)
    * Iterative [C++](sites/leetcode/LetterCombinationOfPhoneNumber.cpp)
    * Recursive [C++](sites/leetcode/LetterCombinationOfPhoneNumber.cpp)
* Generate Balanced Parentheses &nbsp; &nbsp; [Problem](https://leetcode.com/explore/interview/card/top-interview-questions-medium/109/backtracking/794/)
    * Recursive [C++](sites/leetcode/GenerateParentheses.cpp)

### Backtracking
* Permutations &nbsp; &nbsp; [Problem](https://leetcode.com/explore/interview/card/top-interview-questions-medium/109/backtracking/795/)
    * Backtracking [C++](sites/leetcode/Permutations.cpp)
* Subset &nbsp; &nbsp; [Problem](https://leetcode.com/problems/subsets/)
    * Backtracking [C++](sites/leetcode/Subsets.cpp)
* Subset without duplicates &nbsp; &nbsp; [Problem](https://leetcode.com/problems/subsets-ii/)
    * Backtracking [C++](sites/leetcode/Subsets.cpp)
* Combination Sum &nbsp; &nbsp; [Problem](https://leetcode.com/problems/combination-sum/)
    * Backtracking [C++](sites/leetcode/CombinationSum.cpp)
* Combination Sum without duplicates &nbsp; &nbsp; [Problem](https://leetcode.com/problems/combination-sum-ii/)
    * Backtracking [C++](sites/leetcode/CombinationSum.cpp)
* Word Search | [Link](https://leetcode.com/explore/interview/card/top-interview-questions-medium/109/backtracking/797/)
    * Not working, Recursive DFS [C++](sites/leetcode/WordSearch.cpp)