package dao;

import fabrica.Fabrica;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class DAOGenerico<T> {

    private static EntityManager entityManager;
    private Class<T> classe;

    public DAOGenerico(Class<T> classe) {
        entityManager = Fabrica.getFabrica().getEm();
        this.classe = classe;
    }

    public T salvar(T objeto) {
        try {
            if (!entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().begin();
            }
            entityManager.persist(objeto);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }
        return objeto;
    }

    public T alterar(T objeto) {
        try {
            if (!entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().begin();
            }
            entityManager.merge(objeto);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }
        return objeto;
    }

    public boolean excluir(Long id) {
        try {
            if (!entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().begin();
            }
            T objeto = entityManager.find(classe, id);
            if (objeto != null) {
                entityManager.remove(objeto);
                return true;
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();

        }
        return false;
    }

    public List<T> buscarTodos() {
        Query query = null;
        try {
            query = entityManager.createQuery("from " + classe.getSimpleName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return query.getResultList();
    }

    public List<T> buscarCondicao(String consulta) {
        Query query = null;
        try {
            query = entityManager.createQuery("from " + classe.getSimpleName() + " where " + consulta);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return query.getResultList();
    }
    
    public List<T> buscarCondicaoFiltro(int consulta) {
        Query query = null;
        try {
            query = entityManager.createQuery("from " + classe.getSimpleName() + " where " + consulta);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return query.getResultList();
    }

    public List<T> buscarReservasSolicitante(String email) {
        Query query = null;
        try {
            query = entityManager.createQuery("from Reserva where servidor.email='" + email+"'");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return query.getResultList();
    }

    public T buscar(Long id) {
        T retornando = null;
        try {
            retornando = entityManager.find(classe, id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return retornando;
    }

}
