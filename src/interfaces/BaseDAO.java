package interfaces;
 
import java.io.Serializable;
import java.util.List;
import java.util.Map;
 
public interface BaseDAO<Entity extends Serializable> {
 
    Entity getByID(Integer id);
 
    List getList();
 
    List search(Map<String, Object> parameterMap);
 
    Integer insert(Entity entity);
 
    void update(Entity entity);
 
    void delete(Entity entity);
 
    void deleteById(Integer id);
 
}