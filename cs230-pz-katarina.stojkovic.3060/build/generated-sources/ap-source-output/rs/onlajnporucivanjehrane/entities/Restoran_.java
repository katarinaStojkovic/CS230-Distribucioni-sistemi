package rs.onlajnporucivanjehrane.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import rs.onlajnporucivanjehrane.entities.Jelo;
import rs.onlajnporucivanjehrane.entities.User;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-08-21T03:44:42")
@StaticMetamodel(Restoran.class)
public class Restoran_ { 

    public static volatile ListAttribute<Restoran, Jelo> jeloList;
    public static volatile SingularAttribute<Restoran, String> naziv;
    public static volatile SingularAttribute<Restoran, Integer> pib;
    public static volatile SingularAttribute<Restoran, String> adresa;
    public static volatile SingularAttribute<Restoran, User> userid;
    public static volatile SingularAttribute<Restoran, Integer> idrestorana;

}