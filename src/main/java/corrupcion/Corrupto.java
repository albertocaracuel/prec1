/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package corrupcion;

/**
 *
 * @author alberto
 */
public class Corrupto implements Comparable<Corrupto>{

    private String nombre;
    private String apellidos;
    private int lista[];
    private static int contadorCorruptos = 0;

    public Corrupto() {
        contadorCorruptos++;
    }
    

    public Corrupto(String nombre, String apellidos) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.lista = new int  [10];
        contadorCorruptos++;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int[] getLista() {
        return lista;
    }

    public void setLista(int[] lista) {
        this.lista = lista;
    }

    @Override
    public String toString() {
        return "Corrupto{" + "nombre=" + nombre + ", apellidos=" + apellidos + ", lista=" + lista.toString() + '}';
    }

    public int corruptosRegistrados() {
        return contadorCorruptos;
    }
    
    public  int millonesDefraudados(Corrupto o){
        int dinero=0;
        
        for(int i =0; i<o.getLista().length ; i++){
            dinero+=lista[i];
        }
        
      
        return dinero;
    }

    @Override
    public int compareTo(Corrupto o) {
        
  
        String a = (this.nombre + this.apellidos);
        String b = (o.getNombre() + o.getApellidos());
        return a.compareTo(b);
    
    }
}
