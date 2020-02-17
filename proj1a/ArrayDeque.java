import java.lang.reflect.Field;

public class ArrayDeque<Item> {
    private Item[] items;
    private int size;
    private int first;
    private int last;

    private void resize(int capacity){
        Item[] a = (Item[]) new Object[capacity];

        int oidindex = minusOne(first);
        for(int i=0;i<size;i++){

            a[i] = items[oidindex];
            oidindex = minusOne(oidindex);
        }
        items =  a;
        first = capacity-1;
        last = size;

    }

    public ArrayDeque(){
        items = (Item[]) new Object[8];
        size  = 0;
        first = 0;
        last  =1;
    }

    public boolean isSparse(){
         return items.length>=16&&(size<(items.length/4));
    }


   public boolean isFull(){
        return items.length == size;
   }

   public int addOne(int index){
        if(index==0){
            return index-1+items.length;
        }
        else return index-1;

   }

    public int minusOne(int index){
        if(index==items.length-1){
            return index+1-items.length;
        }
        else return index+1;

    }
    public void addFirst(Item F){
        if(isFull()){
            resize(size*2);
        }
        items[first]=F;
        first = addOne(first);
        size= size+1;
    }

    public void addLast(Item L){
        if(isFull()){
            resize(size*2);
        }
        items[last]=L;
        last = minusOne(last);
        size = size+1;
    }

    public boolean isEmpty(){
        return  size==0;
    }

    public void printDeque(){

    }

    public Item removeFirst(){
        if(isSparse()){
            resize(items.length/2);
        }

        Item F = items[minusOne(first)];
        items[minusOne(first)]=null;
        first = minusOne(first);
        if(!isEmpty())
        {
            size = size-1;
        }
        return  F;

    }

    public Item removeLast(){
        if(isSparse())
        {
            resize(items.length/2);
        }
        Item F = items[addOne(last)];
        items[addOne(last)]=null;
        last = addOne(last);
        if(!isEmpty()){
            size = size-1;
        }
        return F;

    }

    public Item get(int index){
        if(index>=size){
            return null;
        }
        int start =minusOne(first);

        return items[(start+index)%items.length];
    }

    public static void main(String[] args){
        ArrayDeque L = new ArrayDeque();
        for(int i = 0;i<64;i++){
            L.addLast(i);
        }

        for(int i=0;i<60;i++){
            L.removeLast();
        }
        System.out.println("works");

    }





}
