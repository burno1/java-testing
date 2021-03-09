package sections.ten;

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
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

/**
 * Author: Bruno Fernandes
 * Created at : 09/03/2021
 */
@ExtendWith(MockitoExtension.class)
@DisplayName("SpecialitySDJpaServiceTest with BDD")
class SpecialitySDJpaServiceTest {

    @Mock
    SpecialtyRepository specialtyRepository;

    @InjectMocks
    SpecialitySDJpaService specialitySDJpaService;

    @DisplayName(value = "Find by Id test BDD")
    @Test
    void findByIdBddTest() {
        //given
        Speciality speciality = new Speciality();
        given(specialtyRepository.findById(1L)).willReturn(Optional.of(speciality));

        //when
        Speciality specialtyFound = specialitySDJpaService.findById(1L);

        //then
        assertThat(specialtyFound).isNotNull();
        then(specialtyRepository).should().findById(anyLong());
        then(specialtyRepository).shouldHaveNoMoreInteractions();

    }

    @DisplayName(value = "Delete by Object BDD")
    @Test
    void testDeleteByObjectBDD() {
        //given
        Speciality speciality = new Speciality();

        //when
        specialitySDJpaService.delete(speciality);

        //then
        then(specialtyRepository).should().delete(any(Speciality.class));

    }

    @DisplayName(value = "Test delete by id BDD")
    @Test
    void deleteById() {
        // given - none

        //when
        specialitySDJpaService.deleteById(1l);

        //then
        then(specialtyRepository).should(times(1)).deleteById(1L);
    }

    @DisplayName(value = "Test delete by id once BDD ")
    @Test
    void deleteByIdVerifyOnce() {
        //given - none

        //when
        specialitySDJpaService.deleteById(1l);
        specialitySDJpaService.deleteById(1l);

        //then
        then(specialtyRepository).should(atLeastOnce()).deleteById(anyLong());
    }

    @DisplayName(value = "Test delete by id twice BDD")
    @Test
    void deleteByIdVerifyTwice() {
        //given - none

        //when
        specialitySDJpaService.deleteById(1l);
        specialitySDJpaService.deleteById(1l);

        //then
        then(specialtyRepository).should(times(2)).deleteById(anyLong());
    }

    @DisplayName(value = "Test delete by at most BDD")
    @Test
    void deleteByIdVerifyAtMost() {
        //given - none

        //when
        specialitySDJpaService.deleteById(1l);
        specialitySDJpaService.deleteById(1l);

        //then
        then(specialtyRepository).should(atMost(5)).deleteById(anyLong());
    }

    @DisplayName(value = "Test delete by at most BDD")
    @Test
    void deleteByIdVerifyNever() {
        //given - none

        //when
        specialitySDJpaService.deleteById(1l);
        specialitySDJpaService.deleteById(1l);

        //then
        then(specialtyRepository).should(never()).deleteById(5L);

    }


    @DisplayName(value = "Test Delete BDD")
    @Test
    void testDelete() {
        // given - none

        // when
        specialitySDJpaService.delete(new Speciality());

        //then
        then(specialtyRepository).should().delete(any(Speciality.class));
    }
}