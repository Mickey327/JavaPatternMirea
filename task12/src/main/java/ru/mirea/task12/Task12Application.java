package ru.mirea.task12;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;

@SpringBootApplication
public class Task12Application implements CommandLineRunner {
	private FileManager fileManager;

	@Autowired
	public void setFileManager(FileManager fileManager){
		this.fileManager = fileManager;
	}

	public static void main(String[] args) {
		for(String arg:args) {
			System.out.println(arg);
		}
		SpringApplication.run(Task12Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		if (args.length == 2){
			fileManager.execute(args[0], args[1]);
		}
		else
			fileManager.hashFile();
	}
}
