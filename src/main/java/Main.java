import entity.PessoaEntity;
import jakarta.persistence.*;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();

            //Teste de inserção
            PessoaEntity franciel = new PessoaEntity();
            franciel.setCpf("042.558.699-53");
            franciel.setEmail("daniel.technix@gmail.com");
            franciel.setNome("Daniel");
            franciel.setTelefone("042 99999-1111");
            entityManager.persist(franciel);

            //Teste de busca pelo nome
            TypedQuery<PessoaEntity> pesByNameQuery =  entityManager.createNamedQuery("PessoaEntity.byName",PessoaEntity.class);
            pesByNameQuery.setParameter(1,"Franciel");
            for (PessoaEntity pessoa : pesByNameQuery.getResultList()) {
                System.out.println("Pessoa:"+pessoa);
            }

            //Teste com busca por Named Query
            Query countEmail = entityManager.createNativeQuery("SELECT count(*) FROM pessoa p WHERE p.email=:emailName");
            countEmail.setParameter("emailName", "franciel.technix@gmail.com");
            System.out.println("Existem "+countEmail.getSingleResult()+ " emails iguais ao informado!");

            transaction.commit();
        }finally {
            if (transaction.isActive()){
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }

    }
}
