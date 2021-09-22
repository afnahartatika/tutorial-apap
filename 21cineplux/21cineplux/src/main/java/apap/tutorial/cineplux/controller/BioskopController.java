package apap.tutorial.cineplux.controller;

import apap.tutorial.cineplux.model.BioskopModel;
import apap.tutorial.cineplux.service.BioskopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@Controller
public class BioskopController {
    @Autowired
    private BioskopService bioskopService;

    // routing url
    @RequestMapping("/bioskop/add")
    public String addBioskop(
            // request parameter yang ingin digunakan
            @RequestParam(value = "idBioskop", required = true) String idBioskop,
            @RequestParam(value = "namaBioskop", required = true) String namaBioskop,
            @RequestParam(value = "alamat", required = true) String alamat,
            @RequestParam(value = "noTelepon", required = true) String noTelepon,
            @RequestParam(value = "jumlahStudio", required = true) int jumlahStudio,
            Model model
    ) {
        // membuat objek BioskopModel
        BioskopModel bioskopModel = new BioskopModel(idBioskop, namaBioskop, alamat, noTelepon, jumlahStudio);

        // menambahkan objek BioskopModel ke dalam service
        bioskopService.addBioskop(bioskopModel);

        // add variabel id bioskop ke "idBioskop" untuk dirender ke dalam thymeleaf
        model.addAttribute("idBioskop", idBioskop);

        // return view template yang digunakan
        return "add-bioskop";

    }

    // getBioskopList
    @RequestMapping("/bioskop/viewall")
    public String listBioskop(Model model){
        // mendapatkan semua bioskop
        List<BioskopModel> listBioskop = bioskopService.getBioskopList();

        // add variable semua BioskopModel ke 'listBioskop' untuk dirender dalam thymeleaf
        model.addAttribute("listBioskop", listBioskop);

        // return view template
        return "viewall-bioskop";
    }

    // getBioskopByIdBioskop
    @RequestMapping("/bioskop/view")
    public String detailBioskop(
            @RequestParam(value = "idBioskop", required = true) String idBioskop, Model model
    ) {
        // mendapatkan bioskop sesuai dengan idBioskop
        BioskopModel bioskopModel = bioskopService.getBioskopByIdBioskop(idBioskop);

        // mendapatkan bioskop sesuai dengan idBioskop
        model.addAttribute("bioskop", bioskopModel);

        return "view-bioskop";
    }

    // latihan 1: view bioskop dengan menggunakan path variable
    @GetMapping(value = {"/bioskop/view/id-bioskop/{idBioskop}", "/bioskop/view/id-bioskop"})
    public String viewBioskopPathVariable(@PathVariable(required = false) String idBioskop, Model model){
        // mendapatkan bioskop sesuai dengan idBioskop
        BioskopModel bioskopModel = bioskopService.getBioskopByIdBioskop(idBioskop);

        // mendapatkan bioskop sesuai dengan idBioskop
        model.addAttribute("bioskop", bioskopModel);

        return "view-bioskop";
    }

    // latihan 2: update jumlah studio
    @GetMapping("/bioskop/update/id-bioskop/{idBioskop}/jumlah-studio/{jumlahStudio}")
    public String updateIdBioskop(@PathVariable String idBioskop, @PathVariable int jumlahStudio, Model model){
        BioskopModel bioskopModel = bioskopService.getBioskopByIdBioskop(idBioskop);
        bioskopModel.setJumlahStudio(jumlahStudio);
        bioskopService.updateJumlahBioskop(bioskopModel);
        model.addAttribute("bioskop", bioskopModel);

        return "update-bioskop";
    }

    // latihan 3: delete bioskop
    @GetMapping("/bioskop/delete/id-bioskop/{idBioskop}")
    public String deleteBioskop(@PathVariable String idBioskop, Model model){
        BioskopModel bioskopModel = bioskopService.getBioskopByIdBioskop(idBioskop);
        bioskopService.deleteBioskop(bioskopModel);

        return "delete-bioskop";
    }

}
