package com.haydikodlayalim.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity //bu bir veri tabani entity si
@Table(name = "person")
@AllArgsConstructor //tum alanlarin dahil oldugu bir constructor
@NoArgsConstructor //parametresiz constructor
@Getter //tum alanlarin getter metodu olsun
@Setter
@EqualsAndHashCode(of = {"id"}) //iki tane nesnenin id si birbirine esit ise bu iki nesne birbirine esittir
@ToString //OTOMATIK TOSTRING METODU YARATIR
public class Person {

    @Id //tabloyla calisiyorsak primary key olmali
    @SequenceGenerator(name = "seq_person", allocationSize = 1) //oto artim 1er 1 er artsin
    @GeneratedValue(generator = "seq_person", strategy = GenerationType.SEQUENCE) //oto artim sequenci yukardakidir, veri tabanina bunu yolla demek. Aslinda mysql de felan boyle degil, burada sequence kullanilmali
    private Long id;

    @Column(name = "name", length = 80) //bu annotation lara bir cok parametre girilebilir
    private String name;

    @Column(name = "surname", length = 80) //bu annotation lara bir cok parametre girilebilir
    private String surname;

    //join islemi, iki tabloyu baglayacagiz
    @OneToMany //Bir kisi nesnesi bir cok adrese gidebilir
    @JoinColumn(name = "person_address_id") //join isleminin ismi
    private List<Address> addresses;

    //column annotation lari vs jpa dan gelir
}
