package persistencia;

import logica.Joven;
import logica.Nomina;
import logica.Tarjeta;
import logica.Visa;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class LecturaEscritura {
    private BufferedReader reader;
    private BufferedWriter writer;
    private String filename;
    private List<Tarjeta> list;
    
    public LecturaEscritura(String nombreArchivo){
        this.filename = nombreArchivo;
        list= new ArrayList<>();
    }
    
    public List<Tarjeta> getList(){
        return list;
    }
    
    public void setFileName(String filename){
        this.filename = filename;
    }
        
    public void leerTarjetas(){
        //ArrayList<Tarjeta> list = new ArrayList();
        try{
            //reader = new BufferedReader(new FileReader(new File("archivos/Enero.txt")));
            reader = new BufferedReader(new FileReader(Paths.get("archivos", this.filename + ".txt").toFile()));
            
            String line = reader.readLine();
            while(line != null){
                
                String[] str = line.split(";");
                switch (str[2]) {
                    case "Joven" -> list.add(new Joven(str[0], Double.parseDouble(str[1]), this.filename));
                    case "Nomina" -> list.add(new Nomina(str[0], Double.parseDouble(str[1]), this.filename));
                    case "Visa" -> list.add(new Visa(str[0], Double.parseDouble(str[1]), this.filename));
                    default -> {
                    }
                }
                
                line = reader.readLine();                
            }
            reader.close();
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
public void escribirTarjetas(List<Tarjeta> tarjetas){
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File("archivos/reporte.txt")))) {
        for (Tarjeta tarjeta : tarjetas) {
            writer.write(tarjeta.toString() + "\n");
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}
}
