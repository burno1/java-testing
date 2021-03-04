package sections.five.fauxspring;

import sections.five.model.Pet;

import javax.validation.Valid;

public interface ModelMap {
    void put(String pet, @Valid Pet pet1);
}
