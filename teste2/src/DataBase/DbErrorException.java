package DataBase;

public class DbErrorException extends RuntimeException{
	
	
	public DbErrorException () {		
		
	}

	public DbErrorException(String msg) {
		
		super(msg);
	}
	
	
}
