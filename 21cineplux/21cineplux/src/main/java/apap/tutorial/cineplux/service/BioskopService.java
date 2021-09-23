package apap.tutorial.cineplux.service;

import apap.tutorial.cineplux.model.BioskopModel;

import java.util.List;

public interface BioskopService {
    void addBioskop(BioskopModel bioskop);
    void updateBioskop(BioskopModel bioskop);
    List<BioskopModel> getBioskopList();
    // latihan 1
    List<BioskopModel> getBioskopSortList();
    // latihan 4
    String deleteBioskop(BioskopModel bioskop);
    BioskopModel getBioskopByNoBioskop(Long noBioskop);
}
