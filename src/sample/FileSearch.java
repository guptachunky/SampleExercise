package sample;

import java.io.File;

public class FileSearch {

	public static void main(String[] args) {
		File file = new File("/home/ttn");

		File[] internalFiles = file.listFiles();
		boolean found = false;
		for (File internalFile : internalFiles) {
			if (internalFile.getName().equals("inpuxzczct.txt")) {
				found = true;
				break;
			}
		}
		if(found) {
			System.out.println("Found");
		} else {
			System.out.println("Not Found");
		}
	}

}
