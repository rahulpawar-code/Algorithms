

# Table of Contents
1. [System Design Questions](#system-design-questions)
2. [Java OOP Concepts](#java-oop-concepts)
3. [References](#references)
4. [Algorithms and Data Structures](#algorithms-and-data-structures)
5. [TODO](#todo-add)



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
**Generics, Equality, String Representation of Object, Hash code of Object, Dynamic array, Iterable, Comparable, assert, Comparator, Immutability**


# References

* **Prefix Hash tree** - https://www.eecs.berkeley.edu/~sylvia/papers/pht.pdf - Prefix Hash Tree: An Indexing Data Structure over Distributed Hash Tables
* **Distributed Hash table** - https://en.wikipedia.org/wiki/Distributed_hash_table
* **Suffix tree** https://en.wikipedia.org/wiki/Suffix_tree Compressed Trie, used in pattern searching, hard algo

# Algorithms and Data Structures

1. Algorithms
2. [LeetCode](#leetcode)
3. [Google CodeJam](#google-codejam)


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
| | []() | ? | []() |

<br/>

## [Google CodeJam](sites/googlecodejam/)
1. Google Code Jam 2018
2. Google Code Jam 2020

## Princeton Algorithms Course
Princeton Algorithms [Part 1](https://www.coursera.org/learn/algorithms-part1/) and [Part2](https://www.coursera.org/learn/algorithms-part2/)

* Union Find
	 * [Quick Find](generic/union-find/QuickFind.java)
	 * [Quick Union](generic/union-find/QuickUnion.java)
	 * [Weighted Quick Union](generic/union-find/WeightedQuickUnion.java)
	 * [Weighted Quick Union with Path compression](generic/union-find/QuickUnionPathCompression.java)

* Stack
	* [Dynamic Stack](generic/stack/DynamicStack.java)
	* [StackOfStrings](generic/stack/StackOfStrings.java)

* Queue
	 * [CircularQueue](generic/queue/CircularQueue.java)
	 * [LinkedQueue](generic/queue/LinkedQueue.java)
	 * [Deque](assignments/queue/Deque.java)
	 * [RandomizedQueue](assignments/queue/RandomizedQueue.java)

* Priority Queue / Heap
	* [Max Queue](generic/priority-queue/MaxQueue.java)
	* [Min Queue](generic/priority-queue/MinQueue.java "MinQueue.java")

* Sorting
	* [Insertion sort](generic/sorting/Insertion.java "Insertion.java")
	* [Selection sort](generic/sorting/Selection.java "Selection.java")
	* [Shell sort](generic/sorting/Shell.java "Shell.java")
	* [Merge](generic/sorting/Merge.java "Merge.java")
	* [Bottom Up Merge](generic/sorting/MergeBU.java "MergeBU.java")
	* [Quicksort](generic/sorting/Quick.java "Quick.java")
	* [3-way Quicksort](generic/sorting/Quick3Way.java "Quick3Way.java")

* Symbol table / Search Trees
	* [Binary Search Tree](generic/symbol-table/BST.java)
	* [Interval Search Tree](generic/symbol-table/IntervalST.java)

* String
    * [Trie](generic/string/Trie.java)

* Other data structures
    * [Activity / Task](greedy/Activity.java "Activity.java") representation of an activity or a task

* Other algorithms
	* [Permutation of objects](assignments/queue/Permutation.java)
	* [kth element, Quick Select](generic/sorting/QuickSelect.java "QuickSelect.java")
	* [Shuffling](generic/sorting/Shuffling.java "Shuffling.java")
		* [Fisher–Yates shuffle algorithm](https://en.wikipedia.org/wiki/Fisher%E2%80%93Yates_shuffle)

* Linked List
    * [Linked List](others/linked-list/LinkedList.java)
    * [Alternating Split](others/linked-list/AlternatingSplit.java)

* Binary Search Tree
    * [BST](others/bst/BST.java)

* Greedy
    * [Activity Selection](other/greedy/ActivitySelection.java)
    * [Activity Sequencing](other/greedy/ActivitySequencing.java) Naive algorithm
    * [Activity Sequencing](other/greedy/ActivitySequencing2.java) Using union-find
* Arrays
    * [Continuous ones](others/array/ContinuousOnes.java)
    * [Infections over a distance](others/array/Contamination.java)

* Dynamic Programming
    * [Word Break problem](others/string/WordBreak.java) recursive algorithm, using trie
    * [Longest Common Subsequence](others/dynamic-programming/LongestCommonSubsequence.java) Naive, top-down, bottom up tabulation, LCS string, LCS of 3 strings
    * Shortest Common Supersequence [Using DP](others/dynamic-programming/ShortestSupersequenceDP.java)  [Using LCS](others/dynamic-programming/Shortestsuperseequence.java)
    * [Longest Common Substring](others/dynamic-programming/LongestCommonSubstring.java) Recursive, bottom-up, space optimized, print substring, without repeating characters
    * [Longest Common Substring in array](others/dynamic-programming/StemInStringArray.java) Stem in an array of strings
    * Subsequence variants: [Repeated Subsequence](others/dynamic-programming/RepeatedSubsequence.java) top-down, naive recursion, print sequence
    * [Levenshtein distance / Edit Distance](others/dynamic-programming/EditDistance.java)
    * [Largest sqaure submatrix of 1's](others/dynamic-programming/LargestSquareSubmatrix.java)
    * [Min cost path from top right to bottom down in matrix](other/dynamic-programming/MatrixMinCost.java)
    * [Maximum value of expression](others/dynamic-programming/MaxValueOfExpression.java)
    * [Subset sum partition](others/dynamic-programming/Partition.java)
    * [Three Partition](others/dynamic-programming/ThreePartition.java)
    * [Rod Cutting](others/dynamic-programming/RodCutting.java)
    * [Rod Cutting Product](others/dynamic-programming/RodCuttingProduct.java)
    * [Coin Change](others/dynamic-programming/CoinChange.java)
    * [Coin Change Ways](others/dynamic-programming/CoinChangeWays.java)
    * [Binary String with no consecutive 1's](others/dynamic-programming/BinaryStrings.java)
    * [Word Break](others/dynamic-programming/WordBreak.java)
    * [Word Break using trie](others/dynamic-programming/WordBreakUsingTrie.java)
    * [Array Adjustment cost](others/dynamic-programming/ArrayAdjustmentCost.java)
    * [No of ways for dice throws](others/dynamic-programming/DiceThrows.java)
    * [Wildcard Matching](others/dynamic-programming/WildcardMatching.java)
    * [Tripping Rain Water](others/array/TrappingRainWater.java)

* String algorithms
    * [String sorting](others/string/SortStringUsingTrie.java) Using trie data structure
    * [Auto Completion search](others/string/AutoComplete.java) Using trie
    * [English word meaning dictionary](others/string/WordMeaningDictionary.java) Using trie
    * [Longest Common Prefix](others/string/LongestCommonPrefix.java) Using trie
    * [Pattern Searching](others/string/PatternSearchingTrie.java) Using trie of all suffix
    * [Word Break problem](others/string/WordBreak.java) Using trie, recursive algorithm
    * [KMP Pattern searching](others/string/KMP.java) Search pattern in text

* Assignment
	* [Percolation](assignments/queue)
	* [Deque](assignments/queue/Deque.java)
	* [RandomizedQueue](assignments/queue/RandomizedQueue.java)
	* [8 Puzzle](assignments/8-puzzle/)

* Math
	* [GaussElimination](others/math/GaussElimination.java "GaussElimination.java") Gauss elimination or Gauss Jordan method to solve system of linear equations
	* [Point2D](https://github.com/rahulpawargithub/Algorithms/blob/master/others/math/Point2D.java "Point2D.java") Data structure to represent point in 2D space
	* [Point3D](https://github.com/rahulpawargithub/Algorithms/blob/master/others/math/Point3D.java "Point3D.java") Data structure to represent point in 3D space

 * Bit manipulation/ Bitwise hacks
    * [Basics](others/bitwise/bitwise1.cpp)
    * [Questions Links 1](https://www.techiedelight.com/Tags/Bit-Hacks/)
    * [Bit Twiddling Hacks collection](https://graphics.stanford.edu/~seander/bithacks.html)

* Computational Geometry
	* [Closest pair of points](others/math/ClosestPairPoint.java "ClosestPairPoint.java") Divide and conquer algorithm
	* [Group points which are at distance less than k](others/math/GroupPoints "GroupPoints.java") brute force algorithm
	* [Group points which are at distance less than k](others/math/GroupPoint2.java "GroupPoint2.java") divide and conquer algorithm

* Random data
    * [Random String](others/dynamic-programming/RandomString.java) Random strings
    * [Random 2D Matrix](others/dynamic-programming/Random2DMatrix.java) Random 2D boolean, binary or integer matrix


# TODO (add)

 - C++ Concepts
 - File IO, threading  related programs
