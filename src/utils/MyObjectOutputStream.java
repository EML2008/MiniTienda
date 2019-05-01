/**
 * Redefinicion de la clase ObjectOutputStream para que no escriba una cabecera
 * al principio del Stream.
 */
package utils;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/**
 * Redefinicion de la clase ObjectOuputStream para que no escriba una cabecera
 * al inicio del Stream.
 */
public class MyObjectOutputStream extends ObjectOutputStream
{
    /** Constructor que recibe OutputStream */
    public MyObjectOutputStream(OutputStream out) throws IOException
    {
        super(out);
    }

    /** Constructor sin parametros */
    protected MyObjectOutputStream() throws IOException, SecurityException
    {
        super();
    }

    /** Redefinicion del metodo de escribir la cabecera para que no haga nada. */
    @Override
    protected void writeStreamHeader() throws IOException
    {
    }
}
