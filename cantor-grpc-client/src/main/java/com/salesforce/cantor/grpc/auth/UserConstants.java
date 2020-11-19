package com.salesforce.cantor.grpc.auth;

import com.salesforce.cantor.management.Roles;
import com.salesforce.cantor.management.Users;
import io.grpc.Context;
import io.grpc.Metadata;

import java.util.List;

import static io.grpc.Metadata.ASCII_STRING_MARSHALLER;

public class UserConstants {
    public static final String USER_NAMESPACE = ".users";
    public static final String ROLES_NAMESPACE = ".roles";

    public static final String USER_CLAIM = "user";
    public static final String PASSWORD_CLAIM = "passwordHash";
    public static final String JSON_FIELD_USERNAME = "name";
    public static final String JSON_FIELD_STATUS = "status";
    public static final String JSON_FIELD_ROLES = "roles";

    public static final Context.Key<Users.User> CONTEXT_KEY_USER = Context.key(USER_CLAIM);
    public static final Context.Key<List<Roles.Role>> CONTEXT_KEY_ROLES = Context.key(JSON_FIELD_ROLES);
    public static final Metadata.Key<String> ACCESS_KEY = Metadata.Key.of("access_key", ASCII_STRING_MARSHALLER);
    public static final Metadata.Key<String> SECRET_KEY = Metadata.Key.of("secret_key", ASCII_STRING_MARSHALLER);
}
