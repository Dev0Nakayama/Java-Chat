package Cliente;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Cliente {
	public static void main(String[] args) throws UnknownHostException, IOException{
		@SuppressWarnings("resource")
		Socket s = new Socket("localhost",49999);
		PrintWriter pr = new PrintWriter(s.getOutputStream());
		Scanner sc = new Scanner(System.in);
		InputStreamReader in = new InputStreamReader(s.getInputStream());
		BufferedReader bf = new BufferedReader(in);
		System.out.println("Server Conectado");
		
		while(true) {
		//recebe
		String str = bf.readLine();
		System.out.println("cliente:"+str);
		
		//manda
		String say = sc.next();
		pr.println(say);
		pr.flush();
		}
	}
}