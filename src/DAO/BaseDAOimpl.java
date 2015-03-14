package DAO;

import interfaces.BaseDAO;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;

import util.HibernateUtil;

public class BaseDAOimpl<Entity extends Serializable> implements
		BaseDAO<Entity> {

	protected Class<Entity> type;

	 public BaseDAOimpl(Class<Entity> type) {
         this.type = type;
    }
	
	@SuppressWarnings("unchecked")
	@Override
	public Entity getByID(Integer id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Entity entity = (Entity) session.get(type, id);
		session.close();
		return (Entity) entity;
		
	}

	@Override
	public List getList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List search(Map<String, Object> parameterMap) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer insert(Entity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Entity entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Entity entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub

	}

}
