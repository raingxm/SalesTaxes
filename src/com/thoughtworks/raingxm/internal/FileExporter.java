package com.thoughtworks.raingxm.internal;

import java.io.FileWriter;
import java.io.IOException;

import com.thoughtworks.raingxm.Exporter;

public class FileExporter implements Exporter  {
	FileWriter fileWriter = null;
	public FileExporter() {		
		try {
			fileWriter = new FileWriter("out.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void output(String words) {
		try {
			fileWriter.write(words + "\r\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void end() {
		try {
			if(fileWriter != null){
				fileWriter.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
