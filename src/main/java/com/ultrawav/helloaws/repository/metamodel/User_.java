package com.ultrawav.helloaws.repository.metamodel;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import com.ultrawav.helloaws.repository.entity.User;

@StaticMetamodel(User.class)
public class User_ {

	public static volatile SingularAttribute<User, String> name;
}
