package javacore.junit.dominio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class DeveloperTest {

    @Test
    void instanceOf_ExecutesChildClassMethod_WhenObjectIsOfChildType(){
        Employee employeeDevoloper = new Developer("1","Java");
        // metódo antigo de verificar a instancia de classe
        if (employeeDevoloper instanceof Developer) {
            Developer developer = (Developer) employeeDevoloper;
            Assertions.assertEquals("Java", ((Developer) employeeDevoloper).getMainLanguage());
        }
        // metódo melhorado no java 16 eu acho
        if (employeeDevoloper instanceof  Developer developer) {
            Assertions.assertEquals("Java",developer.getMainLanguage());
        }
    }

}