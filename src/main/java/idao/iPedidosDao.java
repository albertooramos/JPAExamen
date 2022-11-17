package idao;

import models.Pedido;

import java.util.List;

public interface iPedidosDao {
    public List<Pedido> listarPedidosUsuario(Integer userId);
}
