package cowguest;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.MatchGenerator;
import com.sun.org.apache.xalan.internal.xsltc.util.IntegerArray;
import org.omg.PortableInterceptor.INACTIVE;
import sun.awt.SunHints;

import javax.swing.*;
import javax.swing.text.html.HTMLDocument;
import java.net.Inet4Address;
import java.util.*;

/**
 * LeetCode题目
 */
public class LeetCodeQuestion {

    /**
     * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
     * Given two integers x and y, calculate the Hamming distance.
     * 461
     *
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
     *
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
     *
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
     *
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
     *
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
     *
     * @param moves
     * @return
     */
    public static boolean judgeCircle(String moves) {
        int lr = 0;
        int ud = 0;
        for (int i = 0; i < moves.length(); i++) {
            switch (moves.charAt(i)) {
                case 'L': {
                    lr++;
                    break;
                }
                case 'R': {
                    lr--;
                    break;
                }
                case 'U': {
                    ud--;
                    break;
                }
                case 'D': {
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
     *
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
     * Given an array of 2n integers, your task is to group these integers into n pairs of integer, say (a1, b1),
     * (a2, b2), ..., (an, bn) which makes sum of min(ai, bi) for all i from 1 to n as large as possible.
     * 561
     *
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
     *
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
            if (sign == 0 || sign == words[i].length() * 202 || sign == -words[i].length() * 203) {
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
            stringBuilder.append(new StringBuffer(strings[i]).reverse().toString() + " ");
        }
        return stringBuilder.toString().trim();
    }

    /**
     * Write a function that takes a string as input and returns the string reversed.
     * 344
     *
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
     *
     * @param candies
     * @return
     */
    public static int distributeCandies(int[] candies) {
        Arrays.sort(candies);
        int kinds = 1;
        for (int i = 1; i < candies.length; i++) {
            if (candies[i] > candies[i - 1]) {
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
     *
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
     *
     * @param n
     * @return
     */
    public static List<String> fizzBuzz(int n) {
        List<String> tempString = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                tempString.add("FizzBuzz");
            } else if (i % 3 == 0) {
                tempString.add("Fizz");
            } else if (i % 5 == 0) {
                tempString.add("Buzz");
            } else {
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
     *
     * @param grid
     * @return
     */
    public static int islandPerimeter(int[][] grid) {
        int count = 0;
        int row = grid.length;
        int column = grid[0].length;
        int oneNumbers = 0;
        int blackLine = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j] == 1) {
                    oneNumbers++;
                } else {
                    continue;
                }
                if (j != column - 1 && grid[i][j] == grid[i][j + 1]) {
                    blackLine++;
                }
                if (i != row - 1 && grid[i][j] == grid[i + 1][j]) {

                    blackLine++;
                }
            }
        }
        return 4 * oneNumbers - 2 * blackLine;
    }

    /**
     * You are given two arrays (without duplicates) nums1 and nums2 where nums1’s elements are subset of nums2. Find
     * all the next greater numbers for nums1's elements in the corresponding places of nums2.
     * The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2. If it does
     * not exist, output -1 for this number.
     * 496
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        for (int i = 0; i < nums1.length; i++) {
            int count = -1;
            boolean sign = false;
            for (int j = 0; j < nums2.length; j++) {
                if (sign) {
                    if (nums2[j] > nums1[i]) {
                        count = nums2[j];
                        break;
                    }
                }
                if (nums1[i] == nums2[j]) {
                    sign = true;
                }
            }
            nums1[i] = count;
        }
        return nums1;
    }

    /**
     * Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
     * 637
     *
     * @param root
     * @return
     */
    public static List<Double> averageOfLevels(TreeNode root) {
        List<Integer> integerList = new LinkedList<>();
        List<Double> doubleList = new LinkedList<>();
        average(root, 0, doubleList, integerList);
        for (int i = 0; i < doubleList.size(); i++) {
            doubleList.set(i, doubleList.get(i) / integerList.get(i));
        }
        return doubleList;
    }

    public static void average(TreeNode treeNode, int i, List<Double> sum, List<Integer> count) {
        if (treeNode == null) {
            return;
        }
        if (i < sum.size()) {
            sum.set(i, sum.get(i) + treeNode.val * 1.0);
            count.set(i, count.get(i) + 1);
        } else {
            sum.add(treeNode.val * 1.0);
            count.add(1);
        }
        average(treeNode.left, i + 1, sum, count);
        average(treeNode.right, i + 1, sum, count);
    }

    /**
     * Given a group of two strings, you need to find the longest uncommon subsequence of this group of two strings.
     * The longest uncommon subsequence is defined as the longest subsequence of one of these strings and this
     * subsequence should not be any subsequence of the other strings.
     * A subsequence is a sequence that can be derived from one sequence by deleting some characters without changing
     * the order of the remaining elements. Trivially, any string is a subsequence of itself and an empty string is a
     * subsequence of any string.
     * The input will be two strings, and the output needs to be the length of the longest uncommon subsequence. If
     * the longest uncommon subsequence doesn't exist, return -1.
     * 521
     *
     * @param a
     * @param b
     * @return
     */
    public static int findLUSlength(String a, String b) {
        int count = 0;
        int length = Math.min(a.length(), b.length());
        for (int i = 0; i < length; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                count++;
            }
        }
        if (a.length() == b.length() && count == 0) {
            return -1;
        }
        return Math.max(a.length(), b.length());
    }

    /**
     * You are playing the following Nim Game with your friend: There is a heap of stones on the table, each time one
     * of you take turns to remove 1 to 3 stones. The one who removes the last stone will be the winner. You will take
     * the first turn to remove the stones.
     * Both of you are very clever and have optimal strategies for the game. Write a function to determine whether you
     * can win the game given the number of stones in the heap.
     * For example, if there are 4 stones in the heap, then you will never win the game: no matter 1, 2, or 3 stones
     * you remove, the last stone will always be removed by your friend.
     * 292
     *
     * @param n
     * @return
     */
    public static boolean canWinNim(int n) {
        if (n % 4 == 0) {
            return false;
        }
        return true;
    }

    /**
     * Given an array of integers, every element appears twice except for one. Find that single one.
     * 136
     *
     * @param nums
     * @return
     */
    public static int singleNumber(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashSet.contains(nums[i])) {
                hashSet.remove(nums[i]);
            } else {
                hashSet.add(nums[i]);
            }
        }
        Iterator<Integer> iterator = hashSet.iterator();
        return iterator.next();
    }

    /**
     * Given a binary array, find the maximum number of consecutive 1s in this array.
     * 485
     *
     * @param nums
     * @return
     */
    public static int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count = 0;
            } else {
                count++;
                if (count > max) {
                    max = count;
                }
            }
        }
        return max;
    }

    /**
     * Given a binary tree, find its maximum depth.
     * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf
     * node.
     * 104
     *
     * @param root
     * @return
     */
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = 1 + maxDepth(root.left);
        int right = 1 + maxDepth(root.right);
        return Math.max(left, right);
    }

    /**
     * Given a word, you need to judge whether the usage of capitals in it is right or not.
     * We define the usage of capitals in a word to be right when one of the following cases holds:
     * All letters in this word are capitals, like "USA".
     * All letters in this word are not capitals, like "leetcode".
     * Only the first letter in this word is capital if it has more than one letter, like "Google".
     * Otherwise, we define that this word doesn't use capitals in a right way.
     * 520
     *
     * @param word
     * @return
     */
    public static boolean detectCapitalUse(String word) {
        if (word.equals(word.toUpperCase()) || word.equals(word.toLowerCase())) {
            return true;
        }
        if (word.length() >= 2 && Character.isUpperCase(word.charAt(0)) && word.substring(1).equals(word.substring(1).toLowerCase())) {
            return true;
        }
        return false;
    }

    /**
     * Invert a binary tree.
     * 226
     *
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    /**
     * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear
     * once.
     * Find all the elements of [1, n] inclusive that do not appear in this array.
     * Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as
     * extra space.
     * 448
     *
     * @param nums
     * @return
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> integerList = new LinkedList<>();
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            hashSet.add(nums[i]);
            nums[i] = 0;
        }
        for (int temp : hashSet) {
            nums[temp - 1] = 1;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 1) {
                integerList.add(i + 1);
            }
        }
        return integerList;
    }

    /**
     * Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.
     * 371
     *
     * @param a
     * @param b
     * @return
     */
    public int getSum(int a, int b) {
        return b == 0 ? a : getSum(a ^ b, (a & b) << 1);
    }

    /**
     * Given a Binary Search Tree and a target number, return true if there exist two elements in the BST such that
     * their sum is equal to the given target.
     * 653
     *
     * @param root
     * @param k
     * @return
     */
    public static boolean findTarget(TreeNode root, int k) {
        if (null == root) {
            return false;
        }
        List<Integer> integerList = new ArrayList<>();
        inorder(root, integerList);
        int l = 0;
        int r = integerList.size() - 1;
        while (l < r) {                                     //奇迹的时刻，先是中序遍历形成单调数组，然后左右两边查找，666
            int sum = integerList.get(l) + integerList.get(r);
            if (k == sum) {
                return true;
            } else if (k < sum) {
                r--;
            } else l++;
        }
        return false;
    }

    /**
     * 对二叉树中序遍历后即可形成单调递增数组，厉害
     *
     * @param root
     * @param integerList
     */
    public static void inorder(TreeNode root, List<Integer> integerList) {
        if (null == root) {
            return;
        }
        inorder(root.left, integerList);
        integerList.add(root.val);
        inorder(root.right, integerList);
    }

    /**
     * Given a binary search tree and the lowest and highest boundaries as L and R, trim the tree so that all its
     * elements lies in [L, R] (R >= L). You might need to change the root of the tree, so the result should return
     * the new root of the trimmed binary search tree.
     * 669
     *
     * @param root
     * @param L
     * @param R
     * @return
     */
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) {
            return null;
        }
        if (root.val < L) {
            return trimBST(root.right, L, R);
        }
        if (root.val > R) {
            return trimBST(root.left, L, R);
        }
        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        return root;
    }

    /**
     * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
     * For example:
     * Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
     * 258
     *
     * @param num
     * @return
     */
    public static int addDigits(int num) {
        while (num / 10 > 0) {
            int sum = 0;
            int temp = num;
            while (temp > 0) {
                sum = sum + temp % 10;
                temp = temp / 10;
            }
            num = sum;
        }
        return num;
    }

    /**
     * Given two strings s and t which consist of only lowercase letters.
     * String t is generated by random shuffling string s and then add one more letter at a random position.
     * Find the letter that was added in t.
     * 389
     *
     * @param s
     * @param t
     * @return
     */
    public static char findTheDifference(String s, String t) {
        int charCode = t.charAt(s.length());
        for (int i = 0; i < s.length(); ++i) {
            charCode -= (int) s.charAt(i);
            charCode += (int) t.charAt(i);
        }
        return (char) charCode;
    }

    /**
     * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of
     * the non-zero elements.
     * For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
     * Note:
     * You must do this in-place without making a copy of the array.
     * Minimize the total number of operations.
     * 283
     *
     * @param nums
     */
    public static void moveZeroes(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] != 0) {
                        nums[i] = nums[j];
                        nums[j] = 0;
                        break;
                    }
                    if (j == nums.length - 1 && nums[j] == 0) {
                        return;
                    }
                }
            }
        }
    }

    /**
     * You need to construct a string consists of parenthesis and integers from a binary tree with the preorder
     * traversing way.
     * The null node needs to be represented by empty parenthesis pair "()". And you need to omit all the empty
     * parenthesis pairs that don't affect the one-to-one mapping relationship between the string and the original
     * binary tree.
     * 606
     *
     * @param t
     * @return
     */
    public static String tree2str(TreeNode t) {
        String tempString = "";
        if (t == null) {
            return "";
        }
        tempString = tempString + t.val;
        if (t.left != null && t.right != null) {
            return tempString + "(" + tree2str(t.left) + ")" + "(" + tree2str(t.right) + ")";
        }
        if (t.left != null) {
            return tempString + "(" + tree2str(t.left) + ")";
        }
        if (t.right != null) {
            return tempString + "()" + "(" + tree2str(t.right) + ")";
        }
        return tempString;
    }

    /**
     * Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is
     * changed to the original key plus sum of all keys greater than the original key in BST.
     * 538
     *
     * @param root
     * @return
     */
    public static TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<Integer> integerList = new ArrayList<>();
        addVal(root, integerList);
        putVal(root, integerList);

        return root;
    }

    /**
     * 中序遍历
     *
     * @param root
     * @param integerList
     */
    public static void addVal(TreeNode root, List<Integer> integerList) {
        if (root == null) {
            return;
        }
        addVal(root.left, integerList);
        integerList.add(root.val);
        addVal(root.right, integerList);
    }

    /**
     * 加在一起
     *
     * @param treeNode
     * @param integerList
     */
    public static void putVal(TreeNode treeNode, List<Integer> integerList) {
        if (treeNode == null) {
            return;
        }
        putVal(treeNode.left, integerList);
        for (int i = 0; i < integerList.size(); i++) {
            if (integerList.get(i) == treeNode.val) {
                for (int k = i + 1; k < integerList.size(); k++) {
                    treeNode.val = treeNode.val + integerList.get(k);
                }
                break;
            }
        }
        putVal(treeNode.right, integerList);
    }

    /**
     * For a web developer, it is very important to know how to design a web page's size. So, given a specific
     * rectangular web page’s area, your job by now is to design a rectangular web page, whose length L and width W
     * satisfy the following requirements:
     * 492
     *
     * @param area
     * @return
     */
    public int[] constructRectangle(int area) {
        int[] arrayInt = new int[2];
        if (area == 1) {
            return new int[]{1, 1};
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= area / 2; i++) {
            if ((i * (area / i) == area) && (Math.abs(i - area / i) < min)) {
                arrayInt[0] = Math.max(i, area / i);
                arrayInt[1] = Math.min(i, area / i);
                min = Math.abs(i - area / i);
            }
        }
        return arrayInt;
    }

    /**
     * Given an m * n matrix M initialized with all 0's and several update operations.
     * Operations are represented by a 2D array, and each operation is represented by an array with two positive
     * integers a and b, which means M[i][j] should be added by one for all 0 <= i < a and 0 <= j < b.
     * You need to count and return the number of maximum integers in the matrix after performing all the operations.
     * 598
     *
     * @param m
     * @param n
     * @param ops
     * @return
     */
    public static int maxCount(int m, int n, int[][] ops) {
        if (ops.length == 0) {
            return m * n;
        }
        int count = 0;
        int row = Integer.MAX_VALUE;
        int line = Integer.MAX_VALUE;
        for (int i = 0; i < ops.length; i++) {
            if (row > ops[i][0]) {
                row = ops[i][0];
            }
            if (line > ops[i][1]) {
                line = ops[i][1];
            }
        }
        return row * line;
    }

    /**
     * Given a non-empty integer array of size n, find the minimum number of moves required to make all array elements
     * equal, where a move is incrementing n - 1 elements by 1.
     * 453
     *
     * @param nums
     * @return
     */
    public static int minMoves(int[] nums) {
        if (nums.length == 0) return 0;
        int min = nums[0];
        for (int n : nums) min = Math.min(min, n);
        int res = 0;
        for (int n : nums) res += n - min;
        return res;
    }

    /**
     * Given two arrays, write a function to compute their intersection.
     * 349
     * 这是求两个数组的交集，亏我没看懂题目还抄答案
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> intersect = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                intersect.add(nums2[i]);
            }
        }
        int[] result = new int[intersect.size()];
        int i = 0;
        for (Integer num : intersect) {
            result[i++] = num;
        }
        return result;
    }

    /**
     * Related to question Excel Sheet Column Title
     * Given a column title as appear in an Excel sheet, return its corresponding column number.
     * 171
     * @param s
     * @return
     */
    public static int titleToNumber(String s) {
        int count = 0;
        char[] chars = s.toCharArray();
        int k = chars.length - 1;
        for (int i = 0; i < chars.length; i++) {
            count = count + (int) Math.pow(26, k--) * (chars[i] - 'A' + 1);
        }
        return count;
    }

    /**
     * Given a binary search tree with non-negative values, find the minimum absolute difference between values of any two nodes
     * 530
     * @param root
     * @return
     */
    public static int getMinimumDifference(TreeNode root) {
        List<Integer> integerList = new ArrayList<>();
        getAllNumber(root, integerList);
        int[] arrayInt = new int[integerList.size()];
        for (int i = 0; i < integerList.size(); i++) {
            arrayInt[i] = integerList.get(i);
        }
        Arrays.sort(arrayInt);
        int min = arrayInt[1] - arrayInt[0];
        for (int i = 1; i < arrayInt.length; i++) {
            if ((arrayInt[i] - arrayInt[i - 1]) < min) {
                min = arrayInt[i] - arrayInt[i - 1];
            }
        }
        return min;
    }

    public static void getAllNumber(TreeNode root, List<Integer> integerList) {
        if (root.left != null) {
            getAllNumber(root.left, integerList);
        }
        integerList.add(root.val);
        if (root.right != null) {
            getAllNumber(root.right, integerList);
        }
    }

    /**
     * Given an arbitrary ransom note string and another string containing letters from all the magazines, write a
     * function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will
     * return false.
     * Each letter in the magazine string can only be used once in your ransom note.
     * 383
     * @param ransomNote
     * @param magazine
     * @return
     */
    public static boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() == 0) {
            return true;
        }
        char[] ransomChars = ransomNote.toCharArray();
        Arrays.sort(ransomChars);
        char[] magazineChars = magazine.toCharArray();
        Arrays.sort(magazineChars);
        int k = 0;
        for (int i = 0; i < magazineChars.length; i++) {
            if (ransomChars[k] == magazineChars[i]) {
                k++;
            }
            if (k == ransomChars.length) {
                return true;
            }
        }
        return false;
    }

    /**
     * Say you have an array for which the ith element is the price of a given stock on day i.
     * Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one
     * and sell one share of the stock multiple times). However, you may not engage in multiple transactions at the
     * same time (ie, you must sell the stock before you buy again).
     * 122
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int money = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                money = money + (prices[i] - prices[i - 1]);
            }
        }
        return money;
    }

    /**
     * Assume you are an awesome parent and want to give your children some cookies. But, you should give each child
     * at most one cookie. Each child i has a greed factor gi, which is the minimum size of a cookie that the child
     * will be content with; and each cookie j has a size sj. If sj >= gi, we can assign the cookie j to the child i,
     * and the child i will be content. Your goal is to maximize the number of your content children and output the
     * maximum number.
     * 455
     * @param g
     * @param s
     * @return
     */
    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int k = 0;
        int count = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i] >= g[k]) {
                k++;
                count++;
            }
            if (k == g.length) {
                return count;
            }
        }
        return count;
    }

    /**
     * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to
     * a specific target number.
     * The function twoSum should return indices of the two numbers such that they add up to the target, where index1
     * must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
     * You may assume that each input would have exactly one solution and you may not use the same element twice.
     * 167
     * @param numbers
     * @param target
     * @return
     */
    public static int[] twoSum4(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum < target) {
                i++;
            } else if (sum > target) {
                j--;
            } else return new int[]{i+1, j+1};
        }
        return null;
    }

    /**
     * Find the sum of all left leaves in a given binary tree.
     * 404
     * @param root
     * @return
     */
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left != null && root.left.left == null && root.left.right == null ) {
            return root.left.val + sumOfLeftLeaves(root.right);
        } else return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }

    /**
     * Given a binary tree, return the tilt of the whole tree.
     * The tilt of a tree node is defined as the absolute difference between the sum of all left subtree node values
     * and the sum of all right subtree node values. Null node has tilt 0.
     * The tilt of the whole tree is defined as the sum of all nodes' tilt.
     * 563
     * @param root
     * @return
     */
    public int findTilt(TreeNode root) {
        traverse(root);
        return tilt;
    }

    int tilt = 0;

    public int traverse(TreeNode root)
    {
        if(root==null )
            return 0;
        int left=traverse(root.left);
        int right=traverse(root.right);
        tilt+=Math.abs(left-right);
        return left+right+root.val;
    }

    /* Given an array of size n, find the majority element. The majority element is the element that appears more
     * than ⌊ n/2 ⌋ times.
     * You may assume that the array is non-empty and the majority element always exist in the array.
     * @param nums
     * @return
     */
    public static int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    /**
     * Suppose Andy and Doris want to choose a restaurant for dinner, and they both have a list of favorite
     * restaurants represented by strings.
     * You need to help them find out their common interest with the least list index sum. If there is a choice tie
     * between answers, output all of them with no order requirement. You could assume there always exists an answer.
     * 599
     * @param list1
     * @param list2
     * @return
     */
    public static String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        int sign = 0;
        int min = Integer.MAX_VALUE;
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < list1.length; i++) {
            hashMap.put(list1[i], i);
        }
        for (int i = 0; i < list2.length; i++) {
            if (hashMap.containsKey(list2[i])) {
                int temp = hashMap.get(list2[i]) + i;
                if (temp < min) {
                    min = temp;
                    stringList.clear();
                    stringList.add(list2[i]);
                } else if (temp == min) {
                    stringList.add(list2[i]);
                }
            }
        }
        return stringList.toArray(new String[stringList.size()]);
    }

    /**
     * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
     * 387
     * @param s
     * @return
     */
    // TODO: 17-9-11 这个题不难，我可以做出来，但我现在不想做了，做的水题太多了，明天再做 
    public static int firstUniqChar(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (hashMap.containsKey(s.charAt(i))) {
                hashMap.remove(s.charAt(i));
            } else hashMap.put(s.charAt(i), i);
        }
        return (int)hashMap.values().toArray()[0];
    }

}
