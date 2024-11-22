public class InvertedBST {
	BST<Words> inverted_index;
	
	public InvertedBST() {
		inverted_index= new BST<Words>();
	}
	public void add (String text,int id) {
		if(!Search_word_inverted(text)) {
			Words w =new Words(text);
			w.IDs.insert(id);
			inverted_index.insert(text, w);
		}
		else {
			Words Existing =inverted_index.retrieve();
			Existing.add_id(id);

			
		}
			
	}
	
	public void add_from_inverted_list(InvertedIndex inverted) {
	    // Check if the inverted index is empty
	    if (inverted.inverted_index.empty()) {
	        return;
	    }

	    // Start at the first element in the inverted index
	    inverted.inverted_index.findFirst();

	    // Iterate through the inverted index until the last element
	    while (!inverted.inverted_index.last()) {
	        // Insert the current item into the inverted index
	        inverted_index.insert(inverted.inverted_index.retrieve().text,inverted.inverted_index.retrieve());
	    	
	           // inverted.inverted_index.retrieve().text,  // Retrieve the text from the current item
	          //  inverted.inverted_index.retrieve()        // Retrieve the associated data
	       
	        inverted.inverted_index.findNext();
	    }

	    // Handle the last element separately
	    inverted_index.insert(inverted.inverted_index.retrieve().text,inverted.inverted_index.retrieve() );  ;
	}

	
	
	public boolean Search_word_inverted(String w) {
		return inverted_index.findkey(w);
		
	}
	

	
	public void display_inverted() {
		if(inverted_index==null ||inverted_index.empty()) {
			System.out.println("empty");
			return;}
		
		inverted_index.inOrder();
	}
}
