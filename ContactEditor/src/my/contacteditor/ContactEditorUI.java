/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.contacteditor;

import java.awt.Component;
import java.io.File;
import javax.swing.JFileChooser;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;


import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import jxl.read.biff.BiffException;

import jxl.write.*;

/**
 *
 * @author S199715807
 */
public class ContactEditorUI extends javax.swing.JFrame {

    /**
     * Creates new form ContactEditorUI
     */
    public ContactEditorUI() {
        initComponents();
        next.setVisible(false);
  
    }
    

    public void excelrun()throws BiffException, IOException, WriteException{
        
try{
            
        //Importing Spreadsheet
      
      Workbook wrk1 =  Workbook.getWorkbook(new File(Filetextbar.getText()));
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
    
    
    int MaxArtCap=(int) artspinner.getValue();
    int MaxBusinessCap=(int) businessspinner.getValue();
    int MaxComSciCap=(int) comscispinner.getValue();
    int MaxDanceCap=(int) dancespinner.getValue();
    int MaxDramaCap=(int) dramaspinner.getValue();
    int MaxMusicCap=(int) musicspinner.getValue();
    int MaxTechCap=(int) techspinner.getValue();
    
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
    
    JFileChooser FileSaver = new JFileChooser();
 
    // show file saver and saves file
    FileSaver.setDialogTitle("Specify a file to save");   

    int userSelection = FileSaver.showSaveDialog(this);

    if (userSelection == JFileChooser.APPROVE_OPTION) {
        File fileToSave = FileSaver.getSelectedFile();
        String savefilename=fileToSave.getAbsolutePath();
        Filetextbar1.setText("" + savefilename);

        // export the file
         exportExl(choices, responses,fileToSave);   
        // opens dialog box to show desination file 
         dialog.setVisible(true);
    }
    }// end of try statement at the top
 //if the program breaks since the sessions don't align, keep running
catch(Exception e){
 excelrun();    
}
    }
    public static void exportExl(String[][] selections, String[][] names, File filetextbar1) throws IOException,WriteException{
               
        try {

            WritableWorkbook workbook = Workbook.createWorkbook(new File((filetextbar1)+".xls"));
            workbook.createSheet("Sheet1", 0);
            WritableSheet ws = workbook.getSheet( 0 );
            
            Label l;
            Label r;
            
            for (int i = 0; i < selections.length; i++) {
                for (int j = 0; j < selections[i].length; j++) {
                    l = new Label( i+25, j, selections[i][j] );
                    ws.addCell( l );
                }
            }
            for (int i = 0; i < names.length; i++) {
                for (int j = 0; j < names[i].length; j++) {
                    r = new Label( i, j, names[i][j] );
                    ws.addCell( r );
                }
            }
            
            
            workbook.write();
            workbook.close();
        } catch (WriteException e) {

        } 

    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        FileSaver = new javax.swing.JFileChooser();
        dialog = new javax.swing.JDialog();
        Filetextbar1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        Bluebox = new javax.swing.JPanel();
        Title1 = new javax.swing.JLabel();
        Title2 = new javax.swing.JLabel();
        Blackbox = new javax.swing.JPanel();
        captotal = new javax.swing.JTextField();
        AYJlogo = new javax.swing.JLabel();
        importbutton = new javax.swing.JButton();
        Filetextbar = new javax.swing.JTextField();
        capTotal = new javax.swing.JFormattedTextField();
        help = new javax.swing.JButton();
        Techtext = new javax.swing.JTextField();
        artspinner = new javax.swing.JSpinner();
        businessspinner = new javax.swing.JSpinner();
        comscispinner = new javax.swing.JSpinner();
        dancespinner = new javax.swing.JSpinner();
        dramaspinner = new javax.swing.JSpinner();
        musicspinner = new javax.swing.JSpinner();
        techspinner = new javax.swing.JSpinner();
        Arttext = new javax.swing.JTextField();
        Businesstext = new javax.swing.JTextField();
        comscitext = new javax.swing.JTextField();
        Dancetext = new javax.swing.JTextField();
        totalstudenttext = new javax.swing.JTextField();
        Musictext = new javax.swing.JTextField();
        next = new javax.swing.JButton();
        Dramatext = new javax.swing.JTextField();
        totalStudents = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Errorbox = new javax.swing.JTextArea();
        jTextField1 = new javax.swing.JTextField();

        jInternalFrame1.setVisible(true);

        FileSaver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FileSaverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jInternalFrame1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(FileSaver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jInternalFrame1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(FileSaver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        dialog.setLocationRelativeTo(null);
        dialog.setAlwaysOnTop(true);
        dialog.setMinimumSize(new java.awt.Dimension(500, 260));
        dialog.setPreferredSize(new java.awt.Dimension(500, 260));
        dialog.setResizable(false);
        dialog.setType(java.awt.Window.Type.POPUP);
        dialog.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Filetextbar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Filetextbar1ActionPerformed(evt);
            }
        });
        dialog.getContentPane().add(Filetextbar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, 340, 30));

        jButton2.setText("OK");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        dialog.getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(173, 192, 153, 30));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/my/contacteditor/You-Did-It-Congratulations.png"))); // NOI18N
        dialog.getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 53, 500, -1));

        jTextField2.setEditable(false);
        jTextField2.setBackground(new java.awt.Color(187, 207, 218));
        dialog.getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 260));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("A.Y. Jackson Grade 8 Day Session Sorter");
        setBackground(new java.awt.Color(187, 207, 218));
        setFont(new java.awt.Font("Elkwood", 0, 48)); // NOI18N
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Bluebox.setBackground(new java.awt.Color(106, 159, 201));

        Title1.setFont(new java.awt.Font("Trajan Pro", 1, 34)); // NOI18N
        Title1.setForeground(new java.awt.Color(255, 255, 255));
        Title1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Title1.setText("AYJ Grade 8");

        Title2.setFont(new java.awt.Font("Trajan Pro", 1, 34)); // NOI18N
        Title2.setForeground(new java.awt.Color(255, 255, 255));
        Title2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Title2.setText("Session Organizer");

        javax.swing.GroupLayout BlueboxLayout = new javax.swing.GroupLayout(Bluebox);
        Bluebox.setLayout(BlueboxLayout);
        BlueboxLayout.setHorizontalGroup(
            BlueboxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BlueboxLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Title1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(Title2, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
        );
        BlueboxLayout.setVerticalGroup(
            BlueboxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BlueboxLayout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(Title1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Title2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        getContentPane().add(Bluebox, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 30, 390, 130));

        Blackbox.setBackground(new java.awt.Color(51, 0, 51));

        javax.swing.GroupLayout BlackboxLayout = new javax.swing.GroupLayout(Blackbox);
        Blackbox.setLayout(BlackboxLayout);
        BlackboxLayout.setHorizontalGroup(
            BlackboxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 390, Short.MAX_VALUE)
        );
        BlackboxLayout.setVerticalGroup(
            BlackboxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 130, Short.MAX_VALUE)
        );

        getContentPane().add(Blackbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 40, 390, 130));

        captotal.setEditable(false);
        captotal.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        captotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        captotal.setText("Cap Totals + 5");
        captotal.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        captotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                captotalActionPerformed(evt);
            }
        });
        getContentPane().add(captotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 200, 30));

        AYJlogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/my/contacteditor/newpackage/logo.png"))); // NOI18N
        AYJlogo.setMaximumSize(new java.awt.Dimension(10, 10));
        getContentPane().add(AYJlogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 290, 200));

        importbutton.setBackground(new java.awt.Color(204, 204, 204));
        importbutton.setText("Import");
        importbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importbuttonActionPerformed(evt);
            }
        });
        getContentPane().add(importbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 190, -1, 30));
        getContentPane().add(Filetextbar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 190, 340, 30));

        capTotal.setEditable(false);
        capTotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        capTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                capTotalActionPerformed(evt);
            }
        });
        getContentPane().add(capTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 200, 30));

        help.setBackground(new java.awt.Color(204, 204, 204));
        help.setText("Help");
        help.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpActionPerformed(evt);
            }
        });
        getContentPane().add(help, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 470, 100, 30));

        Techtext.setEditable(false);
        Techtext.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        Techtext.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Techtext.setText("Tech");
        Techtext.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        Techtext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TechtextActionPerformed(evt);
            }
        });
        getContentPane().add(Techtext, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 470, 340, 30));

        artspinner.setModel(new javax.swing.SpinnerNumberModel(30, 0, null, 1));
        getContentPane().add(artspinner, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 230, 60, 30));

        businessspinner.setModel(new javax.swing.SpinnerNumberModel(30, 0, null, 1));
        getContentPane().add(businessspinner, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 270, 60, 30));

        comscispinner.setModel(new javax.swing.SpinnerNumberModel(30, 0, null, 1));
        getContentPane().add(comscispinner, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 310, 60, 30));

        dancespinner.setModel(new javax.swing.SpinnerNumberModel(30, 0, null, 1));
        getContentPane().add(dancespinner, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 350, 60, 30));

        dramaspinner.setModel(new javax.swing.SpinnerNumberModel(30, 0, null, 1));
        getContentPane().add(dramaspinner, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 390, 60, 30));

        musicspinner.setModel(new javax.swing.SpinnerNumberModel(30, 0, null, 1));
        getContentPane().add(musicspinner, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 430, 60, 30));

        techspinner.setModel(new javax.swing.SpinnerNumberModel(30, 0, null, 1));
        getContentPane().add(techspinner, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 470, 60, 30));

        Arttext.setEditable(false);
        Arttext.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        Arttext.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Arttext.setText("Art");
        Arttext.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        Arttext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ArttextActionPerformed(evt);
            }
        });
        getContentPane().add(Arttext, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 230, 340, 30));

        Businesstext.setEditable(false);
        Businesstext.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        Businesstext.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Businesstext.setText("Business");
        Businesstext.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        Businesstext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BusinesstextActionPerformed(evt);
            }
        });
        getContentPane().add(Businesstext, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 270, 340, 30));

        comscitext.setEditable(false);
        comscitext.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        comscitext.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        comscitext.setText("Computer Science");
        comscitext.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        comscitext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comscitextActionPerformed(evt);
            }
        });
        getContentPane().add(comscitext, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 310, 340, 30));

        Dancetext.setEditable(false);
        Dancetext.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        Dancetext.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Dancetext.setText("Dance");
        Dancetext.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        Dancetext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DancetextActionPerformed(evt);
            }
        });
        getContentPane().add(Dancetext, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 350, 340, 30));

        totalstudenttext.setEditable(false);
        totalstudenttext.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        totalstudenttext.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        totalstudenttext.setText("Total Students");
        totalstudenttext.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        totalstudenttext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalstudenttextActionPerformed(evt);
            }
        });
        getContentPane().add(totalstudenttext, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 200, 30));

        Musictext.setEditable(false);
        Musictext.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        Musictext.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Musictext.setText("Music");
        Musictext.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        Musictext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MusictextActionPerformed(evt);
            }
        });
        getContentPane().add(Musictext, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 430, 340, 30));

        next.setBackground(new java.awt.Color(204, 204, 204));
        next.setText("Next >");
        next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextActionPerformed(evt);
            }
        });
        getContentPane().add(next, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 470, 100, 30));

        Dramatext.setEditable(false);
        Dramatext.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        Dramatext.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Dramatext.setText("Drama");
        Dramatext.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        Dramatext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DramatextActionPerformed(evt);
            }
        });
        getContentPane().add(Dramatext, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 390, 340, 30));

        totalStudents.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        totalStudents.setText("[PLEASE ENTER A NUMBER]");
        totalStudents.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalStudentsActionPerformed(evt);
            }
        });
        getContentPane().add(totalStudents, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 200, 30));

        Errorbox.setEditable(false);
        Errorbox.setColumns(20);
        Errorbox.setRows(5);
        Errorbox.setAutoscrolls(false);
        jScrollPane1.setViewportView(Errorbox);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 200, 110));

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(187, 207, 218));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 640, 510));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void importbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importbuttonActionPerformed
        boolean selected = false;
        try{
        JFileChooser chooser =new JFileChooser();
        // opens the file chooser
        chooser.showOpenDialog(null);
        // sets file name to variable called responses
        File responses=chooser.getSelectedFile();
        String filename=responses.getAbsolutePath();
        // sets the file into the text box to show user what file was selected
        Filetextbar.setText(filename);
        selected = true;
        }catch(NullPointerException e){
            selected = false;
            Errorbox.setText("Please select a file to import");
        }finally{
            
        }
        
        next.setVisible(selected);
        
            

    }//GEN-LAST:event_importbuttonActionPerformed

// action for clicking the help button
    private void helpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpActionPerformed
        try {
            //sets website to string called URL
            String URL ="https://docs.google.com/document/d/1co4tWsRIdgdlCs0DytrmPrZm_-bouyQ9mPmjwvC1U-I/edit?usp=sharing";
            java.awt.Desktop.getDesktop().browse(java.net.URI.create(URL));
        }
        catch (Exception e) {
      //      JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }//GEN-LAST:event_helpActionPerformed

    private void TechtextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TechtextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TechtextActionPerformed

    private void ArttextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ArttextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ArttextActionPerformed

    private void BusinesstextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BusinesstextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BusinesstextActionPerformed

    private void comscitextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comscitextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comscitextActionPerformed

    private void DancetextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DancetextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DancetextActionPerformed

    private void totalstudenttextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalstudenttextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalstudenttextActionPerformed

    private void MusictextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MusictextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MusictextActionPerformed

    private void nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextActionPerformed
        //gets info from spinners
        boolean run = false;
        int MaxArtCap=(int) artspinner.getValue();
        int MaxBusinessCap=(int) businessspinner.getValue();
        int MaxComSciCap=(int) comscispinner.getValue();
        int MaxDanceCap=(int) dancespinner.getValue();
        int MaxDramaCap=(int) dramaspinner.getValue();
        int MaxMusicCap=(int) musicspinner.getValue();
        int MaxTechCap=(int) techspinner.getValue();
        try
        {
         // gets info on how many students there are
        int numberStudents = Integer.parseInt(totalStudents.getText());    

        // sets classcap int
        int classcaptotal =MaxArtCap+MaxBusinessCap+MaxComSciCap+MaxDanceCap+MaxDramaCap+MaxMusicCap+MaxTechCap;
        //if user enters negative number create error
        if(numberStudents<0)
        {
              Errorbox.setText("An error has occured:\nPlease enter a postive number");
        } 
        // if the classcapttoal is less than the amount of students , create error
        // +5 so it gives students a better chance at getting their tops picks
        else if(classcaptotal<numberStudents+5)
        {
              Errorbox.setText("An error has occured: \nYour total class caps are less \nthan the total number of \nstudents");  
        }
   
        // otherwise, run the program and clear any error messages
        else 
        {
            Errorbox.setText("");
      //      int loading = integer.parseInt(); 
            run = true;
        }
        
        //sets the captotal to the total plus 5
        capTotal.setText(""+ classcaptotal+5);
        
        if (run==true){
            try {
                excelrun();
            } catch (BiffException ex) {
                Logger.getLogger(ContactEditorUI.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ContactEditorUI.class.getName()).log(Level.SEVERE, null, ex);
            } catch (WriteException ex) {
                Logger.getLogger(ContactEditorUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        }
        catch(Exception n){
             Errorbox.setText("An error has occured:\nPlease enter a number");
        }
    
        
        
        
    }//GEN-LAST:event_nextActionPerformed

    private void DramatextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DramatextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DramatextActionPerformed

    private void totalStudentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalStudentsActionPerformed

    }//GEN-LAST:event_totalStudentsActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //closes dialog box
        dialog.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void captotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_captotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_captotalActionPerformed

    private void capTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_capTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_capTotalActionPerformed

    private void FileSaverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FileSaverActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FileSaverActionPerformed

    private void Filetextbar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Filetextbar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Filetextbar1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])throws BiffException, IOException, WriteException {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ContactEditorUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ContactEditorUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ContactEditorUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ContactEditorUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ContactEditorUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AYJlogo;
    private javax.swing.JTextField Arttext;
    private javax.swing.JPanel Blackbox;
    private javax.swing.JPanel Bluebox;
    private javax.swing.JTextField Businesstext;
    private javax.swing.JTextField Dancetext;
    private javax.swing.JTextField Dramatext;
    private javax.swing.JTextArea Errorbox;
    private javax.swing.JFileChooser FileSaver;
    private javax.swing.JTextField Filetextbar;
    private javax.swing.JTextField Filetextbar1;
    private javax.swing.JTextField Musictext;
    private javax.swing.JTextField Techtext;
    private javax.swing.JLabel Title1;
    private javax.swing.JLabel Title2;
    private javax.swing.JSpinner artspinner;
    private javax.swing.JSpinner businessspinner;
    private javax.swing.JFormattedTextField capTotal;
    private javax.swing.JTextField captotal;
    private javax.swing.JSpinner comscispinner;
    private javax.swing.JTextField comscitext;
    private javax.swing.JSpinner dancespinner;
    private javax.swing.JDialog dialog;
    private javax.swing.JSpinner dramaspinner;
    private javax.swing.JButton help;
    public static javax.swing.JButton importbutton;
    private javax.swing.JButton jButton2;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JSpinner musicspinner;
    private javax.swing.JButton next;
    private javax.swing.JSpinner techspinner;
    private javax.swing.JFormattedTextField totalStudents;
    private javax.swing.JTextField totalstudenttext;
    // End of variables declaration//GEN-END:variables
}
