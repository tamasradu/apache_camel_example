Simple SOA using Apache Camel
=======================================================

Prerequisite
-------------
  Install a version of Apache ActiveMQ - see http://activemq.apache.org/

Running
--------
  1. Start the WS and Server modules
  2. Using curl execute the following two commands and check the results
      * curl -i "http://localhost:18080/user/admin"
      * curl -i "http://localhost:18080/user/other_user"
