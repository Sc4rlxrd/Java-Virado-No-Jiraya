package javacore.colecoes.dominio;

public class Smartphone {
    private String serialNumber;
    private String marca;

    public Smartphone(String serialSerial, String marca) {
        this.serialNumber = serialSerial;
        this.marca = marca;
    }

    // Reflexivo: x.equals(x) tem que ser true para tudo que for diferente de null.
    // Simétrico: para x e y diferentes de null, se x.equals(y) == true logo, y.equals(x) == true.
    // Transitividade: para x,y,z diferentes de null, se x.equals(y) == true , e x.equals(z) == true logo, y.equals(z) == true.
    // Consistente: x.equals(x) sempre retorna true se x for diferente de null
    // para x diferente de null, x.equals(null) tem que retornar false.
    // this seria x e o parametro obj seria y
    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;
        if(this == obj) return true;
        if(this.getClass() != obj.getClass()) return false;
        Smartphone smartphone = (Smartphone) obj;
        return serialNumber != null && serialNumber.equals(smartphone.serialNumber);
    }

    // se x.equals(y) == true, y.hashCode == x.hashCode()
    // y.hashCode() == x.hashCode() não necessariamente o equals de y.equals(x) tem que ser true.
    // x.equals(y) == false
    // y.hashCOde() != x.hashCOde() x.equals(y) deverá ser false.
    // obs: o mesmo atributo do equals tem que ser usado no hashCode também.
    @Override
    public int hashCode() {
        return  serialNumber == null ? 0 : this.serialNumber.hashCode();
    }

    @Override
    public String toString() {
        return "Smartphone{" +
                "serialNumber='" + serialNumber + '\'' +
                ", marca='" + marca + '\'' +
                '}';
    }

    public String getSerialSerial() {
        return serialNumber;
    }

    public void setSerialSerial(String serialSerial) {
        this.serialNumber = serialSerial;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
}
