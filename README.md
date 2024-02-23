# Assignment 4
This is a repository of four sorting algorithms implemented in Kotlin for DSA assignment 4. 

## Research: AlphaDev Summary and Thoughts 
I read the AlphaDev paper from Deep Mind. It spoke of an RL agent that learned to optimize CPU instructions for short fixed-length (lists of size 3, for example) or variable length lists (lists size 1 to 5, for example). In my mind, this does not count as a novel “sorting” algorithm because it doesn’t produce a new sorting algorithm in an abstract sense: it only produces a new algorithm in the practical sense of the word. As in, a new algorithm in the sequence of assembly instructions at the CPU level. Also, it only works for short lists, which may help solve some problems, like those that are recursively defined, but eventually once the recursive cases result in large enough lists, won’t the algorithm break? Improved CPU efficiency is not a new abstract sorting algorithm. 

I also read about DynSort, a sorting algorithm that selects either merge or quicksort based on the properties of the list. It seems not-optimized in its current state, but could potentially perform better with optimizations. I wonder if you could use AlphaDev to optimize implementations of DynSort?

## Algorithm Time Complexity Analysis
I randomly generated lists of different sizes to test the algorithms time performance on the lists: 

```kotlin
Algorithm, List Size, Average Runtime (ms)
SelectionSort, 1, 0
InsertionSort, 1, 0
quickSort, 1, 0
radixSort, 1, 0
SelectionSort, 10, 0
InsertionSort, 10, 0
quickSort, 10, 0
radixSort, 10, 0
SelectionSort, 100, 4
InsertionSort, 100, 0
quickSort, 100, 3
radixSort, 100, 0
SelectionSort, 1000, 139
InsertionSort, 1000, 2
quickSort, 1000, 20
radixSort, 1000, 1
SelectionSort, 5000, 2192
InsertionSort, 5000, 21
quickSort, 5000, 106
radixSort, 5000, 5
```

My insertion sort seemed the fastest? Though I think quicksort is supposed to be faster? Potentially it is worth looking into this more.

Radix sort and insertion sort seem faster on all list sizes, whereas quicksort performs worse. Perhaps my quicksort implementation is slow for some reason. 

## Master's Theorem
