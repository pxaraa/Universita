/**
 * 
 */
package it.uniroma2.lmp.jennifer;

/**
 * @author Armando Stellato &lt;stellato@info.uniroma2.it&gt;
 *
 */
public class StudenteCreationException extends Exception {

	/**
	 * 
	 */
	public StudenteCreationException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public StudenteCreationException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public StudenteCreationException(StudenteInitializationException cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public StudenteCreationException(String message,StudenteInitializationException cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

}
