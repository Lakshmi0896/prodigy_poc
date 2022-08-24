package com.prodigy.utilities;

import java.io.*;
import java.util.*;

public class ReadPropertiesFile {
	public Properties readPropertiesFile(String filename) {
		FileInputStream fis = null;
		Properties prop = null;
		try {
			fis = new FileInputStream("properties/configuration.properties");
			prop = new Properties();
			prop.load(fis);
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
			}
		}
		return prop;
	}
}