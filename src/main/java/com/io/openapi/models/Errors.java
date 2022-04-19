package com.io.openapi.models;

import java.io.Serializable;
import com.io.openapi.models.Error;
import java.util.List;

public class Errors implements Serializable {

	/** Serial Version UID. */
	 private static final long serialVersionUID = 1L;

	private List<Error> errors;
		
	public List<Error> getError()
	{
		return errors;
	}
	
	public void setError(List<Error> errors)
	{
		this.errors = errors;
	}
	
	public Errors()
	{
	}
	
	public Errors(List<Error> errors)
	{
		this.errors = errors;
	}
}