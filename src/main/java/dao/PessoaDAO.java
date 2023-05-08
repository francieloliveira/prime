package dao;

import entity.PessoaEntity;
import jakarta.persistence.*;

import java.util.List;

public class PessoaDAO {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    EntityTransaction transaction = entityManager.getTransaction();

    public List<PessoaEntity> listPessoas() {
        List listaPessoas = null;
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();

            String sql = "SELECT * FROM Pessoa";
            Query query = entityManager.createNativeQuery(sql, PessoaEntity.class);
            listaPessoas = query.getResultList();

            transaction.commit();
        } catch (Exception ex) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            ex.printStackTrace();
        } finally {
            entityManager.close();
        }
        return listaPessoas;
    }



}
