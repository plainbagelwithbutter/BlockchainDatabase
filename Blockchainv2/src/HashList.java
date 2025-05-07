
public class HashList {

	protected HashNode head;
	protected HashNode tail;
	
	public HashList() {
		//-1 denotes that they don't hold info
		//**0 denotes that they don't belong to a user**
		head = new HashNode("-1");
		tail = new HashNode("-1");
		head.setNextNode(tail);
		tail.setPreviousNode(head);
		
		startList("start");
	}
	
	private void startList(String input) {
		HashNode node = new HashNode(input);
		head.setNextNode(node);
		tail.setPreviousNode(node);
		node.setPreviousNode(head);
		node.setNextNode(tail);
		
		node.setHashValue();
		
	}
	
	//creates node with info to the chain
	public void addNewNode(String input) {
		HashNode node = new HashNode(input);
		addToChain(node);
	}
	
	//adds node to the chain
	private void addToChain(HashNode k) {
		k.setPreviousNode(tail.getPreviousNode());
		tail.getPreviousNode().setNextNode(k);
		
		
		tail.setPreviousNode(k);
		k.setNextNode(tail);
		
		k.setHashValue();
	}
	
	public HashNode getHeadNode() {
		return head;
	}
	
	public HashNode getLastNode() {
		return tail.getPreviousNode();
	}
	
	
	
	
}
