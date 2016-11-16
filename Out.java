import java.awt.Color;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.*;

/**
 * Created by Pierre on 16/11/2016.
 */
public class Out implements Computational {

    private Memory memory;
    private String courteSyntaxe=".";
    private Color couleur=new Color(0, 255, 0);
    private BufferedWriter fichierOut=null;

    public Out(Memory memory){
        this.memory = memory;
    }

    public Out(Memory memory, String fichier){
        this.memory = memory;
        try{
            fichierOut = new BufferedWriter(new FileWriter(fichier));
        }
        catch(FileNotFoundException exc){
                System.out.println("Erreur d'ouverture");
        }
         catch(IOException e){
                System.out.println("Erreur d'ouverture");
        }
    }

    public void execute(){
        try{
        if(fichierOut!=null){
            fichierOut.write(memory.getStringMemory());
        }
        else
            System.out.println(memory);
        }
        catch(IOException e){
            System.out.println("Erreur fichier Out");
        }
    }

    public void rewrite(){
        System.out.print(courteSyntaxe);
    }

    public Color translate(){
        return couleur;
    }

    public void Check(){}

}
