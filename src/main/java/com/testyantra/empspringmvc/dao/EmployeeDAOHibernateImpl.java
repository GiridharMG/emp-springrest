package com.testyantra.empspringmvc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.testyantra.empspringmvc.jaxb.beans.DepartmentInfoBean;
import com.testyantra.empspringmvc.jaxb.beans.EmployeeAddressInfoBean;
import com.testyantra.empspringmvc.jaxb.beans.EmployeeEducationInfoBean;
import com.testyantra.empspringmvc.jaxb.beans.EmployeeExperinceInfoBean;
import com.testyantra.empspringmvc.jaxb.beans.EmployeeInfoBean;

@SuppressWarnings("unchecked")
public final class EmployeeDAOHibernateImpl implements EmployeeDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<EmployeeInfoBean> getAllEmployeeInfo() {
		List<EmployeeInfoBean> beans = null;
		Session session = sessionFactory.openSession();
		String hql = "from EmployeeInfoBean";
		beans = session.createQuery(hql).list();
		session.close();
		return beans;
	}

	@Override
	public EmployeeInfoBean getEmployeeInfo(int id) {
		Session session = sessionFactory.openSession();
		EmployeeInfoBean bean = session.get(EmployeeInfoBean.class, id);
		session.close();
		return bean;
	}

	private boolean saveOrUpdate(EmployeeInfoBean bean) {
		bean.getOtherInfo().setId(bean);
		for (EmployeeAddressInfoBean addressInfoBean : bean.getAddressInfo()) {
			addressInfoBean.getAddressPKBean().setId(bean);
		}
		for (EmployeeEducationInfoBean educationInfoBean : bean.getEducationInfo()) {
			educationInfoBean.getEducationPKBean().setId(bean);
		}
		for (EmployeeExperinceInfoBean experinceInfoBean : bean.getExperinceInfo()) {
			experinceInfoBean.getExperincePKBean().setId(bean);
		}
		EmployeeInfoBean manager = getEmployeeInfo(bean.getManagerId().getId());
		bean.setManagerId(manager);
		Transaction txn = null;
		try (Session session = sessionFactory.openSession();) {
			bean.setDepartmentInfo(session.get(DepartmentInfoBean.class, bean.getDepartmentInfo().getDepartmentId()));
			txn = session.beginTransaction();
			session.saveOrUpdate(bean);
			txn.commit();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			if (txn != null) {
				txn.rollback();
			}
			return false;
		}
	}

	@Override
	public boolean createEmployeeInfo(EmployeeInfoBean bean) {
		bean.getOtherInfo().setId(bean);
		for (EmployeeAddressInfoBean addressInfoBean : bean.getAddressInfo()) {
			addressInfoBean.getAddressPKBean().setId(bean);
		}
		for (EmployeeEducationInfoBean educationInfoBean : bean.getEducationInfo()) {
			educationInfoBean.getEducationPKBean().setId(bean);
		}
		for (EmployeeExperinceInfoBean experinceInfoBean : bean.getExperinceInfo()) {
			experinceInfoBean.getExperincePKBean().setId(bean);
		}
		EmployeeInfoBean manager = getEmployeeInfo(bean.getManagerId().getId());
		bean.setManagerId(manager);
		Transaction txn = null;
		try (Session session = sessionFactory.openSession();) {
			bean.setDepartmentInfo(session.get(DepartmentInfoBean.class, bean.getDepartmentInfo().getDepartmentId()));
			txn = session.beginTransaction();
			session.save(bean);
			txn.commit();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			if (txn != null) {
				txn.rollback();
			}
			return false;
		}
	}

	@Override
	public boolean updateEmployeeInfo(EmployeeInfoBean bean) {
		return saveOrUpdate(bean);
	}

	@Override
	public boolean deleteEmployeeInfo(int id) {
		Transaction txn = null;
		EmployeeInfoBean bean = new EmployeeInfoBean();
		bean.setId(id);
		try (Session session = sessionFactory.openSession();) {
			txn = session.beginTransaction();
			session.delete(bean);
			txn.commit();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			if (txn != null) {
				txn.rollback();
			}
			return false;
		}
	}

}// End of Class
