package top100;

//web https://leetcode-cn.com/problems/add-two-numbers


import list.ListNode;

import java.util.*;

public class mysSort {
    private static class Solution {

        public Solution() {
        }


    }

    private static class Person implements Comparable<Person> {
        private String name;
        private int age;

        public Person(String name, int age) {
            super();
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        /**
         * T重写compareTo方法实现按年龄来排序
         */
        @Override
        public int compareTo(Person o) {
            if (this.age > o.getAge()) {
                return 1;
            }
            if (this.age < o.getAge()) {
                return -1;
            }

            char[] chars = this.name.toCharArray();
            char[] chars1 = o.name.toCharArray();
            int len = Math.min(chars1.length, chars.length);

            for (int i = 0; i < len; ++i){
                if (chars[i] != chars1[i]) {
                    return chars[i] - chars1[i];
                }
            }
//            return chars.length >= chars1.length? 1: -1;
            return chars.length - chars1.length;

//            return this.name.hashCode()>o.getName().hashCode()?1:-1;
//            return 0; // 返回0 前面的被覆盖
        }
    }

    private static class P1 {
        private String name;
        private int age;

        public P1(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }


    public static void main(String Args[]) {
        Solution solution = new Solution();

        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(-1);
        arrayList.add(3);
        arrayList.add(3);
        arrayList.add(-5);
        arrayList.add(7);
        arrayList.add(4);
        arrayList.add(-9);
        arrayList.add(-7);
        System.out.println("原始数组:");
        System.out.println(arrayList);
        Collections.reverse(arrayList);
        System.out.println("Collections.reverse(arrayList):");
        System.out.println(arrayList);
        Collections.sort(arrayList);
        System.out.println("Collections.sort(arrayList):");
        System.out.println(arrayList);


        // 两种基本类型对应的排序方法可以按照这个来
        System.out.println("Treeset Sort, compareTo 排序");
        TreeMap<Person, String> pdata = new TreeMap<Person, String>();
        pdata.put(new Person("张三", 30), "zhangsan");
        pdata.put(new Person("李四", 20), "lisi");
        pdata.put(new Person("wangwu", 10), "wangwu");
        pdata.put(new Person("wangwua", 10), "wangwu");
        pdata.put(new Person("小红", 5), "xiaohong");
        pdata.put(new Person("小红", 6), "xiaohong");
        // 得到key的值的同时得到key所对应的值
        Set<Person> keys = pdata.keySet();
        for (Person key : keys) {
            System.out.println(key.getAge() + "-" + key.getName());

        }

        // 一直报错没看出是哪里的问题
//        System.out.println("ArrayList 排序");
//        ArrayList<P1> arr = new ArrayList<P1>();
//        arr.add(new P1("张三", 30));
//        arr.add(new P1("张三", 30));
//        arr.add(new P1("张三", 30));
//        arr.add(new P1("123", 10));
//        arr.add(new P1("124", 10));
//        Arrays.sort(arr,
//                new Comparator<P1>() {
//                    @Override
//                    public int compare(P1 o1, P1 o2) {
//                        return 1;
//                    }
//
////                    public int compare(Person a, Person b){
////                        if (a.age != b.age)
////                            return a.age - b.age;
////                        char[] chars = a.name.toCharArray();
////                        char[] chars1 = b.name.toCharArray();
////                        int len = Math.min(chars1.length, chars.length);
////
////                        for (int i = 0; i < len; ++i){
////                            if (chars[i] != chars1[i]) {
////                                return chars[i] - chars1[i];
////                            }
////                        }
//////                        return chars.length - chars1.length;
////                    }
//                });

        System.out.println("多维数组升排序");
//        int[][] nums = new int[][]{{1,3},{1,2},{4,5},{3,7}};
        int[][] nums = new int[][]{{1,3,3},{1,3,2},{4,0,5},{3,2,7}};

        Arrays.sort(nums, new Comparator<int[]>() {
            public int compare(int[] a, int[] b){
//                if(a[0]==b[0]){
//                    return a[1] - b[1];
//                }else {
//                    return a[0] - b[0];
//                }
                for (int i = 0; i < a.length; ++i) {
                    if (a[i] != b[i]) {
                        return a[i] - b[i];//b[i] - a[i]降序
                    }
                }
                return 0;
            }
        });
        for(int i=0;i<nums.length; i++){
            System.out.println(Arrays.toString(nums[i]));
        }

    }

}
