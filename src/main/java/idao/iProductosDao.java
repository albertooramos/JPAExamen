package idao;

import models.Producto;

import java.util.List;

public interface iProductosDao {
    public boolean aniadirProducto(Producto producto);

    public List<Producto> listarProductosCategoria(Integer categoriaId);
}
