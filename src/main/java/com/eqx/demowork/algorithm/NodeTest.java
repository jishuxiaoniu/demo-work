package com.eqx.demowork.algorithm;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * @ClassName NodeTest
 * @Description test
 * @Author duanhuazhen
 * @Date 下午2:02 2019/3/11
 * @Version 1.0
 **/
public class NodeTest {

    public static void main(String[] args) {
        Node node = new Node(-1);
        for (int i = 0; i < 7; i++) {
            Node se = new Node(i);
            se.next = node;
            node = se;
        }

//        Node newNode = NodeTest.delNodeNoDesc(node, 3);
        Node newNode = NodeTest.midNode(node);

        while (newNode != null) {
            System.out.print(newNode.value + ",");
            newNode = newNode.next;
        }

    }

    public static boolean isHuiWenStr(Node head) {
        // 链表翻转
        Node revertNode = reverNode(head);

        while (head != null && revertNode != null) {
            if (head.value != revertNode.value) {
                return false;
            }
            head = head.next;
            revertNode = revertNode.next;
        }
        return true;
    }

    private static Node reverNode(Node head) {
        if (head == null) {
            return null;
        }

        Node p = head;
        if (p.next != null) {
            p = p.next;
        } else {
            return head;
        }

//        head.next = null;

        while (p != null) {
            Node t = p.next;
            p.next = head;
            head = p;
            p = t;
        }

        return head;
    }

    public boolean isRing(Node head) {
        Map<Node, Class> map = Maps.newHashMap();
        if (head == null) {
            return true;
        }

        while (head.next != null) {
            if (map.containsKey(head.next)) {
                return false;
            }
            map.put(head.next, NodeTest.class);
        }
        return true;
    }

    public Node hebing(Node sortNodeFirst, Node sortNodeLast) {
        if (sortNodeFirst == null) {
            return sortNodeLast;
        }
        if (sortNodeLast == null) {
            return sortNodeFirst;
        }

        Node node;

        if (sortNodeFirst.value < sortNodeLast.value) {
            node = sortNodeFirst;
            node.next = hebing(sortNodeFirst.next, sortNodeLast);
        } else {
            node = sortNodeLast;
            node.next = hebing(sortNodeFirst, sortNodeLast.next);
        }
        return node;
    }

    /**
     * 删除倒数第n个节点, n是有效的
     *
     * @return
     */
    public static Node delNodeNoDesc(Node head, int n) {

        Node p = head;
        Node q = null;
        for (int i = 0; i < n; i++) {
            q = q == null ? head.next : q.next;
        }

        while (q.next != null) {
            p = p.next;
            q = q.next;
        }
        p.next = p.next.next;

        return head;
    }

    /**
     * 链表中间节点
     *
     * @param head
     * @return
     */
    public static Node midNode(Node head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        Node p = head;
        Node q = head.next;

        while (q != null && q.next != null) {
            p = p.next;
            q = q.next.next;
        }

        return p;
    }

    public static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }
}
