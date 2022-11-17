package dao;

import idao.iPedidosDao;
import models.Pedido;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class PedidosDao extends Dao<Pedido> implements iPedidosDao {

    @Override
    public List<Pedido> listarPedidosUsuario(Integer userId) {
        try {
            if (new UsuariosDao().usuarioExiste(userId)){
                Query query=getEntityManager().createQuery(" select pedido from Pedido as pedido where pedido.usuario.id=:id ");
                query.setParameter("id", userId);
                return query.getResultList();
            }
            return new ArrayList<>();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ArrayList<>();
        }
    }
}
