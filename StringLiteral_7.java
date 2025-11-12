import java.io.*;

public class StringLiteral_7 {
    public static void main(String args[]){
        StringLiteral_7 ob = new StringLiteral_7();

        String path = "D:\\Subha\\Compiler Design Lab Codes\\file_ref.c";
        String line = "";
        try{
            BufferedReader br = new BufferedReader(new FileReader(path));
            while((line=br.readLine())!=null){
                ob.identifyString(line);
            }
            br.close();
        }
        catch(Exception e){}
    }    

    public void identifyString(String line){
        String literal = "";
        int count = 0;
        for(int i=0; i<line.length(); i++){
            if(line.charAt(i) == '"')
                count ++;
            if(count%2 == 1){
                literal += line.charAt(i);
            }
            else{
                literal += "\"";
                if(literal.length()>2) System.out.println(literal);
                literal = "";
            }
        }
        
    }
}
