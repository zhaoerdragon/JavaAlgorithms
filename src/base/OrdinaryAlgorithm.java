package base;

public class OrdinaryAlgorithm {
	/**
	 * 求出三个数中的最大数
	 */
	public static int threeMax(int a,int b,int c){
		if(a>=b&&a>=c) return a;
		if(b>=a&&b>=c) return b;
		return c;
	}
	
	/**
	 * 欧几里德算法
	 */
	public static int euclidAlgorithm(int big,int small){
		int mid=0;
		if(small>big){
			small=small+big;
			big=small-big;
			small=small-big;
		}
		while(small>0){
			mid=big%small;
			big=small;
			small=mid;
		}
		return big;
	}
	
    public static int exponentiation(int X,int N){
    	if(N==0) return 1;
    	if(N==1) return X;
    	if(N%2==0) return exponentiation(X*X, N/2);
    	else return euclidAlgorithm(X*X, N/2)*X;
    }

	/**
	 * 斐波那契数列求值
	 * @param x 第一项
	 */
	public static int fibonacciSoft(int x){
    	if(x==1||x==2) return 1;
    	if(x==3) return 2;
    	else return (fibonacciSoft(x-1)+fibonacciSoft(x-2));
	}
    
}
