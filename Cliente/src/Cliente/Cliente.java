package Cliente;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Cliente {
	public static void main(String[] args) throws UnknownHostException, IOException{
		
		//declara que s prescisa manda ligação ao ip e porta
		Socket s = new Socket("localhost",49999);

		//scanner para entrada de informacao
		Scanner sc = new Scanner(System.in);

		//cria um fluxo leitor para o socket em bytes
		InputStreamReader in = new InputStreamReader(s.getInputStream());
		
		//tras o fluxo leitor para caracteres
		BufferedReader bf = new BufferedReader(in);

		//envia fluxo de dados
		PrintWriter pr = new PrintWriter(s.getOutputStream());

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