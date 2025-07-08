package com.example.usermicroservice.services;

import com.example.usermicroservice.Client.AnimalClient;
import com.example.usermicroservice.DTO.Animal;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Slf4j
@RequiredArgsConstructor
public class KeyCloackUserService {

    private final AnimalClient animalClient;

    @Value("${keycloak.auth-server-url}")
    private String authServerUrl;

    @Value("${keycloak.realm}")
    private String realm;

    @Value("${keycloak.clientId}")
    private String clientId;

    @Value("${keycloak.username}")
    private String adminUsername;

    @Value("${keycloak.password}")
    private String adminPassword;

    private Keycloak getKeycloakClient() {
        return KeycloakBuilder.builder()
                .serverUrl(authServerUrl)
                .realm("master") // use "master" only for admin access
                .clientId(clientId)
                .grantType(OAuth2Constants.PASSWORD)
                .username(adminUsername)
                .password(adminPassword)
                .build();
    }

    public UserRepresentation getUserById(String userId) {
        return getKeycloakClient().realm(realm)
                .users()
                .get(userId)
                .toRepresentation();
    }

    public List<UserRepresentation> getAllUsers() {
        return getKeycloakClient().realm(realm)
                .users()
                .list();
    }

    public Map<String, List<String>> getUserAttributes(String userId) {
        UserRepresentation user = getUserById(userId);
        return user.getAttributes();
    }

    public String AffectAnimal(String userId, Long animalId) {
        UserRepresentation user = getUserById(userId);
        Animal animalDTO = animalClient.getById(animalId);

        Map<String, List<String>> attributes = user.getAttributes();
        if (attributes == null) {
            attributes = new HashMap<>();
        }

        List<String> animalsList = attributes.getOrDefault("animals", new ArrayList<>());
        animalsList.add("Nom Animal: " + animalDTO.getNom());

        attributes.put("animals", animalsList);
        user.setAttributes(attributes);

        getKeycloakClient().realm(realm).users().get(userId).update(user);
        return "Animal successfully assigned to user.";
    }
}
