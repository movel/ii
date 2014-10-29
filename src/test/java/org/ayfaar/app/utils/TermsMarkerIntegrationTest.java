package org.ayfaar.app.utils;

import org.ayfaar.app.IntegrationTest;
import org.junit.Test;

import javax.inject.Inject;

import static org.junit.Assert.assertEquals;

public class TermsMarkerIntegrationTest extends IntegrationTest {
    @Inject
    TermsMarker termsMarker;

    @Test
    public void test() {
        final String text = "Например, Формо-Творцы АДД-МАДД-ФЛУЙФ-Уровня, организующие высшие ГЛЭИИЙО-реальности";
        final String expected = "Например, <term id=\"Формо-Творец\">Формо-Творцы</term> " +
                //"АДД-МАДД-ФЛУЙФ-Уровня, организующие высшие <term id=\"ГЛЭИИЙО\">ГЛЭИИЙО-реальности</term>";
                //ГЛЭИИЙО-реальности - нет такого термина в базе, заменил на ГЛЭИИЙО
                "АДД-МАДД-ФЛУЙФ-Уровня, организующие высшие <term id=\"ГЛЭИИЙО\">ГЛЭИИЙО</term>-реальности";

        final String actual = termsMarker.mark(text);
        assertEquals(expected, actual);

        final String text2 = "Всё Пространство в каждой из своих бесчисленных «резонационных зон» структурировано множеством разнокачественных стоячих волн, которые, как бы накладываясь друг на друга и тем самым либо подавляясь, либо модулируясь, образуют в каждом из частотных Уровней возможного Восприятия абсолютно всю качественную динамику видимой и субъективно переживаемой нами «картинки» окружающей нас в каждый момент действительности.";
        final String expected2 = "Всё <term id=\"Пространство\">Пространство</term> в каждой из своих бесчисленных «<term id=\"Резонационная зона\">резонационных зон</term>» структурировано множеством разнокачественных стоячих волн, которые, как бы накладываясь друг на друга и тем самым либо подавляясь, либо модулируясь, образуют в каждом из частотных Уровней возможного Восприятия абсолютно всю качественную динамику видимой и субъективно переживаемой нами «картинки» окружающей нас в каждый момент действительности.";

        final String actual2 = termsMarker.mark(text2);
        assertEquals(expected2, actual2);
    }
}