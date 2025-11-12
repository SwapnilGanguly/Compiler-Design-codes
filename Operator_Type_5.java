import java.io.*;

public class Operator_Type_5 {
    public static void main(String args[]){
        Operator_Type_5 ob = new Operator_Type_5();
        String path = "D:\\Subha\\Compiler Design Lab Codes\\file_ref2.c";
        String line = "";

        try{
            BufferedReader br = new BufferedReader(new FileReader(path));
            while((line = br.readLine())!=null){
                ob.process(line);
            }
            br.close();
        }
        catch(Exception e){}
        
    }

    public void process(String line){
        String arr[] = line.split(" ");

        for(String s : arr){
            if(isArithmetic(s)){
                System.out.println(s+" - Arithmetic Operator");
            }
            else if(isRelational(s)){
                System.out.println(s+" - Relational Operator");
            }
            else if(isLogical(s)){
                System.out.println(s+" - Logical Operator");
            }
        }
    }

    public boolean isArithmetic(String s){
        String arithmetic[] = {"+", "-", "*", "/", "%"};

        for(String op : arithmetic){
            if(op.equals(s)){
                return true;
            }
        }
        return false;
    }

    public boolean isRelational(String s){
        String relational[] = {"==", "!=", "<", ">", "<=", ">="};

        for(String op : relational){
            if(op.equals(s)){
                return true;
            }
        }
        return false;
    }

    public boolean isLogical(String s){
        String logical[] = {"&&", "||", "!"};

        for(String op : logical){
            if(op.equals(s)){
                return true;
            }
        }
        return false;
    }
}
