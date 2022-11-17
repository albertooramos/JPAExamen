import dao.CategoriasDao;
import dao.PedidosDao;
import dao.ProductosDao;
import models.Categoria;
import models.Pedido;
import models.PedidosProductos;
import models.Producto;

import java.util.ArrayList;
import java.util.Collection;

public class App {
    public static void main(String[] args) {
        Producto producto = new Producto();
        producto.setTitulo("djjd");
        producto.setDetalle("jsjs");
        Categoria categoria = new CategoriasDao().getCategoria(1);
        producto.setCategoria(categoria);
        //Categoria categoria1= new Categoria();
        //categoria1.setId(5);
        //producto.setCategoria(categoria1);
        producto.setPrecio(23.43);
        //boolean aniadido = new ProductosDao().aniadirProducto(producto);


        //System.out.println("-------------AÑADIR PRODUCTO -----------------");
        //System.out.println(aniadido ? "producto añadido" : "ERROR producto añadido");


        //System.out.println("-------------LISTAR PEDIDOS USUARIO -----------------");
        //new PedidosDao().listarPedidosUsuario(3).stream().forEach(
             //   ped -> System.out.println(ped.toString()));

        System.out.println("-------------LISTAR PRODUCTOS CATEGORIA -----------------");
        new ProductosDao().listarProductosCategoria(3).stream().forEach(
                prod -> System.out.println(prod.toString()));
    }
}
