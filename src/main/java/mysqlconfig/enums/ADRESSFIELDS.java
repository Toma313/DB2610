package mysqlconfig.enums;

public enum ADRESSFIELDS {
    ID("id"), NAME("name"), FAMILY("family"), FESIC_ADRESS("fisical_adress"),
    BIRTHDAY("birthday"),EMAIL("email");
    String fieldName;

    private ADRESSFIELDS(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldName() {
        return fieldName;
    }
}