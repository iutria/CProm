
package BLL;
import ENTITY.*;
import DAL.*;
import java.awt.TextField;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

public class Proceso {
    Datos datos;
    public Proceso(){
        datos = new Datos();
    }
    public void Guardar(Materia materia){
        datos.Agregar(materia);
    }
    public void Quitar(int pos){
        datos.Quitar(pos);
    }
    public void Reset(int posiciones){
        int hasta = posiciones;
        for (int i = 0; i < hasta; i++) {
            Quitar(0);
        }
    }
    public float Promedio(){
        ArrayList<Materia> Materias = datos.MateriasGuardadas();
        int creditos = 0;
        float total = 0;
        for(Materia materia : Materias){
            creditos = creditos + materia.getCreditos();
            total = total + (materia.getNota() * materia.getCreditos());
        }
        float Promedio = total / creditos;
        float PromRedondeado = Redondear(Promedio);
        return Promedio>=0 && Promedio<=5 ? PromRedondeado : 0;
        
    }
    public DefaultTableModel Materias(){
        ArrayList<Materia> Materias = datos.MateriasGuardadas();
        DefaultTableModel modelo = new DefaultTableModel();
        String[] columnas = {"#","Materia","Nota","Creditos","Quitar"};
        modelo.setColumnIdentifiers(columnas);
        String[] fila;
        int n=0;
        for(Materia materia : Materias){
            n=n+1;
            modelo.addRow(new Object[]{n,""+materia.getNMateria(),""+materia.getNota(),""+materia.getCreditos(),
            new JLabel(new ImageIcon(getClass().getResource("/IMG/quitar.png")))});
        }
        return modelo;
    }
    
    /*public DefaultTableModel Materias(){
        ArrayList<Materia> Materias = datos.MateriasGuardadas();
        DefaultTableModel modelo = new DefaultTableModel();
        String[] columnas = {"#","Materia","Nota","Creditos",""};
        modelo.setColumnIdentifiers(columnas);
        String[] fila;
        int n=0;
        for(Materia materia : Materias){
            fila = new String[columnas.length];
            n=n+1;
            fila[0] = ""+(n);
            fila[1] = materia.getNMateria();
            fila[2] = ""+materia.getNota();
            fila[3] = ""+materia.getCreditos();
            fila[4] = "QUITAR";
            modelo.addRow(fila);
        }
        return modelo;
    }*/
    
    private float Redondear(float num){
        int aux =(int) num;
        float aux2 = num - aux;
        float aux3 = (float) (aux2/0.1);
        int aux4 = (int) aux3;
        float aux5 = aux3 - aux4;
        if (aux5 >=0.5 ) {
            aux4 = aux4 + 1;
        }
        return (float) (aux + (aux4*0.1));
    }
}
