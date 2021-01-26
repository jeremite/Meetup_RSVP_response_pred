package com.rsvps.responsepred;

import com.rsvps.responsepred.collection.WebsocketService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;

@SpringBootApplication
public class ResponsePredApplication {
	private static final String MEETUP_RSVP_ENDPOINT =
			"ws://stream.meetup.com/2/rsvps";
	public static void main(String[] args) {
		SpringApplication.run(ResponsePredApplication.class, args);
	}

	@Bean
	public ApplicationRunner initializeConnection(WebsocketService websocketService){
		return args -> {
			WebSocketClient socketClient = new StandardWebSocketClient();
			socketClient.doHandshake(
					websocketService, MEETUP_RSVP_ENDPOINT);
		};
	}
}
