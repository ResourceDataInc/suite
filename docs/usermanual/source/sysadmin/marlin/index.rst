.. _sysadmin.marlin:

Enabling the Marlin renderer
============================

The Marlin renderer is an open source Java rendering engine optimized for performance, based on OpenJDK's Pisces implementation. With this, vector rendering in GeoServer is much improved over the standard engine.

The Marlin renderer is is installed and configured by default for OpenGeo Suite and OpenGeo Suite Enterprise installers and packages. **You only need to manually enable the Marlin renderer if you are running OpenGeo Suite for Application Servers.**

Windows application server
--------------------------

#. Edit the :file:`setenv.bat` file, located in :file:`<TOMCAT_HOME>\\bin\\` (where :file:`<TOMCAT_HOME>` is the location where Tomcat is installed, such as :file:`C:\\Program Files\\Tomcat\\`).

   .. note:: You may need to create this file if it doesn't exist.

#. Add the following line to the bottom of the file:

   .. code-block:: console

      set "JAVA_OPTS=-Xbootclasspath/a:<WEBAPPS_PATH>\geoserver\WEB-INF\lib\marlin-0.7.3-Unsafe.jar -Dsun.java2d.renderer=org.marlin.pisces.PiscesRenderingEngine"

   replacing :file:`<WEBAPPS_PATH>` with the path to your application server's webapps directory.

   .. note:: If you already have a line that defines the ``JAVA_OPTS`` environment variable, you will want to edit it to include the options listed above.

#. Save the file.

#. Reload the application (or restart Tomcat).

Mac OS X and Linux application servers
--------------------------------------

#. Edit the :file:`setenv.sh` file, located in :file:`$TOMCAT_HOME/bin` (where :file:`$TOMCAT_HOME` is the location where Tomcat is installed, such as :file:`/opt/tomcat/`).

   .. note:: You may need to create this file if it doesn't exist.

#. Add the following line to the bottom of the file:

   .. code-block:: console

      export JAVA_OPTS="-Xbootclasspath/a:<WEBAPPS_PATH>/geoserver/WEB-INF/lib/marlin-0.7.3-Unsafe.jar -Dsun.java2d.renderer=org.marlin.pisces.PiscesRenderingEngine"

   replacing :file:`<WEBAPPS_PATH>` with the path to your application server's webapps directory.

   .. note:: If you already have a line that defines the ``JAVA_OPTS`` environment variable, you will want to edit it to include the options listed above.

#. Save the file.

#. Reload the application (or restart Tomcat).
