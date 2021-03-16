package sections.five.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import sections.five.fauxspring.ModelMapImpl;
import sections.petclinic.controllers.VetController;
import sections.six.ControllerTests;
import sections.petclinic.model.Vet;
import sections.petclinic.services.SpecialtyService;
import sections.petclinic.services.VetService;
import sections.petclinic.services.map.SpecialityMapService;
import sections.petclinic.services.map.VetMapService;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author: Bruno Fernandes
 * Created at : 05/03/2021
 */
class VetControllerTest implements ControllerTests {
    VetService vetService;
    SpecialtyService specialtyService;
    VetController vetController;

    @BeforeEach
    void setUp(){
        specialtyService = new SpecialityMapService();
        vetService = new VetMapService(specialtyService);

        vetController = new VetController(vetService);
        Vet vet = new Vet(1L,"John","Doe",null);
        Vet vet2 = new Vet(2L,"Joahne","Does",null);

        vetService.save(vet);
        vetService.save(vet2);

    }

    @DisplayName(value = "Test List Vets ")
    @Test
    void listVets() {
        ModelMapImpl model = new ModelMapImpl();

        String view = vetController.listVets(model);

        assertThat("vets/index").isEqualTo(view);

        Set modalAttribute = (Set) ((ModelMapImpl) model).getMap().get("vets");
        assertThat(modalAttribute.size()).isEqualTo(2);
    }
}