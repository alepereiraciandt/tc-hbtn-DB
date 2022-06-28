package models;

import entities.Curso;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class CursoModel {

    public void create(Curso c) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();
        try {
            System.out.println("Iniciando a transação");
            em.getTransaction().begin();
            em.persist(c);
            em.getTransaction().commit();
            System.out.println("Curso criado com sucesso !!!");
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao criar o curso !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }
    }

    public void update(Curso c) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();
        try {
            System.out.println("Iniciando a transação");
            em.getTransaction().begin();
            em.merge(c);
            em.getTransaction().commit();
            System.out.println("Curso modificada com sucesso !!!");
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao modificar o curso !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }
    }

    public void delete(Curso c) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();
        try {
            System.out.println("Iniciando a transação");
            em.getTransaction().begin();
            em.remove(c);
            em.getTransaction().commit();
            System.out.println("Curso deletado com sucesso !!!");
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao deletar o curso !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }
    }

    public Curso findById(Curso c) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();
        Curso curso = null;
        try {
            System.out.println("Iniciando a transação");
            em.getTransaction().begin();
            curso = em.find(Curso.class, c.getId());
            em.getTransaction().commit();
            System.out.println("Curso buscado com sucesso !!!");
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao buscar o curso !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }

        return curso;
    }

    public List<Curso> findAll() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();

        List<Curso> cursos = new ArrayList<Curso>();
        try {
            System.out.println("Iniciando a transação");
            em.getTransaction().begin();
            String local = Curso.class.getName();
            cursos = em.createQuery("FROM " + local).getResultList();
            em.getTransaction().commit();
            System.out.println("Curso buscado com sucesso !!!");
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao listar os cursos !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }

        return cursos;
    }
}
