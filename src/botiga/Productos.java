/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package botiga;
//import com.Ostermiller.util.Base64;
import java.io.File;
import java.io.Serializable;

import utils.Utils;


public class Productos implements Serializable {
 private String Nombre = "";
   private String Descripcion = "";
    private int Precio= 0;

    public Productos()
    {
        this.Nombre = "";
        this.Descripcion = "";
        this.Precio = 0;

    }


  public Productos(String nombre,String descripcion,int precio)
    {
        this.Nombre = nombre;
        this.Descripcion = descripcion;
        this.Precio = precio;


    }

   public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

  public void setPrecio(int Precio) {
        this.Precio = Precio;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getNombre() {
        return this.Nombre;
    }

    public int getPrecio() {
        return this.Precio;
    }

    public String getDescripcion() {
       return this.Descripcion;
    }

    //funciones de gestion de ficheros nuevas
    public Productos[] cargarProductos(File fitxer2)
    {
        return Utils.llegirProductes(fitxer2);
    }

    public void guardarProductos(Productos[] array)
    {
        Utils.escriureFitxer2("src\\ficheros\\productos.dat", array);
    }
   
    
}
