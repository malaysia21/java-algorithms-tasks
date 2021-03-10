package task;

import java.util.Map;
import java.util.TreeMap;


public class MergeTwoSortedLists {

    public static void main(String[] args) {
        ListNode l1_1 = new ListNode(2);
        ListNode l1_2 = new ListNode(4);
        ListNode l1_3 = new ListNode(6);
        l1_1.next = l1_2;
        l1_2.next = l1_3;

        ListNode l2_1 = new ListNode(3);
        ListNode l2_2 = new ListNode(4);
        ListNode l2_3 = new ListNode(8);
        l2_1.next = l2_2;
        l2_2.next = l2_3;

        ListNode listNodeSolution1 = mergeTwoListsSolution1(l1_1, l2_1);
        ListNode listNodeSolution2 = mergeTwoListsSolution2(l1_1, l2_1);
        System.out.println(listNodeSolution1);
        System.out.println(listNodeSolution2);

        ListNode listNode2Solution1 = mergeTwoListsSolution1(null, null);
        ListNode listNode2Solution2 = mergeTwoListsSolution2(null, null);
        System.out.println(listNode2Solution1);
        System.out.println(listNode2Solution2);

    }

    private static ListNode mergeTwoListsSolution2(ListNode l1, ListNode l2) {

        TreeMap<Integer, Integer> treeMap = new TreeMap<>();

        ListNode currentList1 = l1;
        ListNode currentList2 = l2;

        while (currentList1 != null) {
            treeMap.merge(currentList1.val, 1, Integer::sum);
            currentList1 = currentList1.next;
        }

        while (currentList2 != null) {
            treeMap.merge(currentList2.val, 1, Integer::sum);
            currentList2 = currentList2.next;
        }


        ListNode resultNode = null;
        ListNode previousNode = null;

        for (Map.Entry<Integer, Integer> entry : treeMap.entrySet()) {
            int times = entry.getValue();

            for (int i = 0; i < times; i++) {
                if (previousNode == null) {
                    previousNode = new ListNode(entry.getKey());
                    resultNode = previousNode;
                } else {
                    ListNode newListNode = new ListNode(entry.getKey());
                    previousNode.next = newListNode;
                    previousNode = newListNode;
                }
            }
        }

        return resultNode;
    }


    private static ListNode mergeTwoListsSolution1(ListNode l1, ListNode l2) {
        ListNode resultNode = new ListNode(0);
        ListNode current = resultNode;

        ListNode currentList1 = l1;
        ListNode currentList2 = l2;

        while(currentList1 != null && currentList2 != null){

            if (currentList1.val < currentList2.val || currentList1.val == currentList2.val) {
                ListNode listNode = new ListNode(currentList1.val);
                current.next = listNode;
                current = listNode;

                currentList1 = currentList1.next;

            } else {

                ListNode listNode = new ListNode(currentList2.val);
                current.next = listNode;
                current = listNode;

                currentList2 = currentList2.next;
            }
        }

        if(currentList1 == null){
            current.next = currentList2;
        }

        if(currentList2 == null){
            current.next = currentList1;
        }

        return resultNode.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}