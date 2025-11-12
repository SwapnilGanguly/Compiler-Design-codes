import java.io.*;
public class Tokens_3{
    public static void main(String args[]){
        Tokens_3 obj = new Tokens_3();

        String path = "D:\\Subha\\Compiler Design Lab Codes\\file_ref.c";
        String line = "";
        try{
            BufferedReader br = new BufferedReader(new FileReader(path));
            while((line=br.readLine())!=null){
                obj.printTokens(line);
            }
            br.close();
        }
        catch(Exception e){
        }
    }

    public void printTokens(String line){
        String arr[] = line.split(" ");
        
        int i=0;
        
        for(; i<arr.length-1; i++){
            System.out.println(arr[i]);
        }
        if(arr[i].charAt(arr[i].length()-1) == ';'){
            for(int j=0; j<arr[i].length()-1; j++)
                System.out.print(arr[i].charAt(j));
            System.out.println("\n"+arr[i].charAt(arr[i].length()-1));
        }
    }
}