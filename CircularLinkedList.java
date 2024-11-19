package com.vima;

import java.util.ArrayList;
import java.util.List;

public class CircularLinkedList {
    private Node head;
    private Node tail;
    private int size;

    public CircularLinkedList() {
        this.size = 0;
    }

    public void insertFirst(int value)
    {
        Node node=new Node(value);
        node.next=head;
        head=node;
        if(tail==null)
        {
            tail=node;
        }
        tail.next=head;
        size++;
        display();
    }

    public void display()
    {
        Node temp=head;
        if(temp==null)
        {
            System.out.println("List is empty");
            return;
        }
        do{
            System.out.print(temp.value+"->");
            temp=temp.next;
        }while (temp!=head);
        System.out.println("Head");
    }

    public void insertLast(int value)
    {
        Node node=new Node(value);
        if(head==null)
        {
            insertFirst(value);
            return;
        }
        tail.next=node;
        tail=node;
        tail.next=head;
        size++;
        display();
    }

    public void insert(int index, int value)
    {
        if(index<0 || index>size)
        {
            System.out.println("Invalid index");
            return;
        }
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
        Node node=new Node(value);
        Node temp=inserHelper(index);
        node.next=temp.next;
        temp.next=node;
        size++;
        display();
    }

    private Node inserHelper(int index)
    {
        Node temp=head;
        for(int i=1;i<index;i++)
        {
            temp=temp.next;
        }
        return temp;
    }

    public void update(int index,int value)
    {
        if(index<0 || index>=size)
        {
            System.out.println("Invalid index");
            return;
        }
        Node temp=updatHelper(index);
        temp.value=value;
        display();
    }
    private Node updatHelper(int index)
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
        List<Integer> arr=new ArrayList<>();
        searchHelper(arr, value);
        if(arr.isEmpty())
        {
            System.out.println("element is not present");
        }
        else {
            System.out.print("element is present at index: ");
            for(int i=0;i<arr.size();i++)
            {
                System.out.print(arr.get(i)+", ");
            }
        }
        System.out.println();
    }

    public void searchHelper(List<Integer>arr,int value)
    {
        int i=0;
        Node temp=head;
        do{
            if(temp.value==value)
            {
                arr.add(i);
            }
            i++;
            temp=temp.next;
        }while (temp!=head);
    }

    public void deleteFirst()
    {
        if(head==tail)
        {
            head=null;
            tail=null;
            size--;
            display();
            return;
        }
        Node temp=head;
        head=head.next;
        tail.next=head;
        temp.next=null;
        size--;
        display();
    }

    public void deleteLast()
    {
        Node temp=deleteHelper();
        Node temp2=tail;
        temp.next=tail.next;
        tail=temp;
        temp2.next=null;
        size--;
        display();
    }

    private Node deleteHelper()
    {
        Node temp=head;
        for(int i=1;i<size-1;i++)
        {
            temp=temp.next;
        }
        return temp;
    }

    public void delete(int index)
    {
        if(index<0 || index>=size)
        {
            System.out.println("Invalid index");
            return;
        }
        if(index==0)
        {
            deleteFirst();
            return;
        }
        if(index==size-1)
        {
            deleteLast();
            return;
        }
        Node temp=deleteHelper(index);
        Node temp2=temp.next;
        temp.next=temp.next.next;
        temp2.next=null;
        size--;
        display();
    }
    private Node deleteHelper(int index)
    {
        Node temp=head;
        for(int i=1;i<index;i++)
        {
            temp=temp.next;
        }
        return temp;
    }

    private static class Node{
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
