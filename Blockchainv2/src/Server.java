
import java.io.*;
//import java.util.*;
import java.util.Random;

public class Server {

	int serverID;
	//UserList userList;
	ServerHashList hashList;
	private String[] info = new String[101];
	private HashNode head = new HashNode("0");
	
	public Server() {
		//set variables as needed
		serverID = generateServerID();
		//userList = new UserList();
		hashList = new ServerHashList();
		
		//for now the "info" is just a list of strings... in this case a list of random animals
		//client requests an integer that represents the array index
		
		try {
			createDatabase();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//This is now done from the creation of the hashlist
		//hashList.startList("start");
	}
	
	public String getInfo(int info, int expectedLastHash, User user) {
		
		
		if(expectedLastHash == getLastHash(user)) {
			
			String ret = (info + ": " + getPrivateInfo(info));
			
			//add to the server chain
			//this.addToLedger(ret, user.getUserID());
			
			
			return ret;
			
		}else {
			//this.addToLedger("Failed access attempt", user.getUserID());
			return "Failed access attempt";
		}
	}
	
	private int getLastHash(User user) {
		
		//System.out.println("actual hash " + hashList.getLastUserHash(user));
		return hashList.getLastUserHash(user);
		
	}
	
	private int generateServerID() {
		//for right now userID is a random number between 0 and 1000
		//code in server checks if the ID is already in use
		Random random = new Random();
		return random.nextInt(1000);
	}
	
	private String getPrivateInfo(int i) {
		return info[i];
	}
	
	public void addToLedger(String info, int userID, int userHash) {
		
		hashList.addNew(info, userID, userHash);
		
	}
	
	private void startHashList() {
		
	}
	
	private void createDatabase() throws FileNotFoundException {
		
		//outdated code with data set as minecraft end poem
//		info[0] = "and the universe said";
//		info[1] = "i love you";
//		info[2] = "you have played the game well";
//		info[3] = "everything you need is within you";
//		info[4] = "you are stronger than you know";
//		info[5] = "you are the daylight";
//		info[6] = "you are the night";
//		info[7] = "the darkness you fight is within you";
//		info[8] = "the light you seek is within you";
//		info[9] = "you are not alone";
//		info[10] = "you are not seperate from every other thing";
		
		File inputFile = new File("input.txt");
		FileReader fr = new FileReader(inputFile);
		BufferedReader br = new BufferedReader(fr);
		
		String line;
		int i = 0;
		try {
			while((line=br.readLine())!=null) {
				info[i]=line;
				i++;
			}
			fr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
		
	
//	private int hash(int input) {
//		return input%407;
//	}
	
}
