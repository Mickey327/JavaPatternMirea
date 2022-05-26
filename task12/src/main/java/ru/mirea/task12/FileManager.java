package ru.mirea.task12;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.xml.bind.DatatypeConverter;
import javax.xml.crypto.Data;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class FileManager {
    private File inputFile;
    private File outputFile;
    @Value("${inputFileName}")
    private String inputFileName;
    @Value("${outputFileName}")
    private String outputFileName;

    @PostConstruct
    public void init(){
        System.out.println("PostConstruct phase has began");
        inputFile = new File(inputFileName);
        outputFile = new File(outputFileName);
        System.out.println("End postConstruct");
        System.out.println(inputFile.getAbsolutePath());
        System.out.println(outputFile.getAbsolutePath());
    }
    public FileManager(){
        System.out.println("File Manager created");
    }


    public void hashFile() throws IOException, NoSuchAlgorithmException {
        System.out.println("Start hash");
        System.out.println(inputFile.getAbsolutePath());
        MessageDigest md = MessageDigest.getInstance("MD5");
        if (inputFile.exists()){
            System.out.println("Input file exists");
            String inputText = new String(Files.readAllBytes(Paths.get(inputFile.getAbsolutePath())));
            md.update(inputText.getBytes());
            byte[] digest = md.digest();
            String outputText = DatatypeConverter
                    .printHexBinary(digest);
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
            writer.write(outputText);
            writer.close();
        }
        else{
            md.update("null".getBytes());
            byte[] digest = md.digest();
            String outputText = DatatypeConverter
                    .printHexBinary(digest);
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
            writer.write(outputText);
            writer.close();
            System.out.println("Input file doesnt exist");

        }
        System.out.println("End hash");
    }
    public void execute(String inputFileName, String outputFileName) throws IOException, NoSuchAlgorithmException {
        this.inputFileName = inputFileName;
        this.outputFileName = outputFileName;
        hashFile();
    }

    @PreDestroy
    public void preDestroy() throws NoSuchAlgorithmException, IOException {
        System.out.println("End of work, preDestroy phase");
        inputFile.delete();


    }

}
