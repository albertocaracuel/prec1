/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package corrupcion;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import static corrupcion.Hacienda.leerFichero;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 *
 * @author alberto
 */
public class Prueba {

    public static void main(String[] args) {

        //declaro la estructura map
        SortedMap<String, Integer> mapaCorruptos = new TreeMap<>();
        //leeo el fichero y guardo la lista que devuelve
        ArrayList<Corrupto> listaCorruptos = leerFichero("./corruptos2021.txt");
        //ordeno el array por nombre y apellidos
        Collections.sort(listaCorruptos);
        //imprimo el array
        for (Corrupto o : listaCorruptos) {
            System.out.println(o.toString());

        }
        //calculo los millones de cada corrupto y los guardo en un map en el que la clave sea su nombre
        for (Corrupto o : listaCorruptos) {
            mapaCorruptos.put(o.getNombre(), o.millonesDefraudados(o));
        }

        System.out.println("---------------------------");
        //imprimir estructura map
        for (String key : mapaCorruptos.keySet()) {
            System.out.printf("Nombre %s -- Dinero %s %n", key, mapaCorruptos.get(key));
        }

        System.out.println("El dinero del corrupto es: " + buscarMillones(mapaCorruptos));
    }

    private static int buscarMillones(SortedMap<String, Integer> map) {
        Scanner sc = new Scanner(System.in);
        int dinero = 0;

        System.out.println("Introduzca el nombre del corrupto que quiere buscar");
        String nombre = sc.nextLine();
        String toUpperCase = nombre.toUpperCase();

        for (String key : map.keySet()) {
            if (toUpperCase.equalsIgnoreCase(nombre)) {
                dinero = map.get(key);

            }
        }

        return dinero;
    }

    
}
