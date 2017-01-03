package at.co.schranz.tlsb.round.model.dao;

import java.util.List;

import at.co.schranz.tlsb.round.model.Round;

public interface RoundDao {
	public at.co.schranz.tlsb.round.model.Round get(int key) throws org.hibernate.HibernateException;
	public at.co.schranz.tlsb.round.model.Round load(int key) throws org.hibernate.HibernateException;
	public java.util.List<? extends at.co.schranz.tlsb.round.model.Round> findAll (Integer siteId);
	public java.lang.Integer save(at.co.schranz.tlsb.round.model.Round round) throws org.hibernate.HibernateException;
	public void update(at.co.schranz.tlsb.round.model.Round round) throws org.hibernate.HibernateException;
	public void delete(int id) throws org.hibernate.HibernateException;
	public void delete(at.co.schranz.tlsb.round.model.Round round) throws org.hibernate.HibernateException;
	public List<Round> getRoundesByDisziplineAndDistrict(Integer disziplineId, String districtId);
}