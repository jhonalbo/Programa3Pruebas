
package co.edu.udea.logica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ContarLineas {

	public static void main(String[] args) {
		try{
			String path = new File("").getAbsolutePath()+"/fichero";
			System.out.println(path);
			FileReader fr = new FileReader(path);
			BufferedReader bf = new BufferedReader(fr);
			long nLineas = 0;	
			long nClases = 0;
			long nMetodos = 0;
			String linea;
			while ((linea = bf.readLine())!=null) {
				if(validar(linea)){
					nLineas++;
				}		
				if(lineaEsClase(linea)) {
					nClases++;
				}
//				if(lineaEsMetodo(linea)) {
//					nmetodos++;
//				}
			}
			System.out.println("Número de lineas en total:"+nLineas);
			System.out.println("Número de clases en total:"+nClases);
			
			bf.close();
		} catch (FileNotFoundException fnfe){
			fnfe.printStackTrace();
		} catch (IOException ioe){
			ioe.printStackTrace();
		}
	}
	
	public static boolean validar(String linea){
		linea = linea.trim();
		if(
				//comentario de una linea
				linea.startsWith("//")||
				//importaciones de librerias o clases
				linea.startsWith("import")||
				//lineas vacías o con solo espacios
				"".equals(linea)){
			return false;
		}else{
			return true;
		}
	}
	
	public static boolean lineaEsClase(String linea){
		return linea.matches(" class ");
	}

}