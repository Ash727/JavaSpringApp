package com.gify.giflibs.data;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.gify.giflibs.model.Gif;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class gifREpository {
    private static final List<Gif> ALL_gifs = Arrays.asList(
            new Gif("android-explosion", LocalDate.of(2015,2,13), "Chris Ramacciotti", false),
            new Gif("ben-and-mike", LocalDate.of(2015,10,30), "Ben Jakuben", true),
            new Gif("book-dominos", LocalDate.of(2015,9,15), "Craig Dennis", false),
            new Gif("compiler-bot", LocalDate.of(2015,2,13), "Ada Lovelace", true),
            new Gif("cowboy-coder", LocalDate.of(2015,2,13), "Grace Hopper", false),
            new Gif("infinite-andrew", LocalDate.of(2015,8,23), "Marissa Mayer", true));
    public void addGif(Gif gif){
        ALL_gifs.add(gif);
    }

    public Gif findByName(String name){

        return ALL_gifs.stream()
                .filter(e->e.getName().equals(name))
                .findAny()
                .orElse(null);
    }

    public static List<Gif> getALL_gifs() {
        return ALL_gifs;
    }
}
