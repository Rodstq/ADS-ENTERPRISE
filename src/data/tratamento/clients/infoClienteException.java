package controladores;

public class infoClienteException  extends Exception{

	public infoClienteException(String erro) {
		super(erro);
				
	}
	
	public infoClienteException(String erro, Exception e) {
	
		super(erro, e);
		
		
	}
	
}
