package utils;

/**
 * 对标准输出的再一次封装，简化一些操作
 */
public class MyOut {

    /**
     * 在命令行中输出，并自动跳行
     * @param string
     */
    public static void println(String string) {
        System.out.println(string);
    }

    /**
     * 函数重载，遍历数组
     * @param arrayInt
     */
    public static void println(int[] arrayInt) {
        println("");
        for(int i=0;i<arrayInt.length;i++) {
            println("第 " + i + " 个的数据是 " + arrayInt[i]);
        }
    }

    /**
     * 遍历二维数组，并打印出结果
     * @param arrayInt
     */
    public static void println(int[][] arrayInt) {
        for(int i=0;i<arrayInt.length;i++) {
            for(int j=0;j<arrayInt[0].length;j++) {
                System.out.print("   " + arrayInt[i][j] + "   ");
            }
            MyOut.println("");
        }
    }
}
