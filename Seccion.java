import java.util.ArrayList;
public class Seccion extends ElemNoticia {
    private String descripcion, imagen;
    private ArrayList<ElemNoticia> secciones;
    
    public Seccion(String desc, String img) {
        descripcion = desc;
        imagen = img;
        secciones = new ArrayList<>();
    }
    
    public void addNoticia(ElemNoticia e) {
        secciones.add(e);
    }
    
    public boolean tieneNoticia(Noticia n) {
        return secciones.contains(n);
    }
    
    //Servicios
    
    @Override 
    public int getCantidadNoticias() {
        int t = 0;
        for (ElemNoticia e : secciones)
            t += e.getCantidadNoticias();
        return t;
    }
    
    @Override
    public ElemNoticia restriccionTopico(String pc) {
        Seccion retorno = new Seccion(this.getDescripcion(), this.getImagen());
        boolean agregado = false;
        for (ElemNoticia e : secciones) {
            ElemNoticia aux = e.restriccionTopico(pc);
            if (aux != null) {
                retorno.addNoticia(aux);
                agregado = true;
            }
        }
        if (agregado) 
            return retorno;
        else return null;
    }
    
    @Override
    public ArrayList<Noticia> getBusqueda(Criterio c) {
        ArrayList<Noticia> retorno = new ArrayList<>();
        for (ElemNoticia e : secciones)
            retorno.addAll(e.getBusqueda(c));
        return retorno;
    }
    
    @Override
    public ArrayList<String> getMapeo() {
        ArrayList<String> mapeo_sitio = new ArrayList<>();
        String mi_map = this.descripcion;
        mapeo_sitio.add(mi_map);
        for (ElemNoticia e : secciones) {
            ArrayList<String> submapeo = e.getMapeo();
            for (String s : submapeo) {
                String map_actual = mi_map + "\\" + s;
                mapeo_sitio.add(map_actual);
            }
        }
        return mapeo_sitio;
    }
    
    //Getters y Setters
    
    public String getDescripcion() {
        return descripcion;
    }
    
    public String getImagen() {
        return imagen;
    }
    
}