package sections.eleven;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import sections.petclinic.model.Speciality;
import sections.petclinic.repositories.SpecialtyRepository;
import sections.petclinic.services.springdatajpa.SpecialitySDJpaService;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.*;
import static org.mockito.Mockito.doThrow;

/**
 * Author: Bruno Fernandes
 * Created at : 09/03/2021
 */
@ExtendWith(MockitoExtension.class)
public class MockitoExceptionsTest {


    @Mock
    SpecialtyRepository specialtyRepository;

    @InjectMocks
    SpecialitySDJpaService service;

    @DisplayName(value = "Test exception mockito delete")
    @Test
    void testDoThrow() {
        doThrow(new RuntimeException("boom")).when(specialtyRepository).delete(any());

        assertThrows(RuntimeException.class, () -> specialtyRepository.delete(new Speciality()));

        then(specialtyRepository).should().delete(any());
    }

    @DisplayName(value = "Test Expception find by id")
    @Test
    void testFindByIdThrows() {
        given(specialtyRepository.findById(1L)).willThrow(new RuntimeException("Boom"));

        assertThrows(RuntimeException.class,()->specialtyRepository.findById(1L));

        then(specialtyRepository).should().findById(anyLong());
    }

    @DisplayName(value = "Test Exception delete bdd")
    @Test
    void testDeleteBDD() {
        willThrow(new RuntimeException("boom")).given(specialtyRepository).delete(any());

        assertThrows(RuntimeException.class, () -> specialtyRepository.delete(new Speciality()));

        then(specialtyRepository).should().delete(any( ));
    }
}
