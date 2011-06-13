var map;
$(document).ready(function() {
	/**
	 * Map initialization
	 */
	geocoder = new google.maps.Geocoder();
	var latlng = new google.maps.LatLng(-35.422753, -71.657266);
	var myOptions = {
		zoom: 12,
		center: latlng,
		mapTypeId: google.maps.MapTypeId.ROADMAP,
		mapTypeControl: true,
		navigationControl: true,
		navigationControlOptions: {
			style: google.maps.NavigationControlStyle.ZOOM_PAN,
			position: google.maps.ControlPosition.LEFT
		},
	}
	map = new google.maps.Map(document.getElementById('mapCanvas'), myOptions);
	
	function OSMMapType() {}
	OSMMapType.prototype = {
		tileSize: new google.maps.Size(256,256),
		maxZoom: 18,
		getTile: function(coord, zoom, ownerDocument) {
			var tileUrl = 'http://tile.openstreetmap.org/' + zoom + '/' + coord.x + '/' + coord.y + '.png';

			var tile = ownerDocument.createElement('img');
			tile.width = this.tileSize.width;
			tile.height = this.tileSize.height;
			tile.src = tileUrl;

			return tile;
		}
	};
	map.mapTypes.set('osm', new OSMMapType());
	map.setMapTypeId('osm');
});