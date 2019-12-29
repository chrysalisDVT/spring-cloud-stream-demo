package org.chrysalis.scstream.vo;

import lombok.Builder;
import lombok.ToString;

@Builder
@ToString
public class UserInformation {
	private String name;
	private long balance;
	private String id;
}
