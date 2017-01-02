package ftp;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.commons.io.FileUtils;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

import at.co.schranz.tlsb.shooter.ftpimport.FTPImporter;

public class FTPTest {
	public static void main(String[] args) {
		FTPImporter importer = new FTPImporter();
		File file = importer.loadFiles();
		if(!file.exists()){
			
		}
	}
	
//	public static void main(String[] args) {
//		FTPClient client = new FTPClient();
//		
//	    try {
//	        client.connect("sport-schuetzen.at");
//	        client.login("schuetz-kuf_adm", "lolemnoch@be25");
//	
//	        // Obtain a list of filenames in the current working
//	        // directory. When no file found an empty array will 
//	        // be returned.
//	        client.changeWorkingDirectory("rwk_data");
//	        
//	        String[] names = client.listNames();
//	        for (String name : names) {
//	            System.out.println("Name = " + name);
//	        }
//	
//	        
//	        FTPFile[] ftpFiles = client.listFiles();
//	        for (FTPFile ftpFile : ftpFiles) {
//	            // Check if FTPFile is a regular file
//	            if (ftpFile.getType() == FTPFile.FILE_TYPE) {
//	                System.out.println("FTPFile: " + ftpFile.getName() +
//	                        "; " + FileUtils.byteCountToDisplaySize(
//	                        ftpFile.getSize()));
//	                if(ftpFile.getName().endsWith(".csv")){
//	                	System.out.println("Download: " + ftpFile.getName());
//	                	OutputStream output;
//	                    output = new FileOutputStream("C://temp/" + ftpFile.getName());
//	                    //get the file from the remote system
//	                    client.retrieveFile(ftpFile.getName(), output);
//	                    //close output stream
//	                    output.close();
//	                }
//	            }
//	        }
//	        client.logout();
//	    } catch (IOException e) {
//	        e.printStackTrace();
//	    } finally {
//	        try {
//	            client.disconnect();
//	        } catch (IOException e) {
//	            e.printStackTrace();
//	        }
//	    }
//	}
}
