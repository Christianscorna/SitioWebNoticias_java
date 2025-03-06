import java.util.ArrayList;
public class Noticia extends ElemNoticia {
    private String titulo, introduccion, texto, autor, link;
    private ArrayList<String> palabras_clave;
    
    public Noticia(String ti, String in, String te, String a, String l) {
        titulo = ti.toUpperCase();
        introduccion = in;
        texto = te;
        autor = a;
        link = l;
        palabras_clave = new ArrayList<>();
    }
    
    @Override
    public boolean equals(Object o) {
        try {
            Noticia noti = (Noticia) o;
            return (titulo.equals(noti.getTitulo()) && autor.equals(noti.getAutor()));
        } catch (Exception e) {
            return false;
        }
    }
    
    public void addPalabraClave(String pc) {
        if (!palabras_clave.contains(pc))
            palabras_clave.add(pc);
    }
    
    public boolean contienePalabraClave(String pc) {
        return palabras_clave.contains(pc);
    }
    
    //Servicios
    
    @Override
    public int getCantidadNoticias() {
        return 1;
    }
    
    @Override
    public ElemNoticia restriccionTopico(String pc) {
        if (this.contienePalabraClave(pc)) {
            Noticia retorno = new Noticia(this.getTitulo(), this.getIntroduccion(), this.getTexto(), this.getAutor(), this.getLink());
            for (String s : palabras_clave)
                retorno.addPalabraClave(s);
            return retorno;
        } else return null;
    }
    
    @Override
    public ArrayList<Noticia> getBusqueda(Criterio c) {
        ArrayList<Noticia> retorno = new ArrayList<>();
        if (c.cumple(this))
            retorno.add(this);
        return retorno;
    }
    
    @Override
    public ArrayList<String> getMapeo() {
        ArrayList<String> map = new ArrayList<>();
        map.add(this.link);
        return map;
    }
    
    //Getters y Setters
    
    public String getTitulo() {
        return titulo;
    }
    
    public String getAutor() {
        return autor;
    }
    
    public String getIntroduccion() {
        return introduccion;
    }
    
    public String getTexto() {
        return texto;
    }
    
    public String getLink() {
        return link;
    }
}