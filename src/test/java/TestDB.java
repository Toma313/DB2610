import dataobjects.AdressTable;
import mysqlconfig.StatemenT;
import mysqlconfig.enums.ADRESSFIELDS;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.SQLException;

public class TestDB {

    static StatemenT statmentT;
    @BeforeClass
    public static void before() {
        statmentT = new StatemenT();
    }
    @Test // Вернет имя юзера по id
    public void test1() throws SQLException {
        statmentT.selectByFieldName(ADRESSFIELDS.ID, "1");
    }
    @Test // Вернет список юзеров с одинаковыми email
    public void test2() throws SQLException {
        System.out.println(statmentT.selectListTableDuplicateEmail());
    }
    @Test // Вернет список Уникальных имен юзеров в базе даних (Limit 0,100)
    public void test3() throws SQLException {
        System.out.println(statmentT.selectUniqueName());
        }
}
