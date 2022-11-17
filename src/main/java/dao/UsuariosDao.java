package dao;

import models.Categoria;
import models.Usuario;

public class UsuariosDao extends Dao<Usuario>{
    public boolean usuarioExiste(Integer id){
        if (em.find(Usuario.class, id)!=null){
            return true;
        }
        return false;
    }
}
