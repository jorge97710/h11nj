import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import javax.swing.JOptionPane;



public class manejador {
	private ArrayList<String> array = new ArrayList<String>();

	private Conexion con = new Conexion();

	ArrayList<String> leerContenido(String archivo) {
		String bfRead;
		try {
			BufferedReader ar = new BufferedReader(new FileReader(archivo));
			while ((bfRead = ar.readLine()) != null) {
				array.add(bfRead);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No se encontro archivo");
		}
		return array;
	}

	void hacergrafo(){
		String ciudad1="",ciudad2="",distancia="";

		for (String i:array){
			int primero =i.indexOf(" ");
			int segundo =i.indexOf(" ",primero+1);
			int tercero =i.indexOf(" ",segundo+1);

			ciudad1=i.substring(0,primero).trim();
			ciudad2=i.substring(primero,segundo).trim();
			distancia=i.substring(segundo,tercero).trim();
			con.insertar(ciudad1,ciudad1);
			con.insertar(ciudad2,ciudad2);
			con.relacionar(ciudad1, ciudad2, distancia);
			
		}
		
	}
	
}
