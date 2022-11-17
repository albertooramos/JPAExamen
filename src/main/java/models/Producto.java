package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

@Table(name = "productos")
@Entity
public class Producto {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "titulo")
    private String titulo;
    @Basic
    @Column(name = "detalle")
    private String detalle;
    @Basic
    @Column(name = "precio")
    private double precio;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return id == producto.id && Double.compare(producto.precio, precio) == 0 && Objects.equals(titulo, producto.titulo) && Objects.equals(detalle, producto.detalle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, titulo, detalle, precio);
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", detalle='" + detalle + '\'' +
                ", precio=" + precio +
                '}';
    }

    @ManyToOne
    @JoinColumn(name = "categoria_id", referencedColumnName = "id", nullable = false)
    private Categoria categoria;

    public Categoria getCategoria(){
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @OneToMany(mappedBy = "producto")
    private Collection<PedidosProductos> pedidos=new ArrayList<>();


    public void setPedidos(Collection<PedidosProductos> pedidos) {
        this.pedidos = pedidos;
    }
}
