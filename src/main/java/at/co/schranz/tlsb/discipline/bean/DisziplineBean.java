package at.co.schranz.tlsb.discipline.bean;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.HandlesEvent;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.StreamingResolution;
import net.sourceforge.stripes.action.UrlBinding;
import at.co.schranz.tlsb.discipline.model.Discipline;
import at.co.schranz.tlsb.discipline.service.DisziplineService;
import at.generalsolutions.annotations.JsonApi;
import at.generalsolutions.beans.BaseActionBean;
import at.generalsolutions.security.Jwt;

@UrlBinding("/diszipline/{$event}/")
@JsonApi
public class DisziplineBean extends BaseActionBean {
	
	public DisziplineBean(){
		siteIdRequired = false;
	}
	
	@Autowired
	private DisziplineService disziplineService;
	
	@DefaultHandler
	@HandlesEvent("findAll")
	@Jwt(required=false, ignoreProductCheck=true)
	public Resolution findAll() throws Exception {
		List<Discipline> diszipline = disziplineService.findAll(null);
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(diszipline);
		return new StreamingResolution("text/html;charset=UTF8", jsonString);
	}	
}
