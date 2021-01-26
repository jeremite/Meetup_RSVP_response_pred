package com.rsvps.responsepred.collection;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

import java.util.logging.Level;
import java.util.logging.Logger;

@Service
@EnableBinding(Source.class)
public class RsvpService {
    private static final Logger logger = Logger.getLogger(RsvpService.class.getName());
    private static final int SENDING_MESSAGE_TIMEOUT_MS = 10000;

    private final Source source;
    public RsvpService(Source source) {
        this.source = source;
    }

    public void sendRsvp(final String rsvp){
        logger.log(Level.INFO, "New RSVP");
        //MessageChannel messageChannel = rsvpStreams.outboundRsvp();

        source.output()
                .send(MessageBuilder.withPayload(rsvp).setHeader(
                MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON).build(),SENDING_MESSAGE_TIMEOUT_MS);
    }
}
