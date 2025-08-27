package javacore.junit.dominio;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MangaTest {
    Manga manga1;
    Manga manga2;
    @BeforeEach
    public void setUp(){
        manga1 = new Manga("Blue Locker", 12);
        manga2 = new Manga("Blue Locker", 12);
    }
    @Test
    public void accessors_ReturnDataWhenInitialized(){
        // valido  se os dados estão do get estão corretos
        Assertions.assertEquals("Blue Locker", manga1.name());
        Assertions.assertEquals(12, manga1.episodes());
    }
    @Test
    public void equals_ReturnTrue_WhenObjectsAreTheSame(){
        // valido o equals se são iguais
       Assertions.assertEquals(manga1,manga2);
    }
    @Test
    public void hashCode_ReturnTrue_WhenObjectsAreTheSame(){
        // valido o hashCode
        Assertions.assertEquals(manga1.hashCode(),manga2.hashCode());
    }
    @Test
    void constructor_ThrowNullPointerException_WhenNameIsNull(){
        // valido o nullPointer através do construtor
        Assertions.assertThrows(NullPointerException.class,()->new Manga(null,12));
    }
    @Test
    void isRecord_ReturnTrue_WhenCalledFromManga(){
        // valido se a class ainda é um record
        Assertions.assertTrue(Manga.class.isRecord());
    }
}