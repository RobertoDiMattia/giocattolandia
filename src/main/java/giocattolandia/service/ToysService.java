package giocattolandia.service;

import giocattolandia.exceptions.CustomException.*;
import giocattolandia.model.Toys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import giocattolandia.repository.ToysRepository;

import java.util.List;

@Service
public class ToysService {

    @Autowired
    private ToysRepository toysRepository;

    public List<Toys> retrieveToysList() {
        if (toysRepository.findAll().isEmpty()) { throw new NotFoundException("No Element Inside The List");}
        return toysRepository.findAll();
    }

    public List<Toys> retrieveToysByName(String name) {
        if (toysRepository.findByPieceOfName(name).isEmpty()) { throw new NotFoundException("No Match for the characters " + name);}
        return toysRepository.findByPieceOfName(name);
    }

    public Toys retrieveToysByBarCode(Long barCode) {
        if (toysRepository.findByBarCode(barCode) == null) { throw new NotFoundException("No Match for the barCode " + barCode);}
        return toysRepository.findByBarCode(barCode);
    }

    public List<Toys> retrieveToysByNameAndAvaiability(String name, boolean avaibility) {
        if (toysRepository.findToysByNameAndAvaiability(name, avaibility).isEmpty()) { throw new NotFoundException("No Element Inside The List");}
        return toysRepository.findToysByNameAndAvaiability(name, avaibility);
    }

    public Toys manageToys(Toys toys) {
        return toysRepository.save(toys);
    }

    public void deleteToysByName(Long barCode) {
        if (toysRepository.findByBarCode(barCode) == null) { throw new NotFoundException("No Match for the barCode " + barCode);}
        toysRepository.delete(toysRepository.findByBarCode(barCode));
    }

    public Toys retrieveToysById(long id) {
        return toysRepository.findById(id).orElseThrow(()-> new NotFoundException("No user with the follow id " + id + " was found"));
    }
}
