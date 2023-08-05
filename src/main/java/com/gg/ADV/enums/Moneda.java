package com.gg.ADV.enums;

public enum Moneda {
	
	PESOS("pesos argentinos"),
	PESOS_CHILENOS("pesos chilenos"),
	DOLARES("dolares estadounidenses"), 
	EUROS("euros"),
	REALES("reales");
	
	private String displayName;

    Moneda (String displayName) {
        this.displayName = displayName;
    }

    public String displayName() { return displayName; }

    // Optionally and/or additionally, toString.
    @Override public String toString() { return displayName; }

}
