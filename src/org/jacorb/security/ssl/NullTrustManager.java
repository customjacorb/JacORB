package org.jacorb.security.ssl;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.X509TrustManager;

//NEW FILE: This is added only for tempoary for bug
//http://www.jacorb.org/cgi-bin/bugzilla/show_bug.cgi?id=822
public class NullTrustManager implements X509TrustManager {

	public NullTrustManager()
	{
	
	}
	
	
	public void checkClientTrusted(X509Certificate[] arg0, String arg1)
			throws CertificateException {
		// TODO Auto-generated method stub
	}

	public void checkServerTrusted(X509Certificate[] arg0, String arg1)
			throws CertificateException {
		// TODO Auto-generated method stub
	}

	public X509Certificate[] getAcceptedIssuers() {
		// TODO Auto-generated method stub
		return null;
	}


}
