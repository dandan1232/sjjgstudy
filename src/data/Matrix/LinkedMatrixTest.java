package data.Matrix;

public class LinkedMatrixTest {
    public static void main(String[] args) {

        //方法一
        Triple[] values1={new Triple(0,2,11), new Triple(0,4,17),
                new Triple(1,1,20),
                new Triple(3,0,19), new Triple(3,2,36), new Triple(3,5,28),
                new Triple(4,2,50)};
        LinkedMatrix matrix1 = new LinkedMatrix(5,6,values1);
        System.out.print("矩阵1三元组行的单链表：\n"+matrix1.toString());
        matrix1.printMatrix2();
        System.out.println("矩阵非0元素最小值三元组："+matrix1.minValue());

        System.out.println("----------------------------");

        //方法二
        String values2="(0,2,-11),(0,4,-17),(2,3,51),(3,0,10),(4,1,23),(4,4,16)";
        LinkedMatrix matrix2 = new LinkedMatrix(5,6,values2);
        System.out.print("\n矩阵2三元组行的单链表：\n"+matrix2.toString());
        matrix2.printMatrix();
        System.out.println("矩阵非0元素最小值三元组："+matrix2.minValue());

        System.out.println("----------------------------");

        //相加
        matrix1.addAll(matrix2);
        System.out.print("\n矩阵1加矩阵2的三元组行的单链表：\n"+matrix1.toString());
        matrix1.printMatrix();
    }
}
