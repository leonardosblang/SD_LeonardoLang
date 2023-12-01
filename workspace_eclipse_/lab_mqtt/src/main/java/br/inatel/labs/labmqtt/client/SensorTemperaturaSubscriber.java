package br.inatel.labs.labmqtt.client;

import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;

import java.util.UUID;

public class SensorTemperaturaSubscriber {
    public static void main(String[] args) throws MqttException {
        IMqttClient subscriber = null;
        try {
            String subscriberId = UUID.randomUUID().toString();
            subscriber = new MqttClient(MyConstants.URI_BROKER, subscriberId);

            MqttConnectOptions options = new MqttConnectOptions();
            options.setAutomaticReconnect(true);
            options.setCleanSession(true);
            options.setConnectionTimeout(10);
            subscriber.connect(options);

            subscriber.subscribe(MyConstants.TOPIC_SENSOR, (topic, msg) -> {
                byte[] payload = msg.getPayload();
                System.out.println("Payload Received: " + new String(payload));
                System.out.println("Topic Received: " + topic);
            });
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (subscriber != null) {
                subscriber.disconnect();
                subscriber.close();
            }
        }
    }
}