public class CriterioOR implements Criterio {
    private Criterio c1, c2;
    
    public CriterioOR(Criterio cr1, Criterio cr2) {
        c1 = cr1;
        c2 = cr2;
    }
    
    @Override 
    public boolean cumple(Noticia n) {
        return c1.cumple(n) || c2.cumple(n);
    }
}