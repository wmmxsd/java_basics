package com.wmm.basics.network;

import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.Date;

/**
 * @author wangmingming160328
 * @Description
 * @date @2020/6/3 16:25
 */
public class UdpClient {
    public void send(String ip, int port, String msg) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket();
        byte[] bytes = msg.getBytes(StandardCharsets.UTF_8);
        DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length, new InetSocketAddress(ip, port));
        datagramSocket.send(datagramPacket);
        datagramSocket.close();
    }

    public static void main(String[] args) {
        System.out.println("UDP发送数据：begin");
        /*String msg0 ="war|{发现病毒文件}|{cems_log_device_virusauditlog}|192.168.118.109|2019-05-07 12:25:06|{终端主机名称}|192.168.118.122|08-00-27-57-D4-40|C:/|病毒类型|报警";
        String msg1 ="war|{违规外联}|{cems_log_device_illegalconnectlog}|192.168.118.109|2019-05-07 12:25:06|{终端主机名称}|192.168.118.122|08-00-27-57-D4-40|同时连接内外网|报警";
        String msg2 ="war|{弱口令}|{cems_log_device_userpwdlog}|192.168.118.109|2019-05-07 12:25:06|{终端主机名称}|192.168.118.122|08-00-27-57-D4-40|admin|空密码|账户admin存在空密码|告警";
        String msg3 ="war|{恶意进程}|{cems_log_device_processmonitorlog}|192.168.118.109|2019-05-07 12:25:06|{终端主机名称}|192.168.118.122|08-00-27-57-D4-40|qq.exe|已禁止运行进程QQ.exe|告警";
        String msg4 ="war|{移动存储审计}|{cems_log_device_udiskoperatelog}|192.168.118.109|2019-05-07 12:25:06|{终端主机名称}|192.168.118.122|08-00-27-57-D4-40|文件拷贝审计:H:\\激活2008.rar|告警";
        String msg5 ="war|{资源异常}|{cems_log_device_resmonitorlog}|192.168.118.109|2019-05-07 12:25:06|{终端主机名称}|192.168.118.122|08-00-27-57-D4-40|CPU|5分钟|CPU使用率出现异常，当前使用率96%，超过阈值|告警";
        String msg6 ="war|{进程启停}|{cems_log_device_processstatuslog}|192.168.118.109|2019-05-07 12:25:06|{终端主机名称}|192.168.118.122|08-00-27-57-D4-40|qq.exe|进程qq.exe停止|告警";
        String msg7 ="war|{上网访问审计}|{cems_log_device_webaccesslog}|192.168.118.109|2019-05-07 12:25:06|{终端主机名称}|192.168.118.122|08-00-27-57-D4-40|https://www.baidu.com|80|访问了违规的URL|告警";*/
        String msg = "{\"minCode\":\"00016078\",\"auditTableName\":\"cems_log_device_portcheckchangedlog\",\"logInfo\":[{\"id\":\"b2aca9c757ff468a88ed572743801eb8\",\"devonlyid\":\"3cb228c57c2b32d6d9873bc4c2c28102\",\"ip\":\"68.62.232.144\",\"mac\":\"28-6E-D4-89-7F-98\",\"name\":\"WIN7-001\",\"orgid\":\"7f2140e2cef849b68a7f5429b8efbdde\",\"orgname\":\"科技信息处\",\"osloginaccount\":\"sansuo01\",\"clienttime\":\"2020-05-06 17:03:57\",\"reporttime\":\"2020-05-06 17:06:09\",\"policyid\":\"00f920a4afa742388bdef51951122f4f\",\"devorgcodeui\":\"01.02\",\"devorgpath\":\"深圳市公安局|科技信息处\",\"holdname\":\"罗工0427\",\"iptype\":\"0\",\"cyrip\":\"68.62.232.144\",\"curmac\":\"28-6E-D4-89-7F-98\",\"localport\":\"3000\",\"localip\":\"0.0.0.0\",\"remoteip\":\"0.0.0.0\",\"remoteport\":\"0\",\"protocol\":\"TCP\",\"status\":\"CLOSED\",\"netstate\":\"0\",\"policyname\":\"导入-端口检查策略\"}]}";
        UdpClient udpClient = new UdpClient();
        try {
            System.out.println(new Date(System.currentTimeMillis()).toString());
            int i = 0;
            int count = 100000;
            while (i < count) {
                udpClient.send("192.168.119.25", 514, msg);
                i++;
            }
            double size = msg.getBytes(StandardCharsets.UTF_8).length;
            System.out.println(size);
            System.out.println(count * size);
            System.out.println("UDP发送数据：end");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
