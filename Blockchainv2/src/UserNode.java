
public class UserNode {
	
	int userID;
	int mostRecentHash;
	UserNode nextNode;
	UserNode previousNode;
	public Server server;
	

	public UserNode() {
		
	}

	public void setMostRecentHash(int mostRecentHash) {
		this.mostRecentHash = mostRecentHash;
	}
	
	public UserNode getNextNode() {
		return nextNode;
	}

	public void setNextNode(UserNode nextNode) {
		this.nextNode = nextNode;
	}

	public UserNode getPreviousNode() {
		return previousNode;
	}

	public void setPreviousNode(UserNode previousNode) {
		this.previousNode = previousNode;
	}
	
}
