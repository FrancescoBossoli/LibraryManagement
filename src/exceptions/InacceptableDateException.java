package exceptions;

public class InacceptableDateException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public InacceptableDateException(String message) {
		super(message);
	}	
}