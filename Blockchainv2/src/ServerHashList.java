
public class ServerHashList{

	//private 
	protected ServerHashNode head;
	protected ServerHashNode tail;
	
	public ServerHashList() {
		//user id of -1 is for head and tail nodes, user id of 0 is for transactions unique to the server
		
		//set the head and the tail to be the beginning and the end
		head = new ServerHashNode("head", -1, 0);
		tail = new ServerHashNode("tail", -1, 0);
		head.setNextNode(tail);
		tail.setPreviousNode(head);
		
		//create a start node and put it after the head
		ServerHashNode node = new ServerHashNode("start", 0, 0);
		head.setNextNode(node);
		tail.setPreviousNode(node);
		node.setPreviousNode(head);
		//System.out.println(head.getInfo());
		node.setNextNode(tail);
		
		node.setHashValueMaster();
	}
	
	
	public int getLastUserHash(User user) {
			
		//search the list
		ServerHashNode trav = new ServerHashNode();
		trav.copy(tail.getPreviousNode());
			
		//trav.setHashValue(100);
			
		//loop thru the hashlist until either reach the end or find transaction with the userID
		while(trav.getHashValue() != -1 && trav.getUserID() != user.getUserID()) {
			trav.copy(trav.getPreviousNode());
		}
			
		//return the hash last connected to the user
		return trav.getHashValueUser();
	}
	
	//creates node with info to the chain
	public void addNew(String input, int userID, int userHash) {
		ServerHashNode node = new ServerHashNode(input, userID, userHash);
		
		addNewHash(node);
	}
	
	//adds node to the chain
	private void addNewHash(ServerHashNode k) {
		k.setPreviousNode(tail.getPreviousNode());
		tail.getPreviousNode().setNextNode(k);
			
			
		tail.setPreviousNode(k);
		k.setNextNode(tail);
			
		k.setHashValueMaster();
	}
	
	
	
}
