package data.KMP;

import data.AboutString.MyString;

/**
 * @author Flobby
 * @version :1.0
 * @date :2020/10/23
 * @ClassName :
 */

public class KmpTest {
    public static void main(String[] args) {
        MyString target = new MyString("ababbabababba"), pattern = new MyString("babab");
        System.out.println(KmpStructure.indexOf(target,pattern));
    }
}
