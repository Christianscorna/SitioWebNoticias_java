public class CriterioLargoTexto implements Criterio {
    private int longitud_deseada;
    
    public CriterioLargoTexto(int l) {
        longitud_deseada = l;
    }
    
    @Override 
    public boolean cumple(Noticia n) {
        return n.getTexto().length() > this.longitud_deseada;
    }
}