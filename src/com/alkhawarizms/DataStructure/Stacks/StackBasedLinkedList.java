package com.alkhawarizms.DataStructure.Stacks;

import com.alkhawarizms.DataStructure.Lists.LinkedList;

/**
 * Created by msoliman on 1/21/17.
 ------------------------------------------------------------------------------------------------------------------------------
 * Description:
   Stack here is implemented on top of linked list to avoid limitation of size and resizing operations we are doing when arrays used.
   Pushing in the front of the list and poping out from the front of the list.
   Usually named "Last in First out" or LIFO
 ------------------------------------------------------------------------------------------------------------------------------

 * Time Complexity:
     push: O(1)
     pop: O(1)
     isEmpty: O(1)
     size: O(1)

 ------------------------------------------------------------------------------------------------------------------------------
 Tests
 ------------------------------------------------------------------------------------------------------------------------------
 StackBasedLinkedList ls = new StackBasedLinkedList();
 ls.push(10);
 ls.push(20);
 System.out.println(ls.pop());
 System.out.println(ls.pop());
 System.out.print(ls.isEmpty());

 */
public class StackBasedLinkedList<E> implements IStack<E> {
    LinkedList<E> lst = new LinkedList();

    //O(1)
    @Override
    public boolean isEmpty() {
        return lst.size() == 0;
        //System.arraycopy();
    }

    //O(1)
    @Override
    public void push(E elem) {
        lst.addFirst(elem);
    }

    //O(1)
    @Override
    public E pop() {
        if(lst.isEmpty())
            return  null;

        E last = lst.getFirst();

        lst.removeFirst();

        return last;
    }

    //O(1)
    @Override
    public E top() {
        if(isEmpty()){
            return  null;
        }

        return lst.getFirst();
    }

    //O(length)
    @Override
    public E[] multiPop(int length) {

        E[] elems = (E[])new Object[length];
        int count = 0;
        while(!isEmpty() && count <= length -1){
            elems[count] = pop();

        }

        return elems;

    }


}
