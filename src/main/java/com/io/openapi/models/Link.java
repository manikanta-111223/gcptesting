package com.io.openapi.models;

import java.io.Serializable;
import javax.validation.constraints.NotNull;

public class Link implements Serializable {

	/** Serial Version UID. */
	 private static final long serialVersionUID = 1L;

	@NotNull(message = "ERR400_REQUIRED")
	private String type;
	@NotNull(message = "ERR400_REQUIRED")
	private String href;
	@NotNull(message = "ERR400_REQUIRED")
	private String description;
		
	public String getType()
	{
		return type;
	}
	
	public void setType(String type)
	{
		this.type = type;
	}
	
	public String getHref()
	{
		return href;
	}
	
	public void setHref(String href)
	{
		this.href = href;
	}
	
	public String getDescription()
	{
		return description;
	}
	
	public void setDescription(String description)
	{
		this.description = description;
	}
	
	public Link()
	{
	}
	
	public Link(String type, String href, String description)
	{
		this.type = type;
		this.href = href;
		this.description = description;
	}
}