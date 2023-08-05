package com.gg.ADV.enums;

public enum Rol {
	
	ADMINISTRADOR("administrador"),
	CLIENTE("cliente"), 
	USUARIO("usuario");
	
	private String displayName;

    Rol (String displayName) {
        this.displayName = displayName;
    }

    public String displayName() { return displayName; }

    // Optionally and/or additionally, toString.
    @Override public String toString() { return displayName; }
}

