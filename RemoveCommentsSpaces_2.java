import java.io.*;
import java.util.StringTokenizer;
public class RemoveCommentsSpaces_2 {
    public static void main(String[] args) {
        String path = "D:\\Subha\\Compiler Design Lab Codes\\file_ref4.c";
        String line = "";

        boolean multiLineComment = false;
       
        try{
            BufferedReader br = new BufferedReader(new FileReader(path));
            FileWriter writer = new FileWriter("output.c");
            while((line=br.readLine())!=null){
                line = line.trim();
                
                if(multiLineComment == true){
                    if(line.contains("*/"))
                        multiLineComment = false;
                    continue;
                }

                if(line.startsWith("//")){
                    continue;
                }
                else if(line.startsWith("/*")){
                    multiLineComment = true;
                    continue;
                }

                StringTokenizer st = new StringTokenizer(line, " ");
                while(st.hasMoreTokens()){
                    writer.write(st.nextToken().trim()+" ");
                }
                writer.write("\n");
            }
            br.close();
            writer.close();
        }
        catch(Exception e){}
    }
}
