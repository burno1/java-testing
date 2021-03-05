package sections.six.services.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import sections.five.model.Owner;
import sections.five.model.PetType;
import sections.five.services.PetService;
import sections.five.services.PetTypeService;
import sections.five.services.map.OwnerMapService;
import sections.five.services.map.PetMapService;
import sections.five.services.map.PetTypeMapService;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author: Bruno Fernandes
 * Created at : 05/03/2021
 */
@DisplayName(value = "Owner Map Service Test - ")
class OwnerMapServiceTest {
    OwnerMapService ownerMapService;
    PetTypeService petTypeService;
    PetService petService;

    @BeforeEach
    void setUp() {
        petTypeService = new PetTypeMapService();
        petService = new PetMapService();
        ownerMapService = new OwnerMapService(petTypeService, petService);


    }

    @DisplayName(value = "Test Zero Owners")
    @Test
    void ownersAreZero() {
        int ownerCount = ownerMapService.findAll().size();

        assertThat(ownerCount).isZero();
    }

    @DisplayName(value = "Test Still Zero Owners")
    @Test
    void ownersStillZero() {
        int ownerCount = ownerMapService.findAll().size();

        assertThat(ownerCount).isZero();
    }

    @DisplayName(value = "Pet Type -")
    @Nested
    class TestCreatePetTypes {

        @BeforeEach
        void setUp() {
            PetType dog = new PetType(1L, "dog");
            PetType cat = new PetType(2L, "cat");
            petTypeService.save(dog);
            petTypeService.save(cat);
        }

        @DisplayName(value = "Test Pet Count")
        @Test
        void testPetCount() {
            int petTypeCount = petTypeService.findAll().size();

            assertThat(petTypeCount).isEqualTo(2);
        }

        @DisplayName(value = "Save Owners Test")
        @Nested
        class SaveOwnerTests {

            @BeforeEach
            void setUp() {
                ownerMapService.save(new Owner(1L, "Before", "Each"));
            }

            @DisplayName(value = "Test Save owner")
            @Test
            void saveOwner() {
                Owner owner = new Owner(2L, "Joe", "Buck");
                Owner savedOwner = ownerMapService.save(owner);
                assertThat(savedOwner).isNotNull();
            }

            @DisplayName(value = "Find Owwner Tests")
            @Nested
            class FindOwnerTests {
                @DisplayName(value = "Find Owner")
                @Test
                void findOwner() {
                    Owner foundOwner = ownerMapService.findById(1L);
                    assertThat(foundOwner).isNotNull();
                }

                @DisplayName(value = "Find Owner Not Found")
                @Test
                void findOwnerNotFound() {
                    Owner foundOwner = ownerMapService.findById(2L);

                    assertThat(foundOwner).isNull();
                }
            }
        }
    }
}