package Application;

import DataBase.db;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
	Scanner leitor = new Scanner(System.in);
	
	//Apenas teste
	int Conectar;
	int Desconectar;
	
	System.out.println("Digite 1 para conectar");
	Conectar = leitor.nextInt();
	
	if(Conectar ==1) {
		
		db.ConnectDb();
		
	}
	
	System.out.println("Digite 2 para desconectar");
	Desconectar = leitor.nextInt();
	
	if(Desconectar ==2) {
		
		db.CloseDb();
		
	}
	
	
	}

}
