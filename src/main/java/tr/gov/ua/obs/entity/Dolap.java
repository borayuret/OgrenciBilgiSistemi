package tr.gov.ua.obs.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Dolap {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String dolapNo;

}
