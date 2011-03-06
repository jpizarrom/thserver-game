function Hint(id, marker) {
	this.id = id;
	this.marker = marker;
}

function Game(maxTeams, maxUserPerTeam, latitude, longitude, city) {
	this.maxTeams = maxTeams;
	this.maxUserPerTeam = maxUserPerTeam;
	this.latitude = latitude;
	this.longitude = longitude;
	this.city = city;
	this.items = new Array();
	
	this.getItems = function() {
		return jQuery.grep(this.items, function(n, i) {
			return n != null;
		})
	}
}
