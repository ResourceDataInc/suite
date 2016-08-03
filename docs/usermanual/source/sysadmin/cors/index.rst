.. _sysadmin.cors:

How to enable Cross-Origin Resource Sharing (CORS)
==================================================

The Same Origin Policy enforced by browsers is designed to prevent a malicious script from one server being able to access sensitive data on a different server.

But if you want your GeoServer to be usable outside of your own domain, you will want to enable Cross-Origin Resource Sharing (CORS).

Jetty
-----

.. note::

   Your copy of Jetty in OpenGeo Suite should include a file called :file:`jetty-servlets.jar`, found in your :file:`jetty/lib` directory. If not, it will need to be downloaded separately.

   Target directories:

   * Windows: :file:`C:\\Program Files (x86)\\Boundless\\OpenGeo\\jetty\\lib`
   * OS X: :file:`/Users/<user>/Library/Application Support/GeoServer/jetty/lib`

#. Edit your GeoServer :file:`web.xml` file (inside :file:`webapps/geoserver/WEB-INF`) and add the following content:

   .. code-block:: xml

      <web-app ...>
          ...
          <filter>
              <filter-name>cross-origin</filter-name>
              <filter-class>org.eclipse.jetty.servlets.CrossOriginFilter</filter-class>
          </filter>
          ...
          <filter-mapping>
              <filter-name>cross-origin</filter-name>
              <url-pattern>/*</url-pattern>
          </filter-mapping>
          ...
      </web-app>

#. Save this file.

#. Restart GeoServer.

Tomcat
------

See http://enable-cors.org/server_tomcat.html for details.
