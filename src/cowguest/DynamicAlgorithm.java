package cowguest;

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
    public int getLCA(int a, int b) {
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
    public int countWays(int x, int y) {

        return 0;
    }

}
