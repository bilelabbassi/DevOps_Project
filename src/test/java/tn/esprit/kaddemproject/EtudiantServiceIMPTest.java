package tn.esprit.kaddemproject;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.kaddemproject.entities.Etudiant;
import tn.esprit.kaddemproject.services.IEtudiantService;

@SpringBootTest
@Slf4j
public class EtudiantServiceIMPTest {

    @Autowired
  private IEtudiantService etudiantService;


    @Test
    public void shouldAddEtudiant() {
        Etudiant etudiant = new Etudiant("bilel");
        Etudiant savedEtudiant = etudiantService.add(etudiant);

        assertNotNull(savedEtudiant);
        assertNotNull(savedEtudiant.getNomE());
        assertEquals("bilel", savedEtudiant.getNomE());

        etudiantService.delete(savedEtudiant.getIdEtudiant());
    }

    @Test
    public void shouldUpdateEtudiant() {
        Etudiant etudiant = new Etudiant("bilel abbassi");
        Etudiant savedEtudiant = etudiantService.add(etudiant);

        assertNotNull(savedEtudiant);
        assertNotNull(savedEtudiant.getNomE());

        etudiant.setNomE("bilel is the best");
        etudiantService.update(etudiant);
        log.info("etudiant updated");

        Etudiant updatedEtudiant = etudiantService.retrieveById(savedEtudiant.getIdEtudiant());
        assertEquals("bilel is the best", updatedEtudiant.getNomE());

        etudiantService.delete(savedEtudiant.getIdEtudiant());
        log.info("aaa");

    }

    @Test
    public void ShouldCheckEtudiantListSize(){
        int size = etudiantService.retrieveAll().size();
        Etudiant etudiant = new Etudiant("bilel");
        Etudiant savedEtudiant = etudiantService.add(etudiant);

        //log.info("processing...");
        //assertEquals(size+1, savedEtudiant.retrieveAll().size());
        }
    
}
