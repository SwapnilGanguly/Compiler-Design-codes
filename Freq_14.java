import java.io.*;
public class Freq_14 {
    public static void main(String[] args) {
        String path = "D:\\Subha\\Compiler Design Lab Codes\\file_ref4.c";
        String line = "";
        int freq[] = new int[256];
        try{
            BufferedReader br = new BufferedReader(new FileReader(path));
            while((line = br.readLine())!=null){
                System.out.println(line);
                for(int i=0; i<line.length(); i++){

                    if(line.charAt(i) == ' ')
                        continue;
                    freq[(int)line.charAt(i)] += 1;
                }
            }
            br.close();
        }
        catch(Exception e){}

        for(int i=0; i<256; i++){
            if(freq[i] != 0)
                System.out.println((char)i+" : "+freq[i]);
        }
    }
}
