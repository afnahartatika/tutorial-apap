package apap.tutorial.cineplux.service;

import apap.tutorial.cineplux.model.PenjagaModel;
import apap.tutorial.cineplux.repository.PenjagaDB;
import apap.tutorial.cineplux.rest.PenjagaDetail;
import apap.tutorial.cineplux.rest.Setting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import javax.transaction.Transactional;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Transactional
public class PenjagaRestServiceImpl implements PenjagaRestService {

    private final WebClient webClient;

    @Autowired
    private PenjagaDB penjagaDB;

    @Override
    public PenjagaModel createPenjaga(PenjagaModel penjaga) {
        return penjagaDB.save(penjaga);
    }

    @Override
    public List<PenjagaModel> retrieveListPenjaga() {
        return penjagaDB.findAll();
    }

    @Override
    public PenjagaModel getPenjagaByNoPenjaga(Long noPenjaga) {
        Optional<PenjagaModel> penjaga = penjagaDB.findByNoPenjaga(noPenjaga);

        if (penjaga.isPresent()) {
            return penjaga.get();
        } else {
            throw new NoSuchElementException();
        }

    }

    // challenge
    @Override
    public List<PenjagaModel> getPenjagaByJenisKelamin(Integer jenisKelamin, List<PenjagaModel> penjagaModelList) {
        List<PenjagaModel> listPenjagaByJenisKelamin = new ArrayList<>();
        for (PenjagaModel p : penjagaModelList) {
            if (p.getJenisKelamin() == jenisKelamin) listPenjagaByJenisKelamin.add(p);
        } return listPenjagaByJenisKelamin;
    }

    @Override
    public void umur(Long noPenjaga) {
        PenjagaModel penjaga = getPenjagaByNoPenjaga(noPenjaga);
        Mono<PenjagaDetail> umur = this.webClient.get().uri("?name=" + penjaga.getNamaPenjaga()).retrieve().bodyToMono(PenjagaDetail.class);
        Integer usia = umur.block().getAge();
        penjaga.setUmur(usia);
    }

    @Override
    public PenjagaModel updatePenjaga(Long noPenjaga, PenjagaModel penjagaUpdate) {
        PenjagaModel penjaga = getPenjagaByNoPenjaga(noPenjaga);
        penjaga.setNamaPenjaga(penjagaUpdate.getNamaPenjaga());
        penjaga.setJenisKelamin(penjagaUpdate.getJenisKelamin());

        return penjagaDB.save(penjaga);
    }

    @Override
    public void deletePenjaga(Long noPenjaga) {
        LocalTime now = LocalTime.now();
        PenjagaModel penjaga = getPenjagaByNoPenjaga(noPenjaga);

        if (now.isBefore(penjaga.getBioskop().getWaktuBuka()) || now.isAfter(penjaga.getBioskop().getWaktuTutup())) {
            penjagaDB.delete(penjaga);
        } else {
            throw new UnsupportedOperationException("Bioskop still open!");
        }
    }

    public PenjagaRestServiceImpl(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://api.agify.io").build();
    }

    @Override
    public Mono<String> getStatus(Long noPenjaga) {
        return this.webClient.get().uri("/rest/penjaga/" + noPenjaga + "/status").retrieve().bodyToMono(String.class);
    }

    @Override
    public Mono<PenjagaDetail> postStatus() {
        MultiValueMap<String, String> data = new LinkedMultiValueMap<>();
        data.add("namaPenjaga", "Penjaga Mock Server");
        data.add("jenisKelamin", "Perempuan");

        return this.webClient.post().uri("/rest/penjaga/full").syncBody(data).retrieve().bodyToMono(PenjagaDetail.class);
    }


}
