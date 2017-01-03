package at.co.schranz.tlsb.shooter.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import at.co.schranz.tlsb.shooter.model.Shooter;
import at.co.schranz.tlsb.shooter.model.dao.ShooterDao;
import at.generalsolutions.messaging.ActionType;
import at.generalsolutions.messaging.BaseMessageService;

@Service
public class ShooterService extends BaseMessageService<Shooter> {
	@Autowired
	private ShooterDao shooterDao;

	public void saveOrUpdate(Shooter shooter){
		if(shooter.getId() < 0){
			shooterDao.save(shooter);
			emitMessage(shooter, ActionType.CREATE);
		}
		else {
			shooterDao.update(shooter);
			emitMessage(shooter, ActionType.UPDATE);
		}
	}

	public void delete(Shooter shooter){
		emitMessage(shooter, ActionType.DELETE);
		shooterDao.delete(shooter);
	}

	public List<Shooter> findAll(Integer siteId){
		return (List<Shooter>) shooterDao.findAll(siteId);
	}

	public Shooter get(Integer id){
		return shooterDao.get(id);
	}

	public Shooter findByPassNr(String passNr){
		return shooterDao.findByPassNr(passNr);
	}
	
	
	public void importShooters(File file){
		 BufferedReader br = null;
		 System.out.println("Start Import at: " + new Date().toString());
		 try
		    {
		      br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "Cp1252"));
		      String stringRead = br.readLine();
		      int row = 1;

		      while( stringRead != null ){
		    	String[] elements = stringRead.split(";");
		    	
		    	if(row == 1){
		    		// Ignore first line is header
		    	}
		    	else{				    	
		    	    if(elements.length < 4) {
		    	      throw new RuntimeException("line too short at line: " +row); //handle missing entries
		    	    }
	
		    	    String passNr = elements[1];
		    	    
		    	    Shooter shooter = findByPassNr(passNr);
		    	    if(shooter == null){
		    	    	shooter = new Shooter(-1);
		    	    	shooter.setPassNr(passNr);
		    	    }
		    	    shooter.setLastUpdate(new Date());
		    	    shooter.setName(elements[0].replaceAll("\"", "").replace(",", ""));
		    	    String fullCommunity = elements[2];
		    	    String community = fullCommunity.substring(fullCommunity.lastIndexOf("|")+1);		    	    
		    	    shooter.setCommunity(community);
		    	    shooter.setSex(elements[3]);
		    	    try{
			    	    try {
							shooter.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse(elements[4]));
						} catch (Exception e) {
							e.printStackTrace();
							System.out.println("Error with Date: " + elements[4] + " at line: " + row);
						}
			    	    
			    	    shooter.setArmbrust(StringUtils.isNotEmpty(elements[5]));
			    	    shooter.setGk(StringUtils.isNotEmpty(elements[6]));
			    	    shooter.setFeuerstutzen(StringUtils.isNotEmpty(elements[7]));
			    	    shooter.setFeuerpistole(StringUtils.isNotEmpty(elements[8]));
			    	    shooter.setFp(StringUtils.isNotEmpty(elements[9]));
			    	    shooter.setKk(StringUtils.isNotEmpty(elements[10]));
			    	    shooter.setLg(StringUtils.isNotEmpty(elements[11]));
			    	    shooter.setLp(StringUtils.isNotEmpty(elements[12]));
			    	    shooter.setLp5(StringUtils.isNotEmpty(elements[13]));
			    	    shooter.setVorderlader(StringUtils.isNotEmpty(elements[14]));
			    	    shooter.setZimmerstutzen(StringUtils.isNotEmpty(elements[15]));
		    	    }
		    	    catch(IndexOutOfBoundsException ioobe){
		    	    	
		    	    }
		    	    saveOrUpdate(shooter);
		    	    System.out.println("Import Shooter with id: " + passNr + " at row: " + row);
		    	}	    	    
	    	    
		        // read the next line
		        stringRead = br.readLine();
		        row++;
		      }
		     
		    }
		    catch(java.io.IOException ioe){
		    	
		    }
		 	finally{
		 		try {
					if(br != null){
						br.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
		 		
		 		System.out.println("Stop Import at: " + new Date().toString());
		 	}
		 	
	}
	
}