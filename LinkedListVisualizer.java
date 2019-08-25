import java.io.*; 
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;


public class LinkedListVisualizer extends JPanel implements ActionListener{
 
	Node head; // head of list 
    public static int arr[] = new int[20];//static array to keep linked list elements in order to display in GUI
    public static int co = 0;//iterator for arr[] array
	// Linked list Node. 
	// This inner class is made static 
	// so that main() can access it 
	static class Node { 

		int data; 
		Node next; 

		// Constructor 
		Node(int d) 
		{ 
			data = d; 
			next = null; 
		} 
	} 
    
	// Method to insert a new node 
	public static LinkedListVisualizer insert(LinkedListVisualizer list, int data) 
	{ 
		// Create a new node with given data 
		Node new_node = new Node(data); 
		new_node.next = null; 

		// If the Linked List is empty, 
		// then make the new node as head 
		if (list.head == null) { 
			list.head = new_node; 
		} 
		else { 
			// Else traverse till the last node 
			// and insert the new_node there 
			Node last = list.head; 
			while (last.next != null) { 
				last = last.next; 
			} 

			// Insert the new_node at last node 
			last.next = new_node; 
		} 

		// Return the list by head 
		return list; 
	} 
    
	// Method to print the LinkedList. 
	public static void printList(LinkedListVisualizer list) 
	{ 
		Node currNode = list.head; 

		System.out.print("LinkedList: "); 
        int sum=0;
		// Traverse through the LinkedList 
		while (currNode != null) { 
			// Print the data at current node 
            System.out.print(currNode.data + " "); 
            arr[sum++] = currNode.data;

			// Go to next node 
			currNode = currNode.next; 
        } 
        co = sum;
	} 

    private static final long serialVersionUID = 1L;
	Timer tm = new Timer(5,this);
	int x4=0,vlX4=3;
	int x3=0,vlX3=3;
	int x2=0,vlX2=3;
	int x1=0,vlX1=3;
	int x0=0,vlX0=3;

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		g.drawString("WELCOME TO LINKED LIST VISUALIZER",500,20);
//fifth element of the LinkedList
		g.setColor(Color.GREEN);
		g.fillOval(x4, 30, 50, 50);
		g.setColor(Color.BLACK);
		g.drawString(String.valueOf(arr[4]), x4+10, 60);

//forth element of the LinkedList
		g.setColor(Color.GREEN);
		g.fillOval(x3, 30, 50, 50);
		g.setColor(Color.black);
		g.drawLine(x3+50,60,x3+200,60);
		g.drawString(String.valueOf(arr[3]), x3+10, 60);
//third element element of the LinkedList
		g.setColor(Color.GREEN);
		g.fillOval(x2, 30, 50, 50);
		g.setColor(Color.black);
		g.drawLine(x2+50,60,x2+200,60);
		g.drawString(String.valueOf(arr[2]), x2+10, 60);
//second element element of the LinkedList
		g.setColor(Color.GREEN);
		g.fillOval(x1, 30, 50, 50);
		g.setColor(Color.black);
		g.drawLine(x1+50,60,x1+200,60);
		g.drawString(String.valueOf(arr[1]), x1+10, 60);
//first element element of the LinkedList
		g.setColor(Color.GREEN);
		g.fillOval(x0, 30, 50, 50);
		g.setColor(Color.black);
		g.drawLine(x0+50,60,x0+200,60);
		g.drawString(String.valueOf(arr[0]), x0+10, 60);
		tm.start();

	}
	public void actionPerformed(ActionEvent e) {
		if(x4<0 || x4 > 1000) {
			vlX4=0;
		}

		if(x3<0 || x3 > 800) {
			vlX3=0;
		}

		if(x2<0 || x2 > 600) {
			vlX2=0;
		}

		if(x1<0 || x1 > 400) {
			vlX1=0;
		}

		if(x0<0 || x0 > 200) {
			vlX0=0;
		}

		x4=x4+vlX4;
		x3=x3+vlX3;
		x2=x2+vlX2;
		x1=x1+vlX1;
		x0=x0+vlX0;
		repaint();
	}
	// Driver code 
	public static void main(String[] args) 
	{ 
		/* Start with the empty list. */
		LinkedListVisualizer list = new LinkedListVisualizer(); 

        int count = 0;
        int[] Arr;
        Arr = new int[20];
		// check if length of args array is 
		// greater than 0 
		if (args.length > 0) 
		{ 
			// the command line arguments 
			for (String val:args) {
				Arr[count++] = Integer.parseInt(val);
				if(Integer.parseInt(val)<0 || Integer.parseInt(val)>999){
					System.out.println(val+" Value do not match");
					return;
				} 
			}
		} 
		else
			System.out.println("No command line "+ 
                            "arguments found."); 

                            // 
                            // ******INSERTION****** 
                            // 
                    
                            // Insert the values 
         for(int i =0;i<count;i++){
            list = insert(list, Arr[i]); 
        }
					
		printList(list);// THis will add the linked list elements in order to the arr[] static array 
		LinkedListVisualizer A = new LinkedListVisualizer();
		JFrame jf= new JFrame();
		jf.setTitle("LinkedList Visualizer");
		jf.setSize(1200,400);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.add(A);

	} 
} 
