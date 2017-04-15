package cowguest;

/**
 * 基本问题的答案
 */
public class BaseQuestion {

	/**
	 * 对于一个矩阵，请设计一个算法，将元素按“之”字形打印。具体见样例。
     * 给定一个整数矩阵mat，以及他的维数nxm，请返回一个数组，其中元素依次为打印的数字
	 * @param mat 矩阵
	 * @param n 矩阵的行数
	 * @param m 矩阵的列数
	 * @return 最终的结果
	 */
	public static int[] ZhiMatrix(int[][] mat, int n, int m){
		int[] ans = new int[n*m];
		int key = 0;
		for(int i=0;i<n;i++){
				if(i%2==0){
					for(int j=0;j<m;j++){
					ans[key++] = mat[i][j];
					}
				}else{
					for(int j=m-1;j>=0;j--){
						ans[key++] = mat[i][j];
					}
				}
			}
		
		return ans;
	}

    /**
     * 有一个NxN整数矩阵，请编写一个算法，将矩阵顺时针旋转90度。
     * 给定一个NxN的矩阵，和矩阵的阶数N,请返回旋转后的NxN矩阵,保证N小于等于300。
     *
     * 测试样例：
     * [[1,2,3],[4,5,6],[7,8,9]],3
     * 返回：[[7,4,1],[8,5,2],[9,6,3]]
     */
	public static int[][] rotateMatrix(int[][] mat, int n) {
	    int[][] ans = new int[n][n];
	    int k=0;
	    for(int i = 0; i < n; i++) {
	        int mn = n-1;
            for (int j = 0; j < n; j++) {
                ans[i][j] = mat[mn--][k];
            }
            k++;
        }
	    return ans;
	}

    /**
     * 请设计一个复杂度为O(n)的算法，计算一个未排序数组中排序后相邻元素的最大差值。
     * 给定一个整数数组A和数组的大小n，请返回最大差值。保证数组元素个数大于等于2小于等于500。
     * 测试样例：
     * [9,3,1,10],4
     * 返回：6
     */
    public static int findMaxDivision(int[] A, int n) {
        int max = A[0] ,min = A[0];
        for(int i = 0;i < A.length;i++){
            if(A[i] > max) max = A[i];
            if(A[i] < min) min = A[i];
        }
        int[] ans =new int[max - min + 1];
        for(int i = 0;i < A.length;i++){
            ans[A[i] - min]++;
        }
        int count = 0;
        int maxvalue = count;
        for(int i = 0;i < ans.length;i++){
            if(ans[i] == 0) count++;
            else{
                if(maxvalue < count){
                    maxvalue = count;
                }
                count = 0;
            }
        }
        return maxvalue + 1;
    }

    /**
     * 对于两个字符串A，B。请设计一个高效算法，找到B在A中第一次出现的起始位置。若B未在A中出现，则返回-1。
     * 给定两个字符串A和B，及它们的长度lena和lenb，请返回题目所求的答案。
     * 测试样例：
     * "acbc",4,"bc",2
     * 返回：2
     */
    public static int findAppearance(String A, int lena, String B, int lenb) {
        int tag = 0;
        int k=0;
        for(int i=0;i<lena;i++){
            if(A.charAt(i)==B.charAt(k))  k++;
            else k=0;
            if(k == lenb)
            {
                tag = i - lenb + 1;
                break;
            }
        }

        if(k != lenb){
            return -1;
        }else return tag;
    }

    /**
     * 请实现一个程序，输入父母血型，判断孩子可能的血型。
     * 给定两个字符串father和mother，代表父母的血型,请返回一个字符串数组，代表孩子的可能血型(按照字典序排列)。
     * 测试样例：
     * ”A”,”A”
     * 返回：[”A”,“O”]
     */
    public static String[] chkBlood(String father, String mother) {
        String[] qus = new String[]{father, mother};
        String[] string = null;
        if(father.equals("O")&&mother.equals("O")){
            string = new String[]{"O"};
        }else if(father.equals("A")&&mother.equals("A")||father.equals("A")&&mother.equals("O")||father.equals("O")&&mother.equals("A")){
            string = new String[]{"A", "O"};
        }else if(father.equals("AB")&&mother.equals("AB")||father.equals("A")&&mother.equals("AB")||father.equals("AB")&&mother.equals("A")||father.equals("B")&&mother.equals("AB")||father.equals("AB")&&mother.equals("B")){
            string = new String[]{"A", "AB", "B"};
        }else if(father.equals("A")&&mother.equals("B")||father.equals("B")&&mother.equals("A")){
            string = new String[]{"A", "AB", "B", "O"};
        }else if(father.equals("B")&&mother.equals("B")||father.equals("B")&&mother.equals("O")||father.equals("O")&&mother.equals("B")){
            string = new String[]{"B", "O"};
        }else string = new String[]{"A", "B"};

        return string;
    }

    /**
     * 请你实现一个简单的字符串替换函数。原串中需要替换的占位符为"%s",请按照参数列表的顺序一一替换占位符。若参数列表的字符数     * 大于占位符个数。则将剩下的参数字符添加到字符串的结尾。
     * 给定一个字符串A，同时给定它的长度n及参数字符数组arg，请返回替换后的字符串。保证参数个数大于等于占位符个数。保证原串由     * 大小写英文字母组成，同时长度小于等于500。
     * 测试样例：
     * "A%sC%sE",7,['B','D','F']
     *  返回："ABCDEF"
     */
    public static String formatString(String A, int n, char[] arg, int m){
        String ans = "";
        int k = 0;
        for(int i = 0;i<A.length();i++){
            if(i == A.length()- 1){
                ans = ans + A.charAt(i);
                break;
            }
            if((""+A.charAt(i)+A.charAt(i+1)).equals("%s")){
                ans = ans + arg[k++];
                i = i + 1;
            }else{
                ans = ans + A.charAt(i);
            }
        }
        if(k < m){
            for(int i = k;i < m;i++) ans = ans + arg[i];
        }

        return ans;
    }

    /**
     * 在4x4的棋盘上摆满了黑白棋子，黑白两色的位置和数目随机其中左上角坐标为(1,1),右下角坐标为(4,4),现在依次有一些翻转操作，  * 要对一些给定支点坐标为中心的上下左右四个棋子的颜色进行翻转，请计算出翻转后的棋盘颜色。
     * 给定两个数组A和f,分别为初始棋盘和翻转位置。其中翻转位置共有3个。请返回翻转后的棋盘。
     */
    public static int[][] flipChess(int[][] A, int[][] f) {
        for(int i = 0;i<f.length;i++){
            int x = f[i][0] - 1;
            int y = f[i][1] - 1;
            if(x-1>=0){
                if(A[x-1][y] == 1){
                    A[x-1][y] = 0;
                }else A[x-1][y] = 1;
            }

            if(y-1>=0){
                if(A[x][y-1] == 1){
                    A[x][y-1] = 0;
                }else A[x][y-1] = 1;
            }

            if(y+1<=3){
                if(A[x][y+1] == 1){
                    A[x][y+1] = 0;
                }else A[x][y+1] = 1;
            }

            if(x+1<=3){
                if(A[x+1][y] == 1){
                    A[x+1][y] = 0;
                }else A[x+1][y] = 1;
            }
        }
        return A;
    }

    /**
     * 有一个方阵，其中每个单元(像素)非黑即白(非0即1)，请设计一个高效算法，找到四条边颜色相同的最大子方阵。
     * 给定一个01方阵mat，同时给定方阵的边长n，请返回最大子方阵的边长。保证方阵边长小于等于100。
     */
    public static int maxSubMatrix(int[][] mat, int n) {
        int ans = 0;
        int matrix = (n+1)/2;

        for(int i = 0;i<matrix;i++){
            for(int j = i;j<n-i;j++){
                int key = mat[i][j];
            }
        }
        return ans;
    }

    /**
     * 请编写一个函数，函数内不使用任何临时变量，直接交换两个数的值。
     * 给定一个int数组AB，其第零个元素和第一个元素为待交换的值，请返回交换后的数组。
     * @param AB
     * @return
     */
    public int[] exchangeAB(int[] AB) {
        AB[0] = AB[0]+AB[1];
        AB[1] = AB[0]-AB[1];
        AB[0] = AB[0]-AB[1];
        return AB;
    }
}
