package sections.nine;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import sections.petclinic.model.Speciality;
import sections.petclinic.repositories.SpecialtyRepository;
import sections.petclinic.services.springdatajpa.SpecialitySDJpaService;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Author: Bruno Fernandes
 * Created at : 08/03/2021
 */
@ExtendWith(MockitoExtension.class)
class SpecialitySDJpaServiceTest {

    @Mock
    SpecialtyRepository specialtyRepository;

    @InjectMocks
    SpecialitySDJpaService specialitySDJpaService;

    @DisplayName(value = "Find by Id test")
    @Test
    void findById() {
        Speciality speciality = new Speciality();

        when(specialtyRepository.findById(1l)).thenReturn(Optional.of(speciality));

        Speciality specialtyFound = specialitySDJpaService.findById(1L);

        assertThat(specialtyFound).isNotNull();
        verify(specialtyRepository).findById(1l);
    }

    @DisplayName(value = "Delete by Object")
    @Test
    void testDeleteByObject() {
        Speciality speciality = new Speciality();

        specialitySDJpaService.delete(speciality);

        verify(specialtyRepository).delete(any(Speciality.class));

    }

    @DisplayName(value = "Test delete by id")
    @Test
    void deleteById() {
        specialitySDJpaService.deleteById(1l);
    }

    @DisplayName(value = "Test delete by id once ")
    @Test
    void deleteByIdVerifyOnce() {
        specialitySDJpaService.deleteById(1l);
        specialitySDJpaService.deleteById(1l);
        verify(specialtyRepository, atLeastOnce()).deleteById(1l);
    }

    @DisplayName(value = "Test delete by id twice")
    @Test
    void deleteByIdVerifyTwice() {
        specialitySDJpaService.deleteById(1l);
        specialitySDJpaService.deleteById(1l);
        verify(specialtyRepository, times(2)).deleteById(1l);
    }

    @DisplayName(value = "Test delete by at most")
    @Test
    void deleteByIdVerifyAtMost() {
        specialitySDJpaService.deleteById(1l);
        specialitySDJpaService.deleteById(1l);
        verify(specialtyRepository, atMost(5)).deleteById(1l);
    }

    @DisplayName(value = "Test delete by at most")
    @Test
    void deleteByIdVerifyNever() {
        specialitySDJpaService.deleteById(1l);
        specialitySDJpaService.deleteById(1l);
        verify(specialtyRepository, atLeastOnce()).deleteById(1l);
        verify(specialtyRepository, never()).deleteById(5l);

    }


    @DisplayName(value = "Test Delete")
    @Test
    void testDelete() {
        specialitySDJpaService.delete(new Speciality());
    }
}