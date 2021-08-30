package Serve;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Serve {
	public static void main(String[] args) throws IOException {
		
		ServerSocket ss = new ServerSocket(49999);
		Socket s = ss.accept();
		Scanner sc = new Scanner(System.in);
		InputStreamReader in = new InputStreamReader(s.getInputStream());
		BufferedReader bf = new BufferedReader(in);
		PrintWriter pr = new PrintWriter(s.getOutputStream());
		System.out.println("Cliente Conectado");

		while(true) {	
			//manda
			String say = sc.next();
			pr.println(say);
			pr.flush();

			//recebe
			String str = bf.readLine();
			System.out.println("Serve:"+str);
		}
	}
}