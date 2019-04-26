package br.pro.hashi.ensino.desagil.projeto1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class DefaultMessagesTest {
    private DefaultMessages defaultMessages;

    @Before
    public void setDefaultMessages(){
        defaultMessages = new DefaultMessages();
    }
    @Test
    public void getFirstMessageOfTheDefaultMessages() {
        Assert.assertEquals("Estou com fome", defaultMessages.getMessage(0));
    }
    @Test
    public void getSecondMessageOfTheDefaultMessages() {
        Assert.assertEquals("Estou com sede", defaultMessages.getMessage(1));
    }
    @Test
    public void getThirdMessageOfTheDefaultMessages() {
        Assert.assertEquals("Preciso ir ao banheiro", defaultMessages.getMessage(2));
    }
    @Test
    public void getFourthMessageOfTheDefaultMessages() {
        Assert.assertEquals("Venha rapidamente", defaultMessages.getMessage(3));
    }
    @Test
    public void getFifthMessageOfTheDefaultMessages() {
        Assert.assertEquals("Sinto dor", defaultMessages.getMessage(4));
    }
}
