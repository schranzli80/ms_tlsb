package at.co.schranz.tlsb.district.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class DistrictService {
	
	public Map<Integer, String> getDistricts(){
		Map<Integer, String> districts = new HashMap<Integer, String>();
		districts.put(701, "Imst");
		districts.put(702, "Innsbruck");
		districts.put(703, "Kitzbühl");
		districts.put(704, "Kufstein");
		districts.put(705, "Landeck");
		districts.put(706, "Lienz");
		districts.put(707, "Reutte");
		districts.put(708, "Schwaz");		
		return districts;
	}
}
