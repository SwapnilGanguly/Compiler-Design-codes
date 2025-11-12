import java.io.*;

public class PreprocessorDirectives_11 {
    public static void main(String[] args) {
        String path = "D:\\Subha\\Compiler Design Lab Codes\\file_ref4.c";
        String line = "";
        try{
            BufferedReader br = new BufferedReader(new FileReader(path));
            while((line=br.readLine())!=null){
                if(line.charAt(0) == '#')
                    System.out.println(line);
            }
            br.close();
        }
        catch(Exception e){}
    }    
}
