package se.functionobj;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TestParam {

    //Java中的数组时协变的。泛型的集合不是协变的。
    //<AnyType>标识标识类型界定，类型界定在尖括号内指定，指定参数类型必须具有的性质。
    public static <AnyType> AnyType findMax(AnyType[] arr, Comparator<? super AnyType> cmp) {
        int maxIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if(cmp.compare(arr[i],arr[maxIndex]) > 0){
                maxIndex = i;
            }
        }
        return arr[maxIndex];
    }

    public static void main(String[] args) {

        String [] arr = {"ZEBRA","allgator","crocodile"};

        System.out.println(findMax(arr,new CaseInsensitiveCompare()));

        System.out.println(25 >> 1);

        List<String> a = new ArrayList<>();
        a.add("a");
        a.add("b");
        a.add("c");
        a.add("d");
        a.add("e");
        a.add("f");


        List<String> b = new ArrayList<>();
        b.add("a");
        b.add("e");
        b.add("f");

        boolean bool = a.removeAll(b);
        System.out.println(bool);
    }

}
