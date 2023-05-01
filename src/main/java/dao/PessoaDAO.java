package dao;

import java.util.ArrayList;
import java.util.List;

import model.People;
import org.hibernate.*;

public class PessoaDAO {

//	public void createPessoa(People pessoa) throws Exception{
//		Transaction trns = null;
//		Session session = HibernateUtil.getSessionFactory().openSession();
//		try {
//			trns = session.beginTransaction();
//			session.save(pessoa);
//			session.getTransaction().commit();
//		} catch (RuntimeException e) {
//			if (trns != null) {
//				trns.rollback();
//			}
//			e.printStackTrace();
//			throw new Exception("Error ao criar pessoa");
//		} finally {
//			session.flush();
//			session.close();
//		}
//	}

//	public People getPeople(String cpf){
//		People pessoa = null;
//		Session session = HibernateUtil.getSessionFactory().openSession();
//		try {
//			pessoa = (People) session.get(People.class, new String(cpf));
//		} finally {
//			session.flush();
//			session.close();
//		}
//
//		return pessoa;
//	}

//	public void deletePessoa(String pessoaId) throws Exception{
//		Transaction trns = null;
//		Session session = HibernateUtil.getSessionFactory().openSession();
//		try {
//			trns = session.beginTransaction();
//			People pessoa = (People) session.load(People.class,
//					new String(pessoaId));
//
//			session.delete(pessoa);
//			session.getTransaction().commit();
//		} catch (RuntimeException e) {
//			if (trns != null) {
//				trns.rollback();
//			}
//			e.printStackTrace();
//			throw new Exception("Error ao excluir pessoa");
//		} finally {
//			session.flush();
//			session.close();
//		}
//	}

//	public void updatePessoa(People pessoa) throws Exception{
//		Transaction trns = null;
//		Session session = HibernateUtil.getSessionFactory().openSession();
//		try {
//			trns = session.beginTransaction();
//			session.update(pessoa);
//			session.getTransaction().commit();
//		} catch (RuntimeException e) {
//			if (trns != null) {
//				trns.rollback();
//			}
//			e.printStackTrace();
//			throw new Exception("Error ao atualizar pessoa");
//		} finally {
//			session.flush();
//			session.close();
//		}
//	}

	public List<People> listPessoas(){
		List<People> people = new ArrayList<>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			people = session.createQuery("from tb_pessoa").list();
			System.out.println("Pessoas do banco de dados: "+people.toString());
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
		return people;
	}
}