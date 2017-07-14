package algorithm;

/**
 * 矩阵的算法
 */
public class MatrixAlgorithm {

    /**
     * 将两个n阶矩阵相乘然后输出结果
     * @param xx
     * @param yy
     * @return
     */
    public static int[][] multiplyMatrix(int[][] xx, int[][] yy) {
        if (xx.length != yy.length) {
            throw new UnsupportedOperationException("请输入两个阶数相等的n阶矩阵");
        }
        int length = xx.length;
        int[][] out = new int[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                out[i][j] = 0;
                for (int k = 0; k < length; k++) {
                    out[i][j] = xx[i][k] + yy[k][j];
                }
            }
        }

        return out;
    }

    /**
     * Strassen算法，时间复杂度是O(n^2.81).
     * @param xx
     * @param yy
     * @return
     */
    // TODO: 7/14/17 这个算法我现在理解不了，所以先把坑留在这，以后再做 
    public static int[][] strassenMatrix(int[][] xx, int[][] yy) {

        return null;
    }
}
