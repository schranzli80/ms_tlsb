package at.co.schranz.tlsb.round.bean;

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
import at.generalsolutions.annotations.JsonApi;
import at.generalsolutions.beans.BaseActionBean;
import at.generalsolutions.security.Jwt;
import at.co.schranz.tlsb.round.model.Round;
import at.co.schranz.tlsb.round.service.RoundService;

@UrlBinding("/round/{$event}/")
@JsonApi
public class RoundBean extends BaseActionBean {
	
	@Autowired
	private RoundService roundService;
	
	public RoundBean(){
		siteIdRequired = false;
	}
	
	@DefaultHandler
	@HandlesEvent("findAll")
	@Jwt(required=false, ignoreProductCheck=true)
	public Resolution findAll() throws Exception {
		List<Round> rounds = roundService.findAll(null);
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(rounds);
		return new StreamingResolution("text/html;charset=UTF8", jsonString);
	}
	
	@HandlesEvent("getRounds")
	@Jwt(required=false, ignoreProductCheck=true)
	public Resolution getRounds() throws Exception {
		List<Round> rounds = roundService.getRoundesByDisziplineAndDistrict(getId("disziplineId"), getString("districtId"));
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(rounds);
		return new StreamingResolution("text/html;charset=UTF8", jsonString);
	}
}
