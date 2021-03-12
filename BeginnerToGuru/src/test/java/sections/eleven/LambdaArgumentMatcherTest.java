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

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.lenient;

/**
 * Author: Bruno Fernandes
 * Created at : 11/03/2021
 */
@ExtendWith(MockitoExtension.class)
public class LambdaArgumentMatcherTest {

    @Mock
    SpecialtyRepository specialtyRepository;

    @InjectMocks
    SpecialitySDJpaService service;

    @DisplayName(value = "Test save lambda")
    @Test
    void testSaveLambda() {
        //given
        final String MATCH_ME = "MATCH_ME";
        Speciality specialty = new Speciality();
        specialty.setDescription(MATCH_ME);

        Speciality savedSpeciality = new Speciality();
        savedSpeciality.setId(1L);

        given(specialtyRepository
                .save(argThat(argument -> argument
                                            .getDescription()
                                            .equals(MATCH_ME))))
        .willReturn(savedSpeciality);

        //when
        Speciality returnedSpecialty = service.save(specialty);

        //then
        assertThat(returnedSpecialty.getId()).isEqualTo(1L);
    }

    @DisplayName(value = "Test save lambda not match")
    @Test
    void testSaveLambdaNotMatch() {
        //given
        final String MATCH_ME = "MATCH_ME";
        Speciality specialty = new Speciality();
        specialty.setDescription("not a match");

        Speciality savedSpeciality = new Speciality();
        savedSpeciality.setId(1L);



        lenient().when(specialtyRepository
                .save(argThat(argument -> argument
                        .getDescription()
                        .equals(MATCH_ME)))).thenReturn(savedSpeciality);

        //when
        Speciality returnedSpecialty = service.save(specialty);

        //then
        assertNull(returnedSpecialty);
    }
}
