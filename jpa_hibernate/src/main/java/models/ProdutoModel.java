package models;

import entities.Pessoa;
import entities.Produto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class ProdutoModel {


        public void create(Produto p) {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
            EntityManager em = emf.createEntityManager();
            System.out.println("cai aqui");
            try {
                System.out.println("Iniciando a transação");
                em.getTransaction().begin();
                em.persist(p);
                em.getTransaction().commit();
                System.out.println("Produto criado com sucesso !!!");
            } catch (Exception e) {
                em.close();
                System.err.println("Erro ao criar o produto !!!" + e.getMessage());
            } finally {
                em.close();
                System.out.println("Finalizando a transação");
            }
        }

        public void update(Produto p) {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
            EntityManager em = emf.createEntityManager();
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

        public void delete(Produto p) {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
            EntityManager em = emf.createEntityManager();
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

        public Produto findById(Produto p) {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
            EntityManager em = emf.createEntityManager();
            Produto prod = null;
            try {
                System.out.println("Iniciando a transação");
                em.getTransaction().begin();
                prod = em.find(Produto.class, p.getId());
                em.getTransaction().commit();
                System.out.println("Produto buscado com sucesso !!!");
            } catch (Exception e) {
                em.close();
                System.err.println("Erro ao buscar o produto !!!" + e.getMessage());
            } finally {
                em.close();
                System.out.println("Finalizando a transação");
            }

            return prod;
        }

        public List<Produto> findAll() {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
            EntityManager em = emf.createEntityManager();

            List<Produto> produtos = new ArrayList<Produto>();
            try {
                System.out.println("Iniciando a transação");
                em.getTransaction().begin();
                String local = Produto.class.getName();
                produtos = em.createQuery("FROM " + local).getResultList();
                em.getTransaction().commit();
                System.out.println("Produto buscado com sucesso !!!");
            } catch (Exception e) {
                em.close();
                System.err.println("Erro ao listar os produtos !!!" + e.getMessage());
            } finally {
                em.close();
                System.out.println("Finalizando a transação");
            }

            return produtos;
        }
}
