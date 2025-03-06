import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public abstract class ElemNoticia {
    //Cantidad de noticias
    public abstract int getCantidadNoticias();
    
    //Es una copia
    public abstract ElemNoticia restriccionTopico(String palabra_clave);
    
    //Busqueda de noticias
    public abstract ArrayList<Noticia> getBusqueda(Criterio c);
    
    //Noticias ordenadas
    public ArrayList<Noticia> getBusquedaOrdenada(Criterio c, Comparator<Noticia> comp) {
        ArrayList<Noticia> aux = getBusqueda(c);
        Collections.sort(aux, comp);
        return aux;
    }
    
    //Mapear el sitio 
    public abstract ArrayList<String> getMapeo();
}