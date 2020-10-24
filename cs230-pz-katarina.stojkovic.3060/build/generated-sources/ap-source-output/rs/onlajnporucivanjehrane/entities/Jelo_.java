package rs.onlajnporucivanjehrane.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import rs.onlajnporucivanjehrane.entities.Porudzbina;
import rs.onlajnporucivanjehrane.entities.Restoran;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-08-21T03:44:42")
@StaticMetamodel(Jelo.class)
public class Jelo_ { 

    public static volatile SingularAttribute<Jelo, Integer> idjela;
    public static volatile SingularAttribute<Jelo, String> nazivJela;
    public static volatile ListAttribute<Jelo, Porudzbina> porudzbinaList;
    public static volatile SingularAttribute<Jelo, Long> cena;
    public static volatile SingularAttribute<Jelo, String> opis;
    public static volatile SingularAttribute<Jelo, Restoran> idrestorana;

}