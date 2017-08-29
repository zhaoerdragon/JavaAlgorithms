package cowguest;

import java.util.Stack;

/**
 * 有些是基本问题，有些是牛客网上的问题
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
     * //Todo 这个题还没有做出来
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

    /**
     * 请编写一个方法，找出两个数字中最大的那个。条件是不得使用if-else等比较和判断运算符。
     * 给定两个int a和b，请返回较大的一个数。若两数相同则返回任意一个。
     */
    public int getMax(int a, int b) {
        return (a+b+Math.abs(a-b))/2;
    }

    /**
     * 请设计一个高效的方法，找出任意指定单词在一篇文章中的出现频数。
     * 给定一个string数组article和数组大小n及一个待统计单词word，请返回该单词在文章中的出现频数。保证文章的词数小于等于1000。
     */
    public int getFrequency(String[] article, int n, String word) {
        int answer = 0;
        for(int i = 0; i < n; i++){
            if(article[i].equals(word)){
                answer++;
            }
        }
        return answer;
    }

    /**
     * 对于一个给定的井字棋棋盘，请设计一个高效算法判断当前玩家是否获胜。
     * 给定一个二维数组board，代表当前棋盘，其中元素为1的代表是当前玩家的棋子，为0表示没有棋子，为-1代表是对方玩家的棋子。
     */
    public boolean checkWon(int[][] board) {
        boolean answer = false;
        if(board[1][1] == 1){
            if(board[0][0] == 1 && board[2][2] == 1){
                answer = true;
                return answer;
            }
            if(board[0][2] == 1 && board[2][0] == 1){
                answer = true;
                return answer;
            }
        }
        int k = 0;
        int z = 0;
        for(int i = 0; i < 2; i++){
            k = 0;
            z = 0;
            for(int j = 0; j < 2; j++){
                if(board[i][j] == 1){
                    k++;
                    if(k == 3) return true;
                }else {
                    k = 0;
                    continue;
                }
                if(board[j][i] == 1){
                    z++;
                    if(z == 3) return true;
                }else {
                    z = 0;
                    continue;
                }
            }
        }
        return answer;
    }

    /**
     * 有两个32位整数n和m，请编写算法将m的二进制数位插入到n的二进制的第j到第i位,其中二进制的位数从低位数到高位且以0开始。
     * 给定两个数int n和int m，同时给定int j和int i，意义如题所述，请返回操作后的数，保证n的第j到第i位均为零，
     * 且m的二进制位数小于等于i-j+1。
     */
    public int binInsert(int n, int m, int j, int i) {
        int answer = 0;
        int[] nint = new int[32];
        int[] mint = new int[i-j+1];
        int ntemp = n;
        int mtemp = m;
        int x = 0, y = 0;
        while (ntemp > 0){
            nint[x++] = ntemp%2;
            ntemp = ntemp/2;
        }
        while (mtemp > 0){
            mint[y++] = mtemp%2;
            mtemp = mtemp/2;
        }
        int c = 0;
        for(int a = j; a<= i; a++){
            nint[a] = mint[c++];
        }
        for(int d = 0; d < 32; d++){
            answer = answer + nint[d]*(int)Math.pow(2,d);
        }
        return answer;
    }

    /**
     * 对于一个字符串，请设计一个算法，判断其是否为一个合法的括号串。
     * 给定一个字符串A和它的长度n，请返回一个bool值代表它是否为一个合法的括号串。
     */
    public boolean chkParenthesis(String A, int n) {
        Stack stack = new Stack();
        for(int i = 0; i < A.length(); i++){
            if(A.charAt(i)=='('){
                stack.add('(');
            }else if(A.charAt(i)==')'){
                if(stack.empty()) return false;
                if((char)stack.peek() == '('){
                    stack.pop();
                }else return false;
            }else return false;
        }
        if(stack.empty()) return true;
        else return false;
    }

    /**
     * 假定我们都知道非常高效的算法来检查一个单词是否为其他字符串的子串。请将这个算法编写成一个函数，给定两个字符串s1和s2，
     * 请编写代码检查s2是否为s1旋转而成，要求只能调用一次检查子串的函数。
     * 给定两个字符串s1,s2,请返回bool值代表s2是否由s1旋转而成。字符串中字符为英文字母和空格，区分大小写，字符串长度小于等于1000。
     */
    public boolean checkReverseEqual(String s1, String s2) {
        String s1s = s1 + s1;
        if(s1s.contains(s2))
            return true;
        else return false;
    }

    /**
     * 请编写一个方法，实现整数的乘法、减法和除法运算(这里的除指整除)。只允许使用加号。
     * 给定两个正整数int a,int b,同时给定一个int type代表运算的类型，1为求a ＊ b，0为求a ／ b，-1为求a － b。
     * 请返回计算的结果，保证数据合法且结果一定在int范围内。
     */
    public int calc(int a, int b, int type) {
        switch (type) {
            case 1: {
                int tempa = 0;
                for (int i = 0; i < b; i++) {
                    tempa = tempa + a;
                }
                return tempa;
            }
            case 0: {
                int temp = 1;
                int tempb = b;
                while (tempb <= a) {
                    tempb = tempb + b;
                    temp++;
                }
                return (temp-1);
            }
            case -1: {
                return a + (-b);
            }
        }
        return 0;
    }

    /**
     * 有一副由NxN矩阵表示的图像，这里每个像素用一个int表示，请编写一个算法，在不占用额外内存空间的情况下(即不使用缓存矩阵)，
     * 将图像顺时针旋转90度。
     * 给定一个NxN的矩阵，和矩阵的阶数N,请返回旋转后的NxN矩阵,保证N小于等于500，图像元素小于等于256。
     */
    public int[][] transformImage(int[][] mat, int n) {
        int[][] temp = new int[n][n];
        int k = n;
        for(int i = 0; i < n; i++){
            k--;
            for(int j = 0; j < n; j++){
                temp[j][k] = mat[i][j];
            }
        }
        return temp;
    }

    /**
     * 现在有一个数组，请找出数组中每个元素的后面比它大的最小的元素，若不存在则为-1。
     * 给定一个int数组A及数组的大小n，请返回每个元素所求的值组成的数组。保证A中元素为正整数，且n小于等于1000。
     * @param A
     * @param n
     * @return
     */
    public static int[] findNext(int[] A, int n) {
        for (int i = 0; i < n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = i + 1; j < n; j++) {
                if (A[j] > A[i] && A[j] < min) {
                    min = A[j];
                }
            }
            if (min == Integer.MAX_VALUE) {
                min = -1;
            }
            A[i] = min;
        }
        return A;
    }

    /**
     * 自守数是指一个数的平方的尾数等于该数自身的自然数。例如：25^2 = 625，76^2 = 5776，9376^2 = 87909376。请求出n以内的自守数的个数
     * @param n
     * @return
     */
    public static int CalcAutomorphicNumbers(int n)
    {
        int count = 0;
        for (int i = 0; i < n; i++) {
            int key = i * i;
            int exp = String.valueOf(i).length();
            if (i == (key % (int) Math.pow(10, exp))) {
                count++;
            }
        }
        return count;
    }

    /**
     * 在一个nxm矩阵形状的城市里爆发了洪水，洪水从(0,0)的格子流到这个城市，在这个矩阵中有的格子有一些建筑，洪水只能在没有建筑的格子流动
     * 。请返回洪水流到(n - 1,m - 1)的最早时间(洪水只能从一个格子流到其相邻的格子且洪水单位时间能从一个格子流到相邻格子)。
     * 给定一个矩阵map表示城市，其中map[i][j]表示坐标为(i,j)的格子，值为1代表该格子有建筑，0代表没有建筑。同时给定矩阵的大小n和m(n和m
     * 均小于等于100)，请返回流到(n - 1,m - 1)的最早时间。保证洪水一定能流到终点。
     * @param map
     * @param n
     * @param m
     * @return
     */
    // TODO: 17-8-29 这个题难，先放一下
    public int floodFill(int[][] map, int n, int m) {
        int count = 0;

        return count;
    }

}
