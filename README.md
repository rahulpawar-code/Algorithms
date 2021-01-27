
# Table of Contents
1. [Algorithms and Data Structures](#algorithms-and-data-structures)
2. [System Design Questions](#system-design-questions)
3. [Java OOP Concepts](#java-oop-concepts)
4. [Algorithm References](#algorithm-references)

# TODO (add)
C++ Concepts

# [System Design Questions](System-Design-Questions/README.md)
Large scale system design and object oriented design questions and topics

## Topics
1. Keywords To Remember
2. Infrastructure Design Questions
3. System Design Questions
4. Object Oriented Design Questions
5. External References

# [Java OOP Concepts](Java-Concepts/README.md)
Short sample programs to demonstrate the inbuilt object oriented concepts in Java language.

## Topics
1. Generics
2. Equility
3. String Representation of Object
4. Hash code of Object
5. Dynamic array
6. Iterable
7. Comparable
8. assert
9. Comparator
10. Immutability


# Algorithm References

* **Prefix Hash tree** - https://www.eecs.berkeley.edu/~sylvia/papers/pht.pdf - Prefix Hash Tree: An Indexing Data Structure over Distributed Hash Tables
* **Distributed Hash table** - https://en.wikipedia.org/wiki/Distributed_hash_table
* **Suffix tree** https://en.wikipedia.org/wiki/Suffix_tree Compressed Trie, used in pattern searching, hard algo

# Algorithms and Data Structures

1. Algorithms 
2. [LeetCode](#leetcode) 
3. [Google CodeJam](#google-codejam)


1. Contains chapter code and programming exercise solutions to Princeton
Algorithms [Part 1](https://www.coursera.org/learn/algorithms-part1/) and [Part2](https://www.coursera.org/learn/algorithms-part2/)
2. Other general data structures and algorithms
3. Explanation & solutions to Google Code Jam programming competitions


## Leetcode
| String | Link | Java  | C++|
|:--|--:|--:|--:|
| Reverse String | [link](https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/879/) | [ReverseString.java](sites/leetcode/ReverseString.java) | [ReverseString.cpp](sites/leetcode/ReverseString.cpp) |
| Reverse Integer |  [link](https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/880/) | ? | [ReverseInteger.cpp](sites/leetcode/ReverseInteger.cpp)  |
| First unique character in a string |  [link](https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/881/) | ? | [FirstUniqueCharacter.cpp](sites/leetcode/FirstUniqueCharacter.cpp) |
| Valid anagram | [link](https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/882) | ? | [ValidAnagram.cpp](sites/leetcode/ValidAnagram.cpp) |
| Valid palindrome |  [link](https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/8823) | ? | [ValidPalindrome.cpp](sites/leetcode/ValidPalindrome.cpp) |
| Longest Common Prefix |  [link](https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/887/) | ? | [Brute Force 1](sites/leetcode/LongestCommonPrefixMethod1.cpp) <br/> [Brute Force 2](sites/leetcode/LongestCommonPrefixMethod2.cpp) <br/> [Using Trie](sites/leetcode/LongestCommonPrefixMethod3.cpp) |


| Singly Linked List| Link | Java  | C++|
|:--|--:|--:|--:|
| Delete Node (without previous) | [link](https://leetcode.com/explore/interview/card/top-interview-questions-easy/93/linked-list/553/) | ? | [Simple Delete](sites/leetcode/LinkedList.cpp) |
| Remove Nth from end | [link](https://leetcode.com/explore/interview/card/top-interview-questions-easy/93/linked-list/603/) | ? | [Simple Delete](sites/leetcode/LinkedList.cpp) |
| Reverse a linked list | [link](https://leetcode.com/explore/interview/card/top-interview-questions-easy/93/linked-list/560/) | ? | [Iterative](sites/leetcode/ReverseList.cpp) <br/> [Recursive](sites/leetcode/ReverseList.cpp)|
| Merge two sorted | [link](https://leetcode.com/explore/interview/card/top-interview-questions-easy/93/linked-list/771/) | ? | [Simple](sites/leetcode/MergeSortedList.cpp) |
| | [link]()| ? | []() |

## [Google CodeJam](sites/googlecodejam/README.md) 
1. Google Code Jam 2018
2. Google Code Jam 2020

## Algorithms 


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

* Google CodeJam
    * [Solution to Code Jam problems](googlecodejam/README.md) SavingTheUniverseAgain, TroubleSort, Vestigium, Nesting Depth, Parenting Partnering Returns, Indicium

* Random data
    * [Random String](others/dynamic-programming/RandomString.java) Random strings
    * [Random 2D Matrix](others/dynamic-programming/Random2DMatrix.java) Random 2D boolean, binary or integer matrix
