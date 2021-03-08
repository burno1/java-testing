package sections.nine;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import sections.petclinic.repositories.VetRepository;
import sections.petclinic.services.springdatajpa.VetSDJpaService;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

/**
 * Author: Bruno Fernandes
 * Created at : 08/03/2021
 */
@ExtendWith(MockitoExtension.class)
class VetSDJpaServiceTest {

    @Mock
    VetRepository vetRepository;

    @InjectMocks
    VetSDJpaService service;


    @DisplayName(value = "Delete by Id")
    @Test
    void deleteById() {
        service.deleteById(1l);

        verify(vetRepository, atLeastOnce()).deleteById(1l);
    }
}