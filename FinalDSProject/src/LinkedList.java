public class LinkedList<T>  implements List<T>{  
	int n;

public Node<T>head;  
public Node<T>current;  
  
public LinkedList() {  
    head=current=null;
    n=0;      
}  
  
public boolean empty() {  
    return head==null;//1  
    //bigO(1)  
}  
  
public boolean last() {  
    return current.next==null;  
    //bigO(1)  
}  
public boolean full( ) {  
    return false;  
    //bigO(1)  
      
  
}  
public void findFirst() {  
    current=head;  
    //bigO(1)  
}  
public void findNext() {  
    current=current.next;  
    //bigO(1)  
}  
public T retrieve() {  
    return current.data;  
    //bigO(1)  
}  
public void update(T val) {  
current.data=val;     
//bigO(1)  
}  
//  
public void insert (T val) {  
	n++;
    Node<T> tmp;  
    if (empty()) {  
        current = head = new Node<T> (val);  
    }  
    else {  
        tmp = current.next;  
        current.next = new Node<T> (val);  
        current = current.next;  
        current.next = tmp;  
    }  
}  
  
public void remove () {  
    if (current == head) {  
        head = head.next;  
    }  
    else {  
        Node<T> tmp = head;  

        while (tmp.next != current)  
            tmp = tmp.next;  

        tmp.next = current.next;  
    } 
    if (current.next == null)  
        current = head;  
    else  
        current = current.next;  
}
public void display( ) {  //extra 
	if(head==null)
		System.out.println("empty list");
	
	 Node<T> p = head;
	 while(p!=null) {
		 System.out.print(p.data+" "); 
		  p= p.next;	 
	 }
	 System.out.println();
}

public boolean exist(T x) {
	
	 Node<T> p = head;
	 while(p!=null) {
		 if (p.data.equals(x))
			 return true;
		  p= p.next;}
		 return false;
     }	
	
}




