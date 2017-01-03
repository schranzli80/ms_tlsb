package at.co.schranz.tlsb.result.bean;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;

import at.co.schranz.tlsb.discipline.model.Discipline;
import at.co.schranz.tlsb.discipline.service.DisziplineService;
import at.co.schranz.tlsb.district.service.DistrictService;
import at.generalsolutions.annotations.JsonApi;
import at.generalsolutions.beans.BaseActionBean;
import at.generalsolutions.report.SimpleReport;
import at.generalsolutions.security.Jwt;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sourceforge.stripes.action.After;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.HandlesEvent;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.StreamingResolution;
import net.sourceforge.stripes.action.UrlBinding;
import net.sourceforge.stripes.controller.LifecycleStage;

@UrlBinding("/results/{disciplineId}/{$event}")
@JsonApi
public class ReportBean extends BaseActionBean {
	
	@Autowired
	private DistrictService districtService;
	@Autowired
	private DisziplineService disziplineService;	
	@Autowired
	private BasicDataSource defaultDataSource;
	
	private Integer districtId;
	private Integer disciplineId;
	

	private String reportName = "Schützen-Schnitt";
	private String reportDescription = "";
	private String eventName = "{0} (TEST)";
	private String districtTitleName = "Bezirksschützenbund ";
	private boolean group = true;
	private String orderBy;

	private Discipline discipline;

	public ReportBean(){
		siteIdRequired = false;
	}
	
	@After(stages=LifecycleStage.BindingAndValidation)
	public void afterBind(){
		if(disciplineId == null){
			throw new RuntimeException("Missing required disciplineId param!");
		}
		discipline = disziplineService.get(disciplineId);
	}
	
	@DefaultHandler
	@HandlesEvent("ezwtotal")
	@Jwt(required=false, ignoreProductCheck=true)
	public Resolution generateReport1()throws Exception{
		String districtName = districtService.getDistricts().get(districtId);
		if(districtName != null){
			districtTitleName += districtName;
		}else{
			districtTitleName = "Tiroler Landesschützenbund";
			eventName = "Landesliste " + eventName;
		}
		
		SimpleReport sr = new SimpleReport();
		Map params = new HashMap();
		
		
		params.put("eventName", eventName.replace("{0}", discipline.getName()));
		if(districtId != null){
			params.put("district", "AND district= '"+districtId+"' ");
		}else{
			params.put("district", "");
		}
		params.put("diszipline", discipline.getId());
		params.put("zentel", discipline.isZehntel());
		
		String order = "";
		
		if(isGroup()){
			params.put("group", true);
			order = "sc.groupName ASC, ";
		}
		
		String orderState = "";
		if(orderBy != null){
			orderState = orderBy.toLowerCase();
		} 
		switch (orderState) {
		case "sum":
			order += "sum DESC ";
			reportName = "Schützen - Ringe";
			break;

		default:
			order += "avg DESC ";
			break;
		}
			
		params.put("order", "ORDER BY " + order);
		
		params.put("reportName", reportName);
		params.put("reportDescription", reportDescription);
		params.put("districtTitleName", districtTitleName);
		
		String image = discipline.getPicturePrint();
		
		params.put("image", image);
		JasperPrint jasperPrint = sr.print("/reports/ezwtotal.jrxml", params , defaultDataSource.getConnection());
		return generateAsStream(jasperPrint);
	}
	
	
	public Resolution generateAsStream(final JasperPrint jasperPrint) {
    	return new StreamingResolution("application/pdf") {
			
		    public void stream(HttpServletResponse response) throws Exception {
				
				try {			
					JasperExportManager.exportReportToPdfStream(jasperPrint,  response.getOutputStream());
				} catch (JRException e) {
					throw e;
				}
		    }
		};
    }

	public Integer getDistrictId() {
		return districtId;
	}

	public void setDistrictId(Integer districtId) {
		this.districtId = districtId;
	}
	
	public boolean isGroup() {
		return group;
	}

	public void setGroup(boolean group) {
		this.group = group;
	}
	
	public Integer getDisciplineId() {
		return disciplineId;
	}

	public void setDisciplineId(Integer disciplineId) {
		this.disciplineId = disciplineId;
	}	

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
}
