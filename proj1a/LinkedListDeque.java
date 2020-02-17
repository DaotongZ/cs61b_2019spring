public class LinkedListDeque<LochNegs> {
    private class Node{
        private LochNegs item;
        private Node next;
        private Node prev;

        public Node(LochNegs i, Node n, Node p){
            item  = i;
            next = n;
            prev = p;
        }
    }
    private Node sentinel;
    private int size;

    public LinkedListDeque(){
        sentinel = new Node(null,null,null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;


    }


    public int size(){
        return size;
    }
    public void printDeque() {
        Node itemPrint = sentinel.next;
        for (int i = 0; i < size; i++) {
            System.out.print(itemPrint.item + " ");
            itemPrint = itemPrint.next;
        }
        System.out.println();
    }

    public LochNegs get(int index) {
        Node getNode  = sentinel.next;
        for(int i =0;i<index;i++) {
            getNode = getNode.next;
        }
        return getNode.item;


    }

    public void addFirst(LochNegs item){
        Node newAdd = new Node(item,sentinel.next,sentinel);
        sentinel.next = newAdd;
        sentinel.next.next.prev = newAdd;
        size = size+1;

    }

    public void addLast(LochNegs item){
        Node newAdd = new Node(item,sentinel,sentinel.prev);

        sentinel.prev = newAdd;
        sentinel.prev.prev.next = newAdd;

        size = size + 1;


    }

    public boolean isEmpty() {
        return size == 0;
    }

    public LochNegs removeFirst(){
        LochNegs firstItem = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.next.prev = sentinel;
        if(!isEmpty()){
            size -=1;
        }
        return firstItem;

    }

    public LochNegs removeLast(){
        LochNegs lastItem  = sentinel.prev.item;
        sentinel.prev.prev.next  = sentinel;
        sentinel.prev = sentinel.prev.prev;
        if(!isEmpty()){
            size -=1;
        }
        return lastItem;

    }


    public LinkedListDeque(LinkedListDeque other){
        sentinel = new Node(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;

        for (int i = 0; i < other.size(); i++) {
            addLast((LochNegs) other.get(i)); // (T) is cast, since type of other is unknown
        }
    }



}

