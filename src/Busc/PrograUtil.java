package Busc;
import java.io.FileReader;
import java.io.IOException;

import au.com.bytecode.opencsv.CSVReader;


public class PrograUtil {
	
	public static String LimpiarEntrada(String arg, String path) throws IOException {


		String TweetCortado = arg;
		String[] oracion = arg.split(" ");
		
		int cnt = 0;
		int maximo = oracion.length;

		while (cnt < maximo) {
			String[] word;
			CSVReader stopwords = new CSVReader(new FileReader(path));
			while ((word = stopwords.readNext()) != null) {
				if (word[0].equals(oracion[cnt])) {
					TweetCortado = TweetCortado.replace(word[0], "");
				}
			}
			cnt += 1;
			stopwords.close();
		}
		return TweetCortado;
	}
}

