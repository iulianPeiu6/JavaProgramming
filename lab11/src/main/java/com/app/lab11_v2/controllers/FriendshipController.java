package com.app.lab11_v2.controllers;

import com.app.lab11_v2.models.Friendship;
import com.app.lab11_v2.models.Person;
import com.app.lab11_v2.models.PersonPopularity;
import com.app.lab11_v2.repositories.FriendshipRepository;
import com.app.lab11_v2.repositories.PersonRepository;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class FriendshipController {

    private final FriendshipRepository friendshipRepository;

    private final PersonRepository personRepository;

    public FriendshipController(FriendshipRepository friendshipRepository, PersonRepository personRepository) {
        this.friendshipRepository = friendshipRepository;
        this.personRepository = personRepository;
    }

    @GetMapping("/friendships")
    public List<Friendship> all() {
        return friendshipRepository.findAll();
    }

    @PostMapping("/friendships")
    public Friendship newFriendship(@RequestBody Friendship newFriendship) {
        return friendshipRepository.save(newFriendship);
    }

    @DeleteMapping("/friendships/{id}")
    public void deleteFriendship(@PathVariable Long id) {
        friendshipRepository.deleteById(id);
    }

    @GetMapping("/leastPopular/{firstX}")
    public List<PersonPopularity> getMostPopular(@PathVariable int firstX) {
        List<PersonPopularity> leastPopularPeople = new ArrayList<>();

        for (Person person : personRepository.findAll()){
            PersonPopularity personPopularity = new PersonPopularity(person);
            for (Friendship friendship : friendshipRepository.findAll()) {
                if (friendship.getTo().equals(personPopularity.getId())
                        || friendship.getFrom().equals(personPopularity.getId()))
                    personPopularity.setPopularity(personPopularity.getPopularity() + 1);
            }
            leastPopularPeople.add(personPopularity);
        }

        leastPopularPeople.sort(Comparator.comparingInt(PersonPopularity::getPopularity));

        return leastPopularPeople.subList(0,Math.max(firstX,leastPopularPeople.size()));
    }
}
