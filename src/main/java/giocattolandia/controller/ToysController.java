package giocattolandia.controller;

import giocattolandia.exceptions.CustomException.*;
import giocattolandia.model.Toys;
import giocattolandia.service.ToysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/toys")
public class ToysController {

    @Autowired
    private ToysService toysService;

    @GetMapping("/list")
    public ResponseEntity<?> retrieveAllToys(){
        try {
            return ResponseEntity.ok(toysService.retrieveToysList());
        }catch (NotFoundException e){
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @GetMapping("/toysById")
    public ResponseEntity<?> retrieveToysById(@RequestParam Long id){
        try {
            return ResponseEntity.ok(toysService.retrieveToysById(id));
        }catch (NotFoundException e){
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @GetMapping("/listByName")
    public ResponseEntity<?> retrieveToysByName(@RequestParam String partOrFullname){
        try {
            return ResponseEntity.ok(toysService.retrieveToysByName(partOrFullname));
        }catch (NotFoundException e){
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @GetMapping("/listByBarCode")
    public ResponseEntity<?> retrieveToysByBarCode(@RequestParam Long barCode){
        try {
            return ResponseEntity.ok(toysService.retrieveToysByBarCode(barCode));
        }catch (NotFoundException e){
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @GetMapping("/listByNameAndAvaiability")
    public ResponseEntity<?> retrieveToysByNameAndAvaiability(@RequestParam String name, boolean avaibility){
        try {
            return ResponseEntity.ok(toysService.retrieveToysByNameAndAvaiability(name, avaibility));
        }catch (NotFoundException e){
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @PostMapping("/insertNewToys")
    public ResponseEntity<Toys> insertNewToys(@RequestBody Toys toys){
        return ResponseEntity.ok(toysService.manageToys(toys));
    }

    @PutMapping("/editToys")
    public ResponseEntity<Toys> editToys(@RequestBody Toys toys){
        return ResponseEntity.ok(toysService.manageToys(toys));
    }

    @DeleteMapping("/deleteToysByName")
    public ResponseEntity<?> deleteToysByName(@RequestParam Long barCode){
        try {
            toysService.deleteToysByName(barCode);
            return ResponseEntity.ok("Toys with barcode " + barCode + " was deleted");
        }catch (NotFoundException e){
            return ResponseEntity.status(404).body(e.getMessage());
        }    }
}
