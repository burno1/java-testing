package sections.five.fauxspring;

import sections.petclinic.fauxspring.Model;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: Bruno Fernandes
 * Created at : 05/03/2021
 */
public class ModelMapImpl implements Model {
    Map<String,Object> map = new HashMap<String,Object>();
    @Override
    public void addAttribute(String key, Object o) {
        map.put(key,o);
    }

    @Override
    public void addAttribute(Object o) {

    }

    public Map<String,Object> getMap(){
        return map;
    }
}
