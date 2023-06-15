package testes;

import conexaoDb.Db;
import java.util.Scanner;

import controladores.*;
public class teste {

	public static void main(String[] args) {
	Scanner leitor = new Scanner(System.in);
	
	//Apenas teste
	int Conectar;
	int Desconectar;
	
	System.out.println("Digite 1 para conectar");
	Conectar = leitor.nextInt();
	
	if(Conectar ==1) {
		
//		consultaCliente.consultaCliente();
		
	}
	
	System.out.println("Digite 2 para desconectar");
	Desconectar = leitor.nextInt();
	
	if(Desconectar ==2) {
		
		Db.CloseDb();
		
	}
	
	
	}

}