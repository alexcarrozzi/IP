package com.alexcarrozzi.Networks;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

public class DottedDecimal {
	private String _address = "";
	private Integer[] _addressElements = new Integer[4];
	
	public DottedDecimal() {
		this._address = "";
		this._addressElements = new Integer[4];
	}
	
	public DottedDecimal(String addressStr) {		
		String[] split = addressStr.split("\\.");

		for(int i=0; i<split.length; i++) {
			_addressElements[i] = Integer.parseInt(split[i]);
		}
		
		this._address = formatArrayOfInts(this._addressElements);
	}
	
	public DottedDecimal(int elements[]) {		
		for(int i=0; i<elements.length; i++) {
			_addressElements[i] = new Integer(elements[i]);
		}
		
		this._address = formatArrayOfInts(this._addressElements);
	}
	
	private String formatArrayOfInts(Integer elements[]) {
		return StringUtils.chop(Arrays.stream(this._addressElements)
				.map(ele -> 
					String.valueOf(ele).concat(".")
				).collect(Collectors.joining("")));
	}
	
	public String getAddress() {
		return this._address;
	}
}
