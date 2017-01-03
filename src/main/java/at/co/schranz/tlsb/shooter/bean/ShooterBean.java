package at.co.schranz.tlsb.shooter.bean;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.HandlesEvent;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.StreamingResolution;
import net.sourceforge.stripes.action.UrlBinding;
import at.co.schranz.tlsb.discipline.model.Discipline;
import at.co.schranz.tlsb.discipline.service.DisziplineService;
import at.co.schranz.tlsb.shooter.ftpimport.FTPImporter;
import at.co.schranz.tlsb.shooter.model.Shooter;
import at.co.schranz.tlsb.shooter.service.ShooterService;
import at.generalsolutions.annotations.JsonApi;
import at.generalsolutions.beans.BaseActionBean;
import at.generalsolutions.security.Authorise;
import at.generalsolutions.security.Jwt;
import at.generalsolutions.security.Permission;
import at.generalsolutions.security.PermissionConstants;
import at.generalsolutions.security.TaskConstants;

@UrlBinding("/shooter/{$event}/")
@JsonApi
public class ShooterBean extends BaseActionBean {
	
	public ShooterBean(){
		siteIdRequired = false;
	}
	
	@Autowired
	private ShooterService shooterService;
	
	@Autowired
	private FTPImporter ftpImporter;
	
	@DefaultHandler
	@HandlesEvent("findAll")
	@Jwt(required=false, ignoreProductCheck=true)
	public Resolution findAll() throws Exception {
		List<Shooter> shooters = shooterService.findAll(null);
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(shooters);
		return new StreamingResolution("text/html;charset=UTF8", jsonString);
	}
	
	@HandlesEvent("importShooters")
	@Jwt(required=false, ignoreProductCheck=true)
	public Resolution importShooters() throws Exception {
		
		File file = ftpImporter.loadFiles();
		shooterService.importShooters(file);
		file.delete();
		
		return new StreamingResolution("text/html;charset=UTF8", STATUS_OK);
	}
}
