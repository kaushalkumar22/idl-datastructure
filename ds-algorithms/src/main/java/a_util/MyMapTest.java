package a_util;

public class MyMapTest {
    public static void main(String[] args) {
        MyMap<Integer,Integer> map = new MyMap<>();
        map.put(10,15);
        map.put(9,12);
        map.put(12,7);
        map.put(15,25);
        map.put(25,21);
        System.out.println(map.get(9));
        System.out.println(map.get(25));
    }
}
class MyMap<K,V> {
    private int capacity;
    Node<K,V>[] buckets;
    static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;//16

    public MyMap() {
        this(DEFAULT_INITIAL_CAPACITY);
    }

    public MyMap(int capacity) {
        this.capacity = capacity;
        buckets = new Node[capacity!=0?capacity:DEFAULT_INITIAL_CAPACITY];
    }
    public V put(K key, V value) {
        Node<K,V > node = new Node<>(key,value);
        int size = buckets.length;
        int hash = hash(key);
        int bucketLocation = hash%size;
        Node<K,V > head = buckets[bucketLocation];
        if(head==null){
            buckets[bucketLocation] = node;
        }else{
            while(head!=null&&head.next!=null){
                head = head.next;
            }
            head.next=node;
        }
        return value;
    }
    public V get(K key) {
        int hash = hash(key);
        int size = buckets.length;
        int bucketLocation = hash%size;
        Node<K,V > head = buckets[bucketLocation];
        if(head==null){
            return null;
        }else{
            while(head!=null){
                if(equals(key,head.getKey())){
                    return head.getValue();
                }else{
                    head = head.next;
                }
            }
        }
        return null;
    }
    private int hash(K key){
        return key==null?0:key.hashCode();
    }
    private boolean equals(K key1,K key2){
        return key1.equals(key2);
    }
    private static class Node<K,V> {
        final K key;
        V value;
        Node<K, V> next;
        Node( K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }

        public final K getKey() {
            return key;
        }

        public final V getValue() {
            return value;
        }
    }
}