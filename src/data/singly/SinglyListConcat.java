package data.singly;

/**
 * @author Flobby
 * @version :1.0
 * @date :2020/10/16
 * @ClassName :
 */

public class SinglyListConcat {
    public static void main(String[] args) {
        //(1) 合并连接与添加子表（深拷贝）
        String[] valueA = {"a", "b", "c"}, valueB = {"x", "y"};
        SinglyList<String> listA = new SinglyList<>(valueA);
        SinglyList<String> listB = new SinglyList<>(valueB);

        String x = "\t\t\t listA=" + listA.toString() + "，\t\t listB=" + listB.toString();
        System.out.println("原list" + x);
        System.out.println();
        listA.concat(listB);
        //在listA之后链接listB
        String x1 = "listA后连接上listB，\t listA=" + listA.toString() + "，\t listB=" + listB.toString();
        System.out.println(x1);
        System.out.println();
        listB.insert("z");
        System.out.println("listB后加上'z'，\t listA=" + listA.toString() + "，\t listB=" + listB.toString());
        /*
        *listA没有z，SinglyList---->line：257
        * 注释这一行listA自动加z
        */
        System.out.println();
        listA.addAll(listB);
        String x2 = "listA后连接上加上'z'的listB，\t listA=" + listA.toString() + "，\t listB=" + listB.toString();
        System.out.println(x2);
        //(3) 添加子表返回（深拷贝）
        System.out.println();
        System.out.println("listA.union(listB)=" + listA.union(listB).toString());
        String x3 = "\t\t\t listA=" + listA.toString() + ",\t\t listB=" + listB.toString();
        System.out.println("深拷贝" + x3);
    }
}
