package br.com.triersistemas.andromeda.helper;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import static org.assertj.core.api.Assertions.assertThat;
public class StringUtilsTests {

    @Test
    public void testGetRandomValue() {

        BigDecimal numero = StringUtils.getRandomValue();
        System.out.println(numero);
        assertThat(numero).isInstanceOf(BigDecimal.class);
    }
}
