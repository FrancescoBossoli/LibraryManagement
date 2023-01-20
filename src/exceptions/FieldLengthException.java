package exceptions;

public class FieldLengthException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public FieldLengthException(String message) {
		super(message);
	}	
}
