public class CriterioNOT implements Criterio {
    private Criterio c;
    
    public CriterioNOT(Criterio c1) {
        c = c1;
    }
    
    @Override 
    public boolean cumple(Noticia n) {
        return !c.cumple(n);
    }
}