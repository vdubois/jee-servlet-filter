package fr.iut.service;

import fr.iut.modele.Utilisateur;
import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.person.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class UtilisateursService {

    private static List<Utilisateur> utilisateurs = new ArrayList<Utilisateur>() {{
        IntStream.range(0, 10).forEach(index -> {
            Fairy fairy = Fairy.create();
            Person person = fairy.person();
            Utilisateur utilisateur = new Utilisateur();
            utilisateur.setNom(person.getLastName());
            utilisateur.setPrenom(person.getFirstName());
            utilisateur.setAge(person.getAge());
            utilisateur.setEmail(person.getEmail());
            utilisateur.setIdentifiant(person.getUsername());
            add(utilisateur);
        });
    }};

    public UtilisateursService() {
    }

    public List<Utilisateur> recupererTousLesUtilisateurs() {
        return utilisateurs;
    }

    public List<Utilisateur> recupererLesUtilisateursDontLeNomContient(String filtreNom) {
        return utilisateurs.stream()
                .filter(utilisateur -> utilisateur.getNom().contains(filtreNom))
                .collect(toList());
    }
}
