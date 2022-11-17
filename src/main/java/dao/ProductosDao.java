package dao;

import idao.iProductosDao;
import models.Categoria;
import models.PedidosProductos;
import models.Producto;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class ProductosDao extends Dao<Producto> implements iProductosDao {




    @Override
    public boolean aniadirProducto(Producto producto) {
        try {
            if (new CategoriasDao().categoriaExiste(producto.getCategoria().getId())) {
                this.create(producto);
                return true;
            }
            return false;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }

    }

    @Override
    public List<Producto> listarProductosCategoria(Integer categoriaId) {
        try {
            if (new CategoriasDao().categoriaExiste(categoriaId)){
                Query query=getEntityManager().createQuery(" select producto from Producto as producto where producto.categoria.id=:id ");
                query.setParameter("id", categoriaId);
                return query.getResultList();
            }
            return new ArrayList<>();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ArrayList<>();
        }
    }


}
