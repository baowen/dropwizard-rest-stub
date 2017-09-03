package com.benaowen.reststub.persistence;

import com.benaowen.reststub.data.Person;

import java.util.*;
import javax.ws.rs.core.Response;

/**
 * Created by benowen on 29/08/2017.
 */
public class PersonDB {
    private static Map<Integer, Person> persons = new HashMap<Integer, Person>();

    static {
        persons.put(1, new Person(1, "FN1", "LN1", "email1@email.com"));
        persons.put(2, new Person(2, "FN2", "LN2", "email2@email.com"));
        persons.put(3, new Person(3, "FN3", "LN3", "email3@email.com"));
        persons.put(4, new Person(4, "FN4", "LN4", "email4@email.com"));
    }

    public static Person getById(int id) {
        return persons.get(id);
    }

    public static List<Person> getAll() {
        List<Person> result = new ArrayList<Person>();
        for (Integer key : persons.keySet()) {
            result.add(persons.get(key));
        }
        return result;
    }

    public static int getCount() {
        return persons.size();
    }

    public static void remove(int id) {
        if (!persons.keySet().isEmpty()) {
            persons.remove(id);
        }
    }

    public static Person save(Person person) {
        String result = "";
        int maxKey = Collections.max(persons.keySet());
        if (person.getId() == 0) {
            person.setId(maxKey+1);
        }
        if (persons.get(person.getId()) != null) {
            result = "Updated Person with id=" + person.getId();
        } else {
            result = "Added Person with id=" + person.getId();
        }
        System.out.println(result);
        persons.put(person.getId(), person);
        return person;
    }
}
