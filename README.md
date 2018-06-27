# Coding Interview Questions
List of some of the famous coding interview questions and their solutions.

## Table of Content

1. [Arrays](#arrays)
	1. [Find Next Greater Element](#arrays_nge)
	2. [Find Pythagoras Triplets](#arrays_pt)
	3. [Find 3 items whose sum matches K](#arrays_ts)
	4. [Stock Span Problem](#arrays_ss)

2. [2D Arrays / Matrix](#matrix)
	1. [Rotate Matrix by 90 degree](#matrix_rotate90)
	
3. [Linked Lists](#linkedlist)
	1. [Add 2 Numbers represented by Linked List](#linkedlist_add)
	2. [Find the merging point of 2 linked lists](#linkedlist_merge)
	3. [Reverse a LinkedList in group](#linkedlist_revingrp)

4. [Set](#set)
	1. [Create sets for given array](#set_create)
	
5. [Strings](#string)
	1. [First recurring character within a string](#string_frc)
	
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

<a id='matrix' />

### 2D Array / Matrix

<a id='matrix_rotate90' />

[RotateMatrixBy90Degree.java](src/matrix/RotateMatrixBy90Degree.java) - Given a `n * n` matrix, rotate its element by 90 degrees.

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

<a id='tree' />
