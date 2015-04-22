package org.example.chapter7;

/*
 * @{java.lang.Object} 是所有类的父类， 任一对象都是Object类型。
 * 该类型定义了一组重要的方法，总共有9个共有方法，2个保护方法--其中5个是
 * @{wait()}@{notify()}的变形， 用来在多线程编程中进行同步线程；还
 * 四个方法用于对象的比较，转换，管理。
 * 
 * @{toString()}返回一个描述对象所属类的信息。
 * @{equal()}比较两个对象是否相同。
 * @{hashCode()}返回对象的hash值.
 */
public class TestObject {

    public static void test_toString() {
        // 任一个对象都有toString()方法, 默认情况下，toString()
        // 方法返回类的全名称，如：
        // org.example.chapter7.TestEquality@7000bcbc
        // 类名@hashCode，
        // 当然，也可以自定义toString()方法，返回合适的内容。
        TestEquality test = new TestEquality();
        System.out.println("This is my object " + test);
    }
    
    public static void test_equals() {
        // equals()方法比较两个对象的hash值.
        
        TestEquality obj1 = new TestEquality();
        TestEquality obj2 = new TestEquality();
        
        System.out.println(obj1);
        System.out.println(obj2);
        if (obj1.equals(obj2)) {
            System.out.println("obj1 equals obj2.");
        }
        else {
            System.out.println("obj1 does not equals obj2.");
        }
    }
    
    public static void test_hashCode() {
        // hashCode() 返回一个对象的hash值.
        TestEquality obj1 = new TestEquality();
        TestEquality obj2 = new TestEquality();
        
        System.out.println(obj1);
        System.out.println(Integer.toHexString(obj1.hashCode()));
        System.out.println(obj2);
        System.out.println(Integer.toHexString(obj2.hashCode()));
        if (obj1.equals(obj2)) {
            System.out.println("obj1 equals obj2.");
        }
        else {
            System.out.println("obj1 does not equals obj2.");
        }
        
    }
    
    public static void main(String[] args) {
        // 测试toString()方法
        test_toString();
        
        // 测试 equals()方法.
        test_equals();
        
        // 测试 hashCode()方法
        test_hashCode();
    }

}
