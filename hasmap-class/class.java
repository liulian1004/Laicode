public class MyHashMap<K,V> {


    public static void main(String[] args) {

    }


        //在一个类中声明另外一个类实现的时候最好用static
        public static class Node<K, V> {
            // K是bucket的Index，一旦确实赋值不能更改，所以这里是final
            final K key;
            //可以更改的值
            V value;
            //类似于linklist的next功能，用于在key相等是查找到下一个空的位置插入
            Node<K, V> next;
            Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
            //getKey, getValue是后续需要用到的功能，这里先声明
            public K getKey() {
                return this.key;
            }
            public V getValue() {
                return this.value;
            }
        }

        // fields
        // the reason to write public is easy to call by users
        public final static int DEFAULT_CAPACITY = 16;
        //Java默认小数输入的默认type是double，这里需要转换下
        public final static float DEFAULT_LOAD_FACTOR = 0.75f;

        //create a array and the type is Node<K, V>
        private Node<K, V>[] array;
        // How many key-value pairs are actually stored in the HashMap
        private int size;
        //rehash
        private float loadFactor;

        private int cap;

        // use will call this function MyHashMap
        public MyHashMap() {
            //默认传入以上定义的数值
            this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
        }

        //实际call上面的function是会发生的function
        //初始化hashmap
       public MyHashMap(int cap, float loadFactor) {
            if(cap <= 0) {
                throw new IllegalArgumentException("cap can not be <= 0");
            }
            //这里是为了后面rehashing的是cap永远是最新的cap
            this.cap = cap;

            //以下this。变量并不总是需要再signature里传入，只要field里定义好就行
            //声明array是不能直接传generic类型，需要通过(Node<K,V>[])来强制转换
            this. array = (Node<K,V>[])(new Node[cap]);
           //也可以先这样写： array = (Node<K,V>[])(new Node[cap]);
            this.size = 0;

            // 也可以这样写 ：size = 0;
            this.loadFactor = loadFactor;
        }

        //API implementation
        public int size() {
            return size;
        }

        public boolean isEmpty() {
            return size == 0;

        }

        public void clear() {
            //assign null to this array
            Arrays.fill(this.array, null);
            //size也要初始化
            size = 0;
        }
        //if the key already exists, return the old corresponding value
        // if key not exists, return null
        public V put(K key, V value) {
            int Index = getIndex(key);
            //找到hashmap的buckets
            Node<K, V>  head = array[Index];
            Node<K, V> node = head;
            while(node != null) {
                //检查这个bucket里的key是不是相等
                //如果key相等，返回之前的value，把原来的key的替换掉
                //size并不增加
                //不能用cur.key.equals(key)
                //因为如果第一个可以是null就会npe
                //这里调用一个method equals
                if(equals(node.key, key)) {
                    V res = node.value;
                    node.value = value;
                    return res;
                }
                node = node.next;
            }
            //node已经走到最后，并没有找到相同的key，所以新key直接加在头上
            //如果这个bucket是空的，也会有一个node，为null
            //append the new node before the head and update the new head
            //Java默认处理collision的方法是separate chaining，好处是实现起来最简单，坏处是分布不均匀
            Node<K, V> newNode = new Node(key, value);
            newNode.next = head;
            //change into the new head;
            array[Index] = newNode;
            //一有新的keysa
            size++;
            if(needRehashing()) {
                rehashing();
            }

            return null;
        }

        private int hash(K key) {
            if(key == null) {
                return 0;
            }
            //hashcode method
            //把hashcode的结果统一转换成正数
            // index % array.length的结果一定要正数，否则会NPE
            return key.hashCode() & 0x7FFFFFFF;
        }

        private int getIndex(K key) {
            return hash(key) % cap;
        }

        private boolean equals(K k1, K k2) {
            if(k1 == null && k2 == null) {
                return true;
            }
            if(k1 == null || k2 == null) {
                return false;
            }
            return k1.equals(k2);
        }

        public V get(K key) {
            int index = getIndex(key);
            Node<K, V> node = array[index];
            //这里调用一个method equals
            while(node != null) {
                if (equals(node.key, key)) {
                    return node.value;
                }
                node = node.next;
            }
            return null;
        }

        public boolean containsKey(K key) {
            int index = getIndex(key);
            Node<K, V> node = array[index];
                while(node != null) {
                    if (equals(node.key, key)) {
                        return true;
                    }
                    node = node.next;
                }
            return false;
        }
        public V remove(K key) {
            int index = getIndex(key);
            Node<K, V> head = array[index];
            Node<K,V> pre = null;
            while(head != null) {
              if(equalsKey(head.value, key)) {
                if(pre == null) {
                  array[index] = head.next;
                }else{
                  pre.next = head.next;
                }
                head.next = null;
                size--;
              }
              pre = head;
              head = head.next;
            }

        }

    private boolean needRehashing() {
        float ratio = (size + 0.0f )/ array.length;
        return ratio >= loadFactor;
    }

    private void rehashing() {
        Node<K, V> [] newArray = (Node<K, V>[]) (new Node [ this.cap * 2]);
        //把cap的数值更新一下
        this.cap *=2;
        for(int i = 0; i < array.length; i++) {
            //重新计算hashcode值，让他分散的更加均匀
            newArray[getIndex(array[i].getKey())] = array[i];
        }
        // do put operation to the new larger array;
        this.array = newArray;

    }

}
