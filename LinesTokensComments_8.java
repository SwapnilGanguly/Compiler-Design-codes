import java.io.*;
public class LinesTokensComments_8 {
    public static void main(String[] args) {
        String path = "D:\\Subha\\Compiler Design Lab Codes\\file_ref4.c";
        String line="";
        int lineCount = 0;
        int commentCount = 0;
        int tokenCount = 0;
        boolean multiLineComment = false;
        try{
            BufferedReader br = new BufferedReader(new FileReader(path));
            while((line=br.readLine())!=null){
                line = line.trim();

                lineCount ++;

                if(multiLineComment == true){
                    commentCount ++;
                    if(line.contains("*/"))
                        multiLineComment = false;
                    continue;
                }

                if(line.startsWith("//")){
                    commentCount ++;
                    tokenCount -= line.length();
                    continue;
                }
                else if(line.startsWith("/*")){
                    multiLineComment = true;
                    tokenCount -= line.split(" ").length;
                    continue;
                }

                tokenCount += line.split(" ").length + 1; // assuming every token is separated by a space & +1 coz of semicolon at the end
            }
            System.out.println("No. of lines: "+lineCount
                                +"\nNo. of tokens: "+tokenCount
                                +"\nNo. of comments: "+commentCount);
            br.close();
        }
        catch(Exception e){}
    }
}
