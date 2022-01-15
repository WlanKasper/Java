package smirnov.artur.volta.ts.it.layout;

import java.io.FileWriter;
import java.io.IOException;

public class MyLayout {
/*
 FILE log.txt VIENE CREATO NELLA CARTELLA ROOT DEL PROGGETTO
 */
	private static FileWriter log;
	
	public MyLayout () {
		try {
			log = new FileWriter("log.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void writeString (String s) {
		System.out.println(s);
		try {
			log.write(s);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
