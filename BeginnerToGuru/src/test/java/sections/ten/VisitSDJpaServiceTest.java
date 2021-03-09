package sections.ten;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import sections.petclinic.model.Visit;
import sections.petclinic.repositories.VisitRepository;
import sections.petclinic.services.springdatajpa.VisitSDJpaService;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

/**
 * Author: Bruno Fernandes
 * Created at : 08/03/2021
 */
@ExtendWith(MockitoExtension.class)
@DisplayName("VisitSDJpaServiceTest with BDD")
class VisitSDJpaServiceTest {

    @Mock
    VisitRepository visitRepository;

    @InjectMocks
    VisitSDJpaService service;

    @DisplayName(value = "Find all Test")
    @Test
    void findAll() {

        //given
        Visit visit = new Visit();
        Set<Visit> visits = new HashSet<>();
        visits.add(visit);
        given(visitRepository.findAll()).willReturn(visits);

        //when
        Set<Visit> found = service.findAll();

        //then
        then(visitRepository).should().findAll();
        assertThat(found).hasSize(1);
    }

    @DisplayName(value = "Test Find By id")
    @Test
    void findById() {
        //given
        Visit visit = new Visit();
        given(visitRepository.findById(1L)).willReturn(Optional.of(visit));

        //when
        Visit foundVisit = service.findById(1l);

        //then
        then(visitRepository).should().findById(anyLong());
        assertThat(foundVisit).isNotNull();
    }

    @DisplayName(value = "Save test")
    @Test
    void save() {
        // given
        Visit visit = new Visit();
        visit.setDescription("new visit");
        given(visitRepository.save(visit)).willReturn(visit);

        //when
        Visit visitSaved = service.save(visit);

        //then
        then(visitRepository).should().save(any(Visit.class));
        assertThat(visitSaved).isNotNull();
    }

    @DisplayName(value = "Delete object test")
    @Test
    void delete() {
        //given - none
        //when
        service.delete(new Visit());

        //then
        then(visitRepository).should(atLeastOnce()).delete(any(Visit.class));
    }

    @DisplayName(value = "Delete by id test")
    @Test
    void deleteById() {
        //given - none
        //when
        service.deleteById(1L);

        //then
        then(visitRepository).should(times(1)).deleteById(anyLong());
    }
}