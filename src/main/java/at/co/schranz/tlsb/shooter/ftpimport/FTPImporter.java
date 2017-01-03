package at.co.schranz.tlsb.shooter.ftpimport;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.springframework.stereotype.Service;

@Service
public class FTPImporter {
	private String hostname;
	private String username;
	private String password;
	private String pathname;
	
	public File loadFiles(){

		FTPClient client = new FTPClient();
		
	    try {
	        client.connect(hostname);
	        client.login(username, password);
	
	        client.changeWorkingDirectory(pathname);        
	        FTPFile[] ftpFiles = client.listFiles();
	        for (FTPFile ftpFile : ftpFiles) {
	            // Check if FTPFile is a regular file
	            if (ftpFile.getType() == FTPFile.FILE_TYPE) {	                
	                if(ftpFile.getName().endsWith(".csv")){
	                	OutputStream output = new FileOutputStream(ftpFile.getName());
	                    //get the file from the remote system
	                    client.retrieveFile(ftpFile.getName(), output);
	                    //close output stream
	                    output.close();
	                    File file = new File(ftpFile.getName());
	                    return file;
	                }
	            }
	        }
	        client.logout();
	    } catch (IOException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            client.disconnect();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	    
	    return null;
	}
	
	
	public String getHostname() {
		return hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPathname() {
		return pathname;
	}

	public void setPathname(String pathname) {
		this.pathname = pathname;
	}
}
