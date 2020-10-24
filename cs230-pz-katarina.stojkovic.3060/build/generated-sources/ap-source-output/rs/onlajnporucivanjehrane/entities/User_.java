package rs.onlajnporucivanjehrane.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import rs.onlajnporucivanjehrane.entities.Porudzbina;
import rs.onlajnporucivanjehrane.entities.Restoran;
import rs.onlajnporucivanjehrane.entities.Role;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-08-21T03:44:42")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, String> ime;
    public static volatile SingularAttribute<User, String> prezime;
    public static volatile SingularAttribute<User, String> password;
    public static volatile SingularAttribute<User, Role> role;
    public static volatile SingularAttribute<User, Date> datumrodjenja;
    public static volatile ListAttribute<User, Restoran> restoranList;
    public static volatile SingularAttribute<User, String> telefon;
    public static volatile ListAttribute<User, Porudzbina> porudzbinaList;
    public static volatile SingularAttribute<User, Integer> userid;
    public static volatile SingularAttribute<User, String> email;
    public static volatile SingularAttribute<User, String> username;

}