JacORB
======

JacORB on INCOGNITO_2_3 was changed to support CORBA SSL and multiple endpoints.


1. JacORB SSL configuration parameters are not read properly
Check http://www.jacorb.org/cgi-bin/bugzilla/show_bug.cgi?id=820 for some bug reports.


2.  SSL clients 
http://www.jacorb.org/cgi-bin/bugzilla/show_bug.cgi?id=822
jacorb.properties cannot turn off verifying server's certficate in a client

For now we just use NullTrustManager which in the customized jacorb.jar now.


3.  org.jacorb.orb.iiop: IIOPListener
This class has been modified to support multiple interfaces.
The acceptor/address (plus SSL version) have been changed to support multiple values (Lists).
OASSLAddress and OAAddress are chanaged to allow multiple network interfaces by using "," as delimiters.

