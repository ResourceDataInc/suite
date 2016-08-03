.. _sysadmin.libjpeg-turbo:

Working with libjpeg-turbo
==========================

The libjpeg-turbo extension provides a significant performance enhancement for JPEG encoding in GeoServer WMS output (up to 40% faster than with no native libraries, equal or greater performance than with Native ImageIO).

**This is installed and configured by default in OpenGeo Suite Enterprise installers.** For OpenGeo Suite for Application Servers, the GeoServer extension is installed by default, but the native libraries will need to be manually installed.

Installation
------------

To perform the installation of the libjpeg-turbo native libraries:

#. Download the `latest stable package for your platform <http://sourceforge.net/projects/libjpeg-turbo/files/>`_. Make sure to match the architecture (32 or 64 bit).

   .. warning:: For Windows, make sure that you download a Visual C++ binary (filename that includes ``-vc.exe`` or ``-vc64.exe``). The default download uses the GCC binaries, which are not sufficient.

#. Perform the installation.

#. *(Windows only)* Make sure that the location where the DLL files were installed is added to your system's PATH environment variable.

#. *(Linux only)* Make sure that the location where the library files were installed is added to your system's LD_LIBRARY_PATH environment variable for the Java process. This may happen automatically.

#. Restart GeoServer.

.. note:: For more information, please see the `GeoServer documentation <../../../geoserver/extensions/libjpeg-turbo/>`_ or the `libjpeg-turbo website <http://libjpeg-turbo.virtualgl.org/>`_.

Verification
------------

The libjpeg-turbo functionality doesn't contain a visual verification through the GeoServer UI. Instead, it will be written into the GeoServer logs::

  WARN [turbojpeg.TurboJPEGMapResponse] - The turbo jpeg encoder is available for usage

If you see a message like the above, then libjpeg-turbo was installed successfully.
