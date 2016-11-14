import java.io.FileReader;
import java.io.IOException;


/**
 * Created by user on 12/10/2016.
 * @author Pierre Bonny
 * @author Marion Campora
 * @author Pierre Fournel
 * @author Thibault Larzabal
 * Classe excecutable.
 */

public class Bfck {

    public static void main(String[] args) throws IOException {
        
        //Initialisation des objets des autres classes
        int nbArgs=args.length;
        int i=0;

        Memory memory = new Memory();
        Computational computational = new Computational(memory);
        Output output = new Output(memory);
        Interpreter interpreter = new Interpreter(computational);
        Reader reader=new Reader(interpreter,output);
        boolean sansOption=true;

        while(i!=nbArgs-1){
        	if(args[i].equals("--rewrite")){
        		reader.rewrite(args[nbArgs-1]);
                sansOption=false;
        	}
        	else if (args[i].equals("-translate")){
                    Picture picture = new Picture();
                    FileReader file = new FileReader(args[nbArgs-1]);
                    picture.translate(file);
                    sansOption=false;
                }
            else if (args[i].equals("-i") || args[i].equals("-o")){
                
                reader.read(args[nbArgs-1]);
                sansOption=false;
            }
            i++;
        }
        if (sansOption){    
            reader.read(args[nbArgs-1]);
        }       
    }       
}
