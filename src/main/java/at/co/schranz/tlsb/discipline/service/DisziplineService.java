package at.co.schranz.tlsb.discipline.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import at.co.schranz.tlsb.discipline.model.Discipline;
import at.co.schranz.tlsb.discipline.model.dao.DisciplineDao;
import at.generalsolutions.messaging.ActionType;
import at.generalsolutions.messaging.BaseMessageService;

@Service
public class DisziplineService extends BaseMessageService<Discipline> {
	@Autowired
	private DisciplineDao disziplineDao;

	public void saveOrUpdate(Discipline diszipline){
		if(diszipline.getId() < 0){
			disziplineDao.save(diszipline);
			emitMessage(diszipline, ActionType.CREATE);
		}
		else {
			disziplineDao.update(diszipline);
			emitMessage(diszipline, ActionType.UPDATE);
		}
	}

	public void delete(Discipline diszipline){
		emitMessage(diszipline, ActionType.DELETE);
		disziplineDao.delete(diszipline);
	}

	public List<Discipline> findAll(Integer siteId){
		return (List<Discipline>) disziplineDao.findAll(siteId);
	}

	public Discipline get(Integer id){
		return disziplineDao.get(id);
	}

}