
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class PhoneNumberApp {

	public static void main(String[] args) {
		/// Obiettivo: leggere un file e ricavarne i numeri di telefono ///

		// 1. Trova la cartella
		String filename = "C:\\Users\\gabri\\Desktop\\Generale\\Programmazione\\Java\\PhoneNumber\\Elenconumeritest.txt";

		// 2. Crea il file in Java
		File file = new File(filename);
		String PhoneNumber = null;

		try { // CON TRY TESTO IL CODICE
				// 3. Apri il file
			BufferedReader br = new BufferedReader(new FileReader(file));

			// 4. Leggi il file
			PhoneNumber = br.readLine();

			// 5. Chiudi le risorse
			br.close();
		} catch (FileNotFoundException e) { // CON CATCH becco l'errore e lo risolve a modo nostro
			System.out.println("ERROR: File not found: " + filename);
		} catch (IOException e) { // becco l'errore e lo risolve a modo nostro
			System.out.println("ERROR: Could not read the data: " + filename);
		}

		// Numero di telefono valido:
		// lunghezza 10 caratteri
		// Evitare 113

		try {
			for (int n = 0; n < PhoneNumber.length(); n++) {
				if (PhoneNumber.substring(n).equals("1")) {
					if (PhoneNumber.substring(n, n + 2).equals("33" + " ")) {
						throw new EmergencyException();
					}
				}
			}
			if (PhoneNumber.length() != 10) {
				throw new TenDigitException();
			}
			if (PhoneNumber.substring(0, 1).equals("3")) {
				System.out.println(PhoneNumber);
			} else {
				throw new AreaCodeException();
			}

		} catch (TenDigitException e) {
			System.out.println("ERRORE: Il numero di telefono non raggiunge i 10 caratteri.");
		} catch (AreaCodeException e) {
			System.out.println("ERRORE: Il numero non è italiano.");
		} catch (EmergencyException e) {
			System.out.println("ERRORE: È il numero della polizia.");
		}

	}
}

class TenDigitException extends Exception { // importante aggiungere extends Exception per ogni tipo di eccezione

}

class AreaCodeException extends Exception {

}

class EmergencyException extends Exception {

}