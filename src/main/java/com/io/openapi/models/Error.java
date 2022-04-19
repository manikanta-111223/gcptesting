package com.io.openapi.models;

import java.io.Serializable;
import com.io.openapi.models.Link;
import java.util.List;
import javax.validation.constraints.NotNull;

public class Error implements Serializable {

	/** Serial Version UID. */
	 private static final long serialVersionUID = 1L;

	private String id;
	@NotNull(message = "ERR400_REQUIRED")
	private String code;
	@NotNull(message = "ERR400_REQUIRED")
	private String title;
	private String detail;
	private List<Link> links;
		
	public String getId()
	{
		return id;
	}
	
	public void setId(String id)
	{
		this.id = id;
	}
	
	public String getCode()
	{
		return code;
	}
	
	public void setCode(String code)
	{
		this.code = code;
	}
	
	public String getTitle()
	{
		return title;
	}
	
	public void setTitle(String title)
	{
		this.title = title;
	}
	
	public String getDetail()
	{
		return detail;
	}
	
	public void setDetail(String detail)
	{
		this.detail = detail;
	}
	
	public List<Link> getLinks()
	{
		return links;
	}
	
	public void setLinks(List<Link> links)
	{
		this.links = links;
	}
	
	public Error()
	{
	}
	
	public Error(String id, String code, String title, String detail, List<Link> links)
	{
		this.id = id;
		this.code = code;
		this.title = title;
		this.detail = detail;
		this.links = links;
	}
}