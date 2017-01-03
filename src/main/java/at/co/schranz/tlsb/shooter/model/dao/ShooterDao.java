package at.co.schranz.tlsb.shooter.model.dao;

import at.co.schranz.tlsb.shooter.model.Shooter;

public interface ShooterDao {
	public at.co.schranz.tlsb.shooter.model.Shooter get(int key) throws org.hibernate.HibernateException;
	public at.co.schranz.tlsb.shooter.model.Shooter load(int key) throws org.hibernate.HibernateException;
	public java.util.List<? extends at.co.schranz.tlsb.shooter.model.Shooter> findAll (Integer siteId);
	public java.lang.Integer save(at.co.schranz.tlsb.shooter.model.Shooter shooter) throws org.hibernate.HibernateException;
	public void update(at.co.schranz.tlsb.shooter.model.Shooter shooter) throws org.hibernate.HibernateException;
	public void delete(int id) throws org.hibernate.HibernateException;
	public void delete(at.co.schranz.tlsb.shooter.model.Shooter shooter) throws org.hibernate.HibernateException;
	public Shooter findByPassNr(String passNr);
}