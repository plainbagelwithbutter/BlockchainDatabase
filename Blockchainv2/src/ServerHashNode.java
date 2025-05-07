
public class ServerHashNode extends HashNode{

	
	private ServerHashNode previousNode;
	private ServerHashNode nextNode;
	private int hashValueMaster;
	private int hashValueUser;
	private int userID;
	//String info;
	//private HashNode sib;
	
	public ServerHashNode() {
		
	}
	
	
	
	public ServerHashNode (String info, int userID, int userHash) {
		//hashValue = hash;
		this.info = info;
		this.userID = userID;
		this.hashValueUser = userHash;
	}
	
	
	
	
	public ServerHashNode getPreviousNode() {
		return previousNode;
	}
	public void setPreviousNode(ServerHashNode previousNode) {
		this.previousNode = previousNode;
		
	}
	public ServerHashNode getNextNode() {
		return nextNode;
	}
	
	public void setNextNode(ServerHashNode nextNode) {
		this.nextNode = nextNode;
	}
	
//	public int getHashValue() {
//		return hashValue;
//	}
//	
	public void setHashValueMaster() {
		String prev = String.valueOf(previousNode.userID + hashValueMaster + hashValueUser) + previousNode.info;
		hashValueMaster = prev.hashCode();
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}
	
	public void copy(ServerHashNode hash) {
		this.hashValueMaster = hash.hashValueMaster;
		this.hashValueUser = hash.hashValueUser;
		this.nextNode = hash.nextNode;
		this.previousNode = hash.previousNode;
		this.userID = hash.userID;
	}
	
	public int getHashValueMaster() {
		return hashValueMaster;
	}

	public void setHashValueMaster(int hashValueMaster) {
		this.hashValueMaster = hashValueMaster;
	}

	public int getHashValueUser() {
		return hashValueUser;
	}

	public void setHashValueUser(int hashValueUser) {
		this.hashValueUser = hashValueUser;
	}

}
