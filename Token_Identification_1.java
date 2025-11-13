import java.io.BufferedReader;
import java.io.FileReader;

public class Token_Identification_1 {
    public static void main(String[] args) {
        Token_Identification_1 ob = new Token_Identification_1();
        String path = "D:\\Subha\\Compiler Design Lab Codes\\file_ref.c";
        String line = "";
        int keywordsCount = 0;
        int identifiersCount = 0;
        int operatorsCount = 0;
        int numbersCount = 0;
        int specialSymbolsCount = 0;
        try{
            BufferedReader br = new BufferedReader(new FileReader(path));
            while((line = br.readLine())!=null){
                line = line.trim();
                
                String arr[] = line.split(" ");
                for(int i=0; i<arr.length; i++){
                    if(ob.isKeyword(arr[i]))
                        keywordsCount ++;
                    else if(ob.isIdentifier(arr[i]))
                        identifiersCount ++;
                    else if(ob.isOperator(arr[i]))
                        operatorsCount ++;
                    else if(ob.isNumber(arr[i]))
                        numbersCount ++;
                    else if(ob.isSpecialSymbol(arr[i]))
                        specialSymbolsCount ++;
                    
                }
            }
            br.close();
            
            System.out.println("Keywords: "+keywordsCount);
            System.out.println("Identifiers: "+identifiersCount);
            System.out.println("Operators: "+operatorsCount);
            System.out.println("Numbers: "+numbersCount);
            System.out.println("Special symbols: "+specialSymbolsCount);
        }
        catch(Exception e){}
    }

    public boolean isKeyword(String s){
        String keywords[] = {"printf", "scanf", "int", "float", "char", "for", "while", "if", "else", "break"};

        for(int i=0; i<keywords.length; i++){
            if(keywords[i].equals(s)){
                System.out.println("Keyword: "+s);
                return true;
            }
                
        }
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
        System.out.println("Identifier: "+s);
        return true;
    }

    public boolean isOperator(String s){
        String operators[] = {"+", "-", "*", "/", "%", "=", "==", "!=", ">", "<", ">=", "<=", "&&", "||", "!"
};
        for(int i=0; i<operators.length; i++){
            if(operators[i].equals(s)){
                System.out.println("Operator: "+s);
                return true;
            }
                
        }
        return false;
    }

    public boolean isNumber(String s){
        int count = 0;
        for(int i=0; i<s.length(); i++){
            if(Character.isDigit(s.charAt(i)) == false){
                return false;
            }
            else if(s.charAt(i) == '.')
                count ++;
        }
        if(count > 1)
            return false;
        System.out.println("Number: "+s);
        return true;
    }

    public boolean isSpecialSymbol(String s){
        if(isKeyword(s) == true || isOperator(s) == true || isNumber(s) == true || isIdentifier(s)==true)
            return false;
        return true;
    }
}


