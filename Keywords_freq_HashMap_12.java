import java.util.*;
import java.io.*;
public class Keywords_freq_HashMap_12 {
    public static void main(String args[]){
        Keywords_freq_HashMap_12 ob = new Keywords_freq_HashMap_12();
        String path = "D:\\Subha\\Compiler Design Lab Codes\\file_ref5.c";
        String line = "";
        HashMap<String, Integer> hmap = new HashMap<>();

        try{
            BufferedReader br = new BufferedReader(new FileReader(path));
            while((line=br.readLine())!=null){
                String arr[] = line.split(" ");
                for(int i=0; i<arr.length; i++){
                    
                    if(ob.isKeyword(arr[i]) == false)
                        continue;

                    if(hmap.containsKey(arr[i]) == false)
                        hmap.put(arr[i], 1);
                    else{
                        hmap.put(arr[i], hmap.get(arr[i])+1);
                    }
                }
            }
            br.close();
            
            for(Map.Entry<String, Integer> entry : hmap.entrySet()){
                System.out.println(entry.getKey()+" : "+entry.getValue());
            }
        }
        catch(Exception e){}
    }

    public boolean isKeyword(String s){
        String keywords[] = {
        "auto", "break", "case", "char", "const", "continue", "default",
        "do", "double", "else", "enum", "extern", "float", "for", "goto",
        "if", "inline", "int", "long", "register", "restrict", "return",
        "short", "signed", "sizeof", "static", "struct", "switch", "typedef",
        "union", "unsigned", "void", "volatile", "while", "_Alignas",
        "_Alignof", "_Atomic", "_Bool", "_Complex", "_Generic", "_Imaginary",
        "_Noreturn", "_Static_assert", "_Thread_local"};

        for(int i=0; i<keywords.length; i++){
            if(keywords[i].equals(s))
                return true;
        }
        return false;
    }
}
