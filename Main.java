package LAB1;

import java.io.File;
import java.util.Scanner;

/**
 * Created by oliva on 27.02.2017.
 */
public  class Main {

      public static void main(String[] args) {

          System.out.println("1. Create file");
          System.out.println("2. Delete file");
          System.out.println("3. Rename file");
          System.out.println("4. Find word");
          System.out.println("5. Replace word");
          System.out.println("0. Exit");

          String pathlab = "";
          FileManger dirFile = new FileManger();

          //  String ud =System.getProperty("user.dir");
          String os = System.getProperty("os.name").toLowerCase();
          System.out.println("This is " + os);
          String sep = System.getProperty("file.separator");
          System.out.println("Please enter path ( C:" + sep+ "name folder" + sep+") ");
          Scanner inp = new Scanner(System.in);
          pathlab = inp.nextLine();
          System.out.println(dirFile.test(pathlab));
           //  String dirName = dirFile.getdirName();
          String dirName = pathlab;

          File dir = new File(dirName.replace("'\'","'\\'"));


          if (dirFile.test(pathlab) == true) // проверка пути по шаблону исп.регулярное выражение
          {
              if (dir.exists() == false) {
                  boolean created = dir.mkdir();
                  if (created)
                      System.out.println("Directory created successfully");
              }
              String newFilename = "";
              String oldFilename = "";
              String old1Filename = "";
              String oldWord = "";
              String newWord = "";

              int exit = 1;

              while (exit != 0) {
                  System.out.println("Choose the menu item");
                  FileManger fileManger = new FileManger();
                  Scanner in = new Scanner(System.in);
                  int vibor = in.nextInt();

                  switch (vibor) {
                      case 1:
                              System.out.println("Create file:");
                              System.out.println("=====================");
                              System.out.println("Please enter filename:");
                              oldFilename = in.next();
                              fileManger.createFile(dirName, oldFilename);
                              break;
                      case 2:
                          if (fileManger.err_newfile==0)
                          {
                              System.out.println("Delete file:");
                              System.out.println("=====================");
                              System.out.println("Please enter filename:");
                              oldFilename = in.next();
                              fileManger.deleteFile(dirName, oldFilename);
                          }
                               else {
                                     exit = 0;
                                    }
                               break;
                      case 3:
                          if (fileManger.err_newfile==0)
                          {
                              System.out.println("Rename file:");
                              System.out.println("=====================");
                              System.out.println("Old filename:");
                              old1Filename = in.next();
                              System.out.println("New filename:");
                              newFilename = in.next();
                              fileManger.renameFile(dirName, newFilename, old1Filename);
                          }
                                else {
                                       exit = 0;
                                     }

                               break;
                       case 4:
                           if (fileManger.err_newfile==0)
                           {
                               System.out.println("Find word:");
                               System.out.println("=====================");
                               System.out.println("Enter search word:");
                               oldWord = in.next();
                               fileManger.findWord(dirName, newFilename, oldWord);
                           }
                                else {
                                      exit = 0;
                                     }
                                break;
                        case 5:
                            if (fileManger.err_newfile==0)
                            {
                               System.out.println("Replace word:");
                               System.out.println("=====================");
                               System.out.println("Enter your search word in the replacement string :");
                               oldWord = in.next();
                               System.out.println("Enter word to replace:");
                               newWord = in.next();
                               fileManger.replaceWord(dirName, newFilename, oldWord, newWord);
                           }
                                else {
                                      exit = 0;
                                     }
                                 break;
                         default:
                                exit = 0;
                                break;
                  }

                }

      } else { System.out.println("Failed to create directory"); }
    }

}
