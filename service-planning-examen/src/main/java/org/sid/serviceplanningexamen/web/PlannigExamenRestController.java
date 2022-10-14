package org.sid.serviceplanningexamen.web;

import org.sid.serviceplanningexamen.entities.PlanningExamen;
import org.sid.serviceplanningexamen.fiegn.AnneeUniversitaireRestClient;
import org.sid.serviceplanningexamen.fiegn.ExamenRestClient;
import org.sid.serviceplanningexamen.models.AnneeUniversitaire;
import org.sid.serviceplanningexamen.repositories.PlanningExamenRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

@RestController
public class PlannigExamenRestController {

    private PlanningExamenRepository planningExamenRepository;
    private ExamenRestClient examenRestClient;
    private AnneeUniversitaireRestClient anneeUniversitaireRestClient;

    public PlannigExamenRestController(PlanningExamenRepository planningExamenRepository, ExamenRestClient examenRestClient, AnneeUniversitaireRestClient anneeUniversitaireRestClient){
        this.planningExamenRepository = planningExamenRepository;
        this.examenRestClient = examenRestClient;
        this.anneeUniversitaireRestClient = anneeUniversitaireRestClient;
    }

    @GetMapping("/planningExamens")
    public Collection<PlanningExamen> getPlanning(){
        Collection<PlanningExamen> ListPlanning = planningExamenRepository.findAll();
        ListPlanning.forEach(p->{
            p.setPlanningExamen(null);
            p.setAvisExamen(null);
        });
        return ListPlanning;
    }

    @GetMapping("/downloadAvis/{id}")
    public void downloadAvisExamen(@PathVariable Long id, HttpServletResponse response) throws IOException {
        PlanningExamen p = planningExamenRepository.findById(id).get();
        AnneeUniversitaire AU = anneeUniversitaireRestClient.getAnnee(1L);
        p.setAnneeUniversitaire(AU);
        response.setContentType("application/octet-stream");
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=Avis Examen "+p.getNomFiliere()+" "+p.getAnneeUniversitaire().getNomAnneeUniversitaire()+".pdf";

        response.setHeader(headerKey,headerValue);

        ServletOutputStream servletOutputStream = response.getOutputStream();
        servletOutputStream.write(p.getAvisExamen());
        servletOutputStream.close();
    }

    @GetMapping("/downloadPlanning/{id}")
    public void downloadPlanningExamen(@PathVariable Long id, HttpServletResponse response) throws IOException {
        PlanningExamen p = planningExamenRepository.findById(id).get();
        AnneeUniversitaire AU = anneeUniversitaireRestClient.getAnnee(1L);
        p.setAnneeUniversitaire(AU);
        response.setContentType("application/octet-stream");
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=Planning Examen "+p.getNomFiliere()+" "+p.getAnneeUniversitaire().getNomAnneeUniversitaire()+".pdf";

        response.setHeader(headerKey,headerValue);

        ServletOutputStream servletOutputStream = response.getOutputStream();
        servletOutputStream.write(p.getAvisExamen());
        servletOutputStream.close();
    }

    @PostMapping("/ajouterPlanning")
    public PlanningExamen insertPlannig(@RequestBody PlanningExamen planning){
        return planningExamenRepository.save(planning);
    }

    @PostMapping ("/uploadFiles/{id}")
    public void insertAvis(@PathVariable("id") Long id, @RequestParam("planningExam") MultipartFile planningExam,
                           @RequestParam("avisExam") MultipartFile avisExam) throws IOException {
        PlanningExamen p = planningExamenRepository.findById(id).get();
        p.setPlanningExamen(planningExam.getBytes());
        p.setAvisExamen(avisExam.getBytes());
        planningExamenRepository.save(p);
    }

    @PostMapping("/modifierPlanning")
    public PlanningExamen editPlanning(@RequestParam Long id, @RequestBody PlanningExamen planningExamen){
        return planningExamenRepository.save(planningExamen);
    }

    @DeleteMapping("/supprimerPlanning/{id}")
    public void deletPlanningExamen(@PathVariable Long id){
        examenRestClient.deleteExamensByPlanningId(id);
        planningExamenRepository.deleteById(id);
    }
}
