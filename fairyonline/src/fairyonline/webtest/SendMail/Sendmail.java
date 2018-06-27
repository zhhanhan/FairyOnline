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
 * JavaMail 版本: 1.6.0
 * JDK 版本: JDK 1.7 以上（必须）
 */
public class Sendmail {

    public void setMail() throws Exception {
        // 创建参数配置, 用于连接邮件服务器的参数配置
        Properties prop = new Properties();                    // 参数配置
        prop.setProperty("mail.transport.protocol", "smtp");   // 使用的协议（JavaMail规范要求）
        prop.setProperty("mail.smtp.host","smtp.163.com" );   // 发件人的邮箱的 SMTP 服务器地址
        prop.setProperty("mail.smtp.auth", "true");            // 需要请求认证

        // PS: 某些邮箱服务器要求 SMTP 连接需要使用 SSL 安全认证 (为了提高安全性, 邮箱支持SSL连接, 也可以自己开启),
        //     如果无法连接邮件服务器, 仔细查看控制台打印的 log, 如果有有类似 “连接失败, 要求 SSL 安全连接” 等错误,
        //     打开下面 /* ... */ 之间的注释代码, 开启 SSL 安全连接。
        /*
        // SMTP 服务器的端口 (非 SSL 连接的端口一般默认为 25, 可以不添加, 如果开启了 SSL 连接,
        //                  需要改为对应邮箱的 SMTP 服务器的端口, 具体可查看对应邮箱服务的帮助,
        //                  QQ邮箱的SMTP(SLL)端口为465或587, 其他邮箱自行去查看)
        final String smtpPort = "465";
        props.setProperty("mail.smtp.port", smtpPort);
        props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.setProperty("mail.smtp.socketFactory.fallback", "false");
        props.setProperty("mail.smtp.socketFactory.port", smtpPort);
        */

      //使用JavaMail发送邮件的5个步骤
      //1、创建session
      Session session = Session.getInstance(prop);
      //开启Session的debug模式，这样就可以查看到程序发送Email的运行状态
      session.setDebug(true);
      //2、通过session得到transport对象
      Transport ts = session.getTransport();
      //3、连上邮件服务器
      ts.connect("smtp.163.com", "hahmine@163.com", "hahmine0125");
      //4、创建邮件
      Message message = createAttachMail(session);
      //5、发送邮件
      ts.sendMessage(message, message.getAllRecipients());
      ts.close();
  }

	public  MimeMessage createAttachMail(Session session) throws Exception {
        // 1. 创建一封邮件
        MimeMessage message = new MimeMessage(session);

      //设置邮件的基本信息
      //发件人
      message.setFrom(new InternetAddress("hahmine@163.com"));
      //收件人
      message.setRecipient(Message.RecipientType.TO, new InternetAddress("hahmine@163.com"));
      //邮件标题
      message.setSubject("测试用例执行情况");

      //创建邮件正文，为了避免邮件正文中文乱码问题，需要使用charset=UTF-8指明字符编码
      MimeBodyPart text = new MimeBodyPart();
      text.setContent("TestNG测试报告", "text/html;charset=UTF-8");

     
      MimeBodyPart attach = new MimeBodyPart();
      DataHandler dh = new DataHandler(new FileDataSource("D:\\TWO_down\\Java\\workspace\\SeleniumTask\\beauty.zip"));
      attach.setDataHandler(dh);
      attach.setFileName(dh.getName());

      //创建容器描述数据关系
      MimeMultipart mp = new MimeMultipart();
      mp.addBodyPart(text);
      mp.addBodyPart(attach);
      mp.setSubType("mixed");

      message.setContent(mp);
      message.saveChanges();
      //将创建的Email写入到E盘存储
      message.writeTo(new FileOutputStream("E:\\attachMail.eml"));
      //返回生成的邮件
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

