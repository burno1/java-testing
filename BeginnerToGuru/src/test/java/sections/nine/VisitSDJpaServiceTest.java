package sections.nine;

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
import static org.mockito.Mockito.*;

/**
 * Author: Bruno Fernandes
 * Created at : 08/03/2021
 */
@ExtendWith(MockitoExtension.class)
class VisitSDJpaServiceTest {

    @Mock
    VisitRepository visitRepository;

    @InjectMocks
    VisitSDJpaService service;

    @DisplayName(value = "Find all Test")
    @Test
    void findAll() {
        Visit visit = new Visit();

        Set<Visit> visits = new HashSet<>();
        visits.add(visit);

        when(visitRepository.findAll()).thenReturn(visits);

        Set<Visit> found = service.findAll();

        verify(visitRepository).findAll();

        assertThat(found).hasSize(1);
    }

    @DisplayName(value = "Test Find By id")
    @Test
    void findById() {
        Visit visit = new Visit();

        when(visitRepository.findById(1L)).thenReturn(Optional.of(visit));

        Visit foundVisit = service.findById(1L);

        assertThat(foundVisit).isNotNull();

        verify(visitRepository).findById(anyLong());
    }

    @DisplayName(value = "Save test")
    @Test
    void save() {
        Visit visit = new Visit();
        visit.setDescription("new visit");
        when(visitRepository.save(visit)).thenReturn(visit);

        Visit visitSaved = service.save(visit);

        assertThat(visitSaved).isNotNull();

        verify(visitRepository).save(any(Visit.class));
    }

    @DisplayName(value = "Delete object test")
    @Test
    void delete() {
        service.delete(new Visit());
        verify(visitRepository, atLeastOnce()).delete(any(Visit.class));
    }

    @DisplayName(value = "Delete by id test")
    @Test
    void deleteById() {
        service.deleteById(1L);
        verify(visitRepository,times(1)).deleteById(anyLong());
    }
}