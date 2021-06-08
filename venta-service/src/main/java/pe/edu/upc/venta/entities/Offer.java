package pe.edu.upc.venta.entities;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

//1
//ES IGUAL "private Date createdAt" A "@CreatedDate"?????
@Entity
@Table(name = "offers")
@Data
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "offer_name", length = 40, nullable = false)
    private String offerName;

    @Column(name = "description", length = 50, nullable = false)
    @Lob //del projecto monolitico
    private String description;

    @Column(name = "image_url", length = 50, nullable = false)
    @Lob //del projecto monolitico
    private String imageUrl;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "start_date", nullable = false, updatable = false)
    @CreatedDate
    private Date startDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "end_date", nullable = false, updatable = false)
    @CreatedDate
    private Date endDate;

    @Column(name = "offer_price", nullable = false)
    private Double offerPrice;

    //Buenas Practicas
    //Createdat y Status
    @Column(name = "created_at")//Forma correcta para el nombre de una tabla
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;  //tener cuidado con los nombres para un atributo de una clase

    @Column(length = 1, nullable = false)
    private String status;

    //****************************************************
    //Relaciones(No tiene Foreign Keys)

    //LAS RELACIONES SOLO SE PONEN EL MANYTOONE???????????????
}
