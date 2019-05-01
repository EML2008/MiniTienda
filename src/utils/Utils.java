
package utils;

import javax.swing.JTable;
import botiga.Clientes;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.NoSuchProviderException;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import botiga.Productos;

public class Utils 
{



    public static Clientes[] guardarTablaClientes(Clientes[] arrayClientes, JTable tableUsers)
    {
        int admin = 0;
        for(int x = 0; x < tableUsers.getRowCount(); x++)
        {
            arrayClientes[x].setNombre(tableUsers.getValueAt(x, 0).toString());
            arrayClientes[x].setApellidos(tableUsers.getValueAt(x, 1).toString());
            arrayClientes[x].setCorreo(tableUsers.getValueAt(x, 2).toString());
            arrayClientes[x].setUserName(tableUsers.getValueAt(x, 3).toString());
            arrayClientes[x].setPassword(tableUsers.getValueAt(x, 4).toString());
            admin = leerEntero(tableUsers.getValueAt(x, 5).toString());
            if((admin == 1)||(admin == 0))
            {
                arrayClientes[x].setAdmin(admin);
            }
            else
            {}
        }
        return arrayClientes;
    }
     public static Productos[] guardarTablaProductos(Productos[] arrayProductos, JTable tableProducts)
    {
        int precio = 0;
        for(int x = 0; x < tableProducts.getRowCount(); x++)
        {
            arrayProductos[x].setNombre(tableProducts.getValueAt(x, 0).toString());
            precio = leerEntero(tableProducts.getValueAt(x, 1).toString());
            arrayProductos[x].setPrecio(precio);
            arrayProductos[x].setDescripcion(tableProducts.getValueAt(x, 2).toString());


        }
        return arrayProductos;
    }
    /**
     * llegirFitxer Es una funció que serveix per llegir el contingut d'un Fitxer serialitzar. Rep una variable de tipus File anomenada 'fitxer'
     * que es el fitxer que volem llegir.
     * @param fitxer Es el fitxer que volem llegir.
     * @return Retorna el contingut del fitxer o null.
     */
    public static Clientes[] llegirClients(File fitxer)
    {
       try
        {
            MyObjectInputStream in = new MyObjectInputStream( new FileInputStream(fitxer));

            Clientes[] aux = (Clientes[]) in.readObject();
            in.close();
            return aux;
        }
        catch (Exception e)
        {
        }
       System.out.println("Array clientes Empty");
       return new Clientes[50];
    }
      public static Productos[] llegirProductes(File fitxer)
    {
       try
        {
            MyObjectInputStream in = new MyObjectInputStream( new FileInputStream(fitxer));

            Productos[] aux = (Productos[]) in.readObject();
            in.close();
            return aux;
        }
        catch (Exception e)
        {
        }
       System.out.println("Array clientes Empty");
       return new Productos[50];
    }

    
    /**
     * llegirFitxer Es una funció que serveix per escriure en un Fitxer serialitzar el contingut d'un array de Productes. 
     * Rep una variable de tipus File anomenada 'fitxer' que es el fitxer que volem escriure.
     * @param fitxer Es el fitxer que volem escriure.
     * @param array Es l'array de Productes que volem guardar
     */
    public static void escriureFitxer(String file, Clientes[] array)
    {
        File fitxer = new File(file);
       try
        {
            FileOutputStream outfisico = new FileOutputStream(fitxer);
            ByteArrayOutputStream presalida = new ByteArrayOutputStream();
            MyObjectOutputStream out = new MyObjectOutputStream(presalida);
            
            out.writeObject(array);
            out.close();
            presalida.writeTo(outfisico);
        }
        catch (Exception e)
        {
        }
    }

    // pensar algo para evitar DRY
     public static void escriureFitxer2(String file, Productos[] array)
    {
        File fitxer = new File(file);
       try
        {
            FileOutputStream outfisico = new FileOutputStream(fitxer);
            ByteArrayOutputStream presalida = new ByteArrayOutputStream();
            MyObjectOutputStream out = new MyObjectOutputStream(presalida);

            out.writeObject(array);
            out.close();
            presalida.writeTo(outfisico);
        }
        catch (Exception e)
        {
        }
    }

     public static int buscarCliente(Clientes[] array, String userName)
    {
        int cont = 0;

        while(array[cont] != null)
        {
            if (array[cont].getUserName().equalsIgnoreCase(userName))
            {
                return cont;
            }
            cont++;
        }
        return -1;
    }
    public static void eliminarCliente(Clientes[] array,int pos)
    {
        int cont = pos;
        while(array[cont] != null)
        {
            array[cont] = array[cont+1];
            cont++;
        }
    }
     public static void eliminarProducto(Productos[] array,int pos)
    {
        int cont = pos;
        while(array[cont] != null)
        {
            array[cont] = array[cont+1];
            cont++;
        }
    }

    public static Clientes[] insertarCliente(Clientes[] array,String nombre,String apellidos,String password,String username, String correo)
    {
        Clientes prod = new Clientes(nombre,apellidos,username,password,correo);
        int cont = 0;
        while(array[cont] != null)
            cont++;
        array[cont] = prod;
        return array;
    }
   
    
    public static Productos[] insertarProductos(Productos[] array,String nombre,String descripcion,int precio)
    {
        Productos prod = new Productos(nombre,descripcion,precio);
        int cont = 0;
        while(array[cont] != null)
            cont++;
        array[cont] = prod;
        return array;
    }

  

    public static int leerEntero(String admin) {
        try
        {
            return (int)Integer.valueOf(admin).intValue();
        }
        catch (Exception e)
        {
            return -1;
        }
    }

    public static void enviamail(String mensajeEnviar,String subject,Clientes cliente) throws NoSuchProviderException, MessagingException{
        Properties props = new Properties();
        
        // Aqui usuario y password de gmail
        String cuentaCorreo = "cuenta@dominio.com"; // Introduce una cuenta de correo valida
        String passwCorreo = "password";  // Introduce el password de la cuenta
        String serverSMTP = "smtp.server"; // Introduce el servidor smtp de la cuenta

        // Nombre del host de correo, es smtp.gmail.com

        props.setProperty("mail.smtp.host", serverSMTP);

        // TLS si está disponible
        props.setProperty("mail.smtp.starttls.enable", "true");

        // Puerto de gmail para envio de correos
        props.setProperty("mail.smtp.port","587");

        // Nombre del usuario
        props.setProperty("mail.smtp.user","");

        // Si requiere o no usuario y password para conectarse.
        props.setProperty("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(props);

        // Para obtener un log de salida más extenso
        session.setDebug(true);


        //Construir un mensaje de texto sencillo
        //Si queremos enviar un mensaje sencillo de texto, simplemente instanciamos la clase MimeMessage. En el constructor se le pasa la Session que acabamos de obtener. Una vez instanciado, rellenamos los campos de interés: from, to, subject, texto, etc.
        MimeMessage message = new MimeMessage(session);

         // Quien envia el correo
        message.setFrom(new InternetAddress(cuentaCorreo));

        // A quien va dirigido
        message.addRecipient(Message.RecipientType.TO, new InternetAddress("risque33@gmail.com"));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(cliente.getCorreo()));

        message.setSubject(subject);

        String codiHTML = "ISO-8859-1";
        String formato = "html";
        message.setText(mensajeEnviar,codiHTML,formato);

        Transport t = session.getTransport("smtp");

        // Enviamos el correo 
        t.connect(cuentaCorreo,passwCorreo);
        t.sendMessage(message,message.getAllRecipients());
        t.close();
    }
}
