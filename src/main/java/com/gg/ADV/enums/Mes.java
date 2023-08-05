package com.gg.ADV.enums;

public enum Mes {
	
	ENERO("enero"),
	FEBRERO("febrero"),
	MARZO("marzo"),
	ABRIL("abril"),
	MAYO("mayo"),
	JUNIO("junio"),
	JULIO("julio"),
	AGOSTO("agosto"),
	SETIEMBRE("setiembre"),
	OCTUBRE("octubre"),
	NOVIEMBRE("noviembre"),
	DICIEMBRE("diciembre");
	
	private String displayName;

    Mes (String displayName) {
        this.displayName = displayName;
    }

    public String displayName() { return displayName; }

    // Optionally and/or additionally, toString.
    @Override public String toString() { return displayName; }

}
