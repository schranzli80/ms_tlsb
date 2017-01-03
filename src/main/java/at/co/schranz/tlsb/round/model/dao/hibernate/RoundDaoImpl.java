package at.co.schranz.tlsb.round.model.dao.hibernate;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import at.generalsolutions.model.dao.BaseDao;
import at.co.schranz.tlsb.round.model.Round;
import at.co.schranz.tlsb.round.model.dao.RoundDao;

public class RoundDaoImpl extends BaseDao<Round> implements RoundDao {
	public RoundDaoImpl(SessionFactory sessionFactory){
		super(sessionFactory);
	}
	public Class<? extends Serializable> getReferenceClass() {
		return Round.class;
	}

	@Override
	public org.hibernate.Criteria getCriteria(Class clazz, Integer siteId) {
		org.hibernate.Criteria criteria = getSession().createCriteria(clazz);
		/*This object has no siteId
		if(siteId != null && siteId > 0){
			criteria.add(org.hibernate.criterion.Restrictions.eq("siteId", siteId));
		}*/
		return criteria;
	}
	@Override
	public List<Round> getRoundesByDisziplineAndDistrict(Integer disziplineId, String districtId) {
		Criteria criteria = getSession().createCriteria(getReferenceClass());
		criteria.add(Restrictions.eq(Round.PROP_DIZIPLINE, disziplineId));
		if(districtId != null){
			criteria.add(Restrictions.eq(Round.PROP_DISTIRCT, districtId));
		}
		criteria.add(Restrictions.eq(Round.PROP_ACTIVE, true));
		criteria.addOrder(Order.asc(Round.PROP_ROUND));
		return criteria.list();
	}
	

}