package dao;

import models.Categoria;

public class CategoriasDao extends Dao<Categoria> {
    public Categoria getCategoria(Integer id) {
        return em.find(Categoria.class, id);
    }

    public boolean categoriaExiste(Integer id){
        if (em.find(Categoria.class, id)!=null){
            return true;
        }
        return false;
    }
}
