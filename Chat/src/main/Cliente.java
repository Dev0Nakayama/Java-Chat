package main;

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

		System.out.print("Insira nome: ");String nome = sc.nextLine();
		System.out.println("Conectado");
		String say;

		do{
		//recebe
		String str = bf.readLine();
		System.out.println("cliente:"+str);
		
		//manda
		System.out.print(nome+": ");say = sc.nextLine();
		pr.println(say);
		pr.flush();
		}while(say.equals("exit") == false);
		s.close();sc.close();
	}
}