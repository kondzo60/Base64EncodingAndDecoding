package pl.balu.encoding;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.codec.binary.Base64;

public class Base64EncodingAndDecoding {
  
  public static void main(String[] args) {
    File file = new File("D:\\1.txt");
    
    try {
      /*
       * Reading a file from file system
       */
      FileInputStream inFile = new FileInputStream(file);
      byte fileData[] = new byte[(int)file.length()];
      inFile.read(fileData);
      
      /*
       * Converting file byte array into Base64 String 
       */
      String fileDataString = encodeFile(fileData);
      
      /*
       * Converting a Base64 String into file byte array 
       */
      byte[] fileByteArray = decodeFile(fileDataString);
      
      /*
       * Write a file byte array into file system  
       */
      FileOutputStream outFile = new FileOutputStream("D:\\2.txt");
      outFile.write(fileByteArray);
      
      inFile.close();
      outFile.close();
      
      System.out.println("File Successfully Manipulated!");
    } catch (FileNotFoundException e) {
      System.out.println("File not found" + e);
    } catch (IOException ioe) {
      System.out.println("Exception while reading the File " + ioe);
    }

  }
  
  /**
   * Encodes the byte array into base64 string
   * @param fileByteArray - byte array
   * @return String a {@link java.lang.String}
   */
  public static String encodeFile(byte[] fileByteArray){    
    return Base64.encodeBase64URLSafeString(fileByteArray);    
  }
  
  /**
   * Decodes the base64 string into byte array
   * @param fileDataString - a {@link java.lang.String} 
   * @return byte array
   */
  public static byte[] decodeFile(String fileDataString) {    
    return Base64.decodeBase64(fileDataString);
  }

}
