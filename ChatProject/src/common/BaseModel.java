package common;


@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({ @JsonSubTypes.Type(value = ClientRequestModel.class),
		@JsonSubTypes.Type(value = MessageModel.class) })
public class BaseModel {

	@JsonProperty("code")
	private ProtocolEnum code;

	@JsonProperty("timestamp")
	private Long timestamp;

	public BaseModel() {
		this.timestamp = System.currentTimeMillis();
	}

	public ProtocolEnum getCode() {
		return code;
	}

	public void setCode(ProtocolEnum code) {
		this.code = code;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

}