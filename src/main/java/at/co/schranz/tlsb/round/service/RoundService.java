package at.co.schranz.tlsb.round.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import at.generalsolutions.messaging.ActionType;
import at.generalsolutions.messaging.BaseMessageService;
import at.co.schranz.tlsb.round.model.Round;
import at.co.schranz.tlsb.round.model.dao.RoundDao;

@Service
public class RoundService extends BaseMessageService<Round> {
	@Autowired
	private RoundDao roundDao;

	public void saveOrUpdate(Round round){
		if(round.getId() < 0){
			roundDao.save(round);
			emitMessage(round, ActionType.CREATE);
		}
		else {
			roundDao.update(round);
			emitMessage(round, ActionType.UPDATE);
		}
	}

	public void delete(Round round){
		emitMessage(round, ActionType.DELETE);
		roundDao.delete(round);
	}

	public List<Round> findAll(Integer siteId){
		return (List<Round>) roundDao.findAll(siteId);
	}

	public Round get(Integer id){
		return roundDao.get(id);
	}

	public List<Round> getRoundesByDisziplineAndDistrict(Integer disziplineId,String districtId) {		
		return roundDao.getRoundesByDisziplineAndDistrict(disziplineId, districtId);
	}

}