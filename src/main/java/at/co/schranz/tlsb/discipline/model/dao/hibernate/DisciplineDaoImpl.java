package at.co.schranz.tlsb.discipline.model.dao.hibernate;

import java.io.Serializable;

import org.hibernate.SessionFactory;
import org.hibernate.SessionFactory;

import at.co.schranz.tlsb.discipline.model.Discipline;
import at.co.schranz.tlsb.discipline.model.dao.DisciplineDao;
import at.generalsolutions.model.dao.BaseDao;

public class DisciplineDaoImpl extends BaseDao<Discipline> implements DisciplineDao {
	public DisciplineDaoImpl(SessionFactory sessionFactory){
		super(sessionFactory);
	}
	public Class<? extends Serializable> getReferenceClass() {
		return Discipline.class;
	}

	public org.hibernate.Criteria getCriteria(Class clazz, Integer siteId) {
		org.hibernate.Criteria criteria = getSession().createCriteria(clazz);
		/*This object has no siteId
		if(siteId != null && siteId > 0){
			criteria.add(org.hibernate.criterion.Restrictions.eq("siteId", siteId));
		}*/
		return criteria;
	}

}