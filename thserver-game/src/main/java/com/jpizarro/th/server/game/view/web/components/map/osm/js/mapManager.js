var map;
var markers;
$(document).ready(function() {
	/**
	 * Map initialization
	 */
    map = new OpenLayers.Map("mapCanvas");


    var mapnik = new OpenLayers.Layer.OSM();
    map.addLayer(mapnik);
    
    markers = new OpenLayers.Layer.Markers( "Markers" );
    map.addLayer(markers);
    
    var size = new OpenLayers.Size(21,25);
    var offset = new OpenLayers.Pixel(-(size.w/2), -size.h);
    var icon = new OpenLayers.Icon('http://www.openlayers.org/dev/img/marker.png',size,offset);
    markers.addMarker(new OpenLayers.Marker(new OpenLayers.LonLat(0,0),icon));

//    map.addControl(new OpenLayers.Control.LayerSwitcher());
//    map.setCenter(new OpenLayers.LonLat(-71.657266, -35.422753));
    map.setCenter(new OpenLayers.LonLat(-71.657266, -35.422753) // Center of the map
    	.transform(
    		new OpenLayers.Projection("EPSG:4326"), // transform from WGS 1984
    		new OpenLayers.Projection("EPSG:900913") // to Spherical Mercator Projection
	    ), 13 // Zoom level
    );
//    map.zoomToMaxExtent();


});