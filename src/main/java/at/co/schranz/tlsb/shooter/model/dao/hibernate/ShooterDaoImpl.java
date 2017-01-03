package at.co.schranz.tlsb.shooter.model.dao.hibernate;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import at.co.schranz.tlsb.shooter.model.Shooter;
import at.co.schranz.tlsb.shooter.model.dao.ShooterDao;
import at.generalsolutions.model.dao.BaseDao;

public class ShooterDaoImpl extends BaseDao<Shooter> implements ShooterDao {
	public ShooterDaoImpl(SessionFactory sessionFactory){
		super(sessionFactory);
	}
	public Class<? extends Serializable> getReferenceClass() {
		return Shooter.class;
	}

	public org.hibernate.Criteria getCriteria(Class clazz, Integer siteId) {
		org.hibernate.Criteria criteria = getSession().createCriteria(clazz);
		/*This object has no siteId
		if(siteId != null && siteId > 0){
			criteria.add(org.hibernate.criterion.Restrictions.eq("siteId", siteId));
		}*/
		return criteria;
	}
	@Override
	public Shooter findByPassNr(String passNr) {
		Criteria criteria = getSession().createCriteria(getReferenceClass());
		criteria.add(Restrictions.eq(Shooter.PROP_PASS_NR, passNr));
		List<Shooter> result = criteria.list();
		if(result.size() == 1){
			return result.get(0);
		}
		else if(result.size() >1) {
			throw new RuntimeException("More then one Shooter found with PassNr: " + passNr);
		}
		else{
			return null;
		}
	}


}