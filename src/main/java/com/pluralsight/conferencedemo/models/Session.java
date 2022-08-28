package com.pluralsight.conferencedemo.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity(name = "session")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_session;
    private String session_name;
    private String session_description;
    private Integer session_length;

    @ManyToMany
    @JoinTable(
            name = "sessions_speakers",
            joinColumns = @JoinColumn(name = "session_id"),
            inverseJoinColumns = @JoinColumn(name = "speakers_id")
    )
    private List<Speaker> speakers;


    public Session(){}

    public Long getId_session() {
        return id_session;
    }

    public void setId_session(Long id_session) {
        this.id_session = id_session;
    }

    public String getSession_name() {
        return session_name;
    }

    public void setSession_name(String session_name) {
        this.session_name = session_name;
    }

    public String getSession_description() {
        return session_description;
    }

    public void setSession_description(String session_description) {
        this.session_description = session_description;
    }

    public Integer getSession_length() {
        return session_length;
    }

    public void setSession_length(Integer session_length) {
        this.session_length = session_length;
    }

    public List<Speaker> getSpeakersList() {
        return speakers;
    }

    public void setSpeakersList(List<Speaker> speakers) {
        this.speakers = speakers;
    }
}
