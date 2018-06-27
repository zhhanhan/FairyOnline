package fairyonline.webtest.SendMail;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.testng.annotations.Test;

import java.io.FileOutputStream;
import java.util.Properties;

/**
 * JavaMail �汾: 1.6.0
 * JDK �汾: JDK 1.7 ���ϣ����룩
 */
public class Sendmail {

    public void setMail() throws Exception {
        // ������������, ���������ʼ��������Ĳ�������
        Properties prop = new Properties();                    // ��������
        prop.setProperty("mail.transport.protocol", "smtp");   // ʹ�õ�Э�飨JavaMail�淶Ҫ��
        prop.setProperty("mail.smtp.host","smtp.163.com" );   // �����˵������ SMTP ��������ַ
        prop.setProperty("mail.smtp.auth", "true");            // ��Ҫ������֤

        // PS: ĳЩ���������Ҫ�� SMTP ������Ҫʹ�� SSL ��ȫ��֤ (Ϊ����߰�ȫ��, ����֧��SSL����, Ҳ�����Լ�����),
        //     ����޷������ʼ�������, ��ϸ�鿴����̨��ӡ�� log, ����������� ������ʧ��, Ҫ�� SSL ��ȫ���ӡ� �ȴ���,
        //     ������ /* ... */ ֮���ע�ʹ���, ���� SSL ��ȫ���ӡ�
        /*
        // SMTP �������Ķ˿� (�� SSL ���ӵĶ˿�һ��Ĭ��Ϊ 25, ���Բ����, ��������� SSL ����,
        //                  ��Ҫ��Ϊ��Ӧ����� SMTP �������Ķ˿�, ����ɲ鿴��Ӧ�������İ���,
        //                  QQ�����SMTP(SLL)�˿�Ϊ465��587, ������������ȥ�鿴)
        final String smtpPort = "465";
        props.setProperty("mail.smtp.port", smtpPort);
        props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.setProperty("mail.smtp.socketFactory.fallback", "false");
        props.setProperty("mail.smtp.socketFactory.port", smtpPort);
        */

      //ʹ��JavaMail�����ʼ���5������
      //1������session
      Session session = Session.getInstance(prop);
      //����Session��debugģʽ�������Ϳ��Բ鿴��������Email������״̬
      session.setDebug(true);
      //2��ͨ��session�õ�transport����
      Transport ts = session.getTransport();
      //3�������ʼ�������
      ts.connect("smtp.163.com", "hahmine@163.com", "hahmine0125");
      //4�������ʼ�
      Message message = createAttachMail(session);
      //5�������ʼ�
      ts.sendMessage(message, message.getAllRecipients());
      ts.close();
  }

	public  MimeMessage createAttachMail(Session session) throws Exception {
        // 1. ����һ���ʼ�
        MimeMessage message = new MimeMessage(session);

      //�����ʼ��Ļ�����Ϣ
      //������
      message.setFrom(new InternetAddress("hahmine@163.com"));
      //�ռ���
      message.setRecipient(Message.RecipientType.TO, new InternetAddress("hahmine@163.com"));
      //�ʼ�����
      message.setSubject("��������ִ�����");

      //�����ʼ����ģ�Ϊ�˱����ʼ����������������⣬��Ҫʹ��charset=UTF-8ָ���ַ�����
      MimeBodyPart text = new MimeBodyPart();
      text.setContent("TestNG���Ա���", "text/html;charset=UTF-8");

     
      MimeBodyPart attach = new MimeBodyPart();
      DataHandler dh = new DataHandler(new FileDataSource("D:\\TWO_down\\Java\\workspace\\SeleniumTask\\beauty.zip"));
      attach.setDataHandler(dh);
      attach.setFileName(dh.getName());

      //���������������ݹ�ϵ
      MimeMultipart mp = new MimeMultipart();
      mp.addBodyPart(text);
      mp.addBodyPart(attach);
      mp.setSubType("mixed");

      message.setContent(mp);
      message.saveChanges();
      //��������Emailд�뵽E�̴洢
      message.writeTo(new FileOutputStream("E:\\attachMail.eml"));
      //�������ɵ��ʼ�
      return message;
      }
      @Test
      public void send(){
      Sendmail sendmail=new Sendmail();
      try {
      sendmail.setMail();
      } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      }
      try {
      sendmail.createAttachMail(null);
      } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      }
      }
    }

