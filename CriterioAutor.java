public class CriterioAutor implements Criterio {
    private String autor_requerido;
    
    public CriterioAutor(String a) {
        autor_requerido = a;
    }
    
    @Override
    public boolean cumple(Noticia n) {
        return n.getAutor().equals(this.autor_requerido);
    }
}