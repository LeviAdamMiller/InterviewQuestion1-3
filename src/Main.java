/*
 URLify: Write a method to replace all spaces (" ") in
 a character buffer (array) with "%20". You may assume
 that the buffer has sufficient space at the end to hold
 the additional characters, and that you are given the "true"
 size of the buffer (which is different from the length or capacity
 of the buffer).

 Constraint: perform the operation in place (in the existing
 buffer), without creating a new or temporary buffer or string.

 Example:
            buffer                             size
            -------------------------------    ----
 Input      Hello, world!                      13
 Output     Hello,%20world!                    15

 Input      Dr Martin Luther King              21
 Output     Dr%20Martin%20Luther%20King        27


 Learning Objectives:
  * To practice an interview question.
  * To recognize the difference between size and length when working
    with a buffer (similar to how a resizable ArrayList, and/or a
    StringBuilder's internals would work).
  * To create and implement an algorithm to manipulate contents of an array.
  * To analyze the runtime performance of the algorithm.

 Source:
 Gayle Laakmann McDowell. 2016. Cracking the Coding Interview (6th ed.)
 CareerCup, Palo Alto, CA.
 */


import java.util.Arrays;

public class Main {
    public static final int BUFFER_CAPACITY = 32768;

    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");

        // set up empty buffer, size of 0
        char[] buffer = new char[BUFFER_CAPACITY];
        int size = 0;

        // initialize the buffer and size variables with some data
        String temp = "Dr Martin Luther King";
        for (int i = 0; i < temp.length(); i++) {
            buffer[i] = temp.charAt(i);
        }
        size = temp.length();

        // check the "before" buffer and size via println
        System.out.println(Arrays.toString(buffer));
        System.out.println("size: " + size);

        // call your method here
        solution(buffer, temp.length());
        // check the "after" buffer contents via println
        // check to see if the new buffer's size is correct

        System.out.println(Arrays.toString(buffer));
        size = 0;
        while (buffer[size] != 0) {
            size++;
        }
        System.out.println("size: " + size);
    }



    // Go from the end of the array and find white space
    // When get to white space move everything to the right of the white space 2 spaces to the right
    // size + 2
    // insert % in original white space
    // insert 2 after the percent sign
    // insert 0 to the right of the 2
    // continue through array to find another white space






    public static void solution(char[] buffer, int size) {
        char percent = '%';
        char two = '2';
        char zero = '0';
        for (int i = 0; i < size; i++) {
            if (buffer[i] == ' ') {
                moveToTheRight(buffer, i, size);
                buffer[i] = percent;
                buffer[i+1] = two;
                buffer[i+2] = zero;
                size = size + 2;
            }
        }
    }

    public static void moveToTheRight(char[] buffer, int position, int size) {
        // move everything over 2, starting from the rightmost spot
        for (int i = size - 1; i > position; i--) {
            buffer[i+2] = buffer[i];
        }
    }

}
