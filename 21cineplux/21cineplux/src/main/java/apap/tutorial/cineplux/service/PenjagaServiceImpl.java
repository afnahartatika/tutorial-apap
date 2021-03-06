package apap.tutorial.cineplux.service;

import apap.tutorial.cineplux.model.BioskopModel;
import apap.tutorial.cineplux.model.PenjagaModel;
import apap.tutorial.cineplux.repository.PenjagaDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalTime;
import java.util.Optional;

@Service
@Transactional
public class PenjagaServiceImpl implements PenjagaService {

    @Autowired
    PenjagaDB penjagaDB;

    @Override
    public void addPenjaga(PenjagaModel penjaga) { penjagaDB.save(penjaga); }

    // latihan 2
    @Override
    public String updatePenjaga(PenjagaModel penjaga) {
        if (penjaga.getBioskop().getWaktuBuka().isBefore(LocalTime.now()) && penjaga.getBioskop().getWaktuTutup().isAfter(LocalTime.now())) {
            return "time-failed";
        } else {
            penjagaDB.save(penjaga);
            return "update-success";
        }
    }

    // latihan 3
    @Override
    public int deletePenjaga(PenjagaModel penjaga) {
        if (penjaga.getBioskop().getWaktuBuka().isBefore(LocalTime.now()) && penjaga.getBioskop().getWaktuTutup().isAfter(LocalTime.now())) {
//            return "time-failed";
            return 0;
        } else {
            penjagaDB.delete(penjaga);
//            return "delete-success";
            return 1;
        }
    }

    @Override
    public PenjagaModel getPenjagaByNoPenjaga(Long noPenjaga) {
        Optional<PenjagaModel> penjaga = penjagaDB.findByNoPenjaga(noPenjaga);
        if (penjaga.isPresent()) {
            return penjaga.get();
        }
        return null;
    }
}
