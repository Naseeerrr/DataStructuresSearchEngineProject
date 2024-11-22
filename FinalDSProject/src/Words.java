
public class Words {    //for inverted index---> word founded in how many Doc.
	String text;
	LinkedList<Integer> IDs;
	
	
		public Words(String word) {
			text=word;
			IDs=  new LinkedList<Integer>();
		}
		
		public boolean ID_exist(Integer id) {  // to check if its there or not also to a id will not repeat if found more than once in the doc
			
			if(IDs.empty())
				return false;
			
			IDs.findFirst();
			while(!IDs.last()) {
				
				if(IDs.retrieve().equals(id))
					return true;
				
				IDs.findNext();
			}
			
			if(IDs.retrieve().equals(id)) // to check last id
				return true;
			
			return false;		}
		
		
		public void add_id(int id) {
			
			if(!ID_exist(id))  // add the id only if its not there
				IDs.insert(id);
			
		}

		public void display() {
		System.out.println(" the wors : "+ text);
		IDs.display();
		
		}
}
