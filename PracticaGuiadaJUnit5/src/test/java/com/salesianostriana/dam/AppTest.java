package com.salesianostriana.dam;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    static CuentaCorriente cuentaCorriente;
    static CuentaCorriente cuentaCorriente2;

    @BeforeAll
    static void iniciar(){
        cuentaCorriente = new CuentaCorriente("Manuel",1,1000);
        cuentaCorriente2 = new CuentaCorriente("Manuel",1,1000);
    }

    @Test
    @DisplayName("Deposita")
    void depositar(){
        assertTrue(cuentaCorriente.deposit(5), "Deposita");
    }

    @Test
    @DisplayName("No deposita")
    void noDepositar(){
        assertFalse(cuentaCorriente.deposit(-5), "No deposita");
    }

    @Test
    @DisplayName("Saca dinero")
    void sacaDinero(){
        assertTrue(cuentaCorriente.withdraw(1,2), "Saca dinero");
    }

    @Test
    @DisplayName("No saca dinero")
    void noSacaDinero1(){
        assertFalse(cuentaCorriente.withdraw(-1,2), "Cantidad negativa");
    }

    @Test
    @DisplayName("No saca dinero")
    void noSacaDinero2(){
        assertFalse(cuentaCorriente.withdraw(1,-2), "Cuota negativa");
    }

    @Test
    @DisplayName("No saca dinero")
    void noSacaDinero3(){
        assertFalse(cuentaCorriente.withdraw(10000,2), "Saca mas dinero");
    }

    @Test
    @DisplayName("Añade interes")
    void anadeInteres(){
        cuentaCorriente.addInterest();
        assertNotEquals(cuentaCorriente.getSaldo(), cuentaCorriente2.getSaldo(), "Añade interes");
    }

    @Test
    @DisplayName("Devuelve numero cuenta")
    void numCuenta(){
        assertEquals(1, cuentaCorriente.getAccountNumber(), "Devuelve numero cuenta");
    }

    @Test
    @DisplayName("Devuelve toString")
    void devuelveToString(){
        assertEquals("1	Manuel	1.047,09 €", cuentaCorriente.toString(), "Devuelve toString");
    }







}
