
public class Index {  // LinkedList of LinkedList --> of type Document---> consists of word + id
	
	LinkedList <Document> All;
	
	
	public Index() {
		 All= new LinkedList <Document>();
	}
	
	public void add_document (Document Doc) {
		All.insert(Doc);
	}
	
	public Document get_doc(int id) {  // search  by id (return)  the document by ID
		if(All.empty()) {
			System.out.println("No Documentd exists");
			return null ; }
		All.findFirst();
		while(!All.last()) {
			if(All.retrieve().id==id)
				return All.retrieve();
			All.findNext();
				
			}
		if(All.retrieve().id==id)
			return All.retrieve();
		
		return null;
		
		}
	public LinkedList<Integer> get_doc_word(String term) { // get the ids that are in the word
	    LinkedList<Integer> result = new LinkedList<>(); // we will move on the whole LL and save it here 
	    if (All.empty()) {
	        System.out.println("no documents exist");
	        return null;
	    }
	    All.findFirst();
	    while (!All.last()) {
	        if (All.retrieve().word.exist(term.toLowerCase().trim())) {// check!!
	            result.insert(All.retrieve().id); // take only ID
	        }
	        All.findNext();
	    }
	    if (All.retrieve().word.exist(term.toLowerCase().trim())) {// check!!
            result.insert(All.retrieve().id);
        }
	    return result;
	}

		
		

	public void display_document() {
		
		if(All.empty()) {
			System.out.println("The Document is empty");
			return;
		}
		All.findFirst();
		while(!All.last()) {
			Document doc=All.retrieve();
			System.out.println("-----------------------------------------------------");
			System.out.println("ID:  "+ doc.id);
			System.out.print("Words:  ");
			doc.word.display();;
			All.findNext();			
			}
		Document doc=All.retrieve(); // for last doc
		System.out.println("-----------------------------------------------------");
		System.out.println("ID:  "+ doc.id);
		System.out.print("Words:  ");
		doc.word.display();;
		System.out.println("<----------------------------------------------------->");
		System.out.println("End of the Document");
		
	}

}
