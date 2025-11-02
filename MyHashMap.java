public class MyHashMap<K, V> {
    
    private static class Node<K, V> {
        final K key;
        V value;
        Node<K, V> next;
        
        Node(K key, V value, Node<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
    
    private int unique_size_collection = 1;                       
    private Node<K, V>[] table = new Node[unique_size_collection];

    // public MyHashMap(){
    //     return;
    // }

    // public MyHashMap(int size){
    //     unique_size_collection = size;
    //     table = new Node[unique_size_collection];
    // }
    
    public V put(K key, V value) {
        int index = key.hashCode() % unique_size_collection;
        Node<K, V> node = table[index];

        while (node != null) {
            if (node.key.equals(key)) {
                V oldValue = node.value;
                node.value = value;
                return oldValue;
            }
            node = node.next;
        }

        table[index] = new Node<>(key, value, table[index]);

        return null;
    }
    
    public V get(K key) {
        int index = key.hashCode() % unique_size_collection;
        Node<K, V> node = table[index];
        
        while (node != null) {
            if (node.key.equals(key)) {
                return node.value;
            }
            node = node.next;
        }
        return null;
    }
    
    public V remove(K key) {
        int index = key.hashCode() % unique_size_collection;
        Node<K, V> node = table[index];
        Node<K, V> prev = null;
        
        while (node != null) {
            if (node.key.equals(key)) {
                if (prev == null) {
                    table[index] = node.next;
                } else {
                    prev.next = node.next;
                }

                return node.value;
            }
            prev = node;
            node = node.next;
        }
        return null;
    }

    // @Override
    // public String toString(){
    //  
    //     String out = "";
    //     Node next = null;
    //     for (int i = 0;i<unique_size_collection;i++){
    //         next = table[i];
    //         out+="\n[table index:"+i+"]:";
    //         while (next!=null){
    //             out += " "+next.value+" -> ";
    //             next = next.next;
    //         }
    //         out += "null";
    //     }
    //     return out;
    // }

    // public static void main(String args[]){
    //     MyHashMap<String,Integer> map = new MyHashMap<>(16);
    //
    //     map.put("0", 1);
    //     map.put("11", 2);
    //     map.put("22", 3);
    //
    //     map.put("3",4);
    //     map.put("5",5);
    //
    //     System.out.println(map);
    //
    //     System.out.println(map.get("11"));
    //
    //     map.put("11",6);
    //
    //     System.out.println(map);
    //
    //     System.out.println(map.get("11"));
    //
    //     map.remove("11");
    //
    //     System.out.println(map);
    //
    //     System.out.println(map.get("11"));
    // }
}