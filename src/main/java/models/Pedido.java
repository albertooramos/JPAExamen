package models;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "pedidos")
public class Pedido {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "estado")
    private String estado;
    @Basic
    @Column(name = "fechapedido")
    private Timestamp fechapedido;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Timestamp getFechapedido() {
        return fechapedido;
    }

    public void setFechapedido(Timestamp fechapedido) {
        this.fechapedido = fechapedido;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pedido pedido = (Pedido) o;
        return id == pedido.id && Objects.equals(estado, pedido.estado) && Objects.equals(fechapedido, pedido.fechapedido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, estado, fechapedido);
    }

    @OneToMany(mappedBy = "pedido")
    private Collection<PedidosProductos> productos;

    public void setProductos(Collection<PedidosProductos> productos) {
        this.productos = productos;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", estado='" + estado + '\'' +
                ", fechapedido=" + fechapedido +
                '}';
    }

    @ManyToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "id", nullable = false)
    private Usuario usuario;
}



