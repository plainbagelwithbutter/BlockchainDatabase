
public class UserList {

		private UserNode head;
		private UserNode tail;
		
		public UserList() {
			head = new UserNode();
			tail = new UserNode();
		}
		
		public void addNew(int input) {
			UserNode node = new UserNode();
			addNewHash(node);
		}
		
		private void addNewHash(UserNode k) {
			tail.getPreviousNode().setNextNode(k);
			k.setPreviousNode(tail.getPreviousNode());
			
			tail.setPreviousNode(k);
			k.setNextNode(tail);
		}
		
		public UserNode getHeadNode() {
			return head;
		}
		
		public UserNode getLastNode() {
			return tail.getPreviousNode();
		}
		
		public int getLastHash(User user) {
			//search for the user by the id
			
			//return that user's last hash
			
			return 0;
		}
	
	
}
