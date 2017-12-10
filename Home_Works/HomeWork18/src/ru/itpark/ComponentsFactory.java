package ru.itpark;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.Properties;

public class ComponentsFactory {

    private final static ComponentsFactory instance;
    private Properties properties;

    static {

        instance = new ComponentsFactory();
    }

    public static ComponentsFactory getInstance() {
        return instance;
    }



    private ComponentsFactory() {
        properties = new Properties();
        try {
            properties.load(new FileReader("application.properties"));
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public MessageRenderer getMessageComponent() {
        String messageText = properties.getProperty("message.text");
        String className = properties.getProperty("message.class");
        String renderer = properties.getProperty("renderer.class");
        try {
            Class <Message> messageClass = (Class<Message>)Class.forName(className);
            Constructor <Message> messageConstructor = messageClass.getConstructor(String.class);
            Message message = messageConstructor.newInstance(messageText);

            Class <MessageRenderer> messageRenderer = (Class<MessageRenderer>) Class.forName(renderer);
            Constructor <MessageRenderer> rendererConstructor = messageRenderer.getConstructor(Message.class);
            MessageRenderer messageRendererReturn = rendererConstructor.newInstance(message);



            return messageRendererReturn;
        } catch (ReflectiveOperationException e) {
            throw new IllegalArgumentException(e);
        }
    }




}

