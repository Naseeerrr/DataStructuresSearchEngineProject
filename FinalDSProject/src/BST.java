public class BST<T> {  
         BSTNode<T> root, current;  
               
             
             public BST() {  
                 root = current = null;  
             }  
               
             public boolean empty() {  
                 return root == null;  
             }  
               
             public boolean full() {  
                 return false;  
             }  
               
             public T retrieve () {  
                 return current.data;  
             }  
             
    public boolean findkey(String key) {  
                 BSTNode<T> p=root; 
                   
                 if(empty())  
                     return false;  
                   
                 while(p!=null) { 
                     current=p;
                      
                     if(key.compareToIgnoreCase(p.key)==0)   
                         return true;  
                      
                     else if(key.compareToIgnoreCase(p.key)<0)  
                         p=p.left;  
                     else  
                         p=p.right;  
                 }  
                 return false;  
             }
             
             
    public boolean insert(String k, T val) {
        if (root == null) {
            current = root = new BSTNode<T>(k, val);
            return true;
        }
    
        BSTNode<T> parent = null;
        BSTNode<T> p = root;
    
        while (p != null) {
            parent = p;
            if (k.compareToIgnoreCase(p.key) < 0) {
                p = p.left;
            } else if (k.compareToIgnoreCase(p.key) > 0) {
                p = p.right;
            } else {
                // Duplicate key
                current = p;
                return false;
            }
        }
    
        BSTNode<T> tmp = new BSTNode<T>(k, val);
        if (k.compareToIgnoreCase(parent.key) < 0) {
            parent.left = tmp;
        } else {
            parent.right = tmp;
        }
    
        current = tmp;
        return true;
    }
    
    
    
    public void inOrder() { // to print BSt in order
        if (root==null)
            System.out.println("Empty tree");
        else
            inOrder(root); // recursion
    }
    private void inOrder(BSTNode p) {
        if (p==null)
            return;
        
        inOrder(p.left); // left side
        System.out.println("key = " + p.key); // processing
        System.out.println("words: "+p.data);
        //((Words)p.data).display();// change to linked list (cast) after test!!!
        inOrder(p.right); // for right
        
        
    
        
    
        
    }
    public static void main(String[] args) {
            BST<Double> bt = new BST<Double>();
            
            System.out.println("is empty? : "+ bt.empty());
            bt.insert("A", 43.0);
            bt.insert("A", 44.7);
            bt.insert("D", 455.0);
            bt.insert("L", 876.7);
            bt.insert("J", 6.0);
            bt.insert("B", 9.0);
            bt.insert("z", 0.0);
            bt.insert("y", 11.0);
            bt.inOrder();
            
    
    
            
        }
             
             
             
             
             
             
}  
    