/* (c) 2014 Boundless, http://boundlessgeo.com
 * This code is licensed under the GPL 2.0 license.
 */
package com.boundlessgeo.geoserver.api.controllers;

import com.boundlessgeo.geoserver.json.JSONArr;
import com.boundlessgeo.geoserver.json.JSONObj;
import com.boundlessgeo.geoserver.util.RecentObjectCache;
import com.boundlessgeo.geoserver.util.RecentObjectCache.Ref;
import org.geoserver.catalog.Catalog;
import org.geoserver.catalog.LayerGroupInfo;
import org.geoserver.catalog.LayerInfo;
import org.geoserver.catalog.WorkspaceInfo;
import org.geoserver.config.GeoServer;
import org.geoserver.config.ServiceInfo;
import org.geoserver.config.SettingsInfo;
import org.geotools.util.Version;
import org.opengis.filter.Filter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Summarizes information about the GeoServer instance.
 */
@Controller
@RequestMapping("/api/serverInfo")
public class ServerInfoController extends ApiController {

    @Autowired
    public ServerInfoController(GeoServer geoServer, RecentObjectCache recent) {
        super(geoServer, recent);
    }

    @RequestMapping(method= RequestMethod.GET)
    public @ResponseBody
    JSONObj get() {
        JSONObj obj = new JSONObj();
        obj.toObject();

        SettingsInfo settings = geoServer.getGlobal().getSettings();
        obj.putObject("service")
           .put("title", settings.getTitle());

        JSONObj services = obj.putObject("services");
        for (ServiceInfo service : geoServer.getServices()) {
            JSONArr versions = services.putObject(service.getName())
               .put("title", service.getTitle())
               .putArray("versions");

            for (Version ver : service.getVersions()) {
                versions.add(ver.toString());
            }
        }

        Catalog cat = geoServer.getCatalog();
        obj.put("workspaces", cat.count(WorkspaceInfo.class, Filter.INCLUDE))
           .put("layers", cat.count(LayerInfo.class, Filter.INCLUDE))
           .put("maps", cat.count(LayerGroupInfo.class, Filter.INCLUDE));

        JSONObj cache = obj.putObject("recent");

        JSONArr recentMaps = cache.putArray("maps");
        for (Ref ref : recent.list(LayerGroupInfo.class)) {
            IO.ref(recentMaps.addObject(), ref);
        }

        return obj;
    }
}
