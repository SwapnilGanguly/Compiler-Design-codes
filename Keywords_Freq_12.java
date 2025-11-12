import java.io.*;
public class Keywords_Freq_12 {
    public static void main(String args[]){
        String path = "D:\\Subha\\Compiler Design Lab Codes\\file_ref5.c";
        String line = "";
        int count[] = new int[4];
        try{
            BufferedReader br = new BufferedReader(new FileReader(path));
            while((line = br.readLine())!=null){
                String arr[] = line.split(" ");
                for(String token : arr){
                    if(token.equals("int"))
                        count[0] ++;
                    else if(token.equals("return"))
                        count[1] ++;
                    if(token.equals("if"))
                        count[2] ++;
                    if(token.equals("while"))
                        count[3] ++;
                }
            }
            br.close();
            System.out.println("int : "+count[0]
                                +"\nreturn : "+count[1]
                                +"\nif : "+count[2]
                                +"\nwhile : "+count[3]);
        }
        catch(Exception e){}
    }
}
