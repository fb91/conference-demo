package com.fabri.conferencedemo.controllers;

import com.fabri.conferencedemo.models.Speakers;
import com.fabri.conferencedemo.repositories.SpeakersRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/speakers")
public class SpeakersController {
    @Autowired
    private SpeakersRepository speakersRepository;

    @GetMapping
    public List<Speakers> list() {
        return speakersRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Speakers get(@PathVariable Long id ) {
        return speakersRepository.getById(id);
    }

    @PostMapping
    public Speakers create(@RequestBody final Speakers speakers) {
        return speakersRepository.saveAndFlush(speakers);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        //TODO: need to check for children records before deleting.
        speakersRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Speakers update(@PathVariable Long id, @RequestBody Speakers speaker) {
        //TODO: Add validation that all attributes are passed in, otherwise return a 400 bad payload error.
        Speakers existingSpeaker = speakersRepository.getById(id);
        BeanUtils.copyProperties(speaker, existingSpeaker, "speaker_id");
        return speakersRepository.saveAndFlush(existingSpeaker);
    }
}
