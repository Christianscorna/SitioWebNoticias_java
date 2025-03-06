public class CriterioPoseePalabraClave implements Criterio {
    private String palabra_clave;
    
    public CriterioPoseePalabraClave(String pc) {
        palabra_clave = pc;
    }
    
    @Override
    public boolean cumple(Noticia n) {
        return n.contienePalabraClave(palabra_clave);
    }
}