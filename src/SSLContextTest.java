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
         * SSLContext.getProtocol(): ���ص�ǰSSLContext�����Э������
         SSLContext.init():  ��ʼ����ǰSSLContext���� ��������������Ϊnull�� ���JDK�ĵ���
         SSLEngine.getSupportedProtocols()�ȼ����������Է���Щ Engine��֧��/�����õ�Э�顢֧��/�����õļ����׼�
         */
        // ��ȡһ��SSLContextʵ��
        SSLContext s= SSLContext.getInstance("SSL");
        // ��ʼ��SSLContextʵ��
        s.init(null,new TrustManager[]{x509m},new java.security.SecureRandom());
        // ��ӡ���SSLContextʵ��ʹ�õ�Э��
        System.out.println("ȱʡ��ȫ�׽���ʹ�õ�Э�飺 "+s.getProtocol());
        // ��ȡSSLContextʵ����ص�SSLEngine
        SSLEngine e=s.createSSLEngine();
        System.out.println("֧�ֵ�Э�飺 "+ Arrays.asList(e.getSupportedProtocols()));
        System.out.println("���õ�Э�飺 "+Arrays.asList(e.getEnabledProtocols()));
        System.out.println("֧�ֵļ����׼��� "+Arrays.asList(e.getSupportedCipherSuites()));
        System.out.println("���õ��׼��� "+Arrays.asList(e.getEnabledCipherSuites()));
    }
}
