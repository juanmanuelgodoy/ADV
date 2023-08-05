package com.gg.ADV.enums;

public enum Unidad {
	
	MILLONES_DE_LITROS("millones de litros");
	
	private String displayName;

    Unidad(String displayName) {
        this.displayName = displayName;
    }

    public String displayName() { return displayName; }

    // Optionally and/or additionally, toString.
    @Override public String toString() { return displayName; }

}
