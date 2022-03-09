package highFre;

import java.util.HashMap;
import java.util.Map;

/**
 * 快速排序演示
 * @author Lvan
 */
public class lruCacheLcci {



    private static class LRUCache {


        // 双向列表
        static class DoubleList {

            Node head, tail;
            int size;

            public DoubleList() {
                head = new Node(0, 0);
                tail = new Node(0, 0);
                head.next = tail;
                tail.prev = head;
                size = 0;
            }

            public void addFirst(Node cur) {

                Node next = head.next;
                cur.next = next;
                next.prev = cur;
                head.next = cur;
                cur.prev = head;
                size++;
            }

            public void remove(Node node) {

                Node prev = node.prev;
                prev.next = node.next;
                prev.next.prev = prev;
                size--;
            }

            public Node removeLast() {

                if (size == 0)
                    return null;

                Node del = tail.prev;
                remove(del);
                return del;
            }
        }

        static class Node {

            int key, val;
            Node prev, next;

            public Node (int key, int val) {

                this.key = key;
                this.val = val;
            }
        }

        int capacity;
        DoubleList cache;
        Map<Integer, Node> map;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            cache = new DoubleList();
            map = new HashMap<>();
        }

        public int get(int key) {
            if (!map.containsKey(key))
                return -1;

            Node tmp = map.get(key);
            cache.remove(tmp);
            cache.addFirst(tmp);

            return tmp.val;
        }

        public void put(int key, int value) {
            Node cur = new Node(key, value);

            if (map.containsKey(key)) {

                cache.remove(map.get(key));
                cache.addFirst(cur);
//                map.put(key, cur); //不能注释, 如果是key没改, val改了, 就会导致结果错误
            } else {

                if (capacity == cache.size) {
                    Node del = cache.removeLast();
                    map.remove(del.key);
                }

                map.put(key, cur);
                cache.addFirst(cur);
            }
        }
    }
    public static void main(String Args[]) {
//        Map<Integer, String> map = new HashMap<>();
//        map.put(1, "1");
//        map.put(1, "1");
//        System.out.println(map);
//        return;

        int res;
        LRUCache cache = new LRUCache( 2 );/* 缓存容量 */
        cache.put(2, 1);
        cache.put(2, 2);
        res = cache.get(2);       // 返回  1
        System.out.println("get(1)" + res);
        cache.put(1, 1);    // 该操作会使得密钥 2 作废
//        res = cache.get(2);       // 返回 -1 (未找到)
//        System.out.println("get(2)" + res);
        cache.put(4, 1);    // 该操作会使得密钥 1 作废
        res = cache.get(2);       // 返回 -1 (未找到)
        System.out.println("get(1)" + res);
//        res = cache.get(3);       // 返回  3
//        System.out.println("get(3)" + res);
//        res = cache.get(4);       // 返回  4
//        System.out.println("get(4)" + res);
    }
}
