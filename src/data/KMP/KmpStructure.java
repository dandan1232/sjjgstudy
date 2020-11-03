package data.KMP;

import data.AboutString.MyString;


public class KmpStructure {
    private static int count=0;                  //记载比较次数
    private static int[] next;                   //模式串pattern改进的next数组
    private static int[] nextk;                  //模式串pattern未改进的next数组

    //返回目标串target中首个与模式串pattern匹配的子串序号，匹配失败时返回-1
    public static int indexOf(MyString target, MyString pattern) {
        return indexOf(target, pattern, 0);
    }

    //返回目标串target从begin开始首个与模式串pattern匹配的子串序号，匹配失败时返回-1。
    //0≤begin<target.length()。对begin容错，若begin<0，从0开始；若begin序号越界，查找不成功。
    //若target、pattern为null，抛出空对象异常。
    public static int indexOf(MyString target, MyString pattern, int begin) {
        int n = target.length(), m = pattern.length();
        if (begin < 0)                              //对begin容错，若begin<0，从0开始
        {
            begin = 0;
        }
        if (n == 0 || n < m || begin >= n)              //若目标串空、较短或begin越界，不需比较
        {
            return -1;
        }

        count = 0;                             //记载比较次数
        nextk = getNextKmp(pattern);
        print(pattern);
        System.out.print("nextk[]: ");
        print(nextk);
        next = getNext(pattern);                 //返回模式串pattern改进的next数组
        System.out.print("next[]:  ");
        print(next);

        int i = begin, j = 0;                        //i、j分别为目标串、模式串比较字符下标
        while (i < n && j < m) {
            if (j != -1) {
                count++;
            }
            if (j == -1 || target.charAt(i) == pattern.charAt(j))//若当前两字符相等，则继续比较后续字符
            {
                if (j != -1) {
                    System.out.print("t" + i + "=p" + j + "，");
                }
                i++;
                j++;
            } else                                 //否则，下次匹配，目标串下标i不回溯
            {
                System.out.println("t" + i + "!=p" + j + "，next[" + j + "]=" + next[j]);
                j = next[j];                       //模式串下标j退回到下次比较字符序号
                if (n - i + 1 < m - j + 1)                  //若目标串剩余子串的长度不够，不再比较，   //比第3版增加此句
                {
                    break;
                }
            }
        }
        System.out.println("\tKMP.count=" + count);
        return j == m ? i - j : -1;                 //若匹配成功，返回匹配子串序号；否则返回-1
    }

    private static int[] getNextKmp(MyString pattern)   //返回模式串pattern的next数组
    {
        int j = 0;
        int k = -1;
        next = new int[pattern.length()];
        next[0] = -1;
        while (j < pattern.length() - 1) {
            if (k == -1 || pattern.charAt(j) == pattern.charAt(k)) {
                j++;
                k++;
                next[j] = k;                       //有待改进
            } else {
                k = next[k];
            }
        }
        return next;
    }

    private static int[] getNext(MyString pattern)    //返回模式串pattern改进的next数组
    {
        int j = 0;
        int k = -1;
        next = new int[pattern.length()];
        next[0] = -1;
        while (j < pattern.length() - 1) {
            if (k == -1 || pattern.charAt(j) == pattern.charAt(k)) {
                j++;
                k++;
                if (pattern.charAt(j) == pattern.charAt(k))  //改进之处
                {
                    next[j] = next[k];
                } else {
                    next[j] = k;
                }
            } else {
                k = next[k];
            }
        }
        return next;
    }

    private static void print(int[] next)        //输出next[]数组
    {
        for (int i = 0; i < next.length; i++) {
            System.out.print(String.format("%3d", next[i]));
        }
        System.out.println();
    }

    private static void print(MyString pattern) {
        System.out.print("pattern: ");
        for (int i = 0; i < pattern.length(); i++) {
            System.out.print("  " + pattern.charAt(i));
        }
        System.out.println();
    }
}
