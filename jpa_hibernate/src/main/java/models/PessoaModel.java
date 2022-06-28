package models;

import entities.Pessoa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class PessoaModel {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
    EntityManager em = emf.createEntityManager();

    public void create(Pessoa p) {

        try {
            System.out.println("Iniciando a transação");
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
            System.out.println("Pessoa criada com sucesso !!!");
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao criar a pessoa !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }
    }

    public void update(Pessoa p) {
        try {
            System.out.println("Iniciando a transação");
            em.getTransaction().begin();
            em.merge(p);
            em.getTransaction().commit();
            System.out.println("Pessoa criada com sucesso !!!");
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao criar a pessoa !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }
    }

    public void delete(Pessoa p) {
        try {
            System.out.println("Iniciando a transação");
            em.getTransaction().begin();
            em.remove(p);
            em.getTransaction().commit();
            System.out.println("Pessoa deletada com sucesso !!!");
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao deletar a pessoa !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }
    }

    public Pessoa findById(Pessoa p) {
        return em.find(Pessoa.class, p.getId());
    }

    public List<Pessoa> findAll() {

        List<Pessoa> pessoas = new ArrayList<Pessoa>();
        try {
            System.out.println("Iniciando a transação");
            em.getTransaction().begin();
            String local = Pessoa.class.getName();
            pessoas = em.createQuery("FROM " + local).getResultList();
            em.getTransaction().commit();
            System.out.println("Pessoa deletada com sucesso !!!");
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao deletar a pessoa !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }

        return pessoas;
    }
}
