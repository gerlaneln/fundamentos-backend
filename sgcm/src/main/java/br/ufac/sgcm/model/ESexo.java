package br.ufac.sgcm.model;

public enum ESexo {

    M("Masculino"),
    F("Feminino");

    private String label;

    private ESexo(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
    
    public static ESexo valueOfLabel(String label) {
        for (ESexo item : ESexo.values()) {
            if (item.getLabel().equals(label)) {
                return item;
            }
        }
        throw new IllegalArgumentException();
    }
    
}
