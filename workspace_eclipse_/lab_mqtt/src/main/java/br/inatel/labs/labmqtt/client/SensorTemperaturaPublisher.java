package br.inatel.labs.labmqtt.client;

import org.eclipse.paho.client.mqttv3.*;
import java.util.Random;
import java.util.UUID;

public class SensorTemperaturaPublisher {

    public static void main(String[] args) throws MqttException {
        IMqttClient publisher = null;
        try {
            String publisherId = UUID.randomUUID().toString();
            publisher = new MqttClient(MyConstants.URI_BROKER, publisherId);

            MqttConnectOptions options = new MqttConnectOptions();
            options.setAutomaticReconnect(true);
            options.setCleanSession(true);
            options.setConnectionTimeout(10);
            publisher.connect(options);

            for (int i = 0; i < 10; i++) {
                MqttMessage msg = getTemperatureMessage();
                msg.setQos(0);
                msg.setRetained(true);
                publisher.publish(MyConstants.TOPIC_SENSOR, msg);
                Thread.sleep(2000);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (publisher != null) {
                publisher.disconnect();
                publisher.close();
            }
        }
    }

    private static MqttMessage getTemperatureMessage() {
        Random r = new Random();
        double temperature = 80 + r.nextDouble() * 20.0;
        byte[] payload = String.format("T:%04.2f", temperature).getBytes();
        return new MqttMessage(payload);
    }
}