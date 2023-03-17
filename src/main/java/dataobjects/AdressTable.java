package dataobjects;

import mysqlconfig.enums.ADRESSFIELDS;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AdressTable {
    public    int id;
    public    String name, family, email, fisicadress, birthday;

    public AdressTable(int id, String name, String family, String email, String fisicadress, String birthday) {
        this.id = id;
        this.name = name;
        this.family = family;
        this.email = email;
        this.fisicadress = fisicadress;
        this.birthday = birthday;
    }

    public AdressTable(ResultSet resultSet) {
        try {
            this.id = resultSet.getInt(ADRESSFIELDS.ID.getFieldName());
            this.name = resultSet.getString(ADRESSFIELDS.NAME.getFieldName());
            this.family = resultSet.getString(ADRESSFIELDS.FAMILY.getFieldName());
            this.email = resultSet.getString(ADRESSFIELDS.EMAIL.getFieldName());
            this.fisicadress = resultSet.getString(ADRESSFIELDS.FESIC_ADRESS.getFieldName());
            this.birthday = resultSet.getString(ADRESSFIELDS.BIRTHDAY.getFieldName());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "\nName = "+name+" LastName =  "+family+" Email = "+email;
    }
}
