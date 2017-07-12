package org.kpi.service;

import org.kpi.model.User;

import java.util.List;

/**
 * Created by lnphi on 7/5/2017.
 */
public interface UserService {
    List<User> getAll();

    User getByUsername(String username);

    void save(User user);

    boolean exist(String username);

    boolean existEmail(String email);
}
