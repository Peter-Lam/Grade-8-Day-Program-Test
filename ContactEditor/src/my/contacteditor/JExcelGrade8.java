/*
Grade 8 Sorting Algorithm
Courtesy of Grads 2016 'The Best Group'
 */
package my.contacteditor;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.lang.*;


import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import jxl.read.biff.BiffException;

import jxl.write.*;

public class JExcelGrade8
{
   public static void main(String args) 
      throws BiffException, IOException, WriteException
    {
      //Importing Spreadsheet
      
      Workbook wrk1 =  Workbook.getWorkbook(new File(new File(".").getCanonicalPath(),"/TestResponses.xls"));
      Sheet sheet = wrk1.getSheet(0);
      
      int numberStudents = 0;
      int numberColumns = 0;
      
      for (int i=0; i>-1; i++)
      {
        try
        {
            Cell cell1 = sheet.getCell(1, i);
            numberStudents = numberStudents +1;
            }
        catch(ArrayIndexOutOfBoundsException e)
        {
            i = -2;
            numberStudents--;
        }
        finally
        {
            
        }
      }
      System.out.println(numberStudents);
      
      for (int i=0; i>-1; i++)
      {
        try
        {
            Cell cell1 = sheet.getCell(i, 1);
            numberColumns = numberColumns +1;
            }
        catch(ArrayIndexOutOfBoundsException e)
        {
            i = -2;
            numberColumns--;
        }
        finally
        {
            
        }
      }
      System.out.println(numberColumns);
      
      String[][] responses = new String[numberColumns][numberStudents];
    for (int i=0; i<numberStudents+1; i++)
    {
        
        for(int j=0; j<numberColumns+3; j++){
            try{
                Cell cell1 = sheet.getCell(j, i);
                responses[j][i]=(cell1.getContents());
                if("".equals(responses[j][i])){
                    responses[j][i] = "--";
                }
                System.out.print(responses[j][i] + ", ");
                System.out.print(j+", "+i+", ");
                
                    
                
            }catch(ArrayIndexOutOfBoundsException e){
                
            }finally{
                
            }
                
                
        }  
        System.out.println("\n\nNew Student\n"); 
    
    }
    
    
    String[][] reversedResponses = new String[numberStudents][numberColumns];
    //Shuffler
    for (int i = 0; i < responses.length; i++) {
            for (int j = 0; j < responses[i].length; j++) {   
                
                   reversedResponses[j][i] = responses[i][j];
                             
                System.out.print(reversedResponses[j][i] + ", ");
            }
            System.out.print("\n");
        }
    try{
    Collections.shuffle(Arrays.asList(reversedResponses));
    }catch(NullPointerException e){
        
    }finally{
        
    }
//BubbleSort    
for(int s = 0; s < reversedResponses.length; s++)
        {
            if(reversedResponses[s][5]== null)
            {
                System.out.println("Hello");
            }
            else
            {
                switch (reversedResponses[s][5]) 
                {
                case "Unsure": //if a[s][0] is Unsure switch it to 1
                    reversedResponses[s][5] = "1";
                    break;
                case "Yes": //if a[s][0] is Yes switch it to 1
                    reversedResponses[s][5] = "2";
                    break;
                case "No": //if a[s][0] is No switch it to 1
                    reversedResponses[s][5] = "3";
                    break;
                }
            }     
        }
Arrays.sort(reversedResponses,(String[] r1, String[] r2) -> String.valueOf(r1[4]).compareTo(r2[4]));

for(int s = 0; s < reversedResponses.length; s++)
        {
            if(reversedResponses[s][5]== null)
            {
                
            }
            else
            {
                switch (reversedResponses[s][5]) 
                {
                case "1":
                    reversedResponses[s][5] = "Unsure"; //if a[s][0] is 1 switch it to Unsure
                    break;
                case "2":
                    reversedResponses[s][5] = "Yes"; //if a[s][0] is 2 switch it to Yes
                    break;
                case "3":
                    reversedResponses[s][5] = "No"; //if a[s][0] is 3 switch it to No
                    break;
                }
            }
        }
    
    
    
    if (responses.length > 0) {
            for (int i = 0; i < responses[0].length; i++) {
                for (int j = 0; j < responses.length; j++) {
                    
                    responses[j][i] = reversedResponses[i][j];
                    if(responses[j][i] == null){
                        System.out.println(j +", " + i);
                        responses[j][i] = "Why is this null";
                    }
                   System.out.print(responses[j][i] + ", ");
                }
                System.out.print("\n");
                System.out.println("Next Student");
            }
            
        }
    
    System.out.println(responses[0].length);
    System.out.println(responses.length);
    
    String[][] choices = new String[3][numberStudents];
    
  
    
    
    
    

//Sorting
    int[] BusinessCap = new int[3];
    int[] ArtCap = new int[3];
    int[] DramaCap = new int[3];
    int[] DanceCap = new int[3];
    int[] MusicCap = new int[3];
    int[] ComSciCap = new int[3];
    int[] TechCap = new int[3];
    
    int[] BusinessAvailability = new int [numberStudents];
    int[] ArtAvailability = new int [numberStudents];
    int[] DramaAvailability = new int [numberStudents];
    int[] DanceAvailability = new int [numberStudents];
    int[] MusicAvailability = new int [numberStudents];
    int[] ComSciAvailability = new int [numberStudents];
    int[] TechAvailability = new int [numberStudents];
    
    for (int j = 0; j < numberStudents; j++)
    {
        BusinessAvailability[j] = 0;
        ArtAvailability[j] = 0;
        DramaAvailability[j] = 0;
        DanceAvailability[j] = 0;
        MusicAvailability[j] = 0;
        ComSciAvailability[j] = 0;
        TechAvailability[j] = 0;
    }
    
    int MaxBusinessCap = 30;
    int MaxArtCap = 30;
    int MaxDramaCap = 30;
    int MaxDanceCap = 30;
    int MaxMusicCap = 30;
    int MaxComSciCap = 30;
    int MaxTechCap = 30;
    
    for (int i = 0; i < 3; i++)
    {
        System.out.println("\n");
        for (int j = 1; j <= numberStudents-1; j++)
        {
            //First Choice
            //System.out.println(responses[i+16][j]);
            if ("Business Technology".equals(responses[i + 16][j]))
            {
                //Ensures one student cannot get the same class in two sessions
                if (BusinessAvailability[j] == 0)
                {
                    if (BusinessCap[i] < MaxBusinessCap)
                    {
                        choices[i][j] = responses[i + 16][j];
                        BusinessCap[i]++;
                        BusinessAvailability[j] = 1;
                    }
                    //Second Choice
                    else if (BusinessCap[i] == MaxBusinessCap)
                    {
                        SecondChoice secondchoice = new SecondChoice();
                        choices[i][j] = secondchoice.second(responses[i + 17][j], BusinessCap[i], ArtCap[i], DramaCap[i], DanceCap[i], MusicCap[i], ComSciCap[i], TechCap[i], MaxBusinessCap, MaxArtCap, MaxDramaCap, MaxDanceCap, MaxMusicCap, MaxComSciCap, MaxTechCap, BusinessAvailability[j], ArtAvailability[j], DramaAvailability[j], DanceAvailability[j], MusicAvailability[j], ComSciAvailability[j], TechAvailability[j]);
                        //Third Choice
                        if ("".equals(choices[i][j]))
                        {
                            ThirdChoice thirdchoice = new ThirdChoice();
                            choices[i][j] = thirdchoice.third(responses[i + 18][j], BusinessCap[i], ArtCap[i], DramaCap[i], DanceCap[i], MusicCap[i], ComSciCap[i], TechCap[i], MaxBusinessCap, MaxArtCap, MaxDramaCap, MaxDanceCap, MaxMusicCap, MaxComSciCap, MaxTechCap, BusinessAvailability[j], ArtAvailability[j], DramaAvailability[j], DanceAvailability[j], MusicAvailability[j], ComSciAvailability[j], TechAvailability[j]);
                            //Fourth Choice
                            if ("".equals(choices[i][j]))
                            {
                                FourthChoice fourthchoice = new FourthChoice();
                                choices[i][j] = fourthchoice.fourth(responses[i + 19][j], BusinessCap[i], ArtCap[i], DramaCap[i], DanceCap[i], MusicCap[i], ComSciCap[i], TechCap[i], MaxBusinessCap, MaxArtCap, MaxDramaCap, MaxDanceCap, MaxMusicCap, MaxComSciCap, MaxTechCap, BusinessAvailability[j], ArtAvailability[j], DramaAvailability[j], DanceAvailability[j], MusicAvailability[j], ComSciAvailability[j], TechAvailability[j]);
                                //Fifth Choice
                                if ("".equals(choices[i][j]))
                                {
                                    FifthChoice fifthchoice = new FifthChoice();
                                    choices[i][j] = fifthchoice.fifth(responses[i + 20][j], BusinessCap[i], ArtCap[i], DramaCap[i], DanceCap[i], MusicCap[i], ComSciCap[i], TechCap[i], MaxBusinessCap, MaxArtCap, MaxDramaCap, MaxDanceCap, MaxMusicCap, MaxComSciCap, MaxTechCap, BusinessAvailability[j], ArtAvailability[j], DramaAvailability[j], DanceAvailability[j], MusicAvailability[j], ComSciAvailability[j], TechAvailability[j]);
                                    //Sixth Choice
                                    if ("".equals(choices[i][j]))
                                    {
                                        SixthChoice sixthchoice = new SixthChoice();
                                        choices[i][j] = sixthchoice.sixth(responses[i + 21][j], BusinessCap[i], ArtCap[i], DramaCap[i], DanceCap[i], MusicCap[i], ComSciCap[i], TechCap[i], MaxBusinessCap, MaxArtCap, MaxDramaCap, MaxDanceCap, MaxMusicCap, MaxComSciCap, MaxTechCap, BusinessAvailability[j], ArtAvailability[j], DramaAvailability[j], DanceAvailability[j], MusicAvailability[j], ComSciAvailability[j], TechAvailability[j]);
                                        //Seventh Choice
                                        if ("".equals(choices[i][j]))
                                        {
                                            SeventhChoice seventhchoice = new SeventhChoice();
                                            choices[i][j] = seventhchoice.seventh(responses[i + 22][j], BusinessCap[i], ArtCap[i], DramaCap[i], DanceCap[i], MusicCap[i], ComSciCap[i], TechCap[i], MaxBusinessCap, MaxArtCap, MaxDramaCap, MaxDanceCap, MaxMusicCap, MaxComSciCap, MaxTechCap, BusinessAvailability[j], ArtAvailability[j], DramaAvailability[j], DanceAvailability[j], MusicAvailability[j], ComSciAvailability[j], TechAvailability[j]);
                                        }
                                    }
                                }
                            }
                        }
                        //Adds to caps
                        if ("Business Technology".equals(choices[i][j]))
                        {
                            BusinessCap[i]++;
                            BusinessAvailability[j] = 1;
                        }
                        else if ("Visual Arts".equals(choices[i][j]))
                        {
                            ArtCap[i]++;
                            ArtAvailability[j] = 1;
                        }
                        else if ("Drama".equals(choices[i][j]))
                        {
                            DramaCap[i]++;
                            DramaAvailability[j] = 1;
                        }
                        else if ("Dance".equals(choices[i][j]))
                        {
                            DanceCap[i]++;
                            DanceAvailability[j] = 1;
                        }
                        else if ("Music".equals(choices[i][j]))
                        {
                            MusicCap[i]++;
                            MusicAvailability[j] = 1;
                        }
                        else if ("Computer Studies".equals(choices[i][j]))
                        {
                            ComSciCap[i]++;
                            ComSciAvailability[j] = 1;
                        }
                        else if ("Exploring Technologies".equals(choices[i][j]))
                        {
                            TechCap[i]++;
                            TechAvailability[j] = 1;
                        }
                        //System.out.println(BusinessCap[i] +"\n"+ ArtCap[i] +"\n"+ DramaCap[i] +"\n"+ DanceCap[i] +"\n"+ MusicCap[i] +"\n"+ ComSciCap[i] +"\n"+ TechCap[i]);
                    }
                }
                else
                {
                    SecondChoice secondchoice = new SecondChoice();
                    choices[i][j] = secondchoice.second(responses[i + 17][j], BusinessCap[i], ArtCap[i], DramaCap[i], DanceCap[i], MusicCap[i], ComSciCap[i], TechCap[i], MaxBusinessCap, MaxArtCap, MaxDramaCap, MaxDanceCap, MaxMusicCap, MaxComSciCap, MaxTechCap, BusinessAvailability[j], ArtAvailability[j], DramaAvailability[j], DanceAvailability[j], MusicAvailability[j], ComSciAvailability[j], TechAvailability[j]);
                    if ("".equals(choices[i][j]))
                    {
                        ThirdChoice thirdchoice = new ThirdChoice();
                        choices[i][j] = thirdchoice.third(responses[i + 18][j], BusinessCap[i], ArtCap[i], DramaCap[i], DanceCap[i], MusicCap[i], ComSciCap[i], TechCap[i], MaxBusinessCap, MaxArtCap, MaxDramaCap, MaxDanceCap, MaxMusicCap, MaxComSciCap, MaxTechCap, BusinessAvailability[j], ArtAvailability[j], DramaAvailability[j], DanceAvailability[j], MusicAvailability[j], ComSciAvailability[j], TechAvailability[j]);
                        if ("".equals(choices[i][j]))
                        {
                            FourthChoice fourthchoice = new FourthChoice();
                            choices[i][j] = fourthchoice.fourth(responses[i + 19][j], BusinessCap[i], ArtCap[i], DramaCap[i], DanceCap[i], MusicCap[i], ComSciCap[i], TechCap[i], MaxBusinessCap, MaxArtCap, MaxDramaCap, MaxDanceCap, MaxMusicCap, MaxComSciCap, MaxTechCap, BusinessAvailability[j], ArtAvailability[j], DramaAvailability[j], DanceAvailability[j], MusicAvailability[j], ComSciAvailability[j], TechAvailability[j]);
                            if ("".equals(choices[i][j]))
                            {
                                FifthChoice fifthchoice = new FifthChoice();
                                choices[i][j] = fifthchoice.fifth(responses[i + 20][j], BusinessCap[i], ArtCap[i], DramaCap[i], DanceCap[i], MusicCap[i], ComSciCap[i], TechCap[i], MaxBusinessCap, MaxArtCap, MaxDramaCap, MaxDanceCap, MaxMusicCap, MaxComSciCap, MaxTechCap, BusinessAvailability[j], ArtAvailability[j], DramaAvailability[j], DanceAvailability[j], MusicAvailability[j], ComSciAvailability[j], TechAvailability[j]);
                                if ("".equals(choices[i][j]))
                                {
                                    SixthChoice sixthchoice = new SixthChoice();
                                    choices[i][j] = sixthchoice.sixth(responses[i + 21][j], BusinessCap[i], ArtCap[i], DramaCap[i], DanceCap[i], MusicCap[i], ComSciCap[i], TechCap[i], MaxBusinessCap, MaxArtCap, MaxDramaCap, MaxDanceCap, MaxMusicCap, MaxComSciCap, MaxTechCap, BusinessAvailability[j], ArtAvailability[j], DramaAvailability[j], DanceAvailability[j], MusicAvailability[j], ComSciAvailability[j], TechAvailability[j]);
                                    if ("".equals(choices[i][j]))
                                    {
                                        SeventhChoice seventhchoice = new SeventhChoice();
                                        choices[i][j] = seventhchoice.seventh(responses[i + 22][j], BusinessCap[i], ArtCap[i], DramaCap[i], DanceCap[i], MusicCap[i], ComSciCap[i], TechCap[i], MaxBusinessCap, MaxArtCap, MaxDramaCap, MaxDanceCap, MaxMusicCap, MaxComSciCap, MaxTechCap, BusinessAvailability[j], ArtAvailability[j], DramaAvailability[j], DanceAvailability[j], MusicAvailability[j], ComSciAvailability[j], TechAvailability[j]);
                                    }
                                }
                            }
                        }
                    }

                    if ("Business Technology".equals(choices[i][j]))
                    {
                        BusinessCap[i]++;
                        BusinessAvailability[j] = 1;
                    }
                    else if ("Visual Arts".equals(choices[i][j]))
                    {
                        ArtCap[i]++;
                        ArtAvailability[j] = 1;
                    }
                    else if ("Drama".equals(choices[i][j]))
                    {
                        DramaCap[i]++;
                        DramaAvailability[j] = 1;
                    }
                    else if ("Dance".equals(choices[i][j]))
                    {
                        DanceCap[i]++;
                        DanceAvailability[j] = 1;
                    }
                    else if ("Music".equals(choices[i][j]))
                    {
                        MusicCap[i]++;
                        MusicAvailability[j] = 1;
                    }
                    else if ("Computer Studies".equals(choices[i][j]))
                    {
                        ComSciCap[i]++;
                        ComSciAvailability[j] = 1;
                    }
                    else if ("Exploring Technologies".equals(choices[i][j]))
                    {
                        TechCap[i]++;
                        TechAvailability[j] = 1;
                    }
                }
            }
            else if (responses[i + 16][j].equals("Visual Arts"))
            {
                if (ArtAvailability[j] == 0)
                {
                    if (ArtCap[i] < MaxArtCap)
                    {
                        choices[i][j] = responses[i + 16][j];
                        ArtCap[i]++;
                        ArtAvailability[j] = 1;
                    }
                    else if (ArtCap[i] == MaxArtCap)
                    {
                        SecondChoice secondchoice = new SecondChoice();
                        choices[i][j] = secondchoice.second(responses[i + 17][j], BusinessCap[i], ArtCap[i], DramaCap[i], DanceCap[i], MusicCap[i], ComSciCap[i], TechCap[i], MaxBusinessCap, MaxArtCap, MaxDramaCap, MaxDanceCap, MaxMusicCap, MaxComSciCap, MaxTechCap, BusinessAvailability[j], ArtAvailability[j], DramaAvailability[j], DanceAvailability[j], MusicAvailability[j], ComSciAvailability[j], TechAvailability[j]);
                        if ("".equals(choices[i][j]))
                        {
                            ThirdChoice thirdchoice = new ThirdChoice();
                            choices[i][j] = thirdchoice.third(responses[i + 18][j], BusinessCap[i], ArtCap[i], DramaCap[i], DanceCap[i], MusicCap[i], ComSciCap[i], TechCap[i], MaxBusinessCap, MaxArtCap, MaxDramaCap, MaxDanceCap, MaxMusicCap, MaxComSciCap, MaxTechCap, BusinessAvailability[j], ArtAvailability[j], DramaAvailability[j], DanceAvailability[j], MusicAvailability[j], ComSciAvailability[j], TechAvailability[j]);
                            if ("".equals(choices[i][j]))
                            {
                                FourthChoice fourthchoice = new FourthChoice();
                                choices[i][j] = fourthchoice.fourth(responses[i + 19][j], BusinessCap[i], ArtCap[i], DramaCap[i], DanceCap[i], MusicCap[i], ComSciCap[i], TechCap[i], MaxBusinessCap, MaxArtCap, MaxDramaCap, MaxDanceCap, MaxMusicCap, MaxComSciCap, MaxTechCap, BusinessAvailability[j], ArtAvailability[j], DramaAvailability[j], DanceAvailability[j], MusicAvailability[j], ComSciAvailability[j], TechAvailability[j]);
                                if ("".equals(choices[i][j]))
                                {
                                    FifthChoice fifthchoice = new FifthChoice();
                                    choices[i][j] = fifthchoice.fifth(responses[i + 20][j], BusinessCap[i], ArtCap[i], DramaCap[i], DanceCap[i], MusicCap[i], ComSciCap[i], TechCap[i], MaxBusinessCap, MaxArtCap, MaxDramaCap, MaxDanceCap, MaxMusicCap, MaxComSciCap, MaxTechCap, BusinessAvailability[j], ArtAvailability[j], DramaAvailability[j], DanceAvailability[j], MusicAvailability[j], ComSciAvailability[j], TechAvailability[j]);
                                    if ("".equals(choices[i][j]))
                                    {
                                        SixthChoice sixthchoice = new SixthChoice();
                                        choices[i][j] = sixthchoice.sixth(responses[i + 21][j], BusinessCap[i], ArtCap[i], DramaCap[i], DanceCap[i], MusicCap[i], ComSciCap[i], TechCap[i], MaxBusinessCap, MaxArtCap, MaxDramaCap, MaxDanceCap, MaxMusicCap, MaxComSciCap, MaxTechCap, BusinessAvailability[j], ArtAvailability[j], DramaAvailability[j], DanceAvailability[j], MusicAvailability[j], ComSciAvailability[j], TechAvailability[j]);
                                        if ("".equals(choices[i][j]))
                                        {
                                            SeventhChoice seventhchoice = new SeventhChoice();
                                            choices[i][j] = seventhchoice.seventh(responses[i + 22][j], BusinessCap[i], ArtCap[i], DramaCap[i], DanceCap[i], MusicCap[i], ComSciCap[i], TechCap[i], MaxBusinessCap, MaxArtCap, MaxDramaCap, MaxDanceCap, MaxMusicCap, MaxComSciCap, MaxTechCap, BusinessAvailability[j], ArtAvailability[j], DramaAvailability[j], DanceAvailability[j], MusicAvailability[j], ComSciAvailability[j], TechAvailability[j]);
                                        }
                                    }
                                }
                            }
                        }
                        
                        if ("Business Technology".equals(choices[i][j]))
                        {
                            BusinessCap[i]++;
                            BusinessAvailability[j] = 1;
                        }
                        else if ("Visual Arts".equals(choices[i][j]))
                        {
                            ArtCap[i]++;
                            ArtAvailability[j] = 1;
                        }
                        else if ("Drama".equals(choices[i][j]))
                        {
                            DramaCap[i]++;
                            DramaAvailability[j] = 1;
                        }
                        else if ("Dance".equals(choices[i][j]))
                        {
                            DanceCap[i]++;
                            DanceAvailability[j] = 1;
                        }
                        else if ("Music".equals(choices[i][j]))
                        {
                            MusicCap[i]++;
                            MusicAvailability[j] = 1;
                        }
                        else if ("Computer Studies".equals(choices[i][j]))
                        {
                            ComSciCap[i]++;
                            ComSciAvailability[j] = 1;
                        }
                        else if ("Exploring Technologies".equals(choices[i][j]))
                        {
                            TechCap[i]++;
                            TechAvailability[j] = 1;
                        }
                        System.out.println(BusinessCap[i] +"\n"+ ArtCap[i] +"\n"+ DramaCap[i] +"\n"+ DanceCap[i] +"\n"+ MusicCap[i] +"\n"+ ComSciCap[i] +"\n"+ TechCap[i]);
                    }
                }
                else
                {
                    SecondChoice secondchoice = new SecondChoice();
                    choices[i][j] = secondchoice.second(responses[i + 17][j], BusinessCap[i], ArtCap[i], DramaCap[i], DanceCap[i], MusicCap[i], ComSciCap[i], TechCap[i], MaxBusinessCap, MaxArtCap, MaxDramaCap, MaxDanceCap, MaxMusicCap, MaxComSciCap, MaxTechCap, BusinessAvailability[j], ArtAvailability[j], DramaAvailability[j], DanceAvailability[j], MusicAvailability[j], ComSciAvailability[j], TechAvailability[j]);
                    if ("".equals(choices[i][j]))
                    {
                        ThirdChoice thirdchoice = new ThirdChoice();
                        choices[i][j] = thirdchoice.third(responses[i + 18][j], BusinessCap[i], ArtCap[i], DramaCap[i], DanceCap[i], MusicCap[i], ComSciCap[i], TechCap[i], MaxBusinessCap, MaxArtCap, MaxDramaCap, MaxDanceCap, MaxMusicCap, MaxComSciCap, MaxTechCap, BusinessAvailability[j], ArtAvailability[j], DramaAvailability[j], DanceAvailability[j], MusicAvailability[j], ComSciAvailability[j], TechAvailability[j]);
                        if ("".equals(choices[i][j]))
                        {
                            FourthChoice fourthchoice = new FourthChoice();
                            choices[i][j] = fourthchoice.fourth(responses[i + 19][j], BusinessCap[i], ArtCap[i], DramaCap[i], DanceCap[i], MusicCap[i], ComSciCap[i], TechCap[i], MaxBusinessCap, MaxArtCap, MaxDramaCap, MaxDanceCap, MaxMusicCap, MaxComSciCap, MaxTechCap, BusinessAvailability[j], ArtAvailability[j], DramaAvailability[j], DanceAvailability[j], MusicAvailability[j], ComSciAvailability[j], TechAvailability[j]);
                            if ("".equals(choices[i][j]))
                            {
                                FifthChoice fifthchoice = new FifthChoice();
                                choices[i][j] = fifthchoice.fifth(responses[i + 20][j], BusinessCap[i], ArtCap[i], DramaCap[i], DanceCap[i], MusicCap[i], ComSciCap[i], TechCap[i], MaxBusinessCap, MaxArtCap, MaxDramaCap, MaxDanceCap, MaxMusicCap, MaxComSciCap, MaxTechCap, BusinessAvailability[j], ArtAvailability[j], DramaAvailability[j], DanceAvailability[j], MusicAvailability[j], ComSciAvailability[j], TechAvailability[j]);
                                if ("".equals(choices[i][j]))
                                {
                                    SixthChoice sixthchoice = new SixthChoice();
                                    choices[i][j] = sixthchoice.sixth(responses[i + 21][j], BusinessCap[i], ArtCap[i], DramaCap[i], DanceCap[i], MusicCap[i], ComSciCap[i], TechCap[i], MaxBusinessCap, MaxArtCap, MaxDramaCap, MaxDanceCap, MaxMusicCap, MaxComSciCap, MaxTechCap, BusinessAvailability[j], ArtAvailability[j], DramaAvailability[j], DanceAvailability[j], MusicAvailability[j], ComSciAvailability[j], TechAvailability[j]);
                                    if ("".equals(choices[i][j]))
                                    {
                                        SeventhChoice seventhchoice = new SeventhChoice();
                                        choices[i][j] = seventhchoice.seventh(responses[i + 22][j], BusinessCap[i], ArtCap[i], DramaCap[i], DanceCap[i], MusicCap[i], ComSciCap[i], TechCap[i], MaxBusinessCap, MaxArtCap, MaxDramaCap, MaxDanceCap, MaxMusicCap, MaxComSciCap, MaxTechCap, BusinessAvailability[j], ArtAvailability[j], DramaAvailability[j], DanceAvailability[j], MusicAvailability[j], ComSciAvailability[j], TechAvailability[j]);
                                    }
                                }
                            }
                        }
                    }

                    if ("Business Technology".equals(choices[i][j]))
                    {
                        BusinessCap[i]++;
                        BusinessAvailability[j] = 1;
                    }
                    else if ("Visual Arts".equals(choices[i][j]))
                    {
                        ArtCap[i]++;
                        ArtAvailability[j] = 1;
                    }
                    else if ("Drama".equals(choices[i][j]))
                    {
                        DramaCap[i]++;
                        DramaAvailability[j] = 1;
                    }
                    else if ("Dance".equals(choices[i][j]))
                    {
                        DanceCap[i]++;
                        DanceAvailability[j] = 1;
                    }
                    else if ("Music".equals(choices[i][j]))
                    {
                        MusicCap[i]++;
                        MusicAvailability[j] = 1;
                    }
                    else if ("Computer Studies".equals(choices[i][j]))
                    {
                        ComSciCap[i]++;
                        ComSciAvailability[j] = 1;
                    }
                    else if ("Exploring Technologies".equals(choices[i][j]))
                    {
                        TechCap[i]++;
                        TechAvailability[j] = 1;
                    }
                }
            }
            else if (responses[i + 16][j].equals("Drama"))
            {
                if (DramaAvailability[j] == 0)
                {
                    if (DramaCap[i] < MaxDramaCap)
                    {
                        choices[i][j] = responses[i + 16][j];
                        DramaCap[i]++;
                        DramaAvailability[j] = 1;
                    }
                    else if (DramaCap[i] == MaxDramaCap)
                    {
                        SecondChoice secondchoice = new SecondChoice();
                        choices[i][j] = secondchoice.second(responses[i + 17][j], BusinessCap[i], ArtCap[i], DramaCap[i], DanceCap[i], MusicCap[i], ComSciCap[i], TechCap[i], MaxBusinessCap, MaxArtCap, MaxDramaCap, MaxDanceCap, MaxMusicCap, MaxComSciCap, MaxTechCap, BusinessAvailability[j], ArtAvailability[j], DramaAvailability[j], DanceAvailability[j], MusicAvailability[j], ComSciAvailability[j], TechAvailability[j]);
                        if ("".equals(choices[i][j]))
                        {
                            ThirdChoice thirdchoice = new ThirdChoice();
                            choices[i][j] = thirdchoice.third(responses[i + 18][j], BusinessCap[i], ArtCap[i], DramaCap[i], DanceCap[i], MusicCap[i], ComSciCap[i], TechCap[i], MaxBusinessCap, MaxArtCap, MaxDramaCap, MaxDanceCap, MaxMusicCap, MaxComSciCap, MaxTechCap, BusinessAvailability[j], ArtAvailability[j], DramaAvailability[j], DanceAvailability[j], MusicAvailability[j], ComSciAvailability[j], TechAvailability[j]);
                            if ("".equals(choices[i][j]))
                            {
                                FourthChoice fourthchoice = new FourthChoice();
                                choices[i][j] = fourthchoice.fourth(responses[i + 19][j], BusinessCap[i], ArtCap[i], DramaCap[i], DanceCap[i], MusicCap[i], ComSciCap[i], TechCap[i], MaxBusinessCap, MaxArtCap, MaxDramaCap, MaxDanceCap, MaxMusicCap, MaxComSciCap, MaxTechCap, BusinessAvailability[j], ArtAvailability[j], DramaAvailability[j], DanceAvailability[j], MusicAvailability[j], ComSciAvailability[j], TechAvailability[j]);
                                if ("".equals(choices[i][j]))
                                {
                                    FifthChoice fifthchoice = new FifthChoice();
                                    choices[i][j] = fifthchoice.fifth(responses[i + 20][j], BusinessCap[i], ArtCap[i], DramaCap[i], DanceCap[i], MusicCap[i], ComSciCap[i], TechCap[i], MaxBusinessCap, MaxArtCap, MaxDramaCap, MaxDanceCap, MaxMusicCap, MaxComSciCap, MaxTechCap, BusinessAvailability[j], ArtAvailability[j], DramaAvailability[j], DanceAvailability[j], MusicAvailability[j], ComSciAvailability[j], TechAvailability[j]);
                                    if ("".equals(choices[i][j]))
                                    {
                                        SixthChoice sixthchoice = new SixthChoice();
                                        choices[i][j] = sixthchoice.sixth(responses[i + 21][j], BusinessCap[i], ArtCap[i], DramaCap[i], DanceCap[i], MusicCap[i], ComSciCap[i], TechCap[i], MaxBusinessCap, MaxArtCap, MaxDramaCap, MaxDanceCap, MaxMusicCap, MaxComSciCap, MaxTechCap, BusinessAvailability[j], ArtAvailability[j], DramaAvailability[j], DanceAvailability[j], MusicAvailability[j], ComSciAvailability[j], TechAvailability[j]);
                                        if ("".equals(choices[i][j]))
                                        {
                                            SeventhChoice seventhchoice = new SeventhChoice();
                                            choices[i][j] = seventhchoice.seventh(responses[i + 22][j], BusinessCap[i], ArtCap[i], DramaCap[i], DanceCap[i], MusicCap[i], ComSciCap[i], TechCap[i], MaxBusinessCap, MaxArtCap, MaxDramaCap, MaxDanceCap, MaxMusicCap, MaxComSciCap, MaxTechCap, BusinessAvailability[j], ArtAvailability[j], DramaAvailability[j], DanceAvailability[j], MusicAvailability[j], ComSciAvailability[j], TechAvailability[j]);
                                        }
                                    }
                                }
                            }
                        }
                        
                        if ("Business Technology".equals(choices[i][j]))
                        {
                            BusinessCap[i]++;
                            BusinessAvailability[j] = 1;
                        }
                        else if ("Visual Arts".equals(choices[i][j]))
                        {
                            ArtCap[i]++;
                            ArtAvailability[j] = 1;
                        }
                        else if ("Drama".equals(choices[i][j]))
                        {
                            DramaCap[i]++;
                            DramaAvailability[j] = 1;
                        }
                        else if ("Dance".equals(choices[i][j]))
                        {
                            DanceCap[i]++;
                            DanceAvailability[j] = 1;
                        }
                        else if ("Music".equals(choices[i][j]))
                        {
                            MusicCap[i]++;
                            MusicAvailability[j] = 1;
                        }
                        else if ("Computer Studies".equals(choices[i][j]))
                        {
                            ComSciCap[i]++;
                            ComSciAvailability[j] = 1;
                        }
                        else if ("Exploring Technologies".equals(choices[i][j]))
                        {
                            TechCap[i]++;
                            TechAvailability[j] = 1;
                        }
                        System.out.println(BusinessCap[i] +"\n"+ ArtCap[i] +"\n"+ DramaCap[i] +"\n"+ DanceCap[i] +"\n"+ MusicCap[i] +"\n"+ ComSciCap[i] +"\n"+ TechCap[i]);
                    }
                }
                else
                {
                    SecondChoice secondchoice = new SecondChoice();
                    choices[i][j] = secondchoice.second(responses[i + 17][j], BusinessCap[i], ArtCap[i], DramaCap[i], DanceCap[i], MusicCap[i], ComSciCap[i], TechCap[i], MaxBusinessCap, MaxArtCap, MaxDramaCap, MaxDanceCap, MaxMusicCap, MaxComSciCap, MaxTechCap, BusinessAvailability[j], ArtAvailability[j], DramaAvailability[j], DanceAvailability[j], MusicAvailability[j], ComSciAvailability[j], TechAvailability[j]);
                    if ("".equals(choices[i][j]))
                    {
                        ThirdChoice thirdchoice = new ThirdChoice();
                        choices[i][j] = thirdchoice.third(responses[i + 18][j], BusinessCap[i], ArtCap[i], DramaCap[i], DanceCap[i], MusicCap[i], ComSciCap[i], TechCap[i], MaxBusinessCap, MaxArtCap, MaxDramaCap, MaxDanceCap, MaxMusicCap, MaxComSciCap, MaxTechCap, BusinessAvailability[j], ArtAvailability[j], DramaAvailability[j], DanceAvailability[j], MusicAvailability[j], ComSciAvailability[j], TechAvailability[j]);
                        if ("".equals(choices[i][j]))
                        {
                            FourthChoice fourthchoice = new FourthChoice();
                            choices[i][j] = fourthchoice.fourth(responses[i + 19][j], BusinessCap[i], ArtCap[i], DramaCap[i], DanceCap[i], MusicCap[i], ComSciCap[i], TechCap[i], MaxBusinessCap, MaxArtCap, MaxDramaCap, MaxDanceCap, MaxMusicCap, MaxComSciCap, MaxTechCap, BusinessAvailability[j], ArtAvailability[j], DramaAvailability[j], DanceAvailability[j], MusicAvailability[j], ComSciAvailability[j], TechAvailability[j]);
                            if ("".equals(choices[i][j]))
                            {
                                FifthChoice fifthchoice = new FifthChoice();
                                choices[i][j] = fifthchoice.fifth(responses[i + 20][j], BusinessCap[i], ArtCap[i], DramaCap[i], DanceCap[i], MusicCap[i], ComSciCap[i], TechCap[i], MaxBusinessCap, MaxArtCap, MaxDramaCap, MaxDanceCap, MaxMusicCap, MaxComSciCap, MaxTechCap, BusinessAvailability[j], ArtAvailability[j], DramaAvailability[j], DanceAvailability[j], MusicAvailability[j], ComSciAvailability[j], TechAvailability[j]);
                                if ("".equals(choices[i][j]))
                                {
                                    SixthChoice sixthchoice = new SixthChoice();
                                    choices[i][j] = sixthchoice.sixth(responses[i + 21][j], BusinessCap[i], ArtCap[i], DramaCap[i], DanceCap[i], MusicCap[i], ComSciCap[i], TechCap[i], MaxBusinessCap, MaxArtCap, MaxDramaCap, MaxDanceCap, MaxMusicCap, MaxComSciCap, MaxTechCap, BusinessAvailability[j], ArtAvailability[j], DramaAvailability[j], DanceAvailability[j], MusicAvailability[j], ComSciAvailability[j], TechAvailability[j]);
                                    if ("".equals(choices[i][j]))
                                    {
                                        SeventhChoice seventhchoice = new SeventhChoice();
                                        choices[i][j] = seventhchoice.seventh(responses[i + 22][j], BusinessCap[i], ArtCap[i], DramaCap[i], DanceCap[i], MusicCap[i], ComSciCap[i], TechCap[i], MaxBusinessCap, MaxArtCap, MaxDramaCap, MaxDanceCap, MaxMusicCap, MaxComSciCap, MaxTechCap, BusinessAvailability[j], ArtAvailability[j], DramaAvailability[j], DanceAvailability[j], MusicAvailability[j], ComSciAvailability[j], TechAvailability[j]);
                                    }
                                }
                            }
                        }
                    }

                    if ("Business Technology".equals(choices[i][j]))
                    {
                        BusinessCap[i]++;
                        BusinessAvailability[j] = 1;
                    }
                    else if ("Visual Arts".equals(choices[i][j]))
                    {
                        ArtCap[i]++;
                        ArtAvailability[j] = 1;
                    }
                    else if ("Drama".equals(choices[i][j]))
                    {
                        DramaCap[i]++;
                        DramaAvailability[j] = 1;
                    }
                    else if ("Dance".equals(choices[i][j]))
                    {
                        DanceCap[i]++;
                        DanceAvailability[j] = 1;
                    }
                    else if ("Music".equals(choices[i][j]))
                    {
                        MusicCap[i]++;
                        MusicAvailability[j] = 1;
                    }
                    else if ("Computer Studies".equals(choices[i][j]))
                    {
                        ComSciCap[i]++;
                        ComSciAvailability[j] = 1;
                    }
                    else if ("Exploring Technologies".equals(choices[i][j]))
                    {
                        TechCap[i]++;
                        TechAvailability[j] = 1;
                    }
                }
            }
            else if (responses[i + 16][j].equals("Dance"))
            {
                if (DanceAvailability[j] == 0)
                {
                    if (DanceCap[i] < MaxDanceCap)
                    {
                        choices[i][j] = responses[i + 16][j];
                        DanceCap[i]++;
                        DanceAvailability[j] = 1;
                    }
                    else if (DanceCap[i] == MaxDanceCap)
                    {
                        SecondChoice secondchoice = new SecondChoice();
                        choices[i][j] = secondchoice.second(responses[i + 17][j], BusinessCap[i], ArtCap[i], DramaCap[i], DanceCap[i], MusicCap[i], ComSciCap[i], TechCap[i], MaxBusinessCap, MaxArtCap, MaxDramaCap, MaxDanceCap, MaxMusicCap, MaxComSciCap, MaxTechCap, BusinessAvailability[j], ArtAvailability[j], DramaAvailability[j], DanceAvailability[j], MusicAvailability[j], ComSciAvailability[j], TechAvailability[j]);
                        if ("".equals(choices[i][j]))
                        {
                            ThirdChoice thirdchoice = new ThirdChoice();
                            choices[i][j] = thirdchoice.third(responses[i + 18][j], BusinessCap[i], ArtCap[i], DramaCap[i], DanceCap[i], MusicCap[i], ComSciCap[i], TechCap[i], MaxBusinessCap, MaxArtCap, MaxDramaCap, MaxDanceCap, MaxMusicCap, MaxComSciCap, MaxTechCap, BusinessAvailability[j], ArtAvailability[j], DramaAvailability[j], DanceAvailability[j], MusicAvailability[j], ComSciAvailability[j], TechAvailability[j]);
                            if ("".equals(choices[i][j]))
                            {
                                FourthChoice fourthchoice = new FourthChoice();
                                choices[i][j] = fourthchoice.fourth(responses[i + 19][j], BusinessCap[i], ArtCap[i], DramaCap[i], DanceCap[i], MusicCap[i], ComSciCap[i], TechCap[i], MaxBusinessCap, MaxArtCap, MaxDramaCap, MaxDanceCap, MaxMusicCap, MaxComSciCap, MaxTechCap, BusinessAvailability[j], ArtAvailability[j], DramaAvailability[j], DanceAvailability[j], MusicAvailability[j], ComSciAvailability[j], TechAvailability[j]);
                                if ("".equals(choices[i][j]))
                                {
                                    FifthChoice fifthchoice = new FifthChoice();
                                    choices[i][j] = fifthchoice.fifth(responses[i + 20][j], BusinessCap[i], ArtCap[i], DramaCap[i], DanceCap[i], MusicCap[i], ComSciCap[i], TechCap[i], MaxBusinessCap, MaxArtCap, MaxDramaCap, MaxDanceCap, MaxMusicCap, MaxComSciCap, MaxTechCap, BusinessAvailability[j], ArtAvailability[j], DramaAvailability[j], DanceAvailability[j], MusicAvailability[j], ComSciAvailability[j], TechAvailability[j]);
                                    if ("".equals(choices[i][j]))
                                    {
                                        SixthChoice sixthchoice = new SixthChoice();
                                        choices[i][j] = sixthchoice.sixth(responses[i + 21][j], BusinessCap[i], ArtCap[i], DramaCap[i], DanceCap[i], MusicCap[i], ComSciCap[i], TechCap[i], MaxBusinessCap, MaxArtCap, MaxDramaCap, MaxDanceCap, MaxMusicCap, MaxComSciCap, MaxTechCap, BusinessAvailability[j], ArtAvailability[j], DramaAvailability[j], DanceAvailability[j], MusicAvailability[j], ComSciAvailability[j], TechAvailability[j]);
                                        if ("".equals(choices[i][j]))
                                        {
                                            SeventhChoice seventhchoice = new SeventhChoice();
                                            choices[i][j] = seventhchoice.seventh(responses[i + 22][j], BusinessCap[i], ArtCap[i], DramaCap[i], DanceCap[i], MusicCap[i], ComSciCap[i], TechCap[i], MaxBusinessCap, MaxArtCap, MaxDramaCap, MaxDanceCap, MaxMusicCap, MaxComSciCap, MaxTechCap, BusinessAvailability[j], ArtAvailability[j], DramaAvailability[j], DanceAvailability[j], MusicAvailability[j], ComSciAvailability[j], TechAvailability[j]);
                                        }
                                    }
                                }
                            }
                        }
                        
                        if ("Business Technology".equals(choices[i][j]))
                        {
                            BusinessCap[i]++;
                            BusinessAvailability[j] = 1;
                        }
                        else if ("Visual Arts".equals(choices[i][j]))
                        {
                            ArtCap[i]++;
                            ArtAvailability[j] = 1;
                        }
                        else if ("Drama".equals(choices[i][j]))
                        {
                            DramaCap[i]++;
                            DramaAvailability[j] = 1;
                        }
                        else if ("Dance".equals(choices[i][j]))
                        {
                            DanceCap[i]++;
                            DanceAvailability[j] = 1;
                        }
                        else if ("Music".equals(choices[i][j]))
                        {
                            MusicCap[i]++;
                            MusicAvailability[j] = 1;
                        }
                        else if ("Computer Studies".equals(choices[i][j]))
                        {
                            ComSciCap[i]++;
                            ComSciAvailability[j] = 1;
                        }
                        else if ("Exploring Technologies".equals(choices[i][j]))
                        {
                            TechCap[i]++;
                            TechAvailability[j] = 1;
                        }
                        System.out.println(BusinessCap[i] +"\n"+ ArtCap[i] +"\n"+ DramaCap[i] +"\n"+ DanceCap[i] +"\n"+ MusicCap[i] +"\n"+ ComSciCap[i] +"\n"+ TechCap[i]);
                    }
                }
                else
                {
                    SecondChoice secondchoice = new SecondChoice();
                    choices[i][j] = secondchoice.second(responses[i + 17][j], BusinessCap[i], ArtCap[i], DramaCap[i], DanceCap[i], MusicCap[i], ComSciCap[i], TechCap[i], MaxBusinessCap, MaxArtCap, MaxDramaCap, MaxDanceCap, MaxMusicCap, MaxComSciCap, MaxTechCap, BusinessAvailability[j], ArtAvailability[j], DramaAvailability[j], DanceAvailability[j], MusicAvailability[j], ComSciAvailability[j], TechAvailability[j]);
                    if ("".equals(choices[i][j]))
                    {
                        ThirdChoice thirdchoice = new ThirdChoice();
                        choices[i][j] = thirdchoice.third(responses[i + 18][j], BusinessCap[i], ArtCap[i], DramaCap[i], DanceCap[i], MusicCap[i], ComSciCap[i], TechCap[i], MaxBusinessCap, MaxArtCap, MaxDramaCap, MaxDanceCap, MaxMusicCap, MaxComSciCap, MaxTechCap, BusinessAvailability[j], ArtAvailability[j], DramaAvailability[j], DanceAvailability[j], MusicAvailability[j], ComSciAvailability[j], TechAvailability[j]);
                        if ("".equals(choices[i][j]))
                        {
                            FourthChoice fourthchoice = new FourthChoice();
                            choices[i][j] = fourthchoice.fourth(responses[i + 19][j], BusinessCap[i], ArtCap[i], DramaCap[i], DanceCap[i], MusicCap[i], ComSciCap[i], TechCap[i], MaxBusinessCap, MaxArtCap, MaxDramaCap, MaxDanceCap, MaxMusicCap, MaxComSciCap, MaxTechCap, BusinessAvailability[j], ArtAvailability[j], DramaAvailability[j], DanceAvailability[j], MusicAvailability[j], ComSciAvailability[j], TechAvailability[j]);
                            if ("".equals(choices[i][j]))
                            {
                                FifthChoice fifthchoice = new FifthChoice();
                                choices[i][j] = fifthchoice.fifth(responses[i + 20][j], BusinessCap[i], ArtCap[i], DramaCap[i], DanceCap[i], MusicCap[i], ComSciCap[i], TechCap[i], MaxBusinessCap, MaxArtCap, MaxDramaCap, MaxDanceCap, MaxMusicCap, MaxComSciCap, MaxTechCap, BusinessAvailability[j], ArtAvailability[j], DramaAvailability[j], DanceAvailability[j], MusicAvailability[j], ComSciAvailability[j], TechAvailability[j]);
                                if ("".equals(choices[i][j]))
                                {
                                    SixthChoice sixthchoice = new SixthChoice();
                                    choices[i][j] = sixthchoice.sixth(responses[i + 21][j], BusinessCap[i], ArtCap[i], DramaCap[i], DanceCap[i], MusicCap[i], ComSciCap[i], TechCap[i], MaxBusinessCap, MaxArtCap, MaxDramaCap, MaxDanceCap, MaxMusicCap, MaxComSciCap, MaxTechCap, BusinessAvailability[j], ArtAvailability[j], DramaAvailability[j], DanceAvailability[j], MusicAvailability[j], ComSciAvailability[j], TechAvailability[j]);
                                    if ("".equals(choices[i][j]))
                                    {
                                        SeventhChoice seventhchoice = new SeventhChoice();
                                        choices[i][j] = seventhchoice.seventh(responses[i + 22][j], BusinessCap[i], ArtCap[i], DramaCap[i], DanceCap[i], MusicCap[i], ComSciCap[i], TechCap[i], MaxBusinessCap, MaxArtCap, MaxDramaCap, MaxDanceCap, MaxMusicCap, MaxComSciCap, MaxTechCap, BusinessAvailability[j], ArtAvailability[j], DramaAvailability[j], DanceAvailability[j], MusicAvailability[j], ComSciAvailability[j], TechAvailability[j]);
                                    }
                                }
                            }
                        }
                    }

                    if ("Business Technology".equals(choices[i][j]))
                    {
                        BusinessCap[i]++;
                        BusinessAvailability[j] = 1;
                    }
                    else if ("Visual Arts".equals(choices[i][j]))
                    {
                        ArtCap[i]++;
                        ArtAvailability[j] = 1;
                    }
                    else if ("Drama".equals(choices[i][j]))
                    {
                        DramaCap[i]++;
                        DramaAvailability[j] = 1;
                    }
                    else if ("Dance".equals(choices[i][j]))
                    {
                        DanceCap[i]++;
                        DanceAvailability[j] = 1;
                    }
                    else if ("Music".equals(choices[i][j]))
                    {
                        MusicCap[i]++;
                        MusicAvailability[j] = 1;
                    }
                    else if ("Computer Studies".equals(choices[i][j]))
                    {
                        ComSciCap[i]++;
                        ComSciAvailability[j] = 1;
                    }
                    else if ("Exploring Technologies".equals(choices[i][j]))
                    {
                        TechCap[i]++;
                        TechAvailability[j] = 1;
                    }
                }
            }
            else if (responses[i + 16][j].equals("Music"))
            {
                if (MusicAvailability[j] == 0)
                {
                    if (MusicCap[i] < MaxMusicCap)
                    {
                        choices[i][j] = responses[i + 16][j];
                        MusicCap[i]++;
                        MusicAvailability[j] = 1;
                    }
                    else if (MusicCap[i] == MaxMusicCap)
                    {
                        SecondChoice secondchoice = new SecondChoice();
                        choices[i][j] = secondchoice.second(responses[i + 17][j], BusinessCap[i], ArtCap[i], DramaCap[i], DanceCap[i], MusicCap[i], ComSciCap[i], TechCap[i], MaxBusinessCap, MaxArtCap, MaxDramaCap, MaxDanceCap, MaxMusicCap, MaxComSciCap, MaxTechCap, BusinessAvailability[j], ArtAvailability[j], DramaAvailability[j], DanceAvailability[j], MusicAvailability[j], ComSciAvailability[j], TechAvailability[j]);
                        if ("".equals(choices[i][j]))
                        {
                            ThirdChoice thirdchoice = new ThirdChoice();
                            choices[i][j] = thirdchoice.third(responses[i + 18][j], BusinessCap[i], ArtCap[i], DramaCap[i], DanceCap[i], MusicCap[i], ComSciCap[i], TechCap[i], MaxBusinessCap, MaxArtCap, MaxDramaCap, MaxDanceCap, MaxMusicCap, MaxComSciCap, MaxTechCap, BusinessAvailability[j], ArtAvailability[j], DramaAvailability[j], DanceAvailability[j], MusicAvailability[j], ComSciAvailability[j], TechAvailability[j]);
                            if ("".equals(choices[i][j]))
                            {
                                FourthChoice fourthchoice = new FourthChoice();
                                choices[i][j] = fourthchoice.fourth(responses[i + 19][j], BusinessCap[i], ArtCap[i], DramaCap[i], DanceCap[i], MusicCap[i], ComSciCap[i], TechCap[i], MaxBusinessCap, MaxArtCap, MaxDramaCap, MaxDanceCap, MaxMusicCap, MaxComSciCap, MaxTechCap, BusinessAvailability[j], ArtAvailability[j], DramaAvailability[j], DanceAvailability[j], MusicAvailability[j], ComSciAvailability[j], TechAvailability[j]);
                                if ("".equals(choices[i][j]))
                                {
                                    FifthChoice fifthchoice = new FifthChoice();
                                    choices[i][j] = fifthchoice.fifth(responses[i + 20][j], BusinessCap[i], ArtCap[i], DramaCap[i], DanceCap[i], MusicCap[i], ComSciCap[i], TechCap[i], MaxBusinessCap, MaxArtCap, MaxDramaCap, MaxDanceCap, MaxMusicCap, MaxComSciCap, MaxTechCap, BusinessAvailability[j], ArtAvailability[j], DramaAvailability[j], DanceAvailability[j], MusicAvailability[j], ComSciAvailability[j], TechAvailability[j]);
                                    if ("".equals(choices[i][j]))
                                    {
                                        SixthChoice sixthchoice = new SixthChoice();
                                        choices[i][j] = sixthchoice.sixth(responses[i + 21][j], BusinessCap[i], ArtCap[i], DramaCap[i], DanceCap[i], MusicCap[i], ComSciCap[i], TechCap[i], MaxBusinessCap, MaxArtCap, MaxDramaCap, MaxDanceCap, MaxMusicCap, MaxComSciCap, MaxTechCap, BusinessAvailability[j], ArtAvailability[j], DramaAvailability[j], DanceAvailability[j], MusicAvailability[j], ComSciAvailability[j], TechAvailability[j]);
                                        if ("".equals(choices[i][j]))
                                        {
                                            SeventhChoice seventhchoice = new SeventhChoice();
                                            choices[i][j] = seventhchoice.seventh(responses[i + 22][j], BusinessCap[i], ArtCap[i], DramaCap[i], DanceCap[i], MusicCap[i], ComSciCap[i], TechCap[i], MaxBusinessCap, MaxArtCap, MaxDramaCap, MaxDanceCap, MaxMusicCap, MaxComSciCap, MaxTechCap, BusinessAvailability[j], ArtAvailability[j], DramaAvailability[j], DanceAvailability[j], MusicAvailability[j], ComSciAvailability[j], TechAvailability[j]);
                                        }
                                    }
                                }
                            }
                        }
                        
                        if ("Business Technology".equals(choices[i][j]))
                        {
                            BusinessCap[i]++;
                            BusinessAvailability[j] = 1;
                        }
                        else if ("Visual Arts".equals(choices[i][j]))
                        {
                            ArtCap[i]++;
                            ArtAvailability[j] = 1;
                        }
                        else if ("Drama".equals(choices[i][j]))
                        {
                            DramaCap[i]++;
                            DramaAvailability[j] = 1;
                        }
                        else if ("Dance".equals(choices[i][j]))
                        {
                            DanceCap[i]++;
                            DanceAvailability[j] = 1;
                        }
                        else if ("Music".equals(choices[i][j]))
                        {
                            MusicCap[i]++;
                            MusicAvailability[j] = 1;
                        }
                        else if ("Computer Studies".equals(choices[i][j]))
                        {
                            ComSciCap[i]++;
                            ComSciAvailability[j] = 1;
                        }
                        else if ("Exploring Technologies".equals(choices[i][j]))
                        {
                            TechCap[i]++;
                            TechAvailability[j] = 1;
                        }
                        System.out.println(BusinessCap[i] +"\n"+ ArtCap[i] +"\n"+ DramaCap[i] +"\n"+ DanceCap[i] +"\n"+ MusicCap[i] +"\n"+ ComSciCap[i] +"\n"+ TechCap[i]);
                    }
                }
                else
                {
                    SecondChoice secondchoice = new SecondChoice();
                    choices[i][j] = secondchoice.second(responses[i + 17][j], BusinessCap[i], ArtCap[i], DramaCap[i], DanceCap[i], MusicCap[i], ComSciCap[i], TechCap[i], MaxBusinessCap, MaxArtCap, MaxDramaCap, MaxDanceCap, MaxMusicCap, MaxComSciCap, MaxTechCap, BusinessAvailability[j], ArtAvailability[j], DramaAvailability[j], DanceAvailability[j], MusicAvailability[j], ComSciAvailability[j], TechAvailability[j]);
                    if ("".equals(choices[i][j]))
                    {
                        ThirdChoice thirdchoice = new ThirdChoice();
                        choices[i][j] = thirdchoice.third(responses[i + 18][j], BusinessCap[i], ArtCap[i], DramaCap[i], DanceCap[i], MusicCap[i], ComSciCap[i], TechCap[i], MaxBusinessCap, MaxArtCap, MaxDramaCap, MaxDanceCap, MaxMusicCap, MaxComSciCap, MaxTechCap, BusinessAvailability[j], ArtAvailability[j], DramaAvailability[j], DanceAvailability[j], MusicAvailability[j], ComSciAvailability[j], TechAvailability[j]);
                        if ("".equals(choices[i][j]))
                        {
                            FourthChoice fourthchoice = new FourthChoice();
                            choices[i][j] = fourthchoice.fourth(responses[i + 19][j], BusinessCap[i], ArtCap[i], DramaCap[i], DanceCap[i], MusicCap[i], ComSciCap[i], TechCap[i], MaxBusinessCap, MaxArtCap, MaxDramaCap, MaxDanceCap, MaxMusicCap, MaxComSciCap, MaxTechCap, BusinessAvailability[j], ArtAvailability[j], DramaAvailability[j], DanceAvailability[j], MusicAvailability[j], ComSciAvailability[j], TechAvailability[j]);
                            if ("".equals(choices[i][j]))
                            {
                                FifthChoice fifthchoice = new FifthChoice();
                                choices[i][j] = fifthchoice.fifth(responses[i + 20][j], BusinessCap[i], ArtCap[i], DramaCap[i], DanceCap[i], MusicCap[i], ComSciCap[i], TechCap[i], MaxBusinessCap, MaxArtCap, MaxDramaCap, MaxDanceCap, MaxMusicCap, MaxComSciCap, MaxTechCap, BusinessAvailability[j], ArtAvailability[j], DramaAvailability[j], DanceAvailability[j], MusicAvailability[j], ComSciAvailability[j], TechAvailability[j]);
                                if ("".equals(choices[i][j]))
                                {
                                    SixthChoice sixthchoice = new SixthChoice();
                                    choices[i][j] = sixthchoice.sixth(responses[i + 21][j], BusinessCap[i], ArtCap[i], DramaCap[i], DanceCap[i], MusicCap[i], ComSciCap[i], TechCap[i], MaxBusinessCap, MaxArtCap, MaxDramaCap, MaxDanceCap, MaxMusicCap, MaxComSciCap, MaxTechCap, BusinessAvailability[j], ArtAvailability[j], DramaAvailability[j], DanceAvailability[j], MusicAvailability[j], ComSciAvailability[j], TechAvailability[j]);
                                    if ("".equals(choices[i][j]))
                                    {
                                        SeventhChoice seventhchoice = new SeventhChoice();
                                        choices[i][j] = seventhchoice.seventh(responses[i + 22][j], BusinessCap[i], ArtCap[i], DramaCap[i], DanceCap[i], MusicCap[i], ComSciCap[i], TechCap[i], MaxBusinessCap, MaxArtCap, MaxDramaCap, MaxDanceCap, MaxMusicCap, MaxComSciCap, MaxTechCap, BusinessAvailability[j], ArtAvailability[j], DramaAvailability[j], DanceAvailability[j], MusicAvailability[j], ComSciAvailability[j], TechAvailability[j]);
                                    }
                                }
                            }
                        }
                    }

                    if ("Business Technology".equals(choices[i][j]))
                    {
                        BusinessCap[i]++;
                        BusinessAvailability[j] = 1;
                    }
                    else if ("Visual Arts".equals(choices[i][j]))
                    {
                        ArtCap[i]++;
                        ArtAvailability[j] = 1;
                    }
                    else if ("Drama".equals(choices[i][j]))
                    {
                        DramaCap[i]++;
                        DramaAvailability[j] = 1;
                    }
                    else if ("Dance".equals(choices[i][j]))
                    {
                        DanceCap[i]++;
                        DanceAvailability[j] = 1;
                    }
                    else if ("Music".equals(choices[i][j]))
                    {
                        MusicCap[i]++;
                        MusicAvailability[j] = 1;
                    }
                    else if ("Computer Studies".equals(choices[i][j]))
                    {
                        ComSciCap[i]++;
                        ComSciAvailability[j] = 1;
                    }
                    else if ("Exploring Technologies".equals(choices[i][j]))
                    {
                        TechCap[i]++;
                        TechAvailability[j] = 1;
                    }
                }
            }
            else if (responses[i + 16][j].equals("Computer Studies"))
            {
                if (ComSciAvailability[j] == 0)
                {
                    //System.out.println(ComSciAvailability[j]);
                    if (ComSciCap[i] < MaxComSciCap)
                    {
                        choices[i][j] = responses[i + 16][j];
                        ComSciCap[i]++;
                        ComSciAvailability[j] = 1;
                    }
                    else if (ComSciCap[i] == MaxComSciCap)
                    {
                        SecondChoice secondchoice = new SecondChoice();
                        choices[i][j] = secondchoice.second(responses[i + 17][j], BusinessCap[i], ArtCap[i], DramaCap[i], DanceCap[i], MusicCap[i], ComSciCap[i], TechCap[i], MaxBusinessCap, MaxArtCap, MaxDramaCap, MaxDanceCap, MaxMusicCap, MaxComSciCap, MaxTechCap, BusinessAvailability[j], ArtAvailability[j], DramaAvailability[j], DanceAvailability[j], MusicAvailability[j], ComSciAvailability[j], TechAvailability[j]);
                        if (choices[i][j].equals(""))
                        {
                            ThirdChoice thirdchoice = new ThirdChoice();
                            choices[i][j] = thirdchoice.third(responses[i + 18][j], BusinessCap[i], ArtCap[i], DramaCap[i], DanceCap[i], MusicCap[i], ComSciCap[i], TechCap[i], MaxBusinessCap, MaxArtCap, MaxDramaCap, MaxDanceCap, MaxMusicCap, MaxComSciCap, MaxTechCap, BusinessAvailability[j], ArtAvailability[j], DramaAvailability[j], DanceAvailability[j], MusicAvailability[j], ComSciAvailability[j], TechAvailability[j]);
                            if ("".equals(choices[i][j]))
                            {
                                FourthChoice fourthchoice = new FourthChoice();
                                choices[i][j] = fourthchoice.fourth(responses[i + 19][j], BusinessCap[i], ArtCap[i], DramaCap[i], DanceCap[i], MusicCap[i], ComSciCap[i], TechCap[i], MaxBusinessCap, MaxArtCap, MaxDramaCap, MaxDanceCap, MaxMusicCap, MaxComSciCap, MaxTechCap, BusinessAvailability[j], ArtAvailability[j], DramaAvailability[j], DanceAvailability[j], MusicAvailability[j], ComSciAvailability[j], TechAvailability[j]);
                                if ("".equals(choices[i][j]))
                                {
                                    FifthChoice fifthchoice = new FifthChoice();
                                    choices[i][j] = fifthchoice.fifth(responses[i + 20][j], BusinessCap[i], ArtCap[i], DramaCap[i], DanceCap[i], MusicCap[i], ComSciCap[i], TechCap[i], MaxBusinessCap, MaxArtCap, MaxDramaCap, MaxDanceCap, MaxMusicCap, MaxComSciCap, MaxTechCap, BusinessAvailability[j], ArtAvailability[j], DramaAvailability[j], DanceAvailability[j], MusicAvailability[j], ComSciAvailability[j], TechAvailability[j]);
                                    if ("".equals(choices[i][j]))
                                    {
                                        SixthChoice sixthchoice = new SixthChoice();
                                        choices[i][j] = sixthchoice.sixth(responses[i + 21][j], BusinessCap[i], ArtCap[i], DramaCap[i], DanceCap[i], MusicCap[i], ComSciCap[i], TechCap[i], MaxBusinessCap, MaxArtCap, MaxDramaCap, MaxDanceCap, MaxMusicCap, MaxComSciCap, MaxTechCap, BusinessAvailability[j], ArtAvailability[j], DramaAvailability[j], DanceAvailability[j], MusicAvailability[j], ComSciAvailability[j], TechAvailability[j]);
                                        if ("".equals(choices[i][j]))
                                        {
                                            SeventhChoice seventhchoice = new SeventhChoice();
                                            choices[i][j] = seventhchoice.seventh(responses[i + 22][j], BusinessCap[i], ArtCap[i], DramaCap[i], DanceCap[i], MusicCap[i], ComSciCap[i], TechCap[i], MaxBusinessCap, MaxArtCap, MaxDramaCap, MaxDanceCap, MaxMusicCap, MaxComSciCap, MaxTechCap, BusinessAvailability[j], ArtAvailability[j], DramaAvailability[j], DanceAvailability[j], MusicAvailability[j], ComSciAvailability[j], TechAvailability[j]);
                                        }
                                    }
                                }
                            }
                        }

                        if ("Business Technology".equals(choices[i][j]))
                        {
                            BusinessCap[i]++;
                            BusinessAvailability[j] = 1;
                        }
                        else if ("Visual Arts".equals(choices[i][j]))
                        {
                            ArtCap[i]++;
                            ArtAvailability[j] = 1;
                        }
                        else if ("Drama".equals(choices[i][j]))
                        {
                            DramaCap[i]++;
                            DramaAvailability[j] = 1;
                        }
                        else if ("Dance".equals(choices[i][j]))
                        {
                            DanceCap[i]++;
                            DanceAvailability[j] = 1;
                        }
                        else if ("Music".equals(choices[i][j]))
                        {
                            MusicCap[i]++;
                            MusicAvailability[j] = 1;
                        }
                        else if ("Computer Studies".equals(choices[i][j]))
                        {
                            ComSciCap[i]++;
                            ComSciAvailability[j] = 1;
                        }
                        else if ("Exploring Technologies".equals(choices[i][j]))
                        {
                            TechCap[i]++;
                            TechAvailability[j] = 1;
                        }
                        System.out.println(BusinessCap[i] +"\n"+ ArtCap[i] +"\n"+ DramaCap[i] +"\n"+ DanceCap[i] +"\n"+ MusicCap[i] +"\n"+ ComSciCap[i] +"\n"+ TechCap[i]);
                    }
                }
                else
                {
                    SecondChoice secondchoice = new SecondChoice();
                    choices[i][j] = secondchoice.second(responses[i + 17][j], BusinessCap[i], ArtCap[i], DramaCap[i], DanceCap[i], MusicCap[i], ComSciCap[i], TechCap[i], MaxBusinessCap, MaxArtCap, MaxDramaCap, MaxDanceCap, MaxMusicCap, MaxComSciCap, MaxTechCap, BusinessAvailability[j], ArtAvailability[j], DramaAvailability[j], DanceAvailability[j], MusicAvailability[j], ComSciAvailability[j], TechAvailability[j]);
                    if ("".equals(choices[i][j]))
                    {
                        ThirdChoice thirdchoice = new ThirdChoice();
                        choices[i][j] = thirdchoice.third(responses[i + 18][j], BusinessCap[i], ArtCap[i], DramaCap[i], DanceCap[i], MusicCap[i], ComSciCap[i], TechCap[i], MaxBusinessCap, MaxArtCap, MaxDramaCap, MaxDanceCap, MaxMusicCap, MaxComSciCap, MaxTechCap, BusinessAvailability[j], ArtAvailability[j], DramaAvailability[j], DanceAvailability[j], MusicAvailability[j], ComSciAvailability[j], TechAvailability[j]);
                        if ("".equals(choices[i][j]))
                        {
                            FourthChoice fourthchoice = new FourthChoice();
                            choices[i][j] = fourthchoice.fourth(responses[i + 19][j], BusinessCap[i], ArtCap[i], DramaCap[i], DanceCap[i], MusicCap[i], ComSciCap[i], TechCap[i], MaxBusinessCap, MaxArtCap, MaxDramaCap, MaxDanceCap, MaxMusicCap, MaxComSciCap, MaxTechCap, BusinessAvailability[j], ArtAvailability[j], DramaAvailability[j], DanceAvailability[j], MusicAvailability[j], ComSciAvailability[j], TechAvailability[j]);
                            if ("".equals(choices[i][j]))
                            {
                                FifthChoice fifthchoice = new FifthChoice();
                                choices[i][j] = fifthchoice.fifth(responses[i + 20][j], BusinessCap[i], ArtCap[i], DramaCap[i], DanceCap[i], MusicCap[i], ComSciCap[i], TechCap[i], MaxBusinessCap, MaxArtCap, MaxDramaCap, MaxDanceCap, MaxMusicCap, MaxComSciCap, MaxTechCap, BusinessAvailability[j], ArtAvailability[j], DramaAvailability[j], DanceAvailability[j], MusicAvailability[j], ComSciAvailability[j], TechAvailability[j]);
                                if ("".equals(choices[i][j]))
                                {
                                    SixthChoice sixthchoice = new SixthChoice();
                                    choices[i][j] = sixthchoice.sixth(responses[i + 21][j], BusinessCap[i], ArtCap[i], DramaCap[i], DanceCap[i], MusicCap[i], ComSciCap[i], TechCap[i], MaxBusinessCap, MaxArtCap, MaxDramaCap, MaxDanceCap, MaxMusicCap, MaxComSciCap, MaxTechCap, BusinessAvailability[j], ArtAvailability[j], DramaAvailability[j], DanceAvailability[j], MusicAvailability[j], ComSciAvailability[j], TechAvailability[j]);
                                    if ("".equals(choices[i][j]))
                                    {
                                        SeventhChoice seventhchoice = new SeventhChoice();
                                        choices[i][j] = seventhchoice.seventh(responses[i + 22][j], BusinessCap[i], ArtCap[i], DramaCap[i], DanceCap[i], MusicCap[i], ComSciCap[i], TechCap[i], MaxBusinessCap, MaxArtCap, MaxDramaCap, MaxDanceCap, MaxMusicCap, MaxComSciCap, MaxTechCap, BusinessAvailability[j], ArtAvailability[j], DramaAvailability[j], DanceAvailability[j], MusicAvailability[j], ComSciAvailability[j], TechAvailability[j]);
                                    }
                                }
                            }
                        }
                    }

                    if ("Business Technology".equals(choices[i][j]))
                    {
                        BusinessCap[i]++;
                        BusinessAvailability[j] = 1;
                    }
                    else if ("Visual Arts".equals(choices[i][j]))
                    {
                        ArtCap[i]++;
                        ArtAvailability[j] = 1;
                    }
                    else if ("Drama".equals(choices[i][j]))
                    {
                        DramaCap[i]++;
                        DramaAvailability[j] = 1;
                    }
                    else if ("Dance".equals(choices[i][j]))
                    {
                        DanceCap[i]++;
                        DanceAvailability[j] = 1;
                    }
                    else if ("Music".equals(choices[i][j]))
                    {
                        MusicCap[i]++;
                        MusicAvailability[j] = 1;
                    }
                    else if ("Computer Studies".equals(choices[i][j]))
                    {
                        ComSciCap[i]++;
                        ComSciAvailability[j] = 1;
                    }
                    else if ("Exploring Technologies".equals(choices[i][j]))
                    {
                        TechCap[i]++;
                        TechAvailability[j] = 1;
                    }
                }
            }
            else if (responses[i + 16][j].equals("Exploring Technologies"))
            {
                if (TechAvailability[j] == 0)
                {
                    if (TechCap[i] < MaxTechCap)
                    {
                        choices[i][j] = responses[i + 16][j];
                        TechCap[i]++;
                        TechAvailability[j] = 1;
                    }
                    else if (TechCap[i] == MaxTechCap)
                    {
                        SecondChoice secondchoice = new SecondChoice();
                        choices[i][j] = secondchoice.second(responses[i + 17][j], BusinessCap[i], ArtCap[i], DramaCap[i], DanceCap[i], MusicCap[i], ComSciCap[i], TechCap[i], MaxBusinessCap, MaxArtCap, MaxDramaCap, MaxDanceCap, MaxMusicCap, MaxComSciCap, MaxTechCap, BusinessAvailability[j], ArtAvailability[j], DramaAvailability[j], DanceAvailability[j], MusicAvailability[j], ComSciAvailability[j], TechAvailability[j]);
                        if ("".equals(choices[i][j]))
                        {
                            ThirdChoice thirdchoice = new ThirdChoice();
                            choices[i][j] = thirdchoice.third(responses[i + 18][j], BusinessCap[i], ArtCap[i], DramaCap[i], DanceCap[i], MusicCap[i], ComSciCap[i], TechCap[i], MaxBusinessCap, MaxArtCap, MaxDramaCap, MaxDanceCap, MaxMusicCap, MaxComSciCap, MaxTechCap, BusinessAvailability[j], ArtAvailability[j], DramaAvailability[j], DanceAvailability[j], MusicAvailability[j], ComSciAvailability[j], TechAvailability[j]);
                            if ("".equals(choices[i][j]))
                            {
                                FourthChoice fourthchoice = new FourthChoice();
                                choices[i][j] = fourthchoice.fourth(responses[i + 19][j], BusinessCap[i], ArtCap[i], DramaCap[i], DanceCap[i], MusicCap[i], ComSciCap[i], TechCap[i], MaxBusinessCap, MaxArtCap, MaxDramaCap, MaxDanceCap, MaxMusicCap, MaxComSciCap, MaxTechCap, BusinessAvailability[j], ArtAvailability[j], DramaAvailability[j], DanceAvailability[j], MusicAvailability[j], ComSciAvailability[j], TechAvailability[j]);
                                if ("".equals(choices[i][j]))
                                {
                                    FifthChoice fifthchoice = new FifthChoice();
                                    choices[i][j] = fifthchoice.fifth(responses[i + 20][j], BusinessCap[i], ArtCap[i], DramaCap[i], DanceCap[i], MusicCap[i], ComSciCap[i], TechCap[i], MaxBusinessCap, MaxArtCap, MaxDramaCap, MaxDanceCap, MaxMusicCap, MaxComSciCap, MaxTechCap, BusinessAvailability[j], ArtAvailability[j], DramaAvailability[j], DanceAvailability[j], MusicAvailability[j], ComSciAvailability[j], TechAvailability[j]);
                                    if ("".equals(choices[i][j]))
                                    {
                                        SixthChoice sixthchoice = new SixthChoice();
                                        choices[i][j] = sixthchoice.sixth(responses[i + 21][j], BusinessCap[i], ArtCap[i], DramaCap[i], DanceCap[i], MusicCap[i], ComSciCap[i], TechCap[i], MaxBusinessCap, MaxArtCap, MaxDramaCap, MaxDanceCap, MaxMusicCap, MaxComSciCap, MaxTechCap, BusinessAvailability[j], ArtAvailability[j], DramaAvailability[j], DanceAvailability[j], MusicAvailability[j], ComSciAvailability[j], TechAvailability[j]);
                                        if ("".equals(choices[i][j]))
                                        {
                                            SeventhChoice seventhchoice = new SeventhChoice();
                                            choices[i][j] = seventhchoice.seventh(responses[i + 22][j], BusinessCap[i], ArtCap[i], DramaCap[i], DanceCap[i], MusicCap[i], ComSciCap[i], TechCap[i], MaxBusinessCap, MaxArtCap, MaxDramaCap, MaxDanceCap, MaxMusicCap, MaxComSciCap, MaxTechCap, BusinessAvailability[j], ArtAvailability[j], DramaAvailability[j], DanceAvailability[j], MusicAvailability[j], ComSciAvailability[j], TechAvailability[j]);
                                        }
                                    }
                                }
                            }
                        }

                        if ("Business Technology".equals(choices[i][j]))
                        {
                            BusinessCap[i]++;
                            BusinessAvailability[j] = 1;
                        }
                        else if ("Visual Arts".equals(choices[i][j]))
                        {
                            ArtCap[i]++;
                            ArtAvailability[j] = 1;
                        }
                        else if ("Drama".equals(choices[i][j]))
                        {
                            DramaCap[i]++;
                            DramaAvailability[j] = 1;
                        }
                        else if ("Dance".equals(choices[i][j]))
                        {
                            DanceCap[i]++;
                            DanceAvailability[j] = 1;
                        }
                        else if ("Music".equals(choices[i][j]))
                        {
                            MusicCap[i]++;
                            MusicAvailability[j] = 1;
                        }
                        else if ("Computer Studies".equals(choices[i][j]))
                        {
                            ComSciCap[i]++;
                            ComSciAvailability[j] = 1;
                        }
                        else if ("Exploring Technologies".equals(choices[i][j]))
                        {
                            TechCap[i]++;
                            TechAvailability[j] = 1;
                        }
                        System.out.println(BusinessCap[i] +"\n"+ ArtCap[i] +"\n"+ DramaCap[i] +"\n"+ DanceCap[i] +"\n"+ MusicCap[i] +"\n"+ ComSciCap[i] +"\n"+ TechCap[i]);
                    }
                }
                else
                {
                    SecondChoice secondchoice = new SecondChoice();
                    choices[i][j] = secondchoice.second(responses[i + 17][j], BusinessCap[i], ArtCap[i], DramaCap[i], DanceCap[i], MusicCap[i], ComSciCap[i], TechCap[i], MaxBusinessCap, MaxArtCap, MaxDramaCap, MaxDanceCap, MaxMusicCap, MaxComSciCap, MaxTechCap, BusinessAvailability[j], ArtAvailability[j], DramaAvailability[j], DanceAvailability[j], MusicAvailability[j], ComSciAvailability[j], TechAvailability[j]);
                    if ("".equals(choices[i][j]))
                    {
                        ThirdChoice thirdchoice = new ThirdChoice();
                        choices[i][j] = thirdchoice.third(responses[i + 18][j], BusinessCap[i], ArtCap[i], DramaCap[i], DanceCap[i], MusicCap[i], ComSciCap[i], TechCap[i], MaxBusinessCap, MaxArtCap, MaxDramaCap, MaxDanceCap, MaxMusicCap, MaxComSciCap, MaxTechCap, BusinessAvailability[j], ArtAvailability[j], DramaAvailability[j], DanceAvailability[j], MusicAvailability[j], ComSciAvailability[j], TechAvailability[j]);
                        if ("".equals(choices[i][j]))
                        {
                            FourthChoice fourthchoice = new FourthChoice();
                            choices[i][j] = fourthchoice.fourth(responses[i + 19][j], BusinessCap[i], ArtCap[i], DramaCap[i], DanceCap[i], MusicCap[i], ComSciCap[i], TechCap[i], MaxBusinessCap, MaxArtCap, MaxDramaCap, MaxDanceCap, MaxMusicCap, MaxComSciCap, MaxTechCap, BusinessAvailability[j], ArtAvailability[j], DramaAvailability[j], DanceAvailability[j], MusicAvailability[j], ComSciAvailability[j], TechAvailability[j]);
                            if ("".equals(choices[i][j]))
                            {
                                FifthChoice fifthchoice = new FifthChoice();
                                choices[i][j] = fifthchoice.fifth(responses[i + 20][j], BusinessCap[i], ArtCap[i], DramaCap[i], DanceCap[i], MusicCap[i], ComSciCap[i], TechCap[i], MaxBusinessCap, MaxArtCap, MaxDramaCap, MaxDanceCap, MaxMusicCap, MaxComSciCap, MaxTechCap, BusinessAvailability[j], ArtAvailability[j], DramaAvailability[j], DanceAvailability[j], MusicAvailability[j], ComSciAvailability[j], TechAvailability[j]);
                                if ("".equals(choices[i][j]))
                                {
                                    SixthChoice sixthchoice = new SixthChoice();
                                    choices[i][j] = sixthchoice.sixth(responses[i + 21][j], BusinessCap[i], ArtCap[i], DramaCap[i], DanceCap[i], MusicCap[i], ComSciCap[i], TechCap[i], MaxBusinessCap, MaxArtCap, MaxDramaCap, MaxDanceCap, MaxMusicCap, MaxComSciCap, MaxTechCap, BusinessAvailability[j], ArtAvailability[j], DramaAvailability[j], DanceAvailability[j], MusicAvailability[j], ComSciAvailability[j], TechAvailability[j]);
                                    if ("".equals(choices[i][j]))
                                    {
                                        SeventhChoice seventhchoice = new SeventhChoice();
                                        choices[i][j] = seventhchoice.seventh(responses[i + 22][j], BusinessCap[i], ArtCap[i], DramaCap[i], DanceCap[i], MusicCap[i], ComSciCap[i], TechCap[i], MaxBusinessCap, MaxArtCap, MaxDramaCap, MaxDanceCap, MaxMusicCap, MaxComSciCap, MaxTechCap, BusinessAvailability[j], ArtAvailability[j], DramaAvailability[j], DanceAvailability[j], MusicAvailability[j], ComSciAvailability[j], TechAvailability[j]);
                                    }
                                }
                            }
                        }
                    }

                    if ("Business Technology".equals(choices[i][j]))
                    {
                        BusinessCap[i]++;
                        BusinessAvailability[j] = 1;
                    }
                    else if ("Visual Arts".equals(choices[i][j]))
                    {
                        ArtCap[i]++;
                        ArtAvailability[j] = 1;
                    }
                    else if ("Drama".equals(choices[i][j]))
                    {
                        DramaCap[i]++;
                        DramaAvailability[j] = 1;
                    }
                    else if ("Dance".equals(choices[i][j]))
                    {
                        DanceCap[i]++;
                        DanceAvailability[j] = 1;
                    }
                    else if ("Music".equals(choices[i][j]))
                    {
                        MusicCap[i]++;
                        MusicAvailability[j] = 1;
                    }
                    else if ("Computer Studies".equals(choices[i][j]))
                    {
                        ComSciCap[i]++;
                        ComSciAvailability[j] = 1;
                    }
                    else if ("Exploring Technologies".equals(choices[i][j]))
                    {
                        TechCap[i]++;
                        TechAvailability[j] = 1;
                    }
                }
            }
            System.out.println(choices[i][j]);
        }
    
        System.out.println("\n");
    }
    
       wrk1.close();
    }
}