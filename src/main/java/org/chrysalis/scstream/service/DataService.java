package org.chrysalis.scstream.service;

import java.text.MessageFormat;
import java.util.Map;
import java.util.UUID;

import org.chrysalis.scstream.vo.UserInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.stereotype.Service;

import lombok.extern.java.Log;

@Service
@Log
public class DataService {

	@Autowired
	private Source source;

	@Value("${chrysalis.app.headers}")
	Map<String, String> headers;

	public <D> void publishData(D data) {
		log.info(() -> MessageFormat.format("Message being published {}", data.toString()));
		source.output().send(MessageBuilder.withPayload(data).copyHeaders(headers).build());
	}

}
