/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package corrupcion;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author alberto
 */
public class Hacienda {

    public Hacienda() {
    }

    public static ArrayList<Corrupto> leerFichero(String url) {
        ArrayList<Corrupto> listaCorruptos = new ArrayList<>();
        // Fichero a leer con datos de ejemplo

        // Variables para guardar los datos que se van leyendo
        String[] tokens;
        String linea;

        System.out.println("Leyendo el fichero: " + url);

        // Inicialización del flujo "datosFichero" en función del archivo llamado "idFichero"
        // Estructura try-with-resources. Permite cerrar los recursos una vez finalizadas
        // las operaciones con el archivo
        try ( Scanner datosFichero = new Scanner(new File(url), "UTF-8")) {
            // hasNextLine devuelve true mientras haya líneas por leer
            while (datosFichero.hasNextLine()) {
                // Guarda la línea completa en un String
                //despues al string linea le sumo la siguiente linea junto con una coma
                //para que se me guarde todo en el array tokens
                linea = datosFichero.nextLine();
               
                linea+="," + datosFichero.nextLine();
                // Se guarda en el array de String cada elemento de la
                // línea en función del carácter separador de campos del fichero CSV
                tokens = linea.split(",");
                int lista[]= new int [10];
                int j=0;
                for(int i=2; i<tokens.length;i++){
                    lista[j]=Integer.parseInt(tokens[i]);
                    j++;
                }
                Corrupto nuevo = new Corrupto();
                nuevo.setApellidos(tokens[0]);
                nuevo.setNombre(tokens[1]);
                nuevo.setLista(lista);
               
                listaCorruptos.add(nuevo);

                

            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return listaCorruptos;
    }
    
    
    public static void escribirFichero(String idFichero,ArrayList<Corrupto> lista){
        

        // Si se utiliza el constructor FileWriter(idFichero, true) entonces se anexa información
        // al final del fichero idFichero
        // Estructura try-with-resources. Instancia el objeto con el fichero a escribir
        // y se encarga de cerrar el recurso "flujo" una vez finalizadas las operaciones
        try ( BufferedWriter flujo = new BufferedWriter(new FileWriter(idFichero))) {
            for (Corrupto o : lista) {

              flujo.write(o.toString());
                // Metodo newLine() añade salto de línea después de cada fila
                flujo.newLine();
            }
            // Metodo fluh() guarda cambios en disco 
            flujo.flush();
            System.out.println("Fichero " + idFichero + " creado correctamente.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        
    }
}


