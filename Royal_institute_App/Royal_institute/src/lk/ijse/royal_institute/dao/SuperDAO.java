package lk.ijse.royal_institute.dao;

import lk.ijse.royal_institute.entity.SuperEntity;
import org.hibernate.Session;

import java.io.Serializable;
import java.util.List;

/**
 * @author Pazindu Shane On 2/9/2021
 * @project Royal_institute_App <shanepazindu7399@gmail.com>
 */
public interface SuperDAO <Entity extends SuperEntity,ID extends Serializable>{

    public boolean add(Entity entity) throws Exception;

    public boolean delete(ID id) throws Exception;

    public  boolean update(Entity entity) throws Exception;

    public Entity search(ID id) throws Exception;

    public List<Entity> viewAll() throws Exception;

    void setSession(Session session);

}
