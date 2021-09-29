package com.haydikodlayalim.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity //bu bir veri tabani entity si
@Table(name = "person_address")
@AllArgsConstructor //tum alanlarin dahil oldugu bir constructor
@NoArgsConstructor //parametresiz constructor
@Getter //tum alanlarin getter metodu olsun
@Setter
@EqualsAndHashCode(of = {"id"}) //iki tane nesnenin id si birbirine esit ise bu iki nesne birbirine esittir
@ToString //OTOMATIK TOSTRING METODU YARATIR
public class Address implements Serializable {

    @Id //tabloyla calisiyorsak primary key olmali
    @SequenceGenerator(name = "seq_person_address", allocationSize = 1) //oto artim 1er 1 er artsin
    @GeneratedValue(generator = "seq_person_address", strategy = GenerationType.SEQUENCE) //oto artim sequenci yukardakidir, veri tabanina bunu yolla demek. Aslinda mysql de felan boyle degil, burada sequence kullanilmali
    private Long id;

    @Column(name = "address", length = 500) //bu annotation lara bir cok parametre girilebilir
    private String address;

    @Enumerated //enum ile yaratilmis
    private AddressType addressType;

    @Column(name = "isActive")
    private Boolean isActive; //ilgili kayit aktif mi

    //join islemi, iki tabloyu baglayacagiz
    @ManyToOne //Bir cok adress bir kisiye gidebilir
    @JoinColumn(name = "address_person_id") //join isleminin ismi
    private Person person; //liste olamaz

    public enum AddressType {
        HOME_ADDRESS,
        WORK_ADRESS,
        OTHER
    }
}
