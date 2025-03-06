public class CriterioTitulo implements Criterio {
    private String titulo_requerido;
    
    public CriterioTitulo(String t) {
        titulo_requerido = t;
    }
    
    @Override
    public boolean cumple(Noticia n) {
        return n.getTitulo().equals(this.titulo_requerido);
    }
}