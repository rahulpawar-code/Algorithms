
# Algorithms and Data Structures

1. Contains chapter code and programming exercise solutions to Princeton
Algorithms [Part 1](https://www.coursera.org/learn/algorithms-part1/) and [Part2](https://www.coursera.org/learn/algorithms-part2/)
2. Other general data structures and algorithms
3. Explanation & solutions to Google Code Jam programming competitions

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

* Greedy
    * [Activity Selection](other/greedy/ActivitySelection.java)
    * [Activity Sequencing](other/greedy/ActivitySequencing.java) Naive algorithm
    * [Activity Sequencing](other/greedy/ActivitySequencing2.java) Using union-find

* Dynamic Programming
    * [Word Break problem](others/string/WordBreak.java) recursive algorithm, using trie
    * [Longest Common Subsequence](others/dynamic-programming/LongestCommonSubsequence.java) Naive, top-down, bottom up tabulation, LCS string, LCS of 3 strings
    * Shortest Common Supersequence [Using DP](others/dynamic-programming/ShortestSupersequenceDP.java)  [Using LCS](others/dynamic-programming/Shortestsuperseequence.java)
    * [Longest Common Substring](others/dynamic-programming/LongestCommonSubstring.java) Recursive, bottom-up, space optimized, print substring, without repeating characters
    * [Longest Common Substring in array](others/dynamic-programming/StemInStringArray.java) Stem in an array of strings
    * Subsequence variants: [Repeated Subsequence](others/dynamic-programming/RepeatedSubsequence.java) top-down, naive recursion, print sequence
    * [Levenshtein distance / Edit Distance](others/dynamic-programming/EditDistance.java)

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

* Computational Geometry
	* [Closest pair of points](others/math/ClosestPairPoint.java "ClosestPairPoint.java") Divide and conquer algorithm
	* [Group points which are at distance less than k](others/math/GroupPoints "GroupPoints.java") brute force algorithm
	* [Group points which are at distance less than k](others/math/GroupPoint2.java "GroupPoint2.java") divide and conquer algorithm

* Google CodeJam
    * [Solution to Code Jam problems](googlecodejam/README.md) SavingTheUniverseAgain, TroubleSort, Vestigium, Nesting Depth, Parenting Partnering Returns, Indicium

* Random data
    * [Random String](others/dynamic-programming/RandomString.java) Random strings
    * [Random 2D Matrix](others/dynamic-programming/Random2DMatrix.java) Random 2D boolean, binary or integer matrix
