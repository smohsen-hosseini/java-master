package com.javaMaster.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @Author Seyed Mohsen Hosseini
 * @Since 31 August 2022
 */

public class FileManipulation {
    private static final Logger logger = LogManager.getLogger(FileManipulation.class);

    private String decompressedFilePath = "src/main/resources/mockFile.txt"; //"mockFile.txt";
    private String compressedFilePath = "src/main/resources/mockFile.txt.zip";

    public FileManipulation() {

    }

    public boolean compressAndDecompressFile() {
        try {
            deleteFile(compressedFilePath);
            compressFile(decompressedFilePath, compressedFilePath);
            decompressFile(compressedFilePath, decompressedFilePath);
            return true;
        } catch (Exception ex) {
            logger.info("FileManipulation.compressFile() src.main.java.com.javaMaster.file {} compressed successfully!", compressedFilePath);
            return false;
        }
    }

    private Boolean compressFile(String inputFilePath, String compressedFilePath) {
        try {
            FileInputStream inputStream = new FileInputStream(inputFilePath);
            FileOutputStream outputStream = new FileOutputStream(compressedFilePath);
            DeflaterOutputStream compressor = new DeflaterOutputStream(outputStream);

            int contents;
            while ((contents = inputStream.read()) != -1) {
                compressor.write(contents);
            }
            compressor.close();
            logger.info("FileManipulation.compressFile() src.main.java.com.javaMaster.file {} compressed successfully!", compressedFilePath);
            return true;
        } catch (Exception ex) {
            logger.error("!!!! Exception in FileManipulation.compressFile() method! " + ex.getMessage());
            return false;
        }
    }

    private Boolean decompressFile(String compressedFilePath, String decompressedFilePath) {
        try {
            FileInputStream fis = new FileInputStream(compressedFilePath);
            FileOutputStream fos = new FileOutputStream(decompressedFilePath);
            InflaterInputStream iis = new InflaterInputStream(fis);

            int data;
            while ((data = iis.read()) != -1) {
                fos.write(data);
            }

            fos.close();
            iis.close();
            logger.info("FileManipulation.decompressFile() compressed src.main.java.com.javaMaster.file {} successfully decompressed to {}!", compressedFilePath, decompressedFilePath);
            return true;
        } catch (Exception ex) {
            logger.error("!!!! Exception in FileManipulation.decompressFile() method! " + ex.getMessage());
            return false;
        }
    }


    private Boolean deleteFile(String filePath) {
        try {
            File fileToDelete = new File(filePath);
            if (!fileToDelete.exists()) {
                logger.info("File '" + filePath + "' does not exists!");
                return false;
            }

            if (fileToDelete.delete())
                logger.info("File '" + filePath + "' deleted successfully");

            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
