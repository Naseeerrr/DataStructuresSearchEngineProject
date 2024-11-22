import java.io.File;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileNotFoundException;

public class Driver { // real work is here تنقية 
	
LinkedList<String> stops;
static Index indexs;
InvertedIndex inverted;
InvertedBST invertedBST;
int tokens=0; // number of words ,spaces....
LinkedList<String> unique_words = new LinkedList<>(); // to store only mentioned one time ,words (all of them)
int num_unique=0; // how many unique word in the document



public Driver() {
  stops=new LinkedList<>();
  indexs = new Index();
  inverted= new InvertedIndex();
  invertedBST= new InvertedBST();
  
}
public void Load_stops(String fileN) {
  try {
    File f= new File(fileN);
    Scanner input= new Scanner (f);
    while(input.hasNextLine()) {
      String line= input.nextLine();
      stops.insert(line);
    }
    
    
  }
  catch(Exception e) {
    System.out.println(" Finished");
  }
}

public void Load_doc(String fileN) {
  String line=null;
  try {
  File f= new File(fileN);
  Scanner input= new Scanner (f);
  input.nextLine();

  while(input.hasNextLine()) {
    line=input.nextLine();
    String takeID=line.substring(0,line.indexOf(","));
    int id=Integer.parseInt(takeID.trim());
    String content=line.substring(line.indexOf(",")+1).trim();
    LinkedList<String>WordsDoc= LL_index_inverted(content,id);
    indexs.add_document(new Document(id,WordsDoc,content)); // adding as index
    
  }
  }catch(Exception e) {
    System.out.println("Finished");
  }
}



 public LinkedList<String> LL_index_inverted(String content,int id){
   LinkedList<String>WordsDoc= new LinkedList<String>();
   do_index_inverted(content,WordsDoc,id);
   return WordsDoc;

 }
public  void do_index_inverted(String content,LinkedList<String> WordsDoc,int id) {
	
	content=content.replaceAll("\'", " ");
	content=content.replaceAll("-", " ");

   content = content.toLowerCase().replaceAll("[^a-zA-Z0-9\\s]", "");
  String []token=content.split("\\s+");
  tokens+= token.length ;// adding number of tokens
  
  for(String w: token) {
	  
	  if(!unique_words.exist(w)){// to insert non repetitive words
		  unique_words.insert(w);
		  num_unique++;}
	  
    if(!check_stops(w)) {
      WordsDoc.insert(w);
      inverted.inverted_add(w, id);
      invertedBST.add(w, id);
    }
  }
  /*for(int i=0;i<token.length;i++) {
    if(!check_stops(token[i])) {
      WordsDoc.insert(token[i] );
      inverted.inverted_add(token[i], id);
    }
  }*/
  
}
public boolean check_stops(String W) {
  if(stops==null||stops.empty())
    return false;
  stops.findFirst();
  while(!stops.last()) {
    if(stops.retrieve().equals(W))
      return true;
    stops.findNext();
    
  }
  if(stops.retrieve().equals(W))
    return true;
  return false;
}

public void loadFiles(String stops,String doc) {
  Load_stops(stops);
  Load_doc(doc);
}


public void display_doc (LinkedList<Integer> IDs){ // display Document by group of ids
	if(IDs.empty()) {
		System.out.println("No Documentd exists");
		return ; }
	IDs.findFirst();
	
	while(!IDs.last()) {
		Document d =indexs.get_doc(IDs.retrieve());
		 if(d!=null) {// id found
			 System.out.println("Document  "+ d.id + ": " +d.content);
			 
		 }
		 IDs.findNext();
	}
	Document d =indexs.get_doc(IDs.retrieve());
	 if(d!=null) {// id found
		 System.out.println("Document  "+ d.id + ": " +d.content);		 
	 }
	 System.out.println("");
	
}





public static void main(String[] args) {
		Driver d = new Driver ();
		d.loadFiles("C:\\Users\\hp\\OneDrive\\Desktop\\KSU\\CS 212 Project\\stop.txt","C:\\Users\\hp\\OneDrive\\Desktop\\KSU\\CS 212 Project\\dataset.csv");
			//d.indexs.display_document();
			System.out.println(" number of tokens =:" + d.tokens);
			System.out.println(" number of unique words =:" + d.num_unique);
			d.unique_words.display();

	//d.inverted.inverted_display();
		
							/////INVERTED_INDEX
//	QueryProcessing q= new QueryProcessing(d.inverted);
//	LinkedList<Integer>  res=QueryProcessing.MixedQuery("MarketORshiftORenviroments") ;
//	
//	InvertedBST inv = new InvertedBST();
//	inv.add_from_inverted_list(d.inverted);
//	
//	Ranking rank1= new Ranking(inv, d.indexs, "Market sports");
//	rank1.insert_sorted_in_list();
//	rank1.display_all_doc_with_score_usingList();
	
	//d.display_doc(res);
		
								//////// INDEX
	QueryProcessing_index ind= new QueryProcessing_index(d.indexs);
	LinkedList<Integer>  res1=QueryProcessing_index.BooleanQuery("marketANDsports") ;
	d.display_doc(res1);

	
	
		
	
		
		
	}
	
	
	
	
	
}





