
package DAL;
import ENTITY.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Datos {
    
    public Datos(){
        FileWriter archivo;
        PrintWriter escritor=null;
        try{
            archivo = new FileWriter("datos.txt", true);
            escritor = new PrintWriter(archivo);
        }
        catch(IOException error){
            
        }finally{
            if(escritor!=null)
            {
                escritor.close();
            }
        }
    }
    public void Agregar(Materia materia){
        GuardarTxt(materia);
    }
    public void Quitar(int pos){
        ArrayList<Materia> Materias = getMaterias();
        Materias.remove(pos);
        ModifiacarTxt(Materias);
    }
    
    public ArrayList<Materia> MateriasGuardadas(){
        return getMaterias();
    }
    
    public void GuardarTxt(Materia materia)
    {
        FileWriter archivo;
        PrintWriter escritor=null;
        try{
            archivo = new FileWriter("datos.txt", true);
            escritor = new PrintWriter(archivo);
            escritor.println(materia.getNMateria()+";"+materia.getNota()+";"+materia.getCreditos());
        }
        catch(IOException error){
            
        }finally{
            if(escritor!=null)
            {
                escritor.close();
            }
        }
    }
    
    public void ModifiacarTxt(ArrayList<Materia> Materias)
    {
        FileWriter archivo;
        PrintWriter escritor=null;
        try{
            archivo = new FileWriter("datos.txt");
            escritor = new PrintWriter(archivo);
            for(Materia materia : Materias){
                escritor.println(materia.getNMateria()+";"+materia.getNota()+";"+materia.getCreditos());
            }
            
        }
        catch(IOException error){
            
        }finally{
            if(escritor!=null)
            {
                escritor.close();
            }
        }
    }
    
    public ArrayList<Materia> getMaterias(){
        File file = new File("datos.txt");
        try{
            FileReader lector = new FileReader(file);
            BufferedReader lectorLineas = new BufferedReader(lector);
            String linea;
            ArrayList<Materia> Materias = new ArrayList<>();
            Materia materia;
            String[] fila;
            while((linea = lectorLineas.readLine()) != null){
                fila = linea.split(";");
                materia = new Materia();
                materia.setNMateria(fila[0]);
                materia.setNota(Float.parseFloat(fila[1]));
                materia.setCreditos(Integer.parseInt(fila[2]));
                Materias.add(materia);
            }
            return Materias;
                    
        }catch(Exception error){}
        return null;
    }
    
}
