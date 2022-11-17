package models;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Table(name = "categorias")
@Entity
public class Categoria {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "titulo")
    private String titulo;
    @Basic
    @Column(name = "descripcion")
    private String descripcion;

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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Categoria categoria = (Categoria) o;
        return id == categoria.id && Objects.equals(titulo, categoria.titulo) && Objects.equals(descripcion, categoria.descripcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, titulo, descripcion);
    }

    @OneToMany(mappedBy = "categoria")
    private List<Producto> productos;

    public List<Producto> getProductos(){return productos;}

    public void setProductos(List<Producto> productos){
        this.productos = productos;
    }
}
