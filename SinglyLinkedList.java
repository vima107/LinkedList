package com.vima;

//this is a class for head and tail
public class SinglyLinkedList {
    private Node head;
    private Node tail;

    private int size;

    public SinglyLinkedList()
    {
        this.size = 0;
    }

    //Inserting at the element at the first position
    public void insertFirst(int value)
    {
        Node node =new Node(value);
        node.next=head;
        head=node;

        if(tail==null)
        {
            tail=head;
        }
        size++;
    }

    //Insertinting the elements in the last position...
    public void insertLast(int value)
    {
        if(tail==null)
        {
            insertFirst(value);
            return;
        }
        Node node =new Node(value);
        tail.next=node;
        tail=node;
        size++;
    }

    //inserting an element in specific index
    public void insert(int value, int index)
    {
        if(index==0)
        {
            insertFirst(value);
            return;
        }
        if(index==size)
        {
            insertLast(value);
            return;
        }
        Node temp=head;
        for(int i=1;i<index;i++)
        {
            temp=temp.next;
        }
        Node node=new Node(value, temp.next);
        temp.next=node;
        size++;
    }

    //deleting the first index element i.e head node
    public void delteFirst()
    {
        head=head.next;
        if(head==null)
        {
            tail=null;
        }
        size--;
    }

    //deleteing the last index element i.e, tail node
    public void deleteLast()
    {
        Node seconLast= secondLastNode(size-2);
        tail=seconLast;
        tail.next=null;
        size--;
    }

    public Node secondLastNode(int lastNode)
    {
        Node temp=head;
        for(int i=0; i<lastNode;i++)
        {
            temp=temp.next;
        }
        return temp;
    }

    //deleting element of specific index
    public void delete(int index)
    {
        if(index==0)
        {
            delteFirst();
        }
        if(index==size-1)
        {
            deleteLast();
        }
        Node currentValue=deleteSpecificNode(index-1);
        Node temp=currentValue.next.next;
        currentValue.next.next=null;
        currentValue.next=temp;
        size--;
    }

    public Node deleteSpecificNode(int index)
    {
        Node temp=head;
        for(int i=0;i<index;i++)
        {
            temp=temp.next;
        }

        return temp;
    }

    public void search(int value)
    {
       int index=searching(value);
       if(index==-1)
       {
           System.out.println("there's no such element is present");
       }
       else {
           System.out.println("the element "+value+" is present at "+index);
       }
    }

    public int searching(int value){
        Node temp=head;

        for(int i=0;i<size;i++)
        {
            if(temp.value==value)
            {
                return i;
            }
            temp=temp.next;
        }
        return -1;
    }

    //displaying element
    public void display(){
        Node temp=head;
        while(temp!=null)
        {
            System.out.print(temp.value+"->");
            temp=temp.next;
        }
        System.out.println("end point");
    }

    // this is the node object class
    private class Node{
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;

        }
        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}
