.. _whatsnew:

What's new in |version|
=======================

**This version is a maintenance release** that contains dozens of bug fixes and performance improvements.

In addition, OpenGeo Suite |version| includes the following new features:

**Vector tiles output format**

:ref:`Vector tiles <dataadmin.vectortiles>` are a way to deliver geographic data to a browser or other client application. Vector tiles are similar to raster tiles but the data is actually a vector representation of the features in the tile. Vector tiles improve the performance of maps while offering full client-side design flexibility. 

**NetCDF support**

`Network Common Data Form (NetCDF) <http://www.unidata.ucar.edu/software/netcdf/>`_ is a format used to store array-oriented scientific data, such as meteorologic data. This version includes support for reading data in GRIB 1, GRIB 2, NetCDF 3 and 4 with CF (Climate and Forecast) formats.

**AWS S3 tile cache for GeoWebCache**

This new tile store option allows for storing tiles in an Amazon Web Services (AWS) Simple Storage Service (S3) bucket, retrieved using a TMS-like URL structure.

.. note:: For more information, please see the `GeoWebCache documentation <http://suite.opengeo.org/docs/latest/geowebcache/configuration/storage.html>`_.

**Improved rendering performance**

The Marlin renderer is an open source Java rendering engine optimized for performance, based on OpenJDK's Pisces implementation. With this, vector rendering is much improved over the standard engine.

In addition, OpenGeo Suite Enterprise installs include :ref:`libjpeg-turbo <sysadmin.libjpeg-turbo>`, which provides a significant performance enhancement for JPEG encoding in GeoServer WMS output (up to 40% faster than with no native libraries, equal or greater performance than with Native ImageIO).

**GeoServer 2.8**

The most recent branch of GeoServer includes improvements such as Z-order rendering, contrast enhancement, and curve support.

.. note:: For more information, please see the `GeoServer 2.8 release notes <http://blog.geoserver.org/2015/09/30/geoserver-2-8-0-released/>`_.

**Components included**

* GeoServer 2.8
* GeoWebCache 1.8
* PostgreSQL 9.3
* PostGIS 2.1.7
* OpenLayers 3.7.0

