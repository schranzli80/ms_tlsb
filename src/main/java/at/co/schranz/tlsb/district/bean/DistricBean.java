package at.co.schranz.tlsb.district.bean;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.HandlesEvent;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.StreamingResolution;
import net.sourceforge.stripes.action.UrlBinding;
import at.co.schranz.tlsb.district.service.DistrictService;
import at.generalsolutions.annotations.JsonApi;
import at.generalsolutions.beans.BaseActionBean;
import at.generalsolutions.security.Jwt;

@UrlBinding("/district/{$event}/")
@JsonApi
public class DistricBean extends BaseActionBean {
	
	@Autowired
	private DistrictService districtService;
	
	public DistricBean(){
		siteIdRequired = false;
	}
	
	@DefaultHandler
	@HandlesEvent("findAll")
	@Jwt(required=false, ignoreProductCheck=true)
	public Resolution findAll() throws Exception {
		Map<Integer, String> districts = districtService.getDistricts();
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(districts);
		return new StreamingResolution("text/html;charset=UTF8", jsonString);
	}
	
	
}
