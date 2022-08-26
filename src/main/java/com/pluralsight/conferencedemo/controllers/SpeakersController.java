package com.pluralsight.conferencedemo.controllers;

import com.pluralsight.conferencedemo.models.Speaker;
import com.pluralsight.conferencedemo.repositories.SpeakerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/api/vi/speakers/")
public class SpeakersController {

    @Autowired
    private SpeakerRepository speakerRepositoryer;

    @GetMapping
    public List<Speaker> listSpeakers(){
        return speakerRepositoryer.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Speaker findById(@PathVariable Long id){
        return speakerRepositoryer.getReferenceById(id);
    }

    @PostMapping
    @ResponseStatus
    public Speaker saveSpeaker(@RequestBody Speaker speaker){
        return speakerRepositoryer.saveAndFlush(speaker);
    }

    @GetMapping
    @RequestMapping(value = "{id}",method = RequestMethod.DELETE)
    public void deleteSpeaker(@PathVariable Long id){
        speakerRepositoryer.deleteById(id);
    }

    @GetMapping
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Speaker updateSpeaker(@PathVariable Long id,@RequestBody Speaker speakers){

        Speaker existingSpeaker = speakerRepositoryer.getReferenceById(id);
        BeanUtils.copyProperties(speakers,existingSpeaker,"id_speakers");
        return speakerRepositoryer.saveAndFlush(speakers);
    }

}
