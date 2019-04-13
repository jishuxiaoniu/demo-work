package com.eqx.demowork.algorithm;

import lombok.Data;

/**
 * @ClassName StackTest
 * @Description 栈测试
 * @Author duanhuazhen
 * @Date 10:19 2019-03-28
 * @Version 1.0
 **/
public class StackTest {
    public static void main(String[] args) {
//        MyStack stack = new MyStack(20);
//        MyLinkStack stack = new MyLinkStack();
//        stack.push("asdf");
//        stack.push("bb");
//        stack.push("cc");
//        stack.push("ee");
//        System.out.println("The result is ----> length " + stack.count);
//
//        String aa = stack.pop();
//        String bb = stack.pop();
//        System.out.println("The result is ----> aa, bb " + aa + ", " + bb);
//        System.out.println("The result is ----> length " + stack.count);
//
//        stack.push("123");
//        stack.push("1235");
//        stack.push("1234");
//        System.out.println("The result is ----> length " + stack.count);
//        String cc = stack.pop();
//        System.out.println("The result is ----> cc " + cc);

//        testGoogle();

        testMark();
    }

    public static void testGoogle() {
        // 浏览器实现前进后退
        Google google = new Google();
        google.newUrl("aaa");
        google.newUrl("bbb");
        google.newUrl("ccc");
        google.newUrl("ddd");
        System.out.println("current-Url = " + google.url);

        google.back();
        System.out.println("current-Url = " + google.url);
        google.back();
        System.out.println("current-Url = " + google.url);

        google.forward();
        System.out.println("current-Url = " + google.url);

        google.newUrl("eee");
        System.out.println("current-Url = " + google.url);
    }

    // {([])} 判断括号是否完整
    public static void testMark() {
        String[] str = {"}", "{", "{", "}", "}", "{", "{", "}", "}"};
        MyStack leftStack = new MyStack(20);

        for (String s : str) {
            if (Mark.isLeft(s)) {
                leftStack.push(s);
            } else if (Mark.isRight(s)) {
                if (leftStack.count == 0){
                    System.out.println("测试符号格式不对, 多一个右括号");
                    return;
                }
                String leftStr = leftStack.pop();
                boolean aTrue = Mark.isTrue(leftStr, s);
                if (!aTrue){
                    System.out.println("测试符号不完整， 不对等");
                    return;
                }
            } else {
                System.out.println("测试符号格式不对");
                return;
            }
        }

        if (leftStack.count > 0){
            System.out.println("测试符号格式不对， 多左括号");
        } else {
            System.out.println("测试符号格式正确");
        }
    }
}

class Mark {
    static String leftMarks = "{[(";
    static String rightMarks = "}])";

    public static boolean isTrue(String leftMark, String rightMark) {
        int i = leftMarks.indexOf(leftMark);
        int i2 = rightMarks.indexOf(rightMark);
        return i == i2 && i != -1;
    }

    public static boolean isLeft(String mark) {
        return leftMarks.contains(mark);
    }

    public static boolean isRight(String mark) {
        return rightMarks.contains(mark);
    }
}

class Google {
    String url;
    MyStack forwardStack = new MyStack(20);
    MyStack backStack = new MyStack(20);

    public void newUrl(String newUrl) {
        url = newUrl;
        forwardStack.push(newUrl);
        backStack.clear();
    }

    public void forward() {
        String pop = backStack.pop();
        newUrl(pop);
        url = pop;
    }

    public void back() {
        backStack.push(forwardStack.pop());
        String temp = forwardStack.pop();
        forwardStack.push(temp);
        url = temp;
    }
}

class MyStack {
    int count;
    int capcity;
    String[] arr;

    public MyStack(int capcity) {
        this.capcity = capcity;
        arr = new String[capcity];
        count = 0;
    }

    public void push(String element) {
        // 不考虑越界
        arr[count] = element;
        count++;
    }

    public String pop() {
        String temp = arr[--count];
        arr[count] = null;
        return temp;
    }

    public void clear() {
        for (int i = 0; i < count; i++) {
            arr[i] = null;
        }
    }
}

class MyLinkStack {
    int count;
    Node node;

    public MyLinkStack() {
        count = 0;
    }

    public void push(String element) {
        if (node != null) {
            Node node1 = new Node();
            node1.setData(element);
            node1.setNext(node);
            node = node1;
        } else {
            node = new Node();
            node.setNext(null);
            node.setData(element);
        }
        count++;
    }

    public String pop() {
        if (node == null) {
            return "error";
        }

        Node tempNode = node;
        node = node.next;
        return tempNode.getData();


    }
}

@Data
class Node {
    String data;
    Node next;
}