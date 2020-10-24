package rs.onlajnporucivanjehrane.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import rs.onlajnporucivanjehrane.entities.Jelo;
import rs.onlajnporucivanjehrane.entities.Recenzije;
import rs.onlajnporucivanjehrane.entities.User;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-08-21T03:44:42")
@StaticMetamodel(Porudzbina.class)
public class Porudzbina_ { 

    public static volatile SingularAttribute<Porudzbina, Integer> idporudzbina;
    public static volatile SingularAttribute<Porudzbina, Jelo> idjela;
    public static volatile ListAttribute<Porudzbina, Recenzije> recenzijeList;
    public static volatile SingularAttribute<Porudzbina, String> adresaisporuke;
    public static volatile SingularAttribute<Porudzbina, Integer> kolicina;
    public static volatile SingularAttribute<Porudzbina, User> userid;
    public static volatile SingularAttribute<Porudzbina, Date> datumisporuke;
    public static volatile SingularAttribute<Porudzbina, Date> vremeisporuke;

}