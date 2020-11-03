package data.Matrix;


public class MatrixTest {
    public static void main(String[] args) {
        Matrix matrix1 = new Matrix(5,6);
        System.out.println("矩阵1的行数："+matrix1.getRows());

        Matrix matrix2 = new Matrix(8);
        System.out.println("方阵2的列数："+matrix2.getColumns());
        matrix2.set(1,2,3);
        System.out.println("获取方阵2当i=1,j=2时的元素："+matrix2.get(1,2));

        int[][] values = {{1,1,1},{2,2,2,2},{3,3,3,3,3}};
        Matrix matrix3 = new Matrix(3,5,values);
        System.out.println("矩阵3的第3行3列元素："+matrix3.get(2,2));
    }
}
