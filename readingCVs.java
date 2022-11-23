import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
public class readingCVs
{
    public static void main(String[] args) throws IOException  {
        String data1[];
        String currentLine1;
        ArrayList<String> colData=new ArrayList<String>();

        try{
            //this code is to read Data form File A and store all the work Id from the File A
            
            FileReader fr=new FileReader("C:\\Users\\USER\\Desktop\\A.txt");
            BufferedReader br= new BufferedReader(fr);
        
            while((currentLine1=br.readLine()) !=null)
            {
               data1=currentLine1.split(",");
               colData.add(data1[2]);
            }
          br.close();

          /*  the lower code is to match the work id and delete the information of the person 
          related to Work Id from the file B */

            String data[];
            String currentLine;
            String tempFile="temp.txt";
            File oldFile=new File("C:\\Users\\USER\\Desktop\\B.txt");
            File newFile=new File(tempFile);
            
            //to read file
            FileReader fr1=new FileReader("C:\\Users\\USER\\Desktop\\B.txt");
            BufferedReader br1= new BufferedReader(fr1);
           
            //to write in the new file
            FileWriter fw=new FileWriter(tempFile,true);
            BufferedWriter bw=new BufferedWriter(fw);
            PrintWriter pw=new PrintWriter(bw);

            while((currentLine=br1.readLine()) !=null)
            {
                data=currentLine.split(",");
                //if work Id is not matched then write in new file
                if(!colData.contains(data[2]))
                {
                   pw.println(currentLine);
                   
                }
                else 
                    System.out.println("Work Id = "+data[2]);

            }
            br1.close();
            pw.flush();
            pw.close();
            fr1.close();
            bw.close();
            fw.close();
            // to delete the old file
            oldFile.delete();
            File dump=new File("C:\\Users\\USER\\Desktop\\B.txt");
            //creating new file with the same name and location
            newFile.renameTo(dump);
        }
        
        catch(Exception e){
            System.out.println(e);
        }
        
    }
}