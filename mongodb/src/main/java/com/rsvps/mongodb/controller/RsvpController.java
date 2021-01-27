package com.rsvps.mongodb.controller;

//import com.mongodb.client.MongoClient;
//import com.mongodb.client.MongoClient;
import com.rsvps.mongodb.model.MeetupRSVP;
//import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class RsvpController {
    private final ReactiveMongoTemplate mongoTemplate;


    public RsvpController(ReactiveMongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @GetMapping(value="/meetupRsvps", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<MeetupRSVP> meetupRSVP(){
        return mongoTemplate.tail(
                new Query(), MeetupRSVP.class).share();
    }


/*    @PostMapping("/meetupRsvps")
    public void insertRspv(@RequestBody MeetupRSVP meetupRSVP)
    {
        MongoTemplate template = new MongoTemplate(, "meetupDB");
        System.out.println("Incoming string "+ meetupRSVP.getVenue().getVenue_name());
        //  Mono<MeetupRSVP> meetupRSVPMono =
        template.insert(meetupRSVP);
    }*/
}
