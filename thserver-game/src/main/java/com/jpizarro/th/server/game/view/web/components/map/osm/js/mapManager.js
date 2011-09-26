var map;
$(document).ready(function() {
	/**
	 * Map initialization
	 */
    map = new OpenLayers.Map("mapCanvas");


    var mapnik = new OpenLayers.Layer.OSM();
    map.addLayer(mapnik);

//    map.addControl(new OpenLayers.Control.LayerSwitcher());
    map.setCenter(new OpenLayers.LonLat(-71.657266, -35.422753) // Center of the map
    	.transform(
    		new OpenLayers.Projection("EPSG:4326"), // transform from WGS 1984
    		new OpenLayers.Projection("EPSG:900913") // to Spherical Mercator Projection
	    ), 13 // Zoom level
    );


});