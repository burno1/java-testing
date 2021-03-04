package sections.five.services.springdatajpa;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import sections.five.model.Owner;

import static org.junit.jupiter.api.Assertions.*;

@Disabled(value = "Disabled until we learn Mocking")
class OwnerSDJpaServiceTest {

    OwnerSDJpaService ownerService;

    @BeforeEach
    void setUp() {
        ownerService = new OwnerSDJpaService(null,null,null);
    }

    @AfterEach
    void tearDown() {
    }

    @Disabled
    @Test
    void findByLastName() {
        Owner buck = ownerService.findByLastName("Buck");
    }

    @Test
    void findAllByLastNameLike() {
    }

    @Test
    void findAll() {
    }

    @Test
    void findById() {
    }

    @Test
    void save() {
    }

    @Test
    void delete() {
    }

    @Test
    void deleteById() {
    }
}