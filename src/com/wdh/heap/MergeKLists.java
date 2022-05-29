package com.wdh.heap;

import com.wdh.ListNode;

import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * @author wdh0713
 * @version 1.0
 * @date 2022/5/27 17:24
 */
public class MergeKLists {
    public static void main(String[] args) {

    }

    private ListNode mergeKLists(ListNode[] lists){
        return merge(lists,0, lists.length-1);
    }

    private ListNode merge(ListNode[] lists, int left, int right){
        if(left == right) return lists[left];
        if(left> right) return null;
        int mid = (left+right)/2;
        return mergeTwo(merge(lists,left,mid),merge(lists,mid+1, right));
    }

    private ListNode mergeTwo(ListNode l1, ListNode l2){
        if(l1 ==null || l2 == null) return l1 == null? l2:l1;
        if(l1.val<l2.val){
            l1.next = mergeTwo(l1.next,l2);
            return l1;
        } else {
            l2.next = mergeTwo(l1, l2.next);
            return l2;
        }
    }

    PriorityQueue<ListNode> queue = new PriorityQueue<>((a,b)-> a.val-b.val);


    private ListNode mergeKLists2(ListNode[] lists){
        for (int i = 0; i < lists.length; i++) {
            queue.offer(lists[i]);
        }
        ListNode res = new ListNode(-1);
        while (!queue.isEmpty()){
            ListNode node = queue.poll();
            res.next = node;
            if(node.next != null){
                queue.offer(node.next);
            }
        }
        return res.next;
    }
}
