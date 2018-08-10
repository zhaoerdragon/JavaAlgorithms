package com.xupt.willscorpio.cowguest;

/**
 * 动态规划问题算法
 */
public class DynamicAlgorithm {

    /**
     * 有一棵无穷大的满二叉树，其结点按根结点一层一层地从左往右依次编号，根结点编号为1。现在有两个结点a，b。请设计一个算法，求    * 出a和b点的最近公共祖先的编号。
     * 给定两个int a,b。为给定结点的编号。请返回a和b的最近公共祖先的编号。注意这里结点本身也可认为是其祖先。
     * 测试样例：
     * 2，3
     * 返回：1
     */
    public static int getLCA(int a, int b) {
        while (a != b){
            if(a>b) a = a/2;
            else b = b/2;
        }
        return a;
    }

    /**
     * 有一个XxY的网格，一个机器人只能走格点且只能向右或向下走，要从左上角走到右下角。请设计一个算法，计算机器人有多少种走法。
     * 给定两个正整数int x,int y，请返回机器人的走法数目。保证x＋y小于等于12。
     */
    public static int countWays(int x, int y) {
        if(x<=0 || y<=0) return 0;
        if(x == 1 && y == 1) return 1;
        return countWays(x-1,y)+countWays(x,y-1);
    }

    /**
     * 在数组A[0..n-1]中，有所谓的魔术索引，满足条件A[i]=i。给定一个升序数组，元素值各不相同，编写一个方法，判断在数组A中是否存在魔术索引。
     * 请思考一种复杂度优于o(n)的方法。给定一个int数组A和int n代表数组大小，请返回一个bool，代表是否存在魔术索引。
     */
    public static boolean findMagicIndex(int[] A, int n) {
        for(int i=0; i<n; i++){
            if(A[i] == i){
                return true;
            }
        }
        return false;
    }

    /**
     *  You are climbing a stair case. It takes n steps to reach to the top.
     *  Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
     */
    public static int climbStairs(int n) {
        if(n==1 || n==2)
            return n;
        int res = 2;
        int pre = 1;
        int tmp = 0;
        for(int i=3; i<=n; i++){
            tmp = res;
            res = res + pre;
            pre = tmp;
        }
        return res;
    }

    /**
     * 在数组A[0..n-1]中，有所谓的魔术索引，满足条件A[i]=i。给定一个不下降序列，元素值可能相同，编写一个方法，
     * 判断在数组A中是否存在魔术索引。请思考一种复杂度优于o(n)的方法。给定一个int数组A和int n代表数组大小，
     * 请返回一个bool，代表是否存在魔术索引。
     */
    public static boolean findMagicIndex2(int[] A, int n) {
        for(int i=0; i<n; i++){
            if(A[i] == i) return true;
        }
        return false;
    }

    /**
     *  A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
     * The robot can only move either down or right at any point in time. The robot is trying to reach the
     * bottom-right corner of the grid (marked 'Finish' in the diagram below).
     * How many possible unique paths are there?
     */
    public static int uniquePaths(int m, int n) {
        if(m<=0 || n<=0) return 0;
        if(m==1 && n==1) return 1;
        return uniquePaths(m-1,n) + uniquePaths(m,n-1);
    }

    /**
     * 叠罗汉是一个著名的游戏，游戏中一个人要站在另一个人的肩膀上。同时我们应该让下面的人比上面的人更高一点。已知参加游戏的每个人的身高，
     * 请编写代码计算通过选择参与游戏的人，我们多能叠多少个人。注意这里的人都是先后到的，
     * 意味着参加游戏的人的先后顺序与原序列中的顺序应该一致。给定一个int数组men，代表依次来的每个人的身高。
     * 同时给定总人数n，请返回最多能叠的人数。保证n小于等于500。
     */
    public static int getHeight(int[] men, int n) {
        int[] res = new int[n];
        res[0] = 1;
        int max = 1;
        for (int i = 1; i < n; i++) {
            res[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (men[i] > men[j] && res[j] + 1 > res[i]) {
                    res[i] = res[j] + 1;
                }
            }
            max = Math.max(res[i], max);
        }
        return max;
    }

    /**
     * 有一个数组changes，changes中所有的值都为正数且不重复。每个值代表一种面值的货币，每种面值的货币可以使用任意
     * 张，对于一个给定值x，请设计一个高效算法，计算组成这个值的方案数。
     * 给定一个int数组changes，代表所以零钱，同时给定它的大小n，另外给定一个正整数x，请返回组成x的方案数，保证n小于等于100且x小于等于
     * 10000。
     * @param changes
     * @param n
     * @param x
     * @return
     */
    public static int countWays(int[] changes, int n, int x) {
        int[] temp = new int[x + 1];
        temp[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j + changes[i] <= x; j++) {
                temp[j + changes[i]] = temp[j + changes[i]] + temp[j];
            }
        }
        return temp[x];
    }

    /**
     * 现定义数组单调和为所有元素i的f(i)值之和。这里的f(i)函数定义为元素i左边(不包括其自身)小于等于它的数字之和。请设计一个高效算法，计
     * 算数组的单调和。给定一个数组A同时给定数组的大小n，请返回数组的单调和。保证数组大小小于等于500，同时保证单调和不会超过int范围。
     * @param A
     * @param n
     * @return
     */
    public static int calcMonoSum(int[] A, int n) {
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < i; j++) {
                if (A[j] <= A[i]) {
                    count = count + A[j];
                }
            }
        }
        return count;
    }

}
