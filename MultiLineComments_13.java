import java.io.*;
public class MultiLineComments_13 {
    public static void main(String[] args) {
        String path = "D:\\Subha\\Compiler Design Lab Codes\\file_ref4.c";
        String line = "";

        boolean multiLineComment = false;
        int commentCount = 0;

        try{
            BufferedReader br = new BufferedReader(new FileReader(path));
            while((line=br.readLine())!=null){
                line = line.trim();
                
                if(multiLineComment == true){
                    System.out.println(line);
                    commentCount ++;
                    if(line.contains("*/"))
                        multiLineComment = false;
                    continue;
                }

                if(line.startsWith("/*")){
                    System.out.println(line);
                    multiLineComment = true;
                    continue;
                }
            }
            if(commentCount == 0)
                System.out.println("No multi-line comments found.");
            else 
                System.out.println("Number of multi-line comments = "+commentCount);

            br.close();
        }
        catch(Exception e){}
    }
}
