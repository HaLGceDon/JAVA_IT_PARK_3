package ru.itpark;

public class Main {
    public static void main(String[] args) {
      //  ComponentsFactory factory = new ComponentsFactory();
      //  MessageRenderer message = factory.getMessageComponent();
      //  message.render();
        ComponentsFactory componentsFactory = ComponentsFactory.getInstance();
        MessageRenderer messageRenderer = componentsFactory.getMessageComponent();
        messageRenderer.render();



    }
}