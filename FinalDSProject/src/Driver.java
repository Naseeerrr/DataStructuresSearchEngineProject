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

public static void displayMenu() {
    System.out.println("========= MENU =========");
    System.out.println("1. Retrieve a Term:");
    System.out.println("   - Using index with lists");
    System.out.println("   - Using inverted index with lists");
    System.out.println("   - Using inverted index with BST");
    System.out.println("2. Perform Boolean Retrieval.");
    System.out.println("3. Perform Ranked Retrieval.");
    System.out.println("4. Display All Indexed Documents.");
    System.out.println("5. Display Total Number of Documents in the Index.");
    System.out.println("6. Show Total Number of Unique Words (Excluding Stop Words).");
    System.out.println("7. Display Inverted Index (List of Lists).");
    System.out.println("8. Display Inverted Index (BST).");
    System.out.println("9. Display Indexed Tokens (Vocabulary and Total Tokens).");
    System.out.println("10. Exit the Program.");
    System.out.println("=========================");
}

public static void test() {
    Driver driver = new Driver();
    driver.loadFiles("C:\\Users\\khali\\OneDrive\\سطح المكتب\\CSC212 Project\\data\\data\\stop.txt", 
                     "C:\\Users\\khali\\OneDrive\\سطح المكتب\\CSC212 Project\\data\\data\\dataset.csv");

    Scanner scanner = new Scanner(System.in);
    int userChoice;
    do {
    	displayMenu(); // Calls the menu display method
        System.out.print("Please select an option: ");
        userChoice = scanner.nextInt();
        switch (userChoice) {
            case 1:
                System.out.print("Enter the term to search: ");
                String term = scanner.next().toLowerCase().trim();

                System.out.println("\nOption: Search using Index List");
                LinkedList<Integer> results = Driver.indexs.get_doc_word(term);
                System.out.print("Term Found: " + term + " -> ");
                results.display();

                System.out.println("\n-------------------------");
                System.out.println("Option: Search using Inverted Index (List)");
                if (driver.inverted.search_inverted(term)) {
                    driver.inverted.inverted_index.retrieve().display();
                } else {
                    System.out.println("No matches found in inverted index.");
                }

                System.out.println("\nOption: Search using Inverted Index (BST)");
                if (driver.invertedBST.Search_word_inverted(term)) {
                    driver.inverted.inverted_index.retrieve().display();
                } else {
                    System.out.println("No matches found in BST.");
                }
                break;

            case 2:
                scanner.nextLine(); // Clears the input buffer
                System.out.print("Enter a query for retrieval: ");
                String query = scanner.nextLine().toLowerCase()
                                     .replaceAll(" and ", " AND ")
                                     .replaceAll(" or ", " OR ");

                System.out.println("\nChoose the method for query processing:");
                System.out.println("1. Index");
                System.out.println("2. Inverted Index (List)");
                System.out.println("3. BST");
                System.out.println("4. Exit Query Menu");

                int methodChoice;
                do {
                    methodChoice = scanner.nextInt();
                    if (methodChoice == 1) {
                        QueryProcessing_index process = new QueryProcessing_index(Driver.indexs);
                        LinkedList<Integer> queryResults = QueryProcessing_index.MixedQuery(query);
                        driver.display_doc(queryResults);
                    } else if (methodChoice == 2) {
                        QueryProcessing process = new QueryProcessing(driver.inverted);
                        LinkedList<Integer> queryResults = QueryProcessing.MixedQuery(query);
                        driver.display_doc(queryResults);
                    } else if (methodChoice == 3) {
                        QueryProcessing_BST process = new QueryProcessing_BST(driver.invertedBST);
                        LinkedList<Integer> queryResults = QueryProcessing_BST.MixedQuery(query);
                        driver.display_doc(queryResults);
                    } else if (methodChoice != 4) {
                        System.out.println("Invalid choice. Try again.");
                    }
                } while (methodChoice != 4);
                break;

            case 3:
                scanner.nextLine(); // Clears the buffer
                System.out.print("Enter a query for ranking: ");
                String rankingQuery = scanner.nextLine().toLowerCase();
                Ranking rankProcessor = new Ranking(driver.invertedBST, Driver.indexs, rankingQuery);
                rankProcessor.insert_sorted_in_list();
                rankProcessor.display_all_doc_with_score_usingList();
                break;

            case 4:
                driver.indexs.display_document();
                System.out.println("-------------------------");
                break;

            case 5:
                System.out.println("Total Documents: " + Driver.indexs.All.n);
                System.out.println("-------------------------");
                break;

            case 6:
                System.out.println("Unique Words (Excluding Stop Words): " + driver.inverted.inverted_index.n);
                System.out.println("-------------------------");
                break;

            case 7:
                driver.inverted.inverted_display();
                break;

            case 8:
                driver.invertedBST.display_inverted();
                break;

            case 9:
                System.out.println("Token Count: " + driver.tokens);
                System.out.println("Unique Words (Including Stop Words): " + driver.unique_words.n);
                break;

            case 10:
                System.out.println("Thank you! Goodbye.");
                break;

            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }
    } while (userChoice != 10);
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
	QueryProcessingIndex ind= new QueryProcessingIndex(d.indexs);
	LinkedList<Integer>  res1=QueryProcessingIndex.BooleanQuery("marketANDsports") ;
	d.display_doc(res1);

	
	
		
	
		
		
	}
	
	
	
	
	
}





