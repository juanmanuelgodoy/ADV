package com.gg.ADV.enums;

public enum Categoria {

	COLOR("color"),
	ENVASE("envase"), 
	TIPO("tipo"),
	VARIEDAD("variedad");
	
	private String displayName;

    Categoria (String displayName) {
        this.displayName = displayName;
    }

    public String displayName() { return displayName; }

    // Optionally and/or additionally, toString.
    @Override public String toString() { return displayName; }
}
