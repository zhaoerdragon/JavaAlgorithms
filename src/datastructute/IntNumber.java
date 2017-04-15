package datastructute;

/**
 * 随机生成一些整形数字数组
 */
public class IntNumber {

	/**
	 * 创建一个自定义长度1到50的整型数组
	 * @param quantity 数组的长 度
	 * @return 返回整型数组
	 */
	public static int[] CreateIntArray(int quantity){
		int[] arrayint=new int[quantity];
		for(int i=0;i<quantity;i++){
			arrayint[i]=(int)(1+Math.random()*50);
			System.out.println("第"+(i+1)+"个数字是"+arrayint[i]);
		}
		return arrayint;
	}

	/**
	 * 创建一个从-50到50的长度自定义的整型数组
	 * @param quantity 数组的长度
	 * @return 整型数组
	 */
	public static int[] CreateNegativeIntArray(int quantity){
		int[] arrayint=new int[quantity];
		for(int i=0;i<quantity;i++){
			arrayint[i]=(int)(-50+Math.random()*100);
			System.out.println("第"+(i+1)+"个数字是"+arrayint[i]);
		}
		return arrayint;
	}
}
