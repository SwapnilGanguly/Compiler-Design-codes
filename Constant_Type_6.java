import java.io.*;

public class Constant_Type_6 {
    public static void main(String args[]){
        Constant_Type_6 ob = new Constant_Type_6();

        String path = "D:\\Subha\\Compiler Design Lab Codes\\file_ref3.c";
        String line = "";

        try{
            BufferedReader br = new BufferedReader(new FileReader(path));
            if((line = br.readLine())!=null){
                String arr[] = line.split(" ");
                for(String s : arr){
                    if(ob.isNumeric(s)){
                    }
                    else if(ob.isCharacter(s)){
                    }
                    else{}
                }
            }
            br.close();
        }
        catch(Exception e){}
    }


    public boolean isNumeric(String s){
        if(s.charAt(s.length()-1) == ';')
            s = s.substring(0, s.length()-1);
        int c = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '.')
                c ++;
            else if(Character.isDigit(s.charAt(i)) == false)
                return false;
        }
        if(c == 1)
            System.out.println(s+" - Float");
        else if(c == 0)
            System.out.println(s+" - Integer");
        
        return true;
    }

    public boolean isCharacter(String s){
        if(s.charAt(s.length()-1) == ';')
            s = s.substring(0, s.length()-1);
        if(s.charAt(0) == '\'' && s.charAt(s.length()-1) == '\''){
            System.out.println(s+" - Character Constant");
            return true;
        }
        return false;
    }

}
