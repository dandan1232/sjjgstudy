package data.KMP;

import data.AboutString.MyString;


public class KmpTest {
    public static void main(String[] args) {
        MyString target = new MyString("ababbabababba"), pattern = new MyString("babab");
        System.out.println(KmpStructure.indexOf(target,pattern));
    }
}
