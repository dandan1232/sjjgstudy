import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Josephus {
/*

    public Josephus(int number,int start,int distance){
        List<String> list=new LinkedList<String>();//直接利用java中自带的LinkedList
        for(int i=0;i<number;i++){
            list.add((char)('A'+i)+"");
        }
        System.out.print("约瑟夫环("+number+","+start+","+distance+"),");
        System.out.println(list.toString());
        int i=start;
        while(list.size()>1){
            i=(i+distance-1)%list.size();
            System.out.print("删除的元素："+list.remove(i).toString()+",");
            System.out.println(list.toString());
        }
        System.out.println("被赦免的罪犯是："+list.get(0).toString());
    }

    public static void main(String[] args) {
        new Josephus(5,0,2);
    }

}*/

/*

    */
/*
     * "约瑟夫环"问题的解决方法1
     * 共N个人，从第S个人开始报数，报数1—M
     * 这里初始化的13个，人从第3个开始报数，数到5的出局
     * 最后运行结果：7 12 4 10 3 11 6 2 1 5 9 13 8
     *//*

    public static void main(String args[]) {
        final int N=13,S=3,M=5;
        int i = S-1, k = N, g = 1, j;
        int a[] = new int[N]; //使用数组存放人;
        for(int h = 1; h <= N; h++)
            a[h-1] = h;    //将编号为h的人存到下标为h-1的数组中

        System.out.println("出圈顺序为：");
        do {
            i = i + (M - 1); //计算出圈人下标
            while(i >= k)
                i = i-k;
            System.out.print(" " + a[i]);

            for(j = i; j < k-1; j++) {
                a[j] = a[j+1]; //第i个人出圈后将后面的人的编号往前移动
            }
            k--; //圈中人数k-1
            g++; //循环次数g+1
        }while(g <= N); //最多N轮循环
    }
}*/



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入总人数：");
        int totalNum = scanner.nextInt();
        System.out.print("请输入报数的大小：");
        int cycleNum = scanner.nextInt();
        yuesefu(totalNum, cycleNum);
        scanner.close();
    }

    public static void yuesefu(int totalNum, int countNum) {
        // 初始化人数
        List<Integer> start = new ArrayList<Integer>();
        for (int i = 1; i <= totalNum; i++) {
            start.add(i);
        }
        // 从第K个开始计数
        int k = 0;
        while (start.size() > 0) {
            k = k + countNum;
            // 第m人的索引位置
            k = k % (start.size()) - 1;
            // 判断是否到队尾
            if (k < 0) {
                System.out.println(start.get(start.size() - 1));
                start.remove(start.size() - 1);
                k = 0;
            } else {
                System.out.println(start.get(k));
                start.remove(k);
            }
        }
    }
}
