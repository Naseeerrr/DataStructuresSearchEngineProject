
public class QueryProcessing_BST {
	

    static InvertedBST inverted;
    public QueryProcessing_BST(InvertedBST inverted){
    this.inverted=inverted;
    }
    public static LinkedList<Integer>BooleanQuery(String Query){
    
      if(!Query.contains("AND")&&!Query.contains("OR"))
         return AndQuery(Query);
     else if(Query.contains("AND")&&!Query.contains("OR"))
         return AndQuery(Query);
     else if(!Query.contains("AND")&&Query.contains("OR"))
         return ORQuery(Query);
     else     
     return MixedQuery(Query);
    }
     public static LinkedList<Integer>MixedQuery(String Query){
         LinkedList<Integer> A=new LinkedList<Integer>();
         LinkedList<Integer> B=new LinkedList<Integer>();
         if(Query.length()==0) return A;  
         String ors[]=Query.split("OR");
       ///////////////////////////////         
         A=AndQuery(ors[0]);
         for(int i=1;i<ors.length;i++)
        {
         B=AndQuery(ors[i]);
         A=ORQuery(A, B);
        }
        return A;
     }
    public static LinkedList<Integer>AndQuery(String Query){
    LinkedList<Integer> A=new LinkedList<Integer>();
    LinkedList<Integer> B=new LinkedList<Integer>();
    String terms[]=Query.split("AND");   
    if(terms.length==0) return A;    
    // ترجع قيمة الليست اللي مرتبطة بهذه الكلمة
    
    //هنا دالة البحث وضعت المؤشر عند الكلمة المطلوبة إذا كانت موجودة
     boolean found=inverted.Search_word_inverted(terms[0].trim().toLowerCase());
       if(found){
         A=inverted.inverted_index.retrieve().IDs;        
       }
   for(int i=1;i<terms.length;i++)
   {      
       found=inverted.Search_word_inverted(terms[i].trim().toLowerCase());
       if(found)
         B=inverted.inverted_index.retrieve().IDs;    
       
       A=AndQuery(A, B);
      
   }
      
    return A;
    }
   public static LinkedList<Integer> AndQuery
                             (LinkedList<Integer>A,LinkedList<Integer>B)
   {
   LinkedList<Integer> result=new LinkedList<Integer>();
    if(A.empty()||B.empty())
       return result;
    A.findFirst();
    while(true){
      boolean found=existsIn_result(result,A.retrieve());
      if(!found){ // not found in result
        B.findFirst();
        while(true)
        {
        if(B.retrieve().equals(A.retrieve()))
        {
         result.insert(A.retrieve());
         break;
        }
        if(!B.last())
          B.findNext();
        else
           break;
      
        }//end inner while for B
      
        }//end if not found
      if(!A.last())
          A.findNext();
       else
          break;
    }
   return result;
   
   }
                             ////////////////////
    public static LinkedList<Integer>ORQuery(String Query){
    LinkedList<Integer> A=new LinkedList<Integer>();
    LinkedList<Integer> B=new LinkedList<Integer>();
    String terms[]=Query.split("OR");
    if(terms.length==0) return A;    
    //ممكن نعمل search 
    // ترجع قيمة الليست اللي مرتبطة بهذه الكلمة
    
    //هنا دالة البحث وضعت المؤشر عند الكلمة المطلوبة إذا كانت موجودة
     boolean found=inverted.Search_word_inverted(terms[0].trim().toLowerCase());
       if(found)
         A=inverted.inverted_index.retrieve().IDs;
   for(int i=1;i<terms.length;i++)
   {
       found=inverted.Search_word_inverted(terms[i].trim().toLowerCase());
       if(found)
         B=inverted.inverted_index.retrieve().IDs;
       A=ORQuery(A, B);
   }
      
    return A;
    }
   public static LinkedList<Integer> ORQuery
                             (LinkedList<Integer>A,LinkedList<Integer>B)
   {
   LinkedList<Integer> result=new LinkedList<Integer>();
    if(A.empty()&&B.empty())
       return result;
     A.findFirst();
     while(!A.empty()){
      boolean found=existsIn_result(result,A.retrieve());
      if(!found){ // not found in result
         result.insert(A.retrieve());
      
       }//end if
       if(!A.last())
          A.findNext();
       else
          break;
    }
     B.findFirst();
      while(!B.empty())
      {
        boolean found=existsIn_result(result,B.retrieve());
        if(!found){ // not found in result
         result.insert(B.retrieve());      
        }//end if
        if(!B.last())
          B.findNext();
        else
           break;
      
      }//end inner while for B
   return result;
   
   }
                            /////////////////
    public static LinkedList<Integer>notQuery(String Query,Index ind1){
    LinkedList<Integer> A=new LinkedList<Integer>();
    LinkedList<Integer> B=new LinkedList<Integer>(); 
    if(Query.length()==0) return A;    
    String term=Query.replaceFirst("NOT","").trim().toLowerCase();
     boolean found=inverted.Search_word_inverted(term);
       if(found){
         A=inverted.inverted_index.retrieve().IDs;        
       }
       if(ind1.All.empty()) return A;
       ind1.All.findFirst();
       while(!ind1.All.last()){      
       if(!A.exist(ind1.All.retrieve().id))
           B.insert(ind1.All.retrieve().id);
         ind1.All.findNext();
       } 
      if(!A.exist(ind1.All.retrieve().id))
           B.insert(ind1.All.retrieve().id);
     return B;
    }
      public static boolean existsIn_result(LinkedList<Integer>result,Integer id) {
      if(result.empty()) return false;
        result.findFirst();
        while (!result.last()) {
            if (result.retrieve().equals(id)) {
                return true;
            }
            result.findNext();
        }
        if (result.retrieve().equals(id)) {
                return true;
            }
        return false;
    }
}
	


