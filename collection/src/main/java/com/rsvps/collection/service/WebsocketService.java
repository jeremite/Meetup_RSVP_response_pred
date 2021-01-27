package com.rsvps.collection.service;

import org.springframework.stereotype.Service;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

import java.util.logging.Logger;

@Service
public class WebsocketService extends AbstractWebSocketHandler{
    private static final Logger logger =
            Logger.getLogger(WebsocketService.class.getName());

    private final RsvpService rsvpService;

    public WebsocketService(RsvpService rsvpService) {
        this.rsvpService = rsvpService;
    }

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception{
        //logger.log(Level.INFO, "New RSVP:\n {0}", message.getPayload());
        this.rsvpService.sendRsvp((String) message.getPayload());
        System.out.print(message.getPayload());
    }
}
