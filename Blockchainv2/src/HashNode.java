
public class HashNode {

	
	protected HashNode nextNode;
	protected HashNode previousNode;
	private int hashValue;
	//private int userID;
	protected String info;
	
	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public HashNode() {
		
	}
	
	public HashNode (String info) {
		//hashValue = hash;
		this.info = info;
		//this.userID = userID;
	}
	
	public HashNode getPreviousNode() {
		return previousNode;
	}
	public void setPreviousNode(HashNode previousNode) {
		this.previousNode = previousNode;
		
	}
	public HashNode getNextNode() {
		return nextNode;
	}
	
	public void setNextNode(HashNode nextNode) {
		this.nextNode = nextNode;
	}
	
	public int getHashValue() {
		return hashValue;
	}
	
	protected void setHashValue() {
		String prev = String.valueOf(hashValue) + previousNode.info;
		hashValue = prev.hashCode();
	}

//	public int getUserID() {
//		return userID;
//	}
//
//	public void setUserID(int userID) {
//		this.userID = userID;
//	}
	
	public void copy(HashNode hash) {
		this.hashValue = hash.hashValue;
		this.nextNode = hash.nextNode;
		this.previousNode = hash.previousNode;
		//this.userID = hash.userID;
	}
	
	
}
