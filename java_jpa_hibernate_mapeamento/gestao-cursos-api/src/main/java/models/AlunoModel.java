package models;

import entities.Aluno;
import entities.Curso;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class AlunoModel {
    public void create(Aluno a) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();
        try {
            System.out.println("Iniciando a transação");
            em.getTransaction().begin();
            em.persist(a);
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

    public void update(Aluno a) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();
        try {
            System.out.println("Iniciando a transação");
            em.getTransaction().begin();
            em.merge(a);
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

    public void delete(Aluno a) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();
        try {
            System.out.println("Iniciando a transação");
            em.getTransaction().begin();
            em.remove(a);
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

    public Aluno findById(Aluno a) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();
        Aluno aluno = null;
        try {
            System.out.println("Iniciando a transação");
            em.getTransaction().begin();
            aluno = em.find(Aluno.class, a.getId());
            em.getTransaction().commit();
            System.out.println("Curso buscado com sucesso !!!");
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao buscar o curso !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }

        return aluno;
    }

    public List<Aluno> findAll() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();

        List<Aluno> alunos = new ArrayList<Aluno>();
        try {
            System.out.println("Iniciando a transação");
            em.getTransaction().begin();
            String local = Curso.class.getName();
            alunos = em.createQuery("FROM " + local).getResultList();
            em.getTransaction().commit();
            System.out.println("Curso buscado com sucesso !!!");
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao listar os cursos !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }

        return alunos;
    }
}
