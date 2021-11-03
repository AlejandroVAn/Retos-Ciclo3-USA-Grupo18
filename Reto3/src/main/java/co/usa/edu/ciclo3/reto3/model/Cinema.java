package co.usa.edu.ciclo3.reto3.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="cinema")
public class Cinema implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String owner;
    private Integer capacity;
    private Integer category_id;
    private String name;


}
