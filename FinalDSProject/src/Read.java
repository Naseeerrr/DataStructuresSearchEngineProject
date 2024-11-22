import java.io.File;
import java.util.*;
public class Read {
	
 static String line=null;
	public static void reading(String fileName) {
		try {
			File f = new File(fileName);
			Scanner scanner=new Scanner(f);
			
			scanner.nextLine();
			
			while(scanner.hasNextLine()) {
				line=scanner.nextLine();
				if(line.length()<3) {
					System.out.println("Empty line found");
					break;
				}
				System.out.println(line);
				String x=line.substring(0,line.indexOf(',')); //to take between 0 and ,
				int id =Integer.parseInt(x.trim());// just in case for spaces(double check) and to covert to int
				String content = line.substring(line.indexOf(',')+1).trim();// to take the line after the (,)for document 
				
				
			}
			
		}
		catch(Exception e) {
			System.out.println("End of file");
		
	}
		}
		
	
public static void main(String[] args) {
	
	//reading("C:\\Users\\hp\\OneDrive\\Desktop\\KSU\\CS 212 Project\\dataset.csv");
/*	
	LinkedList <String> word= new LinkedList <>();
	word.insert("Hello");
	word.insert("Nawaf");
	word.insert("Alrabiah");
	LinkedList <String> word2= new LinkedList <>();
	word2.insert("Saudi");
	word2.insert("Flag");
	word2.insert("Alrabiah");

	Document doc1= new Document(1, word);
	Document doc2= new Document(2, word2);

Index ind = new Index();
ind.add_document(doc1);
ind.add_document(doc2);
ind.display_document();



	Words w1 = new Words("khalid");
	
	w1.add_id(1);
	w1.add_id(1);

	w1.add_id(2);

	Words w2 = new Words("Nawaf");
	w2.add_id(1);
	w2.add_id(3);
	
	Words w3 = new Words("hosieni");
	w3.add_id(1);
	w3.add_id(2);
	w3.add_id(2);
	w3.add_id(3);
	
	
	
	LinkedList<Words> invIndex= new LinkedList<>();
	invIndex.insert(w1);
	invIndex.insert(w2);
	invIndex.insert(w3);
	
	InvertedIndex inv1= new InvertedIndex();
	
	inv1.inverted_add("khalid", 1);
	inv1.inverted_add("khalid", 1);
	inv1.inverted_add("khalid", 2);
	inv1.inverted_add("khalid", 4);

	inv1.inverted_add("Nawaf", 1);
	inv1.inverted_add("Nawaf", 2);
	inv1.inverted_add("hosieni", 4);
	inv1.inverted_add("hosieni", 2);
	inv1.inverted_add("hosieni", 1);
	System.out.println(inv1.inverted_search("khalid"));
	inv1.inverted_display();


*/
	


	

	






	


	
  
	
	
	
}




}



