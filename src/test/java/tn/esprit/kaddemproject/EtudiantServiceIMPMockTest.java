package tn.esprit.kaddemproject;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.kaddemproject.entities.Etudiant;
import tn.esprit.kaddemproject.repositories.EtudiantRepository;
import tn.esprit.kaddemproject.services.IEtudiantServiceImp;


@SpringBootTest
public class EtudiantServiceIMPMockTest {

    @Mock
    private Etudiant etudiant;

    @InjectMocks
    private IEtudiantServiceImp etudiantServiceImp;

    @Mock
    private EtudiantRepository etudiantRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetterAndSetterForNomDepart() {
        Etudiant etudiant = new Etudiant("BILEL");
        String nom = etudiant.getNomE();
        assertEquals("BILEL", nom);
    }

    @Test
    public void testCreateEtudiant() {
        Etudiant etudiant = new Etudiant("bilel abbassi");

        when(etudiantRepository.save(any(Etudiant.class))).thenReturn(etudiant);

        Etudiant savedEtudiant = etudiantServiceImp.add(etudiant);

        assertNotNull(savedEtudiant);
        assertEquals("bilel abbassi", savedEtudiant.getNomE());
    }

    @Test
    public void testReadEtudiant() {
        Integer id = 1;
        String expectedName = "bilelabbassi";

        Etudiant expectedEtudiant = new Etudiant(expectedName);
        when(etudiantRepository.findById(id)).thenReturn(Optional.of(expectedEtudiant));

        Etudiant foundEtudiant = etudiantServiceImp.retrieveById(id);

        assertNotNull(foundEtudiant);
        assertEquals(expectedName, foundEtudiant.getNomE());
    }

    @Test
    public void testUpdateEtudiant() {
        Integer id = 1;
        Etudiant etudiant = new Etudiant("bilel");

        when(etudiantRepository.findById(id)).thenReturn(Optional.of(etudiant));
        when(etudiantRepository.save(any(Etudiant.class))).thenReturn(etudiant);

        etudiant.setNomE("bilel is the best");
        Etudiant updateEtudiant= etudiantServiceImp.update(etudiant);

        assertNotNull(updateEtudiant);
        assertEquals("bilel is the best", updateEtudiant.getNomE());
    }

    @Test
    public void testDeleteEtudiant() {
        Integer id = 1;
        Etudiant etudiant = new Etudiant("bilel");

        when(etudiantRepository.findById(id)).thenReturn(Optional.of(etudiant));
        when(etudiantRepository.existsById(id)).thenReturn(true);
        Mockito.doNothing().when(etudiantRepository).deleteById(id);
        boolean deleted = etudiantServiceImp.delete(id);

        assertTrue(deleted);
    }

    
}
