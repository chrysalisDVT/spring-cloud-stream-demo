package org.chrysalis.scstream.controller;

import org.chrysalis.scstream.service.DataService;
import org.chrysalis.scstream.vo.UserInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChainInitiater {

	@Autowired
	DataService dataService;

	@PostMapping(name = "chain-start", path = "/user")
	public void initiateProcess(@RequestBody UserInformation userInfo) {
		dataService.publishData(userInfo);
	}

}
