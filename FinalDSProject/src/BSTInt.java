class BSTNode2<T>{
    public int key;
    public T data;
    public BSTNode2<T> left;
    public BSTNode2<T> right;
    public BSTNode2(int k,T d) {
      key=k;
      data=d;
      left=right=null;
    }
  
  }
  public class BSTInt<T> {
  private BSTNode2<T> root;
  private BSTNode2<T> current;
  
  public BSTInt() {
    current=root=null;
  }
  
  public boolean empty() {
    return root==null;
  }
  
  public boolean full() {
    return false;
  }
  
  public T retrieve() {
    return current.data;
  }
  
  public boolean findKey(int ke) {
    BSTNode2<T> p=root;
    while(p!=null) {
      current=p;
      if(ke==p.key)
        return true;
      else if(ke>p.key)
        p=p.right;
      else
        p=p.left;
      }
    return false;
    }
  
  public boolean insert(int k, T val) {
    if(root==null) {
      current=root=new BSTNode2<T>(k, val);
      return true;
    }
    BSTNode2<T> p=root;
    while(p!=null) {
      current=p;
      if(k<p.key)
        p=p.left;
      else
        p=p.right;
    }
    
  BSTNode2<T> tmp=new BSTNode2<T>(k, val);
  if(k<current.key)
    current.left=tmp;
  else 
    current.right=tmp;
  current=tmp;
  return true;
  
      }
  
  public void display_decreasing() { 
    
    if (root==null) {
      System.out.println("Tree is empty");
    }
    else{
      System.out.println("DocumentID     Score");
      decrease(root);
    }
  
  }
  
  public void decrease(BSTNode2 p) {
    if(p==null) return;
    decrease(p.right);
    System.out.println(p.data);
    System.out.println("       "+p.key);
    decrease(p.left);
  
  }
  
  
  
  
  
  }