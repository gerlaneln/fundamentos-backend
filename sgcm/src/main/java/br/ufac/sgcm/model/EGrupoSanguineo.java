package br.ufac.sgcm.model;

public enum EGrupoSanguineo {

    A_POSITIVO("A+"),
    A_NEGATIVO("A-"),
    B_POSITIVO("B+"),
    B_NEGATIVO("B-"),
    AB_POSITIVO("AB+"),
    AB_NEGATIVO("AB-"),
    O_POSITIVO("O+"),
    O_NEGATIVO("O-");

    private String label;

    private EGrupoSanguineo(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
    
    public static EGrupoSanguineo valueOfLabel(String label) {
        for (EGrupoSanguineo item : EGrupoSanguineo.values()) {
            if (item.getLabel().equals(label)) {
                return item;
            }
        }
        throw new IllegalArgumentException();
    }
    
}
