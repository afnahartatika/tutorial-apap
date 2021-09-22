package apap.tutorial.cineplux.service;

import apap.tutorial.cineplux.model.BioskopModel;

import java.util.List;

public interface BioskopService {
    // untuk menambah bioskop
    void addBioskop(BioskopModel bioskop);

    // untuk mendapatkan daftar bioskop yang tersimpan
    List<BioskopModel> getBioskopList();

    // untuk mendapatkan data sebuah bioskop berdasarkan id bioskop
    BioskopModel getBioskopByIdBioskop(String idBioskop);

    // latihan 2: update jumlah bioskop
    BioskopModel updateJumlahBioskop(BioskopModel bioskopModel);

    // latihan 3: delete bioskop
    void deleteBioskop(BioskopModel bioskopModel);
}
