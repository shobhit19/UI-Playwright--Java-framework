package com.org.ui.auto.utils;

import com.org.ui.auto.exceptions.ConvertImageToByteException;
import com.org.ui.auto.exceptions.FileConnectionClosedException;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public final class VisualTestUtil {

    private VisualTestUtil(){}

    public static void encodePicture(String path){

        String encodedImage = null;
        encodedImage = Base64.getEncoder().encodeToString(getByteImageData(path));
        writeImageDataInToFile(encodedImage,"data.txt");

    }
    private static byte[] getByteImageData(String path)  {
        byte[] imageData = null;
        FileInputStream fis = null;
        try {
            File file = new File(path);
            fis = new FileInputStream(file);
            imageData = new byte[(int) file.length()];
            fis.read(imageData);

        } catch (Exception e) {
                throw new ConvertImageToByteException("**** unable to convert byte stream from snapshot file ****");
        } finally {
            try {
                fis.close();
            }
            catch (Exception e){
                throw new FileConnectionClosedException("**** some issue in closing the file connection ****");
            }
        }
        return imageData;
    }
    private static void writeImageDataInToFile(String data,String fileName){
        try {
            FileUtils.write(new File(fileName), data, StandardCharsets.UTF_8);
        }
        catch (Exception e){}
    }
    public static String getImageDataFromSavedFile(){
        try {
            return FileUtils.readFileToString(new File("data.txt"), StandardCharsets.UTF_8);
        }
        catch(Exception e){

        }
        return null;
    }
}
