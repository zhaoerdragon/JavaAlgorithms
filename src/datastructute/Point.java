package datastructute;

import java.util.*;

public class Point {

    private int x;
    private int y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public Point() {
        this.x = 0;
        this.y = 0;
    }

    /**
     * 在二维平面上，有一些点，请找出经过点数最多的那条线。
     * 给定一个点集vector p和点集的大小n,没有两个点的横坐标相等的情况,请返回一个vector，代表经过点数最多的那条直线的斜率和截距。
     * todo 不想做了，有点累，啥时候把这写完
     */
    public double[] getLine(Point[] p, int n) {
        double[] answer = new double[]{0};
        HashMap<Double,Integer> hashMap = new HashMap<>();
        for(int i = 0; i < n; i++){
            answer[i] = p[i].y/p[i].x;
        }
        for(int i = 0; i < n; i++){
            if(!hashMap.containsKey(answer[i])){
                hashMap.put(answer[i],1);
            }else {
                int value = hashMap.get(answer[i]);
                value++;
                hashMap.put(answer[i],value);
            }
        }
        List<Integer> list = new ArrayList<>();
        Iterator iterator = hashMap.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry entry = (Map.Entry)iterator.next();
        }

        return answer;
    }
}
