package com.wdh.twoPoint;

import com.wdh.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wdh0713
 * @version 1.0
 * @date 2022/5/27 10:55
 */
public class CycleLink {
    public static void main(String[] args) {

    }

    private boolean hasCycleBySet(ListNode head){
        Set<ListNode> set = new HashSet<>();
        if(head == null){
            return false;
        }
        while (head != null){
            if(!set.add(head)){
                return true;
            }
            head = head.next;
        }
        return false;
    }

    private boolean hasCycleByPointer(ListNode head){
        if(head == null || head.next == null){
            return false;
        }
        ListNode slow = head, fast = head.next;
        while (slow != fast){
            if(slow == null || fast == null){
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    private ListNode cycleLink(ListNode head){
        ListNode slow = head, fast = head;
        while (slow != null){
            slow = slow.next;
            if(fast.next != null){
                fast = fast.next.next;
            } else {
                return null;
            }
            if(slow == fast){
                ListNode ptr = head;
                while (ptr != slow){
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }
        return null;
    }
}
