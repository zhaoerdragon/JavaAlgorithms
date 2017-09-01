package cowguest;

import com.sun.org.apache.xalan.internal.xsltc.util.IntegerArray;

import java.util.*;

/**
 * LeetCode题目
 */
public class LeetCodeQuestion {

    /**
     * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
     * Given two integers x and y, calculate the Hamming distance.
     * 461
     * @param x
     * @param y
     * @return
     */
    public static int hammingDistance(int x, int y) {
        int count = 0;
        while (x != 0 || y != 0) {
            if (x % 2 != y % 2) {
                count++;
            }
            x = x / 2;
            y = y / 2;
        }
        return count;
    }

    /**
     * 461
     * @param x
     * @param y
     * @return
     */
    public static int hammingDistance2(int x, int y) {
        /**
         * bitCount()计算数字转换为2进制有多少个1,而^位运算符则将不同的二进制数记为1,这个真的是6
         * 真的是，让我叹服。
         */
        return Integer.bitCount(x ^ y);
    }

    /**
     * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
     * You may assume that each input would have exactly one solution, and you may not use the same element twice.
     * 1
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    /**
     * 1
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int value = target - nums[i];
            if (hashMap.containsKey(value) && hashMap.get(value) != i) {
                return new int[]{i, hashMap.get(value)};
            }
        }
        return null;
    }

    /**
     * 1
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum3(int[] nums, int target) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (hashMap.containsKey(temp)) {
                return new int[]{hashMap.get(temp), i};
            }
            hashMap.put(nums[i], i);
        }
        return null;
    }

    /**
     * Initially, there is a Robot at position (0, 0). Given a sequence of its moves, judge if this robot makes a
     * circle,which means it moves back to the original place.
     * The move sequence is represented by a string. And each move is represent by a character. The valid robot moves
     * are R (Right), L (Left), U (Up) and D (down). The output should be true or false representing whether the robot
     * makes a circle.
     * 657
     * @param moves
     * @return
     */
    public static boolean judgeCircle(String moves) {
        int lr = 0;
        int ud = 0;
        for (int i = 0; i < moves.length(); i++) {
            switch (moves.charAt(i)) {
                case 'L':{
                    lr++;
                    break;
                }
                case 'R':{
                    lr--;
                    break;
                }case 'U':{
                    ud--;
                    break;
                }case 'D':{
                    ud++;
                    break;
                }
            }
        }
        if (lr == 0 && ud == 0) {
            return true;
        }
        return false;
    }

    /**
     * Given two binary trees and imagine that when you put one of them to cover the other, some nodes of the two trees
     * are overlapped while the others are not.
     * You need to merge them into a new binary tree. The merge rule is that if two nodes overlap, then sum node
     * values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of new tree.
     * 617
     * @param t1
     * @param t2
     * @return
     */
    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        t1.val = t1.val + t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }

    /**
     * 617
     * @param t1
     * @param t2
     * @return
     */
    public static TreeNode mergeTrees2(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        
        return null;
    }

    /**
     * Given an array of 2n integers, your task is to group these integers into n pairs of integer, say (a1, b1),
     * (a2, b2), ..., (an, bn) which makes sum of min(ai, bi) for all i from 1 to n as large as possible.
     * 561
     * @param nums
     * @return
     */
    public static int arrayPairSum(int[] nums) {
        int count = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i = i + 2) {
            count += nums[i];
        }
        return count;
    }

    /**
     * Given a positive integer, output its complement number. The complement strategy is to flip the bits of its
     * binary representation.
     * 476
     * @param num
     * @return
     */
    public static int findComplement(int num) {
        return Integer.highestOneBit(num) - 1 - (num - Integer.highestOneBit(num));
    }

    /**
     * Given a List of words, return the words that can be typed using letters of alphabet on only one row's of
     * American keyboard like the image below.
     * 500
     *
     * @param words
     * @return
     */
    public static String[] findWords(String[] words) {
        List<String> stringList = new ArrayList<>();
        HashMap<Character, Character> topMap = new HashMap<>();
        topMap.put('q', 'Q');
        topMap.put('w', 'W');
        topMap.put('e', 'E');
        topMap.put('r', 'R');
        topMap.put('t', 'T');
        topMap.put('y', 'Y');
        topMap.put('u', 'U');
        topMap.put('i', 'I');
        topMap.put('o', 'O');
        topMap.put('p', 'P');
        HashMap<Character, Character> middleMap = new HashMap<>();
        middleMap.put('a', 'A');
        middleMap.put('s', 'S');
        middleMap.put('d', 'D');
        middleMap.put('f', 'F');
        middleMap.put('g', 'G');
        middleMap.put('h', 'H');
        middleMap.put('j', 'J');
        middleMap.put('k', 'K');
        middleMap.put('l', 'L');
        HashMap<Character, Character> bottomMap = new HashMap<>();
        bottomMap.put('z', 'Z');
        bottomMap.put('x', 'X');
        bottomMap.put('c', 'C');
        bottomMap.put('v', 'V');
        bottomMap.put('b', 'B');
        bottomMap.put('n', 'N');
        bottomMap.put('m', 'M');
        for (int i = 0; i < words.length; i++) {
            int sign = 0;
            for (int j = 0; j < words[i].length(); j++) {
                if (topMap.containsKey(words[i].charAt(j)) || topMap.containsValue(words[i].charAt(j))) {
                    sign = sign - 203;
                }
                if (middleMap.containsKey(words[i].charAt(j)) || middleMap.containsValue(words[i].charAt(j))) {
                }
                if (bottomMap.containsKey(words[i].charAt(j)) || bottomMap.containsValue(words[i].charAt(j))) {
                    sign = sign + 202;
                }
            }
            if (sign == 0 || sign == words[i].length()*202 || sign == -words[i].length()*203) {
                stringList.add(words[i]);
            }
        }
        String[] strings = new String[stringList.size()];
        for (int i = 0; i < stringList.size(); i++) {
            strings[i] = stringList.get(i);
        }
        return strings;
    }

    /**
     * Given a string, you need to reverse the order of characters in each word within a sentence while still
     * preserving whitespace and initial word order.
     * 557
     *
     * @param s
     * @return
     */
    public static String reverseWords(String s) {
        String[] strings = s.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            stringBuilder.append(new StringBuffer(strings[i]).reverse().toString()+" ");
        }
        return stringBuilder.toString().trim();
    }

    /**
     * Write a function that takes a string as input and returns the string reversed.
     * 344
     * @param s
     * @return
     */
    public static String reverseString(String s) {
        return new StringBuffer(s).reverse().toString();
    }

    /**
     * Given an integer array with even length, where different numbers in this array represent different kinds of
     * candies. Each number means one candy of the corresponding kind. You need to distribute these candies equally in
     * number to brother and sister. Return the maximum number of kinds of candies the sister could gain.
     * 575
     * @param candies
     * @return
     */
    public static int distributeCandies(int[] candies) {
        Arrays.sort(candies);
        int kinds = 1;
        for (int i = 1; i < candies.length; i++) {
            if (candies[i] > candies[i - 1] ) {
                kinds++;
            }
        }
        return Math.min(candies.length / 2, kinds);
    }

    /**
     * In MATLAB, there is a very useful function called 'reshape', which can reshape a matrix into a new one with
     * different size but keep its original data.
     * You're given a matrix represented by a two-dimensional array, and two positive integers r and c representing
     * the row number and column number of the wanted reshaped matrix, respectively.
     * The reshaped matrix need to be filled with all the elements of the original matrix in the same row-traversing
     * order as they were.
     * If the 'reshape' operation with given parameters is possible and legal, output the new reshaped matrix;
     * Otherwise, output the original matrix.
     * 566
     * @param nums
     * @param r
     * @param c
     * @return
     */
    public static int[][] matrixReshape(int[][] nums, int r, int c) {
        int tempRow = nums.length;
        int tempColumn = nums[0].length;
        if (tempRow * tempColumn != r * c) {
            return nums;
        }
        int[] temp = new int[tempRow * tempColumn];
        int k = 0;
        for (int i = 0; i < tempRow; i++) {
            for (int j = 0; j < tempColumn; j++) {
                temp[k++] = nums[i][j];
            }
        }
        k = 0;
        int[][] tempArray = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                tempArray[i][j] = temp[k++];
            }
        }
        return tempArray;
    }

    /**
     * Write a program that outputs the string representation of numbers from 1 to n.
     * But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output
     * “Buzz”. For numbers which are multiples of both three and five output “FizzBuzz”.
     * 412
     * @param n
     * @return
     */
    public static List<String> fizzBuzz(int n) {
        List<String> tempString = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                tempString.add("FizzBuzz");
            }else if (i % 3 == 0) {
                tempString.add("Fizz");
            }else if (i % 5 == 0) {
                tempString.add("Buzz");
            }else {
                tempString.add("" + i);
            }
        }
        return tempString;
    }

    /**
     * You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water.
     * Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water,
     * and there is exactly one island (i.e., one or more connected land cells). The island doesn't have "lakes"
     * (water inside that isn't connected to the water around the island). One cell is a square with side length 1.
     * The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.
     * 463
     * @param grid
     * @return
     */
    public static int islandPerimeter(int[][] grid) {

        return 0;
    }
}
