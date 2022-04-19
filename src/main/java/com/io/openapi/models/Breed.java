package com.io.openapi.models;

import java.io.Serializable;
import com.io.openapi.enums.GroupEnum;
import com.io.openapi.models.Link;
import java.util.List;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Breed implements Serializable {

	/** Serial Version UID. */
	 private static final long serialVersionUID = 1L;

	@Max(value = 99999999, message = "ERR400_RANGE")
	@NotNull(message = "ERR400_REQUIRED")
	@Min(value = 0, message = "ERR400_RANGE")
	private Integer id;
	@Size(min = 3, max = 20, message= "ERR400_LENGTH")
	@NotNull(message = "ERR400_REQUIRED")
	private String friendly_id;
	@Pattern(regexp = "[a-z A-Z0-9]*", message= "ERR400_PATTERN")
	@NotNull(message = "ERR400_REQUIRED")
	private String breed;
	private GroupEnum group;
	private String origin_country;
	private List<Link> links;
		
	public Integer getId()
	{
		return id;
	}
	
	public void setId(Integer id)
	{
		this.id = id;
	}
	
	public String getFriendly_id()
	{
		return friendly_id;
	}
	
	public void setFriendly_id(String friendly_id)
	{
		this.friendly_id = friendly_id;
	}
	
	public String getBreed()
	{
		return breed;
	}
	
	public void setBreed(String breed)
	{
		this.breed = breed;
	}
	
	public GroupEnum getGroup()
	{
		return group;
	}
	
	public void setGroup(GroupEnum group)
	{
		this.group = group;
	}
	
	public String getOrigin_country()
	{
		return origin_country;
	}
	
	public void setOrigin_country(String origin_country)
	{
		this.origin_country = origin_country;
	}
	
	public List<Link> getLinks()
	{
		return links;
	}
	
	public void setLinks(List<Link> links)
	{
		this.links = links;
	}
	
	public Breed()
	{
	}
	
	public Breed(Integer id, String friendly_id, String breed, GroupEnum group, String origin_country, List<Link> links)
	{
		this.id = id;
		this.friendly_id = friendly_id;
		this.breed = breed;
		this.group = group;
		this.origin_country = origin_country;
		this.links = links;
	}
}