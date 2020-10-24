package rs.onlajnporucivanjehrane.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import rs.onlajnporucivanjehrane.entities.User;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-08-21T03:44:42")
@StaticMetamodel(Role.class)
public class Role_ { 

    public static volatile ListAttribute<Role, User> userList;
    public static volatile SingularAttribute<Role, Integer> roleId;
    public static volatile SingularAttribute<Role, String> nazivRole;

}