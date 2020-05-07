# Coding Interview Questions
List of some of the famous coding interview questions and their solutions.

## Table of Content

1. [Arrays](#arrays)
	1. [Find Next Greater Element](#arrays_nge)
	2. [Find Pythagoras Triplets](#arrays_pt)
	3. [Find 3 items whose sum matches K](#arrays_ts)
	4. [Stock Span Problem](#arrays_ss)
	5. [Longest Increasing Subsequence](#array_lis)
	6. [Max Difference between two elements](#array_mdiff)

2. [2D Arrays / Matrix](#matrix)
	1. [Rotate Matrix by 90 degree](#matrix_rotate90)
	
3. [Numbers](#numbers)
    1. [Fibonacci Series](#numbers_fib)
    2. [Find all prime numbers in a Range](#numbers_prime_range)
    3. [Find Missing numbers in Increasing sequence](#numbers_missing_seq)
	
3. [Linked Lists](#linkedlist)
	1. [Add 2 Numbers represented by Linked List](#linkedlist_add)
	2. [Find the merging point of 2 linked lists](#linkedlist_merge)
	3. [Reverse a LinkedList in group](#linkedlist_revingrp)

4. [Set](#set)
	1. [Create sets for given array](#set_create)
	
5. [Strings](#string)
	1. [First recurring character within a string](#string_frc)
	2. [Given a string, find all sub-strings which are Palindromes](#string_all_sub_palindromes)
	3. [Replace char with word](#string_replace)
	4. [Find if 2 strings are Anagram](#string_anagram)
	
6. [Write your own questions](#wyo)
	1. [WYO - HashMap](#wyo_hashmap)
	2. [LRU Cache](#wyo_lrucache)
	3. [Fast DS](#wyo_fastDS)
	
7. [Tree](#tree)
	1. [Height of Binary Tree](#tree_height)
	2. [Tree Column Wise Sum](#tree_cws)
	3. [Zig Zag Level order Traversal](#tree_zigzag)
	4. [Check if 2 Binary trees are identical](#tree_identical)
	5. [Binary Tree - Right View](#tree_rightview)
	6. [Binary Tree - Top View](#tree_topview)
	7. [Binary Tree - Traversal](#tree_traversal)
	8. [Binary Tree - Level Order Traversal](#tree_levelorder_traversal)
	9. [Binary Tree - Reverse Level Order Traversal](#tree_levelorder_reverse_traversal)
	10. [Binary Tree to Sum Tree](#tree_to_sumtree)
	
<a id='arrays' />

### Arrays

<a id='arrays_nge' />

[NextGreaterElement](src/arrays/NextGreaterElement.java) - The Next greater Element for an element `x` is the first greater element on the *right* side of `x` in array. Elements for which no greater element exist, consider next greater element as `-1`.

<a id='arrays_pt' />

[PythagorasTriplets](src/arrays/PythagorasTriplets.java) - Given an array, find if it contains the Pythagoras Triplets. Triplet `(a,b,c)` such that `a^2 + b^2 = c^2`.

<a id='arrays_ts' />

[Three Sum Problem](src/arrays/ThreeSum.java) - Given an array and a value, find if there is a triplet in array whose sum is equal to the given value. 

<a id='arrays_ss' />

[StockSpan](src/arrays/StockSpan.java) - [https://www.geeksforgeeks.org/the-stock-span-problem/](https://www.geeksforgeeks.org/the-stock-span-problem/)

<a id='array_lis' />

[LongestIncreasingSubsequence](src/arrays/LongestIncreasingSubsequence.java) - [https://www.interviewbit.com/problems/longest-increasing-subsequence/](https://www.interviewbit.com/problems/longest-increasing-subsequence/). Find the number of elements in the longest increasing subsequence.

<a id='array_mdiff' />

[Maximum Difference between two elements](src/arrays/MaxDifferenceBetween2Numbers.java) - [https://www.geeksforgeeks.org/maximum-difference-between-two-elements/](https://www.geeksforgeeks.org/maximum-difference-between-two-elements/) - Maximum difference between two elements such that larger element appears after the smaller number.

<a id='matrix' />

### 2D Array / Matrix

<a id='matrix_rotate90' />

[RotateMatrixBy90Degree](src/matrix/RotateMatrixBy90Degree.java) - Given a `n * n` matrix, rotate its element by 90 degrees.

### Numbers

<a id='numbers_fib' />

[FibonacciSeries (Dynamic Programming)](src/numbers/FibonacciSeries.java) - Find Fibonacci series upto N.

<a id='numbers_prime_range' />

[FindAllPrimeNumbersInRange](src/numbers/FindAllPrimeNumbersInRange.java) - Find all prime numbers in a given range (N, M)

<a id='numbers_missing_seq' />

[FindMissingNumbersInIncreasingArray](src/numbers/FindMissingNumberInIncreasingArray.java) - Given an array which has numbers from [1...N] find the missing number.


<a id='linkedlist' />

### Linked Lists

<a id='linkedlist_add' />

[Add2NumbersRepresentedByLL](src/linked/list/Add2NumbersRepresentedByLL.java) - Given two numbers represented by two lists, write a function that returns sum list. The sum list is list representation of addition of two input numbers.

<a id='linkedlist_merge' />

[MergingPointOf2Liists](src/linked/list/MergingPointOf2Lists.java) - Given the pointers to the head node of 2 lists which will surely merge, find the merging point (node), at which they merge.

<a id='linkedlist_revingrp' />

[ReverseLinkedListInGroup](src/linked/list/ReverseLinkedListInGroup.java) - Reverse Linked List within a group of `k` elements. For example, if the list is `1 -> 2 -> 3 -> 4 -> 5 ->6 -> 7` and `k = 3`, then output list will be `3 -> 2 -> 1 -> 6 -> 5 -> 4 -> 7`.

<a id='set' />

### Set

<a id='set_create' />

[SetForGivenArray](src/set/SetForGivenArray.java) - Create set consisting of all the possible combinations of elements, for a given array.


<a id='string' />

### String


<a id='string_frc' />

[FirstRecurringCharacter](src/string/FirstRecurringCharacter.java) - Find the first recurring character within a given string.

<a id='string_all_sub_palindromes' />

[AllSubstringPalindromes](src/string/AllSubstringPalindromes.java) - Given a string, find all the substrings of that string which are palindrome

<a id='string_replace' />

[ReplaceACharWithAWord](src/string/ReplaceACharWithAWord.java) - Replace a single char of a String, with a word (String replace without using Java built-in functions)

<a id='string_anagram' />

[TwoStringAnagram](src/string/TwoStringAnagram.java) - Find of 2 strings are Anagrams

<a id='wyo' />

### Write your own - implementations

"Write your own" interview questions, tests your ability of understanding a particular concept or data structure.

<a id='wyo_hashmap' />

[HashMap](src/writeyourown/HashMap.java) - HashMap is a hash based Key-Value pair data structure, which will give `O(1)` time complexity for put and get operations. "Write-your-own" HashMap is a famous Java data structure based interview question to understand, how deep you know about this famous data structure.

<a id='wyo_lrucache' />

[LRUCache](src/writeyourown/LRUCache.java) - LRU Cache - is a key-value pair, which is of fixed length. Whenever the capacity of the cache reaches to MAX, then it evicts the "Least Recently Used" key.

<a id='wyo_fastDs' />

[FastDS](src/writeyourown/FastDS.java) - A custom data structure, which performs add, delete, get and getRandom() operation @ O(n) complexity

<a id='tree' />

### Tree

<a id='tree_height' />

[HeightOfBinaryTree](src/tree/HeightOfBinaryTree.java) - is a recursive way of finding the height of a binary tree (height of binary tree - max (height of left sub-tree, height of right sub-tree)

<a id='tree_cws' />

[Column Wise Sum of Binary Tree](src/tree/TreeColumnWiseSum.java) - Column wise sum of binary tree

<a id='tree_zigzag' />

[Zig Zag Traversal on Binary Tree](src/tree/ZigZagTraversalBinaryTree.java) - Zig Zag traversal on binary tree (level order) using 2 stacks

<a id='tree_identical' />

[Check if 2 binary trees are identical](src/tree/CheckIdenticalBinaryTree.java) - Using recursion to find out if 2 binary trees are identical

<a id='tree_rightview' />

[RightView](src/tree/RightView.java) - Right view of the Binary Tree

<a id='tree_topview' />

[TopView](src/tree/TopView.java) - Top view of the Binary Tree

<a id='tree_traversal' />

[Traversal](src/tree/Traversal.java) - All 3 traversals of Binary Tree (Inorder, Preorder and Postorder)

<a id='tree_levelorder_traversal' />

[LevelOrderTraversal](src/tree/LevelOrderTraversal.java) - Level order Traversal of the Binary Tree

<a id='tree_levelorder_reverse_traversal' />

[ReverseLevelOrderTraversal](src/tree/ReverseLevelOrderTraversal.java) - Reverse Level order Traversal of the Binary Tree

<a id='tree_to_sumtree' />

[BinartTreeToSumTree](src/tree/BinaryTreeToSumTree.java) - Binary tree to the sum tree problem. Each parent node will have a value = cumulative (left node value + right node value)
