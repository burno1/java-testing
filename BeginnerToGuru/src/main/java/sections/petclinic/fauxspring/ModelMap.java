package sections.petclinic.fauxspring;

import sections.petclinic.model.Pet;

import javax.validation.Valid;

public interface ModelMap {
    void put(String pet, @Valid Pet pet1);
}
