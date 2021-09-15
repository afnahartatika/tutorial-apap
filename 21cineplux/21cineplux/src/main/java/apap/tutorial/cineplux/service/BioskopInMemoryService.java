package apap.tutorial.cineplux.service;

import apap.tutorial.cineplux.model.BioskopModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BioskopInMemoryService implements BioskopService {

    private List<BioskopModel> listBioskop;

    // constructor
    public BioskopInMemoryService() {
        listBioskop = new ArrayList<>();
    }

    @Override
    public void addBioskop(BioskopModel bioskop) {
        listBioskop.add(bioskop);
    }

    @Override
    public List<BioskopModel> getBioskopList() {
        return listBioskop;
    }

    @Override
    public BioskopModel getBioskopByIdBioskop(String idBioskop) {
        for(BioskopModel bioskop:listBioskop) {
            if (bioskop.getIdBioskop().equals(idBioskop)) {
                return bioskop;
            }
        }

        return null;
    }

    // latihan 2: update jumlah bioskop
    @Override
    public BioskopModel updateJumlahBioskop(BioskopModel bioskopModel) {
        for (int i=0; i<listBioskop.size(); i++){
            if (listBioskop.get(i).getIdBioskop().equals(bioskopModel.getIdBioskop())){
                listBioskop.set(i,bioskopModel);
            }
        }

        return bioskopModel;
    }

    @Override
    public void deleteBioskop(BioskopModel bioskopModel) {
        for (int i=0; i<listBioskop.size(); i++){
            if (listBioskop.get(i).getIdBioskop().equals(bioskopModel.getIdBioskop())){
                listBioskop.remove(i);
            }
        }
    }
}
