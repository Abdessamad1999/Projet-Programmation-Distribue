package org.sid.serviceexamen.web;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExamenRestController {

    @DeleteMapping(path = "/supprimerExamens/{idPlanning}")
    boolean deleteExamensByPlanningId(@PathVariable Long idPlanning){
        return true;
    }
}
