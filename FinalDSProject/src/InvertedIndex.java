
public class InvertedIndex {  //LinkedList of LinkedList --> of type word
	LinkedList<Words> inverted_index;
	
public InvertedIndex() {
	inverted_index=new LinkedList<Words>();
}


public boolean inverted_search (String w) {
		if(inverted_index.empty())
			return false;	
		
		inverted_index.findFirst();
		while(!inverted_index.last()) {
			
			if(inverted_index.retrieve().text.equals(w))
				return true;
			inverted_index.findNext();		
		}
		if(inverted_index.retrieve().text.equals(w))
			return true;
		
		return false;		}
	
	
public void inverted_add(String w,int id) {
		if(inverted_search(w)) {  // we only add an index to the word
			Words wExist=inverted_index.retrieve();
			wExist.add_id(id);
		}
		else {
			Words word=new Words(w);
			word.add_id(id);
			inverted_index.insert(word);
		}
	}
public boolean search_inverted(String word) {
    if (inverted_index == null || inverted_index.empty())
        return false;

    inverted_index.findFirst();

    while (!inverted_index.last()) {
        if (inverted_index.retrieve().text.equals(word))
            return true;

        inverted_index.findNext();
    }

    if (inverted_index.retrieve().text.equals(word))
        return true;

    return false;
}
public void inverted_display() {
	if(inverted_index.empty() || inverted_index == null) {
		System.out.println("The inverted index is empty");
		return;}
	
	inverted_index.findFirst();		
	while(!inverted_index.last()) {
		Words w=inverted_index.retrieve();
		System.out.println("----------------------------------------");
		System.out.println("word: "+ w.text);
		System.out.print("Doc ID:  " );
		w.IDs.display();
		inverted_index.findNext();
	}
	Words w=inverted_index.retrieve();
	System.out.println("----------------------------------------");
	System.out.println("word: "+ w.text);
	System.out.print("Doc ID:  " );
	w.IDs.display();
	System.out.println("----------------------------------------");
	System.out.println("End of Words");	
}

}
