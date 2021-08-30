package main;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Serve {
	public static void main(String[] args) throws IOException {
		
		//declara que ss prescisa escutar as ligaçoes da porta 49999
		ServerSocket ss = new ServerSocket(49999);

		//espera uma coneção de algum lugar
		Socket s = ss.accept();

		//scanner para entrada de dados
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
			//manda
			System.out.print(nome+": "); say = sc.nextLine();
			pr.println(say);
			pr.flush();

			//recebe
			String str = bf.readLine();
			System.out.println("Serve:"+str);
		}while(say.equals("exit") == false);
		
		ss.close();sc.close();
	}
}