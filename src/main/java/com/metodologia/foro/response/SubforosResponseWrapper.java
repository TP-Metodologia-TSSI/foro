package com.metodologia.foro.response;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SubforosResponseWrapper {
	@JsonProperty
    private ArrayList<SubforoResponseWrapper> subforos;

	 public SubforosResponseWrapper(ArrayList<SubforoResponseWrapper> subforos) {
    	this.subforos = subforos;
    }
}
