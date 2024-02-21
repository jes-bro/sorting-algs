/**
 * A class that houses a variety of sorting algorithms.
 * Includes radixSort, selectionSort, quickSort, and insertionSort.
 * They support mutableList<Int>s as inputs and have varying outputs.
 */
class Sort() {

    /**
     * Convert a list of integers to a list of lists of integers.
     */
    private fun Int.toDigits(): List<Int> = toString().map { it.toString().toInt() } // from stack overflow

    /**
     * Sort a mutable list of integers via radix sort.
     * @param numList a mutable list of integers.
     * @return a mutable list of mutable lists of integers that represent a sorted version of the original mutable list.
     */
    fun radixSort(numList: MutableList<Int>):MutableList<MutableList<Int>> {
        var mainList: MutableList<MutableList<Int>> = mutableListOf()
        var baseTenList: MutableList<MutableList<MutableList<Int>>> = mutableListOf(mutableListOf(), mutableListOf(), mutableListOf(), mutableListOf(), mutableListOf(), mutableListOf(), mutableListOf(), mutableListOf(), mutableListOf(), mutableListOf())
        for (number in numList) {
            val digitList = number.toDigits().toMutableList()
            mainList.add(digitList)
        }

        //First sort
        for (digit in mainList[0].size-1 downTo 0) {
            println("doing index $digit")
            //println(digit)
            println("main list: $mainList")
            for (index in 0..<mainList.size) {
                val valAtPlace = mainList[index][digit]
                baseTenList[valAtPlace].add(mainList[index])
            }
            mainList = baseTenList.flatten().toMutableList()
            baseTenList = mutableListOf(mutableListOf(), mutableListOf(), mutableListOf(), mutableListOf(), mutableListOf(), mutableListOf(), mutableListOf(), mutableListOf(), mutableListOf(), mutableListOf())
            println("main list: $mainList")
        }
        return mainList
    }

    /**
     * Sort a mutable list of integers in place via the selection sort algorithm.
     * @param numList a mutable list of integers.
     */
    fun selectionSort(numList: MutableList<Int>) {
        var unsortedLowerBound = 0
        while (unsortedLowerBound < numList.size - 1) {
            val slice = numList.slice(unsortedLowerBound..<numList.size)
            println("lower bound: $unsortedLowerBound, slice: $slice")
            println("current list is $numList")
            val minimum = slice.indexOf(slice.min()) + unsortedLowerBound
            println("list min index: $minimum")
            val temp = numList[unsortedLowerBound]
            numList[unsortedLowerBound] = numList[minimum]
            numList[minimum] = temp
            println("current list is $numList")
            unsortedLowerBound+=1
        }
    }

    /**
     * Sort a mutable list of integers using the quicksort algorithm.
     * @param numList a mutable list of integers.
     * @return a mutable list of integers that represents a sorted version of the original mutable list.
     */
    fun quickSort(numList: MutableList<Int>):MutableList<Int> {
        if (numList.size <= 1) {
            return numList
        }
        val pivot = numList[numList.size - 1]
        var rightArray = mutableListOf<Int>()
        var leftArray = mutableListOf<Int>()
        println(numList.size)
        for (index in numList.size-2 downTo 0) {
            println(index)
            if (pivot < numList[index]) {
                rightArray.add(numList[index])
            } else if (pivot >= numList[index]) {
                leftArray.add(numList[index])
            }
        }
        println("left array: $leftArray")
        println("right array: $rightArray")
        if (leftArray.isNotEmpty()) {
            leftArray = quickSort(leftArray)
        }
        if (rightArray.isNotEmpty()) {
            rightArray = quickSort(rightArray)
        }
        println("left array: $leftArray")
        println("right array: $rightArray")
        var finalList = leftArray.plus(mutableListOf(pivot)).toMutableList()
        finalList = finalList.plus(rightArray).toMutableList()
        return finalList
    }

    /**
     * Sort a mutable list of integers via insertion sort.
     * @param numList a mutable list of integers
     * @return a mutable list of mutable lists of integers that represent a sorted version of the original mutable list.
     */
    fun insertionSort (numList: MutableList<Int>):MutableList<Int> {

        for (index in 0..numList.size - 1) {
            val key = numList[index]
            var left = index - 1
            while (left >= 0 && numList[left] > key) {
                numList[left + 1] = numList[left]
                left = left - 1
            }
            numList[left + 1] = key
        }
        return numList
    }

}