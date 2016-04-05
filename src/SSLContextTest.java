import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Arrays;

/**
 * Package_name PACKAGE_NAME
 * Project_name JavaStudy
 * Created by lenovo on 2015/12/12 15:30
 */
public class SSLContextTest {
    public static void main(String args[])throws Exception{
        X509TrustManager x509m=new X509TrustManager() {
            @Override
            public void checkClientTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

            }

            @Override
            public void checkServerTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

            }

            @Override
            public X509Certificate[] getAcceptedIssuers() {
                return new X509Certificate[0];
            }
        };
        /**
         * SSLContext.getProtocol(): 返回当前SSLContext对象的协议名称
         SSLContext.init():  初始化当前SSLContext对象。 三个参数均可以为null。 详见JDK文档。
         SSLEngine.getSupportedProtocols()等几个方法可以返回些 Engine上支持/已启用的协议、支持/已启用的加密套件
         */
        // 获取一个SSLContext实例
        SSLContext s= SSLContext.getInstance("SSL");
        // 初始化SSLContext实例
        s.init(null,new TrustManager[]{x509m},new java.security.SecureRandom());
        // 打印这个SSLContext实例使用的协议
        System.out.println("缺省安全套接字使用的协议： "+s.getProtocol());
        // 获取SSLContext实例相关的SSLEngine
        SSLEngine e=s.createSSLEngine();
        System.out.println("支持的协议： "+ Arrays.asList(e.getSupportedProtocols()));
        System.out.println("启用的协议： "+Arrays.asList(e.getEnabledProtocols()));
        System.out.println("支持的加密套件： "+Arrays.asList(e.getSupportedCipherSuites()));
        System.out.println("启用的套件： "+Arrays.asList(e.getEnabledCipherSuites()));
    }
}
