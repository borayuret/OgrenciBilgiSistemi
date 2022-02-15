package tr.gov.ua.obs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tr.gov.ua.obs.entity.Ogrenci;
import tr.gov.ua.obs.exception.OgrenciNotFoundException;
import tr.gov.ua.obs.repository.OgrenciRepository;

import java.util.List;
import java.util.Optional;

@RestController
public class OgrenciController {

    @Autowired
    private OgrenciRepository ogrenciRepository;

    @GetMapping("/ogrenci")
    public List<Ogrenci> getTumOgrenciler()
    {
        return ogrenciRepository.findAll();
    }

    @GetMapping("/ogrenci/{id}")
    public Ogrenci getOgrenciById(@PathVariable("id") long id)
    {
        Ogrenci ogrenci = null;

        Optional<Ogrenci> ogrenciOpt = ogrenciRepository.findById(id);

        if (ogrenciOpt.isPresent())
        {
            ogrenci = ogrenciOpt.get();
            return ogrenci;
        }
        else
        {
            throw new OgrenciNotFoundException(id + " nolu öğrenci bulunamadı!");
        }

    }


    @PostMapping("/ogrenci")
    public Ogrenci kaydet(@RequestBody Ogrenci ogrenci)
    {
        return ogrenciRepository.save(ogrenci);
    }

    @PutMapping("/ogrenci")
    public Ogrenci guncelle(@RequestBody Ogrenci ogrenci)
    {
        return ogrenciRepository.save(ogrenci);
    }

    @DeleteMapping("/ogrenci/{id}")
    public void sil(@PathVariable("id") long id)
    {
        ogrenciRepository.deleteById(id);
    }

}
