package LAB1; /**
 * Created by oliva on 27.02.2017.
 */
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileManger {

    public int err_newfile = 0; // признак успешного действия над файлом

                 //  private String dirNam = "C:\\Projects\\Hillel\\";

    public static boolean test(String testString)
    {

        Pattern p = Pattern.compile("(C{1}:\\\\([A-z]|[0-9]|\\s)+\\\\)");    // путь+файл (\w{1}:\\([A-z]|[0-9]|\s)+\.\w+)
        Matcher m = p.matcher(testString);
        return m.matches();
    }
  /*
    public String getdirName()
   {
        return dirNam;
    }

    public void setDIR_NAME(String dirName)
    {
        this.dirNam = dirNam;
    }
*/
    public void createFile(String DIR_NAME, String NEW_FILENAME)
    {

        String filenameLab1 = DIR_NAME + NEW_FILENAME;
        File file1 = new File(filenameLab1);
        System.out.println(file1.getPath());
        try {
            if (file1.createNewFile())
            {
                System.out.println("File created: " + file1.getAbsolutePath());

                FileWriter fr = null;
                BufferedWriter br = null;
                String dataWithNewLine = "Gruppa QA_10 labwork #1 ";

                fr = new FileWriter(file1);
                br = new BufferedWriter(fr);

                for (int i = 5; i > 0; i--)
                {
                    br.write(dataWithNewLine);
                }
                br.close();
                fr.close();
            } else {
                   // System.out.println("not create file");
                    err_newfile = 2;
                   }
            } catch (IOException ex)
            {
            Logger.getLogger(FileManger.class.getName())
                    .log(Level.SEVERE, null, ex);
            }
    }

    public void deleteFile(String DIR_NAME, String NEW_FILENAME)
    {

        String FILENAME_lab1 = DIR_NAME + NEW_FILENAME;
        File file1 = new File(FILENAME_lab1);

        if (file1.delete())
        {
            System.out.println("File deleted: " + file1.getAbsolutePath());
        } else {
                System.out.println("File not deleted");
               }
    }

    public void renameFile(String DIR_NAME, String NEW_FILENAME, String OLD_FILENAME)
    {

        final File oldFile = new File(DIR_NAME, OLD_FILENAME);
        final File newFile = new File(DIR_NAME, NEW_FILENAME);


        if (oldFile.exists())
        {
            if (oldFile.renameTo(newFile))
            {
               System.out.println("File renamed");
            } else {
                System.out.println("File not renamed");
                err_newfile = 1;
            }

        } else {
                System.out.println("File " + OLD_FILENAME + " does not exist. File not renamed");
                err_newfile = 1;
               }

    }



    public void findWord(String DIR_NAME, String NEW_FILENAME, String NEW_WORD)
    {
        final File newFile = new File(DIR_NAME, NEW_FILENAME);
        String nextLine= null;

        System.out.println("Name file:" + newFile);
        System.out.println("File contents:");

        try (BufferedReader br = new BufferedReader(new FileReader(newFile)))
        {
            while ((nextLine = br.readLine()) != null)
            {
                System.out.println(nextLine);

                if (nextLine.contains(NEW_WORD))
                {
                    System.out.println("the word is found");

                } else {
                        System.out.println("the word is not found");
                       }

            }

        } catch (IOException ex) {
            Logger.getLogger(FileManger.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }


    public void replaceWord(String DIR_NAME, String NEW_FILENAME, String OLD_WORD, String NEW_WORD)
    {
        final File newFile = new File(DIR_NAME, NEW_FILENAME);
        String nextLine;
        String nextLine1;

        System.out.println("Name file:" + newFile);
        System.out.println("File contents:");
        try (BufferedReader br = new BufferedReader(new FileReader(newFile))) {
            while ((nextLine = br.readLine()) != null)
            {
                System.out.println(nextLine);

                nextLine1 = nextLine.replace(OLD_WORD, NEW_WORD);

                System.out.println(nextLine1);

                int replace = (nextLine.length() - nextLine.replace(OLD_WORD, "").length()) / OLD_WORD.length();

               System.out.println("amount replacing = " + replace);
            }
        } catch (IOException ex) {
            Logger.getLogger(FileManger.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }
}

