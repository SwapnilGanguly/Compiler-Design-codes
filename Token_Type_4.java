import java.io.*;

public class Token_Type_4 {
    public static void main(String args[]){
        Token_Type_4 obj = new Token_Type_4();
        String path = "D:\\Subha\\Compiler Design Lab Codes\\file_ref.c";
        String line = ""; 
        try{
            BufferedReader br = new BufferedReader(new FileReader(path));
            while((line = br.readLine())!=null){
                obj.check(line);
            }
            br.close();
        }
        catch(Exception e){

        }
    }

    public void check(String line){
        String arr[] = line.split(" ");

        for(String token : arr){

            if(token.charAt(token.length()-1) == ';' || token.charAt(token.length()-1) == ',')
                token = token.substring(0, token.length()-1);

            if(isKeyword(token) == true)
                System.out.println(token + " - Keyword");
            else if(isStringConstant(token) == true)
                System.out.println(token + " - String Constant");
            else if(isNumericConstant(token) == true)
                System.out.println(token + " - Numeric Constant");
            else if(isIdentifier(token) == true)
                System.out.println(token + " - Identifier");
            else{}
            
        }
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

    public boolean isNumericConstant(String s){
        for(int i=0; i<s.length(); i++){
            if(Character.isDigit(s.charAt(i)) == false){
                return false;
            }
        }
        return true;
    }

    public boolean isStringConstant(String s){
        if(s.charAt(0) == '"' && s.charAt(s.length()-1) == '"')
            return true;
        return false;
    }

    public boolean isIdentifier(String s){
        if(isKeyword(s) == true)
            return false;
        if(Character.isDigit(s.charAt(0)) == true)
            return false;
        for(int i=0; i<s.length(); i++){
            if(Character.isLetterOrDigit(s.charAt(i)) == false && s.charAt(i)!='_')
                return false;
        }
        return true;
    }
}
