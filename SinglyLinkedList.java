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
        display();
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
        display();
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
        display();
    }
    //deleting the first index element i.e head node
    public void deleteFirst()
    {
        head=head.next;
        if(head==null)
        {
            tail=null;
        }
        size--;
        display();
    }

    //deleteing the last index element i.e, tail node
    public void deleteLast()
    {
        Node seconLast= secondLastNode(size-2);
        tail=seconLast;
        tail.next=null;
        size--;
        display();
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
            deleteFirst();
        }
        if(index==size-1)
        {
            deleteLast();
        }
        if(index<0 || index>=size)
        {
            System.out.println("Invalid index");
            return;
        }
        Node currentValue=deleteSpecificNode(index-1);
        Node temp=currentValue.next.next;
        currentValue.next.next=null;
        currentValue.next=temp;
        size--;
        display();
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
        ArrayList<Integer> arr=new ArrayList<>();
        searchHelper(value,arr);
        if(arr.size()==0)
        {
            System.out.println("element is not present");
            return;
        }
        System.out.print("element is present at index: ");
        for(int i=0;i<arr.size();i++)
        {
            System.out.print(arr.get(i)+" ,");
        }
        System.out.println();
    }

    public List<Integer> searchHelper(int value, List<Integer>arr)
    {
        Node temp=head;
        for(int i=0;i<size;i++)
        {
            if(temp.value==value)
            {
                arr.add(i);
            }
            temp=temp.next;
        }
        return arr;
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

    public void update(int index, int value)
    {
        if(index<0 || index==size)
        {
            System.out.println("Invalid index");
            return;
        }
        Node temp=updateHelper(index);
        temp.value=value;
        display();
    }

    public Node updateHelper(int index)
    {
        Node temp=head;
        for(int i=0;i<index;i++)
        {
            temp=temp.next;
        }
        return temp;
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
