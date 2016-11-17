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

public class Bfcketa {

    public static void main(String[] args) throws IOException {

        //Initialisation des objets des autres classes
        int nbArgs=args.length;
        int i=0;



        Memory memory = new Memory();
        Computationaleta computational = new Computationaleta(memory);
        Jump jump=new Jump(computational);
        Back back=new Back(computational,jump);
        Check check = new Check();
        Output output = new Output(memory);
        Interpretereta interpreter = new Interpreter(computational,back,output);

        Reader reader=new Reader(interpreter,output);
        Translatetoimage translatetoimage = new Translatetoimage();
        Translatetointruct translatetointruct = new Translatetointruct();
        String fichierIn=null;
        String fichierOut=null;

        check.read(args[nbArgs-1]);
        if(check.getCount() != 0){
            System.exit(4);
        }

        while(i!=nbArgs-1){

            if (args[i].equals("--check")){
                System.exit(0);
            }
            if(args[i].equals("--rewrite")){
                if (args[nbArgs -1].contains("BMP")||args[nbArgs -1].contains("bmp")){
                    translatetointruct.rewriteImage(args[nbArgs - 1]);
                    System.exit(0);
                }
                else{
                    reader.rewrite(args[nbArgs-1]);
                    System.exit(0);
                }

            }
            else if (args[i].equals("--translate")){
                FileReader file = new FileReader(args[nbArgs-1]);
                translatetoimage.translate(file);
                System.exit(0);
            }
            else if(args[i].equals("-i")){
                i++;
                fichierIn=args[i];
            }
            else if(args[i].equals("-o")){
                i++;
                fichierOut=args[i];
            }


            i++;
        }
        if (args[nbArgs -1].contains("BMP")||args[nbArgs -1].contains("bmp")){
            interpreter.interpreteImg(args[nbArgs - 1],fichierIn,fichierOut);
        }
        else {
            reader.read(args[nbArgs - 1], fichierIn, fichierOut);
        }

    }
}