package at.co.schranz.tlsb.discipline.model.dao;

public interface DisciplineDao {
	public at.co.schranz.tlsb.discipline.model.Discipline get(int key) throws org.hibernate.HibernateException;
	public at.co.schranz.tlsb.discipline.model.Discipline load(int key) throws org.hibernate.HibernateException;
	public java.util.List<? extends at.co.schranz.tlsb.discipline.model.Discipline> findAll (Integer siteId);
	public java.lang.Integer save(at.co.schranz.tlsb.discipline.model.Discipline diszipline) throws org.hibernate.HibernateException;
	public void update(at.co.schranz.tlsb.discipline.model.Discipline diszipline) throws org.hibernate.HibernateException;
	public void delete(int id) throws org.hibernate.HibernateException;
	public void delete(at.co.schranz.tlsb.discipline.model.Discipline diszipline) throws org.hibernate.HibernateException;
}