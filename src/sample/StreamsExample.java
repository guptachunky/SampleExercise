package sample;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class StreamsExample {

	public static void main(String... args) throws IOException {
		StreamsExample streamsExample = new StreamsExample();
//		streamsExample.copyFileByteStream();
//		streamsExample.copyFileCharacterStream();
		streamsExample.copyFileBufferedStream();
	}


	public void copyFileByteStream() throws IOException {
		FileInputStream in = null;
		FileOutputStream out = null;

		try {
			in = new FileInputStream("/home/ttn/input.txt");
			out = new FileOutputStream("/home/ttn/output.txt");

			int c;
			while ((c = in.read()) != -1) {
				out.write(c);
			}
		} finally {
			if (in != null) {
				in.close();
			}
			if (out != null) {
				out.close();
			}
		}
	}

	public void copyFileCharacterStream() throws IOException {
		FileReader in = null;
		FileWriter out = null;

		try {
			in = new FileReader("/home/ttn/input.txt");
			out = new FileWriter("/home/ttn/output.txt");

			int c;
			while ((c = in.read()) != -1) {
				out.write(c);
			}
		} finally {
			if (in != null) {
				in.close();
			}
			if (out != null) {
				out.close();
			}
		}
	}
	
	public void copyFileBufferedStream() throws IOException {
		BufferedInputStream bufferedInputStream = null;
		BufferedOutputStream bufferedOutputStream = null;

		try {
			bufferedInputStream = new BufferedInputStream(new FileInputStream(new File("/home/ttn/input.txt")));
			bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File("/home/ttn/output.txt")));

			int numBytes;
			byte[] buffer = new byte[1000];
	        while ((numBytes = bufferedInputStream.read(buffer))!= -1)
	        {
	        	bufferedOutputStream.write(buffer, 0, numBytes);
	        }
	        //bos.flush();
	        //bos.write("\u001a");

	        bufferedInputStream.close();
	        bufferedOutputStream.close();
		} finally {
			if (bufferedInputStream != null) {
				bufferedInputStream.close();
			}
			if (bufferedOutputStream != null) {
				bufferedOutputStream.close();
			}
		}
	}
	
	
}