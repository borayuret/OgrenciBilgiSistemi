package tr.gov.ua.obs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tr.gov.ua.obs.entity.Dolap;
import tr.gov.ua.obs.entity.Ogrenci;
import tr.gov.ua.obs.repository.OgrenciRepository;

@SpringBootApplication
public class OgrenciBilgiSistemiApplication implements CommandLineRunner {

    @Autowired
    private OgrenciRepository ogrenciRepository;

    public static void main(String[] args) {
        SpringApplication.run(OgrenciBilgiSistemiApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {

        Ogrenci ogr1 = new Ogrenci();
        ogr1.setOgrenciNo(123456);
        ogr1.setAd("Vladimir");
        ogr1.setSoyad("Putin");
        ogr1.setTur("TM");
        ogr1.setHarc(2500.15);

        Ogrenci ogr2 = new Ogrenci();
        ogr2.setOgrenciNo(8888);
        ogr2.setAd("Aziz");
        ogr2.setSoyad("Sancar");
        ogr2.setTur("DNA");
        ogr2.setHarc(50000);

        Ogrenci ogr3 = new Ogrenci();
        ogr3.setOgrenciNo(123456);
        ogr3.setAd("Oktay");
        ogr3.setSoyad("Sinanoğlu");
        ogr3.setTur("TR");
        ogr3.setHarc(1000);


        Dolap dolap1 = new Dolap();
        dolap1.setDolapNo("D1001");

        Dolap dolap2 = new Dolap();
        dolap2.setDolapNo("D1002");

        Dolap dolap3 = new Dolap();
        dolap3.setDolapNo("D1003");

        Dolap dolap4 = new Dolap();
        dolap4.setDolapNo("D1004");

        ogr1.getDolaplar().add(dolap1);
        ogr1.getDolaplar().add(dolap2);
        ogr2.getDolaplar().add(dolap3);
        ogr3.getDolaplar().add(dolap4);

        // unidirectional'dan bidirectional'a çevirirsek,
        // objeleri de çift taraflı bağlamak zorundayız.
        dolap1.setOgrenci(ogr1);
        dolap2.setOgrenci(ogr1);
        dolap3.setOgrenci(ogr2);
        dolap4.setOgrenci(ogr3);


        ogrenciRepository.save(ogr1);
        ogrenciRepository.save(ogr2);
        ogrenciRepository.save(ogr3);






    }
}
