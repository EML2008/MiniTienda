/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package botiga;

import com.Ostermiller.util.Base64;

import utils.Utils;

import java.io.File;
import java.io.Serializable;

public class Clientes implements Serializable
{
    private String Nombre = "";
    private String Apellidos = "";
    private String UserName = "";
    private int Admin = 0;
    private String Password = "";
    private String correo = "";

    public Clientes()
    {
        this.Nombre = "";
        this.Apellidos = "";
        this.UserName = "";
        this.Password = "";
        this.correo = "";
    }

    public Clientes(String nombre,String apellidos,String user, String password,String correo)
    {
        this.Nombre = nombre;
        this.Apellidos = apellidos;
        this.UserName = user;
        this.Password = Base64.encode(password);
        this.correo = correo;
    }

    public void setAdmin(int Admin) {
        this.Admin = Admin;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setPassword(String Password) {
        this.Password = Base64.encode(Password);
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public void setCorreo(String Correo) {
        this.correo = Correo;
    }

    public boolean isAdmin() {
        if(this.Admin == 0)
            return false;
        else
            return true;
    }

    public String getApellidos() {
        return this.Apellidos;
    }

    public String getNombre() {
        return this.Nombre;
    }

    public String getPassword() {
        return Base64.decode(this.Password);
    }

    public String getUserName() {
        return this.UserName;
    }

    public int getAdmin() {
        return this.Admin;
    }

    public String getCorreo() {
        return this.correo;
    }

    public Clientes[] cargarClientes(File fitxer)
    {
        return Utils.llegirClients(fitxer);
    }
    
    public void guardarClientes(Clientes[] array)
    {
        Utils.escriureFitxer("src\\ficheros\\clientes.dat", array);
    }

    public int comprobarCorreo()
    {
        int encontrado = 0;

        encontrado = this.correo.indexOf("@");
        if(encontrado != -1)
        {
            encontrado = this.correo.indexOf(".", encontrado);
            if(encontrado != -1)
            {
                int aux = this.correo.indexOf("@", encontrado);
                if(aux != -1)
                {
                    encontrado = -1;
                }else
                {
                    aux = this.correo.indexOf(".", encontrado);
                    if(aux != -1)
                    {
                        encontrado = -1;
                    }
                }
            }
        }

        return encontrado;
    }
}
