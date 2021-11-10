package apap.tutorial.cineplux.service;

import apap.tutorial.cineplux.model.BioskopModel;
import apap.tutorial.cineplux.model.PenjagaModel;

public interface PenjagaService {
    void addPenjaga(PenjagaModel penjaga);
    // latihan 2
    String updatePenjaga(PenjagaModel penjaga);
    // latihan 3
//    String deletePenjaga(PenjagaModel penjaga);
    PenjagaModel getPenjagaByNoPenjaga(Long noPenjaga);
    // form handler
    int deletePenjaga(PenjagaModel penjaga);
}
