import java.io.*;
public class LexicalErrorDetection_10 {
    public static void main(String[] args) {
        LexicalErrorDetection_10 ob = new LexicalErrorDetection_10();
        String path = "D:\\Subha\\Compiler Design Lab Codes\\file_ref6.c";
        String line = "";

        boolean multiLineComment = false;

        int lineCount = 0;
        int commentError = 0;

        try{
            BufferedReader br = new BufferedReader(new FileReader(path));
            while((line = br.readLine())!=null){

                lineCount ++; 

                if(line == " " || line == "\n")
                    continue;

                if(multiLineComment == true){
                    if(line.contains("*/"))
                        multiLineComment = false;
                    continue;
                }

                if(line.startsWith("/*")){
                    multiLineComment = true;
                    commentError = lineCount; 
                    continue;
                }

                if(ob.unclosedString(line) == false){
                    System.out.println("Unclosed String Literal at Line : "+lineCount);
                }

                if(ob.incorrectIdentifier(line) == false){
                    System.out.println("Incorrect identifier at Line : "+lineCount);
                }
                
            }

            
        }
        catch(Exception e){e.printStackTrace();}
        if(multiLineComment == true)
            System.out.println("Unclosed Comment at: "+commentError);
    }

    public boolean unclosedString(String line){
        int count = 0;
        for(int i=0; i<line.length(); i++){
            if(line.charAt(i) == '"')
                count ++;
        }
        if(count % 2 == 1)
            return false;
        return true;
    }

    public boolean incorrectIdentifier(String line){
        String arr[] = line.split(" ");
        for(String s : arr){
            if(s.isEmpty())
                continue;

            for(int i=0; i<s.length(); i++){
                if(Character.isLetterOrDigit(s.charAt(i)) == false && s.charAt(i)!='_'){
                    System.out.println(s);
                    return false;
                }
            }
            if(Character.isDigit(s.charAt(0)) == true){
                System.out.println(s);
                return false;
            }
        }
        return true;
    }
}

