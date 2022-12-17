package com.javaMaster.security;

import java.security.Provider;
import java.security.Security;
import java.util.Set;
import java.util.TreeSet;

/**
 * @Author Seyed Mohsen Hosseini
 * @Since 17 December 2022
 */

public class MySecurity {

    public void getSecurityProviders() {
        Set<String> algs = new TreeSet<>();
        for (Provider provider : Security.getProviders()) {
            provider.getServices().stream()
                    .filter(s -> "Cipher".equals(s.getType()))
                    .map(Provider.Service::getAlgorithm)
                    .forEach(algs::add);
        }
        algs.forEach(System.out::println);
    }

}
