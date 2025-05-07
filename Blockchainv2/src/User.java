import java.util.Random;

public class User {

	private int userID;
	private int hashedID;
	private int mostRecentHash;
	public Server server;
	private HashList hashList;
	
	public User(Server serverI) {
		
		//generate id and hash it
		//System.out.println("User created");
		userID = generateUserID();
		hashedID = hash(userID);
		
		//set server variable
		server = serverI;
		
		//create hash list for this user
		hashList = new HashList();
		
		//have the server add the user to it's hash
		server.addToLedger("start", userID, hashList.tail.getPreviousNode().getHashValue());
		
	}
	
	private int generateUserID() {
		//for right now userID is a random number between 0 and 1000
		//code in server checks if the ID is already in use
		Random random = new Random();
		return random.nextInt(1000);
		
	}
	
	public int getUserID() {
		return userID;
	}
	
	public void addToPersonalLedger(String info) {
		hashList.addNewNode(info);
	}

	public String requestInfo(int i) {
		// TODO Auto-generated method stub
		String info = server.getInfo(i, getMostRecentHash(), this);
		
		//add to the user chain
		addToPersonalLedger(info);
		
		//add it to the server chain
		server.addToLedger(info, userID, hashList.tail.getPreviousNode().getHashValue());
		
		return info;
		
	}
	
	private int getMostRecentHash() {
		return hashList.getLastNode().getHashValue();
	}
	
	private int hash(int input) {
		return input%407;
	}
	
//	private int hash(String input) {
//		int output = input.hashCode();
//		return output;
//		
//	}
	
}
