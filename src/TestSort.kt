/**
 * A class to test Sort, a class
 * that contains multiple sorting algorithm methods:
 * - Radix sort
 * - Insertion sort
 * - Selection sort
 * - Quick sort
 *  The methods can sort lists of integers.
 */

import org.junit.Test
import org.junit.Assert.*

class TestSort {

    /**
     * Test that radix sort method works on a mutable, unsorted list with similar elements.
     * Test that radix sort method works on a list with one element.
     * Test that radix sort method works on an unsorted list with the smallest element at the end
     * of the list.
     * Test that radix sort works on a sorted list.
     */
    @Test
    fun testRadix() {
        val listOfNumbers = mutableListOf<Int>()
        listOfNumbers.add(409)
        val sort = Sort()
        var sortedNumbersRadix = sort.radixSort(listOfNumbers)
        assertEquals("Check That a single element list is sorted correctly", mutableListOf(mutableListOf(4, 0, 9)), sortedNumbersRadix)
        listOfNumbers.add(411)
        listOfNumbers.add(500)
        listOfNumbers.add(410)
        sortedNumbersRadix = sort.radixSort(listOfNumbers)
        assertEquals("Check That a multiple elements are sorted correctly with similar values in certain places", mutableListOf(mutableListOf(4, 0, 9),
            mutableListOf(4,1,0), mutableListOf(4,1,1), mutableListOf(5,0,0)
        ), sortedNumbersRadix)
        listOfNumbers.add(300)
        sortedNumbersRadix = sort.radixSort(listOfNumbers)
        assertEquals("Check That a smaller value gets sorted correctly", mutableListOf(mutableListOf(3,0,0),mutableListOf(4, 0, 9),
            mutableListOf(4,1,0), mutableListOf(4,1,1), mutableListOf(5,0,0)
        ), sortedNumbersRadix)
    }

    /**
     * Test that the insertion sort method works on a mutable, unsorted list with similar elements.
     * Test that the insertion sort method works on a list with one element.
     * Test that insertion sort works on a sorted list.
     */
    @Test
    fun testInsertionSort() {
        val listOfNumbers = mutableListOf<Int>()
        listOfNumbers.add(740)
        listOfNumbers.add(741)
        listOfNumbers.add(700)
        val sort = Sort()
        val sortedNumbersInsertion = sort.insertionSort(listOfNumbers)
        assertEquals("Insertion sort puts elements in the correct order, even with similar place values, in a large list", mutableListOf(700,740,741), sortedNumbersInsertion)
        assertEquals("Insertion sort works on a list with one element", mutableListOf(10), sort.insertionSort(
            mutableListOf(10)))
        assertEquals("Insertion sort works on a sorted list", mutableListOf(700,740,741), sort.insertionSort(sortedNumbersInsertion))
    }

    /**
     * Test that the quick sort method works on a mutable, unsorted list with similar elements.
     * Test that the quick sort method works on a list with one element.
     * Test that quick sort works on a sorted list.
     */
    @Test
    fun testQuickSort() {
        val listOfNumbers = mutableListOf<Int>()
        listOfNumbers.add(740)
        listOfNumbers.add(741)
        listOfNumbers.add(700)
        val sort = Sort()
        val sortedNumbersQuick = sort.quickSort(listOfNumbers)
        assertEquals("Quick sort puts elements in the correct order, even with similar place values, in a large list", mutableListOf(700,740,741), sortedNumbersQuick)
        assertEquals("Quick sort works on a list with one element", mutableListOf(10), sort.quickSort(
            mutableListOf(10)))
        assertEquals("Quick sort works on a sorted list", mutableListOf(700,740,741), sort.quickSort(sortedNumbersQuick))
    }

    /**
     * Test that the selection sort method works on a mutable, unsorted list with similar elements.
     * Test that the selection sort method works on a list with one element.
     * Test that the selection sort method works on an unsorted list with two elements.
     * Test that selection sort works on a sorted list.
     */
    @Test
    fun testSelectionSort() {
        val listOfNumbers = mutableListOf<Int>()
        listOfNumbers.add(740)
        listOfNumbers.add(741)
        listOfNumbers.add(700)
        val sort = Sort()
        sort.selectionSort(listOfNumbers)
        assertEquals("Selection sort puts elements in the correct order, even with similar place values, in a large list", mutableListOf(700,740,741), listOfNumbers)
        val  singleElemList = mutableListOf(10)
        sort.selectionSort(singleElemList)
        val twoElementList = mutableListOf(60, 7)
        sort.selectionSort(twoElementList)
        assertEquals("Selection sort works on a list with one element", mutableListOf(10),
            singleElemList)
        assertEquals("Selection sort works on a sorted list", mutableListOf(7,60), twoElementList)
    }

    /**
     * Additional test cases I would have done include,
     * smallest element at end for all of them,
     * different sized numbers (for all except radix sort),
     * biggest at the beginning
     * symmetrical list
     * etc.
     */

}