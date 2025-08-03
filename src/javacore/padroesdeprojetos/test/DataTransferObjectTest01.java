package javacore.padroesdeprojetos.test;

import javacore.padroesdeprojetos.dominio.*;

public class DataTransferObjectTest01 {
    public static void main(String[] args) {
        Aircraft aircraft = new Aircraft("999");
        Country country = Country.BRAZIL;
        Currency currency = CurrencyFactory.newCurrency(country);
        Person person = Person.PersonBuilder.aPerson().firstName("Scarlxrd").lastName("Silva").build();
        ReportDto reportDto = ReportDto.ReportDtoBuilder.builder().aircraftName(aircraft.getNumber()).country(country).currency(currency).personName(person.getFirstName()).build();
        System.out.println("DTO: " + reportDto);
    }
}
