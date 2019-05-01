/**
 * Redefinicion de la clase ObjectInputStream para que no escriba una cabecera
 * al principio del Stream.
 */
package utils;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.InputStream;

/**
 * Redefinicion de la clase ObjectInputStream para que no escriba una cabecera
 * al inicio del Stream.
 */
public class MyObjectInputStream extends ObjectInputStream
{
    /** Constructor que recibe InputStream */
    public MyObjectInputStream(InputStream in) throws IOException
    {
        super(in);
    }

    /** Constructor sin parametros */
    protected MyObjectInputStream() throws IOException, SecurityException
    {
        super();
    }

    /** Redefinicion del metodo de escribir la cabecera para que no haga nada. */
    @Override
    protected void readStreamHeader() throws IOException
    {
    }
}
