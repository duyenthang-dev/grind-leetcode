package lc_patterns.arr_and_hashing;

public class MyHashMap_706 {
    private Node[] map;
    // private double hashThreashold = 0.75;
    
    public MyHashMap_706() {
        map = new Node[1000];
        for (int i =0; i < 1000; i++) {
            map[i] = new Node(-1, -1);
        }
    }

    public void put(int key, int value) {
        int hash = hash(key);
        Node curr = map[hash];
        while (curr.next != null) {
            if (curr.next.key == key) {
                curr.next.value = value;
                return;
            }

            curr = curr.next;
        }

        curr.next = new Node(key, value);
    }

    public int get(int key) {
       int hash = hash(key);
       Node curr = map[hash];
        
       while (curr != null) {
            if (curr.key == key) {
                return curr.value;
            }
            curr = curr.next;
       }
       return -1;
    }

    public void remove(int key) {
        int hash = hash(key);
        Node curr = map[hash];
        while (curr.next != null) {
            if (curr.next.key == key) {
                curr.next = curr.next.next;
                return;
            }

            curr = curr.next;
        }
    }

    private int hash(int key) {
        return key % 1000;
    }

    static class Node {
        int key;
        int value;

        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        var myHashMap = new MyHashMap_706();
        myHashMap.put(1, 1); // The map is now [[1,1]]
        myHashMap.put(2, 10); // The map is now [[1,1], [2,2]]
        System.out.println(myHashMap.get(2));// return 1, The map is now [[1,1], [2,2]]
        System.out.println(myHashMap.get(3));// return -1 (i.e., not found), The map is now [[1,1], [2,2]]
        myHashMap.put(2, 1); // The map is now [[1,1], [2,1]] (i.e., update the existing value)
        System.out.println(myHashMap.get(2)); // return 1, The map is now [[1,1], [2,1]]
        myHashMap.remove(2); // remove the mapping for 2, The map is now [[1,1]]
        System.out.println(myHashMap.get(2));  // return -1 (i.e., not found), The map is now [[1,1]]
    }
}
