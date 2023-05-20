package visitorSpring.development.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import visitorSpring.development.JpaRepo.ReviewRepo;
import visitorSpring.development.JpaRepo.TotalVisitRepo;
import visitorSpring.development.JpaRepo.VisitorJpaRepo;
import visitorSpring.development.Model.Review;
import visitorSpring.development.Model.Visitor;
import visitorSpring.development.Model.TotalVisits;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {

    @Autowired
    VisitorJpaRepo visitorJpaRepo;
    @Autowired
    TotalVisitRepo totalVisitRepo;
    @Autowired
    ReviewRepo reviewRepo;
    @Autowired
    Visitor visitor;
    @Autowired
    TotalVisits totalVisits;
    @Autowired
    Review review;

    @GetMapping("/allvisitors")
    public List<Visitor> allVisitors(){
        return visitorJpaRepo.findAll();
    }

    @GetMapping("/visitor/{id}")
    public ResponseEntity<Visitor> visitorById(@PathVariable int id){
        Optional<Visitor> optionalVisitor = this.visitorJpaRepo.findById(id);
        if(optionalVisitor.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        Visitor existingVisitor = optionalVisitor.get();
        return ResponseEntity.created(null).body(existingVisitor);
    }

    @PostMapping("/newvisitor")
    public ResponseEntity<Visitor> createVisitor(@RequestBody Visitor visitor){

         this.visitorJpaRepo.save(visitor);
         return ResponseEntity.created(null).build();
    }


    @PostMapping("/updatevisitor")
    public ResponseEntity<Visitor> updateVisitor(@PathVariable int id){
        Optional<TotalVisits> existingVisitor = this.totalVisitRepo.findById(id);
        if(existingVisitor.isPresent()){
            TotalVisits totalVisits = existingVisitor.get();
            totalVisits.setVisitNo(totalVisits.getVisitNo()+1);
            totalVisits.setDate(Date.from(Instant.now()));
            totalVisits.setNotes("Revisiting");
            this.totalVisitRepo.save(totalVisits);
        }
        else{
            this.visitorJpaRepo.save(visitor);
            this.totalVisitRepo.save(totalVisits);
        }
        return ResponseEntity.created(null).build();
    }


    @DeleteMapping("/deletevisitor")
    public ResponseEntity<Visitor> deleteVisitor(@PathVariable int id){
        Optional<Visitor> visitorOptional = this.visitorJpaRepo.findById(id);
        if(visitorOptional.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        Visitor existingVisitor = visitorOptional.get();
        visitorJpaRepo.delete(existingVisitor);
        return ResponseEntity.created(null).build();
    }



}
