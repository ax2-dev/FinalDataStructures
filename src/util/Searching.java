package util;

public class Searching {

    public static void main(String[] args) {
        // THE ARRAY MUST BE SORTED FOR BINARY SEARCH, BUT IS NOT REQUIRED TO BE SORTED FOR LINEAR SEARCH
        int[] myNumbs = { 28, 29, 41, 47, 64 };
        int valueToSearchFor = 47; // In this case, we are searching for 47 in the 'myNumbs' array
        // Parameter 1: the array itself
        // Parameter 2: the value we are searching for in the array
        int indexFoundAt = linearSearch(myNumbs, valueToSearchFor);
        //int indexFoundAt = binarySearch(myNumbs, valueToSearchFor);
        if (indexFoundAt == -1) {
            System.out.println("The value we are searching for was not found in this array.");
        } else {
            System.out.println("The value we are searching for was found at index " + indexFoundAt);
        }
    }

    // Linear Search - Array
    public static int linearSearch(int array[], int valueToSearchFor) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == valueToSearchFor) {
                return i;
            }
        }
        return -1;
    }

    // Binary Search - Array
    public static int binarySearch(int array[], int x) {
        // 'x' (the second parameter) is the element being searched for
        // 's' is the start index
        // 'e' is the end index
        int s = 0; int e = array.length - 1;

        // Run repeatedly until the start index (s) is greater than the end index (e) - when this happens, it means the whole array has been searched
        while (s <= e) {
            // 'm' holds the value of the current middle index
            int m = (s + e) / 2; // This is the same formula from the slides for calculating the middle index

            if (x == array[m]) { // If x is equal to the element at the current middle index, return the middle index (search complete)
                return m;
            } else if (x > array[m]) { // If x is greater than the element at the middle index...
                s = m + 1; // ...move the start index (s) one position to the right of the middle index.
            } else if (x < array[m]) { // If x is less than the element at the middle index...
                e = m - 1; // ...move the end index (e) one position to the left of the middle index.
            }
        }

        // This part only runs when the element we are searching for was not found in the array. Return -1.
        return -1;
    }

    // Linear Search - Array List
    /*public static int linearSearch(ArrayList<Integer> arrayList, Integer valueToSearchFor) {
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i) == valueToSearchFor) {
                return i;
            }
        }
        return -1;
    }*/

    // Binary Search - Array List
    /*public static int binarySearch(ArrayList<Integer> arrayList, int x) {
        // 'x' (the second parameter) is the element being searched for
        // 's' is the start index
        // 'e' is the end index
        int s = 0; int e = arrayList.size() - 1;

        // Run repeatedly until the start index (s) is greater than the end index (e) - when this happens, it means the whole array has been searched
        while (s <= e) {
            // 'm' holds the value of the current middle index
            int m = (s + e) / 2; // This is the same formula from the slides for calculating the middle index

            if (x == arrayList.get(m)) { // If x is equal to the element at the current middle index, return the middle index (search complete)
                return m;
            } else if (x > arrayList.get(m)) { // If x is greater than the element at the middle index...
                s = m + 1; // ...move the start index (s) one position to the right of the middle index.
            } else if (x < arrayList.get(m)) { // If x is less than the element at the middle index...
                e = m - 1; // ...move the end index (e) one position to the left of the middle index.
            }
        }

        // This part only runs when the element we are searching for was not found in the array. Return -1.
        return -1;
    }*/

    // Linear Search - Linked List
    /*public static int linearSearch(LinkedList<String> linkedList, String valueToSearchFor) {
        for (int i = 0; i < linkedList.size(); i++) {
            if (linkedList.get(i).equals(valueToSearchFor)) {
                return i;
            }
        }
        return -1;
    }*/

    // Binary Search - Linked List
    /*public static int binarySearch(LinkedList<Integer> linkedList, int x) {
        // 'x' (the second parameter) is the element being searched for
        // 's' is the start index
        // 'e' is the end index
        int s = 0; int e = linkedList.size() - 1;

        // Run repeatedly until the start index (s) is greater than the end index (e) - when this happens, it means the whole array has been searched
        while (s <= e) {
            // 'm' holds the value of the current middle index
            int m = (s + e) / 2; // This is the same formula from the slides for calculating the middle index

            if (x == linkedList.get(m)) { // If x is equal to the element at the current middle index, return the middle index (search complete)
                return m;
            } else if (x > linkedList.get(m)) { // If x is greater than the element at the middle index...
                s = m + 1; // ...move the start index (s) one position to the right of the middle index.
            } else if (x < linkedList.get(m)) { // If x is less than the element at the middle index...
                e = m - 1; // ...move the end index (e) one position to the left of the middle index.
            }
        }

        // This part only runs when the element we are searching for was not found in the array. Return -1.
        return -1;
    }*/

}