
package BLL;

public class Validaciones {
    public boolean Validar(String creditos, String nota){
        try{
            int c = Integer.parseInt(creditos);
            float n = Float.parseFloat(nota);
            if (c<0) {
                return false;
            }
            if ( n<0 || n>5) {
                return false;
            }
        }catch(NumberFormatException e){
            return false;
        }
        return true;
    }
}
