import java.io.*;
import java.util.Random;
import java.util.Scanner;
import java.math.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);
		
		
		
		
		
		//OG test for functionality
//		String info = user1.requestInfo(0);
//		System.out.println(info + "\n");
//		
//		info = user2.requestInfo(1);
//		System.out.println(info + "\n");
		
		
		//Test 1: 100 random requests, 1 user ////////////////////////////////////////////////////////////////////////////////
		
//		int numOfTrials = 100;
//		long results[] = new long[numOfTrials];
//		
//		for(int i = 0; i<numOfTrials; i++) {
//			long start = System.nanoTime();
//			
//			user1.requestInfo(i);
//			
//			long stop = System.nanoTime();
//			
//			results[i] = stop-start;
//			
//			System.out.println(results[i]);
//		}
//		
//		double avg = 0;
////		
//		for(int i=0; i<results.length; i++) {
//			avg = avg + results[i];
//		}
//		
//		avg = avg/results.length;
//		
//		System.out.println("Average: " + avg);
//		
//		File output = new File ("output.txt");
//		
//		try {
//			FileWriter fw = new FileWriter(output);
//			for(int i = 0; i<numOfTrials; i++) {
//				fw.write(String.valueOf(results[i]) + "\n");
//			}
//			fw.close();
//			
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		//TEST 2: 100 random requests, 2 users //////////////////////////////////////////////////////////////////////////////
		
//		int numOfTrials = 100;
//		long results[] = new long[numOfTrials];
//		
//		for(int i = 0; i<numOfTrials; i++) {
//			long start = System.nanoTime();
//			
//			if(i%2==0) {
//				user1.requestInfo(i);
//			}else {
//				user2.requestInfo(i);
//			}
//			
//			long stop = System.nanoTime();
//			
//			results[i] = stop-start;
//			
//			//System.out.println(results[i]);
//		}
//		
		
		
//		File output = new File ("output.txt");
//		
//		try {
//			FileWriter fw = new FileWriter(output);
//			for(int i = 0; i<numOfTrials; i++) {
//				fw.write(String.valueOf(results[i]) + "\n");
//			}
//			fw.close();
//			
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		//TEST 3: 100 rounds, 2 users, randomly switching //////////////////////////////////////////////////////////////////
//		int numOfTrials = 100;
//		long results[] = new long[numOfTrials];
//		
//		for(int i = 0; i<numOfTrials; i++) {
//			long start = System.nanoTime();
//			
//			Random random = new Random();
//			
//			
//			if(random.nextBoolean()) {
//				user1.requestInfo(i);
//			}else {
//				user2.requestInfo(i);
//			}
//			
//			long stop = System.nanoTime();
//			
//			results[i] = stop-start;
//			
//			System.out.println(results[i]);
//		}
//		
//		double avg = 0;
//		
//		for(int i=0; i<results.length; i++) {
//			avg = avg + results[i];
//		}
//		
//		avg = avg/results.length;
//		
//		System.out.println("Average: " + avg);
		
		Server server = new Server();
//		
//		int numUsers = 100;
//		
//		User userArray[] = new User[numUsers];
//		for(int i = 0; i<numUsers; i++) {
//			userArray[i] = new User(server);
//		}
//		
//		
//		int numOfTrials = 100;
//		long results[] = new long[numOfTrials];
//		
//		for(int i = 0; i<numOfTrials; i++) {
//			long start = System.nanoTime();
//			
//			Random random = new Random();
//			
//			int rand = random.nextInt(numUsers);
//			
//			userArray[rand].requestInfo(i);
//			
//			long stop = System.nanoTime();
//			
//			results[i] = stop-start;
//			
//			System.out.println(results[i]);
//		}
//		
//		double avg = 0;
//		long min = results[0];
//		long max = results[0];
//		
//		for(int i=0; i<results.length; i++) {
//			avg = avg + results[i];
//			if(results[i]<min) {
//				min = results[i];
//			}
//			if(results[i]>max) {
//				max = results[i];
//			}
//		}
//		
//		avg = avg/results.length;
//		
//		System.out.println("Average: " + avg);
//		System.out.println("Min: " + min);
//		System.out.println("Max: " + max);
//		
//		
//		
////		
//		File output = new File ("output.txt");
//		
//		try {
//			FileWriter fw = new FileWriter(output);
//			for(int i = 0; i<numOfTrials; i++) {
//				fw.write(String.valueOf(results[i]) + "\n");
//			}
//			fw.close();
//			
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		//OLD
		//int i = 3;
		//int input = 10;
		
		User user1 = new User(server);
		User user2 = new User(server);
		
		System.out.println("To act as user1: press q\nFor user2: press w \nFor server: press e\nTo exit: enter -1");
		
		String choice = scanner.next();
		User current = new User(server);
		if(choice.equals("q")) {
			current = user1;
			System.out.println("User 1 selected");
		}else if(choice.equals("w")) {
			current = user2;
			System.out.println("User 2 selected");
		}else if (choice.equals("e")) {
			
		}else if (Integer.valueOf(choice)==-1) {
			System.exit(0);
		}
		
		int i = 0;
		
		do {
			System.out.println("Enter the number associated with the information you wish to access.\nTo switch users: enter -2.\nTo exit: enter -1");
			i = scanner.nextInt();
			
			String info = current.requestInfo(i);
			current.addToPersonalLedger(info);
			System.out.println(info + "\n");
			System.out.println("Enter the number associated with the information you wish to access.\nTo switch users: enter -2.\nTo exit: enter -1");
			i = scanner.nextInt();
			//i = scanner.nextInt();
		}while(i>-1);
		
		
		if(i==-1) {
			System.exit(0);
		}else if(i==-2) {
			
		}else {
			
		}
		
		scanner.close();
		
		
		
	}

}
