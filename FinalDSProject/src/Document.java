public class Document {
	LinkedList <String> word= new LinkedList<>();
	int id;
	String content;
	
	public Document(int id,LinkedList <String> word,String content ) {
		this.id=id;
		this.word=word;
		this.content=content;
		
	}
	
}
