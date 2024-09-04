package net.hwyz.iov.cloud.tsp.vagw.config;

import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;

/**
 * MQTT消息回调
 *
 * @author hwyz_leo
 */
@Slf4j
public class MqttProviderCallBack implements MqttCallback {

    /**
     * 客户端断开连接的回调
     */
    @Override
    public void connectionLost(Throwable throwable) {
        logger.error("出现异常[{}]与服务器断开连接", throwable.getMessage(), throwable);
    }

    /**
     * 消息到达的回调
     */
    @Override
    public void messageArrived(String topic, MqttMessage message) throws Exception {
        logger.debug("接收消息主题 : {}", topic);
        logger.debug("接收消息Qos : {}", message.getQos());
        logger.debug("接收消息内容 : {}", new String(message.getPayload()));
        logger.debug("接收消息retained : {}", message.isRetained());
    }

    /**
     * 消息发布成功的回调
     */
    @Override
    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
        logger.debug("消息发布成功");
    }
}
