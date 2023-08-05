package com.gg.ADV.enums;

public enum SubCategoria {

	BLANCO("blanco"),
	BLANCO_OTROS("blanco otros"), 
	BLANCO_VARIETAL("blanco varietal"),
	BLANCO_SIN_VARIETAL("blanco sin varietal"),
	CABERNET_SAUVIGNON("cabernet sauvignon"),
	CHARDONNAY("chardonnay"),
	COLOR("color"),
	COLOR_OTROS("color otros"),
	COLOR_VARIETAL("color varietal"),
	COLOR_SIN_VARIETAL("color sin varietal"),
	ENVASADO_EN_BOTELLA("envasado en botella"),
	ENVASADO_EN_DAMAJUANA("envasado en damajuana"),
	ENVASADO_EN_TETRABRICK("envasado en tetrabrick"),
	ENVASADO_OTROS_ENVASES("envasado en otros envases"),
	MALBEC("malbec"),
	MERLOT("merlot"),
	OTROS_Y_BLENDS("otros y blends"),
	SAUVIGNON_BLANC("sauvignon blanc"),
	SYRAH("syrah"),
	TORRONTES_RIOJANO("torrontes riojano"),
	TOTALVINO("totalvino"),
	ESPUMANTE_Y_GASIFICADO("vino espumante y gasificado"),
	VINO_VARIETAL("vino varietal"),
	VINO_SIN_VARIETAL("vino sin varietal");
	
	private String displayName;

    SubCategoria (String displayName) {
        this.displayName = displayName;
    }

    public String displayName() { return displayName; }

    // Optionally and/or additionally, toString.
    @Override public String toString() { return displayName; }
}
