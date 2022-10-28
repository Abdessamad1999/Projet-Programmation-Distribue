package org.sid.serviceplanningexamen.web;

import org.sid.serviceplanningexamen.entities.PlanningExamen;
import org.sid.serviceplanningexamen.fiegn.AnneeUniversitaireRestClient;
import org.sid.serviceplanningexamen.fiegn.ExamenRestClient;
import org.sid.serviceplanningexamen.models.AnneeUniversitaire;
import org.sid.serviceplanningexamen.repositories.PlanningExamenRepository;
import org.springframework.http.MediaType;
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

    public PlannigExamenRestController(PlanningExamenRepository planningExamenRepository,
                                       ExamenRestClient examenRestClient, AnneeUniversitaireRestClient anneeUniversitaireRestClient){
        this.planningExamenRepository = planningExamenRepository;
        this.examenRestClient = examenRestClient;
        this.anneeUniversitaireRestClient = anneeUniversitaireRestClient;
    }

    @GetMapping("/PlanningExamens")
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
        AnneeUniversitaire AU = anneeUniversitaireRestClient.getAnnee(p.getIdAnneeUniversitaire());
        response.setContentType("application/octet-stream");
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=Avis Examen "+p.getNomFiliere()+" "+AU.getNomAnneeUniversitaire()+".pdf";

        response.setHeader(headerKey,headerValue);

        ServletOutputStream servletOutputStream = response.getOutputStream();
        servletOutputStream.write(p.getAvisExamen());
        servletOutputStream.close();
    }

    @GetMapping("/downloadPlanning/{id}")
    public void downloadPlanningExamen(@PathVariable Long id, HttpServletResponse response) throws IOException {
        PlanningExamen p = planningExamenRepository.findById(id).get();
        AnneeUniversitaire AU = anneeUniversitaireRestClient.getAnnee(p.getIdAnneeUniversitaire());
        response.setContentType("application/octet-stream");
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=Planning Examen "+p.getNomFiliere()+" "+AU.getNomAnneeUniversitaire()+".pdf";

        response.setHeader(headerKey,headerValue);

        ServletOutputStream servletOutputStream = response.getOutputStream();
        servletOutputStream.write(p.getPlanningExamen());
        servletOutputStream.close();
    }

    @PostMapping(value = "/ajouterPlanning", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public PlanningExamen insertPlannig(@RequestPart("planning") PlanningExamen planning,@RequestPart("planningExam") MultipartFile planningExam,
                                        @RequestPart("avisExam") MultipartFile avisExam) throws IOException{
        planning.setPlanningExamen(planningExam.getBytes());
        planning.setAvisExamen(avisExam.getBytes());
        return planningExamenRepository.save(planning);
    }

    @PutMapping("/modifierPlanning")//
    public PlanningExamen editPlanning(@RequestPart("planning") PlanningExamen planning,@RequestPart("planningExam") MultipartFile planningExam,
                                       @RequestPart("avisExam") MultipartFile avisExam) throws IOException{

        if(planningExam!=null && avisExam!=null){
            planning.setAvisExamen(avisExam.getBytes());
            planning.setPlanningExamen(planningExam.getBytes());
        }else {
            PlanningExamen p = planningExamenRepository.findById(planning.getId()).get();
            if(planningExam==null && avisExam == null){
                planning.setAvisExamen(p.getAvisExamen());
                planning.setPlanningExamen(p.getPlanningExamen());
            }else if(planningExam!= null){
                planning.setAvisExamen(p.getAvisExamen());
                planning.setPlanningExamen(planningExam.getBytes());
            }else {
                planning.setAvisExamen(avisExam.getBytes());
                planning.setPlanningExamen(p.getPlanningExamen());
            }
        }

        return planningExamenRepository.save(planning);
    }

    @DeleteMapping("/supprimerPlanning/{id}")
    public void deletPlanningExamen(@PathVariable Long id){
        examenRestClient.deleteExamensByPlanningId(id);
        planningExamenRepository.deleteById(id);
    }
}
