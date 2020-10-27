import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Josephus {
/*

    public Josephus(int number,int start,int distance){
        List<String> list=new LinkedList<String>();//ֱ������java���Դ���LinkedList
        for(int i=0;i<number;i++){
            list.add((char)('A'+i)+"");
        }
        System.out.print("Լɪ��("+number+","+start+","+distance+"),");
        System.out.println(list.toString());
        int i=start;
        while(list.size()>1){
            i=(i+distance-1)%list.size();
            System.out.print("ɾ����Ԫ�أ�"+list.remove(i).toString()+",");
            System.out.println(list.toString());
        }
        System.out.println("��������ﷸ�ǣ�"+list.get(0).toString());
    }

    public static void main(String[] args) {
        new Josephus(5,0,2);
    }

}*/

/*

    */
/*
     * "Լɪ��"����Ľ������1
     * ��N���ˣ��ӵ�S���˿�ʼ����������1��M
     * �����ʼ����13�����˴ӵ�3����ʼ����������5�ĳ���
     * ������н����7 12 4 10 3 11 6 2 1 5 9 13 8
     *//*

    public static void main(String args[]) {
        final int N=13,S=3,M=5;
        int i = S-1, k = N, g = 1, j;
        int a[] = new int[N]; //ʹ����������;
        for(int h = 1; h <= N; h++)
            a[h-1] = h;    //�����Ϊh���˴浽�±�Ϊh-1��������

        System.out.println("��Ȧ˳��Ϊ��");
        do {
            i = i + (M - 1); //�����Ȧ���±�
            while(i >= k)
                i = i-k;
            System.out.print(" " + a[i]);

            for(j = i; j < k-1; j++) {
                a[j] = a[j+1]; //��i���˳�Ȧ�󽫺�����˵ı����ǰ�ƶ�
            }
            k--; //Ȧ������k-1
            g++; //ѭ������g+1
        }while(g <= N); //���N��ѭ��
    }
}*/



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("��������������");
        int totalNum = scanner.nextInt();
        System.out.print("�����뱨���Ĵ�С��");
        int cycleNum = scanner.nextInt();
        yuesefu(totalNum, cycleNum);
        scanner.close();
    }

    public static void yuesefu(int totalNum, int countNum) {
        // ��ʼ������
        List<Integer> start = new ArrayList<Integer>();
        for (int i = 1; i <= totalNum; i++) {
            start.add(i);
        }
        // �ӵ�K����ʼ����
        int k = 0;
        while (start.size() > 0) {
            k = k + countNum;
            // ��m�˵�����λ��
            k = k % (start.size()) - 1;
            // �ж��Ƿ񵽶�β
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
