package Busc;
import java.io.BufferedReader;
import java.io.Console;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.sql.DriverManager;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import java.util.Scanner;





/*Ahora ocupo guardar los nuevos tweets en otro archivo cvs igual y luego guardar todo en la base de datos*/
import au.com.bytecode.opencsv.*;


public class Indexador {
	
	private static String TweetPath;
	private static String WordsPath;
	
	private static void Indexar() throws IOException{
		
		CSVReader reader = new CSVReader(new FileReader(TweetPath));
		String[] nextLine;
		while ((nextLine = reader.readNext()) != null) {
			// nextLine[] is an array of values from the line
			// nextLine[0] = id del tweet
			// nextLine[1] = autor del tweet
			// nextLine[2] = contenido del tweet
			// nextLine[3] = Fecha del tweet

			Añadidor.Añadir2(nextLine[0], nextLine[2], nextLine[3]); // esta vara lo añade a la base
			String[] oracion = nextLine[2].split(" "); // parto el string en partes por los espacios
			String TweetCortado = nextLine[2]; // guardo el tweet original y no toco el nextLine[2]
			int cnt = 0;
			int maximo = oracion.length;

			Añadidor.Añadir("Username", nextLine[1], nextLine[0]);

			TweetCortado= PrograUtil.LimpiarEntrada(nextLine[2], WordsPath);
			Añadidor.Añadir("Tcortado", TweetCortado, nextLine[0]);
			while (cnt < maximo) {
				if (!oracion[cnt].isEmpty()) {
					if (oracion[cnt].charAt(0) == '#') {
						Añadidor.Añadir("Tag", oracion[cnt], nextLine[0]);
					}
				}
				cnt += 1;
			}

		}
		reader.close();
		System.out.println("Listo");
	}

	
	public static void main(String[] args) throws IOException {
		
		Scanner Entrada = new Scanner(System.in);
		System.out.println("Indicar la ruta hacia el archivo de tweets: ");
		TweetPath = Entrada.nextLine();
		System.out.println("Indicar la ruta hacia el archivo de stop words: ");
		WordsPath = Entrada.nextLine();
		PrintWriter writer = new PrintWriter(System.getProperty("user.dir")+"/wordpath.txt", "UTF-8");
		writer.println(WordsPath);
		writer.close();
		Indexador.Indexar();
		
	
	}
}
