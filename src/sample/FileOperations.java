package sample;

import java.io.File;

import javax.swing.plaf.FileChooserUI;

public class FileOperations {

	public static void main(String... args) {
		FileOperations fileOperations = new FileOperations();
//		fileOperations.createDirectories("/home/ttn/folder1/folder2");
//		fileOperations.deleteFile("/home/ttn/input.txt");
		fileOperations.renameFile("/home/ttn/input.txt", "/home/ttn/new_input.txt");
	}
	
	
	private void createDirectories(String path){
		File file = new File(path);
		file.mkdirs();
	}
	
	private void deleteFile(String path){
		File file = new File(path);
		file.delete();
	}
	
	private void renameFile(String path, String newPath){
		File file = new File(path);
		
		File newFile = new File(newPath);
		file.renameTo(newFile);
	}
}
