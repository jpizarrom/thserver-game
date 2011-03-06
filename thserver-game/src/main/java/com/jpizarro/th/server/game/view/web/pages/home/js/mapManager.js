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
});