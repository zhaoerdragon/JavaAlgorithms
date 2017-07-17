package algorithm;

public class TreeAlgorithm {

    /**
     * 对分查找，但是这个数组必须是已经排好序的
     * @param arrayint 已经排好序的数组
     * @param number 要查找的数组
     * @return true是有,false是没有
     */
	public static boolean baseBinarySearch(int[] arrayint,int number){
		int Low=0,High=arrayint.length-1,Middle=0;
		while(Low<=High){
			Middle=(Low+High)/2;
			if(arrayint[Middle]>number){
				High=Middle-1;
			}else if(arrayint[Middle]<number){
				Low=Middle+1;
			}else return true;
		}
		return false;
	}
}
